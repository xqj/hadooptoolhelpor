using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace SystemConfig
{
   public class ConfigManager
    {
      Dictionary<string,IConfig> configlist;
       private static ConfigManager _instance = new ConfigManager();
       public static ConfigManager Instance
       {
           get
           {
               return _instance;
           }
       }
       private ConfigManager()
       {
           configlist = new Dictionary<string, IConfig>();
           configlist.Add("hostConfig", HostConfigService.Instance);
       }
       public IConfig GetService(string serviceName)
       {
           if (configlist.ContainsKey(serviceName))
               return configlist[serviceName];
           else
               return null;
       }
    }
}
