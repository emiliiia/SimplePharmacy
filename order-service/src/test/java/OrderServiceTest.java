/*
  @author emilia
  @project pharmacy
  @class DrugServiceTest
  @version 1.0.0
  @since 21.05.2023 - 22:50
*/

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.pharmacy.model.Order;
import org.pharmacy.service.OrderServiceImpl;
import org.pharmacy.repository.OrderRepository;

public class OrderServiceTest {
    // Підключення до бази даних
    Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/simplePhamacy", "postgres", "55fm74rml");
    OrderRepository orderRepository = new OrderRepository(conn);

    public OrderServiceTest() throws SQLException {
    }

    @Test
    public void testCreateOrder() throws SQLException {
        Order order = new Order(1, 1, 1, 1,
                100.0, "Gone", Boolean.TRUE, new Date(1,1,2020), new Date(1,1,2020));

        Assertions.assertDoesNotThrow(() -> {
            orderRepository.addOrder(order);
        });
    }

    @Test
    public void testGetOrderById() throws SQLException {
        OrderServiceImpl orderService = new OrderServiceImpl(orderRepository);
        int id = 10;

        Assertions.assertDoesNotThrow(() -> {
            Order order = orderService.getOrderById(id);
        });
    }

    @Test
    public void testGetAllOrders() throws SQLException {
        OrderServiceImpl orderService = new OrderServiceImpl(orderRepository);

        Assertions.assertDoesNotThrow(() -> {
            List<Order> orders = orderService.getAllOrders();
        });
    }

    @Test
    public void testUpdateOrder() throws SQLException {
        OrderServiceImpl orderService = new OrderServiceImpl(orderRepository);
        Order order = new Order(1, 1, 1, 1,
                100.0, "Gone", Boolean.FALSE, new Date(1,1,2020), new Date(1,1,2020));

        Assertions.assertDoesNotThrow(() -> {
            orderService.updateOrder(order);
        });
    }

    @Test
    public void testDeleteOrder() throws SQLException {
        OrderServiceImpl orderService = new OrderServiceImpl(orderRepository);
        int id = 10;

        Assertions.assertDoesNotThrow(() -> {
            orderService.deleteOrder(id);
        });
    }
}
