package centos.shell;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SqoopThrift {

  public interface Iface {

    public String CreateTable(String host, String database, String userName, String password, String tableName, String hiveTaleb) throws org.apache.thrift.TException;

    public String ImportDataInHive(String host, String database, String userName, String password, String tableName, String hiveTaleb, String keyfield) throws org.apache.thrift.TException;

    public String ImportDataInHiveByWhere(String host, String database, String userName, String password, String tableName, String hiveTaleb, String where, List<String> columnNames, String keyfield) throws org.apache.thrift.TException;

    public String ExportData(String host, String database, String userName, String password, String tableName, String hiveTaleb) throws org.apache.thrift.TException;

    public String ExportDataUpdate(String host, String database, String userName, String password, String tableName, String hiveTaleb, String keyfield) throws org.apache.thrift.TException;

  }

  public interface AsyncIface {

    public void CreateTable(String host, String database, String userName, String password, String tableName, String hiveTaleb, org.apache.thrift.async.AsyncMethodCallback<AsyncClient.CreateTable_call> resultHandler) throws org.apache.thrift.TException;

    public void ImportDataInHive(String host, String database, String userName, String password, String tableName, String hiveTaleb, String keyfield, org.apache.thrift.async.AsyncMethodCallback<AsyncClient.ImportDataInHive_call> resultHandler) throws org.apache.thrift.TException;

    public void ImportDataInHiveByWhere(String host, String database, String userName, String password, String tableName, String hiveTaleb, String where, List<String> columnNames, String keyfield, org.apache.thrift.async.AsyncMethodCallback<AsyncClient.ImportDataInHiveByWhere_call> resultHandler) throws org.apache.thrift.TException;

    public void ExportData(String host, String database, String userName, String password, String tableName, String hiveTaleb, org.apache.thrift.async.AsyncMethodCallback<AsyncClient.ExportData_call> resultHandler) throws org.apache.thrift.TException;

    public void ExportDataUpdate(String host, String database, String userName, String password, String tableName, String hiveTaleb, String keyfield, org.apache.thrift.async.AsyncMethodCallback<AsyncClient.ExportDataUpdate_call> resultHandler) throws org.apache.thrift.TException;

  }

  public static class Client extends org.apache.thrift.TServiceClient implements Iface {
    public static class Factory implements org.apache.thrift.TServiceClientFactory<Client> {
      public Factory() {}
      public Client getClient(org.apache.thrift.protocol.TProtocol prot) {
        return new Client(prot);
      }
      public Client getClient(org.apache.thrift.protocol.TProtocol iprot, org.apache.thrift.protocol.TProtocol oprot) {
        return new Client(iprot, oprot);
      }
    }

    public Client(org.apache.thrift.protocol.TProtocol prot)
    {
      super(prot, prot);
    }

    public Client(org.apache.thrift.protocol.TProtocol iprot, org.apache.thrift.protocol.TProtocol oprot) {
      super(iprot, oprot);
    }

    public String CreateTable(String host, String database, String userName, String password, String tableName, String hiveTaleb) throws org.apache.thrift.TException
    {
      send_CreateTable(host, database, userName, password, tableName, hiveTaleb);
      return recv_CreateTable();
    }

    public void send_CreateTable(String host, String database, String userName, String password, String tableName, String hiveTaleb) throws org.apache.thrift.TException
    {
      CreateTable_args args = new CreateTable_args();
      args.setHost(host);
      args.setDatabase(database);
      args.setUserName(userName);
      args.setPassword(password);
      args.setTableName(tableName);
      args.setHiveTaleb(hiveTaleb);
      sendBase("CreateTable", args);
    }

    public String recv_CreateTable() throws org.apache.thrift.TException
    {
      CreateTable_result result = new CreateTable_result();
      receiveBase(result, "CreateTable");
      if (result.isSetSuccess()) {
        return result.success;
      }
      throw new org.apache.thrift.TApplicationException(org.apache.thrift.TApplicationException.MISSING_RESULT, "CreateTable failed: unknown result");
    }

    public String ImportDataInHive(String host, String database, String userName, String password, String tableName, String hiveTaleb, String keyfield) throws org.apache.thrift.TException
    {
      send_ImportDataInHive(host, database, userName, password, tableName, hiveTaleb, keyfield);
      return recv_ImportDataInHive();
    }

    public void send_ImportDataInHive(String host, String database, String userName, String password, String tableName, String hiveTaleb, String keyfield) throws org.apache.thrift.TException
    {
      ImportDataInHive_args args = new ImportDataInHive_args();
      args.setHost(host);
      args.setDatabase(database);
      args.setUserName(userName);
      args.setPassword(password);
      args.setTableName(tableName);
      args.setHiveTaleb(hiveTaleb);
      args.setKeyfield(keyfield);
      sendBase("ImportDataInHive", args);
    }

    public String recv_ImportDataInHive() throws org.apache.thrift.TException
    {
      ImportDataInHive_result result = new ImportDataInHive_result();
      receiveBase(result, "ImportDataInHive");
      if (result.isSetSuccess()) {
        return result.success;
      }
      throw new org.apache.thrift.TApplicationException(org.apache.thrift.TApplicationException.MISSING_RESULT, "ImportDataInHive failed: unknown result");
    }

    public String ImportDataInHiveByWhere(String host, String database, String userName, String password, String tableName, String hiveTaleb, String where, List<String> columnNames, String keyfield) throws org.apache.thrift.TException
    {
      send_ImportDataInHiveByWhere(host, database, userName, password, tableName, hiveTaleb, where, columnNames, keyfield);
      return recv_ImportDataInHiveByWhere();
    }

    public void send_ImportDataInHiveByWhere(String host, String database, String userName, String password, String tableName, String hiveTaleb, String where, List<String> columnNames, String keyfield) throws org.apache.thrift.TException
    {
      ImportDataInHiveByWhere_args args = new ImportDataInHiveByWhere_args();
      args.setHost(host);
      args.setDatabase(database);
      args.setUserName(userName);
      args.setPassword(password);
      args.setTableName(tableName);
      args.setHiveTaleb(hiveTaleb);
      args.setWhere(where);
      args.setColumnNames(columnNames);
      args.setKeyfield(keyfield);
      sendBase("ImportDataInHiveByWhere", args);
    }

    public String recv_ImportDataInHiveByWhere() throws org.apache.thrift.TException
    {
      ImportDataInHiveByWhere_result result = new ImportDataInHiveByWhere_result();
      receiveBase(result, "ImportDataInHiveByWhere");
      if (result.isSetSuccess()) {
        return result.success;
      }
      throw new org.apache.thrift.TApplicationException(org.apache.thrift.TApplicationException.MISSING_RESULT, "ImportDataInHiveByWhere failed: unknown result");
    }

    public String ExportData(String host, String database, String userName, String password, String tableName, String hiveTaleb) throws org.apache.thrift.TException
    {
      send_ExportData(host, database, userName, password, tableName, hiveTaleb);
      return recv_ExportData();
    }

    public void send_ExportData(String host, String database, String userName, String password, String tableName, String hiveTaleb) throws org.apache.thrift.TException
    {
      ExportData_args args = new ExportData_args();
      args.setHost(host);
      args.setDatabase(database);
      args.setUserName(userName);
      args.setPassword(password);
      args.setTableName(tableName);
      args.setHiveTaleb(hiveTaleb);
      sendBase("ExportData", args);
    }

    public String recv_ExportData() throws org.apache.thrift.TException
    {
      ExportData_result result = new ExportData_result();
      receiveBase(result, "ExportData");
      if (result.isSetSuccess()) {
        return result.success;
      }
      throw new org.apache.thrift.TApplicationException(org.apache.thrift.TApplicationException.MISSING_RESULT, "ExportData failed: unknown result");
    }

    public String ExportDataUpdate(String host, String database, String userName, String password, String tableName, String hiveTaleb, String keyfield) throws org.apache.thrift.TException
    {
      send_ExportDataUpdate(host, database, userName, password, tableName, hiveTaleb, keyfield);
      return recv_ExportDataUpdate();
    }

    public void send_ExportDataUpdate(String host, String database, String userName, String password, String tableName, String hiveTaleb, String keyfield) throws org.apache.thrift.TException
    {
      ExportDataUpdate_args args = new ExportDataUpdate_args();
      args.setHost(host);
      args.setDatabase(database);
      args.setUserName(userName);
      args.setPassword(password);
      args.setTableName(tableName);
      args.setHiveTaleb(hiveTaleb);
      args.setKeyfield(keyfield);
      sendBase("ExportDataUpdate", args);
    }

    public String recv_ExportDataUpdate() throws org.apache.thrift.TException
    {
      ExportDataUpdate_result result = new ExportDataUpdate_result();
      receiveBase(result, "ExportDataUpdate");
      if (result.isSetSuccess()) {
        return result.success;
      }
      throw new org.apache.thrift.TApplicationException(org.apache.thrift.TApplicationException.MISSING_RESULT, "ExportDataUpdate failed: unknown result");
    }

  }
  public static class AsyncClient extends org.apache.thrift.async.TAsyncClient implements AsyncIface {
    public static class Factory implements org.apache.thrift.async.TAsyncClientFactory<AsyncClient> {
      private org.apache.thrift.async.TAsyncClientManager clientManager;
      private org.apache.thrift.protocol.TProtocolFactory protocolFactory;
      public Factory(org.apache.thrift.async.TAsyncClientManager clientManager, org.apache.thrift.protocol.TProtocolFactory protocolFactory) {
        this.clientManager = clientManager;
        this.protocolFactory = protocolFactory;
      }
      public AsyncClient getAsyncClient(org.apache.thrift.transport.TNonblockingTransport transport) {
        return new AsyncClient(protocolFactory, clientManager, transport);
      }
    }

    public AsyncClient(org.apache.thrift.protocol.TProtocolFactory protocolFactory, org.apache.thrift.async.TAsyncClientManager clientManager, org.apache.thrift.transport.TNonblockingTransport transport) {
      super(protocolFactory, clientManager, transport);
    }

    public void CreateTable(String host, String database, String userName, String password, String tableName, String hiveTaleb, org.apache.thrift.async.AsyncMethodCallback<CreateTable_call> resultHandler) throws org.apache.thrift.TException {
      checkReady();
      CreateTable_call method_call = new CreateTable_call(host, database, userName, password, tableName, hiveTaleb, resultHandler, this, ___protocolFactory, ___transport);
      this.___currentMethod = method_call;
      ___manager.call(method_call);
    }

    public static class CreateTable_call extends org.apache.thrift.async.TAsyncMethodCall {
      private String host;
      private String database;
      private String userName;
      private String password;
      private String tableName;
      private String hiveTaleb;
      public CreateTable_call(String host, String database, String userName, String password, String tableName, String hiveTaleb, org.apache.thrift.async.AsyncMethodCallback<CreateTable_call> resultHandler, org.apache.thrift.async.TAsyncClient client, org.apache.thrift.protocol.TProtocolFactory protocolFactory, org.apache.thrift.transport.TNonblockingTransport transport) throws org.apache.thrift.TException {
        super(client, protocolFactory, transport, resultHandler, false);
        this.host = host;
        this.database = database;
        this.userName = userName;
        this.password = password;
        this.tableName = tableName;
        this.hiveTaleb = hiveTaleb;
      }

      public void write_args(org.apache.thrift.protocol.TProtocol prot) throws org.apache.thrift.TException {
        prot.writeMessageBegin(new org.apache.thrift.protocol.TMessage("CreateTable", org.apache.thrift.protocol.TMessageType.CALL, 0));
        CreateTable_args args = new CreateTable_args();
        args.setHost(host);
        args.setDatabase(database);
        args.setUserName(userName);
        args.setPassword(password);
        args.setTableName(tableName);
        args.setHiveTaleb(hiveTaleb);
        args.write(prot);
        prot.writeMessageEnd();
      }

      public String getResult() throws org.apache.thrift.TException {
        if (getState() != org.apache.thrift.async.TAsyncMethodCall.State.RESPONSE_READ) {
          throw new IllegalStateException("Method call not finished!");
        }
        org.apache.thrift.transport.TMemoryInputTransport memoryTransport = new org.apache.thrift.transport.TMemoryInputTransport(getFrameBuffer().array());
        org.apache.thrift.protocol.TProtocol prot = client.getProtocolFactory().getProtocol(memoryTransport);
        return (new Client(prot)).recv_CreateTable();
      }
    }

    public void ImportDataInHive(String host, String database, String userName, String password, String tableName, String hiveTaleb, String keyfield, org.apache.thrift.async.AsyncMethodCallback<ImportDataInHive_call> resultHandler) throws org.apache.thrift.TException {
      checkReady();
      ImportDataInHive_call method_call = new ImportDataInHive_call(host, database, userName, password, tableName, hiveTaleb, keyfield, resultHandler, this, ___protocolFactory, ___transport);
      this.___currentMethod = method_call;
      ___manager.call(method_call);
    }

    public static class ImportDataInHive_call extends org.apache.thrift.async.TAsyncMethodCall {
      private String host;
      private String database;
      private String userName;
      private String password;
      private String tableName;
      private String hiveTaleb;
      private String keyfield;
      public ImportDataInHive_call(String host, String database, String userName, String password, String tableName, String hiveTaleb, String keyfield, org.apache.thrift.async.AsyncMethodCallback<ImportDataInHive_call> resultHandler, org.apache.thrift.async.TAsyncClient client, org.apache.thrift.protocol.TProtocolFactory protocolFactory, org.apache.thrift.transport.TNonblockingTransport transport) throws org.apache.thrift.TException {
        super(client, protocolFactory, transport, resultHandler, false);
        this.host = host;
        this.database = database;
        this.userName = userName;
        this.password = password;
        this.tableName = tableName;
        this.hiveTaleb = hiveTaleb;
        this.keyfield = keyfield;
      }

      public void write_args(org.apache.thrift.protocol.TProtocol prot) throws org.apache.thrift.TException {
        prot.writeMessageBegin(new org.apache.thrift.protocol.TMessage("ImportDataInHive", org.apache.thrift.protocol.TMessageType.CALL, 0));
        ImportDataInHive_args args = new ImportDataInHive_args();
        args.setHost(host);
        args.setDatabase(database);
        args.setUserName(userName);
        args.setPassword(password);
        args.setTableName(tableName);
        args.setHiveTaleb(hiveTaleb);
        args.setKeyfield(keyfield);
        args.write(prot);
        prot.writeMessageEnd();
      }

      public String getResult() throws org.apache.thrift.TException {
        if (getState() != org.apache.thrift.async.TAsyncMethodCall.State.RESPONSE_READ) {
          throw new IllegalStateException("Method call not finished!");
        }
        org.apache.thrift.transport.TMemoryInputTransport memoryTransport = new org.apache.thrift.transport.TMemoryInputTransport(getFrameBuffer().array());
        org.apache.thrift.protocol.TProtocol prot = client.getProtocolFactory().getProtocol(memoryTransport);
        return (new Client(prot)).recv_ImportDataInHive();
      }
    }

    public void ImportDataInHiveByWhere(String host, String database, String userName, String password, String tableName, String hiveTaleb, String where, List<String> columnNames, String keyfield, org.apache.thrift.async.AsyncMethodCallback<ImportDataInHiveByWhere_call> resultHandler) throws org.apache.thrift.TException {
      checkReady();
      ImportDataInHiveByWhere_call method_call = new ImportDataInHiveByWhere_call(host, database, userName, password, tableName, hiveTaleb, where, columnNames, keyfield, resultHandler, this, ___protocolFactory, ___transport);
      this.___currentMethod = method_call;
      ___manager.call(method_call);
    }

    public static class ImportDataInHiveByWhere_call extends org.apache.thrift.async.TAsyncMethodCall {
      private String host;
      private String database;
      private String userName;
      private String password;
      private String tableName;
      private String hiveTaleb;
      private String where;
      private List<String> columnNames;
      private String keyfield;
      public ImportDataInHiveByWhere_call(String host, String database, String userName, String password, String tableName, String hiveTaleb, String where, List<String> columnNames, String keyfield, org.apache.thrift.async.AsyncMethodCallback<ImportDataInHiveByWhere_call> resultHandler, org.apache.thrift.async.TAsyncClient client, org.apache.thrift.protocol.TProtocolFactory protocolFactory, org.apache.thrift.transport.TNonblockingTransport transport) throws org.apache.thrift.TException {
        super(client, protocolFactory, transport, resultHandler, false);
        this.host = host;
        this.database = database;
        this.userName = userName;
        this.password = password;
        this.tableName = tableName;
        this.hiveTaleb = hiveTaleb;
        this.where = where;
        this.columnNames = columnNames;
        this.keyfield = keyfield;
      }

      public void write_args(org.apache.thrift.protocol.TProtocol prot) throws org.apache.thrift.TException {
        prot.writeMessageBegin(new org.apache.thrift.protocol.TMessage("ImportDataInHiveByWhere", org.apache.thrift.protocol.TMessageType.CALL, 0));
        ImportDataInHiveByWhere_args args = new ImportDataInHiveByWhere_args();
        args.setHost(host);
        args.setDatabase(database);
        args.setUserName(userName);
        args.setPassword(password);
        args.setTableName(tableName);
        args.setHiveTaleb(hiveTaleb);
        args.setWhere(where);
        args.setColumnNames(columnNames);
        args.setKeyfield(keyfield);
        args.write(prot);
        prot.writeMessageEnd();
      }

      public String getResult() throws org.apache.thrift.TException {
        if (getState() != org.apache.thrift.async.TAsyncMethodCall.State.RESPONSE_READ) {
          throw new IllegalStateException("Method call not finished!");
        }
        org.apache.thrift.transport.TMemoryInputTransport memoryTransport = new org.apache.thrift.transport.TMemoryInputTransport(getFrameBuffer().array());
        org.apache.thrift.protocol.TProtocol prot = client.getProtocolFactory().getProtocol(memoryTransport);
        return (new Client(prot)).recv_ImportDataInHiveByWhere();
      }
    }

    public void ExportData(String host, String database, String userName, String password, String tableName, String hiveTaleb, org.apache.thrift.async.AsyncMethodCallback<ExportData_call> resultHandler) throws org.apache.thrift.TException {
      checkReady();
      ExportData_call method_call = new ExportData_call(host, database, userName, password, tableName, hiveTaleb, resultHandler, this, ___protocolFactory, ___transport);
      this.___currentMethod = method_call;
      ___manager.call(method_call);
    }

    public static class ExportData_call extends org.apache.thrift.async.TAsyncMethodCall {
      private String host;
      private String database;
      private String userName;
      private String password;
      private String tableName;
      private String hiveTaleb;
      public ExportData_call(String host, String database, String userName, String password, String tableName, String hiveTaleb, org.apache.thrift.async.AsyncMethodCallback<ExportData_call> resultHandler, org.apache.thrift.async.TAsyncClient client, org.apache.thrift.protocol.TProtocolFactory protocolFactory, org.apache.thrift.transport.TNonblockingTransport transport) throws org.apache.thrift.TException {
        super(client, protocolFactory, transport, resultHandler, false);
        this.host = host;
        this.database = database;
        this.userName = userName;
        this.password = password;
        this.tableName = tableName;
        this.hiveTaleb = hiveTaleb;
      }

      public void write_args(org.apache.thrift.protocol.TProtocol prot) throws org.apache.thrift.TException {
        prot.writeMessageBegin(new org.apache.thrift.protocol.TMessage("ExportData", org.apache.thrift.protocol.TMessageType.CALL, 0));
        ExportData_args args = new ExportData_args();
        args.setHost(host);
        args.setDatabase(database);
        args.setUserName(userName);
        args.setPassword(password);
        args.setTableName(tableName);
        args.setHiveTaleb(hiveTaleb);
        args.write(prot);
        prot.writeMessageEnd();
      }

      public String getResult() throws org.apache.thrift.TException {
        if (getState() != org.apache.thrift.async.TAsyncMethodCall.State.RESPONSE_READ) {
          throw new IllegalStateException("Method call not finished!");
        }
        org.apache.thrift.transport.TMemoryInputTransport memoryTransport = new org.apache.thrift.transport.TMemoryInputTransport(getFrameBuffer().array());
        org.apache.thrift.protocol.TProtocol prot = client.getProtocolFactory().getProtocol(memoryTransport);
        return (new Client(prot)).recv_ExportData();
      }
    }

    public void ExportDataUpdate(String host, String database, String userName, String password, String tableName, String hiveTaleb, String keyfield, org.apache.thrift.async.AsyncMethodCallback<ExportDataUpdate_call> resultHandler) throws org.apache.thrift.TException {
      checkReady();
      ExportDataUpdate_call method_call = new ExportDataUpdate_call(host, database, userName, password, tableName, hiveTaleb, keyfield, resultHandler, this, ___protocolFactory, ___transport);
      this.___currentMethod = method_call;
      ___manager.call(method_call);
    }

    public static class ExportDataUpdate_call extends org.apache.thrift.async.TAsyncMethodCall {
      private String host;
      private String database;
      private String userName;
      private String password;
      private String tableName;
      private String hiveTaleb;
      private String keyfield;
      public ExportDataUpdate_call(String host, String database, String userName, String password, String tableName, String hiveTaleb, String keyfield, org.apache.thrift.async.AsyncMethodCallback<ExportDataUpdate_call> resultHandler, org.apache.thrift.async.TAsyncClient client, org.apache.thrift.protocol.TProtocolFactory protocolFactory, org.apache.thrift.transport.TNonblockingTransport transport) throws org.apache.thrift.TException {
        super(client, protocolFactory, transport, resultHandler, false);
        this.host = host;
        this.database = database;
        this.userName = userName;
        this.password = password;
        this.tableName = tableName;
        this.hiveTaleb = hiveTaleb;
        this.keyfield = keyfield;
      }

      public void write_args(org.apache.thrift.protocol.TProtocol prot) throws org.apache.thrift.TException {
        prot.writeMessageBegin(new org.apache.thrift.protocol.TMessage("ExportDataUpdate", org.apache.thrift.protocol.TMessageType.CALL, 0));
        ExportDataUpdate_args args = new ExportDataUpdate_args();
        args.setHost(host);
        args.setDatabase(database);
        args.setUserName(userName);
        args.setPassword(password);
        args.setTableName(tableName);
        args.setHiveTaleb(hiveTaleb);
        args.setKeyfield(keyfield);
        args.write(prot);
        prot.writeMessageEnd();
      }

      public String getResult() throws org.apache.thrift.TException {
        if (getState() != org.apache.thrift.async.TAsyncMethodCall.State.RESPONSE_READ) {
          throw new IllegalStateException("Method call not finished!");
        }
        org.apache.thrift.transport.TMemoryInputTransport memoryTransport = new org.apache.thrift.transport.TMemoryInputTransport(getFrameBuffer().array());
        org.apache.thrift.protocol.TProtocol prot = client.getProtocolFactory().getProtocol(memoryTransport);
        return (new Client(prot)).recv_ExportDataUpdate();
      }
    }

  }

  public static class Processor<I extends Iface> extends org.apache.thrift.TBaseProcessor<I> implements org.apache.thrift.TProcessor {
    private static final Logger LOGGER = LoggerFactory.getLogger(Processor.class.getName());
    public Processor(I iface) {
      super(iface, getProcessMap(new HashMap<String, org.apache.thrift.ProcessFunction<I, ? extends org.apache.thrift.TBase>>()));
    }

    protected Processor(I iface, Map<String,  org.apache.thrift.ProcessFunction<I, ? extends  org.apache.thrift.TBase>> processMap) {
      super(iface, getProcessMap(processMap));
    }

    private static <I extends Iface> Map<String,  org.apache.thrift.ProcessFunction<I, ? extends  org.apache.thrift.TBase>> getProcessMap(Map<String,  org.apache.thrift.ProcessFunction<I, ? extends  org.apache.thrift.TBase>> processMap) {
      processMap.put("CreateTable", new CreateTable());
      processMap.put("ImportDataInHive", new ImportDataInHive());
      processMap.put("ImportDataInHiveByWhere", new ImportDataInHiveByWhere());
      processMap.put("ExportData", new ExportData());
      processMap.put("ExportDataUpdate", new ExportDataUpdate());
      return processMap;
    }

    public static class CreateTable<I extends Iface> extends org.apache.thrift.ProcessFunction<I, CreateTable_args> {
      public CreateTable() {
        super("CreateTable");
      }

      public CreateTable_args getEmptyArgsInstance() {
        return new CreateTable_args();
      }

      protected boolean isOneway() {
        return false;
      }

      public CreateTable_result getResult(I iface, CreateTable_args args) throws org.apache.thrift.TException {
        CreateTable_result result = new CreateTable_result();
        result.success = iface.CreateTable(args.host, args.database, args.userName, args.password, args.tableName, args.hiveTaleb);
        return result;
      }
    }

    public static class ImportDataInHive<I extends Iface> extends org.apache.thrift.ProcessFunction<I, ImportDataInHive_args> {
      public ImportDataInHive() {
        super("ImportDataInHive");
      }

      public ImportDataInHive_args getEmptyArgsInstance() {
        return new ImportDataInHive_args();
      }

      protected boolean isOneway() {
        return false;
      }

      public ImportDataInHive_result getResult(I iface, ImportDataInHive_args args) throws org.apache.thrift.TException {
        ImportDataInHive_result result = new ImportDataInHive_result();
        result.success = iface.ImportDataInHive(args.host, args.database, args.userName, args.password, args.tableName, args.hiveTaleb, args.keyfield);
        return result;
      }
    }

    public static class ImportDataInHiveByWhere<I extends Iface> extends org.apache.thrift.ProcessFunction<I, ImportDataInHiveByWhere_args> {
      public ImportDataInHiveByWhere() {
        super("ImportDataInHiveByWhere");
      }

      public ImportDataInHiveByWhere_args getEmptyArgsInstance() {
        return new ImportDataInHiveByWhere_args();
      }

      protected boolean isOneway() {
        return false;
      }

      public ImportDataInHiveByWhere_result getResult(I iface, ImportDataInHiveByWhere_args args) throws org.apache.thrift.TException {
        ImportDataInHiveByWhere_result result = new ImportDataInHiveByWhere_result();
        result.success = iface.ImportDataInHiveByWhere(args.host, args.database, args.userName, args.password, args.tableName, args.hiveTaleb, args.where, args.columnNames, args.keyfield);
        return result;
      }
    }

    public static class ExportData<I extends Iface> extends org.apache.thrift.ProcessFunction<I, ExportData_args> {
      public ExportData() {
        super("ExportData");
      }

      public ExportData_args getEmptyArgsInstance() {
        return new ExportData_args();
      }

      protected boolean isOneway() {
        return false;
      }

      public ExportData_result getResult(I iface, ExportData_args args) throws org.apache.thrift.TException {
        ExportData_result result = new ExportData_result();
        result.success = iface.ExportData(args.host, args.database, args.userName, args.password, args.tableName, args.hiveTaleb);
        return result;
      }
    }

    public static class ExportDataUpdate<I extends Iface> extends org.apache.thrift.ProcessFunction<I, ExportDataUpdate_args> {
      public ExportDataUpdate() {
        super("ExportDataUpdate");
      }

      public ExportDataUpdate_args getEmptyArgsInstance() {
        return new ExportDataUpdate_args();
      }

      protected boolean isOneway() {
        return false;
      }

      public ExportDataUpdate_result getResult(I iface, ExportDataUpdate_args args) throws org.apache.thrift.TException {
        ExportDataUpdate_result result = new ExportDataUpdate_result();
        result.success = iface.ExportDataUpdate(args.host, args.database, args.userName, args.password, args.tableName, args.hiveTaleb, args.keyfield);
        return result;
      }
    }

  }

  public static class CreateTable_args implements org.apache.thrift.TBase<CreateTable_args, CreateTable_args._Fields>, java.io.Serializable, Cloneable   {
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("CreateTable_args");

    private static final org.apache.thrift.protocol.TField HOST_FIELD_DESC = new org.apache.thrift.protocol.TField("host", org.apache.thrift.protocol.TType.STRING, (short)1);
    private static final org.apache.thrift.protocol.TField DATABASE_FIELD_DESC = new org.apache.thrift.protocol.TField("database", org.apache.thrift.protocol.TType.STRING, (short)2);
    private static final org.apache.thrift.protocol.TField USER_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("userName", org.apache.thrift.protocol.TType.STRING, (short)3);
    private static final org.apache.thrift.protocol.TField PASSWORD_FIELD_DESC = new org.apache.thrift.protocol.TField("password", org.apache.thrift.protocol.TType.STRING, (short)4);
    private static final org.apache.thrift.protocol.TField TABLE_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("tableName", org.apache.thrift.protocol.TType.STRING, (short)5);
    private static final org.apache.thrift.protocol.TField HIVE_TALEB_FIELD_DESC = new org.apache.thrift.protocol.TField("hiveTaleb", org.apache.thrift.protocol.TType.STRING, (short)6);

    private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
    static {
      schemes.put(StandardScheme.class, new CreateTable_argsStandardSchemeFactory());
      schemes.put(TupleScheme.class, new CreateTable_argsTupleSchemeFactory());
    }

    public String host; // required
    public String database; // required
    public String userName; // required
    public String password; // required
    public String tableName; // required
    public String hiveTaleb; // required

    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
      HOST((short)1, "host"),
      DATABASE((short)2, "database"),
      USER_NAME((short)3, "userName"),
      PASSWORD((short)4, "password"),
      TABLE_NAME((short)5, "tableName"),
      HIVE_TALEB((short)6, "hiveTaleb");

      private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

      static {
        for (_Fields field : EnumSet.allOf(_Fields.class)) {
          byName.put(field.getFieldName(), field);
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, or null if its not found.
       */
      public static _Fields findByThriftId(int fieldId) {
        switch(fieldId) {
          case 1: // HOST
            return HOST;
          case 2: // DATABASE
            return DATABASE;
          case 3: // USER_NAME
            return USER_NAME;
          case 4: // PASSWORD
            return PASSWORD;
          case 5: // TABLE_NAME
            return TABLE_NAME;
          case 6: // HIVE_TALEB
            return HIVE_TALEB;
          default:
            return null;
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, throwing an exception
       * if it is not found.
       */
      public static _Fields findByThriftIdOrThrow(int fieldId) {
        _Fields fields = findByThriftId(fieldId);
        if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
        return fields;
      }

      /**
       * Find the _Fields constant that matches name, or null if its not found.
       */
      public static _Fields findByName(String name) {
        return byName.get(name);
      }

      private final short _thriftId;
      private final String _fieldName;

      _Fields(short thriftId, String fieldName) {
        _thriftId = thriftId;
        _fieldName = fieldName;
      }

      public short getThriftFieldId() {
        return _thriftId;
      }

      public String getFieldName() {
        return _fieldName;
      }
    }

    // isset id assignments
    public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
    static {
      Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
      tmpMap.put(_Fields.HOST, new org.apache.thrift.meta_data.FieldMetaData("host", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
      tmpMap.put(_Fields.DATABASE, new org.apache.thrift.meta_data.FieldMetaData("database", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
      tmpMap.put(_Fields.USER_NAME, new org.apache.thrift.meta_data.FieldMetaData("userName", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
      tmpMap.put(_Fields.PASSWORD, new org.apache.thrift.meta_data.FieldMetaData("password", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
      tmpMap.put(_Fields.TABLE_NAME, new org.apache.thrift.meta_data.FieldMetaData("tableName", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
      tmpMap.put(_Fields.HIVE_TALEB, new org.apache.thrift.meta_data.FieldMetaData("hiveTaleb", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
      metaDataMap = Collections.unmodifiableMap(tmpMap);
      org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(CreateTable_args.class, metaDataMap);
    }

    public CreateTable_args() {
    }

    public CreateTable_args(
      String host,
      String database,
      String userName,
      String password,
      String tableName,
      String hiveTaleb)
    {
      this();
      this.host = host;
      this.database = database;
      this.userName = userName;
      this.password = password;
      this.tableName = tableName;
      this.hiveTaleb = hiveTaleb;
    }

    /**
     * Performs a deep copy on <i>other</i>.
     */
    public CreateTable_args(CreateTable_args other) {
      if (other.isSetHost()) {
        this.host = other.host;
      }
      if (other.isSetDatabase()) {
        this.database = other.database;
      }
      if (other.isSetUserName()) {
        this.userName = other.userName;
      }
      if (other.isSetPassword()) {
        this.password = other.password;
      }
      if (other.isSetTableName()) {
        this.tableName = other.tableName;
      }
      if (other.isSetHiveTaleb()) {
        this.hiveTaleb = other.hiveTaleb;
      }
    }

    public CreateTable_args deepCopy() {
      return new CreateTable_args(this);
    }

    @Override
    public void clear() {
      this.host = null;
      this.database = null;
      this.userName = null;
      this.password = null;
      this.tableName = null;
      this.hiveTaleb = null;
    }

    public String getHost() {
      return this.host;
    }

    public CreateTable_args setHost(String host) {
      this.host = host;
      return this;
    }

    public void unsetHost() {
      this.host = null;
    }

    /** Returns true if field host is set (has been assigned a value) and false otherwise */
    public boolean isSetHost() {
      return this.host != null;
    }

    public void setHostIsSet(boolean value) {
      if (!value) {
        this.host = null;
      }
    }

    public String getDatabase() {
      return this.database;
    }

    public CreateTable_args setDatabase(String database) {
      this.database = database;
      return this;
    }

    public void unsetDatabase() {
      this.database = null;
    }

    /** Returns true if field database is set (has been assigned a value) and false otherwise */
    public boolean isSetDatabase() {
      return this.database != null;
    }

    public void setDatabaseIsSet(boolean value) {
      if (!value) {
        this.database = null;
      }
    }

    public String getUserName() {
      return this.userName;
    }

    public CreateTable_args setUserName(String userName) {
      this.userName = userName;
      return this;
    }

    public void unsetUserName() {
      this.userName = null;
    }

    /** Returns true if field userName is set (has been assigned a value) and false otherwise */
    public boolean isSetUserName() {
      return this.userName != null;
    }

    public void setUserNameIsSet(boolean value) {
      if (!value) {
        this.userName = null;
      }
    }

    public String getPassword() {
      return this.password;
    }

    public CreateTable_args setPassword(String password) {
      this.password = password;
      return this;
    }

    public void unsetPassword() {
      this.password = null;
    }

    /** Returns true if field password is set (has been assigned a value) and false otherwise */
    public boolean isSetPassword() {
      return this.password != null;
    }

    public void setPasswordIsSet(boolean value) {
      if (!value) {
        this.password = null;
      }
    }

    public String getTableName() {
      return this.tableName;
    }

    public CreateTable_args setTableName(String tableName) {
      this.tableName = tableName;
      return this;
    }

    public void unsetTableName() {
      this.tableName = null;
    }

    /** Returns true if field tableName is set (has been assigned a value) and false otherwise */
    public boolean isSetTableName() {
      return this.tableName != null;
    }

    public void setTableNameIsSet(boolean value) {
      if (!value) {
        this.tableName = null;
      }
    }

    public String getHiveTaleb() {
      return this.hiveTaleb;
    }

    public CreateTable_args setHiveTaleb(String hiveTaleb) {
      this.hiveTaleb = hiveTaleb;
      return this;
    }

    public void unsetHiveTaleb() {
      this.hiveTaleb = null;
    }

    /** Returns true if field hiveTaleb is set (has been assigned a value) and false otherwise */
    public boolean isSetHiveTaleb() {
      return this.hiveTaleb != null;
    }

    public void setHiveTalebIsSet(boolean value) {
      if (!value) {
        this.hiveTaleb = null;
      }
    }

    public void setFieldValue(_Fields field, Object value) {
      switch (field) {
      case HOST:
        if (value == null) {
          unsetHost();
        } else {
          setHost((String)value);
        }
        break;

      case DATABASE:
        if (value == null) {
          unsetDatabase();
        } else {
          setDatabase((String)value);
        }
        break;

      case USER_NAME:
        if (value == null) {
          unsetUserName();
        } else {
          setUserName((String)value);
        }
        break;

      case PASSWORD:
        if (value == null) {
          unsetPassword();
        } else {
          setPassword((String)value);
        }
        break;

      case TABLE_NAME:
        if (value == null) {
          unsetTableName();
        } else {
          setTableName((String)value);
        }
        break;

      case HIVE_TALEB:
        if (value == null) {
          unsetHiveTaleb();
        } else {
          setHiveTaleb((String)value);
        }
        break;

      }
    }

    public Object getFieldValue(_Fields field) {
      switch (field) {
      case HOST:
        return getHost();

      case DATABASE:
        return getDatabase();

      case USER_NAME:
        return getUserName();

      case PASSWORD:
        return getPassword();

      case TABLE_NAME:
        return getTableName();

      case HIVE_TALEB:
        return getHiveTaleb();

      }
      throw new IllegalStateException();
    }

    /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
    public boolean isSet(_Fields field) {
      if (field == null) {
        throw new IllegalArgumentException();
      }

      switch (field) {
      case HOST:
        return isSetHost();
      case DATABASE:
        return isSetDatabase();
      case USER_NAME:
        return isSetUserName();
      case PASSWORD:
        return isSetPassword();
      case TABLE_NAME:
        return isSetTableName();
      case HIVE_TALEB:
        return isSetHiveTaleb();
      }
      throw new IllegalStateException();
    }

    @Override
    public boolean equals(Object that) {
      if (that == null)
        return false;
      if (that instanceof CreateTable_args)
        return this.equals((CreateTable_args)that);
      return false;
    }

    public boolean equals(CreateTable_args that) {
      if (that == null)
        return false;

      boolean this_present_host = true && this.isSetHost();
      boolean that_present_host = true && that.isSetHost();
      if (this_present_host || that_present_host) {
        if (!(this_present_host && that_present_host))
          return false;
        if (!this.host.equals(that.host))
          return false;
      }

      boolean this_present_database = true && this.isSetDatabase();
      boolean that_present_database = true && that.isSetDatabase();
      if (this_present_database || that_present_database) {
        if (!(this_present_database && that_present_database))
          return false;
        if (!this.database.equals(that.database))
          return false;
      }

      boolean this_present_userName = true && this.isSetUserName();
      boolean that_present_userName = true && that.isSetUserName();
      if (this_present_userName || that_present_userName) {
        if (!(this_present_userName && that_present_userName))
          return false;
        if (!this.userName.equals(that.userName))
          return false;
      }

      boolean this_present_password = true && this.isSetPassword();
      boolean that_present_password = true && that.isSetPassword();
      if (this_present_password || that_present_password) {
        if (!(this_present_password && that_present_password))
          return false;
        if (!this.password.equals(that.password))
          return false;
      }

      boolean this_present_tableName = true && this.isSetTableName();
      boolean that_present_tableName = true && that.isSetTableName();
      if (this_present_tableName || that_present_tableName) {
        if (!(this_present_tableName && that_present_tableName))
          return false;
        if (!this.tableName.equals(that.tableName))
          return false;
      }

      boolean this_present_hiveTaleb = true && this.isSetHiveTaleb();
      boolean that_present_hiveTaleb = true && that.isSetHiveTaleb();
      if (this_present_hiveTaleb || that_present_hiveTaleb) {
        if (!(this_present_hiveTaleb && that_present_hiveTaleb))
          return false;
        if (!this.hiveTaleb.equals(that.hiveTaleb))
          return false;
      }

      return true;
    }

    @Override
    public int hashCode() {
      return 0;
    }

    public int compareTo(CreateTable_args other) {
      if (!getClass().equals(other.getClass())) {
        return getClass().getName().compareTo(other.getClass().getName());
      }

      int lastComparison = 0;
      CreateTable_args typedOther = (CreateTable_args)other;

      lastComparison = Boolean.valueOf(isSetHost()).compareTo(typedOther.isSetHost());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetHost()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.host, typedOther.host);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      lastComparison = Boolean.valueOf(isSetDatabase()).compareTo(typedOther.isSetDatabase());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetDatabase()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.database, typedOther.database);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      lastComparison = Boolean.valueOf(isSetUserName()).compareTo(typedOther.isSetUserName());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetUserName()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.userName, typedOther.userName);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      lastComparison = Boolean.valueOf(isSetPassword()).compareTo(typedOther.isSetPassword());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetPassword()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.password, typedOther.password);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      lastComparison = Boolean.valueOf(isSetTableName()).compareTo(typedOther.isSetTableName());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetTableName()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.tableName, typedOther.tableName);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      lastComparison = Boolean.valueOf(isSetHiveTaleb()).compareTo(typedOther.isSetHiveTaleb());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetHiveTaleb()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.hiveTaleb, typedOther.hiveTaleb);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      return 0;
    }

    public _Fields fieldForId(int fieldId) {
      return _Fields.findByThriftId(fieldId);
    }

    public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
      schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
      schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder("CreateTable_args(");
      boolean first = true;

      sb.append("host:");
      if (this.host == null) {
        sb.append("null");
      } else {
        sb.append(this.host);
      }
      first = false;
      if (!first) sb.append(", ");
      sb.append("database:");
      if (this.database == null) {
        sb.append("null");
      } else {
        sb.append(this.database);
      }
      first = false;
      if (!first) sb.append(", ");
      sb.append("userName:");
      if (this.userName == null) {
        sb.append("null");
      } else {
        sb.append(this.userName);
      }
      first = false;
      if (!first) sb.append(", ");
      sb.append("password:");
      if (this.password == null) {
        sb.append("null");
      } else {
        sb.append(this.password);
      }
      first = false;
      if (!first) sb.append(", ");
      sb.append("tableName:");
      if (this.tableName == null) {
        sb.append("null");
      } else {
        sb.append(this.tableName);
      }
      first = false;
      if (!first) sb.append(", ");
      sb.append("hiveTaleb:");
      if (this.hiveTaleb == null) {
        sb.append("null");
      } else {
        sb.append(this.hiveTaleb);
      }
      first = false;
      sb.append(")");
      return sb.toString();
    }

    public void validate() throws org.apache.thrift.TException {
      // check for required fields
      // check for sub-struct validity
    }

    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
      try {
        write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
      } catch (org.apache.thrift.TException te) {
        throw new java.io.IOException(te);
      }
    }

    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
      try {
        read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
      } catch (org.apache.thrift.TException te) {
        throw new java.io.IOException(te);
      }
    }

    private static class CreateTable_argsStandardSchemeFactory implements SchemeFactory {
      public CreateTable_argsStandardScheme getScheme() {
        return new CreateTable_argsStandardScheme();
      }
    }

    private static class CreateTable_argsStandardScheme extends StandardScheme<CreateTable_args> {

      public void read(org.apache.thrift.protocol.TProtocol iprot, CreateTable_args struct) throws org.apache.thrift.TException {
        org.apache.thrift.protocol.TField schemeField;
        iprot.readStructBegin();
        while (true)
        {
          schemeField = iprot.readFieldBegin();
          if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
            break;
          }
          switch (schemeField.id) {
            case 1: // HOST
              if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                struct.host = iprot.readString();
                struct.setHostIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            case 2: // DATABASE
              if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                struct.database = iprot.readString();
                struct.setDatabaseIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            case 3: // USER_NAME
              if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                struct.userName = iprot.readString();
                struct.setUserNameIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            case 4: // PASSWORD
              if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                struct.password = iprot.readString();
                struct.setPasswordIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            case 5: // TABLE_NAME
              if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                struct.tableName = iprot.readString();
                struct.setTableNameIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            case 6: // HIVE_TALEB
              if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                struct.hiveTaleb = iprot.readString();
                struct.setHiveTalebIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            default:
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
          }
          iprot.readFieldEnd();
        }
        iprot.readStructEnd();

        // check for required fields of primitive type, which can't be checked in the validate method
        struct.validate();
      }

      public void write(org.apache.thrift.protocol.TProtocol oprot, CreateTable_args struct) throws org.apache.thrift.TException {
        struct.validate();

        oprot.writeStructBegin(STRUCT_DESC);
        if (struct.host != null) {
          oprot.writeFieldBegin(HOST_FIELD_DESC);
          oprot.writeString(struct.host);
          oprot.writeFieldEnd();
        }
        if (struct.database != null) {
          oprot.writeFieldBegin(DATABASE_FIELD_DESC);
          oprot.writeString(struct.database);
          oprot.writeFieldEnd();
        }
        if (struct.userName != null) {
          oprot.writeFieldBegin(USER_NAME_FIELD_DESC);
          oprot.writeString(struct.userName);
          oprot.writeFieldEnd();
        }
        if (struct.password != null) {
          oprot.writeFieldBegin(PASSWORD_FIELD_DESC);
          oprot.writeString(struct.password);
          oprot.writeFieldEnd();
        }
        if (struct.tableName != null) {
          oprot.writeFieldBegin(TABLE_NAME_FIELD_DESC);
          oprot.writeString(struct.tableName);
          oprot.writeFieldEnd();
        }
        if (struct.hiveTaleb != null) {
          oprot.writeFieldBegin(HIVE_TALEB_FIELD_DESC);
          oprot.writeString(struct.hiveTaleb);
          oprot.writeFieldEnd();
        }
        oprot.writeFieldStop();
        oprot.writeStructEnd();
      }

    }

    private static class CreateTable_argsTupleSchemeFactory implements SchemeFactory {
      public CreateTable_argsTupleScheme getScheme() {
        return new CreateTable_argsTupleScheme();
      }
    }

    private static class CreateTable_argsTupleScheme extends TupleScheme<CreateTable_args> {

      @Override
      public void write(org.apache.thrift.protocol.TProtocol prot, CreateTable_args struct) throws org.apache.thrift.TException {
        TTupleProtocol oprot = (TTupleProtocol) prot;
        BitSet optionals = new BitSet();
        if (struct.isSetHost()) {
          optionals.set(0);
        }
        if (struct.isSetDatabase()) {
          optionals.set(1);
        }
        if (struct.isSetUserName()) {
          optionals.set(2);
        }
        if (struct.isSetPassword()) {
          optionals.set(3);
        }
        if (struct.isSetTableName()) {
          optionals.set(4);
        }
        if (struct.isSetHiveTaleb()) {
          optionals.set(5);
        }
        oprot.writeBitSet(optionals, 6);
        if (struct.isSetHost()) {
          oprot.writeString(struct.host);
        }
        if (struct.isSetDatabase()) {
          oprot.writeString(struct.database);
        }
        if (struct.isSetUserName()) {
          oprot.writeString(struct.userName);
        }
        if (struct.isSetPassword()) {
          oprot.writeString(struct.password);
        }
        if (struct.isSetTableName()) {
          oprot.writeString(struct.tableName);
        }
        if (struct.isSetHiveTaleb()) {
          oprot.writeString(struct.hiveTaleb);
        }
      }

      @Override
      public void read(org.apache.thrift.protocol.TProtocol prot, CreateTable_args struct) throws org.apache.thrift.TException {
        TTupleProtocol iprot = (TTupleProtocol) prot;
        BitSet incoming = iprot.readBitSet(6);
        if (incoming.get(0)) {
          struct.host = iprot.readString();
          struct.setHostIsSet(true);
        }
        if (incoming.get(1)) {
          struct.database = iprot.readString();
          struct.setDatabaseIsSet(true);
        }
        if (incoming.get(2)) {
          struct.userName = iprot.readString();
          struct.setUserNameIsSet(true);
        }
        if (incoming.get(3)) {
          struct.password = iprot.readString();
          struct.setPasswordIsSet(true);
        }
        if (incoming.get(4)) {
          struct.tableName = iprot.readString();
          struct.setTableNameIsSet(true);
        }
        if (incoming.get(5)) {
          struct.hiveTaleb = iprot.readString();
          struct.setHiveTalebIsSet(true);
        }
      }
    }

  }

  public static class CreateTable_result implements org.apache.thrift.TBase<CreateTable_result, CreateTable_result._Fields>, java.io.Serializable, Cloneable   {
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("CreateTable_result");

    private static final org.apache.thrift.protocol.TField SUCCESS_FIELD_DESC = new org.apache.thrift.protocol.TField("success", org.apache.thrift.protocol.TType.STRING, (short)0);

    private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
    static {
      schemes.put(StandardScheme.class, new CreateTable_resultStandardSchemeFactory());
      schemes.put(TupleScheme.class, new CreateTable_resultTupleSchemeFactory());
    }

    public String success; // required

    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
      SUCCESS((short)0, "success");

      private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

      static {
        for (_Fields field : EnumSet.allOf(_Fields.class)) {
          byName.put(field.getFieldName(), field);
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, or null if its not found.
       */
      public static _Fields findByThriftId(int fieldId) {
        switch(fieldId) {
          case 0: // SUCCESS
            return SUCCESS;
          default:
            return null;
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, throwing an exception
       * if it is not found.
       */
      public static _Fields findByThriftIdOrThrow(int fieldId) {
        _Fields fields = findByThriftId(fieldId);
        if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
        return fields;
      }

      /**
       * Find the _Fields constant that matches name, or null if its not found.
       */
      public static _Fields findByName(String name) {
        return byName.get(name);
      }

      private final short _thriftId;
      private final String _fieldName;

      _Fields(short thriftId, String fieldName) {
        _thriftId = thriftId;
        _fieldName = fieldName;
      }

      public short getThriftFieldId() {
        return _thriftId;
      }

      public String getFieldName() {
        return _fieldName;
      }
    }

    // isset id assignments
    public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
    static {
      Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
      tmpMap.put(_Fields.SUCCESS, new org.apache.thrift.meta_data.FieldMetaData("success", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
      metaDataMap = Collections.unmodifiableMap(tmpMap);
      org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(CreateTable_result.class, metaDataMap);
    }

    public CreateTable_result() {
    }

    public CreateTable_result(
      String success)
    {
      this();
      this.success = success;
    }

    /**
     * Performs a deep copy on <i>other</i>.
     */
    public CreateTable_result(CreateTable_result other) {
      if (other.isSetSuccess()) {
        this.success = other.success;
      }
    }

    public CreateTable_result deepCopy() {
      return new CreateTable_result(this);
    }

    @Override
    public void clear() {
      this.success = null;
    }

    public String getSuccess() {
      return this.success;
    }

    public CreateTable_result setSuccess(String success) {
      this.success = success;
      return this;
    }

    public void unsetSuccess() {
      this.success = null;
    }

    /** Returns true if field success is set (has been assigned a value) and false otherwise */
    public boolean isSetSuccess() {
      return this.success != null;
    }

    public void setSuccessIsSet(boolean value) {
      if (!value) {
        this.success = null;
      }
    }

    public void setFieldValue(_Fields field, Object value) {
      switch (field) {
      case SUCCESS:
        if (value == null) {
          unsetSuccess();
        } else {
          setSuccess((String)value);
        }
        break;

      }
    }

    public Object getFieldValue(_Fields field) {
      switch (field) {
      case SUCCESS:
        return getSuccess();

      }
      throw new IllegalStateException();
    }

    /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
    public boolean isSet(_Fields field) {
      if (field == null) {
        throw new IllegalArgumentException();
      }

      switch (field) {
      case SUCCESS:
        return isSetSuccess();
      }
      throw new IllegalStateException();
    }

    @Override
    public boolean equals(Object that) {
      if (that == null)
        return false;
      if (that instanceof CreateTable_result)
        return this.equals((CreateTable_result)that);
      return false;
    }

    public boolean equals(CreateTable_result that) {
      if (that == null)
        return false;

      boolean this_present_success = true && this.isSetSuccess();
      boolean that_present_success = true && that.isSetSuccess();
      if (this_present_success || that_present_success) {
        if (!(this_present_success && that_present_success))
          return false;
        if (!this.success.equals(that.success))
          return false;
      }

      return true;
    }

    @Override
    public int hashCode() {
      return 0;
    }

    public int compareTo(CreateTable_result other) {
      if (!getClass().equals(other.getClass())) {
        return getClass().getName().compareTo(other.getClass().getName());
      }

      int lastComparison = 0;
      CreateTable_result typedOther = (CreateTable_result)other;

      lastComparison = Boolean.valueOf(isSetSuccess()).compareTo(typedOther.isSetSuccess());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetSuccess()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.success, typedOther.success);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      return 0;
    }

    public _Fields fieldForId(int fieldId) {
      return _Fields.findByThriftId(fieldId);
    }

    public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
      schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
      schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
      }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder("CreateTable_result(");
      boolean first = true;

      sb.append("success:");
      if (this.success == null) {
        sb.append("null");
      } else {
        sb.append(this.success);
      }
      first = false;
      sb.append(")");
      return sb.toString();
    }

    public void validate() throws org.apache.thrift.TException {
      // check for required fields
      // check for sub-struct validity
    }

    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
      try {
        write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
      } catch (org.apache.thrift.TException te) {
        throw new java.io.IOException(te);
      }
    }

    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
      try {
        read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
      } catch (org.apache.thrift.TException te) {
        throw new java.io.IOException(te);
      }
    }

    private static class CreateTable_resultStandardSchemeFactory implements SchemeFactory {
      public CreateTable_resultStandardScheme getScheme() {
        return new CreateTable_resultStandardScheme();
      }
    }

    private static class CreateTable_resultStandardScheme extends StandardScheme<CreateTable_result> {

      public void read(org.apache.thrift.protocol.TProtocol iprot, CreateTable_result struct) throws org.apache.thrift.TException {
        org.apache.thrift.protocol.TField schemeField;
        iprot.readStructBegin();
        while (true)
        {
          schemeField = iprot.readFieldBegin();
          if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
            break;
          }
          switch (schemeField.id) {
            case 0: // SUCCESS
              if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                struct.success = iprot.readString();
                struct.setSuccessIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            default:
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
          }
          iprot.readFieldEnd();
        }
        iprot.readStructEnd();

        // check for required fields of primitive type, which can't be checked in the validate method
        struct.validate();
      }

      public void write(org.apache.thrift.protocol.TProtocol oprot, CreateTable_result struct) throws org.apache.thrift.TException {
        struct.validate();

        oprot.writeStructBegin(STRUCT_DESC);
        if (struct.success != null) {
          oprot.writeFieldBegin(SUCCESS_FIELD_DESC);
          oprot.writeString(struct.success);
          oprot.writeFieldEnd();
        }
        oprot.writeFieldStop();
        oprot.writeStructEnd();
      }

    }

    private static class CreateTable_resultTupleSchemeFactory implements SchemeFactory {
      public CreateTable_resultTupleScheme getScheme() {
        return new CreateTable_resultTupleScheme();
      }
    }

    private static class CreateTable_resultTupleScheme extends TupleScheme<CreateTable_result> {

      @Override
      public void write(org.apache.thrift.protocol.TProtocol prot, CreateTable_result struct) throws org.apache.thrift.TException {
        TTupleProtocol oprot = (TTupleProtocol) prot;
        BitSet optionals = new BitSet();
        if (struct.isSetSuccess()) {
          optionals.set(0);
        }
        oprot.writeBitSet(optionals, 1);
        if (struct.isSetSuccess()) {
          oprot.writeString(struct.success);
        }
      }

      @Override
      public void read(org.apache.thrift.protocol.TProtocol prot, CreateTable_result struct) throws org.apache.thrift.TException {
        TTupleProtocol iprot = (TTupleProtocol) prot;
        BitSet incoming = iprot.readBitSet(1);
        if (incoming.get(0)) {
          struct.success = iprot.readString();
          struct.setSuccessIsSet(true);
        }
      }
    }

  }

  public static class ImportDataInHive_args implements org.apache.thrift.TBase<ImportDataInHive_args, ImportDataInHive_args._Fields>, java.io.Serializable, Cloneable   {
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ImportDataInHive_args");

    private static final org.apache.thrift.protocol.TField HOST_FIELD_DESC = new org.apache.thrift.protocol.TField("host", org.apache.thrift.protocol.TType.STRING, (short)1);
    private static final org.apache.thrift.protocol.TField DATABASE_FIELD_DESC = new org.apache.thrift.protocol.TField("database", org.apache.thrift.protocol.TType.STRING, (short)2);
    private static final org.apache.thrift.protocol.TField USER_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("userName", org.apache.thrift.protocol.TType.STRING, (short)3);
    private static final org.apache.thrift.protocol.TField PASSWORD_FIELD_DESC = new org.apache.thrift.protocol.TField("password", org.apache.thrift.protocol.TType.STRING, (short)4);
    private static final org.apache.thrift.protocol.TField TABLE_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("tableName", org.apache.thrift.protocol.TType.STRING, (short)5);
    private static final org.apache.thrift.protocol.TField HIVE_TALEB_FIELD_DESC = new org.apache.thrift.protocol.TField("hiveTaleb", org.apache.thrift.protocol.TType.STRING, (short)6);
    private static final org.apache.thrift.protocol.TField KEYFIELD_FIELD_DESC = new org.apache.thrift.protocol.TField("keyfield", org.apache.thrift.protocol.TType.STRING, (short)7);

    private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
    static {
      schemes.put(StandardScheme.class, new ImportDataInHive_argsStandardSchemeFactory());
      schemes.put(TupleScheme.class, new ImportDataInHive_argsTupleSchemeFactory());
    }

    public String host; // required
    public String database; // required
    public String userName; // required
    public String password; // required
    public String tableName; // required
    public String hiveTaleb; // required
    public String keyfield; // required

    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
      HOST((short)1, "host"),
      DATABASE((short)2, "database"),
      USER_NAME((short)3, "userName"),
      PASSWORD((short)4, "password"),
      TABLE_NAME((short)5, "tableName"),
      HIVE_TALEB((short)6, "hiveTaleb"),
      KEYFIELD((short)7, "keyfield");

      private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

      static {
        for (_Fields field : EnumSet.allOf(_Fields.class)) {
          byName.put(field.getFieldName(), field);
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, or null if its not found.
       */
      public static _Fields findByThriftId(int fieldId) {
        switch(fieldId) {
          case 1: // HOST
            return HOST;
          case 2: // DATABASE
            return DATABASE;
          case 3: // USER_NAME
            return USER_NAME;
          case 4: // PASSWORD
            return PASSWORD;
          case 5: // TABLE_NAME
            return TABLE_NAME;
          case 6: // HIVE_TALEB
            return HIVE_TALEB;
          case 7: // KEYFIELD
            return KEYFIELD;
          default:
            return null;
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, throwing an exception
       * if it is not found.
       */
      public static _Fields findByThriftIdOrThrow(int fieldId) {
        _Fields fields = findByThriftId(fieldId);
        if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
        return fields;
      }

      /**
       * Find the _Fields constant that matches name, or null if its not found.
       */
      public static _Fields findByName(String name) {
        return byName.get(name);
      }

      private final short _thriftId;
      private final String _fieldName;

      _Fields(short thriftId, String fieldName) {
        _thriftId = thriftId;
        _fieldName = fieldName;
      }

      public short getThriftFieldId() {
        return _thriftId;
      }

      public String getFieldName() {
        return _fieldName;
      }
    }

    // isset id assignments
    public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
    static {
      Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
      tmpMap.put(_Fields.HOST, new org.apache.thrift.meta_data.FieldMetaData("host", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
      tmpMap.put(_Fields.DATABASE, new org.apache.thrift.meta_data.FieldMetaData("database", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
      tmpMap.put(_Fields.USER_NAME, new org.apache.thrift.meta_data.FieldMetaData("userName", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
      tmpMap.put(_Fields.PASSWORD, new org.apache.thrift.meta_data.FieldMetaData("password", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
      tmpMap.put(_Fields.TABLE_NAME, new org.apache.thrift.meta_data.FieldMetaData("tableName", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
      tmpMap.put(_Fields.HIVE_TALEB, new org.apache.thrift.meta_data.FieldMetaData("hiveTaleb", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
      tmpMap.put(_Fields.KEYFIELD, new org.apache.thrift.meta_data.FieldMetaData("keyfield", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
      metaDataMap = Collections.unmodifiableMap(tmpMap);
      org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ImportDataInHive_args.class, metaDataMap);
    }

    public ImportDataInHive_args() {
    }

    public ImportDataInHive_args(
      String host,
      String database,
      String userName,
      String password,
      String tableName,
      String hiveTaleb,
      String keyfield)
    {
      this();
      this.host = host;
      this.database = database;
      this.userName = userName;
      this.password = password;
      this.tableName = tableName;
      this.hiveTaleb = hiveTaleb;
      this.keyfield = keyfield;
    }

    /**
     * Performs a deep copy on <i>other</i>.
     */
    public ImportDataInHive_args(ImportDataInHive_args other) {
      if (other.isSetHost()) {
        this.host = other.host;
      }
      if (other.isSetDatabase()) {
        this.database = other.database;
      }
      if (other.isSetUserName()) {
        this.userName = other.userName;
      }
      if (other.isSetPassword()) {
        this.password = other.password;
      }
      if (other.isSetTableName()) {
        this.tableName = other.tableName;
      }
      if (other.isSetHiveTaleb()) {
        this.hiveTaleb = other.hiveTaleb;
      }
      if (other.isSetKeyfield()) {
        this.keyfield = other.keyfield;
      }
    }

    public ImportDataInHive_args deepCopy() {
      return new ImportDataInHive_args(this);
    }

    @Override
    public void clear() {
      this.host = null;
      this.database = null;
      this.userName = null;
      this.password = null;
      this.tableName = null;
      this.hiveTaleb = null;
      this.keyfield = null;
    }

    public String getHost() {
      return this.host;
    }

    public ImportDataInHive_args setHost(String host) {
      this.host = host;
      return this;
    }

    public void unsetHost() {
      this.host = null;
    }

    /** Returns true if field host is set (has been assigned a value) and false otherwise */
    public boolean isSetHost() {
      return this.host != null;
    }

    public void setHostIsSet(boolean value) {
      if (!value) {
        this.host = null;
      }
    }

    public String getDatabase() {
      return this.database;
    }

    public ImportDataInHive_args setDatabase(String database) {
      this.database = database;
      return this;
    }

    public void unsetDatabase() {
      this.database = null;
    }

    /** Returns true if field database is set (has been assigned a value) and false otherwise */
    public boolean isSetDatabase() {
      return this.database != null;
    }

    public void setDatabaseIsSet(boolean value) {
      if (!value) {
        this.database = null;
      }
    }

    public String getUserName() {
      return this.userName;
    }

    public ImportDataInHive_args setUserName(String userName) {
      this.userName = userName;
      return this;
    }

    public void unsetUserName() {
      this.userName = null;
    }

    /** Returns true if field userName is set (has been assigned a value) and false otherwise */
    public boolean isSetUserName() {
      return this.userName != null;
    }

    public void setUserNameIsSet(boolean value) {
      if (!value) {
        this.userName = null;
      }
    }

    public String getPassword() {
      return this.password;
    }

    public ImportDataInHive_args setPassword(String password) {
      this.password = password;
      return this;
    }

    public void unsetPassword() {
      this.password = null;
    }

    /** Returns true if field password is set (has been assigned a value) and false otherwise */
    public boolean isSetPassword() {
      return this.password != null;
    }

    public void setPasswordIsSet(boolean value) {
      if (!value) {
        this.password = null;
      }
    }

    public String getTableName() {
      return this.tableName;
    }

    public ImportDataInHive_args setTableName(String tableName) {
      this.tableName = tableName;
      return this;
    }

    public void unsetTableName() {
      this.tableName = null;
    }

    /** Returns true if field tableName is set (has been assigned a value) and false otherwise */
    public boolean isSetTableName() {
      return this.tableName != null;
    }

    public void setTableNameIsSet(boolean value) {
      if (!value) {
        this.tableName = null;
      }
    }

    public String getHiveTaleb() {
      return this.hiveTaleb;
    }

    public ImportDataInHive_args setHiveTaleb(String hiveTaleb) {
      this.hiveTaleb = hiveTaleb;
      return this;
    }

    public void unsetHiveTaleb() {
      this.hiveTaleb = null;
    }

    /** Returns true if field hiveTaleb is set (has been assigned a value) and false otherwise */
    public boolean isSetHiveTaleb() {
      return this.hiveTaleb != null;
    }

    public void setHiveTalebIsSet(boolean value) {
      if (!value) {
        this.hiveTaleb = null;
      }
    }

    public String getKeyfield() {
      return this.keyfield;
    }

    public ImportDataInHive_args setKeyfield(String keyfield) {
      this.keyfield = keyfield;
      return this;
    }

    public void unsetKeyfield() {
      this.keyfield = null;
    }

    /** Returns true if field keyfield is set (has been assigned a value) and false otherwise */
    public boolean isSetKeyfield() {
      return this.keyfield != null;
    }

    public void setKeyfieldIsSet(boolean value) {
      if (!value) {
        this.keyfield = null;
      }
    }

    public void setFieldValue(_Fields field, Object value) {
      switch (field) {
      case HOST:
        if (value == null) {
          unsetHost();
        } else {
          setHost((String)value);
        }
        break;

      case DATABASE:
        if (value == null) {
          unsetDatabase();
        } else {
          setDatabase((String)value);
        }
        break;

      case USER_NAME:
        if (value == null) {
          unsetUserName();
        } else {
          setUserName((String)value);
        }
        break;

      case PASSWORD:
        if (value == null) {
          unsetPassword();
        } else {
          setPassword((String)value);
        }
        break;

      case TABLE_NAME:
        if (value == null) {
          unsetTableName();
        } else {
          setTableName((String)value);
        }
        break;

      case HIVE_TALEB:
        if (value == null) {
          unsetHiveTaleb();
        } else {
          setHiveTaleb((String)value);
        }
        break;

      case KEYFIELD:
        if (value == null) {
          unsetKeyfield();
        } else {
          setKeyfield((String)value);
        }
        break;

      }
    }

    public Object getFieldValue(_Fields field) {
      switch (field) {
      case HOST:
        return getHost();

      case DATABASE:
        return getDatabase();

      case USER_NAME:
        return getUserName();

      case PASSWORD:
        return getPassword();

      case TABLE_NAME:
        return getTableName();

      case HIVE_TALEB:
        return getHiveTaleb();

      case KEYFIELD:
        return getKeyfield();

      }
      throw new IllegalStateException();
    }

    /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
    public boolean isSet(_Fields field) {
      if (field == null) {
        throw new IllegalArgumentException();
      }

      switch (field) {
      case HOST:
        return isSetHost();
      case DATABASE:
        return isSetDatabase();
      case USER_NAME:
        return isSetUserName();
      case PASSWORD:
        return isSetPassword();
      case TABLE_NAME:
        return isSetTableName();
      case HIVE_TALEB:
        return isSetHiveTaleb();
      case KEYFIELD:
        return isSetKeyfield();
      }
      throw new IllegalStateException();
    }

    @Override
    public boolean equals(Object that) {
      if (that == null)
        return false;
      if (that instanceof ImportDataInHive_args)
        return this.equals((ImportDataInHive_args)that);
      return false;
    }

    public boolean equals(ImportDataInHive_args that) {
      if (that == null)
        return false;

      boolean this_present_host = true && this.isSetHost();
      boolean that_present_host = true && that.isSetHost();
      if (this_present_host || that_present_host) {
        if (!(this_present_host && that_present_host))
          return false;
        if (!this.host.equals(that.host))
          return false;
      }

      boolean this_present_database = true && this.isSetDatabase();
      boolean that_present_database = true && that.isSetDatabase();
      if (this_present_database || that_present_database) {
        if (!(this_present_database && that_present_database))
          return false;
        if (!this.database.equals(that.database))
          return false;
      }

      boolean this_present_userName = true && this.isSetUserName();
      boolean that_present_userName = true && that.isSetUserName();
      if (this_present_userName || that_present_userName) {
        if (!(this_present_userName && that_present_userName))
          return false;
        if (!this.userName.equals(that.userName))
          return false;
      }

      boolean this_present_password = true && this.isSetPassword();
      boolean that_present_password = true && that.isSetPassword();
      if (this_present_password || that_present_password) {
        if (!(this_present_password && that_present_password))
          return false;
        if (!this.password.equals(that.password))
          return false;
      }

      boolean this_present_tableName = true && this.isSetTableName();
      boolean that_present_tableName = true && that.isSetTableName();
      if (this_present_tableName || that_present_tableName) {
        if (!(this_present_tableName && that_present_tableName))
          return false;
        if (!this.tableName.equals(that.tableName))
          return false;
      }

      boolean this_present_hiveTaleb = true && this.isSetHiveTaleb();
      boolean that_present_hiveTaleb = true && that.isSetHiveTaleb();
      if (this_present_hiveTaleb || that_present_hiveTaleb) {
        if (!(this_present_hiveTaleb && that_present_hiveTaleb))
          return false;
        if (!this.hiveTaleb.equals(that.hiveTaleb))
          return false;
      }

      boolean this_present_keyfield = true && this.isSetKeyfield();
      boolean that_present_keyfield = true && that.isSetKeyfield();
      if (this_present_keyfield || that_present_keyfield) {
        if (!(this_present_keyfield && that_present_keyfield))
          return false;
        if (!this.keyfield.equals(that.keyfield))
          return false;
      }

      return true;
    }

    @Override
    public int hashCode() {
      return 0;
    }

    public int compareTo(ImportDataInHive_args other) {
      if (!getClass().equals(other.getClass())) {
        return getClass().getName().compareTo(other.getClass().getName());
      }

      int lastComparison = 0;
      ImportDataInHive_args typedOther = (ImportDataInHive_args)other;

      lastComparison = Boolean.valueOf(isSetHost()).compareTo(typedOther.isSetHost());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetHost()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.host, typedOther.host);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      lastComparison = Boolean.valueOf(isSetDatabase()).compareTo(typedOther.isSetDatabase());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetDatabase()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.database, typedOther.database);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      lastComparison = Boolean.valueOf(isSetUserName()).compareTo(typedOther.isSetUserName());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetUserName()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.userName, typedOther.userName);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      lastComparison = Boolean.valueOf(isSetPassword()).compareTo(typedOther.isSetPassword());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetPassword()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.password, typedOther.password);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      lastComparison = Boolean.valueOf(isSetTableName()).compareTo(typedOther.isSetTableName());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetTableName()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.tableName, typedOther.tableName);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      lastComparison = Boolean.valueOf(isSetHiveTaleb()).compareTo(typedOther.isSetHiveTaleb());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetHiveTaleb()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.hiveTaleb, typedOther.hiveTaleb);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      lastComparison = Boolean.valueOf(isSetKeyfield()).compareTo(typedOther.isSetKeyfield());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetKeyfield()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.keyfield, typedOther.keyfield);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      return 0;
    }

    public _Fields fieldForId(int fieldId) {
      return _Fields.findByThriftId(fieldId);
    }

    public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
      schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
      schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder("ImportDataInHive_args(");
      boolean first = true;

      sb.append("host:");
      if (this.host == null) {
        sb.append("null");
      } else {
        sb.append(this.host);
      }
      first = false;
      if (!first) sb.append(", ");
      sb.append("database:");
      if (this.database == null) {
        sb.append("null");
      } else {
        sb.append(this.database);
      }
      first = false;
      if (!first) sb.append(", ");
      sb.append("userName:");
      if (this.userName == null) {
        sb.append("null");
      } else {
        sb.append(this.userName);
      }
      first = false;
      if (!first) sb.append(", ");
      sb.append("password:");
      if (this.password == null) {
        sb.append("null");
      } else {
        sb.append(this.password);
      }
      first = false;
      if (!first) sb.append(", ");
      sb.append("tableName:");
      if (this.tableName == null) {
        sb.append("null");
      } else {
        sb.append(this.tableName);
      }
      first = false;
      if (!first) sb.append(", ");
      sb.append("hiveTaleb:");
      if (this.hiveTaleb == null) {
        sb.append("null");
      } else {
        sb.append(this.hiveTaleb);
      }
      first = false;
      if (!first) sb.append(", ");
      sb.append("keyfield:");
      if (this.keyfield == null) {
        sb.append("null");
      } else {
        sb.append(this.keyfield);
      }
      first = false;
      sb.append(")");
      return sb.toString();
    }

    public void validate() throws org.apache.thrift.TException {
      // check for required fields
      // check for sub-struct validity
    }

    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
      try {
        write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
      } catch (org.apache.thrift.TException te) {
        throw new java.io.IOException(te);
      }
    }

    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
      try {
        read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
      } catch (org.apache.thrift.TException te) {
        throw new java.io.IOException(te);
      }
    }

    private static class ImportDataInHive_argsStandardSchemeFactory implements SchemeFactory {
      public ImportDataInHive_argsStandardScheme getScheme() {
        return new ImportDataInHive_argsStandardScheme();
      }
    }

    private static class ImportDataInHive_argsStandardScheme extends StandardScheme<ImportDataInHive_args> {

      public void read(org.apache.thrift.protocol.TProtocol iprot, ImportDataInHive_args struct) throws org.apache.thrift.TException {
        org.apache.thrift.protocol.TField schemeField;
        iprot.readStructBegin();
        while (true)
        {
          schemeField = iprot.readFieldBegin();
          if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
            break;
          }
          switch (schemeField.id) {
            case 1: // HOST
              if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                struct.host = iprot.readString();
                struct.setHostIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            case 2: // DATABASE
              if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                struct.database = iprot.readString();
                struct.setDatabaseIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            case 3: // USER_NAME
              if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                struct.userName = iprot.readString();
                struct.setUserNameIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            case 4: // PASSWORD
              if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                struct.password = iprot.readString();
                struct.setPasswordIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            case 5: // TABLE_NAME
              if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                struct.tableName = iprot.readString();
                struct.setTableNameIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            case 6: // HIVE_TALEB
              if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                struct.hiveTaleb = iprot.readString();
                struct.setHiveTalebIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            case 7: // KEYFIELD
              if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                struct.keyfield = iprot.readString();
                struct.setKeyfieldIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            default:
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
          }
          iprot.readFieldEnd();
        }
        iprot.readStructEnd();

        // check for required fields of primitive type, which can't be checked in the validate method
        struct.validate();
      }

      public void write(org.apache.thrift.protocol.TProtocol oprot, ImportDataInHive_args struct) throws org.apache.thrift.TException {
        struct.validate();

        oprot.writeStructBegin(STRUCT_DESC);
        if (struct.host != null) {
          oprot.writeFieldBegin(HOST_FIELD_DESC);
          oprot.writeString(struct.host);
          oprot.writeFieldEnd();
        }
        if (struct.database != null) {
          oprot.writeFieldBegin(DATABASE_FIELD_DESC);
          oprot.writeString(struct.database);
          oprot.writeFieldEnd();
        }
        if (struct.userName != null) {
          oprot.writeFieldBegin(USER_NAME_FIELD_DESC);
          oprot.writeString(struct.userName);
          oprot.writeFieldEnd();
        }
        if (struct.password != null) {
          oprot.writeFieldBegin(PASSWORD_FIELD_DESC);
          oprot.writeString(struct.password);
          oprot.writeFieldEnd();
        }
        if (struct.tableName != null) {
          oprot.writeFieldBegin(TABLE_NAME_FIELD_DESC);
          oprot.writeString(struct.tableName);
          oprot.writeFieldEnd();
        }
        if (struct.hiveTaleb != null) {
          oprot.writeFieldBegin(HIVE_TALEB_FIELD_DESC);
          oprot.writeString(struct.hiveTaleb);
          oprot.writeFieldEnd();
        }
        if (struct.keyfield != null) {
          oprot.writeFieldBegin(KEYFIELD_FIELD_DESC);
          oprot.writeString(struct.keyfield);
          oprot.writeFieldEnd();
        }
        oprot.writeFieldStop();
        oprot.writeStructEnd();
      }

    }

    private static class ImportDataInHive_argsTupleSchemeFactory implements SchemeFactory {
      public ImportDataInHive_argsTupleScheme getScheme() {
        return new ImportDataInHive_argsTupleScheme();
      }
    }

    private static class ImportDataInHive_argsTupleScheme extends TupleScheme<ImportDataInHive_args> {

      @Override
      public void write(org.apache.thrift.protocol.TProtocol prot, ImportDataInHive_args struct) throws org.apache.thrift.TException {
        TTupleProtocol oprot = (TTupleProtocol) prot;
        BitSet optionals = new BitSet();
        if (struct.isSetHost()) {
          optionals.set(0);
        }
        if (struct.isSetDatabase()) {
          optionals.set(1);
        }
        if (struct.isSetUserName()) {
          optionals.set(2);
        }
        if (struct.isSetPassword()) {
          optionals.set(3);
        }
        if (struct.isSetTableName()) {
          optionals.set(4);
        }
        if (struct.isSetHiveTaleb()) {
          optionals.set(5);
        }
        if (struct.isSetKeyfield()) {
          optionals.set(6);
        }
        oprot.writeBitSet(optionals, 7);
        if (struct.isSetHost()) {
          oprot.writeString(struct.host);
        }
        if (struct.isSetDatabase()) {
          oprot.writeString(struct.database);
        }
        if (struct.isSetUserName()) {
          oprot.writeString(struct.userName);
        }
        if (struct.isSetPassword()) {
          oprot.writeString(struct.password);
        }
        if (struct.isSetTableName()) {
          oprot.writeString(struct.tableName);
        }
        if (struct.isSetHiveTaleb()) {
          oprot.writeString(struct.hiveTaleb);
        }
        if (struct.isSetKeyfield()) {
          oprot.writeString(struct.keyfield);
        }
      }

      @Override
      public void read(org.apache.thrift.protocol.TProtocol prot, ImportDataInHive_args struct) throws org.apache.thrift.TException {
        TTupleProtocol iprot = (TTupleProtocol) prot;
        BitSet incoming = iprot.readBitSet(7);
        if (incoming.get(0)) {
          struct.host = iprot.readString();
          struct.setHostIsSet(true);
        }
        if (incoming.get(1)) {
          struct.database = iprot.readString();
          struct.setDatabaseIsSet(true);
        }
        if (incoming.get(2)) {
          struct.userName = iprot.readString();
          struct.setUserNameIsSet(true);
        }
        if (incoming.get(3)) {
          struct.password = iprot.readString();
          struct.setPasswordIsSet(true);
        }
        if (incoming.get(4)) {
          struct.tableName = iprot.readString();
          struct.setTableNameIsSet(true);
        }
        if (incoming.get(5)) {
          struct.hiveTaleb = iprot.readString();
          struct.setHiveTalebIsSet(true);
        }
        if (incoming.get(6)) {
          struct.keyfield = iprot.readString();
          struct.setKeyfieldIsSet(true);
        }
      }
    }

  }

  public static class ImportDataInHive_result implements org.apache.thrift.TBase<ImportDataInHive_result, ImportDataInHive_result._Fields>, java.io.Serializable, Cloneable   {
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ImportDataInHive_result");

    private static final org.apache.thrift.protocol.TField SUCCESS_FIELD_DESC = new org.apache.thrift.protocol.TField("success", org.apache.thrift.protocol.TType.STRING, (short)0);

    private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
    static {
      schemes.put(StandardScheme.class, new ImportDataInHive_resultStandardSchemeFactory());
      schemes.put(TupleScheme.class, new ImportDataInHive_resultTupleSchemeFactory());
    }

    public String success; // required

    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
      SUCCESS((short)0, "success");

      private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

      static {
        for (_Fields field : EnumSet.allOf(_Fields.class)) {
          byName.put(field.getFieldName(), field);
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, or null if its not found.
       */
      public static _Fields findByThriftId(int fieldId) {
        switch(fieldId) {
          case 0: // SUCCESS
            return SUCCESS;
          default:
            return null;
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, throwing an exception
       * if it is not found.
       */
      public static _Fields findByThriftIdOrThrow(int fieldId) {
        _Fields fields = findByThriftId(fieldId);
        if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
        return fields;
      }

      /**
       * Find the _Fields constant that matches name, or null if its not found.
       */
      public static _Fields findByName(String name) {
        return byName.get(name);
      }

      private final short _thriftId;
      private final String _fieldName;

      _Fields(short thriftId, String fieldName) {
        _thriftId = thriftId;
        _fieldName = fieldName;
      }

      public short getThriftFieldId() {
        return _thriftId;
      }

      public String getFieldName() {
        return _fieldName;
      }
    }

    // isset id assignments
    public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
    static {
      Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
      tmpMap.put(_Fields.SUCCESS, new org.apache.thrift.meta_data.FieldMetaData("success", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
      metaDataMap = Collections.unmodifiableMap(tmpMap);
      org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ImportDataInHive_result.class, metaDataMap);
    }

    public ImportDataInHive_result() {
    }

    public ImportDataInHive_result(
      String success)
    {
      this();
      this.success = success;
    }

    /**
     * Performs a deep copy on <i>other</i>.
     */
    public ImportDataInHive_result(ImportDataInHive_result other) {
      if (other.isSetSuccess()) {
        this.success = other.success;
      }
    }

    public ImportDataInHive_result deepCopy() {
      return new ImportDataInHive_result(this);
    }

    @Override
    public void clear() {
      this.success = null;
    }

    public String getSuccess() {
      return this.success;
    }

    public ImportDataInHive_result setSuccess(String success) {
      this.success = success;
      return this;
    }

    public void unsetSuccess() {
      this.success = null;
    }

    /** Returns true if field success is set (has been assigned a value) and false otherwise */
    public boolean isSetSuccess() {
      return this.success != null;
    }

    public void setSuccessIsSet(boolean value) {
      if (!value) {
        this.success = null;
      }
    }

    public void setFieldValue(_Fields field, Object value) {
      switch (field) {
      case SUCCESS:
        if (value == null) {
          unsetSuccess();
        } else {
          setSuccess((String)value);
        }
        break;

      }
    }

    public Object getFieldValue(_Fields field) {
      switch (field) {
      case SUCCESS:
        return getSuccess();

      }
      throw new IllegalStateException();
    }

    /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
    public boolean isSet(_Fields field) {
      if (field == null) {
        throw new IllegalArgumentException();
      }

      switch (field) {
      case SUCCESS:
        return isSetSuccess();
      }
      throw new IllegalStateException();
    }

    @Override
    public boolean equals(Object that) {
      if (that == null)
        return false;
      if (that instanceof ImportDataInHive_result)
        return this.equals((ImportDataInHive_result)that);
      return false;
    }

    public boolean equals(ImportDataInHive_result that) {
      if (that == null)
        return false;

      boolean this_present_success = true && this.isSetSuccess();
      boolean that_present_success = true && that.isSetSuccess();
      if (this_present_success || that_present_success) {
        if (!(this_present_success && that_present_success))
          return false;
        if (!this.success.equals(that.success))
          return false;
      }

      return true;
    }

    @Override
    public int hashCode() {
      return 0;
    }

    public int compareTo(ImportDataInHive_result other) {
      if (!getClass().equals(other.getClass())) {
        return getClass().getName().compareTo(other.getClass().getName());
      }

      int lastComparison = 0;
      ImportDataInHive_result typedOther = (ImportDataInHive_result)other;

      lastComparison = Boolean.valueOf(isSetSuccess()).compareTo(typedOther.isSetSuccess());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetSuccess()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.success, typedOther.success);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      return 0;
    }

    public _Fields fieldForId(int fieldId) {
      return _Fields.findByThriftId(fieldId);
    }

    public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
      schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
      schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
      }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder("ImportDataInHive_result(");
      boolean first = true;

      sb.append("success:");
      if (this.success == null) {
        sb.append("null");
      } else {
        sb.append(this.success);
      }
      first = false;
      sb.append(")");
      return sb.toString();
    }

    public void validate() throws org.apache.thrift.TException {
      // check for required fields
      // check for sub-struct validity
    }

    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
      try {
        write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
      } catch (org.apache.thrift.TException te) {
        throw new java.io.IOException(te);
      }
    }

    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
      try {
        read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
      } catch (org.apache.thrift.TException te) {
        throw new java.io.IOException(te);
      }
    }

    private static class ImportDataInHive_resultStandardSchemeFactory implements SchemeFactory {
      public ImportDataInHive_resultStandardScheme getScheme() {
        return new ImportDataInHive_resultStandardScheme();
      }
    }

    private static class ImportDataInHive_resultStandardScheme extends StandardScheme<ImportDataInHive_result> {

      public void read(org.apache.thrift.protocol.TProtocol iprot, ImportDataInHive_result struct) throws org.apache.thrift.TException {
        org.apache.thrift.protocol.TField schemeField;
        iprot.readStructBegin();
        while (true)
        {
          schemeField = iprot.readFieldBegin();
          if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
            break;
          }
          switch (schemeField.id) {
            case 0: // SUCCESS
              if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                struct.success = iprot.readString();
                struct.setSuccessIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            default:
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
          }
          iprot.readFieldEnd();
        }
        iprot.readStructEnd();

        // check for required fields of primitive type, which can't be checked in the validate method
        struct.validate();
      }

      public void write(org.apache.thrift.protocol.TProtocol oprot, ImportDataInHive_result struct) throws org.apache.thrift.TException {
        struct.validate();

        oprot.writeStructBegin(STRUCT_DESC);
        if (struct.success != null) {
          oprot.writeFieldBegin(SUCCESS_FIELD_DESC);
          oprot.writeString(struct.success);
          oprot.writeFieldEnd();
        }
        oprot.writeFieldStop();
        oprot.writeStructEnd();
      }

    }

    private static class ImportDataInHive_resultTupleSchemeFactory implements SchemeFactory {
      public ImportDataInHive_resultTupleScheme getScheme() {
        return new ImportDataInHive_resultTupleScheme();
      }
    }

    private static class ImportDataInHive_resultTupleScheme extends TupleScheme<ImportDataInHive_result> {

      @Override
      public void write(org.apache.thrift.protocol.TProtocol prot, ImportDataInHive_result struct) throws org.apache.thrift.TException {
        TTupleProtocol oprot = (TTupleProtocol) prot;
        BitSet optionals = new BitSet();
        if (struct.isSetSuccess()) {
          optionals.set(0);
        }
        oprot.writeBitSet(optionals, 1);
        if (struct.isSetSuccess()) {
          oprot.writeString(struct.success);
        }
      }

      @Override
      public void read(org.apache.thrift.protocol.TProtocol prot, ImportDataInHive_result struct) throws org.apache.thrift.TException {
        TTupleProtocol iprot = (TTupleProtocol) prot;
        BitSet incoming = iprot.readBitSet(1);
        if (incoming.get(0)) {
          struct.success = iprot.readString();
          struct.setSuccessIsSet(true);
        }
      }
    }

  }

  public static class ImportDataInHiveByWhere_args implements org.apache.thrift.TBase<ImportDataInHiveByWhere_args, ImportDataInHiveByWhere_args._Fields>, java.io.Serializable, Cloneable   {
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ImportDataInHiveByWhere_args");

    private static final org.apache.thrift.protocol.TField HOST_FIELD_DESC = new org.apache.thrift.protocol.TField("host", org.apache.thrift.protocol.TType.STRING, (short)1);
    private static final org.apache.thrift.protocol.TField DATABASE_FIELD_DESC = new org.apache.thrift.protocol.TField("database", org.apache.thrift.protocol.TType.STRING, (short)2);
    private static final org.apache.thrift.protocol.TField USER_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("userName", org.apache.thrift.protocol.TType.STRING, (short)3);
    private static final org.apache.thrift.protocol.TField PASSWORD_FIELD_DESC = new org.apache.thrift.protocol.TField("password", org.apache.thrift.protocol.TType.STRING, (short)4);
    private static final org.apache.thrift.protocol.TField TABLE_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("tableName", org.apache.thrift.protocol.TType.STRING, (short)5);
    private static final org.apache.thrift.protocol.TField HIVE_TALEB_FIELD_DESC = new org.apache.thrift.protocol.TField("hiveTaleb", org.apache.thrift.protocol.TType.STRING, (short)6);
    private static final org.apache.thrift.protocol.TField WHERE_FIELD_DESC = new org.apache.thrift.protocol.TField("where", org.apache.thrift.protocol.TType.STRING, (short)7);
    private static final org.apache.thrift.protocol.TField COLUMN_NAMES_FIELD_DESC = new org.apache.thrift.protocol.TField("columnNames", org.apache.thrift.protocol.TType.LIST, (short)8);
    private static final org.apache.thrift.protocol.TField KEYFIELD_FIELD_DESC = new org.apache.thrift.protocol.TField("keyfield", org.apache.thrift.protocol.TType.STRING, (short)9);

    private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
    static {
      schemes.put(StandardScheme.class, new ImportDataInHiveByWhere_argsStandardSchemeFactory());
      schemes.put(TupleScheme.class, new ImportDataInHiveByWhere_argsTupleSchemeFactory());
    }

    public String host; // required
    public String database; // required
    public String userName; // required
    public String password; // required
    public String tableName; // required
    public String hiveTaleb; // required
    public String where; // required
    public List<String> columnNames; // required
    public String keyfield; // required

    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
      HOST((short)1, "host"),
      DATABASE((short)2, "database"),
      USER_NAME((short)3, "userName"),
      PASSWORD((short)4, "password"),
      TABLE_NAME((short)5, "tableName"),
      HIVE_TALEB((short)6, "hiveTaleb"),
      WHERE((short)7, "where"),
      COLUMN_NAMES((short)8, "columnNames"),
      KEYFIELD((short)9, "keyfield");

      private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

      static {
        for (_Fields field : EnumSet.allOf(_Fields.class)) {
          byName.put(field.getFieldName(), field);
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, or null if its not found.
       */
      public static _Fields findByThriftId(int fieldId) {
        switch(fieldId) {
          case 1: // HOST
            return HOST;
          case 2: // DATABASE
            return DATABASE;
          case 3: // USER_NAME
            return USER_NAME;
          case 4: // PASSWORD
            return PASSWORD;
          case 5: // TABLE_NAME
            return TABLE_NAME;
          case 6: // HIVE_TALEB
            return HIVE_TALEB;
          case 7: // WHERE
            return WHERE;
          case 8: // COLUMN_NAMES
            return COLUMN_NAMES;
          case 9: // KEYFIELD
            return KEYFIELD;
          default:
            return null;
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, throwing an exception
       * if it is not found.
       */
      public static _Fields findByThriftIdOrThrow(int fieldId) {
        _Fields fields = findByThriftId(fieldId);
        if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
        return fields;
      }

      /**
       * Find the _Fields constant that matches name, or null if its not found.
       */
      public static _Fields findByName(String name) {
        return byName.get(name);
      }

      private final short _thriftId;
      private final String _fieldName;

      _Fields(short thriftId, String fieldName) {
        _thriftId = thriftId;
        _fieldName = fieldName;
      }

      public short getThriftFieldId() {
        return _thriftId;
      }

      public String getFieldName() {
        return _fieldName;
      }
    }

    // isset id assignments
    public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
    static {
      Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
      tmpMap.put(_Fields.HOST, new org.apache.thrift.meta_data.FieldMetaData("host", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
      tmpMap.put(_Fields.DATABASE, new org.apache.thrift.meta_data.FieldMetaData("database", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
      tmpMap.put(_Fields.USER_NAME, new org.apache.thrift.meta_data.FieldMetaData("userName", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
      tmpMap.put(_Fields.PASSWORD, new org.apache.thrift.meta_data.FieldMetaData("password", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
      tmpMap.put(_Fields.TABLE_NAME, new org.apache.thrift.meta_data.FieldMetaData("tableName", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
      tmpMap.put(_Fields.HIVE_TALEB, new org.apache.thrift.meta_data.FieldMetaData("hiveTaleb", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
      tmpMap.put(_Fields.WHERE, new org.apache.thrift.meta_data.FieldMetaData("where", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
      tmpMap.put(_Fields.COLUMN_NAMES, new org.apache.thrift.meta_data.FieldMetaData("columnNames", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
              new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
      tmpMap.put(_Fields.KEYFIELD, new org.apache.thrift.meta_data.FieldMetaData("keyfield", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
      metaDataMap = Collections.unmodifiableMap(tmpMap);
      org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ImportDataInHiveByWhere_args.class, metaDataMap);
    }

    public ImportDataInHiveByWhere_args() {
    }

    public ImportDataInHiveByWhere_args(
      String host,
      String database,
      String userName,
      String password,
      String tableName,
      String hiveTaleb,
      String where,
      List<String> columnNames,
      String keyfield)
    {
      this();
      this.host = host;
      this.database = database;
      this.userName = userName;
      this.password = password;
      this.tableName = tableName;
      this.hiveTaleb = hiveTaleb;
      this.where = where;
      this.columnNames = columnNames;
      this.keyfield = keyfield;
    }

    /**
     * Performs a deep copy on <i>other</i>.
     */
    public ImportDataInHiveByWhere_args(ImportDataInHiveByWhere_args other) {
      if (other.isSetHost()) {
        this.host = other.host;
      }
      if (other.isSetDatabase()) {
        this.database = other.database;
      }
      if (other.isSetUserName()) {
        this.userName = other.userName;
      }
      if (other.isSetPassword()) {
        this.password = other.password;
      }
      if (other.isSetTableName()) {
        this.tableName = other.tableName;
      }
      if (other.isSetHiveTaleb()) {
        this.hiveTaleb = other.hiveTaleb;
      }
      if (other.isSetWhere()) {
        this.where = other.where;
      }
      if (other.isSetColumnNames()) {
        List<String> __this__columnNames = new ArrayList<String>();
        for (String other_element : other.columnNames) {
          __this__columnNames.add(other_element);
        }
        this.columnNames = __this__columnNames;
      }
      if (other.isSetKeyfield()) {
        this.keyfield = other.keyfield;
      }
    }

    public ImportDataInHiveByWhere_args deepCopy() {
      return new ImportDataInHiveByWhere_args(this);
    }

    @Override
    public void clear() {
      this.host = null;
      this.database = null;
      this.userName = null;
      this.password = null;
      this.tableName = null;
      this.hiveTaleb = null;
      this.where = null;
      this.columnNames = null;
      this.keyfield = null;
    }

    public String getHost() {
      return this.host;
    }

    public ImportDataInHiveByWhere_args setHost(String host) {
      this.host = host;
      return this;
    }

    public void unsetHost() {
      this.host = null;
    }

    /** Returns true if field host is set (has been assigned a value) and false otherwise */
    public boolean isSetHost() {
      return this.host != null;
    }

    public void setHostIsSet(boolean value) {
      if (!value) {
        this.host = null;
      }
    }

    public String getDatabase() {
      return this.database;
    }

    public ImportDataInHiveByWhere_args setDatabase(String database) {
      this.database = database;
      return this;
    }

    public void unsetDatabase() {
      this.database = null;
    }

    /** Returns true if field database is set (has been assigned a value) and false otherwise */
    public boolean isSetDatabase() {
      return this.database != null;
    }

    public void setDatabaseIsSet(boolean value) {
      if (!value) {
        this.database = null;
      }
    }

    public String getUserName() {
      return this.userName;
    }

    public ImportDataInHiveByWhere_args setUserName(String userName) {
      this.userName = userName;
      return this;
    }

    public void unsetUserName() {
      this.userName = null;
    }

    /** Returns true if field userName is set (has been assigned a value) and false otherwise */
    public boolean isSetUserName() {
      return this.userName != null;
    }

    public void setUserNameIsSet(boolean value) {
      if (!value) {
        this.userName = null;
      }
    }

    public String getPassword() {
      return this.password;
    }

    public ImportDataInHiveByWhere_args setPassword(String password) {
      this.password = password;
      return this;
    }

    public void unsetPassword() {
      this.password = null;
    }

    /** Returns true if field password is set (has been assigned a value) and false otherwise */
    public boolean isSetPassword() {
      return this.password != null;
    }

    public void setPasswordIsSet(boolean value) {
      if (!value) {
        this.password = null;
      }
    }

    public String getTableName() {
      return this.tableName;
    }

    public ImportDataInHiveByWhere_args setTableName(String tableName) {
      this.tableName = tableName;
      return this;
    }

    public void unsetTableName() {
      this.tableName = null;
    }

    /** Returns true if field tableName is set (has been assigned a value) and false otherwise */
    public boolean isSetTableName() {
      return this.tableName != null;
    }

    public void setTableNameIsSet(boolean value) {
      if (!value) {
        this.tableName = null;
      }
    }

    public String getHiveTaleb() {
      return this.hiveTaleb;
    }

    public ImportDataInHiveByWhere_args setHiveTaleb(String hiveTaleb) {
      this.hiveTaleb = hiveTaleb;
      return this;
    }

    public void unsetHiveTaleb() {
      this.hiveTaleb = null;
    }

    /** Returns true if field hiveTaleb is set (has been assigned a value) and false otherwise */
    public boolean isSetHiveTaleb() {
      return this.hiveTaleb != null;
    }

    public void setHiveTalebIsSet(boolean value) {
      if (!value) {
        this.hiveTaleb = null;
      }
    }

    public String getWhere() {
      return this.where;
    }

    public ImportDataInHiveByWhere_args setWhere(String where) {
      this.where = where;
      return this;
    }

    public void unsetWhere() {
      this.where = null;
    }

    /** Returns true if field where is set (has been assigned a value) and false otherwise */
    public boolean isSetWhere() {
      return this.where != null;
    }

    public void setWhereIsSet(boolean value) {
      if (!value) {
        this.where = null;
      }
    }

    public int getColumnNamesSize() {
      return (this.columnNames == null) ? 0 : this.columnNames.size();
    }

    public java.util.Iterator<String> getColumnNamesIterator() {
      return (this.columnNames == null) ? null : this.columnNames.iterator();
    }

    public void addToColumnNames(String elem) {
      if (this.columnNames == null) {
        this.columnNames = new ArrayList<String>();
      }
      this.columnNames.add(elem);
    }

    public List<String> getColumnNames() {
      return this.columnNames;
    }

    public ImportDataInHiveByWhere_args setColumnNames(List<String> columnNames) {
      this.columnNames = columnNames;
      return this;
    }

    public void unsetColumnNames() {
      this.columnNames = null;
    }

    /** Returns true if field columnNames is set (has been assigned a value) and false otherwise */
    public boolean isSetColumnNames() {
      return this.columnNames != null;
    }

    public void setColumnNamesIsSet(boolean value) {
      if (!value) {
        this.columnNames = null;
      }
    }

    public String getKeyfield() {
      return this.keyfield;
    }

    public ImportDataInHiveByWhere_args setKeyfield(String keyfield) {
      this.keyfield = keyfield;
      return this;
    }

    public void unsetKeyfield() {
      this.keyfield = null;
    }

    /** Returns true if field keyfield is set (has been assigned a value) and false otherwise */
    public boolean isSetKeyfield() {
      return this.keyfield != null;
    }

    public void setKeyfieldIsSet(boolean value) {
      if (!value) {
        this.keyfield = null;
      }
    }

    public void setFieldValue(_Fields field, Object value) {
      switch (field) {
      case HOST:
        if (value == null) {
          unsetHost();
        } else {
          setHost((String)value);
        }
        break;

      case DATABASE:
        if (value == null) {
          unsetDatabase();
        } else {
          setDatabase((String)value);
        }
        break;

      case USER_NAME:
        if (value == null) {
          unsetUserName();
        } else {
          setUserName((String)value);
        }
        break;

      case PASSWORD:
        if (value == null) {
          unsetPassword();
        } else {
          setPassword((String)value);
        }
        break;

      case TABLE_NAME:
        if (value == null) {
          unsetTableName();
        } else {
          setTableName((String)value);
        }
        break;

      case HIVE_TALEB:
        if (value == null) {
          unsetHiveTaleb();
        } else {
          setHiveTaleb((String)value);
        }
        break;

      case WHERE:
        if (value == null) {
          unsetWhere();
        } else {
          setWhere((String)value);
        }
        break;

      case COLUMN_NAMES:
        if (value == null) {
          unsetColumnNames();
        } else {
          setColumnNames((List<String>)value);
        }
        break;

      case KEYFIELD:
        if (value == null) {
          unsetKeyfield();
        } else {
          setKeyfield((String)value);
        }
        break;

      }
    }

    public Object getFieldValue(_Fields field) {
      switch (field) {
      case HOST:
        return getHost();

      case DATABASE:
        return getDatabase();

      case USER_NAME:
        return getUserName();

      case PASSWORD:
        return getPassword();

      case TABLE_NAME:
        return getTableName();

      case HIVE_TALEB:
        return getHiveTaleb();

      case WHERE:
        return getWhere();

      case COLUMN_NAMES:
        return getColumnNames();

      case KEYFIELD:
        return getKeyfield();

      }
      throw new IllegalStateException();
    }

    /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
    public boolean isSet(_Fields field) {
      if (field == null) {
        throw new IllegalArgumentException();
      }

      switch (field) {
      case HOST:
        return isSetHost();
      case DATABASE:
        return isSetDatabase();
      case USER_NAME:
        return isSetUserName();
      case PASSWORD:
        return isSetPassword();
      case TABLE_NAME:
        return isSetTableName();
      case HIVE_TALEB:
        return isSetHiveTaleb();
      case WHERE:
        return isSetWhere();
      case COLUMN_NAMES:
        return isSetColumnNames();
      case KEYFIELD:
        return isSetKeyfield();
      }
      throw new IllegalStateException();
    }

    @Override
    public boolean equals(Object that) {
      if (that == null)
        return false;
      if (that instanceof ImportDataInHiveByWhere_args)
        return this.equals((ImportDataInHiveByWhere_args)that);
      return false;
    }

    public boolean equals(ImportDataInHiveByWhere_args that) {
      if (that == null)
        return false;

      boolean this_present_host = true && this.isSetHost();
      boolean that_present_host = true && that.isSetHost();
      if (this_present_host || that_present_host) {
        if (!(this_present_host && that_present_host))
          return false;
        if (!this.host.equals(that.host))
          return false;
      }

      boolean this_present_database = true && this.isSetDatabase();
      boolean that_present_database = true && that.isSetDatabase();
      if (this_present_database || that_present_database) {
        if (!(this_present_database && that_present_database))
          return false;
        if (!this.database.equals(that.database))
          return false;
      }

      boolean this_present_userName = true && this.isSetUserName();
      boolean that_present_userName = true && that.isSetUserName();
      if (this_present_userName || that_present_userName) {
        if (!(this_present_userName && that_present_userName))
          return false;
        if (!this.userName.equals(that.userName))
          return false;
      }

      boolean this_present_password = true && this.isSetPassword();
      boolean that_present_password = true && that.isSetPassword();
      if (this_present_password || that_present_password) {
        if (!(this_present_password && that_present_password))
          return false;
        if (!this.password.equals(that.password))
          return false;
      }

      boolean this_present_tableName = true && this.isSetTableName();
      boolean that_present_tableName = true && that.isSetTableName();
      if (this_present_tableName || that_present_tableName) {
        if (!(this_present_tableName && that_present_tableName))
          return false;
        if (!this.tableName.equals(that.tableName))
          return false;
      }

      boolean this_present_hiveTaleb = true && this.isSetHiveTaleb();
      boolean that_present_hiveTaleb = true && that.isSetHiveTaleb();
      if (this_present_hiveTaleb || that_present_hiveTaleb) {
        if (!(this_present_hiveTaleb && that_present_hiveTaleb))
          return false;
        if (!this.hiveTaleb.equals(that.hiveTaleb))
          return false;
      }

      boolean this_present_where = true && this.isSetWhere();
      boolean that_present_where = true && that.isSetWhere();
      if (this_present_where || that_present_where) {
        if (!(this_present_where && that_present_where))
          return false;
        if (!this.where.equals(that.where))
          return false;
      }

      boolean this_present_columnNames = true && this.isSetColumnNames();
      boolean that_present_columnNames = true && that.isSetColumnNames();
      if (this_present_columnNames || that_present_columnNames) {
        if (!(this_present_columnNames && that_present_columnNames))
          return false;
        if (!this.columnNames.equals(that.columnNames))
          return false;
      }

      boolean this_present_keyfield = true && this.isSetKeyfield();
      boolean that_present_keyfield = true && that.isSetKeyfield();
      if (this_present_keyfield || that_present_keyfield) {
        if (!(this_present_keyfield && that_present_keyfield))
          return false;
        if (!this.keyfield.equals(that.keyfield))
          return false;
      }

      return true;
    }

    @Override
    public int hashCode() {
      return 0;
    }

    public int compareTo(ImportDataInHiveByWhere_args other) {
      if (!getClass().equals(other.getClass())) {
        return getClass().getName().compareTo(other.getClass().getName());
      }

      int lastComparison = 0;
      ImportDataInHiveByWhere_args typedOther = (ImportDataInHiveByWhere_args)other;

      lastComparison = Boolean.valueOf(isSetHost()).compareTo(typedOther.isSetHost());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetHost()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.host, typedOther.host);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      lastComparison = Boolean.valueOf(isSetDatabase()).compareTo(typedOther.isSetDatabase());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetDatabase()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.database, typedOther.database);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      lastComparison = Boolean.valueOf(isSetUserName()).compareTo(typedOther.isSetUserName());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetUserName()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.userName, typedOther.userName);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      lastComparison = Boolean.valueOf(isSetPassword()).compareTo(typedOther.isSetPassword());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetPassword()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.password, typedOther.password);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      lastComparison = Boolean.valueOf(isSetTableName()).compareTo(typedOther.isSetTableName());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetTableName()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.tableName, typedOther.tableName);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      lastComparison = Boolean.valueOf(isSetHiveTaleb()).compareTo(typedOther.isSetHiveTaleb());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetHiveTaleb()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.hiveTaleb, typedOther.hiveTaleb);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      lastComparison = Boolean.valueOf(isSetWhere()).compareTo(typedOther.isSetWhere());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetWhere()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.where, typedOther.where);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      lastComparison = Boolean.valueOf(isSetColumnNames()).compareTo(typedOther.isSetColumnNames());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetColumnNames()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.columnNames, typedOther.columnNames);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      lastComparison = Boolean.valueOf(isSetKeyfield()).compareTo(typedOther.isSetKeyfield());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetKeyfield()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.keyfield, typedOther.keyfield);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      return 0;
    }

    public _Fields fieldForId(int fieldId) {
      return _Fields.findByThriftId(fieldId);
    }

    public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
      schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
      schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder("ImportDataInHiveByWhere_args(");
      boolean first = true;

      sb.append("host:");
      if (this.host == null) {
        sb.append("null");
      } else {
        sb.append(this.host);
      }
      first = false;
      if (!first) sb.append(", ");
      sb.append("database:");
      if (this.database == null) {
        sb.append("null");
      } else {
        sb.append(this.database);
      }
      first = false;
      if (!first) sb.append(", ");
      sb.append("userName:");
      if (this.userName == null) {
        sb.append("null");
      } else {
        sb.append(this.userName);
      }
      first = false;
      if (!first) sb.append(", ");
      sb.append("password:");
      if (this.password == null) {
        sb.append("null");
      } else {
        sb.append(this.password);
      }
      first = false;
      if (!first) sb.append(", ");
      sb.append("tableName:");
      if (this.tableName == null) {
        sb.append("null");
      } else {
        sb.append(this.tableName);
      }
      first = false;
      if (!first) sb.append(", ");
      sb.append("hiveTaleb:");
      if (this.hiveTaleb == null) {
        sb.append("null");
      } else {
        sb.append(this.hiveTaleb);
      }
      first = false;
      if (!first) sb.append(", ");
      sb.append("where:");
      if (this.where == null) {
        sb.append("null");
      } else {
        sb.append(this.where);
      }
      first = false;
      if (!first) sb.append(", ");
      sb.append("columnNames:");
      if (this.columnNames == null) {
        sb.append("null");
      } else {
        sb.append(this.columnNames);
      }
      first = false;
      if (!first) sb.append(", ");
      sb.append("keyfield:");
      if (this.keyfield == null) {
        sb.append("null");
      } else {
        sb.append(this.keyfield);
      }
      first = false;
      sb.append(")");
      return sb.toString();
    }

    public void validate() throws org.apache.thrift.TException {
      // check for required fields
      // check for sub-struct validity
    }

    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
      try {
        write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
      } catch (org.apache.thrift.TException te) {
        throw new java.io.IOException(te);
      }
    }

    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
      try {
        read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
      } catch (org.apache.thrift.TException te) {
        throw new java.io.IOException(te);
      }
    }

    private static class ImportDataInHiveByWhere_argsStandardSchemeFactory implements SchemeFactory {
      public ImportDataInHiveByWhere_argsStandardScheme getScheme() {
        return new ImportDataInHiveByWhere_argsStandardScheme();
      }
    }

    private static class ImportDataInHiveByWhere_argsStandardScheme extends StandardScheme<ImportDataInHiveByWhere_args> {

      public void read(org.apache.thrift.protocol.TProtocol iprot, ImportDataInHiveByWhere_args struct) throws org.apache.thrift.TException {
        org.apache.thrift.protocol.TField schemeField;
        iprot.readStructBegin();
        while (true)
        {
          schemeField = iprot.readFieldBegin();
          if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
            break;
          }
          switch (schemeField.id) {
            case 1: // HOST
              if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                struct.host = iprot.readString();
                struct.setHostIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            case 2: // DATABASE
              if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                struct.database = iprot.readString();
                struct.setDatabaseIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            case 3: // USER_NAME
              if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                struct.userName = iprot.readString();
                struct.setUserNameIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            case 4: // PASSWORD
              if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                struct.password = iprot.readString();
                struct.setPasswordIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            case 5: // TABLE_NAME
              if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                struct.tableName = iprot.readString();
                struct.setTableNameIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            case 6: // HIVE_TALEB
              if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                struct.hiveTaleb = iprot.readString();
                struct.setHiveTalebIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            case 7: // WHERE
              if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                struct.where = iprot.readString();
                struct.setWhereIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            case 8: // COLUMN_NAMES
              if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
                {
                  org.apache.thrift.protocol.TList _list0 = iprot.readListBegin();
                  struct.columnNames = new ArrayList<String>(_list0.size);
                  for (int _i1 = 0; _i1 < _list0.size; ++_i1)
                  {
                    String _elem2; // required
                    _elem2 = iprot.readString();
                    struct.columnNames.add(_elem2);
                  }
                  iprot.readListEnd();
                }
                struct.setColumnNamesIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            case 9: // KEYFIELD
              if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                struct.keyfield = iprot.readString();
                struct.setKeyfieldIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            default:
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
          }
          iprot.readFieldEnd();
        }
        iprot.readStructEnd();

        // check for required fields of primitive type, which can't be checked in the validate method
        struct.validate();
      }

      public void write(org.apache.thrift.protocol.TProtocol oprot, ImportDataInHiveByWhere_args struct) throws org.apache.thrift.TException {
        struct.validate();

        oprot.writeStructBegin(STRUCT_DESC);
        if (struct.host != null) {
          oprot.writeFieldBegin(HOST_FIELD_DESC);
          oprot.writeString(struct.host);
          oprot.writeFieldEnd();
        }
        if (struct.database != null) {
          oprot.writeFieldBegin(DATABASE_FIELD_DESC);
          oprot.writeString(struct.database);
          oprot.writeFieldEnd();
        }
        if (struct.userName != null) {
          oprot.writeFieldBegin(USER_NAME_FIELD_DESC);
          oprot.writeString(struct.userName);
          oprot.writeFieldEnd();
        }
        if (struct.password != null) {
          oprot.writeFieldBegin(PASSWORD_FIELD_DESC);
          oprot.writeString(struct.password);
          oprot.writeFieldEnd();
        }
        if (struct.tableName != null) {
          oprot.writeFieldBegin(TABLE_NAME_FIELD_DESC);
          oprot.writeString(struct.tableName);
          oprot.writeFieldEnd();
        }
        if (struct.hiveTaleb != null) {
          oprot.writeFieldBegin(HIVE_TALEB_FIELD_DESC);
          oprot.writeString(struct.hiveTaleb);
          oprot.writeFieldEnd();
        }
        if (struct.where != null) {
          oprot.writeFieldBegin(WHERE_FIELD_DESC);
          oprot.writeString(struct.where);
          oprot.writeFieldEnd();
        }
        if (struct.columnNames != null) {
          oprot.writeFieldBegin(COLUMN_NAMES_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, struct.columnNames.size()));
            for (String _iter3 : struct.columnNames)
            {
              oprot.writeString(_iter3);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
        if (struct.keyfield != null) {
          oprot.writeFieldBegin(KEYFIELD_FIELD_DESC);
          oprot.writeString(struct.keyfield);
          oprot.writeFieldEnd();
        }
        oprot.writeFieldStop();
        oprot.writeStructEnd();
      }

    }

    private static class ImportDataInHiveByWhere_argsTupleSchemeFactory implements SchemeFactory {
      public ImportDataInHiveByWhere_argsTupleScheme getScheme() {
        return new ImportDataInHiveByWhere_argsTupleScheme();
      }
    }

    private static class ImportDataInHiveByWhere_argsTupleScheme extends TupleScheme<ImportDataInHiveByWhere_args> {

      @Override
      public void write(org.apache.thrift.protocol.TProtocol prot, ImportDataInHiveByWhere_args struct) throws org.apache.thrift.TException {
        TTupleProtocol oprot = (TTupleProtocol) prot;
        BitSet optionals = new BitSet();
        if (struct.isSetHost()) {
          optionals.set(0);
        }
        if (struct.isSetDatabase()) {
          optionals.set(1);
        }
        if (struct.isSetUserName()) {
          optionals.set(2);
        }
        if (struct.isSetPassword()) {
          optionals.set(3);
        }
        if (struct.isSetTableName()) {
          optionals.set(4);
        }
        if (struct.isSetHiveTaleb()) {
          optionals.set(5);
        }
        if (struct.isSetWhere()) {
          optionals.set(6);
        }
        if (struct.isSetColumnNames()) {
          optionals.set(7);
        }
        if (struct.isSetKeyfield()) {
          optionals.set(8);
        }
        oprot.writeBitSet(optionals, 9);
        if (struct.isSetHost()) {
          oprot.writeString(struct.host);
        }
        if (struct.isSetDatabase()) {
          oprot.writeString(struct.database);
        }
        if (struct.isSetUserName()) {
          oprot.writeString(struct.userName);
        }
        if (struct.isSetPassword()) {
          oprot.writeString(struct.password);
        }
        if (struct.isSetTableName()) {
          oprot.writeString(struct.tableName);
        }
        if (struct.isSetHiveTaleb()) {
          oprot.writeString(struct.hiveTaleb);
        }
        if (struct.isSetWhere()) {
          oprot.writeString(struct.where);
        }
        if (struct.isSetColumnNames()) {
          {
            oprot.writeI32(struct.columnNames.size());
            for (String _iter4 : struct.columnNames)
            {
              oprot.writeString(_iter4);
            }
          }
        }
        if (struct.isSetKeyfield()) {
          oprot.writeString(struct.keyfield);
        }
      }

      @Override
      public void read(org.apache.thrift.protocol.TProtocol prot, ImportDataInHiveByWhere_args struct) throws org.apache.thrift.TException {
        TTupleProtocol iprot = (TTupleProtocol) prot;
        BitSet incoming = iprot.readBitSet(9);
        if (incoming.get(0)) {
          struct.host = iprot.readString();
          struct.setHostIsSet(true);
        }
        if (incoming.get(1)) {
          struct.database = iprot.readString();
          struct.setDatabaseIsSet(true);
        }
        if (incoming.get(2)) {
          struct.userName = iprot.readString();
          struct.setUserNameIsSet(true);
        }
        if (incoming.get(3)) {
          struct.password = iprot.readString();
          struct.setPasswordIsSet(true);
        }
        if (incoming.get(4)) {
          struct.tableName = iprot.readString();
          struct.setTableNameIsSet(true);
        }
        if (incoming.get(5)) {
          struct.hiveTaleb = iprot.readString();
          struct.setHiveTalebIsSet(true);
        }
        if (incoming.get(6)) {
          struct.where = iprot.readString();
          struct.setWhereIsSet(true);
        }
        if (incoming.get(7)) {
          {
            org.apache.thrift.protocol.TList _list5 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, iprot.readI32());
            struct.columnNames = new ArrayList<String>(_list5.size);
            for (int _i6 = 0; _i6 < _list5.size; ++_i6)
            {
              String _elem7; // required
              _elem7 = iprot.readString();
              struct.columnNames.add(_elem7);
            }
          }
          struct.setColumnNamesIsSet(true);
        }
        if (incoming.get(8)) {
          struct.keyfield = iprot.readString();
          struct.setKeyfieldIsSet(true);
        }
      }
    }

  }

  public static class ImportDataInHiveByWhere_result implements org.apache.thrift.TBase<ImportDataInHiveByWhere_result, ImportDataInHiveByWhere_result._Fields>, java.io.Serializable, Cloneable   {
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ImportDataInHiveByWhere_result");

    private static final org.apache.thrift.protocol.TField SUCCESS_FIELD_DESC = new org.apache.thrift.protocol.TField("success", org.apache.thrift.protocol.TType.STRING, (short)0);

    private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
    static {
      schemes.put(StandardScheme.class, new ImportDataInHiveByWhere_resultStandardSchemeFactory());
      schemes.put(TupleScheme.class, new ImportDataInHiveByWhere_resultTupleSchemeFactory());
    }

    public String success; // required

    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
      SUCCESS((short)0, "success");

      private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

      static {
        for (_Fields field : EnumSet.allOf(_Fields.class)) {
          byName.put(field.getFieldName(), field);
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, or null if its not found.
       */
      public static _Fields findByThriftId(int fieldId) {
        switch(fieldId) {
          case 0: // SUCCESS
            return SUCCESS;
          default:
            return null;
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, throwing an exception
       * if it is not found.
       */
      public static _Fields findByThriftIdOrThrow(int fieldId) {
        _Fields fields = findByThriftId(fieldId);
        if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
        return fields;
      }

      /**
       * Find the _Fields constant that matches name, or null if its not found.
       */
      public static _Fields findByName(String name) {
        return byName.get(name);
      }

      private final short _thriftId;
      private final String _fieldName;

      _Fields(short thriftId, String fieldName) {
        _thriftId = thriftId;
        _fieldName = fieldName;
      }

      public short getThriftFieldId() {
        return _thriftId;
      }

      public String getFieldName() {
        return _fieldName;
      }
    }

    // isset id assignments
    public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
    static {
      Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
      tmpMap.put(_Fields.SUCCESS, new org.apache.thrift.meta_data.FieldMetaData("success", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
      metaDataMap = Collections.unmodifiableMap(tmpMap);
      org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ImportDataInHiveByWhere_result.class, metaDataMap);
    }

    public ImportDataInHiveByWhere_result() {
    }

    public ImportDataInHiveByWhere_result(
      String success)
    {
      this();
      this.success = success;
    }

    /**
     * Performs a deep copy on <i>other</i>.
     */
    public ImportDataInHiveByWhere_result(ImportDataInHiveByWhere_result other) {
      if (other.isSetSuccess()) {
        this.success = other.success;
      }
    }

    public ImportDataInHiveByWhere_result deepCopy() {
      return new ImportDataInHiveByWhere_result(this);
    }

    @Override
    public void clear() {
      this.success = null;
    }

    public String getSuccess() {
      return this.success;
    }

    public ImportDataInHiveByWhere_result setSuccess(String success) {
      this.success = success;
      return this;
    }

    public void unsetSuccess() {
      this.success = null;
    }

    /** Returns true if field success is set (has been assigned a value) and false otherwise */
    public boolean isSetSuccess() {
      return this.success != null;
    }

    public void setSuccessIsSet(boolean value) {
      if (!value) {
        this.success = null;
      }
    }

    public void setFieldValue(_Fields field, Object value) {
      switch (field) {
      case SUCCESS:
        if (value == null) {
          unsetSuccess();
        } else {
          setSuccess((String)value);
        }
        break;

      }
    }

    public Object getFieldValue(_Fields field) {
      switch (field) {
      case SUCCESS:
        return getSuccess();

      }
      throw new IllegalStateException();
    }

    /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
    public boolean isSet(_Fields field) {
      if (field == null) {
        throw new IllegalArgumentException();
      }

      switch (field) {
      case SUCCESS:
        return isSetSuccess();
      }
      throw new IllegalStateException();
    }

    @Override
    public boolean equals(Object that) {
      if (that == null)
        return false;
      if (that instanceof ImportDataInHiveByWhere_result)
        return this.equals((ImportDataInHiveByWhere_result)that);
      return false;
    }

    public boolean equals(ImportDataInHiveByWhere_result that) {
      if (that == null)
        return false;

      boolean this_present_success = true && this.isSetSuccess();
      boolean that_present_success = true && that.isSetSuccess();
      if (this_present_success || that_present_success) {
        if (!(this_present_success && that_present_success))
          return false;
        if (!this.success.equals(that.success))
          return false;
      }

      return true;
    }

    @Override
    public int hashCode() {
      return 0;
    }

    public int compareTo(ImportDataInHiveByWhere_result other) {
      if (!getClass().equals(other.getClass())) {
        return getClass().getName().compareTo(other.getClass().getName());
      }

      int lastComparison = 0;
      ImportDataInHiveByWhere_result typedOther = (ImportDataInHiveByWhere_result)other;

      lastComparison = Boolean.valueOf(isSetSuccess()).compareTo(typedOther.isSetSuccess());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetSuccess()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.success, typedOther.success);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      return 0;
    }

    public _Fields fieldForId(int fieldId) {
      return _Fields.findByThriftId(fieldId);
    }

    public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
      schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
      schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
      }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder("ImportDataInHiveByWhere_result(");
      boolean first = true;

      sb.append("success:");
      if (this.success == null) {
        sb.append("null");
      } else {
        sb.append(this.success);
      }
      first = false;
      sb.append(")");
      return sb.toString();
    }

    public void validate() throws org.apache.thrift.TException {
      // check for required fields
      // check for sub-struct validity
    }

    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
      try {
        write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
      } catch (org.apache.thrift.TException te) {
        throw new java.io.IOException(te);
      }
    }

    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
      try {
        read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
      } catch (org.apache.thrift.TException te) {
        throw new java.io.IOException(te);
      }
    }

    private static class ImportDataInHiveByWhere_resultStandardSchemeFactory implements SchemeFactory {
      public ImportDataInHiveByWhere_resultStandardScheme getScheme() {
        return new ImportDataInHiveByWhere_resultStandardScheme();
      }
    }

    private static class ImportDataInHiveByWhere_resultStandardScheme extends StandardScheme<ImportDataInHiveByWhere_result> {

      public void read(org.apache.thrift.protocol.TProtocol iprot, ImportDataInHiveByWhere_result struct) throws org.apache.thrift.TException {
        org.apache.thrift.protocol.TField schemeField;
        iprot.readStructBegin();
        while (true)
        {
          schemeField = iprot.readFieldBegin();
          if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
            break;
          }
          switch (schemeField.id) {
            case 0: // SUCCESS
              if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                struct.success = iprot.readString();
                struct.setSuccessIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            default:
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
          }
          iprot.readFieldEnd();
        }
        iprot.readStructEnd();

        // check for required fields of primitive type, which can't be checked in the validate method
        struct.validate();
      }

      public void write(org.apache.thrift.protocol.TProtocol oprot, ImportDataInHiveByWhere_result struct) throws org.apache.thrift.TException {
        struct.validate();

        oprot.writeStructBegin(STRUCT_DESC);
        if (struct.success != null) {
          oprot.writeFieldBegin(SUCCESS_FIELD_DESC);
          oprot.writeString(struct.success);
          oprot.writeFieldEnd();
        }
        oprot.writeFieldStop();
        oprot.writeStructEnd();
      }

    }

    private static class ImportDataInHiveByWhere_resultTupleSchemeFactory implements SchemeFactory {
      public ImportDataInHiveByWhere_resultTupleScheme getScheme() {
        return new ImportDataInHiveByWhere_resultTupleScheme();
      }
    }

    private static class ImportDataInHiveByWhere_resultTupleScheme extends TupleScheme<ImportDataInHiveByWhere_result> {

      @Override
      public void write(org.apache.thrift.protocol.TProtocol prot, ImportDataInHiveByWhere_result struct) throws org.apache.thrift.TException {
        TTupleProtocol oprot = (TTupleProtocol) prot;
        BitSet optionals = new BitSet();
        if (struct.isSetSuccess()) {
          optionals.set(0);
        }
        oprot.writeBitSet(optionals, 1);
        if (struct.isSetSuccess()) {
          oprot.writeString(struct.success);
        }
      }

      @Override
      public void read(org.apache.thrift.protocol.TProtocol prot, ImportDataInHiveByWhere_result struct) throws org.apache.thrift.TException {
        TTupleProtocol iprot = (TTupleProtocol) prot;
        BitSet incoming = iprot.readBitSet(1);
        if (incoming.get(0)) {
          struct.success = iprot.readString();
          struct.setSuccessIsSet(true);
        }
      }
    }

  }

  public static class ExportData_args implements org.apache.thrift.TBase<ExportData_args, ExportData_args._Fields>, java.io.Serializable, Cloneable   {
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ExportData_args");

    private static final org.apache.thrift.protocol.TField HOST_FIELD_DESC = new org.apache.thrift.protocol.TField("host", org.apache.thrift.protocol.TType.STRING, (short)1);
    private static final org.apache.thrift.protocol.TField DATABASE_FIELD_DESC = new org.apache.thrift.protocol.TField("database", org.apache.thrift.protocol.TType.STRING, (short)2);
    private static final org.apache.thrift.protocol.TField USER_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("userName", org.apache.thrift.protocol.TType.STRING, (short)3);
    private static final org.apache.thrift.protocol.TField PASSWORD_FIELD_DESC = new org.apache.thrift.protocol.TField("password", org.apache.thrift.protocol.TType.STRING, (short)4);
    private static final org.apache.thrift.protocol.TField TABLE_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("tableName", org.apache.thrift.protocol.TType.STRING, (short)5);
    private static final org.apache.thrift.protocol.TField HIVE_TALEB_FIELD_DESC = new org.apache.thrift.protocol.TField("hiveTaleb", org.apache.thrift.protocol.TType.STRING, (short)6);

    private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
    static {
      schemes.put(StandardScheme.class, new ExportData_argsStandardSchemeFactory());
      schemes.put(TupleScheme.class, new ExportData_argsTupleSchemeFactory());
    }

    public String host; // required
    public String database; // required
    public String userName; // required
    public String password; // required
    public String tableName; // required
    public String hiveTaleb; // required

    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
      HOST((short)1, "host"),
      DATABASE((short)2, "database"),
      USER_NAME((short)3, "userName"),
      PASSWORD((short)4, "password"),
      TABLE_NAME((short)5, "tableName"),
      HIVE_TALEB((short)6, "hiveTaleb");

      private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

      static {
        for (_Fields field : EnumSet.allOf(_Fields.class)) {
          byName.put(field.getFieldName(), field);
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, or null if its not found.
       */
      public static _Fields findByThriftId(int fieldId) {
        switch(fieldId) {
          case 1: // HOST
            return HOST;
          case 2: // DATABASE
            return DATABASE;
          case 3: // USER_NAME
            return USER_NAME;
          case 4: // PASSWORD
            return PASSWORD;
          case 5: // TABLE_NAME
            return TABLE_NAME;
          case 6: // HIVE_TALEB
            return HIVE_TALEB;
          default:
            return null;
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, throwing an exception
       * if it is not found.
       */
      public static _Fields findByThriftIdOrThrow(int fieldId) {
        _Fields fields = findByThriftId(fieldId);
        if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
        return fields;
      }

      /**
       * Find the _Fields constant that matches name, or null if its not found.
       */
      public static _Fields findByName(String name) {
        return byName.get(name);
      }

      private final short _thriftId;
      private final String _fieldName;

      _Fields(short thriftId, String fieldName) {
        _thriftId = thriftId;
        _fieldName = fieldName;
      }

      public short getThriftFieldId() {
        return _thriftId;
      }

      public String getFieldName() {
        return _fieldName;
      }
    }

    // isset id assignments
    public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
    static {
      Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
      tmpMap.put(_Fields.HOST, new org.apache.thrift.meta_data.FieldMetaData("host", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
      tmpMap.put(_Fields.DATABASE, new org.apache.thrift.meta_data.FieldMetaData("database", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
      tmpMap.put(_Fields.USER_NAME, new org.apache.thrift.meta_data.FieldMetaData("userName", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
      tmpMap.put(_Fields.PASSWORD, new org.apache.thrift.meta_data.FieldMetaData("password", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
      tmpMap.put(_Fields.TABLE_NAME, new org.apache.thrift.meta_data.FieldMetaData("tableName", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
      tmpMap.put(_Fields.HIVE_TALEB, new org.apache.thrift.meta_data.FieldMetaData("hiveTaleb", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
      metaDataMap = Collections.unmodifiableMap(tmpMap);
      org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ExportData_args.class, metaDataMap);
    }

    public ExportData_args() {
    }

    public ExportData_args(
      String host,
      String database,
      String userName,
      String password,
      String tableName,
      String hiveTaleb)
    {
      this();
      this.host = host;
      this.database = database;
      this.userName = userName;
      this.password = password;
      this.tableName = tableName;
      this.hiveTaleb = hiveTaleb;
    }

    /**
     * Performs a deep copy on <i>other</i>.
     */
    public ExportData_args(ExportData_args other) {
      if (other.isSetHost()) {
        this.host = other.host;
      }
      if (other.isSetDatabase()) {
        this.database = other.database;
      }
      if (other.isSetUserName()) {
        this.userName = other.userName;
      }
      if (other.isSetPassword()) {
        this.password = other.password;
      }
      if (other.isSetTableName()) {
        this.tableName = other.tableName;
      }
      if (other.isSetHiveTaleb()) {
        this.hiveTaleb = other.hiveTaleb;
      }
    }

    public ExportData_args deepCopy() {
      return new ExportData_args(this);
    }

    @Override
    public void clear() {
      this.host = null;
      this.database = null;
      this.userName = null;
      this.password = null;
      this.tableName = null;
      this.hiveTaleb = null;
    }

    public String getHost() {
      return this.host;
    }

    public ExportData_args setHost(String host) {
      this.host = host;
      return this;
    }

    public void unsetHost() {
      this.host = null;
    }

    /** Returns true if field host is set (has been assigned a value) and false otherwise */
    public boolean isSetHost() {
      return this.host != null;
    }

    public void setHostIsSet(boolean value) {
      if (!value) {
        this.host = null;
      }
    }

    public String getDatabase() {
      return this.database;
    }

    public ExportData_args setDatabase(String database) {
      this.database = database;
      return this;
    }

    public void unsetDatabase() {
      this.database = null;
    }

    /** Returns true if field database is set (has been assigned a value) and false otherwise */
    public boolean isSetDatabase() {
      return this.database != null;
    }

    public void setDatabaseIsSet(boolean value) {
      if (!value) {
        this.database = null;
      }
    }

    public String getUserName() {
      return this.userName;
    }

    public ExportData_args setUserName(String userName) {
      this.userName = userName;
      return this;
    }

    public void unsetUserName() {
      this.userName = null;
    }

    /** Returns true if field userName is set (has been assigned a value) and false otherwise */
    public boolean isSetUserName() {
      return this.userName != null;
    }

    public void setUserNameIsSet(boolean value) {
      if (!value) {
        this.userName = null;
      }
    }

    public String getPassword() {
      return this.password;
    }

    public ExportData_args setPassword(String password) {
      this.password = password;
      return this;
    }

    public void unsetPassword() {
      this.password = null;
    }

    /** Returns true if field password is set (has been assigned a value) and false otherwise */
    public boolean isSetPassword() {
      return this.password != null;
    }

    public void setPasswordIsSet(boolean value) {
      if (!value) {
        this.password = null;
      }
    }

    public String getTableName() {
      return this.tableName;
    }

    public ExportData_args setTableName(String tableName) {
      this.tableName = tableName;
      return this;
    }

    public void unsetTableName() {
      this.tableName = null;
    }

    /** Returns true if field tableName is set (has been assigned a value) and false otherwise */
    public boolean isSetTableName() {
      return this.tableName != null;
    }

    public void setTableNameIsSet(boolean value) {
      if (!value) {
        this.tableName = null;
      }
    }

    public String getHiveTaleb() {
      return this.hiveTaleb;
    }

    public ExportData_args setHiveTaleb(String hiveTaleb) {
      this.hiveTaleb = hiveTaleb;
      return this;
    }

    public void unsetHiveTaleb() {
      this.hiveTaleb = null;
    }

    /** Returns true if field hiveTaleb is set (has been assigned a value) and false otherwise */
    public boolean isSetHiveTaleb() {
      return this.hiveTaleb != null;
    }

    public void setHiveTalebIsSet(boolean value) {
      if (!value) {
        this.hiveTaleb = null;
      }
    }

    public void setFieldValue(_Fields field, Object value) {
      switch (field) {
      case HOST:
        if (value == null) {
          unsetHost();
        } else {
          setHost((String)value);
        }
        break;

      case DATABASE:
        if (value == null) {
          unsetDatabase();
        } else {
          setDatabase((String)value);
        }
        break;

      case USER_NAME:
        if (value == null) {
          unsetUserName();
        } else {
          setUserName((String)value);
        }
        break;

      case PASSWORD:
        if (value == null) {
          unsetPassword();
        } else {
          setPassword((String)value);
        }
        break;

      case TABLE_NAME:
        if (value == null) {
          unsetTableName();
        } else {
          setTableName((String)value);
        }
        break;

      case HIVE_TALEB:
        if (value == null) {
          unsetHiveTaleb();
        } else {
          setHiveTaleb((String)value);
        }
        break;

      }
    }

    public Object getFieldValue(_Fields field) {
      switch (field) {
      case HOST:
        return getHost();

      case DATABASE:
        return getDatabase();

      case USER_NAME:
        return getUserName();

      case PASSWORD:
        return getPassword();

      case TABLE_NAME:
        return getTableName();

      case HIVE_TALEB:
        return getHiveTaleb();

      }
      throw new IllegalStateException();
    }

    /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
    public boolean isSet(_Fields field) {
      if (field == null) {
        throw new IllegalArgumentException();
      }

      switch (field) {
      case HOST:
        return isSetHost();
      case DATABASE:
        return isSetDatabase();
      case USER_NAME:
        return isSetUserName();
      case PASSWORD:
        return isSetPassword();
      case TABLE_NAME:
        return isSetTableName();
      case HIVE_TALEB:
        return isSetHiveTaleb();
      }
      throw new IllegalStateException();
    }

    @Override
    public boolean equals(Object that) {
      if (that == null)
        return false;
      if (that instanceof ExportData_args)
        return this.equals((ExportData_args)that);
      return false;
    }

    public boolean equals(ExportData_args that) {
      if (that == null)
        return false;

      boolean this_present_host = true && this.isSetHost();
      boolean that_present_host = true && that.isSetHost();
      if (this_present_host || that_present_host) {
        if (!(this_present_host && that_present_host))
          return false;
        if (!this.host.equals(that.host))
          return false;
      }

      boolean this_present_database = true && this.isSetDatabase();
      boolean that_present_database = true && that.isSetDatabase();
      if (this_present_database || that_present_database) {
        if (!(this_present_database && that_present_database))
          return false;
        if (!this.database.equals(that.database))
          return false;
      }

      boolean this_present_userName = true && this.isSetUserName();
      boolean that_present_userName = true && that.isSetUserName();
      if (this_present_userName || that_present_userName) {
        if (!(this_present_userName && that_present_userName))
          return false;
        if (!this.userName.equals(that.userName))
          return false;
      }

      boolean this_present_password = true && this.isSetPassword();
      boolean that_present_password = true && that.isSetPassword();
      if (this_present_password || that_present_password) {
        if (!(this_present_password && that_present_password))
          return false;
        if (!this.password.equals(that.password))
          return false;
      }

      boolean this_present_tableName = true && this.isSetTableName();
      boolean that_present_tableName = true && that.isSetTableName();
      if (this_present_tableName || that_present_tableName) {
        if (!(this_present_tableName && that_present_tableName))
          return false;
        if (!this.tableName.equals(that.tableName))
          return false;
      }

      boolean this_present_hiveTaleb = true && this.isSetHiveTaleb();
      boolean that_present_hiveTaleb = true && that.isSetHiveTaleb();
      if (this_present_hiveTaleb || that_present_hiveTaleb) {
        if (!(this_present_hiveTaleb && that_present_hiveTaleb))
          return false;
        if (!this.hiveTaleb.equals(that.hiveTaleb))
          return false;
      }

      return true;
    }

    @Override
    public int hashCode() {
      return 0;
    }

    public int compareTo(ExportData_args other) {
      if (!getClass().equals(other.getClass())) {
        return getClass().getName().compareTo(other.getClass().getName());
      }

      int lastComparison = 0;
      ExportData_args typedOther = (ExportData_args)other;

      lastComparison = Boolean.valueOf(isSetHost()).compareTo(typedOther.isSetHost());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetHost()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.host, typedOther.host);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      lastComparison = Boolean.valueOf(isSetDatabase()).compareTo(typedOther.isSetDatabase());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetDatabase()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.database, typedOther.database);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      lastComparison = Boolean.valueOf(isSetUserName()).compareTo(typedOther.isSetUserName());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetUserName()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.userName, typedOther.userName);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      lastComparison = Boolean.valueOf(isSetPassword()).compareTo(typedOther.isSetPassword());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetPassword()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.password, typedOther.password);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      lastComparison = Boolean.valueOf(isSetTableName()).compareTo(typedOther.isSetTableName());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetTableName()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.tableName, typedOther.tableName);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      lastComparison = Boolean.valueOf(isSetHiveTaleb()).compareTo(typedOther.isSetHiveTaleb());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetHiveTaleb()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.hiveTaleb, typedOther.hiveTaleb);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      return 0;
    }

    public _Fields fieldForId(int fieldId) {
      return _Fields.findByThriftId(fieldId);
    }

    public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
      schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
      schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder("ExportData_args(");
      boolean first = true;

      sb.append("host:");
      if (this.host == null) {
        sb.append("null");
      } else {
        sb.append(this.host);
      }
      first = false;
      if (!first) sb.append(", ");
      sb.append("database:");
      if (this.database == null) {
        sb.append("null");
      } else {
        sb.append(this.database);
      }
      first = false;
      if (!first) sb.append(", ");
      sb.append("userName:");
      if (this.userName == null) {
        sb.append("null");
      } else {
        sb.append(this.userName);
      }
      first = false;
      if (!first) sb.append(", ");
      sb.append("password:");
      if (this.password == null) {
        sb.append("null");
      } else {
        sb.append(this.password);
      }
      first = false;
      if (!first) sb.append(", ");
      sb.append("tableName:");
      if (this.tableName == null) {
        sb.append("null");
      } else {
        sb.append(this.tableName);
      }
      first = false;
      if (!first) sb.append(", ");
      sb.append("hiveTaleb:");
      if (this.hiveTaleb == null) {
        sb.append("null");
      } else {
        sb.append(this.hiveTaleb);
      }
      first = false;
      sb.append(")");
      return sb.toString();
    }

    public void validate() throws org.apache.thrift.TException {
      // check for required fields
      // check for sub-struct validity
    }

    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
      try {
        write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
      } catch (org.apache.thrift.TException te) {
        throw new java.io.IOException(te);
      }
    }

    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
      try {
        read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
      } catch (org.apache.thrift.TException te) {
        throw new java.io.IOException(te);
      }
    }

    private static class ExportData_argsStandardSchemeFactory implements SchemeFactory {
      public ExportData_argsStandardScheme getScheme() {
        return new ExportData_argsStandardScheme();
      }
    }

    private static class ExportData_argsStandardScheme extends StandardScheme<ExportData_args> {

      public void read(org.apache.thrift.protocol.TProtocol iprot, ExportData_args struct) throws org.apache.thrift.TException {
        org.apache.thrift.protocol.TField schemeField;
        iprot.readStructBegin();
        while (true)
        {
          schemeField = iprot.readFieldBegin();
          if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
            break;
          }
          switch (schemeField.id) {
            case 1: // HOST
              if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                struct.host = iprot.readString();
                struct.setHostIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            case 2: // DATABASE
              if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                struct.database = iprot.readString();
                struct.setDatabaseIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            case 3: // USER_NAME
              if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                struct.userName = iprot.readString();
                struct.setUserNameIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            case 4: // PASSWORD
              if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                struct.password = iprot.readString();
                struct.setPasswordIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            case 5: // TABLE_NAME
              if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                struct.tableName = iprot.readString();
                struct.setTableNameIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            case 6: // HIVE_TALEB
              if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                struct.hiveTaleb = iprot.readString();
                struct.setHiveTalebIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            default:
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
          }
          iprot.readFieldEnd();
        }
        iprot.readStructEnd();

        // check for required fields of primitive type, which can't be checked in the validate method
        struct.validate();
      }

      public void write(org.apache.thrift.protocol.TProtocol oprot, ExportData_args struct) throws org.apache.thrift.TException {
        struct.validate();

        oprot.writeStructBegin(STRUCT_DESC);
        if (struct.host != null) {
          oprot.writeFieldBegin(HOST_FIELD_DESC);
          oprot.writeString(struct.host);
          oprot.writeFieldEnd();
        }
        if (struct.database != null) {
          oprot.writeFieldBegin(DATABASE_FIELD_DESC);
          oprot.writeString(struct.database);
          oprot.writeFieldEnd();
        }
        if (struct.userName != null) {
          oprot.writeFieldBegin(USER_NAME_FIELD_DESC);
          oprot.writeString(struct.userName);
          oprot.writeFieldEnd();
        }
        if (struct.password != null) {
          oprot.writeFieldBegin(PASSWORD_FIELD_DESC);
          oprot.writeString(struct.password);
          oprot.writeFieldEnd();
        }
        if (struct.tableName != null) {
          oprot.writeFieldBegin(TABLE_NAME_FIELD_DESC);
          oprot.writeString(struct.tableName);
          oprot.writeFieldEnd();
        }
        if (struct.hiveTaleb != null) {
          oprot.writeFieldBegin(HIVE_TALEB_FIELD_DESC);
          oprot.writeString(struct.hiveTaleb);
          oprot.writeFieldEnd();
        }
        oprot.writeFieldStop();
        oprot.writeStructEnd();
      }

    }

    private static class ExportData_argsTupleSchemeFactory implements SchemeFactory {
      public ExportData_argsTupleScheme getScheme() {
        return new ExportData_argsTupleScheme();
      }
    }

    private static class ExportData_argsTupleScheme extends TupleScheme<ExportData_args> {

      @Override
      public void write(org.apache.thrift.protocol.TProtocol prot, ExportData_args struct) throws org.apache.thrift.TException {
        TTupleProtocol oprot = (TTupleProtocol) prot;
        BitSet optionals = new BitSet();
        if (struct.isSetHost()) {
          optionals.set(0);
        }
        if (struct.isSetDatabase()) {
          optionals.set(1);
        }
        if (struct.isSetUserName()) {
          optionals.set(2);
        }
        if (struct.isSetPassword()) {
          optionals.set(3);
        }
        if (struct.isSetTableName()) {
          optionals.set(4);
        }
        if (struct.isSetHiveTaleb()) {
          optionals.set(5);
        }
        oprot.writeBitSet(optionals, 6);
        if (struct.isSetHost()) {
          oprot.writeString(struct.host);
        }
        if (struct.isSetDatabase()) {
          oprot.writeString(struct.database);
        }
        if (struct.isSetUserName()) {
          oprot.writeString(struct.userName);
        }
        if (struct.isSetPassword()) {
          oprot.writeString(struct.password);
        }
        if (struct.isSetTableName()) {
          oprot.writeString(struct.tableName);
        }
        if (struct.isSetHiveTaleb()) {
          oprot.writeString(struct.hiveTaleb);
        }
      }

      @Override
      public void read(org.apache.thrift.protocol.TProtocol prot, ExportData_args struct) throws org.apache.thrift.TException {
        TTupleProtocol iprot = (TTupleProtocol) prot;
        BitSet incoming = iprot.readBitSet(6);
        if (incoming.get(0)) {
          struct.host = iprot.readString();
          struct.setHostIsSet(true);
        }
        if (incoming.get(1)) {
          struct.database = iprot.readString();
          struct.setDatabaseIsSet(true);
        }
        if (incoming.get(2)) {
          struct.userName = iprot.readString();
          struct.setUserNameIsSet(true);
        }
        if (incoming.get(3)) {
          struct.password = iprot.readString();
          struct.setPasswordIsSet(true);
        }
        if (incoming.get(4)) {
          struct.tableName = iprot.readString();
          struct.setTableNameIsSet(true);
        }
        if (incoming.get(5)) {
          struct.hiveTaleb = iprot.readString();
          struct.setHiveTalebIsSet(true);
        }
      }
    }

  }

  public static class ExportData_result implements org.apache.thrift.TBase<ExportData_result, ExportData_result._Fields>, java.io.Serializable, Cloneable   {
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ExportData_result");

    private static final org.apache.thrift.protocol.TField SUCCESS_FIELD_DESC = new org.apache.thrift.protocol.TField("success", org.apache.thrift.protocol.TType.STRING, (short)0);

    private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
    static {
      schemes.put(StandardScheme.class, new ExportData_resultStandardSchemeFactory());
      schemes.put(TupleScheme.class, new ExportData_resultTupleSchemeFactory());
    }

    public String success; // required

    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
      SUCCESS((short)0, "success");

      private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

      static {
        for (_Fields field : EnumSet.allOf(_Fields.class)) {
          byName.put(field.getFieldName(), field);
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, or null if its not found.
       */
      public static _Fields findByThriftId(int fieldId) {
        switch(fieldId) {
          case 0: // SUCCESS
            return SUCCESS;
          default:
            return null;
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, throwing an exception
       * if it is not found.
       */
      public static _Fields findByThriftIdOrThrow(int fieldId) {
        _Fields fields = findByThriftId(fieldId);
        if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
        return fields;
      }

      /**
       * Find the _Fields constant that matches name, or null if its not found.
       */
      public static _Fields findByName(String name) {
        return byName.get(name);
      }

      private final short _thriftId;
      private final String _fieldName;

      _Fields(short thriftId, String fieldName) {
        _thriftId = thriftId;
        _fieldName = fieldName;
      }

      public short getThriftFieldId() {
        return _thriftId;
      }

      public String getFieldName() {
        return _fieldName;
      }
    }

    // isset id assignments
    public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
    static {
      Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
      tmpMap.put(_Fields.SUCCESS, new org.apache.thrift.meta_data.FieldMetaData("success", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
      metaDataMap = Collections.unmodifiableMap(tmpMap);
      org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ExportData_result.class, metaDataMap);
    }

    public ExportData_result() {
    }

    public ExportData_result(
      String success)
    {
      this();
      this.success = success;
    }

    /**
     * Performs a deep copy on <i>other</i>.
     */
    public ExportData_result(ExportData_result other) {
      if (other.isSetSuccess()) {
        this.success = other.success;
      }
    }

    public ExportData_result deepCopy() {
      return new ExportData_result(this);
    }

    @Override
    public void clear() {
      this.success = null;
    }

    public String getSuccess() {
      return this.success;
    }

    public ExportData_result setSuccess(String success) {
      this.success = success;
      return this;
    }

    public void unsetSuccess() {
      this.success = null;
    }

    /** Returns true if field success is set (has been assigned a value) and false otherwise */
    public boolean isSetSuccess() {
      return this.success != null;
    }

    public void setSuccessIsSet(boolean value) {
      if (!value) {
        this.success = null;
      }
    }

    public void setFieldValue(_Fields field, Object value) {
      switch (field) {
      case SUCCESS:
        if (value == null) {
          unsetSuccess();
        } else {
          setSuccess((String)value);
        }
        break;

      }
    }

    public Object getFieldValue(_Fields field) {
      switch (field) {
      case SUCCESS:
        return getSuccess();

      }
      throw new IllegalStateException();
    }

    /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
    public boolean isSet(_Fields field) {
      if (field == null) {
        throw new IllegalArgumentException();
      }

      switch (field) {
      case SUCCESS:
        return isSetSuccess();
      }
      throw new IllegalStateException();
    }

    @Override
    public boolean equals(Object that) {
      if (that == null)
        return false;
      if (that instanceof ExportData_result)
        return this.equals((ExportData_result)that);
      return false;
    }

    public boolean equals(ExportData_result that) {
      if (that == null)
        return false;

      boolean this_present_success = true && this.isSetSuccess();
      boolean that_present_success = true && that.isSetSuccess();
      if (this_present_success || that_present_success) {
        if (!(this_present_success && that_present_success))
          return false;
        if (!this.success.equals(that.success))
          return false;
      }

      return true;
    }

    @Override
    public int hashCode() {
      return 0;
    }

    public int compareTo(ExportData_result other) {
      if (!getClass().equals(other.getClass())) {
        return getClass().getName().compareTo(other.getClass().getName());
      }

      int lastComparison = 0;
      ExportData_result typedOther = (ExportData_result)other;

      lastComparison = Boolean.valueOf(isSetSuccess()).compareTo(typedOther.isSetSuccess());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetSuccess()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.success, typedOther.success);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      return 0;
    }

    public _Fields fieldForId(int fieldId) {
      return _Fields.findByThriftId(fieldId);
    }

    public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
      schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
      schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
      }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder("ExportData_result(");
      boolean first = true;

      sb.append("success:");
      if (this.success == null) {
        sb.append("null");
      } else {
        sb.append(this.success);
      }
      first = false;
      sb.append(")");
      return sb.toString();
    }

    public void validate() throws org.apache.thrift.TException {
      // check for required fields
      // check for sub-struct validity
    }

    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
      try {
        write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
      } catch (org.apache.thrift.TException te) {
        throw new java.io.IOException(te);
      }
    }

    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
      try {
        read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
      } catch (org.apache.thrift.TException te) {
        throw new java.io.IOException(te);
      }
    }

    private static class ExportData_resultStandardSchemeFactory implements SchemeFactory {
      public ExportData_resultStandardScheme getScheme() {
        return new ExportData_resultStandardScheme();
      }
    }

    private static class ExportData_resultStandardScheme extends StandardScheme<ExportData_result> {

      public void read(org.apache.thrift.protocol.TProtocol iprot, ExportData_result struct) throws org.apache.thrift.TException {
        org.apache.thrift.protocol.TField schemeField;
        iprot.readStructBegin();
        while (true)
        {
          schemeField = iprot.readFieldBegin();
          if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
            break;
          }
          switch (schemeField.id) {
            case 0: // SUCCESS
              if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                struct.success = iprot.readString();
                struct.setSuccessIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            default:
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
          }
          iprot.readFieldEnd();
        }
        iprot.readStructEnd();

        // check for required fields of primitive type, which can't be checked in the validate method
        struct.validate();
      }

      public void write(org.apache.thrift.protocol.TProtocol oprot, ExportData_result struct) throws org.apache.thrift.TException {
        struct.validate();

        oprot.writeStructBegin(STRUCT_DESC);
        if (struct.success != null) {
          oprot.writeFieldBegin(SUCCESS_FIELD_DESC);
          oprot.writeString(struct.success);
          oprot.writeFieldEnd();
        }
        oprot.writeFieldStop();
        oprot.writeStructEnd();
      }

    }

    private static class ExportData_resultTupleSchemeFactory implements SchemeFactory {
      public ExportData_resultTupleScheme getScheme() {
        return new ExportData_resultTupleScheme();
      }
    }

    private static class ExportData_resultTupleScheme extends TupleScheme<ExportData_result> {

      @Override
      public void write(org.apache.thrift.protocol.TProtocol prot, ExportData_result struct) throws org.apache.thrift.TException {
        TTupleProtocol oprot = (TTupleProtocol) prot;
        BitSet optionals = new BitSet();
        if (struct.isSetSuccess()) {
          optionals.set(0);
        }
        oprot.writeBitSet(optionals, 1);
        if (struct.isSetSuccess()) {
          oprot.writeString(struct.success);
        }
      }

      @Override
      public void read(org.apache.thrift.protocol.TProtocol prot, ExportData_result struct) throws org.apache.thrift.TException {
        TTupleProtocol iprot = (TTupleProtocol) prot;
        BitSet incoming = iprot.readBitSet(1);
        if (incoming.get(0)) {
          struct.success = iprot.readString();
          struct.setSuccessIsSet(true);
        }
      }
    }

  }

  public static class ExportDataUpdate_args implements org.apache.thrift.TBase<ExportDataUpdate_args, ExportDataUpdate_args._Fields>, java.io.Serializable, Cloneable   {
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ExportDataUpdate_args");

    private static final org.apache.thrift.protocol.TField HOST_FIELD_DESC = new org.apache.thrift.protocol.TField("host", org.apache.thrift.protocol.TType.STRING, (short)1);
    private static final org.apache.thrift.protocol.TField DATABASE_FIELD_DESC = new org.apache.thrift.protocol.TField("database", org.apache.thrift.protocol.TType.STRING, (short)2);
    private static final org.apache.thrift.protocol.TField USER_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("userName", org.apache.thrift.protocol.TType.STRING, (short)3);
    private static final org.apache.thrift.protocol.TField PASSWORD_FIELD_DESC = new org.apache.thrift.protocol.TField("password", org.apache.thrift.protocol.TType.STRING, (short)4);
    private static final org.apache.thrift.protocol.TField TABLE_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("tableName", org.apache.thrift.protocol.TType.STRING, (short)5);
    private static final org.apache.thrift.protocol.TField HIVE_TALEB_FIELD_DESC = new org.apache.thrift.protocol.TField("hiveTaleb", org.apache.thrift.protocol.TType.STRING, (short)6);
    private static final org.apache.thrift.protocol.TField KEYFIELD_FIELD_DESC = new org.apache.thrift.protocol.TField("keyfield", org.apache.thrift.protocol.TType.STRING, (short)7);

    private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
    static {
      schemes.put(StandardScheme.class, new ExportDataUpdate_argsStandardSchemeFactory());
      schemes.put(TupleScheme.class, new ExportDataUpdate_argsTupleSchemeFactory());
    }

    public String host; // required
    public String database; // required
    public String userName; // required
    public String password; // required
    public String tableName; // required
    public String hiveTaleb; // required
    public String keyfield; // required

    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
      HOST((short)1, "host"),
      DATABASE((short)2, "database"),
      USER_NAME((short)3, "userName"),
      PASSWORD((short)4, "password"),
      TABLE_NAME((short)5, "tableName"),
      HIVE_TALEB((short)6, "hiveTaleb"),
      KEYFIELD((short)7, "keyfield");

      private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

      static {
        for (_Fields field : EnumSet.allOf(_Fields.class)) {
          byName.put(field.getFieldName(), field);
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, or null if its not found.
       */
      public static _Fields findByThriftId(int fieldId) {
        switch(fieldId) {
          case 1: // HOST
            return HOST;
          case 2: // DATABASE
            return DATABASE;
          case 3: // USER_NAME
            return USER_NAME;
          case 4: // PASSWORD
            return PASSWORD;
          case 5: // TABLE_NAME
            return TABLE_NAME;
          case 6: // HIVE_TALEB
            return HIVE_TALEB;
          case 7: // KEYFIELD
            return KEYFIELD;
          default:
            return null;
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, throwing an exception
       * if it is not found.
       */
      public static _Fields findByThriftIdOrThrow(int fieldId) {
        _Fields fields = findByThriftId(fieldId);
        if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
        return fields;
      }

      /**
       * Find the _Fields constant that matches name, or null if its not found.
       */
      public static _Fields findByName(String name) {
        return byName.get(name);
      }

      private final short _thriftId;
      private final String _fieldName;

      _Fields(short thriftId, String fieldName) {
        _thriftId = thriftId;
        _fieldName = fieldName;
      }

      public short getThriftFieldId() {
        return _thriftId;
      }

      public String getFieldName() {
        return _fieldName;
      }
    }

    // isset id assignments
    public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
    static {
      Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
      tmpMap.put(_Fields.HOST, new org.apache.thrift.meta_data.FieldMetaData("host", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
      tmpMap.put(_Fields.DATABASE, new org.apache.thrift.meta_data.FieldMetaData("database", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
      tmpMap.put(_Fields.USER_NAME, new org.apache.thrift.meta_data.FieldMetaData("userName", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
      tmpMap.put(_Fields.PASSWORD, new org.apache.thrift.meta_data.FieldMetaData("password", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
      tmpMap.put(_Fields.TABLE_NAME, new org.apache.thrift.meta_data.FieldMetaData("tableName", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
      tmpMap.put(_Fields.HIVE_TALEB, new org.apache.thrift.meta_data.FieldMetaData("hiveTaleb", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
      tmpMap.put(_Fields.KEYFIELD, new org.apache.thrift.meta_data.FieldMetaData("keyfield", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
      metaDataMap = Collections.unmodifiableMap(tmpMap);
      org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ExportDataUpdate_args.class, metaDataMap);
    }

    public ExportDataUpdate_args() {
    }

    public ExportDataUpdate_args(
      String host,
      String database,
      String userName,
      String password,
      String tableName,
      String hiveTaleb,
      String keyfield)
    {
      this();
      this.host = host;
      this.database = database;
      this.userName = userName;
      this.password = password;
      this.tableName = tableName;
      this.hiveTaleb = hiveTaleb;
      this.keyfield = keyfield;
    }

    /**
     * Performs a deep copy on <i>other</i>.
     */
    public ExportDataUpdate_args(ExportDataUpdate_args other) {
      if (other.isSetHost()) {
        this.host = other.host;
      }
      if (other.isSetDatabase()) {
        this.database = other.database;
      }
      if (other.isSetUserName()) {
        this.userName = other.userName;
      }
      if (other.isSetPassword()) {
        this.password = other.password;
      }
      if (other.isSetTableName()) {
        this.tableName = other.tableName;
      }
      if (other.isSetHiveTaleb()) {
        this.hiveTaleb = other.hiveTaleb;
      }
      if (other.isSetKeyfield()) {
        this.keyfield = other.keyfield;
      }
    }

    public ExportDataUpdate_args deepCopy() {
      return new ExportDataUpdate_args(this);
    }

    @Override
    public void clear() {
      this.host = null;
      this.database = null;
      this.userName = null;
      this.password = null;
      this.tableName = null;
      this.hiveTaleb = null;
      this.keyfield = null;
    }

    public String getHost() {
      return this.host;
    }

    public ExportDataUpdate_args setHost(String host) {
      this.host = host;
      return this;
    }

    public void unsetHost() {
      this.host = null;
    }

    /** Returns true if field host is set (has been assigned a value) and false otherwise */
    public boolean isSetHost() {
      return this.host != null;
    }

    public void setHostIsSet(boolean value) {
      if (!value) {
        this.host = null;
      }
    }

    public String getDatabase() {
      return this.database;
    }

    public ExportDataUpdate_args setDatabase(String database) {
      this.database = database;
      return this;
    }

    public void unsetDatabase() {
      this.database = null;
    }

    /** Returns true if field database is set (has been assigned a value) and false otherwise */
    public boolean isSetDatabase() {
      return this.database != null;
    }

    public void setDatabaseIsSet(boolean value) {
      if (!value) {
        this.database = null;
      }
    }

    public String getUserName() {
      return this.userName;
    }

    public ExportDataUpdate_args setUserName(String userName) {
      this.userName = userName;
      return this;
    }

    public void unsetUserName() {
      this.userName = null;
    }

    /** Returns true if field userName is set (has been assigned a value) and false otherwise */
    public boolean isSetUserName() {
      return this.userName != null;
    }

    public void setUserNameIsSet(boolean value) {
      if (!value) {
        this.userName = null;
      }
    }

    public String getPassword() {
      return this.password;
    }

    public ExportDataUpdate_args setPassword(String password) {
      this.password = password;
      return this;
    }

    public void unsetPassword() {
      this.password = null;
    }

    /** Returns true if field password is set (has been assigned a value) and false otherwise */
    public boolean isSetPassword() {
      return this.password != null;
    }

    public void setPasswordIsSet(boolean value) {
      if (!value) {
        this.password = null;
      }
    }

    public String getTableName() {
      return this.tableName;
    }

    public ExportDataUpdate_args setTableName(String tableName) {
      this.tableName = tableName;
      return this;
    }

    public void unsetTableName() {
      this.tableName = null;
    }

    /** Returns true if field tableName is set (has been assigned a value) and false otherwise */
    public boolean isSetTableName() {
      return this.tableName != null;
    }

    public void setTableNameIsSet(boolean value) {
      if (!value) {
        this.tableName = null;
      }
    }

    public String getHiveTaleb() {
      return this.hiveTaleb;
    }

    public ExportDataUpdate_args setHiveTaleb(String hiveTaleb) {
      this.hiveTaleb = hiveTaleb;
      return this;
    }

    public void unsetHiveTaleb() {
      this.hiveTaleb = null;
    }

    /** Returns true if field hiveTaleb is set (has been assigned a value) and false otherwise */
    public boolean isSetHiveTaleb() {
      return this.hiveTaleb != null;
    }

    public void setHiveTalebIsSet(boolean value) {
      if (!value) {
        this.hiveTaleb = null;
      }
    }

    public String getKeyfield() {
      return this.keyfield;
    }

    public ExportDataUpdate_args setKeyfield(String keyfield) {
      this.keyfield = keyfield;
      return this;
    }

    public void unsetKeyfield() {
      this.keyfield = null;
    }

    /** Returns true if field keyfield is set (has been assigned a value) and false otherwise */
    public boolean isSetKeyfield() {
      return this.keyfield != null;
    }

    public void setKeyfieldIsSet(boolean value) {
      if (!value) {
        this.keyfield = null;
      }
    }

    public void setFieldValue(_Fields field, Object value) {
      switch (field) {
      case HOST:
        if (value == null) {
          unsetHost();
        } else {
          setHost((String)value);
        }
        break;

      case DATABASE:
        if (value == null) {
          unsetDatabase();
        } else {
          setDatabase((String)value);
        }
        break;

      case USER_NAME:
        if (value == null) {
          unsetUserName();
        } else {
          setUserName((String)value);
        }
        break;

      case PASSWORD:
        if (value == null) {
          unsetPassword();
        } else {
          setPassword((String)value);
        }
        break;

      case TABLE_NAME:
        if (value == null) {
          unsetTableName();
        } else {
          setTableName((String)value);
        }
        break;

      case HIVE_TALEB:
        if (value == null) {
          unsetHiveTaleb();
        } else {
          setHiveTaleb((String)value);
        }
        break;

      case KEYFIELD:
        if (value == null) {
          unsetKeyfield();
        } else {
          setKeyfield((String)value);
        }
        break;

      }
    }

    public Object getFieldValue(_Fields field) {
      switch (field) {
      case HOST:
        return getHost();

      case DATABASE:
        return getDatabase();

      case USER_NAME:
        return getUserName();

      case PASSWORD:
        return getPassword();

      case TABLE_NAME:
        return getTableName();

      case HIVE_TALEB:
        return getHiveTaleb();

      case KEYFIELD:
        return getKeyfield();

      }
      throw new IllegalStateException();
    }

    /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
    public boolean isSet(_Fields field) {
      if (field == null) {
        throw new IllegalArgumentException();
      }

      switch (field) {
      case HOST:
        return isSetHost();
      case DATABASE:
        return isSetDatabase();
      case USER_NAME:
        return isSetUserName();
      case PASSWORD:
        return isSetPassword();
      case TABLE_NAME:
        return isSetTableName();
      case HIVE_TALEB:
        return isSetHiveTaleb();
      case KEYFIELD:
        return isSetKeyfield();
      }
      throw new IllegalStateException();
    }

    @Override
    public boolean equals(Object that) {
      if (that == null)
        return false;
      if (that instanceof ExportDataUpdate_args)
        return this.equals((ExportDataUpdate_args)that);
      return false;
    }

    public boolean equals(ExportDataUpdate_args that) {
      if (that == null)
        return false;

      boolean this_present_host = true && this.isSetHost();
      boolean that_present_host = true && that.isSetHost();
      if (this_present_host || that_present_host) {
        if (!(this_present_host && that_present_host))
          return false;
        if (!this.host.equals(that.host))
          return false;
      }

      boolean this_present_database = true && this.isSetDatabase();
      boolean that_present_database = true && that.isSetDatabase();
      if (this_present_database || that_present_database) {
        if (!(this_present_database && that_present_database))
          return false;
        if (!this.database.equals(that.database))
          return false;
      }

      boolean this_present_userName = true && this.isSetUserName();
      boolean that_present_userName = true && that.isSetUserName();
      if (this_present_userName || that_present_userName) {
        if (!(this_present_userName && that_present_userName))
          return false;
        if (!this.userName.equals(that.userName))
          return false;
      }

      boolean this_present_password = true && this.isSetPassword();
      boolean that_present_password = true && that.isSetPassword();
      if (this_present_password || that_present_password) {
        if (!(this_present_password && that_present_password))
          return false;
        if (!this.password.equals(that.password))
          return false;
      }

      boolean this_present_tableName = true && this.isSetTableName();
      boolean that_present_tableName = true && that.isSetTableName();
      if (this_present_tableName || that_present_tableName) {
        if (!(this_present_tableName && that_present_tableName))
          return false;
        if (!this.tableName.equals(that.tableName))
          return false;
      }

      boolean this_present_hiveTaleb = true && this.isSetHiveTaleb();
      boolean that_present_hiveTaleb = true && that.isSetHiveTaleb();
      if (this_present_hiveTaleb || that_present_hiveTaleb) {
        if (!(this_present_hiveTaleb && that_present_hiveTaleb))
          return false;
        if (!this.hiveTaleb.equals(that.hiveTaleb))
          return false;
      }

      boolean this_present_keyfield = true && this.isSetKeyfield();
      boolean that_present_keyfield = true && that.isSetKeyfield();
      if (this_present_keyfield || that_present_keyfield) {
        if (!(this_present_keyfield && that_present_keyfield))
          return false;
        if (!this.keyfield.equals(that.keyfield))
          return false;
      }

      return true;
    }

    @Override
    public int hashCode() {
      return 0;
    }

    public int compareTo(ExportDataUpdate_args other) {
      if (!getClass().equals(other.getClass())) {
        return getClass().getName().compareTo(other.getClass().getName());
      }

      int lastComparison = 0;
      ExportDataUpdate_args typedOther = (ExportDataUpdate_args)other;

      lastComparison = Boolean.valueOf(isSetHost()).compareTo(typedOther.isSetHost());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetHost()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.host, typedOther.host);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      lastComparison = Boolean.valueOf(isSetDatabase()).compareTo(typedOther.isSetDatabase());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetDatabase()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.database, typedOther.database);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      lastComparison = Boolean.valueOf(isSetUserName()).compareTo(typedOther.isSetUserName());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetUserName()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.userName, typedOther.userName);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      lastComparison = Boolean.valueOf(isSetPassword()).compareTo(typedOther.isSetPassword());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetPassword()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.password, typedOther.password);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      lastComparison = Boolean.valueOf(isSetTableName()).compareTo(typedOther.isSetTableName());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetTableName()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.tableName, typedOther.tableName);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      lastComparison = Boolean.valueOf(isSetHiveTaleb()).compareTo(typedOther.isSetHiveTaleb());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetHiveTaleb()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.hiveTaleb, typedOther.hiveTaleb);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      lastComparison = Boolean.valueOf(isSetKeyfield()).compareTo(typedOther.isSetKeyfield());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetKeyfield()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.keyfield, typedOther.keyfield);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      return 0;
    }

    public _Fields fieldForId(int fieldId) {
      return _Fields.findByThriftId(fieldId);
    }

    public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
      schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
      schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder("ExportDataUpdate_args(");
      boolean first = true;

      sb.append("host:");
      if (this.host == null) {
        sb.append("null");
      } else {
        sb.append(this.host);
      }
      first = false;
      if (!first) sb.append(", ");
      sb.append("database:");
      if (this.database == null) {
        sb.append("null");
      } else {
        sb.append(this.database);
      }
      first = false;
      if (!first) sb.append(", ");
      sb.append("userName:");
      if (this.userName == null) {
        sb.append("null");
      } else {
        sb.append(this.userName);
      }
      first = false;
      if (!first) sb.append(", ");
      sb.append("password:");
      if (this.password == null) {
        sb.append("null");
      } else {
        sb.append(this.password);
      }
      first = false;
      if (!first) sb.append(", ");
      sb.append("tableName:");
      if (this.tableName == null) {
        sb.append("null");
      } else {
        sb.append(this.tableName);
      }
      first = false;
      if (!first) sb.append(", ");
      sb.append("hiveTaleb:");
      if (this.hiveTaleb == null) {
        sb.append("null");
      } else {
        sb.append(this.hiveTaleb);
      }
      first = false;
      if (!first) sb.append(", ");
      sb.append("keyfield:");
      if (this.keyfield == null) {
        sb.append("null");
      } else {
        sb.append(this.keyfield);
      }
      first = false;
      sb.append(")");
      return sb.toString();
    }

    public void validate() throws org.apache.thrift.TException {
      // check for required fields
      // check for sub-struct validity
    }

    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
      try {
        write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
      } catch (org.apache.thrift.TException te) {
        throw new java.io.IOException(te);
      }
    }

    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
      try {
        read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
      } catch (org.apache.thrift.TException te) {
        throw new java.io.IOException(te);
      }
    }

    private static class ExportDataUpdate_argsStandardSchemeFactory implements SchemeFactory {
      public ExportDataUpdate_argsStandardScheme getScheme() {
        return new ExportDataUpdate_argsStandardScheme();
      }
    }

    private static class ExportDataUpdate_argsStandardScheme extends StandardScheme<ExportDataUpdate_args> {

      public void read(org.apache.thrift.protocol.TProtocol iprot, ExportDataUpdate_args struct) throws org.apache.thrift.TException {
        org.apache.thrift.protocol.TField schemeField;
        iprot.readStructBegin();
        while (true)
        {
          schemeField = iprot.readFieldBegin();
          if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
            break;
          }
          switch (schemeField.id) {
            case 1: // HOST
              if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                struct.host = iprot.readString();
                struct.setHostIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            case 2: // DATABASE
              if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                struct.database = iprot.readString();
                struct.setDatabaseIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            case 3: // USER_NAME
              if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                struct.userName = iprot.readString();
                struct.setUserNameIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            case 4: // PASSWORD
              if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                struct.password = iprot.readString();
                struct.setPasswordIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            case 5: // TABLE_NAME
              if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                struct.tableName = iprot.readString();
                struct.setTableNameIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            case 6: // HIVE_TALEB
              if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                struct.hiveTaleb = iprot.readString();
                struct.setHiveTalebIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            case 7: // KEYFIELD
              if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                struct.keyfield = iprot.readString();
                struct.setKeyfieldIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            default:
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
          }
          iprot.readFieldEnd();
        }
        iprot.readStructEnd();

        // check for required fields of primitive type, which can't be checked in the validate method
        struct.validate();
      }

      public void write(org.apache.thrift.protocol.TProtocol oprot, ExportDataUpdate_args struct) throws org.apache.thrift.TException {
        struct.validate();

        oprot.writeStructBegin(STRUCT_DESC);
        if (struct.host != null) {
          oprot.writeFieldBegin(HOST_FIELD_DESC);
          oprot.writeString(struct.host);
          oprot.writeFieldEnd();
        }
        if (struct.database != null) {
          oprot.writeFieldBegin(DATABASE_FIELD_DESC);
          oprot.writeString(struct.database);
          oprot.writeFieldEnd();
        }
        if (struct.userName != null) {
          oprot.writeFieldBegin(USER_NAME_FIELD_DESC);
          oprot.writeString(struct.userName);
          oprot.writeFieldEnd();
        }
        if (struct.password != null) {
          oprot.writeFieldBegin(PASSWORD_FIELD_DESC);
          oprot.writeString(struct.password);
          oprot.writeFieldEnd();
        }
        if (struct.tableName != null) {
          oprot.writeFieldBegin(TABLE_NAME_FIELD_DESC);
          oprot.writeString(struct.tableName);
          oprot.writeFieldEnd();
        }
        if (struct.hiveTaleb != null) {
          oprot.writeFieldBegin(HIVE_TALEB_FIELD_DESC);
          oprot.writeString(struct.hiveTaleb);
          oprot.writeFieldEnd();
        }
        if (struct.keyfield != null) {
          oprot.writeFieldBegin(KEYFIELD_FIELD_DESC);
          oprot.writeString(struct.keyfield);
          oprot.writeFieldEnd();
        }
        oprot.writeFieldStop();
        oprot.writeStructEnd();
      }

    }

    private static class ExportDataUpdate_argsTupleSchemeFactory implements SchemeFactory {
      public ExportDataUpdate_argsTupleScheme getScheme() {
        return new ExportDataUpdate_argsTupleScheme();
      }
    }

    private static class ExportDataUpdate_argsTupleScheme extends TupleScheme<ExportDataUpdate_args> {

      @Override
      public void write(org.apache.thrift.protocol.TProtocol prot, ExportDataUpdate_args struct) throws org.apache.thrift.TException {
        TTupleProtocol oprot = (TTupleProtocol) prot;
        BitSet optionals = new BitSet();
        if (struct.isSetHost()) {
          optionals.set(0);
        }
        if (struct.isSetDatabase()) {
          optionals.set(1);
        }
        if (struct.isSetUserName()) {
          optionals.set(2);
        }
        if (struct.isSetPassword()) {
          optionals.set(3);
        }
        if (struct.isSetTableName()) {
          optionals.set(4);
        }
        if (struct.isSetHiveTaleb()) {
          optionals.set(5);
        }
        if (struct.isSetKeyfield()) {
          optionals.set(6);
        }
        oprot.writeBitSet(optionals, 7);
        if (struct.isSetHost()) {
          oprot.writeString(struct.host);
        }
        if (struct.isSetDatabase()) {
          oprot.writeString(struct.database);
        }
        if (struct.isSetUserName()) {
          oprot.writeString(struct.userName);
        }
        if (struct.isSetPassword()) {
          oprot.writeString(struct.password);
        }
        if (struct.isSetTableName()) {
          oprot.writeString(struct.tableName);
        }
        if (struct.isSetHiveTaleb()) {
          oprot.writeString(struct.hiveTaleb);
        }
        if (struct.isSetKeyfield()) {
          oprot.writeString(struct.keyfield);
        }
      }

      @Override
      public void read(org.apache.thrift.protocol.TProtocol prot, ExportDataUpdate_args struct) throws org.apache.thrift.TException {
        TTupleProtocol iprot = (TTupleProtocol) prot;
        BitSet incoming = iprot.readBitSet(7);
        if (incoming.get(0)) {
          struct.host = iprot.readString();
          struct.setHostIsSet(true);
        }
        if (incoming.get(1)) {
          struct.database = iprot.readString();
          struct.setDatabaseIsSet(true);
        }
        if (incoming.get(2)) {
          struct.userName = iprot.readString();
          struct.setUserNameIsSet(true);
        }
        if (incoming.get(3)) {
          struct.password = iprot.readString();
          struct.setPasswordIsSet(true);
        }
        if (incoming.get(4)) {
          struct.tableName = iprot.readString();
          struct.setTableNameIsSet(true);
        }
        if (incoming.get(5)) {
          struct.hiveTaleb = iprot.readString();
          struct.setHiveTalebIsSet(true);
        }
        if (incoming.get(6)) {
          struct.keyfield = iprot.readString();
          struct.setKeyfieldIsSet(true);
        }
      }
    }

  }

  public static class ExportDataUpdate_result implements org.apache.thrift.TBase<ExportDataUpdate_result, ExportDataUpdate_result._Fields>, java.io.Serializable, Cloneable   {
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ExportDataUpdate_result");

    private static final org.apache.thrift.protocol.TField SUCCESS_FIELD_DESC = new org.apache.thrift.protocol.TField("success", org.apache.thrift.protocol.TType.STRING, (short)0);

    private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
    static {
      schemes.put(StandardScheme.class, new ExportDataUpdate_resultStandardSchemeFactory());
      schemes.put(TupleScheme.class, new ExportDataUpdate_resultTupleSchemeFactory());
    }

    public String success; // required

    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
      SUCCESS((short)0, "success");

      private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

      static {
        for (_Fields field : EnumSet.allOf(_Fields.class)) {
          byName.put(field.getFieldName(), field);
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, or null if its not found.
       */
      public static _Fields findByThriftId(int fieldId) {
        switch(fieldId) {
          case 0: // SUCCESS
            return SUCCESS;
          default:
            return null;
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, throwing an exception
       * if it is not found.
       */
      public static _Fields findByThriftIdOrThrow(int fieldId) {
        _Fields fields = findByThriftId(fieldId);
        if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
        return fields;
      }

      /**
       * Find the _Fields constant that matches name, or null if its not found.
       */
      public static _Fields findByName(String name) {
        return byName.get(name);
      }

      private final short _thriftId;
      private final String _fieldName;

      _Fields(short thriftId, String fieldName) {
        _thriftId = thriftId;
        _fieldName = fieldName;
      }

      public short getThriftFieldId() {
        return _thriftId;
      }

      public String getFieldName() {
        return _fieldName;
      }
    }

    // isset id assignments
    public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
    static {
      Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
      tmpMap.put(_Fields.SUCCESS, new org.apache.thrift.meta_data.FieldMetaData("success", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
      metaDataMap = Collections.unmodifiableMap(tmpMap);
      org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ExportDataUpdate_result.class, metaDataMap);
    }

    public ExportDataUpdate_result() {
    }

    public ExportDataUpdate_result(
      String success)
    {
      this();
      this.success = success;
    }

    /**
     * Performs a deep copy on <i>other</i>.
     */
    public ExportDataUpdate_result(ExportDataUpdate_result other) {
      if (other.isSetSuccess()) {
        this.success = other.success;
      }
    }

    public ExportDataUpdate_result deepCopy() {
      return new ExportDataUpdate_result(this);
    }

    @Override
    public void clear() {
      this.success = null;
    }

    public String getSuccess() {
      return this.success;
    }

    public ExportDataUpdate_result setSuccess(String success) {
      this.success = success;
      return this;
    }

    public void unsetSuccess() {
      this.success = null;
    }

    /** Returns true if field success is set (has been assigned a value) and false otherwise */
    public boolean isSetSuccess() {
      return this.success != null;
    }

    public void setSuccessIsSet(boolean value) {
      if (!value) {
        this.success = null;
      }
    }

    public void setFieldValue(_Fields field, Object value) {
      switch (field) {
      case SUCCESS:
        if (value == null) {
          unsetSuccess();
        } else {
          setSuccess((String)value);
        }
        break;

      }
    }

    public Object getFieldValue(_Fields field) {
      switch (field) {
      case SUCCESS:
        return getSuccess();

      }
      throw new IllegalStateException();
    }

    /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
    public boolean isSet(_Fields field) {
      if (field == null) {
        throw new IllegalArgumentException();
      }

      switch (field) {
      case SUCCESS:
        return isSetSuccess();
      }
      throw new IllegalStateException();
    }

    @Override
    public boolean equals(Object that) {
      if (that == null)
        return false;
      if (that instanceof ExportDataUpdate_result)
        return this.equals((ExportDataUpdate_result)that);
      return false;
    }

    public boolean equals(ExportDataUpdate_result that) {
      if (that == null)
        return false;

      boolean this_present_success = true && this.isSetSuccess();
      boolean that_present_success = true && that.isSetSuccess();
      if (this_present_success || that_present_success) {
        if (!(this_present_success && that_present_success))
          return false;
        if (!this.success.equals(that.success))
          return false;
      }

      return true;
    }

    @Override
    public int hashCode() {
      return 0;
    }

    public int compareTo(ExportDataUpdate_result other) {
      if (!getClass().equals(other.getClass())) {
        return getClass().getName().compareTo(other.getClass().getName());
      }

      int lastComparison = 0;
      ExportDataUpdate_result typedOther = (ExportDataUpdate_result)other;

      lastComparison = Boolean.valueOf(isSetSuccess()).compareTo(typedOther.isSetSuccess());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetSuccess()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.success, typedOther.success);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      return 0;
    }

    public _Fields fieldForId(int fieldId) {
      return _Fields.findByThriftId(fieldId);
    }

    public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
      schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
      schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
      }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder("ExportDataUpdate_result(");
      boolean first = true;

      sb.append("success:");
      if (this.success == null) {
        sb.append("null");
      } else {
        sb.append(this.success);
      }
      first = false;
      sb.append(")");
      return sb.toString();
    }

    public void validate() throws org.apache.thrift.TException {
      // check for required fields
      // check for sub-struct validity
    }

    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
      try {
        write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
      } catch (org.apache.thrift.TException te) {
        throw new java.io.IOException(te);
      }
    }

    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
      try {
        read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
      } catch (org.apache.thrift.TException te) {
        throw new java.io.IOException(te);
      }
    }

    private static class ExportDataUpdate_resultStandardSchemeFactory implements SchemeFactory {
      public ExportDataUpdate_resultStandardScheme getScheme() {
        return new ExportDataUpdate_resultStandardScheme();
      }
    }

    private static class ExportDataUpdate_resultStandardScheme extends StandardScheme<ExportDataUpdate_result> {

      public void read(org.apache.thrift.protocol.TProtocol iprot, ExportDataUpdate_result struct) throws org.apache.thrift.TException {
        org.apache.thrift.protocol.TField schemeField;
        iprot.readStructBegin();
        while (true)
        {
          schemeField = iprot.readFieldBegin();
          if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
            break;
          }
          switch (schemeField.id) {
            case 0: // SUCCESS
              if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                struct.success = iprot.readString();
                struct.setSuccessIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            default:
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
          }
          iprot.readFieldEnd();
        }
        iprot.readStructEnd();

        // check for required fields of primitive type, which can't be checked in the validate method
        struct.validate();
      }

      public void write(org.apache.thrift.protocol.TProtocol oprot, ExportDataUpdate_result struct) throws org.apache.thrift.TException {
        struct.validate();

        oprot.writeStructBegin(STRUCT_DESC);
        if (struct.success != null) {
          oprot.writeFieldBegin(SUCCESS_FIELD_DESC);
          oprot.writeString(struct.success);
          oprot.writeFieldEnd();
        }
        oprot.writeFieldStop();
        oprot.writeStructEnd();
      }

    }

    private static class ExportDataUpdate_resultTupleSchemeFactory implements SchemeFactory {
      public ExportDataUpdate_resultTupleScheme getScheme() {
        return new ExportDataUpdate_resultTupleScheme();
      }
    }

    private static class ExportDataUpdate_resultTupleScheme extends TupleScheme<ExportDataUpdate_result> {

      @Override
      public void write(org.apache.thrift.protocol.TProtocol prot, ExportDataUpdate_result struct) throws org.apache.thrift.TException {
        TTupleProtocol oprot = (TTupleProtocol) prot;
        BitSet optionals = new BitSet();
        if (struct.isSetSuccess()) {
          optionals.set(0);
        }
        oprot.writeBitSet(optionals, 1);
        if (struct.isSetSuccess()) {
          oprot.writeString(struct.success);
        }
      }

      @Override
      public void read(org.apache.thrift.protocol.TProtocol prot, ExportDataUpdate_result struct) throws org.apache.thrift.TException {
        TTupleProtocol iprot = (TTupleProtocol) prot;
        BitSet incoming = iprot.readBitSet(1);
        if (incoming.get(0)) {
          struct.success = iprot.readString();
          struct.setSuccessIsSet(true);
        }
      }
    }

  }

}
