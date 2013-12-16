using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;
using SystemConfig;

namespace AdvDemo
{
    internal class EveryDayConsume_AD_AreaServiceImp : IEveryDayConsumeServiceProvider
    {
         private static EveryDayConsume_AD_AreaServiceImp _instance = new EveryDayConsume_AD_AreaServiceImp();
        private HiveService.HiveService _daoInstance;
        public static IEveryDayConsumeServiceProvider Instance
        {
            get
            {
                return _instance;
            }
        }
        private EveryDayConsume_AD_AreaServiceImp()
        {
            var config = DatabaseConfigService.Instance.GetSqlServerConfig("db_autosense_logmgr");
            _daoInstance = new HiveService.HiveService("default", "default", config.Host, config.Database, config.UserName, config.Password);
        }
        public bool Execute(DateTime yesterday)
        {
            string viewTable = "AdTxt" + yesterday.ToString("yyyy.MM.dd").Replace(".", "") + "View";
            string clickTable = "AdTxt" + yesterday.ToString("yyyy.MM.dd").Replace(".", "") + "Click";
            string sql = "insert overwrite table EveryDayConsume_AD_Area "
                + "SELECT VendorID,v.adtxtid,'" + yesterday.ToString("yyyy-MM-dd HH:mm:ss.fffffff") + "' as YearMonthDay,areacn,viewcount,(case when clickcount is null then 0L else clickcount end) as clickcount,viewIpcount,(case when clickIpcount is null then 0L else clickIpcount end) as clickIpcount "
                + "FROM "
                + "( "
                + "	SELECT adtxtid,substring(areacodeid,0,2) AS provinceid,count(1) AS viewcount,count(DISTINCT ip) AS viewIpcount "
                + "	FROM  " + viewTable
                + "	GROUP BY AdTxtId,substring(areacodeid,0,2)  "
                + ") V "
                + "LEFT OUTER JOIN "
                + "( "
                + "	SELECT adtxtid,substring(areacodeid,0,2) AS provinceid,count(1) AS clickcount,count(DISTINCT ip) AS clickIpcount "
                + "	FROM  " + clickTable
                + "	GROUP BY AdTxtId,substring(areacodeid,0,2) "
                + ") C "
                + "ON V.adtxtid=C.adtxtid and V.provinceid=C.provinceid  "
                + "JOIN temp_adtxt  D  "
                + "ON D.id=V.adtxtid  "
                + "JOIN temp_areap P "
                + "ON V.provinceid =substring(P.areacodeid,0,2) ";
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
            LogService.LogService.Instance.Logger("从 everydayconsume_ad_area 向 temp_EveryDayConsume_AD_Area 导数据.\n", "sqoop");
            var feedback= _daoInstance.ExportData("temp_EveryDayConsume_AD_Area", "everydayconsume_ad_area");
            LogService.LogService.Instance.Logger("从 everydayconsume_ad_area 向 temp_EveryDayConsume_AD_Area 导数据操作完成！\n", "sqoop");
            DatabaseDao.execute("Insert into EveryDayConsume_AD_Area(VendorID,AdTxtID,YearMonthDay,AreaTitle,viewnum,clicknum,viewIpnum,clickIpnum) select * from temp_EveryDayConsume_AD_Area");
            LogService.LogService.Instance.Logger("从 temp_EveryDayConsume_AD_Area 向 everydayconsume_ad_area 导数据操作完成！\n", "sqoop");
            LogService.LogService.Instance.Logger(feedback + "\n", "sqoop");
            return feedback;
           
        }
    }
}
