package com.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dao.DAO;
import com.dao.conn.MySQLConnection;
import com.entity.Payment;

public class PaymentDAO implements DAO<Payment> {
  @Override
  public boolean create(Payment data) {
    try {
      String sql = "INSERT INTO Payment (`name`, `type`) VALUES (?,?)";
      PreparedStatement pst = MySQLConnection.getConnection().prepareStatement(sql);
      pst.setString(1, data.getName());
      pst.setString(2, data.getType());

      pst.executeUpdate();
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  @Override
  public List<Payment> getAll() {
    List<Payment> payments = new ArrayList<>();
    Payment payment = null;

    try {
      String sql = "SELECT * FROM Payment";
      PreparedStatement pst = MySQLConnection.getConnection().prepareStatement(sql);
      ResultSet rs = pst.executeQuery();

      while (rs.next()) {
        payment = new Payment();
        payment.setPaymentID(rs.getInt("payment_id"));
        payment.setName(rs.getString("name"));
        payment.setType(rs.getString("type"));

        payments.add(payment);
      }

      return payments;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public Payment find(int id) {
    Payment payment = null;

    try {
      String sql = "SELECT * FROM Payment WHERE payment_id = ?";
      PreparedStatement pst = MySQLConnection.getConnection().prepareStatement(sql);
      pst.setString(1, String.valueOf(id));

      ResultSet rs = pst.executeQuery();

      while (rs.next()) {
        payment = new Payment();
        payment.setPaymentID(rs.getInt("payment_id"));
        payment.setName(rs.getString("name"));
        payment.setType(rs.getString("type"));
      }

      return payment;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public List<Payment> getAllWhere(String query) {
    List<Payment> payments = new ArrayList<>();
    Payment payment = null;

    try {
      String sql = "SELECT * FROM Payment WHERE ?";
      PreparedStatement pst = MySQLConnection.getConnection().prepareStatement(sql);
      pst.setString(1, query);

      ResultSet rs = pst.executeQuery();

      while (rs.next()) {
        payment = new Payment();
        payment.setPaymentID(rs.getInt("payment_id"));
        payment.setName(rs.getString("name"));
        payment.setType(rs.getString("type"));

        payments.add(payment);
      }

      return payments;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public boolean update(int id, Payment data) {
    try {
      String sql = "UPDATE Payment SET name=?, type=? WHERE payment_id=?";
      PreparedStatement pst = MySQLConnection.getConnection().prepareStatement(sql);
      pst.setString(1, data.getName());
      pst.setString(2, data.getType());
      pst.setString(3, String.valueOf(id));

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
      String sql = "DELETE FROM Payment WHERE payment_id=?";
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
