using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Thrift.Transport;
using Thrift.Protocol;
using Apache.Hadoop.Hive;
using AdvDemo;
using System.Threading.Tasks;
using HiveService;
using DataConverionTool;

namespace hivedemo
{
    class Program
    {
        static void Main(string[] args)
        {
           // t1((DateTime.Parse("2012-04-23")));
         //t2();
            // t3();
           // t4();
           // t5();
        t6();
          
        }


        private static void t6()
        {
            List<string> columns=new List<string>();
            List<string> columns2=new List<string>();
             List<string> columns3=new List<string>();
            columns.Add("AdTxtId");
            columns.Add("Position");
            columns.Add("AdSiteId");
            columns.Add("AdDomainId");
            columns.Add("KeywordId");
            columns.Add("AdTxtTraceId");
            columns.Add("UnionId");
            columns.Add("KeywordPId");
            columns.Add("Url");
            columns.Add("Ip");
            columns2.Add("Url");
            columns2.Add("Ip");
            columns3.Add("CreateTime");
            MahoutService ms = new MahoutService();
            ms.ImportDataInMahout("adtxt20131128view", "mhadtxt20131128view", columns, "id", columns3, columns2, true);
            Console.Read();
        }

        private static void t5()
        {
             List<string> list=new List<string>();
            list.Add("select count(1) from adtxt20120423view");
            list.Add("select count(1) from temp_adsite");
            list.Add("select count(1) from temp_adtxt");
            list.Add("select count(1) from temp_area");
            list.Add("select count(1) from temp_areap");
            list.Add("select count(1) from temp_keyword");
            list.Add("select count(1) from temp_keyword_l1");
            list.Add("select count(1) from temp_keyword_l2");
            list.Add("select count(1) from adtxt20120423view");
            list.Add("select count(1) from temp_adsite");
            list.Add("select count(1) from temp_adtxt");
            list.Add("select count(1) from temp_area");
            list.Add("select count(1) from temp_areap");
            list.Add("select count(1) from temp_keyword");
            list.Add("select count(1) from temp_keyword_l1");
            list.Add("select count(1) from temp_keyword_l2");
            Parallel.ForEach(list,e=>t6(e));
        }
        private static void t6(string cmd)
        {
            HiveService.HiveService _daoInstance = new HiveService.HiveService("default", "default", @"192.168.87.62\SQL2005", "db_autosense_logmgr", "sa", "sa");
            _daoInstance.Execute(cmd);
            //var list=_daoInstance.SelectAllColunms(cmd);
            //list.ForEach(a =>
            //{
            //    Console.WriteLine(a+"\n");
            //});
        }
        private static void t4()
        {
            DateTime show = DateTime.Parse("2012-04-23");
            string s = show.ToString("yyyy-MM-dd HH:mm:ss.fffffff");
        }

        private static void t2()
        {
            DateTime starttime = DateTime.Now;
            EveryDayConsumenServiceImp.Instance.Count(DateTime.Parse("2013-11-28"));
            DateTime endtime = DateTime.Now;
            TimeSpan timecount = endtime - starttime;
            Console.WriteLine(timecount.ToString());
            Console.Read();
        }

