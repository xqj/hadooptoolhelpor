using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace SystemConfig
{
    public class DatabaseConfigService : SystemConfig,IConfig
    {
        private List<DatabaseConfigItem> _list;
        private static DatabaseConfigService _instance = new DatabaseConfigService();
        public static DatabaseConfigService Instance
        {
            get
            {
                return _instance;
            }
        }
        private DatabaseConfigService()
        {
            init();
        }
        protected override void init()
        {
            _list = XmlConfigSerializer.Instance.Deserialize<DatabaseConfigItem>(DefineTable.Instance.GetFile("databaseConfig"));
        }

        public List<Object> GetConfigItem(string itemType)
        {
            var list=_list.FindAll(a => a.ItemType == itemType);
            List<Object> results = null;
            if (list != null)
            {
                results = new List<Object>();
                list.ForEach(a=>results.Add((Object)a));
            }
            return results;
        }
        public DatabaseConfigItem GetSqlServerConfig(string name)
        {
           var list= GetConfigItem("sqlserver");           
           if (list != null)
           {
               for (int i = 0; i < list.Count; i++)
               {
                  var item = (DatabaseConfigItem)list[i];
                   if (item.Name == name)
                       return item;
               }
           }
           return new DatabaseConfigItem();
          
        }
    }
}
