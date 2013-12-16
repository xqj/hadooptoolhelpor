using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace AdvDemo
{
    public interface IEveryDayConsumeServiceProvider
    {
        bool Execute(DateTime statisticsdate);
        string Export(DateTime statisticsdate);
    }
}
