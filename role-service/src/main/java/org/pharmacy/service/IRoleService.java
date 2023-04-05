package org.pharmacy.service;

import org.pharmacy.model.Role;

import java.sql.SQLException;
import java.util.List;

public interface IRoleService {
    void createRole(Role role) throws SQLException;
    Role getRoleById(int id) throws SQLException;
    List<Role> getAllRoles() throws SQLException;
    void updateRole(Role role) throws SQLException;
    void deleteRole(int id) throws SQLException;
}
