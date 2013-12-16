using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;
using SystemConfig;

namespace AdvDemo
{
    internal class EveryDayConsume_Vendor_SiteServiceImp : IEveryDayConsumeServiceProvider
    {
         private static EveryDayConsume_Vendor_SiteServiceImp _instance = new EveryDayConsume_Vendor_SiteServiceImp();
        private HiveService.HiveService _daoInstance;
        public static IEveryDayConsumeServiceProvider Instance
        {
            get
            {
                return _instance;
            }
        }
        private EveryDayConsume_Vendor_SiteServiceImp()
        {
            var config = DatabaseConfigService.Instance.GetSqlServerConfig("db_autosense_logmgr");
            _daoInstance = new HiveService.HiveService("default", "default", config.Host, config.Database, config.UserName, config.Password);
        }
        public bool Execute(DateTime yesterday)
        {
            string viewTable = "AdTxt" + yesterday.ToString("yyyy.MM.dd").Replace(".", "") + "View";
            string clickTable = "AdTxt" + yesterday.ToString("yyyy.MM.dd").Replace(".", "") + "Click";
            string sql = "insert overwrite table EveryDayConsume_Vendor_Site "
                + "SELECT V.VendorID,'" + yesterday.ToString("yyyy-MM-dd HH:mm:ss.fffffff") + "' as YearMonthDay,V.ADSiteId as siteid,s.title as SiteTitle,viewcount,(case when clickcount is null then 0L else clickcount end) as clickcount,viewIpcount,(case when clickIpcount is null then 0L else clickIpcount end) as clickIpcount "
                + "FROM "
                + "( "
                + "	SELECT vendorid,ADSiteId,count(1) as viewcount,count(distinct ip) as viewIpcount  "
                + "	FROM  " + viewTable + " v "
                + "	JOIN temp_adtxt t "
                + "	ON v.adtxtid=t.id "
                + "	GROUP BY vendorid,ADSiteId  "
                + ") V "
                + "JOIN temp_AdSite s "
                + "ON s.id=v.ADSiteId  "
                + "LEFT OUTER JOIN "
                + "( "
                + "	SELECT vendorid,ADSiteId,count(1) as clickcount,count(distinct ip) as clickIpcount  "
                + "	FROM  " + clickTable + " c "
                + "	JOIN temp_adtxt t "
                + "	ON c.adtxtid=t.id "
                + "	GROUP BY vendorid,ADSiteId  "
                + ") C "
                + "ON V.VendorID=C.vendorid AND V.ADSiteId=C.ADSiteId ";
            LogService.LogService.Instance.Logger("执行hivesql:" + sql.ToString(), "hive");
            _daoInstance.Execute(sql);
           //var list= _daoInstance.SelectAllColunms(sql.ToString());
           // StringBuilder con=new StringBuilder();
           // int i = 1;
           // list.ForEach(a=>{
           // con.Append("num:"+i.ToString()+"start:"+a+"\tEND\n");
           // i++;
           // });
           // File.AppendAllText(@"D:\TestProject\hivetest\hivetxt\" + yesterday.ToString("yyyy.MM.dd").Replace(".", "") + ".txt", con.ToString());
           
            return true;
        }
        public string Export(DateTime statisticsdate)
        {
            LogService.LogService.Instance.Logger("从 EveryDayConsume_Vendor_Site 向 temp_EveryDayConsume_Vendor_Site 导数据.\n", "sqoop");
            var feedback = _daoInstance.ExportData("temp_EveryDayConsume_Vendor_Site", "EveryDayConsume_Vendor_Site");
            LogService.LogService.Instance.Logger("从 EveryDayConsume_Vendor_Site 向 temp_EveryDayConsume_Vendor_Site 导数据操作完成！\n", "sqoop");
            DatabaseDao.execute("Insert into EveryDayConsume_Vendor_Site(VendorID,YearMonthDay,SiteId,SiteTitle,viewnum,clicknum,viewIpnum,clickIpnum) select * from temp_EveryDayConsume_Vendor_Site");
            LogService.LogService.Instance.Logger("从 temp_EveryDayConsume_Vendor_Site 向 EveryDayConsume_Vendor_Site 导数据操作完成！\n", "sqoop");
            LogService.LogService.Instance.Logger(feedback + "\n", "sqoop");
            return feedback;
        }
    }
}
