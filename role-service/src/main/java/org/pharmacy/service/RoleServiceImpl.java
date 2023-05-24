package org.pharmacy.service;
/*
  @author emilia
  @project pharmacy
  @class RoleService
  @version 1.0.0
  @since 05.04.2023 - 17:43
*/

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.pharmacy.model.Role;
import org.pharmacy.repository.RoleRepository;

import java.sql.*;
import java.util.List;

public class RoleServiceImpl implements IRoleService{
    private static final Logger logger = LogManager.getLogger("RoleServiceImpl");
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public void createRole(Role role) throws SQLException {
        roleRepository.addRole(role);
        logger.info("createRole");
    }

    public Role getRoleById(int id) throws SQLException {
        logger.info("getRoleById: " + id);
        return roleRepository.getRoleById(id);
    }

    public List<Role> getAllRoles() throws SQLException {
        logger.info("getAllRoles");
        return roleRepository.getAllRoles();
    }

    public void updateRole(Role role) throws SQLException {
        logger.info("updateRole with id: " + role.getId());
        roleRepository.updateRole(role);
    }

    public void deleteRole(int id) throws SQLException {
        logger.info("deleteRole by id: " + id);
        roleRepository.deleteRole(id);
    }
}