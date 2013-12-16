using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace SystemConfig
{
    public struct BaseConfigItem
    {
        public bool IsDebug
        {
            set;
            get;
        }
        /// <summary>
        /// File,Database,WebFile
        /// </summary>
        public string LogType
        {
            set;
            get;
        }
        /// <summary>
        /// normal,test
        /// </summary>
        public string ItemType
        {
            set;
            get;
        }
    }
}
