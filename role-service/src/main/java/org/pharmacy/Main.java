package org.pharmacy;

import com.google.gson.Gson;
import org.pharmacy.controller.RoleController;
import org.pharmacy.model.Role;
import org.pharmacy.repository.RoleRepository;
import org.pharmacy.service.RoleServiceImpl;
import spark.Spark;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        // Підключення до бази даних
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/simplePhamacy", "postgres", "55fm74rml");

        Gson gson = new Gson();

        RoleRepository roleRepository = new RoleRepository(conn);
        RoleServiceImpl roleService = new RoleServiceImpl(roleRepository);
        RoleController roleController = new RoleController(roleService, gson);

        // Налаштування маршрутів Spark
        Spark.port(8082);

        Spark.get("/role/", roleController::getAllRoles, gson::toJson);

        Spark.get("/role/:id", roleController::getRoleById, gson::toJson);

        // Налаштування роуту для обробки POST-запиту
        Spark.post("/role", (request, response) -> {
            // Отримання JSON-даних з тіла POST-запиту
            Role role = new Gson().fromJson(request.body(), Role.class);

            // Виклик методу createRole з використанням отриманих даних з клієнта
            roleController.createRole(role);

            // Повернення відповіді клієнту
            response.status(200);
            return "Role created successfully";
        });

        Spark.put("/role/:id", (request, response) -> {
            // Отримання JSON-даних з тіла POST-запиту
            Role role = new Gson().fromJson(request.body(), Role.class);

            // Виклик методу createRole з використанням отриманих даних з клієнта
            roleController.updateRole(request, role);

            // Повернення відповіді клієнту
            response.status(200);
            return "Role updated successfully";
        });

        Spark.delete("/role/:id", roleController::deleteRole, gson::toJson);
    }
}