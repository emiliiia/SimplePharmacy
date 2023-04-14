package org.pharmacy.controller;
/*
  @author emilia
  @project pharmacy
  @class ManufacturerController
  @version 1.0.0
  @since 14.04.2023 - 14:56
*/

import com.google.gson.Gson;
import org.pharmacy.model.Manufacturer;
import org.pharmacy.service.ManufacturerServiceImpl;
import spark.Request;
import spark.Response;

import java.sql.SQLException;
import java.util.List;

public class ManufacturerController {
    private final ManufacturerServiceImpl manufacturerService;
    private final Gson gson;

    public ManufacturerController(ManufacturerServiceImpl manufacturerService, Gson gson) {
        this.manufacturerService = manufacturerService;
        this.gson = gson;
    }

    public void createManufacturer(Manufacturer manufacturer) throws SQLException {
        manufacturerService.createManufacturer(manufacturer);
    }

    public String getManufacturerById(Request req, Response res) throws SQLException {
        int id = Integer.parseInt(req.params(":id"));
        Manufacturer manufacturer = manufacturerService.getManufacturerById(id);
        if (manufacturer != null) {
            return gson.toJson(manufacturer);
        } else {
            res.status(404);
            return "Manufacturer not found";
        }
    }

    public String getAllManufacturers(Request req, Response res) throws SQLException {
        List<Manufacturer> manufacturers = manufacturerService.getAllManufacturers();
        return gson.toJson(manufacturers);
    }

    public void updateManufacturer(Request req, Manufacturer updatedManufacturer) throws SQLException {
        int id = Integer.parseInt(req.params(":id"));
        Manufacturer role = manufacturerService.getManufacturerById(id);
        if (role != null) {
            updatedManufacturer.setId(id);
            manufacturerService.updateManufacturer(updatedManufacturer);
        }
    }

    public String deleteManufacturer(Request req, Response res) throws SQLException {
        int id = Integer.parseInt(req.params(":id"));
        Manufacturer manufacturer = manufacturerService.getManufacturerById(id);
        if (manufacturer != null) {
            manufacturerService.deleteManufacturer(id);
            return "Manufacturer deleted successfully";
        } else {
            res.status(404);
            return "Manufacturer not found";
        }
    }
}

