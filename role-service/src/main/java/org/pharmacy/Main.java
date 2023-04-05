package org.pharmacy;

import com.google.gson.Gson;
import org.pharmacy.controller.RoleController;
import org.pharmacy.service.RoleServiceImpl;
import spark.Spark;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        // Підключення до бази даних
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/simplePhamacy", "postgres", "55fm74rml");
        RoleServiceImpl roleService = new RoleServiceImpl(conn);
        Gson gson = new Gson();
        RoleController roleController = new RoleController(roleService, gson);

        // Налаштування маршрутів Spark
        Spark.port(8080);

        Spark.get("/role/", roleController::getAllRoles, gson::toJson);

        Spark.get("/role/:id", roleController::getRoleById, gson::toJson);

        Spark.post("/role", roleController::createRole, gson::toJson);

        Spark.put("/role/:id", roleController::updateRole, gson::toJson);

        Spark.delete("/role/:id", roleController::deleteRole, gson::toJson);
    }
}