using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace DataConverionTool
{
    public class MahoutThriftClient : MahoutThrift.Iface
    {
         private Thrift.Protocol.TBinaryProtocol _proto;
         private MahoutThrift.Client client;
        public MahoutThriftClient(Thrift.Protocol.TBinaryProtocol proto)
        {
             this._proto = proto;
             client = new MahoutThrift.Client(_proto); 
        }
        public string ImportDataInMahout(string hiveTableName, string mahoutTable)
        {
            return client.ImportDataInMahout(hiveTableName, mahoutTable);
        }

        public string ExportDataOutMahout(string hiveTableName, string mahoutTable)
        {
            return client.ExportDataOutMahout(hiveTableName, mahoutTable);
        }
    }
}
