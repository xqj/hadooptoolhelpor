using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace SystemConfig
{
    public class LogConfigService : SystemConfig,IConfig
    {
        private List<LogConfigItem> _list;
        private static LogConfigService _instance = new LogConfigService();
        public static LogConfigService Instance
        {
            get
            {
                return _instance;
            }
        }
        private LogConfigService()
        {
            init();
        }
        protected override void init()
        {
            _list = XmlConfigSerializer.Instance.Deserialize<LogConfigItem>(DefineTable.Instance.GetFile("logConfig"));
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
        public LogConfigItem GetConfig(string name,string itemType)
        {
            var list = GetConfigItem(itemType);
            if (list != null)
            {
                for (int i = 0; i < list.Count; i++)
                {
                    var item = (LogConfigItem)list[i];
                    if (item.Name == name)
                        return item;
                }
            }
            return new LogConfigItem();
        }
        public LogConfigItem GetDefaultConfig()
        {
            return GetConfig("default",BaseConfigService.Instance.LogType());
        }
    }
}
