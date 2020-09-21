package com.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dao.DAO;
import com.dao.conn.MySQLConnection;
import com.entity.User;

public class UserDAO implements DAO<User> {
  @Override
  public boolean create(User data) {
    try {
      String sql = "INSERT INTO User (`email`, `password`, `fullname`, `dob`, `gender`, `phone_number`, `photo_url`, `date_joined`) VALUES (?,?,?,?,?,?,?,?)";
      PreparedStatement pst = MySQLConnection.getConnection().prepareStatement(sql);
      pst.setString(1, data.getEmail());
      pst.setString(2, data.getPassword());
      pst.setString(3, data.getFullname());
      pst.setString(4, String.valueOf(data.getDob().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()));
      pst.setString(5, String.valueOf(data.getGender()));
      pst.setString(6, data.getPhoneNumber());
      pst.setString(7, data.getPhotoUrl());
      pst.setString(8, String.valueOf(new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()));
      // TODO: is Java Date compatible with MySQL Date?

      pst.executeUpdate();
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  @Override
  public List<User> getAll() {
    List<User> users = new ArrayList<>();
    User user = null;

    try {
      String sql = "SELECT * FROM User";
      PreparedStatement pst = MySQLConnection.getConnection().prepareStatement(sql);
      ResultSet rs = pst.executeQuery();

      while (rs.next()) {
        user = new User();
        user.setUserID(rs.getInt("user_id"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setFullname(rs.getString("fullname"));
        user.setDob(rs.getDate("dob"));
        user.setGender(rs.getByte("gender"));
        user.setPhoneNumber(rs.getString("phone_number"));
        user.setPhotoUrl(rs.getString("photo_url"));
        user.setDateJoined(rs.getDate("date_joined"));
        user.setRole(rs.getByte("role"));

        users.add(user);
      }

      return users;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public User find(int id) {
    User user = null;

    try {
      String sql = "SELECT * FROM User WHERE user_id = ?";
      PreparedStatement pst = MySQLConnection.getConnection().prepareStatement(sql);
      pst.setString(1, String.valueOf(id));

      ResultSet rs = pst.executeQuery();

      while (rs.next()) {
        user = new User();
        user.setUserID(rs.getInt("user_id"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setFullname(rs.getString("fullname"));
        user.setDob(rs.getDate("dob"));
        user.setGender(rs.getByte("gender"));
        user.setPhoneNumber(rs.getString("phone_number"));
        user.setPhotoUrl(rs.getString("photo_url"));
        user.setDateJoined(rs.getDate("date_joined"));
        user.setRole(rs.getByte("role"));
      }

      return user;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public List<User> getAllWhere(String query) {
    List<User> users = new ArrayList<>();
    User user = null;

    try {
      String sql = "SELECT * FROM User WHERE ?";
      PreparedStatement pst = MySQLConnection.getConnection().prepareStatement(sql);
      pst.setString(1, query);

      ResultSet rs = pst.executeQuery();

      while (rs.next()) {
        user = new User();
        user.setUserID(rs.getInt("user_id"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setFullname(rs.getString("fullname"));
        user.setDob(rs.getDate("dob"));
        user.setGender(rs.getByte("gender"));
        user.setPhoneNumber(rs.getString("phone_number"));
        user.setPhotoUrl(rs.getString("photo_url"));
        user.setDateJoined(rs.getDate("date_joined"));
        user.setRole(rs.getByte("role"));

        users.add(user);
      }

      return users;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public boolean update(int id, User data) {
    try {
      String sql = "UPDATE User SET email=?, password=?, fullname=?, dob=?, gender=?, phone_number=?, photo_url=? WHERE user_id=?";
      PreparedStatement pst = MySQLConnection.getConnection().prepareStatement(sql);
      pst.setString(1, data.getEmail());
      pst.setString(2, data.getPassword());
      pst.setString(3, data.getFullname());
      pst.setString(4, String.valueOf(data.getDob()));
      pst.setString(5, String.valueOf(data.getGender()));
      pst.setString(6, data.getPhoneNumber());
      pst.setString(7, data.getPhotoUrl());
      pst.setString(8, String.valueOf(id));

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
      String sql = "DELETE FROM User WHERE user_id=?";
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
