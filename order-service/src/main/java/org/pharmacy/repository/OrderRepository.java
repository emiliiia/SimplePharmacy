package org.pharmacy.repository;
/*
  @author emilia
  @project pharmacy
  @class OrderRepository
  @version 1.0.0
  @since 24.04.2023 - 1:22
*/

import org.pharmacy.model.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository {
    private static final String SELECT_ALL_ORDERS = "SELECT * FROM orders";
    private static final String SELECT_ORDER_BY_ID = "SELECT * FROM orders WHERE id = ?";
    private static final String INSERT_ORDER =
            "INSERT INTO orders(client_id, drug_id, drug_quantity, price, order_status, order_go) " +
                    "VALUES(?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_ORDER = "UPDATE orders SET " +
            "client_id = ?, drug_id = ?, drug_quantity = ?, price = ?, order_status = ?, order_go = ? WHERE id = ?";
    private static final String DELETE_ORDER = "DELETE FROM orders WHERE id = ?";

    private final Connection conn;

    public OrderRepository(Connection conn) {
        this.conn = conn;
    }

    public List<Order> getAllOrders() throws SQLException {
        List<Order> orders = new ArrayList<>();
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(SELECT_ALL_ORDERS);
            while (rs.next()) {
                Order order = new Order(
                        rs.getInt("id"),
                        rs.getInt("client_id"),
                        rs.getInt("drug_id"),
                        rs.getInt("drug_quantity"),
                        rs.getDouble("price"),
                        rs.getString("order_status"),
                        rs.getBoolean("order_go"),
                        rs.getDate("created_at"),
                        rs.getDate("updated_at")
                );
                orders.add(order);
            }
        }
        return orders;
    }

    public Order getOrderById(int id) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(SELECT_ORDER_BY_ID)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Order(
                        rs.getInt("id"),
                        rs.getInt("client_id"),
                        rs.getInt("drug_id"),
                        rs.getInt("drug_quantity"),
                        rs.getDouble("price"),
                        rs.getString("order_status"),
                        rs.getBoolean("order_go"),
                        rs.getDate("created_at"),
                        rs.getDate("updated_at")
                );
            } else {
                return null;
            }
        }
    }

    public void addOrder(Order order) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(INSERT_ORDER)) {
            stmt.setInt(1, order.getClientId());
            stmt.setInt(2, order.getDrugId());
            stmt.setInt(3, order.getDrugQuantity());
            stmt.setDouble(4, order.getPrice());
            stmt.setString(5, order.getOrderStatus());
            stmt.setBoolean(6, order.getOrderGo());
            stmt.executeUpdate();
        }
    }

    public void updateOrder(Order order) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(UPDATE_ORDER)) {
            stmt.setInt(1, order.getClientId());
            stmt.setInt(2, order.getDrugId());
            stmt.setInt(3, order.getDrugQuantity());
            stmt.setDouble(4, order.getPrice());
            stmt.setString(5, order.getOrderStatus());
            stmt.setBoolean(6, order.getOrderGo());
            stmt.setInt(7, order.getId());
            stmt.executeUpdate();
        }
    }

    public void deleteOrder(int id) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(DELETE_ORDER)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
