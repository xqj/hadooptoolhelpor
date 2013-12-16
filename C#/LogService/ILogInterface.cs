using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace LogService
{
    public interface ILogProvider
    {
        void Logger(string content,string logType);
    }
}
