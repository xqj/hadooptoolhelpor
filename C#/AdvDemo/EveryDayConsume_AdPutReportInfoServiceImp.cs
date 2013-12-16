using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;
using SystemConfig;

namespace AdvDemo
{
    internal class EveryDayConsume_AdPutReportInfoServiceImp : IEveryDayConsumeServiceProvider
    {
         private static EveryDayConsume_AdPutReportInfoServiceImp _instance = new EveryDayConsume_AdPutReportInfoServiceImp();
        private HiveService.HiveService _daoInstance;
        public static IEveryDayConsumeServiceProvider Instance
        {
            get
            {
                return _instance;
            }
        }
        private EveryDayConsume_AdPutReportInfoServiceImp()
        {
            var config = DatabaseConfigService.Instance.GetSqlServerConfig("db_autosense_logmgr");
            _daoInstance = new HiveService.HiveService("default", "default", config.Host, config.Database, config.UserName, config.Password);
        }
        public bool Execute(DateTime yesterday)
        {
            StringBuilder sql = new StringBuilder();
            string viewTable = "AdTxt" + yesterday.ToString("yyyy.MM.dd").Replace(".", "") + "View";
            string clickTable = "AdTxt" + yesterday.ToString("yyyy.MM.dd").Replace(".", "") + "Click";
             sql.Append("insert overwrite table EveryDayConsume_AdPutReportInfo ");
             sql.Append("select vn.AdTxtId as AdTxtId,'" + yesterday.ToString("yyyy-MM-dd HH:mm:ss.fffffff") + "' as YearMonthDay,vn.AdTxtTraceId as AdTxtTraceId,");
            sql.Append("case when vn.num is null then 0L else vn.num end as viewnum,");
            sql.Append("case when cn.num is null then 0L else  cn.num end as clicknum,");
            sql.Append("case when vin.num is null then 0L else  vin.num end as viewIpnum,");
            sql.Append("case when cin.num  is null then 0L else  cin.num end as clickIpnum ");
            sql.Append("from ( select AdTxtId,AdTxtTraceId,count(id) as num from " + viewTable + " adlog group by AdTxtId,AdTxtTraceId ) vn ");
            sql.Append("left outer join ( select  AdTxtId,AdTxtTraceId,count(distinct ip) as num from " + viewTable + " adlog group by AdTxtId,AdTxtTraceId ) vin  on vn.AdTxtId=vin.AdTxtId and vn.AdTxtTraceId=vin.AdTxtTraceId ");
            sql.Append("left outer join ( select  AdTxtId,AdTxtTraceId,count(id) as num from " + clickTable + " adlog group by AdTxtId,AdTxtTraceId ) cn on vn.AdTxtId=cn.AdTxtId and vn.AdTxtTraceId=cn.AdTxtTraceId ");
            sql.Append("left outer join ( select  AdTxtId,AdTxtTraceId,count(distinct ip) as num from " + clickTable + " adlog group by AdTxtId,AdTxtTraceId ) cin on vn.AdTxtId=cin.AdTxtId and vn.AdTxtTraceId=cin.AdTxtTraceId ");
            LogService.LogService.Instance.Logger("执行hivesql:" + sql.ToString(), "hive");
            _daoInstance.Execute(sql.ToString());
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
            LogService.LogService.Instance.Logger("从 EveryDayConsume_AdPutReportInfo 向 temp_EveryDayConsume_AdPutReportInfo 导数据.\n", "sqoop");
            var feedback = _daoInstance.ExportData("temp_EveryDayConsume_AdPutReportInfo", "EveryDayConsume_AdPutReportInfo");
            LogService.LogService.Instance.Logger("从 EveryDayConsume_AdPutReportInfo 向 temp_EveryDayConsume_AdPutReportInfo 导数据操作完成！\n", "sqoop");
            DatabaseDao.execute("Insert into EveryDayConsume_AdPutReportInfo(AdtxtId,YearMonthDay,AdTxtTraceId,viewnum,clicknum,viewIpnum,clickIpnum) select * from temp_EveryDayConsume_AdPutReportInfo");
            LogService.LogService.Instance.Logger("从 temp_EveryDayConsume_AdPutReportInfo 向 EveryDayConsume_AdPutReportInfo 导数据操作完成！\n", "sqoop");
            LogService.LogService.Instance.Logger(feedback + "\n", "sqoop");
            return feedback;
             
        }
    }
}
