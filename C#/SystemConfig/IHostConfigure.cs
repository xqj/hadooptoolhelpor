using System;
namespace SystemConfig
{
   public interface IHostConfigure
    {
        void AddHostServer(string hostServerName, string host, int port);
        string GetDefaultHost();
        int GetDefaultPort();
        int GetHostPort(string hostServerName);
        string GetHostServer(string hostServerName);
        bool SetHostPort(string hostServerName, int port);
    }
}
