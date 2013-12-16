using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using SystemConfig;

namespace HiveService
{
    public class SqoopConfigure : IHostConfigure
    {
        private static Dictionary<string, string> _sqoopHostCollections = new Dictionary<string, string>();
        private static Dictionary<string, int> _sqoopHostPortCollections = new Dictionary<string, int>();
        private static SqoopConfigure _instance = new SqoopConfigure();
        private SqoopConfigure()
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
            var list = service.GetConfigItem("sqoop");
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
            _sqoopHostCollections.Add(hostServerName, host);
            _sqoopHostPortCollections.Add(hostServerName, port);
        }
        public bool SetHostPort(string hostServerName, int port)
        {
            if (_sqoopHostPortCollections.ContainsKey(hostServerName))
            {
                _sqoopHostPortCollections[hostServerName] = port;
                return true;
            }
            return false;

        }
        public string GetHostServer(string hostServerName)
        {
            if (_sqoopHostCollections.ContainsKey(hostServerName))
            {
                return _sqoopHostCollections[hostServerName];
            }
            return string.Empty;
        }
        public int GetHostPort(string hostServerName)
        {
            if (_sqoopHostPortCollections.ContainsKey(hostServerName))
            {
                return _sqoopHostPortCollections[hostServerName];
            }
            return -1;
        }
        public string GetDefaultHost()
        {
            return _sqoopHostCollections["default"];
        }
        public int GetDefaultPort()
        {
            return _sqoopHostPortCollections["default"];
        }
    }
}
