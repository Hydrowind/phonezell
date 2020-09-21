package com.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dao.DAO;
import com.dao.conn.MySQLConnection;
import com.entity.Address;
import com.entity.Invoice;
import com.entity.OrderCart;
import com.entity.Payment;
import com.entity.Shipment;

public class InvoiceDAO implements DAO<Invoice> {
  AddressDAO addressdao = new AddressDAO();
  PaymentDAO paymentdao = new PaymentDAO();
  ShipmentDAO shipmentdao = new ShipmentDAO();
  OrderCartDAO cartdao = new OrderCartDAO();

  public InvoiceDAO() {
  }

  @Override
  public boolean create(Invoice data) {
    try {
      String sql = "INSERT INTO Invoice (`transaction_no`, `status`, `address_id`, `payment_id`, `shipment_id`, `cart_id`) VALUES (?,?,?,?,?,?)";
      PreparedStatement pst = MySQLConnection.getConnection().prepareStatement(sql);
      pst.setString(1, data.getTransactionNo());
      pst.setString(2, data.getStatus());
      pst.setString(3, String.valueOf(data.getAddress().getAddressID()));
      pst.setString(4, String.valueOf(data.getPayment().getPaymentID()));
      pst.setString(5, String.valueOf(data.getShipment().getShipmentID()));
      pst.setString(6, String.valueOf(data.getCart().getCartID()));

      pst.executeUpdate();
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  @Override
  public List<Invoice> getAll() {
    List<Invoice> invoices = new ArrayList<>();
    Invoice invoice = null;
    Address address = null;
    Payment payment = null;
    Shipment shipment = null;
    OrderCart cart = null;

    try {
      String sql = "SELECT * FROM Invoice";
      PreparedStatement pst = MySQLConnection.getConnection().prepareStatement(sql);
      ResultSet rs = pst.executeQuery();

      while (rs.next()) {
        invoice = new Invoice();
        invoice.setInvoiceID(rs.getInt("invoice_id"));
        invoice.setTransactionNo(rs.getString("transaction_no"));

        address = new Address();
        address = addressdao.find(rs.getInt("address_id"));
        invoice.setAddress(address);

        payment = new Payment();
        payment = paymentdao.find(rs.getInt("payment_id"));
        invoice.setPayment(payment);

        shipment = new Shipment();
        shipment = shipmentdao.find(rs.getInt("shipment_id"));
        invoice.setShipment(shipment);

        cart = new OrderCart();
        cart = cartdao.find(rs.getInt("cart_id"));
        invoice.setCart(cart);

        invoices.add(invoice);
      }

      return invoices;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public Invoice find(int id) {
    Invoice invoice = null;
    Address address = null;
    Payment payment = null;
    Shipment shipment = null;
    OrderCart cart = null;

    try {
      String sql = "SELECT * FROM Invoice WHERE invoice_id = ?";
      PreparedStatement pst = MySQLConnection.getConnection().prepareStatement(sql);
      pst.setString(1, String.valueOf(id));

      ResultSet rs = pst.executeQuery();

      while (rs.next()) {
        invoice = new Invoice();
        invoice.setInvoiceID(rs.getInt("invoice_id"));
        invoice.setTransactionNo(rs.getString("transaction_no"));

        address = new Address();
        address = addressdao.find(rs.getInt("address_id"));
        invoice.setAddress(address);

        payment = new Payment();
        payment = paymentdao.find(rs.getInt("payment_id"));
        invoice.setPayment(payment);

        shipment = new Shipment();
        shipment = shipmentdao.find(rs.getInt("shipment_id"));
        invoice.setShipment(shipment);

        cart = new OrderCart();
        cart = cartdao.find(rs.getInt("cart_id"));
        invoice.setCart(cart);
      }

      return invoice;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public List<Invoice> getAllWhere(String query) {
    List<Invoice> invoices = new ArrayList<>();
    Invoice invoice = null;
    Address address = null;
    Payment payment = null;
    Shipment shipment = null;
    OrderCart cart = null;

    try {
      String sql = "SELECT * FROM Invoice WHERE ?";
      PreparedStatement pst = MySQLConnection.getConnection().prepareStatement(sql);
      pst.setString(1, query);
      ResultSet rs = pst.executeQuery();

      while (rs.next()) {
        invoice = new Invoice();
        invoice.setInvoiceID(rs.getInt("invoice_id"));
        invoice.setTransactionNo(rs.getString("transaction_no"));

        address = new Address();
        address = addressdao.find(rs.getInt("address_id"));
        invoice.setAddress(address);

        payment = new Payment();
        payment = paymentdao.find(rs.getInt("payment_id"));
        invoice.setPayment(payment);

        shipment = new Shipment();
        shipment = shipmentdao.find(rs.getInt("shipment_id"));
        invoice.setShipment(shipment);

        cart = new OrderCart();
        cart = cartdao.find(rs.getInt("cart_id"));
        invoice.setCart(cart);

        invoices.add(invoice);
      }

      return invoices;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public boolean update(int id, Invoice data) {
    try {
      String sql = "UPDATE Invoice SET transaction_no=?, status=?, address_id=?, payment_id=?, shipment_id=?, cart_id=? WHERE invoice_id=?";
      PreparedStatement pst = MySQLConnection.getConnection().prepareStatement(sql);
      pst.setString(1, data.getTransactionNo());
      pst.setString(2, data.getStatus());
      pst.setString(3, String.valueOf(data.getAddress().getAddressID()));
      pst.setString(4, String.valueOf(data.getPayment().getPaymentID()));
      pst.setString(5, String.valueOf(data.getShipment().getShipmentID()));
      pst.setString(6, String.valueOf(data.getCart().getCartID()));
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
      String sql = "DELETE FROM Invoice WHERE invoice_id=?";
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
