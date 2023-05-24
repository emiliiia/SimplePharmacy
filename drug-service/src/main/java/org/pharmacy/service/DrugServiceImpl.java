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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DrugServiceImpl implements IDrugService{
    private static final Logger logger = LogManager.getLogger("DrugServiceImpl");
    private final DrugRepository drugRepository;

    public DrugServiceImpl(DrugRepository drugRepository) {
        this.drugRepository = drugRepository;
    }

    public void createDrug(Drug drug) throws SQLException {
        drugRepository.addDrug(drug);
        logger.info("createDrug");
    }

    public Drug getDrugById(int id) throws SQLException {
        logger.info("getDrugById: " + id);
        return drugRepository.getDrugById(id);
    }

    public List<Drug> getAllDrugs() throws SQLException {
        logger.info("getAllDrugs");
        return drugRepository.getAllDrugs();
    }

    public void updateDrug(Drug drug) throws SQLException {
        logger.info("updateDrug with id: " + drug.getId());
        drugRepository.updateDrug(drug);
    }

    public void deleteDrug(int id) throws SQLException {
        logger.info("deleteDrug by id: " + id);
        drugRepository.deleteDrug(id);
    }
}
