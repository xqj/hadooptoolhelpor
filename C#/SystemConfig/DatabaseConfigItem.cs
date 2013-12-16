using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace SystemConfig
{
   [Serializable]
    public struct DatabaseConfigItem
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
        public string Database
        {
            get;
            set;
        }
        public string UserName
        {
            get;
            set;
        }
        public string Password
        {
            get;
            set;
        }
       /// <summary>
       /// sqlserver,oracle,mysql
       /// </summary>
        public string ItemType
        {
            get;
            set;
        }
    }
}
