package org.pharmacy.service;

import org.pharmacy.model.Manufacturer;

import java.sql.SQLException;
import java.util.List;

public interface IManufacturerService {
    void createManufacturer(Manufacturer manufacturer) throws SQLException;
    Manufacturer getManufacturerById(int id) throws SQLException;
    List<Manufacturer> getAllManufacturers() throws SQLException;
    void updateManufacturer(Manufacturer manufacturer) throws SQLException;
    void deleteManufacturer(int id) throws SQLException;
}
