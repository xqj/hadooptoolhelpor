using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Thrift.Transport;
using Thrift.Protocol;

namespace DataConverionTool
{
    public class MahoutService : IMahoutInterface, IDisposable
    {
        private MahoutThriftClient mahoutClient;
        private TBufferedTransport transport;
        private HiveService.HiveService _daoInstance;
        public MahoutService()
        {
            var socket = new TSocket(MahoutConfigure.Instance.GetDefaultHost(), MahoutConfigure.Instance.GetDefaultPort());
            transport = new TBufferedTransport(socket);          
            var proto = new TBinaryProtocol(transport);
            mahoutClient = new MahoutThriftClient(proto);
            _daoInstance = new HiveService.HiveService();
            transport.Open();
        }

        public string ImportDataInMahout(string hiveTableName, string mahoutTable, List<string> columnNames, string hivePrimaryKey, List<string> timeColumnNames = null, List<string> convertColumnNames = null, bool createTable = false)
        {
            StringBuilder message = new StringBuilder();
            StringBuilder columns = new StringBuilder();
            StringBuilder contionSql = new StringBuilder();
            //创建转换字段的临时表
            if (convertColumnNames != null)
            {
                int i = 1;
                string tempTable;
                foreach (var column in convertColumnNames)
                {
                    tempTable = hiveTableName + "_" + column + " b" + i.ToString();
                    CreateMahoutTempTable(column, hiveTableName, hivePrimaryKey);
                    columnNames.Remove(column);
                    columns.Append("b" + i.ToString() + ".id as " + column + ",");
                    //创建连接条件
                    contionSql.Append(" JOIN " + tempTable);
                    contionSql.Append(" ON ht." + column + "=b" + i.ToString() + "." + column);

                    i++;
                }

            }
            columnNames.ForEach(a =>
            {
                columns.Append("ht." + a + ",");
            });
            if (timeColumnNames != null)
            {
                timeColumnNames.ForEach(a =>
                {
                    //将日期类型转换为以秒和以小时为单位的正数，以1970-1-1为起点
                    columns.Append("unix_timestamp(ht." + a + ") as " + a + "sec,");
                    columns.Append("unix_timestamp(ht." + a + ")/3600 as " + a + "hour,");
                });
            }

            if (createTable)
                CreateMahoutTable(mahoutTable, columnNames, timeColumnNames, convertColumnNames);
            StringBuilder sql = new StringBuilder();
            sql.Append("insert overwrite table " + mahoutTable);
            sql.Append(" select " + columns.ToString().TrimEnd(',') + " from " + hiveTableName + " ht");
            sql.Append(contionSql.ToString());
            LogService.LogService.Instance.Logger("执行mahout数据导入:" + sql.ToString(), "mahout");
            _daoInstance.Execute(sql.ToString()); 
            mahoutClient.ImportDataInMahout(mahoutTable, mahoutTable);
            //删除转换字段的临时表
            if (convertColumnNames != null)
            {
                sql.Clear();
                sql.Append("drop table $table");
                foreach (var column in convertColumnNames)
                {
                    _daoInstance.DdlTable(sql.ToString().Replace("$table", hiveTableName + "_" + column));
                }
            }
            return message.ToString();
        }

        private void CreateMahoutTempTable(string column, string hiveTableName, string hivePrimaryKey = "id")
        {
            string tempTable = hiveTableName + "_" + column;
            string ddlSql = " create table " + tempTable + " (id int," + column + " string)";
            _daoInstance.DdlTable(ddlSql);
            ddlSql = " create table temp_" + tempTable + " (" + column + " string)";
            _daoInstance.DdlTable(ddlSql);
            StringBuilder sql = new StringBuilder();
            sql.Append("insert overwrite table temp_" + tempTable);
            sql.Append(" select distinct " + column + " from " + hiveTableName);
            _daoInstance.Execute(sql.ToString());
            sql.Clear();
            sql.Append("add jar /home/hadoopuser/hivefuntiontool.jar");
            _daoInstance.Execute(sql.ToString());
            sql.Clear();
            sql.Append("create temporary function getidentity as 'HiveUntilTool.HiveTool'");
            _daoInstance.Execute(sql.ToString());
            sql.Clear();
            sql.Append("insert overwrite table " + tempTable);
            sql.Append(" select getidentity() as id," + column);
            sql.Append(" from temp_" + tempTable);
            _daoInstance.Execute(sql.ToString());
            sql.Clear();
            ddlSql="drop table temp_" + tempTable;
            _daoInstance.DdlTable(ddlSql);
            LogService.LogService.Instance.Logger("创建mahout数据导入临时字段表:" + sql.ToString(), "mahout");
        }

        private void CreateMahoutTable(string mahoutTable, List<string> columnNames, List<string> timeColumnNames = null, List<string> convertColumnNames = null)
        {
            string ddlSql = " create table $table ($column) row format delimited fields terminated by ' '";
            StringBuilder columns = new StringBuilder();
            columnNames.ForEach(a =>
            {
                columns.Append(a.ToString() + " string,");
            });
            if (timeColumnNames != null)
            {
                timeColumnNames.ForEach(a =>
                {
                    columns.Append(a.ToString() + "sec int,");
                    columns.Append(a.ToString() + "hour int,");
                });
            }
            if (convertColumnNames != null)
            {
                convertColumnNames.ForEach(a =>
                {
                    columns.Append(a.ToString() + " bigint,");                   
                });
            }
            ddlSql = ddlSql.Replace("$column", columns.ToString().TrimEnd(','));
            ddlSql = ddlSql.Replace("$table", mahoutTable);
            _daoInstance.DdlTable(ddlSql);
            LogService.LogService.Instance.Logger("创建mahout数据表:" + ddlSql.ToString(), "mahout");
        }
        public string ExportDataOutMahout(string hiveTableName, string mahoutTable)
        {
            StringBuilder message = new StringBuilder();
            return message.ToString();
        }

        public void Dispose()
        {
            transport.Close();
            transport.Dispose();
        }


        public string ExtractVectorField(string mahoutTableName, string mahoutTargetTableName, string extractXColumn, string extractYColumn, bool createTable = false)
        {
            string ddlSql = " create table " + mahoutTargetTableName + " ($column) row format delimited fields terminated by ' '";
            StringBuilder columns = new StringBuilder();
            StringBuilder message = new StringBuilder();          
            columns.Append(extractXColumn+" string,");
            columns.Append(extractYColumn + " string");
            ddlSql = ddlSql.Replace("$column", columns.ToString());
            _daoInstance.DdlTable(ddlSql);
            StringBuilder sql = new StringBuilder();
            sql.Append("insert overwrite table " + mahoutTargetTableName);
            sql.Append(" select " + mahoutTableName + "," + extractXColumn + "," + extractYColumn);
            sql.Append(" from" + mahoutTableName);
            _daoInstance.Execute(sql.ToString());
            return message.ToString();          
        }
    }
}
