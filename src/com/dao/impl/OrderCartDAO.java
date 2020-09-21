package com.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import com.dao.DAO;
import com.dao.conn.MySQLConnection;
import com.entity.OrderCart;
import com.entity.User;

public class OrderCartDAO implements DAO<OrderCart> {
  private UserDAO userdao;

  public OrderCartDAO() {
    userdao = new UserDAO();
  }

  @Override
  public boolean create(OrderCart data) {
    try {
      String sql = "INSERT INTO OrderCart (`checkout_date`, `user_id`) VALUES (?,?)";
      PreparedStatement pst = MySQLConnection.getConnection().prepareStatement(sql);
      pst.setString(1, String.valueOf(data.getCheckoutDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()));
      pst.setString(2, String.valueOf(data.getUser().getUserID()));

      pst.executeUpdate();
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  @Override
  public List<OrderCart> getAll() {
    List<OrderCart> carts = new ArrayList<>();
    OrderCart cart = null;
    User user = null;

    try {
      String sql = "SELECT * FROM OrderCart";
      PreparedStatement pst = MySQLConnection.getConnection().prepareStatement(sql);
      ResultSet rs = pst.executeQuery();

      while (rs.next()) {
        cart = new OrderCart();
        cart.setCartID(rs.getInt("cart_id"));
        cart.setCheckoutDate(rs.getDate("checkout_date"));

        user = new User();
        user = userdao.find(rs.getInt("user_id"));

        cart.setUser(user);
        carts.add(cart);
      }

      return carts;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public OrderCart find(int id) {
    OrderCart cart = null;
    User user = null;

    try {
      String sql = "SELECT * FROM OrderCart WHERE cart_id = ?";
      PreparedStatement pst = MySQLConnection.getConnection().prepareStatement(sql);
      pst.setString(1, String.valueOf(id));

      ResultSet rs = pst.executeQuery();

      while (rs.next()) {
        cart = new OrderCart();
        cart.setCartID(rs.getInt("cart_id"));
        cart.setCheckoutDate(rs.getDate("checkout_date"));

        user = new User();
        user = userdao.find(rs.getInt("user_id"));

        cart.setUser(user);
      }

      return cart;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public List<OrderCart> getAllWhere(String query) {
    List<OrderCart> carts = new ArrayList<>();
    OrderCart cart = null;
    User user = null;

    try {
      String sql = "SELECT * FROM OrderCart WHERE ?";
      PreparedStatement pst = MySQLConnection.getConnection().prepareStatement(sql);
      pst.setString(1, query);

      ResultSet rs = pst.executeQuery();

      while (rs.next()) {
        cart = new OrderCart();
        cart.setCartID(rs.getInt("cart_id"));
        cart.setCheckoutDate(rs.getDate("checkout_date"));

        user = new User();
        user = userdao.find(rs.getInt("user_id"));

        cart.setUser(user);
        carts.add(cart);
      }

      return carts;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public boolean update(int id, OrderCart data) {
    try {
      String sql = "UPDATE OrderCart SET checkout_date=?, user_id=? WHERE cart_id=?";
      PreparedStatement pst = MySQLConnection.getConnection().prepareStatement(sql);
      pst.setString(1, String.valueOf(data.getCheckoutDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()));
      pst.setString(2, String.valueOf(data.getUser().getUserID()));
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
      String sql = "DELETE FROM OrderCart WHERE cart_id=?";
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
