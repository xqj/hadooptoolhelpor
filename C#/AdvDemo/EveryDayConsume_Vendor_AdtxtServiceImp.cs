using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;
using SystemConfig;


namespace AdvDemo
{
    internal class EveryDayConsume_Vendor_AdtxtServiceImp : IEveryDayConsumeServiceProvider
    {
        private static EveryDayConsume_Vendor_AdtxtServiceImp _instance = new EveryDayConsume_Vendor_AdtxtServiceImp();
        private HiveService.HiveService _daoInstance;
        public static IEveryDayConsumeServiceProvider Instance
        {
            get
            {
                return _instance;
            }
        }
        private EveryDayConsume_Vendor_AdtxtServiceImp()
        {
            var config = DatabaseConfigService.Instance.GetSqlServerConfig("db_autosense_logmgr");
            _daoInstance = new HiveService.HiveService("default", "default", config.Host, config.Database, config.UserName, config.Password);
        }
        public bool Execute(DateTime yesterday)
        {
            StringBuilder sql =new StringBuilder();
            string viewTable = "AdTxt" + yesterday.ToString("yyyy.MM.dd").Replace(".","") + "View";
            string clickTable = "AdTxt" + yesterday.ToString("yyyy.MM.dd").Replace(".", "") + "Click";
            sql.Append("insert overwrite table EveryDayConsume_Vendor_Adtxt ");
            sql.Append("select t.vendorid as vendorid,'" + yesterday.ToString("yyyy-MM-dd HH:mm:ss.fffffff") + "' as YearMonthDay,t.id adtxtid,t.title adtxttitle,");
            sql.Append("case when vn.num is null then 0L else vn.num end  viewnum,");
            sql.Append("case when cn.num is null then 0L else  cn.num end  clicknum,");
            sql.Append("case when vin.num is null then 0L else  vin.num end viewIpnum,");
            sql.Append("case when cin.num  is null then 0L else  cin.num end  clickIpnum ");
            //sql.Append("unix_timestamp('" + DateTime.Now.ToShortDateString() + "') as createtime");
            sql.Append(" from Temp_AdTxt t ");
            sql.Append(" join  ( select v.adtxtid,count(v.adtxtid) num  from " + viewTable + " v group by v.adtxtid ) vn  on (t.id=vn.adtxtid) ");
            sql.Append(" join  ( select v.adtxtid,count(distinct v.ip) num  from " + viewTable + " v group by v.adtxtid )  vin on (t.id=vin.adtxtid) ");
            sql.Append("left outer join  ( select v.adtxtid,count(v.adtxtid)  num  from " + clickTable + " v group by v.adtxtid )  cn on (t.id=cn.adtxtid) ");
            sql.Append(" left outer join  ( select v.adtxtid,count(distinct v.ip) num  from " + clickTable + " v group by v.adtxtid )  cin on (t.id=cin.adtxtid)");
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
            LogService.LogService.Instance.Logger("从 EveryDayConsume_Vendor_Adtxt 向 temp_EveryDayConsume_Vendor_Adtxt 导数据.\n", "sqoop");
            var feedback = _daoInstance.ExportData("temp_EveryDayConsume_Vendor_Adtxt", "EveryDayConsume_Vendor_Adtxt");
            LogService.LogService.Instance.Logger("从 EveryDayConsume_Vendor_Adtxt 向 temp_EveryDayConsume_Vendor_Adtxt 导数据操作完成！\n", "sqoop");
            DatabaseDao.execute("Insert into EveryDayConsume_Vendor_Adtxt(VendorID,YearMonthDay,AdtxtId,AdtxtTitle,viewnum,clicknum,viewIpnum,clickIpnum) select * from temp_EveryDayConsume_Vendor_Adtxt");
            LogService.LogService.Instance.Logger("从 temp_EveryDayConsume_Vendor_Adtxt 向 EveryDayConsume_Vendor_Adtxt 导数据操作完成！\n", "sqoop");
            LogService.LogService.Instance.Logger(feedback + "\n", "sqoop");
            return feedback; 
        }
    }
}
