package org.pharmacy.controller;
/*
  @author emilia
  @project pharmacy
  @class DrugController
  @version 1.0.0
  @since 23.04.2023 - 23:53
*/

import com.google.gson.Gson;
import org.pharmacy.model.Drug;
import org.pharmacy.service.DrugServiceImpl;
import spark.Request;
import spark.Response;

import java.sql.SQLException;
import java.util.List;

public class DrugController {
    private final DrugServiceImpl drugService;
    private final Gson gson;

    public DrugController(DrugServiceImpl drugService, Gson gson) {
        this.drugService = drugService;
        this.gson = gson;
    }

    public void createDrug(Drug drug) throws SQLException {
        drugService.createDrug(drug);
    }

    public String getDrugById(Request req, Response res) throws SQLException {
        int id = Integer.parseInt(req.params(":id"));
        Drug drug = drugService.getDrugById(id);
        if (drug != null) {
            return gson.toJson(drug);
        } else {
            res.status(404);
            return "Drug not found";
        }
    }

    public String getAllDrugs(Request req, Response res) throws SQLException {
        List<Drug> drugs = drugService.getAllDrugs();
        return gson.toJson(drugs);
    }

    public void updateDrug(Request req, Drug updatedDrug) throws SQLException {
        int id = Integer.parseInt(req.params(":id"));
        Drug drug = drugService.getDrugById(id);
        if (drug != null) {
            updatedDrug.setId(id);
            drugService.updateDrug(updatedDrug);
        }
    }

    public String deleteDrug(Request req, Response res) throws SQLException {
        int id = Integer.parseInt(req.params(":id"));
        Drug drug = drugService.getDrugById(id);
        if (drug != null) {
            drugService.deleteDrug(id);
            return "Drug deleted successfully";
        } else {
            res.status(404);
            return "Drug not found";
        }
    }
}
