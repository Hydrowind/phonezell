package com.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dao.DAO;
import com.dao.conn.MySQLConnection;
import com.entity.Shipment;

public class ShipmentDAO implements DAO<Shipment> {
  @Override
  public boolean create(Shipment data) {
    try {
      String sql = "INSERT INTO Shipment (`name`, `service`) VALUES (?,?)";
      PreparedStatement pst = MySQLConnection.getConnection().prepareStatement(sql);
      pst.setString(1, data.getName());
      pst.setString(2, data.getService());

      pst.executeUpdate();
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  @Override
  public List<Shipment> getAll() {
    List<Shipment> shipments = new ArrayList<>();
    Shipment shipment = null;

    try {
      String sql = "SELECT * FROM Shipment";
      PreparedStatement pst = MySQLConnection.getConnection().prepareStatement(sql);
      ResultSet rs = pst.executeQuery();

      while (rs.next()) {
        shipment = new Shipment();
        shipment.setShipmentID(rs.getInt("shipment_id"));
        shipment.setName(rs.getString("name"));
        shipment.setService(rs.getString("service"));

        shipments.add(shipment);
      }

      return shipments;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public Shipment find(int id) {
    Shipment shipment = null;

    try {
      String sql = "SELECT * FROM Shipment WHERE shipment_id = ?";
      PreparedStatement pst = MySQLConnection.getConnection().prepareStatement(sql);
      pst.setString(1, String.valueOf(id));

      ResultSet rs = pst.executeQuery();

      while (rs.next()) {
        shipment = new Shipment();
        shipment.setShipmentID(rs.getInt("shipment_id"));
        shipment.setName(rs.getString("name"));
        shipment.setService(rs.getString("service"));
      }

      return shipment;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public List<Shipment> getAllWhere(String query) {
    List<Shipment> shipments = new ArrayList<>();
    Shipment shipment = null;

    try {
      String sql = "SELECT * FROM Shipment WHERE ?";
      PreparedStatement pst = MySQLConnection.getConnection().prepareStatement(sql);
      pst.setString(1, query);

      ResultSet rs = pst.executeQuery();

      while (rs.next()) {
        shipment = new Shipment();
        shipment.setShipmentID(rs.getInt("shipment_id"));
        shipment.setName(rs.getString("name"));
        shipment.setService(rs.getString("service"));

        shipments.add(shipment);
      }

      return shipments;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public boolean update(int id, Shipment data) {
    try {
      String sql = "UPDATE Shipment SET name=?, service=? WHERE shipment_id=?";
      PreparedStatement pst = MySQLConnection.getConnection().prepareStatement(sql);
      pst.setString(1, data.getName());
      pst.setString(2, data.getService());
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
      String sql = "DELETE FROM Shipment WHERE shipment_id=?";
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
