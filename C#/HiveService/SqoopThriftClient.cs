using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace HiveService
{
    public class SqoopThriftClient : SqoopThrift.Iface
    {
        private Thrift.Protocol.TBinaryProtocol _proto;
        private SqoopThrift.Client client; 
        public SqoopThriftClient(Thrift.Protocol.TBinaryProtocol proto)
        {
             this._proto = proto;
            client = new SqoopThrift.Client(_proto); 
        }


        public string ImportDataInHive(string host, string database, string userName, string password, string tableName, string hiveTaleb, string keyfield)
        {
            return client.ImportDataInHive(host, database, userName, password, tableName, hiveTaleb, keyfield);
        }

        public string ImportDataInHiveByWhere(string host, string database, string userName, string password, string tableName, string hiveTaleb, string where, List<string> columnNames, string keyfield)
        {
            return client.ImportDataInHiveByWhere(host, database, userName, password, tableName, hiveTaleb, where, columnNames, keyfield);
        }

        public string ExportData(string host, string database, string userName, string password, string tableName, string hiveTaleb)
        {
            return client.ExportData(host, database, userName, password, tableName, hiveTaleb);
        }

        public string ExportDataUpdate(string host, string database, string userName, string password, string tableName, string hiveTaleb, string keyfield)
        {
            return client.ExportDataUpdate(host, database, userName, password, tableName, hiveTaleb, keyfield);
        }

      


        public string CreateTable(string host, string database, string userName, string password, string tableName, string hiveTaleb)
        {
            return client.CreateTable(host, database, userName, password, tableName, hiveTaleb);
        }
    }
}
