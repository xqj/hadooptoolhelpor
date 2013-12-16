using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace HiveService
{
    public interface IHiveProvider
    {
        List<T> SelectList<T>(string sql) where T : new();
        T select<T>(string sql) where T : new();
        List<String> SelectAllColunms(string sql);
        void Execute(string sql);
        string InsertTo(string tableName, string keyfield);
        string AppendTo(string tableName, string[] columnNames, string whereSql, string keyfield, string hiveTableName = null);
        string CreateTable(string tableName, string hiveTable = null);
        void DdlTable(string sql);
    }
}
