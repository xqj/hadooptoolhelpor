using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace SystemConfig
{
   [Serializable]
    public struct HostConfigItem
    {
       public string Name
       {
           get;
           set;
       }

        public string Host
        {
            get;
            set;
        }

        public int Port
        {
            get;
            set;
        }
       /// <summary>
       /// sqoop,hive
       /// </summary>
        public string ItemType
        {
            get;
            set;
        }
    }
}
