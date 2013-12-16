using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;
using SystemConfig;

namespace AdvDemo
{
    internal class EveryDayConsume_Vendor_KeyWordServiceImp : IEveryDayConsumeServiceProvider
    {
       private static EveryDayConsume_Vendor_KeyWordServiceImp _instance = new EveryDayConsume_Vendor_KeyWordServiceImp();
        private HiveService.HiveService _daoInstance;
        public static IEveryDayConsumeServiceProvider Instance
        {
            get
            {
                return _instance;
            }
        }
        private EveryDayConsume_Vendor_KeyWordServiceImp()
        {
            var config = DatabaseConfigService.Instance.GetSqlServerConfig("db_autosense_logmgr");
            _daoInstance = new HiveService.HiveService("default", "default", config.Host, config.Database, config.UserName, config.Password);
        }
        public bool Execute(DateTime yesterday)
        {
            StringBuilder sql = new StringBuilder();
            string viewTable = "AdTxt" + yesterday.ToString("yyyy.MM.dd").Replace(".", "") + "View";
            string clickTable = "AdTxt" + yesterday.ToString("yyyy.MM.dd").Replace(".", "") + "Click";
            sql.Append("insert overwrite table EveryDayConsume_Vendor_KeyWord ");
            sql.Append("select vn.vendorid as vendorid,'" + yesterday.ToString("yyyy-MM-dd HH:mm:ss.fffffff") + "' as YearMonthDay,ta.id as KeyWordId,ta.TokenWord as KeyWordTitle,");
            sql.Append("case when vn.num is null then 0L else vn.num end as viewnum,");
            sql.Append("case when cn.num is null then 0L else  cn.num end as clicknum,");
            sql.Append("case when vin.num is null then 0L else  vin.num end as viewIpnum,");
            sql.Append("case when cin.num  is null then 0L else  cin.num end as clickIpnum ");
            sql.Append("from ( select t.vendorid as vendorid,s.id as KeyWordId,count(v.id) as num from " + viewTable + " v  join temp_adtxt t on t.id=v.adtxtid   join temp_KeyWord s on s.id=v.KeyWordId  group by t.vendorid,s.id ) vn ");
            sql.Append(" join temp_KeyWord ta on vn.KeyWordId=ta.id ");
            sql.Append(" join ( select t.vendorid as vendorid,s.id as KeyWordId,count(distinct v.ip) as num from " + viewTable + " v  join temp_adtxt t on t.id=v.adtxtid   join temp_KeyWord s on s.id=v.KeyWordId group by t.vendorid,s.id ) vin on vn.vendorid=vin.vendorid and vn.KeyWordId=vin.KeyWordId ");
            sql.Append("left outer join ( select t.vendorid as vendorid,s.id as KeyWordId,count(v.id) as num from " + clickTable + " v  join temp_adtxt t on t.id=v.adtxtid  join temp_KeyWord s on s.id=v.KeyWordId group by t.vendorid,s.id ) cn on vn.vendorid=cn.vendorid and vn.KeyWordId=cn.KeyWordId ");
            sql.Append("left outer join (select t.vendorid as vendorid,s.id as KeyWordId,count(distinct v.ip) as num from " + clickTable + " v  join temp_adtxt t on t.id=v.adtxtid  join temp_KeyWord s on s.id=v.KeyWordId group by t.vendorid,s.id ) cin on vn.vendorid=cin.vendorid and vn.KeyWordId=cin.KeyWordId ");
            LogService.LogService.Instance.Logger("执行hivesql:" + sql.ToString(), "hive");
            _daoInstance.Execute(sql.ToString());

            //var list = _daoInstance.SelectAllColunms(sql.ToString());
            //StringBuilder con = new StringBuilder();
            //int i = 1;
            //list.ForEach(a =>
            //{
            //    con.Append("num:" + i.ToString() + "start:" + a + "\tEND\r");
            //    i++;
            //});
            //File.AppendAllText(@"D:\TestProject\hivetest\hivetxt\" + (i - 1).ToString() + ".txt", con.ToString());

            return true;
        }
        public string Export(DateTime statisticsdate)
        {
            LogService.LogService.Instance.Logger("从 EveryDayConsume_Vendor_KeyWord 向 temp_EveryDayConsume_Vendor_KeyWord 导数据.\n", "sqoop");
            var feedback = _daoInstance.ExportData("temp_EveryDayConsume_Vendor_KeyWord", "EveryDayConsume_Vendor_KeyWord");
            LogService.LogService.Instance.Logger("从 EveryDayConsume_Vendor_KeyWord 向 temp_EveryDayConsume_Vendor_KeyWord 导数据操作完成！\n", "sqoop");
            DatabaseDao.execute("Insert into EveryDayConsume_Vendor_KeyWord(VendorID,YearMonthDay,KeyWordId,KeyWordTitle,viewnum,clicknum,viewIpnum,clickIpnum) select * from temp_EveryDayConsume_Vendor_KeyWord");
            LogService.LogService.Instance.Logger("从 temp_EveryDayConsume_Vendor_KeyWord 向 EveryDayConsume_Vendor_KeyWord 导数据操作完成！\n", "sqoop");
            LogService.LogService.Instance.Logger(feedback + "\n", "sqoop");
            return feedback;
        }
    }
}
