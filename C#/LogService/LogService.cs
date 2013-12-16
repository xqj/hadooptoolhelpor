using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Timers;
using SystemConfig;
using System.IO;
using System.Collections.Concurrent;

namespace LogService
{
    
    public class LogService : ILogProvider
    {
        private static LogService _instance = new LogService();
        public static ILogProvider Instance
        {
            get
            {
                return _instance;
            }
        }
        private ConcurrentQueue<LogContentStruct> _contents;
        private Timer _timer;
        private LogConfigItem _config;      
        private LogService()
        {
            _contents = new ConcurrentQueue<LogContentStruct>();
            _config = LogConfigService.Instance.GetDefaultConfig();
            _timer = new Timer(5000);
            _timer.Elapsed += new ElapsedEventHandler(SaveLog);
            _timer.Start();
        }
        void SaveLog(object sender, ElapsedEventArgs e)
        {
            _timer.Stop();
            string storeType = BaseConfigService.Instance.LogType();
            if(storeType=="File")
            SaveLocalFile();
            _timer.Start();
        }

        private void SaveLocalFile()
        {
            string path = _config.Store + DateTime.Now.ToString("yyyyMMddHHmmss-ffffff") + ".log";
            StringBuilder logContent = new StringBuilder();
            var count = 1024;
            if (count > _contents.Count)
                count= _contents.Count;
            if (count == 0)
                return;
            for (int i = 0; i < count; i++)
                {
                    LogContentStruct temp;
                    if(_contents.TryDequeue(out temp))
                    logContent.Append(temp.LogType + ":" + temp.Content+"\n");
                }
                File.AppendAllText(path, logContent.ToString());
        }
       
        public void Logger(string content,string logType)
        {
            _contents.Enqueue(new LogContentStruct() {
                Content = content,
                LogType = logType
            });
        }
        private struct LogContentStruct
        {
            public string LogType
            {
                set;
                get;
            }
            public string Content
            {
                set;
                get;
            }
        }
    }
}
