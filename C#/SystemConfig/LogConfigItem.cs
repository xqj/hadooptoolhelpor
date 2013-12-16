using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace SystemConfig
{
    public struct LogConfigItem
    {       
        /// <summary>
        /// File,Database,WebFile
        /// </summary>
        public string ItemType
        {
            set;
            get;
        }
        /// <summary>
        ///Local File path or Database connnection string
        /// </summary>
        public string Store
        {
            set;
            get;
        }

        public string Name
        {
            set;
            get;
        }
        /// <summary>
        /// table name or file name
        /// </summary>
        public string StoreName
        {
            set;
            get;
        }
    }
}
