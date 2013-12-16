package centos.shell;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JavaShellUtil {
	private static String basePath = "/tmp/";
	private static String executeShellLogFile;

	public JavaShellUtil(String logPath) {
		if (!logPath.isEmpty())
			basePath = logPath;
		executeShellLogFile = basePath + "executeShell";
	}

	public String executeShell(String shellCommand) throws IOException {
		StringBuffer stringBuffer = new StringBuffer();
		BufferedReader bufferedReader = null;
		BufferedReader errorReader = null;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS ");
		DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd-HH-mm-SS");

		try {
			stringBuffer.append(dateFormat.format(new Date()))
					.append("ready for cmd:").append(shellCommand)
					.append(" \r\n");
			Process pid = null;
			String[] cmd = { "/bin/bash", "-c", shellCommand };
			pid = Runtime.getRuntime().exec(cmd);
			if (pid != null) {
				stringBuffer.append("threadid:").append(pid.toString())
						.append("\r\n");
				errorReader = new BufferedReader(new InputStreamReader(
						pid.getErrorStream()));
				bufferedReader = new BufferedReader(new InputStreamReader(
						pid.getInputStream()));
				pid.waitFor();
			} else {
				stringBuffer.append("no pid\r\n");
			}
			stringBuffer.append(dateFormat.format(new Date())).append(
					"Shell is over\r\nfeed back\r\n");
			String line = null;
			while (bufferedReader != null
					&& (line = bufferedReader.readLine()) != null) {
				stringBuffer.append(line).append("\r\n");
			}
			while (errorReader != null
					&& (line = errorReader.readLine()) != null) {
				stringBuffer.append(line).append("\r\n");
			}
		} catch (Exception ioe) {
			stringBuffer.append("runing of exception\r\n")
					.append(ioe.getMessage()).append("\r\n");
		} finally {
			if (bufferedReader != null) {
				OutputStreamWriter outputStreamWriter = null;
				try {
					bufferedReader.close();
					errorReader.close();
					OutputStream outputStream = new FileOutputStream(
							executeShellLogFile
									+ dateFormat1.format(new Date()) + ".log");
					outputStreamWriter = new OutputStreamWriter(outputStream,
							"UTF-8");
					outputStreamWriter.write(stringBuffer.toString());
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					outputStreamWriter.close();
				}
			}
		}
		return stringBuffer.toString();
	}
}
