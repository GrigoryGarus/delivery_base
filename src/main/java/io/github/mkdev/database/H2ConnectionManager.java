package io.github.mkdev.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class H2ConnectionManager {
  private static final int INITIAL_POOL_SIZE = 10;
  private final List<Connection> connectionPool;
  private final List<Connection> usedConnections = new ArrayList<>();


  private H2ConnectionManager(List<Connection> connectionPool) {
    this.connectionPool = connectionPool;
  }


  /**
   * Create new connection manager instance.
   */
  public static H2ConnectionManager create() throws SQLException {


    String url = "jdbc:h2:mem:delivery;"
         + "INIT=RUNSCRIPT FROM 'classpath:init.sql'";
    String user = "";
    String password = "";


    List<Connection> pool = new ArrayList<>(INITIAL_POOL_SIZE);
    for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
      pool.add(createConnection(url, user, password));
    }
    return new H2ConnectionManager(pool);
  }


  private static Connection createConnection(
             String url, String user, String password)
            throws SQLException {
    return DriverManager.getConnection(url, user, password);
  }


  /**
   * Get database connection.
   */
  public Connection getConnection() {
    Connection connection = connectionPool
              .remove(connectionPool.size() - 1);
    usedConnections.add(connection);
    return connection;
  }


  public boolean releaseConnection(Connection connection) {
    connectionPool.add(connection);
    return usedConnections.remove(connection);
  }


  public int getSize() {
    return connectionPool.size() + usedConnections.size();
  }
}
