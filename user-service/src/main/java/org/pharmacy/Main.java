package org.pharmacy;

import com.google.gson.Gson;
import org.pharmacy.controller.UserController;
import org.pharmacy.model.User;
import org.pharmacy.repository.UserRepository;
import org.pharmacy.service.UserServiceImpl;
import spark.Spark;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        // Підключення до бази даних
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/simplePhamacy", "postgres", "");

        Gson gson = new Gson();

        UserRepository userRepository = new UserRepository(conn);
        UserServiceImpl userService = new UserServiceImpl(userRepository);
        UserController userController = new UserController(userService, gson);
        // Налаштування маршрутів Spark
        Spark.port(8087);

        Spark.get("/user/", userController::getAllUsers, gson::toJson);

        Spark.get("/user/:id", userController::getUserById, gson::toJson);

        // Налаштування роуту для обробки POST-запиту
        Spark.post("/user", (request, response) -> {
            // Отримання JSON-даних з тіла POST-запиту
            User user = new Gson().fromJson(request.body(), User.class);

            // Виклик методу createRole з використанням отриманих даних з клієнта
            userController.createUser(user);

            // Повернення відповіді клієнту
            response.status(200);
            return "User created successfully";
        });

        Spark.put("/user/:id", (request, response) -> {
            // Отримання JSON-даних з тіла POST-запиту
            User user = new Gson().fromJson(request.body(), User.class);

            // Виклик методу createRole з використанням отриманих даних з клієнта
            userController.updateUser(request, user);

            // Повернення відповіді клієнту
            response.status(200);
            return "User updated successfully";
        });

        Spark.delete("/user/:id", userController::deleteUser, gson::toJson);
    }
}