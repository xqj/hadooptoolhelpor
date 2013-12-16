package centos.shell;


import java.io.IOException;
import java.util.List;

import org.apache.thrift.TException;

public class SqoopServiceImp implements SqoopThrift.Iface {
	private JavaShellUtil cmdHelper;	
	private String shellpath="/usr/local/sqoop/";
	public SqoopServiceImp(String shellbasepath,String shellLogPath){
		if(!shellbasepath.isEmpty()){
			shellpath=shellbasepath;
		}
		cmdHelper=new JavaShellUtil(shellLogPath);
	}	
	@Override
	public String ExportData(String host, String database, String userName,
			String password, String tableName, String hiveTaleb)
			throws TException {
		System.out.print("begin ExportData "+tableName+"\n");
		String feedback="";
		String shellCommand=shellpath+"bin/sqoop export --connect 'jdbc:sqlserver://"+host
		+";username="+userName+";password="+password+";database="+database+"' --table "+tableName+" --export-dir /user/hive/warehouse/"+hiveTaleb
		+" --input-fields-terminated-by '\t'";
		try {
			feedback=cmdHelper.executeShell(shellCommand);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print("ExportData over\n");
		return feedback;
	}

	@Override
	public String ExportDataUpdate(String host, String database,
			String userName, String password, String tableName,
			String hiveTaleb, String keyfield) throws TException {
		System.out.print("begin ExportDataUpdate "+tableName+"\n");
		String feedback="";
		String shellCommand=shellpath+"bin/sqoop export --connect 'jdbc:sqlserver://"+host
		+";username="+userName+";password="+password+";database="+database+"' --table "+tableName
		+" --update-key '"+keyfield+"' --export-dir /user/hive/warehouse/"+hiveTaleb+" --input-fields-terminated-by '\t'";
		try {
			feedback=cmdHelper.executeShell(shellCommand);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print("ExportDataUpdate over\n");
		return feedback;
	}

	@Override
	public String CreateTable(String host, String database,
			String userName, String password, String tableName,
			String hiveTaleb)
			throws TException {
		System.out.print("begin create hive table "+tableName+"\n");
		String feedback="";		
		String shellCommand=shellpath+"bin/sqoop create-hive-table --connect 'jdbc:sqlserver://"+host
		+";username="+userName+";password="+password+";database="+database+"' --table "+tableName+" --hive-table "+hiveTaleb;
		try {
			//System.out.print("cmd is run \n");
			feedback=cmdHelper.executeShell(shellCommand);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print("create hive table over\n");
		return feedback;
	}

	@Override
	public String ImportDataInHive(String host, String database,
			String userName, String password, String tableName,
			String hiveTaleb, String keyfield) throws TException {
		System.out.print("begin ImportDataInHive "+tableName+"\n");
		String feedback="";
		String shellCommand=shellpath+"bin/sqoop import --connect 'jdbc:sqlserver://"+host
		+";username="+userName+";password="+password+";database="+database+"' --table "+tableName+" --hive-import --hive-table "+hiveTaleb
		+" --split-by '"+keyfield+"'";
		try {
			feedback=cmdHelper.executeShell(shellCommand);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print("ImportDataInHive over\n");
		return feedback;
	}

	@Override
	public String ImportDataInHiveByWhere(String host, String database,
			String userName, String password, String tableName,
			String hiveTaleb, String where, List<String> columnNames,
			String keyfield) throws TException {
		System.out.print("begin ImportDataInHiveByWhere "+tableName+"\n");
		String fileds="";
		for(int i=0;i<columnNames.size();i++){
			fileds=fileds+","+columnNames.get(i);
		}
		if(fileds.length()>1)
			fileds=fileds.substring(1, fileds.length()-1);
		String feedback="";
		String shellCommand=shellpath+"bin/sqoop import --connect 'jdbc:sqlserver://"+host
		+";username="+userName+";password="+password+";database="+database+"' --table "+tableName+" --where '"+where+"' --columns '"+fileds
		+"' --hive-import --hive-table "+hiveTaleb
		+" --split-by '"+keyfield+"'";
		try {
			feedback=cmdHelper.executeShell(shellCommand);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print("ImportDataInHiveByWhere over\n");
		return feedback;
	}
	

	

}
