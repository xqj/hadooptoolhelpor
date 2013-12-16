package centos.shell;

import java.io.IOException;

import org.apache.thrift.TException;

public class MahoutServiceImp implements MahoutThrift.Iface {
	private JavaShellUtil cmdHelper;
	private String shellpath = "/usr/local/mahout08/";

	public MahoutServiceImp(String shellbasepath, String shellLogPath) {
		if (!shellbasepath.isEmpty()) {
			shellpath = shellbasepath;
		}
		cmdHelper = new JavaShellUtil(shellLogPath);
	}

	@Override
	public String ImportDataInMahout(String hiveTableName, String mahoutTable)
			throws TException {
		System.out.print("begin ImportData " + hiveTableName + "\n");
		String feedback = "";
		String shellCommand = shellpath
				+ "bin/mahout org.apache.mahout.clustering.conversion.InputDriver -i /user/hive/warehouse/"
				+ hiveTableName + " -o /mahoutdata/" + mahoutTable
				+ " -v org.apache.mahout.math.DenseVector";
		try {
			feedback = cmdHelper.executeShell(shellCommand);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print("ImportData over\n");
		return feedback;
	}

	@Override
	public String ExportDataOutMahout(String hiveTableName, String mahoutTable) throws TException {
		System.out.print("begin ExportData " + hiveTableName + "\n");
		String feedback = "";
		String shellCommand = shellpath
				+ "bin/mahout clusterdump -i /user/hive/warehouse/"
				+ mahoutTable + " -o /data/mahout/" + hiveTableName
				+ ".txt -of TEXT ";
		try {
			feedback = cmdHelper.executeShell(shellCommand);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print("ExportData over\n");
		return feedback;
	}

}
