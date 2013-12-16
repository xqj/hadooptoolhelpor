using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Thrift.Transport;
using Thrift.Protocol;

namespace HiveService
{
    public class SqoopSqlServerService : ISqoopInterface,IDisposable
    {
        private string _host;
        private string _database;
        private string _userName;
        private string _password;
        private SqoopThriftClient sqoopClient;
        private TBufferedTransport transport;
        public SqoopSqlServerService(string sqlServerHost, string databaseName, string userName, string password)
        {
            _host = sqlServerHost;
            _database = databaseName;
            _userName = userName;
            _password = password;

            var socket = new TSocket(SqoopConfigure.Instance.GetDefaultHost(), SqoopConfigure.Instance.GetDefaultPort());
            transport = new TBufferedTransport(socket);
            var proto = new TBinaryProtocol(transport);
            sqoopClient = new SqoopThriftClient(proto);

        }

        public SqoopSqlServerService(string sqoopServerHostName, string sqlServerHost, string databaseName, string userName, string password)
        {
            _host = sqlServerHost;
            _database = databaseName;
            _userName = userName;
            _password = password;

            var socket = new TSocket(SqoopConfigure.Instance.GetHostServer(sqoopServerHostName), SqoopConfigure.Instance.GetHostPort(sqoopServerHostName));
            transport = new TBufferedTransport(socket);
            var proto = new TBinaryProtocol(transport);
            sqoopClient = new SqoopThriftClient(proto);
        }

        public string ImportData(string tableName, string hiveTaleb, string keyfield)
        {
            var feedback = "";
            try
            {
                if (!transport.IsOpen)
                    transport.Open();
                if (string.IsNullOrEmpty(hiveTaleb))
                    feedback = sqoopClient.ImportDataInHive(_host, _database, _userName, _password, tableName, tableName, keyfield);
                else
                    feedback = sqoopClient.ImportDataInHive(_host, _database, _userName, _password, tableName, hiveTaleb, keyfield);
                transport.Close();
            }
            catch (Exception ex)
            {
                transport.Close();
                Console.WriteLine(ex.Message);
                LogService.LogService.Instance.Logger(ex.Message + "\n", "sqoop");
            }
            return feedback;
        }

        public string ImportData(string tableName, string[] columnNames, string whereSql, string hiveTaleb, string keyfield)
        {
            var feedback = "";
            try
            {
                if (!transport.IsOpen)
                    transport.Open();
                if (string.IsNullOrEmpty(hiveTaleb))
                    feedback = sqoopClient.ImportDataInHiveByWhere(_host, _database, _userName, _password, tableName, tableName, whereSql, columnNames.ToList(), keyfield);
                else
                    feedback = sqoopClient.ImportDataInHiveByWhere(_host, _database, _userName, _password, tableName, hiveTaleb, whereSql, columnNames.ToList(), keyfield);
                transport.Close();
            }
            catch (Exception ex)
            {
                transport.Close();
                Console.WriteLine(ex.Message);
                LogService.LogService.Instance.Logger(ex.Message + "\n", "sqoop");
            }
            return feedback;
        }
        public string ExportData(string tableName, string hiveTaleb)
        {
            var feedback = "";
            try
            {
                if (!transport.IsOpen)
                    transport.Open();
                feedback = sqoopClient.ExportData(_host, _database, _userName, _password, tableName, hiveTaleb);
                transport.Close();
            }
            catch (Exception ex)
            {
                transport.Close();
                Console.WriteLine(ex.Message);
                LogService.LogService.Instance.Logger(ex.Message + "\n", "sqoop");
            }
            return feedback;
        }

        public string ExportDataUpdate(string tableName, string hiveTaleb, string keyfield)
        {
            var feedback = "";
            try
            {
                if (!transport.IsOpen)
                    transport.Open();
                feedback = sqoopClient.ExportDataUpdate(_host, _database, _userName, _password, tableName, hiveTaleb, keyfield);
                transport.Close();
            }
            catch (Exception ex)
            {
                transport.Close();
                Console.WriteLine(ex.Message);
                LogService.LogService.Instance.Logger(ex.Message + "\n", "sqoop");
            }
            return feedback;
        }

        public string CreateTable(string tableName, string hiveTaleb = null)
        {
            var feedback = "";
            try
            {
                if (!transport.IsOpen)
                    transport.Open();
               
                if (string.IsNullOrEmpty(hiveTaleb))
                    feedback = sqoopClient.CreateTable(_host, _database, _userName, _password, tableName, tableName);
                else
                    feedback = sqoopClient.CreateTable(_host, _database, _userName, _password, tableName, hiveTaleb);

                transport.Close();
            }
            catch (Exception ex)
            {
                transport.Close();
                Console.WriteLine(ex.Message);
                LogService.LogService.Instance.Logger(ex.Message + "\n", "sqoop");
            }
            return feedback;
        }

        public void Dispose()
        {
            transport = null;
        }
    }
}
