package io.github.mkdev.dao;

import io.github.mkdev.model.Role;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Locale;


public class H2BaseRepository {
  private Connection connection;


  public H2BaseRepository(Connection connection) {
    this.connection = connection;
  }


  /**
   * Execute SQL query for insert new record.
   * @param insertQuery sql query
   * @return id of inserted row
   * @throws SQLException when some error in inserting query.
   */
  public String insert(String insertQuery) throws SQLException {
    String id = null;


    String[] returnedAttributes = {"id"};
    try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery,
                                                                returnedAttributes);) {
      int rows = insertStatement.executeUpdate();
      if (rows == 0) {
        throw new SQLException("Failed of insertion");
      }
      try (ResultSet rs = insertStatement.getGeneratedKeys()) {
        if (rs.next()) {
          id = rs.getString("id");
        } else {
          throw new SQLException("Failed of insertion");
        }
      }
    }


    return id;
  }


  /**
   * Select all field from table by name and row id.
   * @param tableName name of table
   * @param id row id
   * @return {@link java.util.HashMap} with k/v table representation
   * @throws SQLException if can't retrieve field.
   */
  public HashMap<String, String> selectAllFieldsByTableNameAndId(String tableName, String id)
                                                                          throws SQLException {
    HashMap<String, String> result = new HashMap<>();
    Statement statementx = connection.createStatement();
    ResultSet selectStatement = statementx.executeQuery(
              "SELECT * FROM "
                + tableName.toUpperCase(Locale.ENGLISH)
        + " WHERE ID='" + id + "';"
    );
    while (selectStatement.next()) {
      Class<?> cls = Role.class;
      Field[] fieldlist = cls.getDeclaredFields();
      for (Field field : fieldlist) {
        result.put(field.getName(), selectStatement.getString(field.getName()));
      }
    }
    return result;
  }

  public void updateFieldByTableNameFieldNameAndId(String tableName,
                                                 String fieldName, String id, String updateValue)
                                             throws SQLException {
    Statement statementx = connection.createStatement();
    statementx.executeUpdate(String.format("UPDATE %s SET %s = '%s' WHERE ID ='%s'",
        tableName.toUpperCase(Locale.ENGLISH), fieldName.toUpperCase(Locale.ENGLISH),
                                                              updateValue, id));
  }

  public void deleteRowByTableNameAndRowId(String tableName, String id)
    throws SQLException {
    Statement statementx = connection.createStatement();
    statementx.executeUpdate(String.format("delete from %s where ID='%s'",
      tableName.toUpperCase(Locale.ENGLISH), id));
  }

  public void createRowByTableNameAndColumns(String tableName, String [] values)
    throws SQLException {
    Statement statementx = connection.createStatement();
    StringBuilder valueAppend = new StringBuilder();
    valueAppend.append("INSERT INTO ").append(tableName).append(" VALUES (");
    for (int i = 0; i <values.length ; i++) {
      if (i!=values.length-1){
                  valueAppend.append("'").append(values[i]).append("', ");
      } else valueAppend.append("'").append(values[i]).append("')");
    }

    statementx.executeUpdate(valueAppend.toString());
  }


}
