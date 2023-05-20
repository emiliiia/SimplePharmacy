package org.pharmacy.service;
/*
  @author emilia
  @project pharmacy
  @class OrderServiceImpl
  @version 1.0.0
  @since 14.05.2023 - 14:23
*/

import org.pharmacy.model.Order;
import org.pharmacy.repository.OrderRepository;

import java.sql.SQLException;
import java.util.List;

public class OrderServiceImpl implements IOrderService   {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void createOrder(Order order) throws SQLException {
        orderRepository.addOrder(order);
    }

    public Order getOrderById(int id) throws SQLException {
        return orderRepository.getOrderById(id);
    }

    public List<Order> getAllOrders() throws SQLException {
        return orderRepository.getAllOrders();
    }

    public void updateOrder(Order order) throws SQLException {
        orderRepository.updateOrder(order);
    }

    public void deleteOrder(int id) throws SQLException {
        orderRepository.deleteOrder(id);
    }
}
