package com.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dao.DAO;
import com.dao.conn.MySQLConnection;
import com.entity.EWallet;
import com.entity.User;

public class EWalletDAO implements DAO<EWallet> {
  UserDAO userdao = new UserDAO();

  @Override
  public boolean create(EWallet data) {
    try {
      String sql = "INSERT INTO EWallet (`balance`, `pin`, `user_id`) VALUES (?,?,?)";
      PreparedStatement pst = MySQLConnection.getConnection().prepareStatement(sql);
      pst.setString(1, String.valueOf(data.getBalance()));
      pst.setString(2, String.valueOf(data.getPin()));
      pst.setString(3, String.valueOf(data.getUser().getUserID()));

      pst.executeUpdate();
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  @Override
  public List<EWallet> getAll() {
    List<EWallet> ewallets = new ArrayList<>();
    EWallet ewallet = null;
    User user = null;

    try {
      String sql = "SELECT * FROM EWallet";
      PreparedStatement pst = MySQLConnection.getConnection().prepareStatement(sql);
      ResultSet rs = pst.executeQuery();

      while (rs.next()) {
        ewallet = new EWallet();
        ewallet.setEwalletID(rs.getInt("ewallet_id"));
        ewallet.setBalance(rs.getDouble("balance"));
        ewallet.setPin(rs.getInt("pin"));

        user = new User();
        user = userdao.find(rs.getInt("user_id"));

        ewallet.setUser(user);
        ewallets.add(ewallet);
      }

      return ewallets;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public EWallet find(int id) {
    EWallet ewallet = null;
    User user = null;

    try {
      String sql = "SELECT * FROM EWallet WHERE ewallet_id = ?";
      PreparedStatement pst = MySQLConnection.getConnection().prepareStatement(sql);
      pst.setString(1, String.valueOf(id));

      ResultSet rs = pst.executeQuery();

      while (rs.next()) {
        ewallet = new EWallet();
        ewallet.setEwalletID(rs.getInt("ewallet_id"));
        ewallet.setBalance(rs.getDouble("balance"));
        ewallet.setPin(rs.getInt("pin"));

        user = new User();
        user = userdao.find(rs.getInt("user_id"));

        ewallet.setUser(user);
      }

      return ewallet;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public List<EWallet> getAllWhere(String query) {
    List<EWallet> ewallets = new ArrayList<>();
    EWallet ewallet = null;
    User user = null;

    try {
      String sql = "SELECT * FROM EWallet WHERE ?";
      PreparedStatement pst = MySQLConnection.getConnection().prepareStatement(sql);
      pst.setString(1, query);
      ResultSet rs = pst.executeQuery();

      while (rs.next()) {
        ewallet = new EWallet();
        ewallet.setEwalletID(rs.getInt("ewallet_id"));
        ewallet.setBalance(rs.getDouble("balance"));
        ewallet.setPin(rs.getInt("pin"));

        user = new User();
        user = userdao.find(rs.getInt("user_id"));

        ewallet.setUser(user);
        ewallets.add(ewallet);
      }

      return ewallets;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public boolean update(int id, EWallet data) {
    try {
      String sql = "UPDATE EWallet SET balance=?, pin=?, user_id=? WHERE ewallet_id=?";
      PreparedStatement pst = MySQLConnection.getConnection().prepareStatement(sql);
      pst.setString(1, String.valueOf(data.getBalance()));
      pst.setString(2, String.valueOf(data.getPin()));
      pst.setString(3, String.valueOf(data.getUser().getUserID()));
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
      String sql = "DELETE FROM EWallet WHERE ewallet_id=?";
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
