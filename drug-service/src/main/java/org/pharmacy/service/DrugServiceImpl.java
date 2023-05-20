package org.pharmacy.service;
/*
  @author emilia
  @project pharmacy
  @class DrugServiceImpl
  @version 1.0.0
  @since 23.04.2023 - 23:54
*/

import org.pharmacy.model.Drug;
import org.pharmacy.repository.DrugRepository;

import java.sql.SQLException;
import java.util.List;

public class DrugServiceImpl implements IDrugService{
    private final DrugRepository drugRepository;

    public DrugServiceImpl(DrugRepository drugRepository) {
        this.drugRepository = drugRepository;
    }

    public void createDrug(Drug drug) throws SQLException {
        drugRepository.addDrug(drug);
    }

    public Drug getDrugById(int id) throws SQLException {
        return drugRepository.getDrugById(id);
    }

    public List<Drug> getAllDrugs() throws SQLException {
        return drugRepository.getAllDrugs();
    }

    public void updateDrug(Drug drug) throws SQLException {
        drugRepository.updateDrug(drug);
    }

    public void deleteDrug(int id) throws SQLException {
        drugRepository.deleteDrug(id);
    }
}
