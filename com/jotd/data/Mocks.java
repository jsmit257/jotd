package com.jotd.data;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Date;
import java.sql.NClob;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class Mocks {

  public class BaseConnection implements Connection {

    private boolean closed, autoCommit, readOnly;
    private int holdability, networkTimeout, transactionIsolation;

    @Override
    public boolean isWrapperFor(Class<?> arg0) throws SQLException {
      return false;
    }

    @Override
    public <T> T unwrap(Class<T> arg0) throws SQLException {
      return null;
    }

    @Override
    public void abort(Executor arg0) throws SQLException {
    }

    @Override
    public void clearWarnings() throws SQLException {
    }

    @Override
    public void close() throws SQLException {
      closed = true;
    }

    @Override
    public void commit() throws SQLException {
    }

    @Override
    public Array createArrayOf(String arg0, Object[] arg1) throws SQLException {
      return null;
    }

    @Override
    public Blob createBlob() throws SQLException {
      return null;
    }

    @Override
    public Clob createClob() throws SQLException {
      return null;
    }

    @Override
    public NClob createNClob() throws SQLException {
      return null;
    }

    @Override
    public SQLXML createSQLXML() throws SQLException {
      return null;
    }

    @Override
    public Statement createStatement() throws SQLException {
      return null;
    }

    @Override
    public Statement createStatement(int arg0, int arg1) throws SQLException {
      return null;
    }

    @Override
    public Statement createStatement(int arg0, int arg1, int arg2) throws SQLException {
      return null;
    }

    @Override
    public Struct createStruct(String arg0, Object[] arg1) throws SQLException {
      return null;
    }

    @Override
    public boolean getAutoCommit() throws SQLException {
      return autoCommit;
    }

    @Override
    public String getCatalog() throws SQLException {
      return null;
    }

    @Override
    public Properties getClientInfo() throws SQLException {
      return null;
    }

    @Override
    public String getClientInfo(String arg0) throws SQLException {
      return null;
    }

    @Override
    public int getHoldability() throws SQLException {
      return holdability;
    }

    @Override
    public DatabaseMetaData getMetaData() throws SQLException {
      return null;
    }

    @Override
    public int getNetworkTimeout() throws SQLException {
      return networkTimeout;
    }

    @Override
    public String getSchema() throws SQLException {
      return null;
    }

    @Override
    public int getTransactionIsolation() throws SQLException {
      return transactionIsolation;
    }

    @Override
    public Map<String, Class<?>> getTypeMap() throws SQLException {
      return null;
    }

    @Override
    public SQLWarning getWarnings() throws SQLException {
      return null;
    }

    @Override
    public boolean isClosed() throws SQLException {
      return closed;
    }

    @Override
    public boolean isReadOnly() throws SQLException {
      return readOnly;
    }

    @Override
    public boolean isValid(int arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'isValid'");
    }

    @Override
    public String nativeSQL(String arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'nativeSQL'");
    }

    @Override
    public CallableStatement prepareCall(String arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'prepareCall'");
    }

    @Override
    public CallableStatement prepareCall(String arg0, int arg1, int arg2) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'prepareCall'");
    }

    @Override
    public CallableStatement prepareCall(String arg0, int arg1, int arg2, int arg3) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'prepareCall'");
    }

    @Override
    public PreparedStatement prepareStatement(String arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'prepareStatement'");
    }

    @Override
    public PreparedStatement prepareStatement(String arg0, int arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'prepareStatement'");
    }

    @Override
    public PreparedStatement prepareStatement(String arg0, int[] arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'prepareStatement'");
    }

    @Override
    public PreparedStatement prepareStatement(String arg0, String[] arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'prepareStatement'");
    }

    @Override
    public PreparedStatement prepareStatement(String arg0, int arg1, int arg2) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'prepareStatement'");
    }

    @Override
    public PreparedStatement prepareStatement(String arg0, int arg1, int arg2, int arg3) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'prepareStatement'");
    }

    @Override
    public void releaseSavepoint(Savepoint arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'releaseSavepoint'");
    }

    @Override
    public void rollback() throws SQLException {
    }

    @Override
    public void rollback(Savepoint arg0) throws SQLException {
    }

    @Override
    public void setAutoCommit(boolean arg0) throws SQLException {
      autoCommit = arg0;
    }

    @Override
    public void setCatalog(String arg0) throws SQLException {
    }

    @Override
    public void setClientInfo(Properties arg0) throws SQLClientInfoException {
    }

    @Override
    public void setClientInfo(String arg0, String arg1) throws SQLClientInfoException {
    }

    @Override
    public void setHoldability(int arg0) throws SQLException {
      holdability = arg0;
    }

    @Override
    public void setNetworkTimeout(Executor arg0, int arg1) throws SQLException {
      networkTimeout = arg1;
    }

    @Override
    public void setReadOnly(boolean arg0) throws SQLException {
      readOnly = arg0;
    }

    @Override
    public Savepoint setSavepoint() throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'setSavepoint'");
    }

    @Override
    public Savepoint setSavepoint(String arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'setSavepoint'");
    }

    @Override
    public void setSchema(String arg0) throws SQLException {
    }

    @Override
    public void setTransactionIsolation(int arg0) throws SQLException {
      transactionIsolation = arg0;
    }

    @Override
    public void setTypeMap(Map<String, Class<?>> arg0) throws SQLException {
    }
  }

  public class BasePreparedStatement implements PreparedStatement {

    private boolean closeOnComplete, closed, poolable;
    private int fetchDir, fetchSize, maxFieldSize, maxRows, queryTimeout;

    @Override
    public void addBatch(String arg0) throws SQLException {
    }

    @Override
    public void cancel() throws SQLException {
    }

    @Override
    public void clearBatch() throws SQLException {
    }

    @Override
    public void clearWarnings() throws SQLException {
    }

    @Override
    public void close() throws SQLException {
      closed = true;
    }

    @Override
    public void closeOnCompletion() throws SQLException {
      closeOnComplete = true;
    }

    @Override
    public boolean execute(String arg0) throws SQLException {
      return false;
    }

    @Override
    public boolean execute(String arg0, int arg1) throws SQLException {
      return false;
    }

    @Override
    public boolean execute(String arg0, int[] arg1) throws SQLException {
      return false;
    }

    @Override
    public boolean execute(String arg0, String[] arg1) throws SQLException {
      return false;
    }

    @Override
    public int[] executeBatch() throws SQLException {
      return null;
    }

    @Override
    public ResultSet executeQuery(String arg0) throws SQLException {
      return null;
    }

    @Override
    public int executeUpdate(String arg0) throws SQLException {
      return 0;
    }

    @Override
    public int executeUpdate(String arg0, int arg1) throws SQLException {
      return 0;
    }

    @Override
    public int executeUpdate(String arg0, int[] arg1) throws SQLException {
      return 0;
    }

    @Override
    public int executeUpdate(String arg0, String[] arg1) throws SQLException {
      return 0;
    }

    @Override
    public Connection getConnection() throws SQLException {
      return null;
    }

    @Override
    public int getFetchDirection() throws SQLException {
      return fetchDir;
    }

    @Override
    public int getFetchSize() throws SQLException {
      return fetchSize;
    }

    @Override
    public ResultSet getGeneratedKeys() throws SQLException {
      return null;
    }

    @Override
    public int getMaxFieldSize() throws SQLException {
      return maxFieldSize;
    }

    @Override
    public int getMaxRows() throws SQLException {
      return maxRows;
    }

    @Override
    public boolean getMoreResults() throws SQLException {
      return false;
    }

    @Override
    public boolean getMoreResults(int arg0) throws SQLException {
      return false;
    }

    @Override
    public int getQueryTimeout() throws SQLException {
      return queryTimeout;
    }

    @Override
    public ResultSet getResultSet() throws SQLException {
      return null;
    }

    @Override
    public int getResultSetConcurrency() throws SQLException {
      return 0;
    }

    @Override
    public int getResultSetHoldability() throws SQLException {
      return 0;
    }

    @Override
    public int getResultSetType() throws SQLException {
      return 0;
    }

    @Override
    public int getUpdateCount() throws SQLException {
      return 0;
    }

    @Override
    public SQLWarning getWarnings() throws SQLException {
      return null;
    }

    @Override
    public boolean isCloseOnCompletion() throws SQLException {
      return closeOnComplete;
    }

    @Override
    public boolean isClosed() throws SQLException {
      return closed;
    }

    @Override
    public boolean isPoolable() throws SQLException {
      return poolable;
    }

    @Override
    public void setCursorName(String arg0) throws SQLException {
    }

    @Override
    public void setEscapeProcessing(boolean arg0) throws SQLException {
    }

    @Override
    public void setFetchDirection(int arg0) throws SQLException {
      fetchDir = arg0;
    }

    @Override
    public void setFetchSize(int arg0) throws SQLException {
      fetchSize = arg0;
    }

    @Override
    public void setMaxFieldSize(int arg0) throws SQLException {
      maxFieldSize = arg0;
    }

    @Override
    public void setMaxRows(int arg0) throws SQLException {
      maxRows = arg0;
    }

    @Override
    public void setPoolable(boolean arg0) throws SQLException {
      poolable = arg0;
    }

    @Override
    public void setQueryTimeout(int arg0) throws SQLException {
      queryTimeout = arg0;
    }

    @Override
    public boolean isWrapperFor(Class<?> arg0) throws SQLException {
      return false;
    }

    @Override
    public <T> T unwrap(Class<T> arg0) throws SQLException {
      return null;
    }

    @Override
    public void addBatch() throws SQLException {
    }

    @Override
    public void clearParameters() throws SQLException {
    }

    @Override
    public boolean execute() throws SQLException {
      return false;
    }

    @Override
    public ResultSet executeQuery() throws SQLException {
      return null;
    }

    @Override
    public int executeUpdate() throws SQLException {
      return 0;
    }

    @Override
    public ResultSetMetaData getMetaData() throws SQLException {
      return null;
    }

    @Override
    public ParameterMetaData getParameterMetaData() throws SQLException {
      return null;
    }

    @Override
    public void setArray(int arg0, Array arg1) throws SQLException {
    }

    @Override
    public void setAsciiStream(int arg0, InputStream arg1) throws SQLException {
    }

    @Override
    public void setAsciiStream(int arg0, InputStream arg1, int arg2) throws SQLException {
    }

    @Override
    public void setAsciiStream(int arg0, InputStream arg1, long arg2) throws SQLException {
    }

    @Override
    public void setBigDecimal(int arg0, BigDecimal arg1) throws SQLException {
    }

    @Override
    public void setBinaryStream(int arg0, InputStream arg1) throws SQLException {
    }

    @Override
    public void setBinaryStream(int arg0, InputStream arg1, int arg2) throws SQLException {
    }

    @Override
    public void setBinaryStream(int arg0, InputStream arg1, long arg2) throws SQLException {
    }

    @Override
    public void setBlob(int arg0, Blob arg1) throws SQLException {
    }

    @Override
    public void setBlob(int arg0, InputStream arg1) throws SQLException {
    }

    @Override
    public void setBlob(int arg0, InputStream arg1, long arg2) throws SQLException {
    }

    @Override
    public void setBoolean(int arg0, boolean arg1) throws SQLException {
    }

    @Override
    public void setByte(int arg0, byte arg1) throws SQLException {
    }

    @Override
    public void setBytes(int arg0, byte[] arg1) throws SQLException {
    }

    @Override
    public void setCharacterStream(int arg0, Reader arg1) throws SQLException {
    }

    @Override
    public void setCharacterStream(int arg0, Reader arg1, int arg2) throws SQLException {
    }

    @Override
    public void setCharacterStream(int arg0, Reader arg1, long arg2) throws SQLException {
    }

    @Override
    public void setClob(int arg0, Clob arg1) throws SQLException {
    }

    @Override
    public void setClob(int arg0, Reader arg1) throws SQLException {
    }

    @Override
    public void setClob(int arg0, Reader arg1, long arg2) throws SQLException {
    }

    @Override
    public void setDate(int arg0, Date arg1) throws SQLException {
    }

    @Override
    public void setDate(int arg0, Date arg1, Calendar arg2) throws SQLException {
    }

    @Override
    public void setDouble(int arg0, double arg1) throws SQLException {
    }

    @Override
    public void setFloat(int arg0, float arg1) throws SQLException {
    }

    @Override
    public void setInt(int arg0, int arg1) throws SQLException {
    }

    @Override
    public void setLong(int arg0, long arg1) throws SQLException {
    }

    @Override
    public void setNCharacterStream(int arg0, Reader arg1) throws SQLException {
    }

    @Override
    public void setNCharacterStream(int arg0, Reader arg1, long arg2) throws SQLException {
    }

    @Override
    public void setNClob(int arg0, NClob arg1) throws SQLException {
    }

    @Override
    public void setNClob(int arg0, Reader arg1) throws SQLException {
    }

    @Override
    public void setNClob(int arg0, Reader arg1, long arg2) throws SQLException {
    }

    @Override
    public void setNString(int arg0, String arg1) throws SQLException {
    }

    @Override
    public void setNull(int arg0, int arg1) throws SQLException {
    }

    @Override
    public void setNull(int arg0, int arg1, String arg2) throws SQLException {
    }

    @Override
    public void setObject(int arg0, Object arg1) throws SQLException {
    }

    @Override
    public void setObject(int arg0, Object arg1, int arg2) throws SQLException {
    }

    @Override
    public void setObject(int arg0, Object arg1, int arg2, int arg3) throws SQLException {
    }

    @Override
    public void setRef(int arg0, Ref arg1) throws SQLException {
    }

    @Override
    public void setRowId(int arg0, RowId arg1) throws SQLException {
    }

    @Override
    public void setSQLXML(int arg0, SQLXML arg1) throws SQLException {
    }

    @Override
    public void setShort(int arg0, short arg1) throws SQLException {
    }

    @Override
    public void setString(int arg0, String arg1) throws SQLException {
    }

    @Override
    public void setTime(int arg0, Time arg1) throws SQLException {
    }

    @Override
    public void setTime(int arg0, Time arg1, Calendar arg2) throws SQLException {
    }

    @Override
    public void setTimestamp(int arg0, Timestamp arg1) throws SQLException {
    }

    @Override
    public void setTimestamp(int arg0, Timestamp arg1, Calendar arg2) throws SQLException {
    }

    @Override
    public void setURL(int arg0, URL arg1) throws SQLException {
    }

    @Override
    public void setUnicodeStream(int arg0, InputStream arg1, int arg2) throws SQLException {
    }
  }

  public class BaseResultSet implements ResultSet {

    @Override
    public boolean isWrapperFor(Class<?> arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'isWrapperFor'");
    }

    @Override
    public <T> T unwrap(Class<T> arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'unwrap'");
    }

    @Override
    public boolean absolute(int arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'absolute'");
    }

    @Override
    public void afterLast() throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'afterLast'");
    }

    @Override
    public void beforeFirst() throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'beforeFirst'");
    }

    @Override
    public void cancelRowUpdates() throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'cancelRowUpdates'");
    }

    @Override
    public void clearWarnings() throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'clearWarnings'");
    }

    @Override
    public void close() throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'close'");
    }

    @Override
    public void deleteRow() throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'deleteRow'");
    }

    @Override
    public int findColumn(String arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'findColumn'");
    }

    @Override
    public boolean first() throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'first'");
    }

    @Override
    public Array getArray(int arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getArray'");
    }

    @Override
    public Array getArray(String arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getArray'");
    }

    @Override
    public InputStream getAsciiStream(int arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getAsciiStream'");
    }

    @Override
    public InputStream getAsciiStream(String arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getAsciiStream'");
    }

    @Override
    public BigDecimal getBigDecimal(int arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getBigDecimal'");
    }

    @Override
    public BigDecimal getBigDecimal(String arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getBigDecimal'");
    }

    @Override
    public BigDecimal getBigDecimal(int arg0, int arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getBigDecimal'");
    }

    @Override
    public BigDecimal getBigDecimal(String arg0, int arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getBigDecimal'");
    }

    @Override
    public InputStream getBinaryStream(int arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getBinaryStream'");
    }

    @Override
    public InputStream getBinaryStream(String arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getBinaryStream'");
    }

    @Override
    public Blob getBlob(int arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getBlob'");
    }

    @Override
    public Blob getBlob(String arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getBlob'");
    }

    @Override
    public boolean getBoolean(int arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getBoolean'");
    }

    @Override
    public boolean getBoolean(String arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getBoolean'");
    }

    @Override
    public byte getByte(int arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getByte'");
    }

    @Override
    public byte getByte(String arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getByte'");
    }

    @Override
    public byte[] getBytes(int arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getBytes'");
    }

    @Override
    public byte[] getBytes(String arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getBytes'");
    }

    @Override
    public Reader getCharacterStream(int arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getCharacterStream'");
    }

    @Override
    public Reader getCharacterStream(String arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getCharacterStream'");
    }

    @Override
    public Clob getClob(int arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getClob'");
    }

    @Override
    public Clob getClob(String arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getClob'");
    }

    @Override
    public int getConcurrency() throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getConcurrency'");
    }

    @Override
    public String getCursorName() throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getCursorName'");
    }

    @Override
    public Date getDate(int arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getDate'");
    }

    @Override
    public Date getDate(String arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getDate'");
    }

    @Override
    public Date getDate(int arg0, Calendar arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getDate'");
    }

    @Override
    public Date getDate(String arg0, Calendar arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getDate'");
    }

    @Override
    public double getDouble(int arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getDouble'");
    }

    @Override
    public double getDouble(String arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getDouble'");
    }

    @Override
    public int getFetchDirection() throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getFetchDirection'");
    }

    @Override
    public int getFetchSize() throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getFetchSize'");
    }

    @Override
    public float getFloat(int arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getFloat'");
    }

    @Override
    public float getFloat(String arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getFloat'");
    }

    @Override
    public int getHoldability() throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getHoldability'");
    }

    @Override
    public int getInt(int arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getInt'");
    }

    @Override
    public int getInt(String arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getInt'");
    }

    @Override
    public long getLong(int arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getLong'");
    }

    @Override
    public long getLong(String arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getLong'");
    }

    @Override
    public ResultSetMetaData getMetaData() throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getMetaData'");
    }

    @Override
    public Reader getNCharacterStream(int arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getNCharacterStream'");
    }

    @Override
    public Reader getNCharacterStream(String arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getNCharacterStream'");
    }

    @Override
    public NClob getNClob(int arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getNClob'");
    }

    @Override
    public NClob getNClob(String arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getNClob'");
    }

    @Override
    public String getNString(int arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getNString'");
    }

    @Override
    public String getNString(String arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getNString'");
    }

    @Override
    public Object getObject(int arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getObject'");
    }

    @Override
    public Object getObject(String arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getObject'");
    }

    @Override
    public Object getObject(int arg0, Map<String, Class<?>> arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getObject'");
    }

    @Override
    public Object getObject(String arg0, Map<String, Class<?>> arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getObject'");
    }

    @Override
    public <T> T getObject(int arg0, Class<T> arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getObject'");
    }

    @Override
    public <T> T getObject(String arg0, Class<T> arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getObject'");
    }

    @Override
    public Ref getRef(int arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getRef'");
    }

    @Override
    public Ref getRef(String arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getRef'");
    }

    @Override
    public int getRow() throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getRow'");
    }

    @Override
    public RowId getRowId(int arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getRowId'");
    }

    @Override
    public RowId getRowId(String arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getRowId'");
    }

    @Override
    public SQLXML getSQLXML(int arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getSQLXML'");
    }

    @Override
    public SQLXML getSQLXML(String arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getSQLXML'");
    }

    @Override
    public short getShort(int arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getShort'");
    }

    @Override
    public short getShort(String arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getShort'");
    }

    @Override
    public Statement getStatement() throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getStatement'");
    }

    @Override
    public String getString(int arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getString'");
    }

    @Override
    public String getString(String arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getString'");
    }

    @Override
    public Time getTime(int arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getTime'");
    }

    @Override
    public Time getTime(String arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getTime'");
    }

    @Override
    public Time getTime(int arg0, Calendar arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getTime'");
    }

    @Override
    public Time getTime(String arg0, Calendar arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getTime'");
    }

    @Override
    public Timestamp getTimestamp(int arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getTimestamp'");
    }

    @Override
    public Timestamp getTimestamp(String arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getTimestamp'");
    }

    @Override
    public Timestamp getTimestamp(int arg0, Calendar arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getTimestamp'");
    }

    @Override
    public Timestamp getTimestamp(String arg0, Calendar arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getTimestamp'");
    }

    @Override
    public int getType() throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getType'");
    }

    @Override
    public URL getURL(int arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getURL'");
    }

    @Override
    public URL getURL(String arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getURL'");
    }

    @Override
    public InputStream getUnicodeStream(int arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getUnicodeStream'");
    }

    @Override
    public InputStream getUnicodeStream(String arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getUnicodeStream'");
    }

    @Override
    public SQLWarning getWarnings() throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getWarnings'");
    }

    @Override
    public void insertRow() throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'insertRow'");
    }

    @Override
    public boolean isAfterLast() throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'isAfterLast'");
    }

    @Override
    public boolean isBeforeFirst() throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'isBeforeFirst'");
    }

    @Override
    public boolean isClosed() throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'isClosed'");
    }

    @Override
    public boolean isFirst() throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'isFirst'");
    }

    @Override
    public boolean isLast() throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'isLast'");
    }

    @Override
    public boolean last() throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'last'");
    }

    @Override
    public void moveToCurrentRow() throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'moveToCurrentRow'");
    }

    @Override
    public void moveToInsertRow() throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'moveToInsertRow'");
    }

    @Override
    public boolean next() throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'next'");
    }

    @Override
    public boolean previous() throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'previous'");
    }

    @Override
    public void refreshRow() throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'refreshRow'");
    }

    @Override
    public boolean relative(int arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'relative'");
    }

    @Override
    public boolean rowDeleted() throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'rowDeleted'");
    }

    @Override
    public boolean rowInserted() throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'rowInserted'");
    }

    @Override
    public boolean rowUpdated() throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'rowUpdated'");
    }

    @Override
    public void setFetchDirection(int arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'setFetchDirection'");
    }

    @Override
    public void setFetchSize(int arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'setFetchSize'");
    }

    @Override
    public void updateArray(int arg0, Array arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateArray'");
    }

    @Override
    public void updateArray(String arg0, Array arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateArray'");
    }

    @Override
    public void updateAsciiStream(int arg0, InputStream arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateAsciiStream'");
    }

    @Override
    public void updateAsciiStream(String arg0, InputStream arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateAsciiStream'");
    }

    @Override
    public void updateAsciiStream(int arg0, InputStream arg1, int arg2) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateAsciiStream'");
    }

    @Override
    public void updateAsciiStream(String arg0, InputStream arg1, int arg2) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateAsciiStream'");
    }

    @Override
    public void updateAsciiStream(int arg0, InputStream arg1, long arg2) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateAsciiStream'");
    }

    @Override
    public void updateAsciiStream(String arg0, InputStream arg1, long arg2) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateAsciiStream'");
    }

    @Override
    public void updateBigDecimal(int arg0, BigDecimal arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateBigDecimal'");
    }

    @Override
    public void updateBigDecimal(String arg0, BigDecimal arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateBigDecimal'");
    }

    @Override
    public void updateBinaryStream(int arg0, InputStream arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateBinaryStream'");
    }

    @Override
    public void updateBinaryStream(String arg0, InputStream arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateBinaryStream'");
    }

    @Override
    public void updateBinaryStream(int arg0, InputStream arg1, int arg2) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateBinaryStream'");
    }

    @Override
    public void updateBinaryStream(String arg0, InputStream arg1, int arg2) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateBinaryStream'");
    }

    @Override
    public void updateBinaryStream(int arg0, InputStream arg1, long arg2) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateBinaryStream'");
    }

    @Override
    public void updateBinaryStream(String arg0, InputStream arg1, long arg2) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateBinaryStream'");
    }

    @Override
    public void updateBlob(int arg0, Blob arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateBlob'");
    }

    @Override
    public void updateBlob(String arg0, Blob arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateBlob'");
    }

    @Override
    public void updateBlob(int arg0, InputStream arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateBlob'");
    }

    @Override
    public void updateBlob(String arg0, InputStream arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateBlob'");
    }

    @Override
    public void updateBlob(int arg0, InputStream arg1, long arg2) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateBlob'");
    }

    @Override
    public void updateBlob(String arg0, InputStream arg1, long arg2) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateBlob'");
    }

    @Override
    public void updateBoolean(int arg0, boolean arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateBoolean'");
    }

    @Override
    public void updateBoolean(String arg0, boolean arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateBoolean'");
    }

    @Override
    public void updateByte(int arg0, byte arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateByte'");
    }

    @Override
    public void updateByte(String arg0, byte arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateByte'");
    }

    @Override
    public void updateBytes(int arg0, byte[] arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateBytes'");
    }

    @Override
    public void updateBytes(String arg0, byte[] arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateBytes'");
    }

    @Override
    public void updateCharacterStream(int arg0, Reader arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateCharacterStream'");
    }

    @Override
    public void updateCharacterStream(String arg0, Reader arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateCharacterStream'");
    }

    @Override
    public void updateCharacterStream(int arg0, Reader arg1, int arg2) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateCharacterStream'");
    }

    @Override
    public void updateCharacterStream(String arg0, Reader arg1, int arg2) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateCharacterStream'");
    }

    @Override
    public void updateCharacterStream(int arg0, Reader arg1, long arg2) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateCharacterStream'");
    }

    @Override
    public void updateCharacterStream(String arg0, Reader arg1, long arg2) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateCharacterStream'");
    }

    @Override
    public void updateClob(int arg0, Clob arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateClob'");
    }

    @Override
    public void updateClob(String arg0, Clob arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateClob'");
    }

    @Override
    public void updateClob(int arg0, Reader arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateClob'");
    }

    @Override
    public void updateClob(String arg0, Reader arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateClob'");
    }

    @Override
    public void updateClob(int arg0, Reader arg1, long arg2) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateClob'");
    }

    @Override
    public void updateClob(String arg0, Reader arg1, long arg2) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateClob'");
    }

    @Override
    public void updateDate(int arg0, Date arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateDate'");
    }

    @Override
    public void updateDate(String arg0, Date arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateDate'");
    }

    @Override
    public void updateDouble(int arg0, double arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateDouble'");
    }

    @Override
    public void updateDouble(String arg0, double arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateDouble'");
    }

    @Override
    public void updateFloat(int arg0, float arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateFloat'");
    }

    @Override
    public void updateFloat(String arg0, float arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateFloat'");
    }

    @Override
    public void updateInt(int arg0, int arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateInt'");
    }

    @Override
    public void updateInt(String arg0, int arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateInt'");
    }

    @Override
    public void updateLong(int arg0, long arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateLong'");
    }

    @Override
    public void updateLong(String arg0, long arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateLong'");
    }

    @Override
    public void updateNCharacterStream(int arg0, Reader arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateNCharacterStream'");
    }

    @Override
    public void updateNCharacterStream(String arg0, Reader arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateNCharacterStream'");
    }

    @Override
    public void updateNCharacterStream(int arg0, Reader arg1, long arg2) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateNCharacterStream'");
    }

    @Override
    public void updateNCharacterStream(String arg0, Reader arg1, long arg2) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateNCharacterStream'");
    }

    @Override
    public void updateNClob(int arg0, NClob arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateNClob'");
    }

    @Override
    public void updateNClob(String arg0, NClob arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateNClob'");
    }

    @Override
    public void updateNClob(int arg0, Reader arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateNClob'");
    }

    @Override
    public void updateNClob(String arg0, Reader arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateNClob'");
    }

    @Override
    public void updateNClob(int arg0, Reader arg1, long arg2) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateNClob'");
    }

    @Override
    public void updateNClob(String arg0, Reader arg1, long arg2) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateNClob'");
    }

    @Override
    public void updateNString(int arg0, String arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateNString'");
    }

    @Override
    public void updateNString(String arg0, String arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateNString'");
    }

    @Override
    public void updateNull(int arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateNull'");
    }

    @Override
    public void updateNull(String arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateNull'");
    }

    @Override
    public void updateObject(int arg0, Object arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateObject'");
    }

    @Override
    public void updateObject(String arg0, Object arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateObject'");
    }

    @Override
    public void updateObject(int arg0, Object arg1, int arg2) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateObject'");
    }

    @Override
    public void updateObject(String arg0, Object arg1, int arg2) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateObject'");
    }

    @Override
    public void updateRef(int arg0, Ref arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateRef'");
    }

    @Override
    public void updateRef(String arg0, Ref arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateRef'");
    }

    @Override
    public void updateRow() throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateRow'");
    }

    @Override
    public void updateRowId(int arg0, RowId arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateRowId'");
    }

    @Override
    public void updateRowId(String arg0, RowId arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateRowId'");
    }

    @Override
    public void updateSQLXML(int arg0, SQLXML arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateSQLXML'");
    }

    @Override
    public void updateSQLXML(String arg0, SQLXML arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateSQLXML'");
    }

    @Override
    public void updateShort(int arg0, short arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateShort'");
    }

    @Override
    public void updateShort(String arg0, short arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateShort'");
    }

    @Override
    public void updateString(int arg0, String arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateString'");
    }

    @Override
    public void updateString(String arg0, String arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateString'");
    }

    @Override
    public void updateTime(int arg0, Time arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateTime'");
    }

    @Override
    public void updateTime(String arg0, Time arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateTime'");
    }

    @Override
    public void updateTimestamp(int arg0, Timestamp arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateTimestamp'");
    }

    @Override
    public void updateTimestamp(String arg0, Timestamp arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateTimestamp'");
    }

    @Override
    public boolean wasNull() throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'wasNull'");
    }
  }

  public class BaseResultMetaData implements ResultSetMetaData {

    @Override
    public boolean isWrapperFor(Class<?> arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'isWrapperFor'");
    }

    @Override
    public <T> T unwrap(Class<T> arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'unwrap'");
    }

    @Override
    public String getCatalogName(int arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getCatalogName'");
    }

    @Override
    public String getColumnClassName(int arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getColumnClassName'");
    }

    @Override
    public int getColumnCount() throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getColumnCount'");
    }

    @Override
    public int getColumnDisplaySize(int arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getColumnDisplaySize'");
    }

    @Override
    public String getColumnLabel(int arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getColumnLabel'");
    }

    @Override
    public String getColumnName(int arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getColumnName'");
    }

    @Override
    public int getColumnType(int arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getColumnType'");
    }

    @Override
    public String getColumnTypeName(int arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getColumnTypeName'");
    }

    @Override
    public int getPrecision(int arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getPrecision'");
    }

    @Override
    public int getScale(int arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getScale'");
    }

    @Override
    public String getSchemaName(int arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getSchemaName'");
    }

    @Override
    public String getTableName(int arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getTableName'");
    }

    @Override
    public boolean isAutoIncrement(int arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'isAutoIncrement'");
    }

    @Override
    public boolean isCaseSensitive(int arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'isCaseSensitive'");
    }

    @Override
    public boolean isCurrency(int arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'isCurrency'");
    }

    @Override
    public boolean isDefinitelyWritable(int arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'isDefinitelyWritable'");
    }

    @Override
    public int isNullable(int arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'isNullable'");
    }

    @Override
    public boolean isReadOnly(int arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'isReadOnly'");
    }

    @Override
    public boolean isSearchable(int arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'isSearchable'");
    }

    @Override
    public boolean isSigned(int arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'isSigned'");
    }

    @Override
    public boolean isWritable(int arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'isWritable'");
    }
  }

  public class BaseParameterMetaData implements ParameterMetaData {

    @Override
    public boolean isWrapperFor(Class<?> arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'isWrapperFor'");
    }

    @Override
    public <T> T unwrap(Class<T> arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'unwrap'");
    }

    @Override
    public String getParameterClassName(int arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getParameterClassName'");
    }

    @Override
    public int getParameterCount() throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getParameterCount'");
    }

    @Override
    public int getParameterMode(int arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getParameterMode'");
    }

    @Override
    public int getParameterType(int arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getParameterType'");
    }

    @Override
    public String getParameterTypeName(int arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getParameterTypeName'");
    }

    @Override
    public int getPrecision(int arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getPrecision'");
    }

    @Override
    public int getScale(int arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getScale'");
    }

    @Override
    public int isNullable(int arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'isNullable'");
    }

    @Override
    public boolean isSigned(int arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'isSigned'");
    }
  }

  public class BaseStatement implements Statement {

    @Override
    public boolean isWrapperFor(Class<?> arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'isWrapperFor'");
    }

    @Override
    public <T> T unwrap(Class<T> arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'unwrap'");
    }

    @Override
    public void addBatch(String arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'addBatch'");
    }

    @Override
    public void cancel() throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'cancel'");
    }

    @Override
    public void clearBatch() throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'clearBatch'");
    }

    @Override
    public void clearWarnings() throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'clearWarnings'");
    }

    @Override
    public void close() throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'close'");
    }

    @Override
    public void closeOnCompletion() throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'closeOnCompletion'");
    }

    @Override
    public boolean execute(String arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'execute'");
    }

    @Override
    public boolean execute(String arg0, int arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'execute'");
    }

    @Override
    public boolean execute(String arg0, int[] arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'execute'");
    }

    @Override
    public boolean execute(String arg0, String[] arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'execute'");
    }

    @Override
    public int[] executeBatch() throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'executeBatch'");
    }

    @Override
    public ResultSet executeQuery(String arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'executeQuery'");
    }

    @Override
    public int executeUpdate(String arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'executeUpdate'");
    }

    @Override
    public int executeUpdate(String arg0, int arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'executeUpdate'");
    }

    @Override
    public int executeUpdate(String arg0, int[] arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'executeUpdate'");
    }

    @Override
    public int executeUpdate(String arg0, String[] arg1) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'executeUpdate'");
    }

    @Override
    public Connection getConnection() throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getConnection'");
    }

    @Override
    public int getFetchDirection() throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getFetchDirection'");
    }

    @Override
    public int getFetchSize() throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getFetchSize'");
    }

    @Override
    public ResultSet getGeneratedKeys() throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getGeneratedKeys'");
    }

    @Override
    public int getMaxFieldSize() throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getMaxFieldSize'");
    }

    @Override
    public int getMaxRows() throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getMaxRows'");
    }

    @Override
    public boolean getMoreResults() throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getMoreResults'");
    }

    @Override
    public boolean getMoreResults(int arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getMoreResults'");
    }

    @Override
    public int getQueryTimeout() throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getQueryTimeout'");
    }

    @Override
    public ResultSet getResultSet() throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getResultSet'");
    }

    @Override
    public int getResultSetConcurrency() throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getResultSetConcurrency'");
    }

    @Override
    public int getResultSetHoldability() throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getResultSetHoldability'");
    }

    @Override
    public int getResultSetType() throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getResultSetType'");
    }

    @Override
    public int getUpdateCount() throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getUpdateCount'");
    }

    @Override
    public SQLWarning getWarnings() throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getWarnings'");
    }

    @Override
    public boolean isCloseOnCompletion() throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'isCloseOnCompletion'");
    }

    @Override
    public boolean isClosed() throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'isClosed'");
    }

    @Override
    public boolean isPoolable() throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'isPoolable'");
    }

    @Override
    public void setCursorName(String arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'setCursorName'");
    }

    @Override
    public void setEscapeProcessing(boolean arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'setEscapeProcessing'");
    }

    @Override
    public void setFetchDirection(int arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'setFetchDirection'");
    }

    @Override
    public void setFetchSize(int arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'setFetchSize'");
    }

    @Override
    public void setMaxFieldSize(int arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'setMaxFieldSize'");
    }

    @Override
    public void setMaxRows(int arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'setMaxRows'");
    }

    @Override
    public void setPoolable(boolean arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'setPoolable'");
    }

    @Override
    public void setQueryTimeout(int arg0) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'setQueryTimeout'");
    }
  }

}
