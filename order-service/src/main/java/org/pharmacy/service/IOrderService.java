package org.pharmacy.service;

import org.pharmacy.model.Order;

import java.sql.SQLException;
import java.util.List;

public interface IOrderService {
    void createOrder(Order order) throws SQLException;
    Order getOrderById(int id) throws SQLException;
    List<Order> getAllOrders() throws SQLException;
    void updateOrder(Order order) throws SQLException;
    void deleteOrder(int id) throws SQLException;
}
