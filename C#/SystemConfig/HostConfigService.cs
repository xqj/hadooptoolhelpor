using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace SystemConfig
{
    public class HostConfigService : SystemConfig,IConfig
    {
        private List<HostConfigItem> _list;
        private static HostConfigService _instance = new HostConfigService();
        public static IConfig Instance
        {
            get
            {
                return _instance;
            }
        }
        private HostConfigService()
        {
            init();
        }
        protected override void init()
        {
            _list = XmlConfigSerializer.Instance.Deserialize<HostConfigItem>(DefineTable.Instance.GetFile("hostConfig"));
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
    }
}
