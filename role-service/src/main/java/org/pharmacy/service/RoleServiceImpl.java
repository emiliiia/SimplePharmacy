package org.pharmacy.service;
/*
  @author emilia
  @project pharmacy
  @class RoleService
  @version 1.0.0
  @since 05.04.2023 - 17:43
*/

import org.pharmacy.model.Role;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoleServiceImpl implements IRoleService{
    private final Connection conn;

    public RoleServiceImpl(Connection conn) {
        this.conn = conn;
    }

    public void createRole(Role role) throws SQLException {
        String sql = "INSERT INTO role(roleName) VALUES(?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, role.getRoleName());
        statement.executeUpdate();
    }

    public Role getRoleById(int id) throws SQLException {
        String sql = "SELECT * FROM role WHERE id=?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            String roleName = rs.getString("roleName");
            return new Role(id, roleName);
        }
        return null;
    }

    public List<Role> getAllRoles() throws SQLException {
        String sql = "SELECT * FROM role";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        List<Role> role = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String roleName = rs.getString("roleName");
            role.add(new Role(id, roleName));
        }
        return role;
    }

    public void updateRole(Role role) throws SQLException {
        String sql = "UPDATE role SET roleName=? WHERE id=?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, role.getRoleName());
        statement.setInt(2, role.getId());
        statement.executeUpdate();
    }

    public void deleteRole(int id) throws SQLException {
        String sql = "DELETE FROM role WHERE id=?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, id);
        statement.executeUpdate();
    }
}