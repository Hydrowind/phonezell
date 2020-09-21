package com.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dao.DAO;
import com.dao.conn.MySQLConnection;
import com.entity.Log;

public class LogDAO implements DAO<Log> {
  public LogDAO() {
  }

  @Override
  public boolean create(Log data) {
    try {
      String sql = "INSERT INTO Log VALUES (?,?,?)";
      PreparedStatement pst = MySQLConnection.getConnection().prepareStatement(sql);
      pst.setString(1, data.getAction());
      pst.setString(2, data.getTable());
      pst.setString(3, String.valueOf(data.getDatetime()));

      pst.executeUpdate();
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  @Override
  public List<Log> getAll() {
    List<Log> logs = new ArrayList<>();
    Log log = null;

    try {
      String sql = "SELECT * FROM Log";
      PreparedStatement pst = MySQLConnection.getConnection().prepareStatement(sql);
      ResultSet rs = pst.executeQuery();

      while (rs.next()) {
        log = new Log();
        log.setLogID(rs.getInt("log_id"));
        log.setAction(rs.getString("action"));
        log.setTable(rs.getString("table"));

        logs.add(log);
      }

      return logs;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public Log find(int id) {
    Log log = null;

    try {
      String sql = "SELECT * FROM Log WHERE log_id = ?";
      PreparedStatement pst = MySQLConnection.getConnection().prepareStatement(sql);
      pst.setString(1, String.valueOf(id));

      ResultSet rs = pst.executeQuery();

      while (rs.next()) {
        log = new Log();
        log.setLogID(rs.getInt("log_id"));
        log.setAction(rs.getString("action"));
        log.setTable(rs.getString("table"));
        // TODO: Set Timestamp
      }

      return log;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public List<Log> getAllWhere(String query) {
    List<Log> logs = new ArrayList<>();
    Log log = null;

    try {
      String sql = "SELECT * FROM Log WHERE ?";
      PreparedStatement pst = MySQLConnection.getConnection().prepareStatement(sql);
      pst.setString(1, query);

      ResultSet rs = pst.executeQuery();

      while (rs.next()) {
        log = new Log();
        log.setLogID(rs.getInt("log_id"));
        log.setAction(rs.getString("action"));
        log.setTable(rs.getString("table"));

        logs.add(log);
      }

      return logs;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public boolean update(int id, Log data) {
    try {
      String sql = "UPDATE Log SET action=?, table=?, datetime=? WHERE log_id=?";
      PreparedStatement pst = MySQLConnection.getConnection().prepareStatement(sql);
      pst.setString(1, data.getAction());
      pst.setString(2, data.getTable());
      pst.setString(3, String.valueOf(data.getDatetime()));
      pst.setString(4, String.valueOf(id));

      pst.executeUpdate();
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  @Override
  public boolean destroy(int id) {
    try {
      String sql = "DELETE FROM Log WHERE log_id=?";
      PreparedStatement pst = MySQLConnection.getConnection().prepareStatement(sql);
      pst.setString(1, String.valueOf(id));

      pst.executeUpdate();
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

}
