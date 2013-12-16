package centos.shell;
import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MahoutThrift {

  public interface Iface {

    public String ImportDataInMahout(String hiveTableName, String mahoutTable) throws org.apache.thrift.TException;

    public String ExportDataOutMahout(String hiveTableName, String mahoutTable) throws org.apache.thrift.TException;

  }

  public interface AsyncIface {

    public void ImportDataInMahout(String hiveTableName, String mahoutTable, org.apache.thrift.async.AsyncMethodCallback<AsyncClient.ImportDataInMahout_call> resultHandler) throws org.apache.thrift.TException;

    public void ExportDataOutMahout(String hiveTableName, String mahoutTable, org.apache.thrift.async.AsyncMethodCallback<AsyncClient.ExportDataOutMahout_call> resultHandler) throws org.apache.thrift.TException;

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

    public String ImportDataInMahout(String hiveTableName, String mahoutTable) throws org.apache.thrift.TException
    {
      send_ImportDataInMahout(hiveTableName, mahoutTable);
      return recv_ImportDataInMahout();
    }

    public void send_ImportDataInMahout(String hiveTableName, String mahoutTable) throws org.apache.thrift.TException
    {
      ImportDataInMahout_args args = new ImportDataInMahout_args();
      args.setHiveTableName(hiveTableName);
      args.setMahoutTable(mahoutTable);
      sendBase("ImportDataInMahout", args);
    }

    public String recv_ImportDataInMahout() throws org.apache.thrift.TException
    {
      ImportDataInMahout_result result = new ImportDataInMahout_result();
      receiveBase(result, "ImportDataInMahout");
      if (result.isSetSuccess()) {
        return result.success;
      }
      throw new org.apache.thrift.TApplicationException(org.apache.thrift.TApplicationException.MISSING_RESULT, "ImportDataInMahout failed: unknown result");
    }

    public String ExportDataOutMahout(String hiveTableName, String mahoutTable) throws org.apache.thrift.TException
    {
      send_ExportDataOutMahout(hiveTableName, mahoutTable);
      return recv_ExportDataOutMahout();
    }

    public void send_ExportDataOutMahout(String hiveTableName, String mahoutTable) throws org.apache.thrift.TException
    {
      ExportDataOutMahout_args args = new ExportDataOutMahout_args();
      args.setHiveTableName(hiveTableName);
      args.setMahoutTable(mahoutTable);
      sendBase("ExportDataOutMahout", args);
    }

    public String recv_ExportDataOutMahout() throws org.apache.thrift.TException
    {
      ExportDataOutMahout_result result = new ExportDataOutMahout_result();
      receiveBase(result, "ExportDataOutMahout");
      if (result.isSetSuccess()) {
        return result.success;
      }
      throw new org.apache.thrift.TApplicationException(org.apache.thrift.TApplicationException.MISSING_RESULT, "ExportDataOutMahout failed: unknown result");
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

    public void ImportDataInMahout(String hiveTableName, String mahoutTable, org.apache.thrift.async.AsyncMethodCallback<ImportDataInMahout_call> resultHandler) throws org.apache.thrift.TException {
      checkReady();
      ImportDataInMahout_call method_call = new ImportDataInMahout_call(hiveTableName, mahoutTable, resultHandler, this, ___protocolFactory, ___transport);
      this.___currentMethod = method_call;
      ___manager.call(method_call);
    }

    public static class ImportDataInMahout_call extends org.apache.thrift.async.TAsyncMethodCall {
      private String hiveTableName;
      private String mahoutTable;
      public ImportDataInMahout_call(String hiveTableName, String mahoutTable, org.apache.thrift.async.AsyncMethodCallback<ImportDataInMahout_call> resultHandler, org.apache.thrift.async.TAsyncClient client, org.apache.thrift.protocol.TProtocolFactory protocolFactory, org.apache.thrift.transport.TNonblockingTransport transport) throws org.apache.thrift.TException {
        super(client, protocolFactory, transport, resultHandler, false);
        this.hiveTableName = hiveTableName;
        this.mahoutTable = mahoutTable;
      }

      public void write_args(org.apache.thrift.protocol.TProtocol prot) throws org.apache.thrift.TException {
        prot.writeMessageBegin(new org.apache.thrift.protocol.TMessage("ImportDataInMahout", org.apache.thrift.protocol.TMessageType.CALL, 0));
        ImportDataInMahout_args args = new ImportDataInMahout_args();
        args.setHiveTableName(hiveTableName);
        args.setMahoutTable(mahoutTable);
        args.write(prot);
        prot.writeMessageEnd();
      }

      public String getResult() throws org.apache.thrift.TException {
        if (getState() != org.apache.thrift.async.TAsyncMethodCall.State.RESPONSE_READ) {
          throw new IllegalStateException("Method call not finished!");
        }
        org.apache.thrift.transport.TMemoryInputTransport memoryTransport = new org.apache.thrift.transport.TMemoryInputTransport(getFrameBuffer().array());
        org.apache.thrift.protocol.TProtocol prot = client.getProtocolFactory().getProtocol(memoryTransport);
        return (new Client(prot)).recv_ImportDataInMahout();
      }
    }

    public void ExportDataOutMahout(String hiveTableName, String mahoutTable, org.apache.thrift.async.AsyncMethodCallback<ExportDataOutMahout_call> resultHandler) throws org.apache.thrift.TException {
      checkReady();
      ExportDataOutMahout_call method_call = new ExportDataOutMahout_call(hiveTableName, mahoutTable, resultHandler, this, ___protocolFactory, ___transport);
      this.___currentMethod = method_call;
      ___manager.call(method_call);
    }

    public static class ExportDataOutMahout_call extends org.apache.thrift.async.TAsyncMethodCall {
      private String hiveTableName;
      private String mahoutTable;
      public ExportDataOutMahout_call(String hiveTableName, String mahoutTable, org.apache.thrift.async.AsyncMethodCallback<ExportDataOutMahout_call> resultHandler, org.apache.thrift.async.TAsyncClient client, org.apache.thrift.protocol.TProtocolFactory protocolFactory, org.apache.thrift.transport.TNonblockingTransport transport) throws org.apache.thrift.TException {
        super(client, protocolFactory, transport, resultHandler, false);
        this.hiveTableName = hiveTableName;
        this.mahoutTable = mahoutTable;
      }

      public void write_args(org.apache.thrift.protocol.TProtocol prot) throws org.apache.thrift.TException {
        prot.writeMessageBegin(new org.apache.thrift.protocol.TMessage("ExportDataOutMahout", org.apache.thrift.protocol.TMessageType.CALL, 0));
        ExportDataOutMahout_args args = new ExportDataOutMahout_args();
        args.setHiveTableName(hiveTableName);
        args.setMahoutTable(mahoutTable);
        args.write(prot);
        prot.writeMessageEnd();
      }

      public String getResult() throws org.apache.thrift.TException {
        if (getState() != org.apache.thrift.async.TAsyncMethodCall.State.RESPONSE_READ) {
          throw new IllegalStateException("Method call not finished!");
        }
        org.apache.thrift.transport.TMemoryInputTransport memoryTransport = new org.apache.thrift.transport.TMemoryInputTransport(getFrameBuffer().array());
        org.apache.thrift.protocol.TProtocol prot = client.getProtocolFactory().getProtocol(memoryTransport);
        return (new Client(prot)).recv_ExportDataOutMahout();
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
      processMap.put("ImportDataInMahout", new ImportDataInMahout());
      processMap.put("ExportDataOutMahout", new ExportDataOutMahout());
      return processMap;
    }

    public static class ImportDataInMahout<I extends Iface> extends org.apache.thrift.ProcessFunction<I, ImportDataInMahout_args> {
      public ImportDataInMahout() {
        super("ImportDataInMahout");
      }

      public ImportDataInMahout_args getEmptyArgsInstance() {
        return new ImportDataInMahout_args();
      }

      protected boolean isOneway() {
        return false;
      }

      public ImportDataInMahout_result getResult(I iface, ImportDataInMahout_args args) throws org.apache.thrift.TException {
        ImportDataInMahout_result result = new ImportDataInMahout_result();
        result.success = iface.ImportDataInMahout(args.hiveTableName, args.mahoutTable);
        return result;
      }
    }

    public static class ExportDataOutMahout<I extends Iface> extends org.apache.thrift.ProcessFunction<I, ExportDataOutMahout_args> {
      public ExportDataOutMahout() {
        super("ExportDataOutMahout");
      }

      public ExportDataOutMahout_args getEmptyArgsInstance() {
        return new ExportDataOutMahout_args();
      }

      protected boolean isOneway() {
        return false;
      }

      public ExportDataOutMahout_result getResult(I iface, ExportDataOutMahout_args args) throws org.apache.thrift.TException {
        ExportDataOutMahout_result result = new ExportDataOutMahout_result();
        result.success = iface.ExportDataOutMahout(args.hiveTableName, args.mahoutTable);
        return result;
      }
    }

  }

  public static class ImportDataInMahout_args implements org.apache.thrift.TBase<ImportDataInMahout_args, ImportDataInMahout_args._Fields>, java.io.Serializable, Cloneable   {
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ImportDataInMahout_args");

    private static final org.apache.thrift.protocol.TField HIVE_TABLE_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("hiveTableName", org.apache.thrift.protocol.TType.STRING, (short)1);
    private static final org.apache.thrift.protocol.TField MAHOUT_TABLE_FIELD_DESC = new org.apache.thrift.protocol.TField("mahoutTable", org.apache.thrift.protocol.TType.STRING, (short)2);

    private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
    static {
      schemes.put(StandardScheme.class, new ImportDataInMahout_argsStandardSchemeFactory());
      schemes.put(TupleScheme.class, new ImportDataInMahout_argsTupleSchemeFactory());
    }

    public String hiveTableName; // required
    public String mahoutTable; // required

    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
      HIVE_TABLE_NAME((short)1, "hiveTableName"),
      MAHOUT_TABLE((short)2, "mahoutTable");

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
          case 1: // HIVE_TABLE_NAME
            return HIVE_TABLE_NAME;
          case 2: // MAHOUT_TABLE
            return MAHOUT_TABLE;
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
      tmpMap.put(_Fields.HIVE_TABLE_NAME, new org.apache.thrift.meta_data.FieldMetaData("hiveTableName", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
      tmpMap.put(_Fields.MAHOUT_TABLE, new org.apache.thrift.meta_data.FieldMetaData("mahoutTable", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
      metaDataMap = Collections.unmodifiableMap(tmpMap);
      org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ImportDataInMahout_args.class, metaDataMap);
    }

    public ImportDataInMahout_args() {
    }

    public ImportDataInMahout_args(
      String hiveTableName,
      String mahoutTable)
    {
      this();
      this.hiveTableName = hiveTableName;
      this.mahoutTable = mahoutTable;
    }

    /**
     * Performs a deep copy on <i>other</i>.
     */
    public ImportDataInMahout_args(ImportDataInMahout_args other) {
      if (other.isSetHiveTableName()) {
        this.hiveTableName = other.hiveTableName;
      }
      if (other.isSetMahoutTable()) {
        this.mahoutTable = other.mahoutTable;
      }
    }

    public ImportDataInMahout_args deepCopy() {
      return new ImportDataInMahout_args(this);
    }

    @Override
    public void clear() {
      this.hiveTableName = null;
      this.mahoutTable = null;
    }

    public String getHiveTableName() {
      return this.hiveTableName;
    }

    public ImportDataInMahout_args setHiveTableName(String hiveTableName) {
      this.hiveTableName = hiveTableName;
      return this;
    }

    public void unsetHiveTableName() {
      this.hiveTableName = null;
    }

    /** Returns true if field hiveTableName is set (has been assigned a value) and false otherwise */
    public boolean isSetHiveTableName() {
      return this.hiveTableName != null;
    }

    public void setHiveTableNameIsSet(boolean value) {
      if (!value) {
        this.hiveTableName = null;
      }
    }

    public String getMahoutTable() {
      return this.mahoutTable;
    }

    public ImportDataInMahout_args setMahoutTable(String mahoutTable) {
      this.mahoutTable = mahoutTable;
      return this;
    }

    public void unsetMahoutTable() {
      this.mahoutTable = null;
    }

    /** Returns true if field mahoutTable is set (has been assigned a value) and false otherwise */
    public boolean isSetMahoutTable() {
      return this.mahoutTable != null;
    }

    public void setMahoutTableIsSet(boolean value) {
      if (!value) {
        this.mahoutTable = null;
      }
    }

    public void setFieldValue(_Fields field, Object value) {
      switch (field) {
      case HIVE_TABLE_NAME:
        if (value == null) {
          unsetHiveTableName();
        } else {
          setHiveTableName((String)value);
        }
        break;

      case MAHOUT_TABLE:
        if (value == null) {
          unsetMahoutTable();
        } else {
          setMahoutTable((String)value);
        }
        break;

      }
    }

    public Object getFieldValue(_Fields field) {
      switch (field) {
      case HIVE_TABLE_NAME:
        return getHiveTableName();

      case MAHOUT_TABLE:
        return getMahoutTable();

      }
      throw new IllegalStateException();
    }

    /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
    public boolean isSet(_Fields field) {
      if (field == null) {
        throw new IllegalArgumentException();
      }

      switch (field) {
      case HIVE_TABLE_NAME:
        return isSetHiveTableName();
      case MAHOUT_TABLE:
        return isSetMahoutTable();
      }
      throw new IllegalStateException();
    }

    @Override
    public boolean equals(Object that) {
      if (that == null)
        return false;
      if (that instanceof ImportDataInMahout_args)
        return this.equals((ImportDataInMahout_args)that);
      return false;
    }

    public boolean equals(ImportDataInMahout_args that) {
      if (that == null)
        return false;

      boolean this_present_hiveTableName = true && this.isSetHiveTableName();
      boolean that_present_hiveTableName = true && that.isSetHiveTableName();
      if (this_present_hiveTableName || that_present_hiveTableName) {
        if (!(this_present_hiveTableName && that_present_hiveTableName))
          return false;
        if (!this.hiveTableName.equals(that.hiveTableName))
          return false;
      }

      boolean this_present_mahoutTable = true && this.isSetMahoutTable();
      boolean that_present_mahoutTable = true && that.isSetMahoutTable();
      if (this_present_mahoutTable || that_present_mahoutTable) {
        if (!(this_present_mahoutTable && that_present_mahoutTable))
          return false;
        if (!this.mahoutTable.equals(that.mahoutTable))
          return false;
      }

      return true;
    }

    @Override
    public int hashCode() {
      return 0;
    }

    public int compareTo(ImportDataInMahout_args other) {
      if (!getClass().equals(other.getClass())) {
        return getClass().getName().compareTo(other.getClass().getName());
      }

      int lastComparison = 0;
      ImportDataInMahout_args typedOther = (ImportDataInMahout_args)other;

      lastComparison = Boolean.valueOf(isSetHiveTableName()).compareTo(typedOther.isSetHiveTableName());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetHiveTableName()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.hiveTableName, typedOther.hiveTableName);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      lastComparison = Boolean.valueOf(isSetMahoutTable()).compareTo(typedOther.isSetMahoutTable());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetMahoutTable()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.mahoutTable, typedOther.mahoutTable);
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
      StringBuilder sb = new StringBuilder("ImportDataInMahout_args(");
      boolean first = true;

      sb.append("hiveTableName:");
      if (this.hiveTableName == null) {
        sb.append("null");
      } else {
        sb.append(this.hiveTableName);
      }
      first = false;
      if (!first) sb.append(", ");
      sb.append("mahoutTable:");
      if (this.mahoutTable == null) {
        sb.append("null");
      } else {
        sb.append(this.mahoutTable);
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

    private static class ImportDataInMahout_argsStandardSchemeFactory implements SchemeFactory {
      public ImportDataInMahout_argsStandardScheme getScheme() {
        return new ImportDataInMahout_argsStandardScheme();
      }
    }

    private static class ImportDataInMahout_argsStandardScheme extends StandardScheme<ImportDataInMahout_args> {

      public void read(org.apache.thrift.protocol.TProtocol iprot, ImportDataInMahout_args struct) throws org.apache.thrift.TException {
        org.apache.thrift.protocol.TField schemeField;
        iprot.readStructBegin();
        while (true)
        {
          schemeField = iprot.readFieldBegin();
          if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
            break;
          }
          switch (schemeField.id) {
            case 1: // HIVE_TABLE_NAME
              if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                struct.hiveTableName = iprot.readString();
                struct.setHiveTableNameIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            case 2: // MAHOUT_TABLE
              if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                struct.mahoutTable = iprot.readString();
                struct.setMahoutTableIsSet(true);
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

      public void write(org.apache.thrift.protocol.TProtocol oprot, ImportDataInMahout_args struct) throws org.apache.thrift.TException {
        struct.validate();

        oprot.writeStructBegin(STRUCT_DESC);
        if (struct.hiveTableName != null) {
          oprot.writeFieldBegin(HIVE_TABLE_NAME_FIELD_DESC);
          oprot.writeString(struct.hiveTableName);
          oprot.writeFieldEnd();
        }
        if (struct.mahoutTable != null) {
          oprot.writeFieldBegin(MAHOUT_TABLE_FIELD_DESC);
          oprot.writeString(struct.mahoutTable);
          oprot.writeFieldEnd();
        }
        oprot.writeFieldStop();
        oprot.writeStructEnd();
      }

    }

    private static class ImportDataInMahout_argsTupleSchemeFactory implements SchemeFactory {
      public ImportDataInMahout_argsTupleScheme getScheme() {
        return new ImportDataInMahout_argsTupleScheme();
      }
    }

    private static class ImportDataInMahout_argsTupleScheme extends TupleScheme<ImportDataInMahout_args> {

      @Override
      public void write(org.apache.thrift.protocol.TProtocol prot, ImportDataInMahout_args struct) throws org.apache.thrift.TException {
        TTupleProtocol oprot = (TTupleProtocol) prot;
        BitSet optionals = new BitSet();
        if (struct.isSetHiveTableName()) {
          optionals.set(0);
        }
        if (struct.isSetMahoutTable()) {
          optionals.set(1);
        }
        oprot.writeBitSet(optionals, 2);
        if (struct.isSetHiveTableName()) {
          oprot.writeString(struct.hiveTableName);
        }
        if (struct.isSetMahoutTable()) {
          oprot.writeString(struct.mahoutTable);
        }
      }

      @Override
      public void read(org.apache.thrift.protocol.TProtocol prot, ImportDataInMahout_args struct) throws org.apache.thrift.TException {
        TTupleProtocol iprot = (TTupleProtocol) prot;
        BitSet incoming = iprot.readBitSet(2);
        if (incoming.get(0)) {
          struct.hiveTableName = iprot.readString();
          struct.setHiveTableNameIsSet(true);
        }
        if (incoming.get(1)) {
          struct.mahoutTable = iprot.readString();
          struct.setMahoutTableIsSet(true);
        }
      }
    }

  }

  public static class ImportDataInMahout_result implements org.apache.thrift.TBase<ImportDataInMahout_result, ImportDataInMahout_result._Fields>, java.io.Serializable, Cloneable   {
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ImportDataInMahout_result");

    private static final org.apache.thrift.protocol.TField SUCCESS_FIELD_DESC = new org.apache.thrift.protocol.TField("success", org.apache.thrift.protocol.TType.STRING, (short)0);

    private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
    static {
      schemes.put(StandardScheme.class, new ImportDataInMahout_resultStandardSchemeFactory());
      schemes.put(TupleScheme.class, new ImportDataInMahout_resultTupleSchemeFactory());
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
      org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ImportDataInMahout_result.class, metaDataMap);
    }

    public ImportDataInMahout_result() {
    }

    public ImportDataInMahout_result(
      String success)
    {
      this();
      this.success = success;
    }

    /**
     * Performs a deep copy on <i>other</i>.
     */
    public ImportDataInMahout_result(ImportDataInMahout_result other) {
      if (other.isSetSuccess()) {
        this.success = other.success;
      }
    }

    public ImportDataInMahout_result deepCopy() {
      return new ImportDataInMahout_result(this);
    }

    @Override
    public void clear() {
      this.success = null;
    }

    public String getSuccess() {
      return this.success;
    }

    public ImportDataInMahout_result setSuccess(String success) {
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
      if (that instanceof ImportDataInMahout_result)
        return this.equals((ImportDataInMahout_result)that);
      return false;
    }

    public boolean equals(ImportDataInMahout_result that) {
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

    public int compareTo(ImportDataInMahout_result other) {
      if (!getClass().equals(other.getClass())) {
        return getClass().getName().compareTo(other.getClass().getName());
      }

      int lastComparison = 0;
      ImportDataInMahout_result typedOther = (ImportDataInMahout_result)other;

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
      StringBuilder sb = new StringBuilder("ImportDataInMahout_result(");
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

    private static class ImportDataInMahout_resultStandardSchemeFactory implements SchemeFactory {
      public ImportDataInMahout_resultStandardScheme getScheme() {
        return new ImportDataInMahout_resultStandardScheme();
      }
    }

    private static class ImportDataInMahout_resultStandardScheme extends StandardScheme<ImportDataInMahout_result> {

      public void read(org.apache.thrift.protocol.TProtocol iprot, ImportDataInMahout_result struct) throws org.apache.thrift.TException {
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

      public void write(org.apache.thrift.protocol.TProtocol oprot, ImportDataInMahout_result struct) throws org.apache.thrift.TException {
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

    private static class ImportDataInMahout_resultTupleSchemeFactory implements SchemeFactory {
      public ImportDataInMahout_resultTupleScheme getScheme() {
        return new ImportDataInMahout_resultTupleScheme();
      }
    }

    private static class ImportDataInMahout_resultTupleScheme extends TupleScheme<ImportDataInMahout_result> {

      @Override
      public void write(org.apache.thrift.protocol.TProtocol prot, ImportDataInMahout_result struct) throws org.apache.thrift.TException {
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
      public void read(org.apache.thrift.protocol.TProtocol prot, ImportDataInMahout_result struct) throws org.apache.thrift.TException {
        TTupleProtocol iprot = (TTupleProtocol) prot;
        BitSet incoming = iprot.readBitSet(1);
        if (incoming.get(0)) {
          struct.success = iprot.readString();
          struct.setSuccessIsSet(true);
        }
      }
    }

  }

  public static class ExportDataOutMahout_args implements org.apache.thrift.TBase<ExportDataOutMahout_args, ExportDataOutMahout_args._Fields>, java.io.Serializable, Cloneable   {
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ExportDataOutMahout_args");

    private static final org.apache.thrift.protocol.TField HIVE_TABLE_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("hiveTableName", org.apache.thrift.protocol.TType.STRING, (short)1);
    private static final org.apache.thrift.protocol.TField MAHOUT_TABLE_FIELD_DESC = new org.apache.thrift.protocol.TField("mahoutTable", org.apache.thrift.protocol.TType.STRING, (short)2);

    private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
    static {
      schemes.put(StandardScheme.class, new ExportDataOutMahout_argsStandardSchemeFactory());
      schemes.put(TupleScheme.class, new ExportDataOutMahout_argsTupleSchemeFactory());
    }

    public String hiveTableName; // required
    public String mahoutTable; // required

    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
      HIVE_TABLE_NAME((short)1, "hiveTableName"),
      MAHOUT_TABLE((short)2, "mahoutTable");

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
          case 1: // HIVE_TABLE_NAME
            return HIVE_TABLE_NAME;
          case 2: // MAHOUT_TABLE
            return MAHOUT_TABLE;
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
      tmpMap.put(_Fields.HIVE_TABLE_NAME, new org.apache.thrift.meta_data.FieldMetaData("hiveTableName", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
      tmpMap.put(_Fields.MAHOUT_TABLE, new org.apache.thrift.meta_data.FieldMetaData("mahoutTable", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
      metaDataMap = Collections.unmodifiableMap(tmpMap);
      org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ExportDataOutMahout_args.class, metaDataMap);
    }

    public ExportDataOutMahout_args() {
    }

    public ExportDataOutMahout_args(
      String hiveTableName,
      String mahoutTable)
    {
      this();
      this.hiveTableName = hiveTableName;
      this.mahoutTable = mahoutTable;
    }

    /**
     * Performs a deep copy on <i>other</i>.
     */
    public ExportDataOutMahout_args(ExportDataOutMahout_args other) {
      if (other.isSetHiveTableName()) {
        this.hiveTableName = other.hiveTableName;
      }
      if (other.isSetMahoutTable()) {
        this.mahoutTable = other.mahoutTable;
      }
    }

    public ExportDataOutMahout_args deepCopy() {
      return new ExportDataOutMahout_args(this);
    }

    @Override
    public void clear() {
      this.hiveTableName = null;
      this.mahoutTable = null;
    }

    public String getHiveTableName() {
      return this.hiveTableName;
    }

    public ExportDataOutMahout_args setHiveTableName(String hiveTableName) {
      this.hiveTableName = hiveTableName;
      return this;
    }

    public void unsetHiveTableName() {
      this.hiveTableName = null;
    }

    /** Returns true if field hiveTableName is set (has been assigned a value) and false otherwise */
    public boolean isSetHiveTableName() {
      return this.hiveTableName != null;
    }

    public void setHiveTableNameIsSet(boolean value) {
      if (!value) {
        this.hiveTableName = null;
      }
    }

    public String getMahoutTable() {
      return this.mahoutTable;
    }

    public ExportDataOutMahout_args setMahoutTable(String mahoutTable) {
      this.mahoutTable = mahoutTable;
      return this;
    }

    public void unsetMahoutTable() {
      this.mahoutTable = null;
    }

    /** Returns true if field mahoutTable is set (has been assigned a value) and false otherwise */
    public boolean isSetMahoutTable() {
      return this.mahoutTable != null;
    }

    public void setMahoutTableIsSet(boolean value) {
      if (!value) {
        this.mahoutTable = null;
      }
    }

    public void setFieldValue(_Fields field, Object value) {
      switch (field) {
      case HIVE_TABLE_NAME:
        if (value == null) {
          unsetHiveTableName();
        } else {
          setHiveTableName((String)value);
        }
        break;

      case MAHOUT_TABLE:
        if (value == null) {
          unsetMahoutTable();
        } else {
          setMahoutTable((String)value);
        }
        break;

      }
    }

    public Object getFieldValue(_Fields field) {
      switch (field) {
      case HIVE_TABLE_NAME:
        return getHiveTableName();

      case MAHOUT_TABLE:
        return getMahoutTable();

      }
      throw new IllegalStateException();
    }

    /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
    public boolean isSet(_Fields field) {
      if (field == null) {
        throw new IllegalArgumentException();
      }

      switch (field) {
      case HIVE_TABLE_NAME:
        return isSetHiveTableName();
      case MAHOUT_TABLE:
        return isSetMahoutTable();
      }
      throw new IllegalStateException();
    }

    @Override
    public boolean equals(Object that) {
      if (that == null)
        return false;
      if (that instanceof ExportDataOutMahout_args)
        return this.equals((ExportDataOutMahout_args)that);
      return false;
    }

    public boolean equals(ExportDataOutMahout_args that) {
      if (that == null)
        return false;

      boolean this_present_hiveTableName = true && this.isSetHiveTableName();
      boolean that_present_hiveTableName = true && that.isSetHiveTableName();
      if (this_present_hiveTableName || that_present_hiveTableName) {
        if (!(this_present_hiveTableName && that_present_hiveTableName))
          return false;
        if (!this.hiveTableName.equals(that.hiveTableName))
          return false;
      }

      boolean this_present_mahoutTable = true && this.isSetMahoutTable();
      boolean that_present_mahoutTable = true && that.isSetMahoutTable();
      if (this_present_mahoutTable || that_present_mahoutTable) {
        if (!(this_present_mahoutTable && that_present_mahoutTable))
          return false;
        if (!this.mahoutTable.equals(that.mahoutTable))
          return false;
      }

      return true;
    }

    @Override
    public int hashCode() {
      return 0;
    }

    public int compareTo(ExportDataOutMahout_args other) {
      if (!getClass().equals(other.getClass())) {
        return getClass().getName().compareTo(other.getClass().getName());
      }

      int lastComparison = 0;
      ExportDataOutMahout_args typedOther = (ExportDataOutMahout_args)other;

      lastComparison = Boolean.valueOf(isSetHiveTableName()).compareTo(typedOther.isSetHiveTableName());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetHiveTableName()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.hiveTableName, typedOther.hiveTableName);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      lastComparison = Boolean.valueOf(isSetMahoutTable()).compareTo(typedOther.isSetMahoutTable());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetMahoutTable()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.mahoutTable, typedOther.mahoutTable);
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
      StringBuilder sb = new StringBuilder("ExportDataOutMahout_args(");
      boolean first = true;

      sb.append("hiveTableName:");
      if (this.hiveTableName == null) {
        sb.append("null");
      } else {
        sb.append(this.hiveTableName);
      }
      first = false;
      if (!first) sb.append(", ");
      sb.append("mahoutTable:");
      if (this.mahoutTable == null) {
        sb.append("null");
      } else {
        sb.append(this.mahoutTable);
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

    private static class ExportDataOutMahout_argsStandardSchemeFactory implements SchemeFactory {
      public ExportDataOutMahout_argsStandardScheme getScheme() {
        return new ExportDataOutMahout_argsStandardScheme();
      }
    }

    private static class ExportDataOutMahout_argsStandardScheme extends StandardScheme<ExportDataOutMahout_args> {

      public void read(org.apache.thrift.protocol.TProtocol iprot, ExportDataOutMahout_args struct) throws org.apache.thrift.TException {
        org.apache.thrift.protocol.TField schemeField;
        iprot.readStructBegin();
        while (true)
        {
          schemeField = iprot.readFieldBegin();
          if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
            break;
          }
          switch (schemeField.id) {
            case 1: // HIVE_TABLE_NAME
              if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                struct.hiveTableName = iprot.readString();
                struct.setHiveTableNameIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            case 2: // MAHOUT_TABLE
              if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                struct.mahoutTable = iprot.readString();
                struct.setMahoutTableIsSet(true);
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

      public void write(org.apache.thrift.protocol.TProtocol oprot, ExportDataOutMahout_args struct) throws org.apache.thrift.TException {
        struct.validate();

        oprot.writeStructBegin(STRUCT_DESC);
        if (struct.hiveTableName != null) {
          oprot.writeFieldBegin(HIVE_TABLE_NAME_FIELD_DESC);
          oprot.writeString(struct.hiveTableName);
          oprot.writeFieldEnd();
        }
        if (struct.mahoutTable != null) {
          oprot.writeFieldBegin(MAHOUT_TABLE_FIELD_DESC);
          oprot.writeString(struct.mahoutTable);
          oprot.writeFieldEnd();
        }
        oprot.writeFieldStop();
        oprot.writeStructEnd();
      }

    }

    private static class ExportDataOutMahout_argsTupleSchemeFactory implements SchemeFactory {
      public ExportDataOutMahout_argsTupleScheme getScheme() {
        return new ExportDataOutMahout_argsTupleScheme();
      }
    }

    private static class ExportDataOutMahout_argsTupleScheme extends TupleScheme<ExportDataOutMahout_args> {

      @Override
      public void write(org.apache.thrift.protocol.TProtocol prot, ExportDataOutMahout_args struct) throws org.apache.thrift.TException {
        TTupleProtocol oprot = (TTupleProtocol) prot;
        BitSet optionals = new BitSet();
        if (struct.isSetHiveTableName()) {
          optionals.set(0);
        }
        if (struct.isSetMahoutTable()) {
          optionals.set(1);
        }
        oprot.writeBitSet(optionals, 2);
        if (struct.isSetHiveTableName()) {
          oprot.writeString(struct.hiveTableName);
        }
        if (struct.isSetMahoutTable()) {
          oprot.writeString(struct.mahoutTable);
        }
      }

      @Override
      public void read(org.apache.thrift.protocol.TProtocol prot, ExportDataOutMahout_args struct) throws org.apache.thrift.TException {
        TTupleProtocol iprot = (TTupleProtocol) prot;
        BitSet incoming = iprot.readBitSet(2);
        if (incoming.get(0)) {
          struct.hiveTableName = iprot.readString();
          struct.setHiveTableNameIsSet(true);
        }
        if (incoming.get(1)) {
          struct.mahoutTable = iprot.readString();
          struct.setMahoutTableIsSet(true);
        }
      }
    }

  }

  public static class ExportDataOutMahout_result implements org.apache.thrift.TBase<ExportDataOutMahout_result, ExportDataOutMahout_result._Fields>, java.io.Serializable, Cloneable   {
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ExportDataOutMahout_result");

    private static final org.apache.thrift.protocol.TField SUCCESS_FIELD_DESC = new org.apache.thrift.protocol.TField("success", org.apache.thrift.protocol.TType.STRING, (short)0);

    private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
    static {
      schemes.put(StandardScheme.class, new ExportDataOutMahout_resultStandardSchemeFactory());
      schemes.put(TupleScheme.class, new ExportDataOutMahout_resultTupleSchemeFactory());
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
      org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ExportDataOutMahout_result.class, metaDataMap);
    }

    public ExportDataOutMahout_result() {
    }

    public ExportDataOutMahout_result(
      String success)
    {
      this();
      this.success = success;
    }

    /**
     * Performs a deep copy on <i>other</i>.
     */
    public ExportDataOutMahout_result(ExportDataOutMahout_result other) {
      if (other.isSetSuccess()) {
        this.success = other.success;
      }
    }

    public ExportDataOutMahout_result deepCopy() {
      return new ExportDataOutMahout_result(this);
    }

    @Override
    public void clear() {
      this.success = null;
    }

    public String getSuccess() {
      return this.success;
    }

    public ExportDataOutMahout_result setSuccess(String success) {
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
      if (that instanceof ExportDataOutMahout_result)
        return this.equals((ExportDataOutMahout_result)that);
      return false;
    }

    public boolean equals(ExportDataOutMahout_result that) {
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

    public int compareTo(ExportDataOutMahout_result other) {
      if (!getClass().equals(other.getClass())) {
        return getClass().getName().compareTo(other.getClass().getName());
      }

      int lastComparison = 0;
      ExportDataOutMahout_result typedOther = (ExportDataOutMahout_result)other;

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
      StringBuilder sb = new StringBuilder("ExportDataOutMahout_result(");
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

    private static class ExportDataOutMahout_resultStandardSchemeFactory implements SchemeFactory {
      public ExportDataOutMahout_resultStandardScheme getScheme() {
        return new ExportDataOutMahout_resultStandardScheme();
      }
    }

    private static class ExportDataOutMahout_resultStandardScheme extends StandardScheme<ExportDataOutMahout_result> {

      public void read(org.apache.thrift.protocol.TProtocol iprot, ExportDataOutMahout_result struct) throws org.apache.thrift.TException {
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

      public void write(org.apache.thrift.protocol.TProtocol oprot, ExportDataOutMahout_result struct) throws org.apache.thrift.TException {
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

    private static class ExportDataOutMahout_resultTupleSchemeFactory implements SchemeFactory {
      public ExportDataOutMahout_resultTupleScheme getScheme() {
        return new ExportDataOutMahout_resultTupleScheme();
      }
    }

    private static class ExportDataOutMahout_resultTupleScheme extends TupleScheme<ExportDataOutMahout_result> {

      @Override
      public void write(org.apache.thrift.protocol.TProtocol prot, ExportDataOutMahout_result struct) throws org.apache.thrift.TException {
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
      public void read(org.apache.thrift.protocol.TProtocol prot, ExportDataOutMahout_result struct) throws org.apache.thrift.TException {
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
