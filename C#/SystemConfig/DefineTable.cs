using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace SystemConfig
{
    internal class DefineTable
    {
        private Dictionary<string, string> releaseConfigs;
        private Dictionary<string, string> deBugConfigs;
        private static DefineTable _instance = new DefineTable();
        public static DefineTable Instance
        {
            get
            {
                return _instance;
            }
        }
        private DefineTable()
        {
            releaseConfigs = new Dictionary<string, string>();
            releaseConfigs.Add("hostConfig", "releaseConfig/hostConfig.xml");
            releaseConfigs.Add("databaseConfig", "releaseConfig/databaseConfig.xml");
            releaseConfigs.Add("logConfig", "releaseConfig/logConfig.xml");
            deBugConfigs = new Dictionary<string, string>();
            deBugConfigs.Add("hostConfig", "debugConfig/hostConfig.xml");
            deBugConfigs.Add("databaseConfig", "releaseConfig/databaseConfig.xml");
            deBugConfigs.Add("logConfig", "releaseConfig/logConfig.xml");
        }
        public string GetFile(string configName)
        {
            if (BaseConfigService.Instance.IsDebug())
            {
                if (deBugConfigs.ContainsKey(configName))
                    return deBugConfigs[configName];
            }
            else
            {
                if (releaseConfigs.ContainsKey(configName))
                    return releaseConfigs[configName];
              
            }
                return string.Empty;
        }
    }
}
