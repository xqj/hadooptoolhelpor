declare @targetcount int
declare @tempcount int
declare @temp int
select @targetcount=count(1) from dbo.EveryDayConsume_AD_Area
select @temp=count(1) from dbo.temp_EveryDayConsume_AD_Area
select @tempcount=count(1) from dbo.temp_EveryDayConsume_AD_Area a,dbo.EveryDayConsume_AD_Area b where a.AreaTitle=b.AreaTitle and a.VendorID=b.VendorID and a.AdTxtID=b.AdTxtID and  a.viewnum=b.viewnum and a.clicknum=b.clicknum and a.viewIpnum=b.viewIpnum and a.clickIpnum=b.clickIpnum
select @tempcount,@targetcount,@temp
if(@tempcount=@targetcount)
print 'EveryDayConsume_AD_Area is ok'
else 
print 'EveryDayConsume_AD_Area is wrong'

select @temp=count(1) from dbo.temp_EveryDayConsume_AdPutReportInfo
select @targetcount=count(1) from dbo.EveryDayConsume_AdPutReportInfo
select @tempcount=count(1) from dbo.temp_EveryDayConsume_AdPutReportInfo a,dbo.EveryDayConsume_AdPutReportInfo b where a.AdtxtId=b.AdtxtId and a.AdTxtTraceId=b.AdTxtTraceId and  a.viewnum=b.viewnum and a.clicknum=b.clicknum and a.viewIpnum=b.viewIpnum and a.clickIpnum=b.clickIpnum
select @tempcount,@targetcount,@temp
if(@tempcount=@targetcount)
print 'EveryDayConsume_AdPutReportInfo is ok'
else 
print 'EveryDayConsume_AdPutReportInfo is wrong'

select @temp=count(1) from dbo.temp_EveryDayConsume_Dealer_Keyword_L1
select @targetcount=count(1) from dbo.EveryDayConsume_Dealer_Keyword_L1
select @tempcount=count(1) from dbo.temp_EveryDayConsume_Dealer_Keyword_L1 a,dbo.EveryDayConsume_Dealer_Keyword_L1 b where a.DealerId=b.DealerId and a.KeywordPId=b.KeywordPId and a.viewnum=b.viewnum and a.clicknum=b.clicknum and a.viewIpnum=b.viewIpnum and a.clickIpnum=b.clickIpnum
select @tempcount,@targetcount,@temp
if(@tempcount=@targetcount)
print 'EveryDayConsume_Dealer_Keyword_L1 is ok'
else 
print 'EveryDayConsume_Dealer_Keyword_L1 is wrong'

select @temp=count(1) from dbo.temp_EveryDayConsume_Dealer_Keyword_L2
select @targetcount=count(1) from dbo.EveryDayConsume_Dealer_Keyword_L2
select @tempcount=count(1) from dbo.temp_EveryDayConsume_Dealer_Keyword_L2 a,dbo.EveryDayConsume_Dealer_Keyword_L2 b where a.DealerId=b.DealerId and a.KeywordId=b.KeywordId and a.viewnum=b.viewnum and a.clicknum=b.clicknum and a.viewIpnum=b.viewIpnum and a.clickIpnum=b.clickIpnum
select @tempcount,@targetcount,@temp
if(@tempcount=@targetcount)
print 'EveryDayConsume_Dealer_Keyword_L2 is ok'
else 
print 'EveryDayConsume_Dealer_Keyword_L2 is wrong'

select @temp=count(1) from dbo.temp_EveryDayConsume_Vendor
select @targetcount=count(1) from dbo.EveryDayConsume_Vendor
select @tempcount=count(1) from dbo.temp_EveryDayConsume_Vendor a,dbo.EveryDayConsume_Vendor b where a.VendorID=b.VendorID and a.viewnum=b.viewnum and a.clicknum=b.clicknum and a.viewIpnum=b.viewIpnum and a.clickIpnum=b.clickIpnum
select @tempcount,@targetcount,@temp
if(@tempcount=@targetcount)
print 'EveryDayConsume_Vendor is ok'
else 
print 'EveryDayConsume_Vendor is wrong'

