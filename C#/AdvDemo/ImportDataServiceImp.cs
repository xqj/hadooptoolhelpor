using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using SystemConfig;

namespace AdvDemo
{

     public  class ImportDataServiceImp
    {
      
      private static ImportDataServiceImp _instanct = new ImportDataServiceImp();
      public static ImportDataServiceImp Instance
      {
          get
          {
              return _instanct;
          }
      }
      private DatabaseConfigItem config;
      private ImportDataServiceImp()
      {
         
      }      
      public string CreateTable(string tableName,string database,string hivetable=null)
      {
          config = DatabaseConfigService.Instance.GetSqlServerConfig(database);
         
          var dao = new HiveService.SqoopSqlServerService("default", config.Host, config.Database, config.UserName, config.Password);
          if (string.IsNullOrEmpty(hivetable))
              hivetable = tableName;
          return dao.CreateTable(tableName, hivetable);         
      }
      public string ImportData(string tableName, string keyField, string database, string hivetable = null)
      {
          config = DatabaseConfigService.Instance.GetSqlServerConfig(database);
         
          var dao = new HiveService.SqoopSqlServerService("default", config.Host, config.Database, config.UserName, config.Password);
          if (string.IsNullOrEmpty(hivetable))
              hivetable = tableName;
          return dao.ImportData(tableName,hivetable, keyField);
      }
     
    }
}
