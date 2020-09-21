package com.dao.impl;

import java.util.ArrayList;
import java.util.List;
import com.dao.DAO;
import com.dao.conn.MySQLConnection;
import com.entity.Address;
import com.entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AddressDAO implements DAO<Address> {
  UserDAO userdao = new UserDAO();

  @Override
  public boolean create(Address data) {
    try {
      String sql = "INSERT INTO ADDRESS (`province`, `city`, `details`, `latitude`, `longitude`, `user_id`) VALUES (?,?,?,?,?,?)";
      PreparedStatement pst = MySQLConnection.getConnection().prepareStatement(sql);
      pst.setString(1, data.getProvince());
      pst.setString(2, data.getCity());
      pst.setString(3, data.getDetails());
      pst.setString(4, String.valueOf(data.getLatitude()));
      pst.setString(5, String.valueOf(data.getLongitude()));
      pst.setString(6, String.valueOf(data.getUser().getUserID()));

      pst.executeUpdate();
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  @Override
  public Address find(int id) {
    Address address = null;
    User user = null;

    try {
      String sql = "SELECT * FROM ADDRESS WHERE address_id = ?";
      PreparedStatement pst = MySQLConnection.getConnection().prepareStatement(sql);
      pst.setString(1, String.valueOf(id));

      ResultSet rs = pst.executeQuery();

      while (rs.next()) {
        address = new Address();
        address.setAddressID(rs.getInt("address_id"));
        address.setProvince(rs.getString("province"));
        address.setCity(rs.getString("city"));
        address.setDetails(rs.getString("details"));
        address.setLatitude(rs.getDouble("latitude"));
        address.setLongitude(rs.getDouble("longitude"));

        user = new User();
        user = userdao.find(rs.getInt("user_id"));

        address.setUser(user);
      }

      return address;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public List<Address> getAll() {
    List<Address> addresses = new ArrayList<Address>();
    Address address = null;
    User user = null;

    try {
      String sql = "SELECT * FROM ADDRESS";
      PreparedStatement pst = MySQLConnection.getConnection().prepareStatement(sql);
      ResultSet rs = pst.executeQuery();

      while (rs.next()) {
        address = new Address();
        address.setAddressID(rs.getInt("address_id"));
        address.setProvince(rs.getString("province"));
        address.setCity(rs.getString("city"));
        address.setDetails(rs.getString("details"));
        address.setLatitude(rs.getDouble("latitude"));
        address.setLongitude(rs.getDouble("longitude"));

        user = new User();
        user = userdao.find(rs.getInt("user_id"));

        address.setUser(user);
        addresses.add(address);
      }

      return addresses;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public boolean update(int id, Address data) {
    try {
      String sql = "UPDATE ADDRESS SET province=?, city=?, details=?, latitude=?, longitude=?, user_id=? WHERE address_id=?";
      PreparedStatement pst = MySQLConnection.getConnection().prepareStatement(sql);
      pst.setString(1, data.getProvince());
      pst.setString(2, data.getCity());
      pst.setString(3, data.getDetails());
      pst.setString(4, String.valueOf(data.getLatitude()));
      pst.setString(5, String.valueOf(data.getLongitude()));
      pst.setString(6, String.valueOf(data.getUser().getUserID()));
      pst.setString(7, String.valueOf(id));

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
      String sql = "DELETE FROM ADDRESS WHERE address_id=?";
      PreparedStatement pst = MySQLConnection.getConnection().prepareStatement(sql);
      pst.setString(1, String.valueOf(id));

      pst.executeUpdate();
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  @Override
  public List<Address> getAllWhere(String query) {
    List<Address> addresses = new ArrayList<Address>();
    Address address = null;
    User user = null;

    try {
      String sql = "SELECT * FROM ADDRESS WHERE ?";
      PreparedStatement pst = MySQLConnection.getConnection().prepareStatement(sql);
      pst.setString(1, query);
      ResultSet rs = pst.executeQuery();

      while (rs.next()) {
        address = new Address();
        address.setAddressID(rs.getInt("address_id"));
        address.setProvince(rs.getString("province"));
        address.setCity(rs.getString("city"));
        address.setDetails(rs.getString("details"));
        address.setLatitude(rs.getDouble("latitude"));
        address.setLongitude(rs.getDouble("longitude"));

        user = new User();
        user = userdao.find(rs.getInt("user_id"));

        address.setUser(user);
        addresses.add(address);
      }

      return addresses;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

}
