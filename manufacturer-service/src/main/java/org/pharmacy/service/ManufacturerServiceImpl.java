package org.pharmacy.service;
/*
  @author emilia
  @project pharmacy
  @class ManufacturerServiceImpl
  @version 1.0.0
  @since 14.04.2023 - 15:45
*/

import org.pharmacy.model.Manufacturer;
import org.pharmacy.repository.ManufacturerRepository;
import java.sql.SQLException;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class ManufacturerServiceImpl implements IManufacturerService {
    private static final Logger logger = LogManager.getLogger("ManufacturerServiceImpl");
    private final ManufacturerRepository manufacturerRepository;

    public ManufacturerServiceImpl(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    public void createManufacturer(Manufacturer manufacturer) throws SQLException {
        manufacturerRepository.addManufacturer(manufacturer);
    }

    public Manufacturer getManufacturerById(int id) throws SQLException {
        logger.info("getManufacturerById: " + id);
        return manufacturerRepository.getManufacturerById(id);
    }

    public List<Manufacturer> getAllManufacturers() throws SQLException {
        logger.info("getAllManufacturers");
        return manufacturerRepository.getAllManufacturers();
    }

    public void updateManufacturer(Manufacturer manufacturer) throws SQLException {
        logger.info("updateManufacturer with id: " + manufacturer.getId());
        manufacturerRepository.updateManufacturer(manufacturer);
    }

    public void deleteManufacturer(int id) throws SQLException {
        logger.info("deleteManufacturer by id: " + id);
        manufacturerRepository.deleteManufacturer(id);
    }
}