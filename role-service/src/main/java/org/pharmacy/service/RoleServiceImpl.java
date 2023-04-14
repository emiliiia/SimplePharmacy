package org.pharmacy.service;
/*
  @author emilia
  @project pharmacy
  @class RoleService
  @version 1.0.0
  @since 05.04.2023 - 17:43
*/

import org.pharmacy.model.Role;
import org.pharmacy.repository.RoleRepository;

import java.sql.*;
import java.util.List;

public class RoleServiceImpl implements IRoleService{
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public void createRole(Role role) throws SQLException {
        roleRepository.addRole(role);
    }

    public Role getRoleById(int id) throws SQLException {
        return roleRepository.getRoleById(id);
    }

    public List<Role> getAllRoles() throws SQLException {
        return roleRepository.getAllRoles();
    }

    public void updateRole(Role role) throws SQLException {
        roleRepository.updateRole(role);
    }

    public void deleteRole(int id) throws SQLException {
        roleRepository.deleteRole(id);
    }
}