        private static void t3()
        {

            Dictionary<string, string> tl = new Dictionary<string, string>();
            //tl.Add("temp_EveryDayConsume_AD_Area", "EveryDayConsume_AD_Area");
            //tl.Add("temp_EveryDayConsume_AD_City", "EveryDayConsume_AD_City");
            //tl.Add("temp_EveryDayConsume_AdPutReportInfo", "EveryDayConsume_AdPutReportInfo");
            //tl.Add("temp_EveryDayConsume_Dealer_Keyword_L1", "EveryDayConsume_Dealer_Keyword_L1");
            //tl.Add("temp_EveryDayConsume_Dealer_Keyword_L2", "EveryDayConsume_Dealer_Keyword_L2");
            //tl.Add("temp_EveryDayConsume_Vendor", "EveryDayConsume_Vendor");
            //tl.Add("temp_EveryDayConsume_Vendor_Adtxt", "EveryDayConsume_Vendor_Adtxt");
            //tl.Add("temp_EveryDayConsume_Vendor_Area", "EveryDayConsume_Vendor_Area");
            //tl.Add("temp_EveryDayConsume_Vendor_KeyWord", "EveryDayConsume_Vendor_KeyWord");
            //tl.Add("temp_EveryDayConsume_Vendor_Site", "EveryDayConsume_Vendor_Site");
            tl.Add("temp_AdSite", "temp_AdSite");
            tl.Add("temp_AdTxt", "temp_AdTxt");
            tl.Add("Temp_Area", "Temp_Area");
            tl.Add("temp_keyword", "temp_keyword");
            tl.Add("temp_Keyword_L1", "temp_Keyword_L1");
            tl.Add("temp_Keyword_L2", "temp_Keyword_L2");
           
            foreach (var kv in tl)
            {

                ImportDataServiceImp.Instance.CreateTable(kv.Key, "db_autosense_logmgr", kv.Value);
               ImportDataServiceImp.Instance.ImportData(kv.Key, "id", "db_autosense_logmgr", kv.Value);
            }
            ImportDataServiceImp.Instance.CreateTable("Temp_AreaP", "db_autosense_logmgr");
            ImportDataServiceImp.Instance.ImportData("Temp_AreaP", "areacodeid", "db_autosense_logmgr");
           
        }

        private static void t1(DateTime yesterday)
        {
            string viewTable = "AdTxt" + yesterday.ToString("yyyy.MM.dd").Replace(".", "") + "View";
            string clickTable = "AdTxt" + yesterday.ToString("yyyy.MM.dd").Replace(".", "") + "View";
          
            StringBuilder sql = new StringBuilder();
            sql.Append("select '" + yesterday.ToString("yyyy-MM-dd hh:mm:ss.fffffff") + "' as ReportDate,vn.DealerId,vn.KeywordPId,");
            sql.Append("case when vn.num is null then 0L else  cn.num end  ViewNum,");
            sql.Append("case when cn.num is null then 0L else  cn.num end  clicknum,");
            sql.Append("case when vin.num is null then 0L else  vin.num end viewIpnum,");
            sql.Append("case when cin.num is null then 0L else  cin.num end  clickIpnum ");
            //sql.Append("unix_timestamp('" + DateTime.Now.ToShortDateString() + "') as createtime ");
            sql.Append("From (select a.VendorId as DealerId,v.KeywordPId,count(v.KeywordPId) Num  from " + viewTable + " v join temp_adtxt a on a.Id=v.AdTxtId inner join temp_Keyword_L1 k on k.Id=v.KeywordId group by a.VendorId ,v.KeywordPId) vn ");
            sql.Append("join (select a.VendorId as DealerId,v.KeywordPId,count(distinct v.Ip) Num  from " + viewTable + " v join temp_adtxt a on a.Id=v.AdTxtId join temp_Keyword_L1 k on k.Id=v.KeywordId group by a.VendorId ,v.KeywordPId) vin on vn.DealerId=vin.DealerId and vn.KeywordPId=vin.KeywordPId ");
            sql.Append("left outer join (select a.VendorId as DealerId,v.KeywordPId,count(v.KeywordPId) Num  from " + clickTable + " v join temp_adtxt a on a.Id=v.AdTxtId join temp_Keyword_L1 k on k.Id=v.KeywordId group by a.VendorId ,v.KeywordPId) cn on vn.DealerId=cn.DealerId and vn.KeywordPId=cn.KeywordPId ");
            sql.Append("left outer join (select a.VendorId as DealerId,v.KeywordPId,count(distinct v.Ip) Num  from " + clickTable + " v join temp_adtxt a on a.Id=v.AdTxtId join temp_Keyword_L1 k on k.Id=v.KeywordId group by a.VendorId ,v.KeywordPId) cin on vn.DealerId=cin.DealerId and vn.KeywordPId=cin.KeywordPId limit 1");
            int port = 10000;
            var socket = new TSocket("192.168.87.64", port);
            var transport = new TBufferedTransport(socket);
            var proto = new TBinaryProtocol(transport);
            var client = new ThriftHive.Client(proto);
            transport.Open();
            client.execute(sql.ToString());
            var rows2 = client.fetchAll();
            transport.Close();


            rows2.ForEach(Console.WriteLine);
        }

       
    }
}
