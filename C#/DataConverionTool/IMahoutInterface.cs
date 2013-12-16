using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace DataConverionTool
{
    public interface IMahoutInterface
    {
        string ImportDataInMahout(string hiveTableName, string mahoutTable, List<string> columnNames, string hivePrimaryKey, List<string> timeColumnNames = null, List<string> convertColumnNames = null, bool createTable = false);
         string ExportDataOutMahout(string hiveTableName, string mahoutTable);
         string ExtractVectorField(string mahoutTableName, string mahoutTargetTableName, string extractXColumn, string extractYColumn, bool createTable = false);
    }
}
