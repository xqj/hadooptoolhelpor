using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;
using SystemConfig;

namespace AdvDemo
{
    internal class MemberSiteEveryDaySummaryServiceImp : IEveryDayConsumeServiceProvider
    {
         private static MemberSiteEveryDaySummaryServiceImp _instance = new MemberSiteEveryDaySummaryServiceImp();
        private HiveService.HiveService _daoInstance;
        public static IEveryDayConsumeServiceProvider Instance
        {
            get
            {
                return _instance;
            }
        }
        private MemberSiteEveryDaySummaryServiceImp()
        {
            var config = DatabaseConfigService.Instance.GetSqlServerConfig("db_AutosenseUnion");
            _daoInstance = new HiveService.HiveService("default", "default", config.Host, config.Database, config.UserName, config.Password);
            
        }
        public bool Execute(DateTime yesterday)
        {
            string viewTable = "AdTxt" + yesterday.ToString("yyyy.MM.dd").Replace(".", "") + "View";
            string clickTable = "AdTxt" + yesterday.ToString("yyyy.MM.dd").Replace(".", "") + "Click";
            string sql = "insert overwrite table MemberSiteEveryDaySummary " +
                "SELECT UniONId,v.AdSiteId,'" + yesterday.ToString("yyyy-MM-dd HH:mm:ss.fffffff") + "' as ymd,viewnum,(case when clicknum is null then 0L else clicknum end) clicknum,Ratio,(case when clicknum is null then 0*1.0 else clicknum * Ratio/100 end) AS Income,0 AS status "
                + "FROM "
                + "( "
                + "	SELECT AdSiteId ,count(1) AS viewnum "
                + "	FROM " + viewTable
                + "	GROUP BY AdSiteId "
                + ") v "
                + "JOIN UniONMemberSite s "
                + "ON v.AdSiteId=s.adsiteid "
                + "LEFT OUTER JOIN "
                + "( "
                + "	SELECT AdSiteId ,count(1) AS clicknum "
                + "	FROM " + clickTable
                + "	GROUP BY AdSiteId "
                + ") c "
                + "ON c.AdSiteId=v.adsiteid";
            LogService.LogService.Instance.Logger("执行hivesql:"+sql.ToString(), "hive");
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
            LogService.LogService.Instance.Logger("从 MemberSiteEveryDaySummary 向 temp_MemberSiteEveryDaySummary 导数据.\n", "sqoop");
            var feedback = _daoInstance.ExportData("temp_MemberSiteEveryDaySummary", "MemberSiteEveryDaySummary");
            LogService.LogService.Instance.Logger("从 MemberSiteEveryDaySummary 向 temp_MemberSiteEveryDaySummary 导数据操作完成！\n", "sqoop");
            DatabaseDao.execute1("Insert into MemberSiteEveryDaySummary(UnionMemberId,AdSiteId,ymd,viewnum,ClickNum,Ratio,Income,Status) select * from temp_MemberSiteEveryDaySummary");
            LogService.LogService.Instance.Logger("从 temp_MemberSiteEveryDaySummary 向 MemberSiteEveryDaySummary 导数据操作完成！\n", "sqoop");
            LogService.LogService.Instance.Logger(feedback + "\n", "sqoop");
            return feedback;
        }
    }
}
