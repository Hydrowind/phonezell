package com.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dao.DAO;
import com.dao.conn.MySQLConnection;
import com.entity.Product;

public class ProductDAO implements DAO<Product> {
  @Override
  public boolean create(Product data) {
    try {
      String sql = "INSERT INTO `product`(`name`, `brand`, `description`, `color`, `weight`, `condition`, `img_url`, `stock`, `price`, `date_created`) VALUES (?,?,?,?,?,?,?,?,?,?)";
      PreparedStatement pst = MySQLConnection.getConnection().prepareStatement(sql);
      pst.setString(1, data.getName());
      pst.setString(2, data.getBrand());
      pst.setString(3, data.getDescription());
      pst.setString(4, data.getColor());
      pst.setString(5, String.valueOf(data.getWeight()));
      pst.setString(6, String.valueOf(data.getCondition()));
      pst.setString(7, data.getImgUrl());
      pst.setString(8, String.valueOf(data.getStock()));
      pst.setString(9, String.valueOf(data.getPrice()));
      pst.setString(10, String.valueOf(data.getDateCreated().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()));

      pst.executeUpdate();
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  @Override
  public List<Product> getAll() {
    List<Product> products = new ArrayList<>();
    Product product = null;

    try {
      String sql = "SELECT * FROM Product";
      PreparedStatement pst = MySQLConnection.getConnection().prepareStatement(sql);
      ResultSet rs = pst.executeQuery();

      while (rs.next()) {
        product = new Product();
        product.setProductID(rs.getInt("product_id"));
        product.setName(rs.getString("name"));
        product.setBrand(rs.getString("brand"));
        product.setDescription(rs.getString("description"));
        product.setColor(rs.getString("color"));
        product.setWeight(rs.getDouble("weight"));
        product.setCondition(rs.getInt("condition"));
        product.setImgUrl(rs.getString("img_url"));
        product.setStock(rs.getInt("stock"));
        product.setPrice(rs.getDouble("price"));
        product.setDateCreated(rs.getDate("date_created"));
        product.setDateModified(rs.getDate("date_modified"));
        product.setDateDeleted(rs.getDate("date_deleted"));
        // TODO: setModifiedFrom()

        products.add(product);
      }

      return products;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public Product find(int id) {
    Product product = null;

    try {
      String sql = "SELECT * FROM Product WHERE product_id = ?";
      PreparedStatement pst = MySQLConnection.getConnection().prepareStatement(sql);
      pst.setString(1, String.valueOf(id));

      ResultSet rs = pst.executeQuery();

      while (rs.next()) {
        product = new Product();
        product.setProductID(rs.getInt("product_id"));
        product.setName(rs.getString("name"));
        product.setBrand(rs.getString("brand"));
        product.setDescription(rs.getString("description"));
        product.setColor(rs.getString("color"));
        product.setWeight(rs.getDouble("weight"));
        product.setCondition(rs.getInt("condition"));
        product.setImgUrl(rs.getString("img_url"));
        product.setStock(rs.getInt("stock"));
        product.setPrice(rs.getDouble("price"));
        product.setDateCreated(rs.getDate("date_created"));
        product.setDateModified(rs.getDate("date_modified"));
        product.setDateDeleted(rs.getDate("date_deleted"));
        // TODO: setModifiedFrom()
      }

      return product;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public List<Product> getAllWhere(String query) {
    List<Product> products = new ArrayList<>();
    Product product = null;

    try {
      String sql = "SELECT * FROM Product WHERE ?";
      PreparedStatement pst = MySQLConnection.getConnection().prepareStatement(sql);
      pst.setString(1, query);

      ResultSet rs = pst.executeQuery();

      while (rs.next()) {
        product = new Product();
        product.setProductID(rs.getInt("product_id"));
        product.setName(rs.getString("name"));
        product.setBrand(rs.getString("brand"));
        product.setDescription(rs.getString("description"));
        product.setColor(rs.getString("color"));
        product.setWeight(rs.getDouble("weight"));
        product.setCondition(rs.getInt("condition"));
        product.setImgUrl(rs.getString("img_url"));
        product.setStock(rs.getInt("stock"));
        product.setPrice(rs.getDouble("price"));
        product.setDateCreated(rs.getDate("date_created"));
        product.setDateModified(rs.getDate("date_modified"));
        product.setDateDeleted(rs.getDate("date_deleted"));
        // TODO: setModifiedFrom()

        products.add(product);
      }

      return products;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public boolean update(int id, Product data) {
    try {
      this.destroy(id);

      String sql = "INSERT INTO `product`(`name`, `brand`, `description`, `color`, `weight`, `condition`, `img_url`, `stock`, `price`, `date_created`, `date_modified`, `date_deleted`, `modified_from`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
      PreparedStatement pst = MySQLConnection.getConnection().prepareStatement(sql);
      pst.setString(1, data.getName());
      pst.setString(2, data.getBrand());
      pst.setString(3, data.getDescription());
      pst.setString(4, data.getColor());
      pst.setString(5, String.valueOf(data.getWeight()));
      pst.setString(6, String.valueOf(data.getCondition()));
      pst.setString(7, data.getImgUrl());
      pst.setString(8, String.valueOf(data.getStock()));
      pst.setString(9, String.valueOf(data.getPrice()));
      pst.setString(10, String.valueOf(data.getDateCreated())); // java.sql.date can be directly inserted
      pst.setString(11, String.valueOf(new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()));
      pst.setString(12, null);
      pst.setString(13, String.valueOf(id));

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
      String sql = "UPDATE Product SET date_deleted=? WHERE product_id=?";
      PreparedStatement pst = MySQLConnection.getConnection().prepareStatement(sql);
      pst.setString(1, String.valueOf(new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()));
      pst.setString(2, String.valueOf(id));

      pst.executeUpdate();
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

}
