using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace SystemConfig
{
   public interface IConfig
    {
       List<Object> GetConfigItem(string itemType);
    }
}
