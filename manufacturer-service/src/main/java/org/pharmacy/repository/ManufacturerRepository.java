package org.pharmacy.repository;
/*
  @author emilia
  @project pharmacy
  @class ManufacturerRepository
  @version 1.0.0
  @since 14.04.2023 - 15:45
*/

import org.pharmacy.model.Manufacturer;

import java.sql.*;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ManufacturerRepository {
    private static final String SELECT_ALL_MANUFACTURERS = "SELECT * FROM manufacturer";
    private static final String SELECT_MANUFACTURER_BY_ID = "SELECT * FROM manufacturer WHERE id = ?";
    private static final String INSERT_MANUFACTURER =
            "INSERT INTO manufacturer(manufacturer_name, country, agent_name, agent_phone_num, description) VALUES(?)";
    private static final String UPDATE_MANUFACTURER = "UPDATE manufacturer SET " +
            "manufacturer_name = ?, country = ?, agent_name = ?, agent_phone_num = ?, description = ? WHERE id = ?";
    private static final String DELETE_MANUFACTURER = "DELETE FROM manufacturer WHERE id = ?";

    private final Connection conn;

    public ManufacturerRepository(Connection conn) {
        this.conn = conn;
    }

    public List<Manufacturer> getAllManufacturers() throws SQLException {
        List<Manufacturer> manufacturers = new ArrayList<>();
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(SELECT_ALL_MANUFACTURERS);
            while (rs.next()) {
                Manufacturer manufacturer = new Manufacturer(
                        rs.getInt("id"),
                        rs.getString("manufacturer_name"),
                        rs.getString("country"),
                        rs.getString("agent_name"),
                        rs.getString("agent_phone_num"),
                        rs.getString("description"),
                        rs.getDate("created_at"),
                        rs.getDate("updated_at")
                );
                manufacturers.add(manufacturer);
            }
        }
        return manufacturers;
    }

    public Manufacturer getManufacturerById(int id) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(SELECT_MANUFACTURER_BY_ID)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Manufacturer(
                        rs.getInt("id"),
                        rs.getString("manufacturer_name"),
                        rs.getString("country"),
                        rs.getString("agent_name"),
                        rs.getString("agent_phone_num"),
                        rs.getString("description"),
                        rs.getDate("created_at"),
                        rs.getDate("updated_at")
                );
            } else {
                return null;
            }
        }
    }

    public void addManufacturer(Manufacturer manufacturer) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(INSERT_MANUFACTURER)) {
            stmt.setString(1, manufacturer.getManufacturerName());
            stmt.setString(2, manufacturer.getCountry());
            stmt.setString(3, manufacturer.getAgentName());
            stmt.setString(4, manufacturer.getAgentPhoneNum());
            stmt.setString(5, manufacturer.getDescription());
            stmt.executeUpdate();
        }
    }

    public void updateManufacturer(Manufacturer manufacturer) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(UPDATE_MANUFACTURER)) {
            stmt.setString(1, manufacturer.getManufacturerName());
            stmt.setString(2, manufacturer.getCountry());
            stmt.setString(3, manufacturer.getAgentName());
            stmt.setString(4, manufacturer.getAgentPhoneNum());
            stmt.setString(5, manufacturer.getDescription());
            stmt.setInt(6, manufacturer.getId());
            stmt.executeUpdate();
        }
    }

    public void deleteManufacturer(int id) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(DELETE_MANUFACTURER)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
