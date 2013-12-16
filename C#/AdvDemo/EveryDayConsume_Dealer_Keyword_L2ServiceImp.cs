using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;
using SystemConfig;

namespace AdvDemo
{
    internal class EveryDayConsume_Dealer_Keyword_L2ServiceImp : IEveryDayConsumeServiceProvider
    {
         private static EveryDayConsume_Dealer_Keyword_L2ServiceImp _instance = new EveryDayConsume_Dealer_Keyword_L2ServiceImp();
        private HiveService.HiveService _daoInstance;
        public static IEveryDayConsumeServiceProvider Instance
        {
            get
            {
                return _instance;
            }
        }
        private EveryDayConsume_Dealer_Keyword_L2ServiceImp()
        {
            var config = DatabaseConfigService.Instance.GetSqlServerConfig("db_autosense_logmgr");
            _daoInstance = new HiveService.HiveService("default", "default", config.Host, config.Database, config.UserName, config.Password);
        }
        public bool Execute(DateTime yesterday)
        {
            StringBuilder sql = new StringBuilder();
            string viewTable = "AdTxt" + yesterday.ToString("yyyy.MM.dd").Replace(".", "") + "View";
            string clickTable = "AdTxt" + yesterday.ToString("yyyy.MM.dd").Replace(".", "") + "Click";
             sql.Append("insert overwrite table EveryDayConsume_Dealer_Keyword_L2 ");
            //sql.Append("select unix_timestamp('" + yesterday.ToShortDateString() + "') as ReportDate,vn.DealerId,vn.KeywordId,vn.Num as ViewNum,");
            //sql.Append("case when cn.num is null then 0L else  cn.num end  clicknum,");
            //sql.Append("case when vin.num is null then 0L else  vin.num end viewIpnum,");
            //sql.Append("case when cin.num  is null then 0L else  cin.num end  clickIpnum,");
            //sql.Append("unix_timestamp('" + DateTime.Now.ToShortDateString() + "') as createtime ");
            //sql.Append("From (select a.VendorId as DealerId,v.KeywordId,count(v.KeywordId) Num  from " + viewTable + " v join temp_adtxt a on a.Id=v.AdTxtId join temp_Keyword_L2 k on k.Id=v.KeywordId group by a.VendorId ,v.KeywordId) vn ");
            //sql.Append("join (select a.VendorId as DealerId,v.KeywordId,count(distinct v.Ip) Num  from " + viewTable + " v join temp_adtxt a on a.Id=v.AdTxtId join temp_Keyword_L2 k on k.Id=v.KeywordId group by a.VendorId ,v.KeywordId) vin on vn.DealerId=vin.DealerId and vn.KeywordId=vin.KeywordId ");
            //sql.Append("left outer join (select a.VendorId as DealerId,v.KeywordId,count(v.KeywordId) Num  from " + clickTable + " v join temp_adtxt a on a.Id=v.AdTxtId join temp_Keyword_L2 k on k.Id=v.KeywordId group by a.VendorId ,v.KeywordId) cn on vn.DealerId=cn.DealerId and vn.KeywordId=cn.KeywordId ");
            //sql.Append("Left outer join (select a.VendorId as DealerId,v.KeywordId,count(distinct v.Ip) Num  from " + clickTable + " v join temp_adtxt a on a.Id=v.AdTxtId join temp_Keyword_L2 k on k.Id=v.KeywordId group by a.VendorId ,v.KeywordId) cin on vn.DealerId=cin.DealerId and vn.KeywordId=cin.KeywordId ");
            //优化后
             sql.Append("SELECT '" + yesterday.ToString("yyyy-MM-dd HH:mm:ss.fffffff") + "' as ReportDate,V.VendorId as DealerId,V.KeywordId,");
             sql.Append("case when V.ViewNum is null then 0L else  V.ViewNum end  ViewNum,");
             sql.Append("case when C.ClickNum is null then 0L else  C.ClickNum end  clicknum,");
             sql.Append("case when V.ViewIpNum is null then 0L else  V.ViewIpNum end viewIpnum,");
             sql.Append("case when C.ClickIpNum is null then 0L else  C.ClickIpNum end  clickIpnum ");
            sql.Append("FROM ( SELECT VendorId,v.KeywordId,count(v.KeywordId) ViewNum,count(distinct Ip) ViewIpNum FROM " + viewTable + " v JOIN temp_adtxt a ON a.Id=v.AdTxtId 	GROUP BY VendorId ,v.KeywordId ) V ");
            sql.Append("LEFT OUTER JOIN ( SELECT VendorId,c.KeywordId,count(c.KeywordId) ClickNum,count(distinct Ip) ClickIpNum FROM " + clickTable + " c JOIN temp_adtxt a ON a.Id=c.AdTxtId  GROUP BY VendorId ,c.KeywordId ) C ON  V.VendorId=C.VendorId and V.KeywordId=C.KeywordId ");
            sql.Append("JOIN temp_Keyword_L2 K ON k.Id=V.KeywordId");
            LogService.LogService.Instance.Logger("执行hivesql:" + sql.ToString(), "hive");
        _daoInstance.Execute(sql.ToString());

            //var list = _daoInstance.SelectAllColunms(sql1.ToString());
            //StringBuilder con = new StringBuilder();
            //int i = 1;
            //list.ForEach(a =>
            //{
            //    con.Append("num:" + i.ToString() + "start:" + a + "\tEND\n");
            //    i++;
            //});
            //File.AppendAllText(@"D:\TestProject\hivetest\hivetxt\" + (i - 1).ToString() + ".txt", con.ToString());

            return true;
        }
        public string Export(DateTime statisticsdate)
        {
            LogService.LogService.Instance.Logger("从 EveryDayConsume_Dealer_Keyword_L2 向 temp_EveryDayConsume_Dealer_Keyword_L2 导数据.\n", "sqoop");
            var feedback = _daoInstance.ExportData("temp_EveryDayConsume_Dealer_Keyword_L2", "EveryDayConsume_Dealer_Keyword_L2");
            LogService.LogService.Instance.Logger("从 EveryDayConsume_Dealer_Keyword_L2 向 temp_EveryDayConsume_Dealer_Keyword_L2 导数据操作完成！\n", "sqoop");
            DatabaseDao.execute("Insert into EveryDayConsume_Dealer_Keyword_L2(ReportDate,DealerId,KeywordId,ViewNum,ClickNum,ViewIpNum,ClickIpNum) select * from temp_EveryDayConsume_Dealer_Keyword_L2");
            LogService.LogService.Instance.Logger("从 temp_EveryDayConsume_Dealer_Keyword_L2 向 EveryDayConsume_Dealer_Keyword_L2 导数据操作完成！\n", "sqoop");
            LogService.LogService.Instance.Logger(feedback + "\n", "sqoop");
            return feedback;

        }
    }
}
