package com.dao.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
  private static Connection conn = null;

  public static void init() {
    final String URL = "jdbc:mysql://localhost:3306/db_phonezell";
    final String USR = "root";
    final String PWD = "";

    try {
      conn = DriverManager.getConnection(URL, USR, PWD);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static Connection getConnection() {
    return conn;
  }

  public static void closeConnection() {
    try {
      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
