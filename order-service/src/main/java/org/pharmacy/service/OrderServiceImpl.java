package org.pharmacy.service;
/*
  @author emilia
  @project pharmacy
  @class OrderServiceImpl
  @version 1.0.0
  @since 14.05.2023 - 14:23
*/

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.pharmacy.model.Order;
import org.pharmacy.repository.OrderRepository;

import java.sql.SQLException;
import java.util.List;

public class OrderServiceImpl implements IOrderService   {
    private static final Logger logger = LogManager.getLogger("OrderServiceImpl");
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void createOrder(Order order) throws SQLException {
        orderRepository.addOrder(order);
        logger.info("createOrder");
    }

    public Order getOrderById(int id) throws SQLException {
        logger.info("getOrderById: " + id);
        return orderRepository.getOrderById(id);
    }

    public List<Order> getAllOrders() throws SQLException {
        logger.info("getAllDrugs");
        return orderRepository.getAllOrders();
    }

    public void updateOrder(Order order) throws SQLException {
        logger.info("updateOrder with id: " + order.getId());
        orderRepository.updateOrder(order);
    }

    public void deleteOrder(int id) throws SQLException {
        logger.info("deleteOrder by id: " + id);
        orderRepository.deleteOrder(id);
    }
}
