package org.pharmacy.repository;
/*
  @author emilia
  @project pharmacy
  @class DrugRepository
  @version 1.0.0
  @since 23.04.2023 - 23:29
*/

import org.pharmacy.model.Drug;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DrugRepository {
    private static final String SELECT_ALL_DRUGS = "SELECT * FROM drug";
    private static final String SELECT_DRUG_BY_ID = "SELECT * FROM drug WHERE id = ?";
    private static final String INSERT_DRUG =
            "INSERT INTO drug(drug_name, expiration_date, volume, price, in_stock, manufacturer_id, description) " +
                    "VALUES(?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_DRUG = "UPDATE drug SET " +
            "drug_name = ?, expiration_date = ?, volume = ?, price = ?, in_stock = ?, manufacturer_id = ?, description = ? WHERE id = ?";
    private static final String DELETE_DRUG = "DELETE FROM drug WHERE id = ?";

    private final Connection conn;

    public DrugRepository(Connection conn) {
        this.conn = conn;
    }

    public List<Drug> getAllDrugs() throws SQLException {
        List<Drug> drugs = new ArrayList<>();
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(SELECT_ALL_DRUGS);
            while (rs.next()) {
                Drug drug = new Drug(
                        rs.getInt("id"),
                        rs.getString("drug_name"),
                        rs.getDate("expiration_date"),
                        rs.getDouble("volume"),
                        rs.getDouble("price"),
                        rs.getInt("in_stock"),
                        rs.getInt("manufacturer_id"),
                        rs.getString("description"),
                        rs.getDate("created_at"),
                        rs.getDate("updated_at")
                );
                drugs.add(drug);
            }
        }
        return drugs;
    }

    public Drug getDrugById(int id) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(SELECT_DRUG_BY_ID)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Drug(
                        rs.getInt("id"),
                        rs.getString("drug_name"),
                        rs.getDate("expiration_date"),
                        rs.getDouble("volume"),
                        rs.getDouble("price"),
                        rs.getInt("in_stock"),
                        rs.getInt("manufacturer_id"),
                        rs.getString("description"),
                        rs.getDate("created_at"),
                        rs.getDate("updated_at")
                );
            } else {
                return null;
            }
        }
    }

    public void addDrug(Drug drug) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(INSERT_DRUG)) {
            stmt.setString(1, drug.getDrugName());
            stmt.setDate(2, drug.getExpirationDate());
            stmt.setDouble(3, drug.getVolume());
            stmt.setDouble(4, drug.getPrice());
            stmt.setInt(5, drug.getInStock());
            stmt.setInt(6, drug.getManufacturerId());
            stmt.setString(7, drug.getDescription());
            stmt.executeUpdate();
        }
    }

    public void updateDrug(Drug drug) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(UPDATE_DRUG)) {
            stmt.setString(1, drug.getDrugName());
            stmt.setDate(2, drug.getExpirationDate());
            stmt.setDouble(3, drug.getVolume());
            stmt.setDouble(4, drug.getPrice());
            stmt.setInt(5, drug.getInStock());
            stmt.setInt(6, drug.getManufacturerId());
            stmt.setString(7, drug.getDescription());
            stmt.setInt(8, drug.getId());
            stmt.executeUpdate();
        }
    }

    public void deleteDrug(int id) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(DELETE_DRUG)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
