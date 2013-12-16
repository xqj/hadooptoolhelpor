namespace java com.javabloger.gen.code
service SqoopThrift{   
string CreateTable(1:string host, 2:string database, 3:string userName, 4:string password, 5:string tableName, 6:string hiveTaleb)
string ImportDataInHive(1:string host, 2:string database, 3:string userName, 4:string password, 5:string tableName, 6:string hiveTaleb,7:string keyfield)
string ImportDataInHiveByWhere(1:string host, 2:string database, 3:string userName, 4:string password, 5:string tableName, 6:string hiveTaleb, 7:string where, 8:list<string> columnNames,9:string keyfield)
string ExportData(1:string host, 2:string database, 3:string userName, 4:string password, 5:string tableName, 6:string hiveTaleb)
string ExportDataUpdate(1:string host, 2:string database, 3:string userName, 4:string password, 5:string tableName, 6:string hiveTaleb,7:string keyfield)
}