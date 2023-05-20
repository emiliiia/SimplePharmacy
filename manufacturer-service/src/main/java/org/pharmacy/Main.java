package org.pharmacy;

import com.google.gson.Gson;
import org.pharmacy.controller.ManufacturerController;
import org.pharmacy.model.Manufacturer;
import org.pharmacy.repository.ManufacturerRepository;
import org.pharmacy.service.ManufacturerServiceImpl;
import spark.Spark;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        // Підключення до бази даних
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/simplePhamacy", "postgres", "55fm74rml");

        Gson gson = new Gson();

        ManufacturerRepository manufacturerRepository = new ManufacturerRepository(conn);
        ManufacturerServiceImpl manufacturerService = new ManufacturerServiceImpl(manufacturerRepository);
        ManufacturerController manufacturerController = new ManufacturerController(manufacturerService, gson);
        // Налаштування маршрутів Spark
        Spark.port(8083);

        Spark.get("/manufacturer/", manufacturerController::getAllManufacturers, gson::toJson);

        Spark.get("/manufacturer/:id", manufacturerController::getManufacturerById, gson::toJson);

        // Налаштування роуту для обробки POST-запиту
        Spark.post("/manufacturer", (request, response) -> {
            // Отримання JSON-даних з тіла POST-запиту
            Manufacturer manufacturer = new Gson().fromJson(request.body(), Manufacturer.class);

            // Виклик методу createRole з використанням отриманих даних з клієнта
            manufacturerController.createManufacturer(manufacturer);

            // Повернення відповіді клієнту
            response.status(200);
            return "Manufacturer created successfully";
        });

        Spark.put("/manufacturer/:id", (request, response) -> {
            // Отримання JSON-даних з тіла POST-запиту
            Manufacturer manufacturer = new Gson().fromJson(request.body(), Manufacturer.class);

            // Виклик методу createRole з використанням отриманих даних з клієнта
            manufacturerController.updateManufacturer(request, manufacturer);

            // Повернення відповіді клієнту
            response.status(200);
            return "Manufacturer updated successfully";
        });

        Spark.delete("/manufacturer/:id", manufacturerController::deleteManufacturer, gson::toJson);
    }
}