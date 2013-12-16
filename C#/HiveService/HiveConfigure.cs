using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using SystemConfig;

namespace HiveService
{
    public class HiveConfigure:IHostConfigure
    {
        private static Dictionary<string, string> _hiveHostCollections = new Dictionary<string, string>();
        private static Dictionary<string, int> _hiveHostPortCollections = new Dictionary<string, int>();
        private static HiveConfigure _instance = new HiveConfigure();
        private HiveConfigure()
        {
            Init();
        }
        public static IHostConfigure Instance
        {
            get { return _instance; }
        }
        private void Init()
        {
            var service = ConfigManager.Instance.GetService("hostConfig");
            var list = service.GetConfigItem("hive");
            if (list != null)
            {
                list.ForEach(a => {
                    var temp = (HostConfigItem)a;
                    AddHostServer(temp.Name, temp.Host, temp.Port);
                });
            }
           
        }
        public void AddHostServer(string hostServerName, string host, int port)
        {
            _hiveHostCollections.Add(hostServerName, host);
            _hiveHostPortCollections.Add(hostServerName, port);
        }
        public bool SetHostPort(string hostServerName, int port)
        {
            if (_hiveHostPortCollections.ContainsKey(hostServerName))
            {
                _hiveHostPortCollections[hostServerName] = port;
                return true;
            }
            return false;

        }
        public string GetHostServer(string hostServerName)
        {
            if (_hiveHostCollections.ContainsKey(hostServerName))
            {
                return _hiveHostCollections[hostServerName];
            }
            return string.Empty;
        }
        public int GetHostPort(string hostServerName)
        {
            if (_hiveHostPortCollections.ContainsKey(hostServerName))
            {
                return _hiveHostPortCollections[hostServerName];
            }
            return -1;
        }
     

        public string GetDefaultHost()
        {
            return _hiveHostCollections["default"];
        }

        public int GetDefaultPort()
        {
            return _hiveHostPortCollections["default"];
        }
    }
}
