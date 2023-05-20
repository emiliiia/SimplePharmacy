package org.pharmacy.controller;
/*
  @author emilia
  @project pharmacy
  @class OrderController
  @version 1.0.0
  @since 14.05.2023 - 14:23
*/

import com.google.gson.Gson;
import org.pharmacy.model.Order;
import org.pharmacy.service.OrderServiceImpl;
import spark.Request;
import spark.Response;

import java.sql.SQLException;
import java.util.List;

public class OrderController {
    private final OrderServiceImpl orderService;
    private final Gson gson;

    public OrderController(OrderServiceImpl orderService, Gson gson) {
        this.orderService = orderService;
        this.gson = gson;
    }

    public void createOrder(Order order) throws SQLException {
        orderService.createOrder(order);
    }

    public String getOrderById(Request req, Response res) throws SQLException {
        int id = Integer.parseInt(req.params(":id"));
        Order order = orderService.getOrderById(id);
        if (order != null) {
            return gson.toJson(order);
        } else {
            res.status(404);
            return "Order not found";
        }
    }

    public String getAllOrders(Request req, Response res) throws SQLException {
        List<Order> orders = orderService.getAllOrders();
        return gson.toJson(orders);
    }

    public void updateOrder(Request req, Order updatedOrder) throws SQLException {
        int id = Integer.parseInt(req.params(":id"));
        Order order = orderService.getOrderById(id);
        if (order != null) {
            updatedOrder.setId(id);
            orderService.updateOrder(updatedOrder);
        }
    }

    public String deleteOrder(Request req, Response res) throws SQLException {
        int id = Integer.parseInt(req.params(":id"));
        Order order = orderService.getOrderById(id);
        if (order != null) {
            orderService.deleteOrder(id);
            return "Order deleted successfully";
        } else {
            res.status(404);
            return "Order not found";
        }
    }
}
