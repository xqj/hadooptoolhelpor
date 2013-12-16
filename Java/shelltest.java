import java.io.IOException;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TBinaryProtocol.Factory;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.server.TThreadPoolServer.Args;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

import centos.shell.MahoutServiceImp;
import centos.shell.MahoutThrift;
import centos.shell.SqoopServiceImp;
import centos.shell.SqoopThrift;



public class shelltest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {	
		//System.out.print("sqoop thrift server is start!\n");
		System.out.print("mahout thrift server is start!\n");
		//String logPath="/tmp/";
		String logPath="/data/mahout/";
		//String shellPath="/usr/local/sqoop/";
		String shellPath="/usr/local/mahout08/";
		if(args.length>1)
			shellPath=args[0];
		if(args.length==2)
			logPath=args[1];
		 startServer(shellPath,logPath);
			
	}
	public static void startServer(String shellpath,String logPath) {
        try {

            //TServerSocket serverTransport = new TServerSocket(18000);
        	TServerSocket serverTransport = new TServerSocket(18001);
            //SqoopThrift.Processor<SqoopServiceImp> process = new SqoopThrift.Processor<SqoopServiceImp>(new SqoopServiceImp(shellpath,logPath));
            MahoutThrift.Processor<MahoutServiceImp> process = new MahoutThrift.Processor<MahoutServiceImp>(new MahoutServiceImp(shellpath,logPath));

            Factory portFactory = new TBinaryProtocol.Factory(true, true);

            Args args = new Args(serverTransport);
            args.processor(process);
            args.protocolFactory(portFactory);

            TServer server = new TThreadPoolServer(args);
            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }


}
