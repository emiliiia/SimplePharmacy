package org.pharmacy.repository;

import org.pharmacy.model.Role;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoleRepository {
    private static final String SELECT_ALL_ROLES = "SELECT * FROM role";
    private static final String SELECT_ROLE_BY_ID = "SELECT * FROM role WHERE id = ?";
    private static final String INSERT_ROLE = "INSERT INTO role(roleName) VALUES(?)";
    private static final String UPDATE_ROLE = "UPDATE role SET roleName = ? WHERE id = ?";
    private static final String DELETE_ROLE = "DELETE FROM role WHERE id = ?";

    private final Connection conn;

    public RoleRepository(Connection conn) {
        this.conn = conn;
    }

    public List<Role> getAllRoles() throws SQLException {
        List<Role> roles = new ArrayList<>();
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(SELECT_ALL_ROLES);
            while (rs.next()) {
                Role role = new Role(
                        rs.getInt("id"),
                        rs.getString("roleName")
                );
                roles.add(role);
            }
        }
        return roles;
    }

    public Role getRoleById(int id) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(SELECT_ROLE_BY_ID)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Role(
                        rs.getInt("id"),
                        rs.getString("roleName")
                );
            } else {
                return null;
            }
        }
    }

    public void addRole(Role role) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(INSERT_ROLE)) {
            stmt.setString(1, role.getRoleName());
            stmt.executeUpdate();
        }
    }

    public void updateRole(Role role) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(UPDATE_ROLE)) {
            stmt.setString(1, role.getRoleName());
            stmt.setInt(2, role.getId());
            stmt.executeUpdate();
        }
    }

    public void deleteRole(int id) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(DELETE_ROLE)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