select @temp=count(1) from dbo.temp_EveryDayConsume_Vendor_Adtxt
select @targetcount=count(1) from dbo.EveryDayConsume_Vendor_Adtxt
select @tempcount=count(1) from dbo.temp_EveryDayConsume_Vendor_Adtxt a,dbo.EveryDayConsume_Vendor_Adtxt b where a.AdtxtId=b.AdtxtId and a.VendorID=b.VendorID and a.viewnum=b.viewnum and a.clicknum=b.clicknum and a.viewIpnum=b.viewIpnum and a.clickIpnum=b.clickIpnum
select @tempcount,@targetcount,@temp
if(@tempcount=@targetcount)
print 'EveryDayConsume_Vendor_Adtxt is ok'
else 
print 'EveryDayConsume_Vendor_Adtxt is wrong'

select @temp=count(1) from dbo.temp_EveryDayConsume_Vendor_Area
select @targetcount=count(1) from dbo.EveryDayConsume_Vendor_Area
select @tempcount=count(1) from dbo.temp_EveryDayConsume_Vendor_Area a , dbo.EveryDayConsume_Vendor_Area b where a.AreaTitle=b.AreaTitle and a.VendorID=b.VendorID and a.viewnum=b.viewnum and a.clicknum=b.clicknum and a.viewIpnum=b.viewIpnum and a.clickIpnum=b.clickIpnum
select @tempcount,@targetcount,@temp
if(@tempcount=@targetcount)
print 'EveryDayConsume_Vendor_Area is ok'
else 
print 'EveryDayConsume_Vendor_Area is wrong'

select @temp=count(1) from dbo.temp_EveryDayConsume_Vendor_KeyWord
select @targetcount=count(1) from dbo.EveryDayConsume_Vendor_KeyWord
select @tempcount=count(1) from dbo.temp_EveryDayConsume_Vendor_KeyWord a ,dbo.EveryDayConsume_Vendor_KeyWord b where a.VendorID=b.VendorID and a.KeyWordTitle=b.KeyWordTitle and a.KeyWordId=b.KeyWordId and  a.viewnum=b.viewnum and a.clicknum=b.clicknum and a.viewIpnum=b.viewIpnum and a.clickIpnum=b.clickIpnum
select @tempcount,@targetcount,@temp
if(@tempcount=@targetcount)
print 'EveryDayConsume_Vendor_KeyWord is ok'
else 
print 'EveryDayConsume_Vendor_KeyWord is wrong'

select @temp=count(1) from dbo.temp_EveryDayConsume_Vendor_Site
select @targetcount=count(1) from dbo.EveryDayConsume_Vendor_Site
select @tempcount=count(1) from dbo.temp_EveryDayConsume_Vendor_Site a,dbo.EveryDayConsume_Vendor_Site b where a.VendorID=b.VendorID and a.SiteId=b.SiteId and a.SiteTitle=b.SiteTitle and  a.viewnum=b.viewnum and a.clicknum=b.clicknum and a.viewIpnum=b.viewIpnum and a.clickIpnum=b.clickIpnum
select @tempcount,@targetcount,@temp
if(@tempcount=@targetcount)
print 'EveryDayConsume_Vendor_Site is ok'
else 
print 'EveryDayConsume_Vendor_Site is wrong'

select @temp=count(1) from db_AutosenseUnion.dbo.temp_MemberSiteEveryDaySummary
select @targetcount=count(1) from db_AutosenseUnion.dbo.MemberSiteEveryDaySummary
select @tempcount=count(1) from db_AutosenseUnion.dbo.temp_MemberSiteEveryDaySummary a,db_AutosenseUnion.dbo.MemberSiteEveryDaySummary b where a.UnionMemberId=b.UnionMemberId and a.AdSiteId=b.AdSiteId and a.viewnum=b.viewnum and a.clicknum=b.clicknum and a.Ratio=b.Ratio and a.Income=b.Income and a.[Status]=b.[Status]
select @tempcount,@targetcount,@temp
if(@tempcount=@targetcount)
print 'MemberSiteEveryDaySummary is ok'
else 
print 'MemberSiteEveryDaySummary is wrong'

