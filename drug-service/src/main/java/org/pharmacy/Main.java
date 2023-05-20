package org.pharmacy;

import com.google.gson.Gson;
import org.pharmacy.controller.DrugController;
import org.pharmacy.model.Drug;
import org.pharmacy.repository.DrugRepository;
import org.pharmacy.service.DrugServiceImpl;
import spark.Spark;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        // Підключення до бази даних
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/simplePhamacy", "postgres", "55fm74rml");

        Gson gson = new Gson();

        DrugRepository drugRepository = new DrugRepository(conn);
        DrugServiceImpl drugService = new DrugServiceImpl(drugRepository);
        DrugController drugController = new DrugController(drugService, gson);
        // Налаштування маршрутів Spark
        Spark.port(8085);

        Spark.get("/drug/", drugController::getAllDrugs, gson::toJson);

        Spark.get("/drug/:id", drugController::getDrugById, gson::toJson);

        // Налаштування роуту для обробки POST-запиту
        Spark.post("/drug", (request, response) -> {
            // Отримання JSON-даних з тіла POST-запиту
            Drug drug = new Gson().fromJson(request.body(), Drug.class);

            // Виклик методу createRole з використанням отриманих даних з клієнта
            drugController.createDrug(drug);

            // Повернення відповіді клієнту
            response.status(200);
            return "Drug created successfully";
        });

        Spark.put("/drug/:id", (request, response) -> {
            // Отримання JSON-даних з тіла POST-запиту
            Drug drug = new Gson().fromJson(request.body(), Drug.class);

            // Виклик методу createRole з використанням отриманих даних з клієнта
            drugController.updateDrug(request, drug);

            // Повернення відповіді клієнту
            response.status(200);
            return "Drug updated successfully";
        });

        Spark.delete("/drug/:id", drugController::deleteDrug, gson::toJson);
    }
}