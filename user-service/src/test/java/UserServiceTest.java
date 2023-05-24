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

import org.pharmacy.model.User;
import org.pharmacy.service.UserServiceImpl;
import org.pharmacy.repository.UserRepository;

public class UserServiceTest {
    // Підключення до бази даних
    Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/simplePhamacy", "postgres", "55fm74rml");
    UserRepository userRepository = new UserRepository(conn);

    public UserServiceTest() throws SQLException {
    }

    @Test
    public void testCreateUser() throws SQLException {
        User user = new User(10, "kate", new Date(1,1,2020), "552489", "usert@chnu.edu.ua", 1,
                new Date(1,1,2020), new Date(1,1,2020));

        Assertions.assertDoesNotThrow(() -> {
            userRepository.addUser(user);
        });
    }

    @Test
    public void testGetUserById() throws SQLException {
        UserServiceImpl userService = new UserServiceImpl(userRepository);
        int id = 10;

        Assertions.assertDoesNotThrow(() -> {
            User user = userService.getUserById(id);
        });
    }

    @Test
    public void testGetAllUsers() throws SQLException {
        UserServiceImpl userService = new UserServiceImpl(userRepository);

        Assertions.assertDoesNotThrow(() -> {
            List<User> users = userService.getAllUsers();
        });
    }

    @Test
    public void testUpdateUser() throws SQLException {
        UserServiceImpl userService = new UserServiceImpl(userRepository);
        User user = new User(10, "kate", new Date(1,1,2020), "552489", "usert@chnu.edu.ua", 1,
                new Date(1,1,2020), new Date(1,1,2020));

        Assertions.assertDoesNotThrow(() -> {
            userService.updateUser(user);
        });
    }

    @Test
    public void testDeleteRole() throws SQLException {
        UserServiceImpl userService = new UserServiceImpl(userRepository);
        int id = 10;

        Assertions.assertDoesNotThrow(() -> {
            userService.deleteUser(id);
        });
    }
}
