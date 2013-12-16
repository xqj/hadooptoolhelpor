using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace SystemConfig
{
    public class BaseConfigService : SystemConfig
    {
        private List<BaseConfigItem> _list;
        private static BaseConfigService _instance = new BaseConfigService();
        public static BaseConfigService Instance
        {
            get
            {
                return _instance;
            }
        }
        private BaseConfigService()
        {
            init();
        }
        protected override void init()
        {
            _list = XmlConfigSerializer.Instance.Deserialize<BaseConfigItem>("baseConfig.xml");
        }

        private List<Object> GetConfigItem()
        {
            List<Object> results = null;
            if (_list != null)
            {
                results = new List<Object>();
                _list.ForEach(a => results.Add((Object)a));
            }
            return results;
        }
        public bool IsDebug()
        {
            var baseConfig =(BaseConfigItem)GetConfigItem().FirstOrDefault();
            return baseConfig.IsDebug;
        }
        public string LogType()
        {
            var baseConfig = (BaseConfigItem)GetConfigItem().FirstOrDefault();
            return baseConfig.LogType;
        }
    }
}
