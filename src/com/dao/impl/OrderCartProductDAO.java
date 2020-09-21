package com.dao.impl;

import java.sql.PreparedStatement;
import java.util.List;

import com.dao.DAO;
import com.dao.conn.MySQLConnection;
import com.entity.OrderCartProduct;

public class OrderCartProductDAO implements DAO<OrderCartProduct> {
  // TODO: This table has 2 Primary Keys, how to Update?
  public OrderCartProductDAO() {
    MySQLConnection.init();
  }

  @Override
  public boolean create(OrderCartProduct data) {
    try {
      String sql = "INSERT INTO OrderCart_Product VALUES (?,?,?)";
      PreparedStatement pst = MySQLConnection.getConnection().prepareStatement(sql);
      pst.setString(1, String.valueOf(data.getCart().getCartID()));
      pst.setString(2, String.valueOf(data.getProduct().getProductID()));
      pst.setString(3, String.valueOf(data.getQuantity()));

      pst.executeUpdate();
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  @Override
  public List<OrderCartProduct> getAll() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public OrderCartProduct find(int id) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<OrderCartProduct> getAllWhere(String sql) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean update(int id, OrderCartProduct data) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean destroy(int id) {
    // TODO Auto-generated method stub
    return false;
  }

}
