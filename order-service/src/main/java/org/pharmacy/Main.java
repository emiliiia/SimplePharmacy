package org.pharmacy;

import com.google.gson.Gson;
import org.pharmacy.controller.OrderController;
import org.pharmacy.model.Order;
import org.pharmacy.repository.OrderRepository;
import org.pharmacy.service.OrderServiceImpl;
import spark.Spark;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        // Підключення до бази даних
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/simplePhamacy", "postgres", "55fm74rml");

        Gson gson = new Gson();

        OrderRepository orderRepository = new OrderRepository(conn);
        OrderServiceImpl orderService = new OrderServiceImpl(orderRepository);
        OrderController orderController = new OrderController(orderService, gson);
        // Налаштування маршрутів Spark
        Spark.port(8080);

        Spark.get("/order/", orderController::getAllOrders, gson::toJson);

        Spark.get("/order/:id", orderController::getOrderById, gson::toJson);

        // Налаштування роуту для обробки POST-запиту
        Spark.post("/order", (request, response) -> {
            // Отримання JSON-даних з тіла POST-запиту
            Order order = new Gson().fromJson(request.body(), Order.class);

            // Виклик методу createRole з використанням отриманих даних з клієнта
            orderController.createOrder(order);

            // Повернення відповіді клієнту
            response.status(200);
            return "Order created successfully";
        });

        Spark.put("/order/:id", (request, response) -> {
            // Отримання JSON-даних з тіла POST-запиту
            Order order = new Gson().fromJson(request.body(), Order.class);

            // Виклик методу createRole з використанням отриманих даних з клієнта
            orderController.updateOrder(request, order);

            // Повернення відповіді клієнту
            response.status(200);
            return "Order updated successfully";
        });

        Spark.delete("/order/:id", orderController::deleteOrder, gson::toJson);
    }
}