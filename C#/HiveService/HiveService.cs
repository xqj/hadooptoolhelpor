using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Apache.Hadoop.Hive;
using Thrift.Transport;
using Thrift.Protocol;
using System.Text.RegularExpressions;

namespace HiveService
{
    public class HiveService
        : IHiveProvider,IDisposable
    {
        private ThriftHive.Client client;
        private TBufferedTransport transport;
        private SqoopSqlServerService sqoopSqlServer;
        public HiveService()
        {
            var socket = new TSocket(HiveConfigure.Instance.GetDefaultHost(), HiveConfigure.Instance.GetDefaultPort());
            transport = new TBufferedTransport(socket);
            var proto = new TBinaryProtocol(transport);
            client = new ThriftHive.Client(proto);
            transport.Open();
        }
        public HiveService(string serverHostName)
        {
            var socket = new TSocket(HiveConfigure.Instance.GetHostServer(serverHostName), HiveConfigure.Instance.GetHostPort(serverHostName));
            transport = new TBufferedTransport(socket);
            var proto = new TBinaryProtocol(transport);
            client = new ThriftHive.Client(proto);
        }
        public HiveService(string serverHostName, string sqoopServerHostName, string sqoopSqlServerHost, string sqoopDatabaseName, string sqoopUserName, string sqoopPassword)
        {
            var socket = new TSocket(HiveConfigure.Instance.GetHostServer(serverHostName), HiveConfigure.Instance.GetHostPort(serverHostName));
            transport = new TBufferedTransport(socket);
            var proto = new TBinaryProtocol(transport);
            client = new ThriftHive.Client(proto);
            sqoopSqlServer = new SqoopSqlServerService(sqoopServerHostName, sqoopSqlServerHost, sqoopDatabaseName, sqoopUserName, sqoopPassword);
        }
        public void SetSqoop(string sqlServerHost, string databaseName, string userName, string password)
        {
            if (sqoopSqlServer == null)
                sqoopSqlServer = new SqoopSqlServerService(sqlServerHost, databaseName, userName, password);
        }
        public List<T> SelectList<T>(string sql) where T : new()
        {
            Dictionary<int, string> columns = GetColumnsBySql(sql);
            List<string> result = null;
            try
            {
                transport.Open();
                client.execute(sql);
                result = client.fetchAll();
                transport.Close();
            }
            catch (Exception ex)
            {
                transport.Close();
                Console.WriteLine(ex.Message);
                LogService.LogService.Instance.Logger(ex.Message, "hive");
            }
            List<T> list = ClassReflection.GetList<T>(columns, result, ',');
            return list;
        }
        public T select<T>(string sql) where T : new()
        {
            Dictionary<int, string> columns = GetColumnsBySql(sql);
            string data = null;
            try
            {
                transport.Open();
                client.execute(sql);
                data = client.fetchOne();
                transport.Close();
            }
            catch (Exception ex)
            {
                transport.Close();
                Console.WriteLine(ex.Message);
                LogService.LogService.Instance.Logger(ex.Message, "hive");
            }
            T result = ClassReflection.Get<T>(columns, data, ',');
            return result;

        }
        private Dictionary<int, string> GetColumnsBySql(string sql)
        {
            var matche = Regex.Match(sql, @"select (\S)* from", RegexOptions.IgnoreCase);
            var temps = matche.Value.ToLower().Replace("select", "").Replace("from", "").Trim().Split(',');
            Dictionary<int, string> dic = new Dictionary<int, string>();
            for (int i = 0; i < temps.Length; i++)
            {
                dic.Add(i, temps[i]);
            }
            return dic;
        }
        public List<string> SelectAllColunms(string sql)
        {
            List<string> result = null;
            try
            {
                transport.Open();
                client.execute(sql);
                result = client.fetchAll();
                transport.Close();
            }
            catch (Exception ex)
            {
                transport.Close();
                Console.WriteLine(ex.Message);
                LogService.LogService.Instance.Logger(ex.Message, "hive");
            }
            return result;
        }
        public void Execute(string sql)
        {

            try
            {
                if(!transport.IsOpen)
                transport.Open();
                client.execute(sql);                
                //transport.Close();
            }
            catch (Exception ex)
            {
                transport.Close();
                Console.WriteLine(ex.Message);
                LogService.LogService.Instance.Logger(ex.Message + "\n", "hive");
            }

        }
        public string InsertTo(string tableName, string keyfield)
        {
            return sqoopSqlServer.ImportData(tableName, null, keyfield);
        }

        public string AppendTo(string tableName, string[] columnNames, string whereSql, string keyfield, string hiveTableName = null)
        {
            return sqoopSqlServer.ImportData(tableName, columnNames, whereSql, hiveTableName, keyfield);
        }
        public void DdlTable(string sql)
        {
            try
            {
              
              client.execute(sql);
              //transport.Close();
            }
            catch (Exception ex)
            {
                transport.Close();
                Console.WriteLine(ex.Message);
                LogService.LogService.Instance.Logger(ex.Message + "\n", "hive");
            }
        }

        public string ExportData(string tableName, string hiveTaleb)
        {
            return sqoopSqlServer.ExportData(tableName, hiveTaleb.ToLower());//dfs中路径全部为小写字符
        }

        public string ExportDataUpdate(string tableName, string hiveTaleb, string keyfield)
        {
            return sqoopSqlServer.ExportDataUpdate(tableName, hiveTaleb, keyfield);
        }


        public string CreateTable(string tableName, string hiveTable = null)
        {
            return sqoopSqlServer.CreateTable(tableName);
        }




        public void Dispose()
        {
            transport = null;
            sqoopSqlServer = null;
        }
    }
}
