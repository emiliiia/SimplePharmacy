package org.pharmacy.service;

import org.pharmacy.model.Drug;

import java.sql.SQLException;
import java.util.List;

public interface IDrugService {
    void createDrug(Drug drug) throws SQLException;
    Drug getDrugById(int id) throws SQLException;
    List<Drug> getAllDrugs() throws SQLException;
    void updateDrug(Drug drug) throws SQLException;
    void deleteDrug(int id) throws SQLException;
}
