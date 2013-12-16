using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using SystemConfig;

namespace DataConverionTool
{
    public class MahoutConfigure : IHostConfigure
    {
        private static Dictionary<string, string> _hostCollections = new Dictionary<string, string>();
        private static Dictionary<string, int> _hostPortCollections = new Dictionary<string, int>();
        private static MahoutConfigure _instance = new MahoutConfigure();
        private MahoutConfigure()
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
            var list = service.GetConfigItem("mahout");
            if (list != null)
            {
                list.ForEach(a =>
                {
                    var temp = (HostConfigItem)a;
                    AddHostServer(temp.Name, temp.Host, temp.Port);
                });
            }
        }
        public void AddHostServer(string hostServerName, string host, int port)
        {
            _hostCollections.Add(hostServerName, host);
            _hostPortCollections.Add(hostServerName, port);
        }
        public bool SetHostPort(string hostServerName, int port)
        {
            if (_hostPortCollections.ContainsKey(hostServerName))
            {
                _hostPortCollections[hostServerName] = port;
                return true;
            }
            return false;

        }
        public string GetHostServer(string hostServerName)
        {
            if (_hostCollections.ContainsKey(hostServerName))
            {
                return _hostCollections[hostServerName];
            }
            return string.Empty;
        }
        public int GetHostPort(string hostServerName)
        {
            if (_hostPortCollections.ContainsKey(hostServerName))
            {
                return _hostPortCollections[hostServerName];
            }
            return -1;
        }
        public string GetDefaultHost()
        {
            return _hostCollections["default"];
        }
        public int GetDefaultPort()
        {
            return _hostPortCollections["default"];
        }
    }
}
