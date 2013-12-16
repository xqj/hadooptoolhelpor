using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace HiveService
{
    public interface ISqoopInterface
    {
        string CreateTable(string tableName, string hiveTaleb);

        string ImportData(string tableName, string hiveTaleb, string keyfield);

        string ImportData(string tableName, string[] columnNames, string whereSql, string hiveTaleb, string keyfield);

         string ExportData(string tableName, string hiveTaleb);

         string ExportDataUpdate(string tableName, string hiveTaleb, string keyfield);
    }
}
