using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;
using SystemConfig;

namespace AdvDemo
{
    internal class EveryDayConsume_Dealer_Keyword_L1ServiceImp : IEveryDayConsumeServiceProvider
    {
        private static EveryDayConsume_Dealer_Keyword_L1ServiceImp _instance = new EveryDayConsume_Dealer_Keyword_L1ServiceImp();
        private HiveService.HiveService _daoInstance;
        public static IEveryDayConsumeServiceProvider Instance
        {
            get
            {
                return _instance;
            }
        }
        private EveryDayConsume_Dealer_Keyword_L1ServiceImp()
        {
            var config = DatabaseConfigService.Instance.GetSqlServerConfig("db_autosense_logmgr");
            _daoInstance = new HiveService.HiveService("default", "default", config.Host, config.Database, config.UserName, config.Password);
        }

        public bool Execute(DateTime yesterday)
        {
            StringBuilder sql = new StringBuilder();
            string viewTable = "AdTxt" + yesterday.ToString("yyyy.MM.dd").Replace(".", "") + "View";
            string clickTable = "AdTxt" + yesterday.ToString("yyyy.MM.dd").Replace(".", "") + "Click";
            sql.Append("insert overwrite table EveryDayConsume_Dealer_Keyword_L1 ");
            sql.Append("select '" + yesterday.ToString("yyyy-MM-dd HH:mm:ss.fffffff") + "' as ReportDate,vn.DealerId,vn.KeywordPId,");
            sql.Append("case when vn.num is null then 0L else  vn.num end  ViewNum,");
            sql.Append("case when cn.num is null then 0L else  cn.num end  clicknum,");
            sql.Append("case when vin.num is null then 0L else  vin.num end viewIpnum,");
            sql.Append("case when cin.num is null then 0L else  cin.num end  clickIpnum ");
            //sql.Append("unix_timestamp('" + DateTime.Now.ToShortDateString() + "') as createtime ");
            sql.Append("From (select a.VendorId as DealerId,v.KeywordPId,count(v.KeywordPId) Num  from "+viewTable+" v join temp_adtxt a on a.Id=v.AdTxtId inner join temp_Keyword_L1 k on k.Id=v.KeywordId group by a.VendorId ,v.KeywordPId) vn ");
            sql.Append("join (select a.VendorId as DealerId,v.KeywordPId,count(distinct v.Ip) Num  from " + viewTable + " v join temp_adtxt a on a.Id=v.AdTxtId join temp_Keyword_L1 k on k.Id=v.KeywordId group by a.VendorId ,v.KeywordPId) vin on vn.DealerId=vin.DealerId and vn.KeywordPId=vin.KeywordPId ");
            sql.Append("left outer join (select a.VendorId as DealerId,v.KeywordPId,count(v.KeywordPId) Num  from " + clickTable + " v join temp_adtxt a on a.Id=v.AdTxtId join temp_Keyword_L1 k on k.Id=v.KeywordId group by a.VendorId ,v.KeywordPId) cn on vn.DealerId=cn.DealerId and vn.KeywordPId=cn.KeywordPId ");
            sql.Append("left outer join (select a.VendorId as DealerId,v.KeywordPId,count(distinct v.Ip) Num  from " + clickTable + " v join temp_adtxt a on a.Id=v.AdTxtId join temp_Keyword_L1 k on k.Id=v.KeywordId group by a.VendorId ,v.KeywordPId) cin on vn.DealerId=cin.DealerId and vn.KeywordPId=cin.KeywordPId ");
            LogService.LogService.Instance.Logger("执行hivesql:" + sql.ToString(), "hive");
            _daoInstance.Execute(sql.ToString());

            //var list = _daoInstance.SelectAllColunms(sql.ToString());
            //StringBuilder con = new StringBuilder();
            //int i = 1;
            //list.ForEach(a =>
            //{
            //    con.Append("num:" + i.ToString() + "start:" + a + "\tEND\n");
            //    i++;
            //});
            //File.AppendAllText(@"D:\TestProject\hivetest\hivetxt\" + yesterday.ToString("yyyy.MM.dd").Replace(".", "") + ".txt", con.ToString());

            return true;
        }
        public string Export(DateTime statisticsdate)
        {
            LogService.LogService.Instance.Logger("从 EveryDayConsume_Dealer_Keyword_L1 向 temp_EveryDayConsume_Dealer_Keyword_L1 导数据.\n", "sqoop");
            var feedback = _daoInstance.ExportData("temp_EveryDayConsume_Dealer_Keyword_L1", "EveryDayConsume_Dealer_Keyword_L1");
            LogService.LogService.Instance.Logger("从 EveryDayConsume_Dealer_Keyword_L1 向 temp_EveryDayConsume_Dealer_Keyword_L1 导数据操作完成！\n", "sqoop");
            DatabaseDao.execute("Insert into EveryDayConsume_Dealer_Keyword_L1(ReportDate,DealerId,KeywordPId,ViewNum,ClickNum,ViewIpNum,ClickIpNum) select * from temp_EveryDayConsume_Dealer_Keyword_L1");
            LogService.LogService.Instance.Logger("从 temp_EveryDayConsume_Dealer_Keyword_L1 向 EveryDayConsume_Dealer_Keyword_L1 导数据操作完成！\n", "sqoop");
            LogService.LogService.Instance.Logger(feedback + "\n", "sqoop");
            return feedback;
           
        }
    }
}
