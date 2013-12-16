using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AdvDemo
{
    public class EveryDayConsumenServiceImp : IAdvServiceProvider
    {
       List<IEveryDayConsumeServiceProvider> doList;
       private static EveryDayConsumenServiceImp _instance = new EveryDayConsumenServiceImp();
       public static IAdvServiceProvider Instance
       {
           get
           {
               return _instance;
           }
       }
       private EveryDayConsumenServiceImp()
       {          
           doList = new List<IEveryDayConsumeServiceProvider>();
           doList.Add(EveryDayConsume_Vendor_SiteServiceImp.Instance);
           doList.Add(EveryDayConsume_Vendor_KeyWordServiceImp.Instance);
           doList.Add(EveryDayConsume_Vendor_AreaServiceImp.Instance);
           doList.Add(EveryDayConsume_Vendor_AdtxtServiceImp.Instance);
           doList.Add(EveryDayConsume_VendorServiceImp.Instance);
           doList.Add(EveryDayConsume_AdPutReportInfoServiceImp.Instance);
           doList.Add(EveryDayConsume_AD_AreaServiceImp.Instance);
           doList.Add(EveryDayConsume_Dealer_Keyword_L1ServiceImp.Instance);
           doList.Add(EveryDayConsume_Dealer_Keyword_L2ServiceImp.Instance);
           doList.Add(MemberSiteEveryDaySummaryServiceImp.Instance);
       }
       private void ImportData(DateTime importDate)
       {
           string viewTable = "AdTxt" + importDate.ToString("yyyy.MM.dd").Replace(".", "") + "View";
           string clickTable = "AdTxt" + importDate.ToString("yyyy.MM.dd").Replace(".", "") + "Click";
           List<string> talbes = new List<string>();
           talbes.Add(viewTable);
           talbes.Add(clickTable);
           Parallel.ForEach(talbes, e =>
           {
               LogService.LogService.Instance.Logger("创建表" + e + ".\n", "sqoop");             
                var message=ImportDataServiceImp.Instance.CreateTable(e, "db_autosense_logdata");
                LogService.LogService.Instance.Logger(message, "sqoop");
               LogService.LogService.Instance.Logger("导入表" + e + ".\n", "sqoop");
               var message1= ImportDataServiceImp.Instance.ImportData(e, "id", "db_autosense_logdata");
               LogService.LogService.Instance.Logger(message1, "sqoop");
           });
         
       }
       public void Count(DateTime statisticsdate)
       {
           ImportData(statisticsdate);
           int index = 0;
           //Parallel.ForEach(doList, e =>
           //{
           //    index++;
           //    //Console.WriteLine(index.ToString() + ":Execute\n");
           //    e.Execute(statisticsdate);
           //    //Console.WriteLine("Export");
           //    e.Export(statisticsdate);

           //});
          
          //doList.ForEach(a => { a.Execute(statisticsdate); });
          // doList.ForEach(a => { a.Export(statisticsdate); });
       }
    }
}
