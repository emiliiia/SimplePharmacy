package org.pharmacy.controller;
/*
  @author emilia
  @project pharmacy
  @class RoleController
  @version 1.0.0
  @since 05.04.2023 - 17:44
*/


import com.google.gson.Gson;
import org.pharmacy.model.Role;
import org.pharmacy.service.RoleServiceImpl;
import spark.Request;
import spark.Response;
import java.sql.SQLException;
import java.util.List;

public class RoleController {
    private final RoleServiceImpl roleService;
    private final Gson gson;

    public RoleController(RoleServiceImpl roleService, Gson gson) {
        this.roleService = roleService;
        this.gson = gson;
    }

    public String createRole(Request req, Response res) throws SQLException {
        String name = req.queryParams("roleName");
        Role role = new Role(name);
        roleService.createRole(role);
        res.status(201);
        return "Role created successfully";
    }

    public String getRoleById(Request req, Response res) throws SQLException {
        int id = Integer.parseInt(req.params(":id"));
        Role role = roleService.getRoleById(id);
        if (role != null) {
            return gson.toJson(role);
        } else {
            res.status(404);
            return "Role not found";
        }
    }

    public String getAllRoles(Request req, Response res) throws SQLException {
        List<Role> roles = roleService.getAllRoles();
        return gson.toJson(roles);
    }

    public String updateRole(Request req, Response res) throws SQLException {
        int id = Integer.parseInt(req.params(":id"));
        Role role = roleService.getRoleById(id);
        if (role != null) {
            String name = req.queryParams("roleName");
            role.setRoleName(name);
            roleService.updateRole(role);
            return "Role updated successfully";
        } else {
            res.status(404);
            return "Role not found";
        }
    }

    public String deleteRole(Request req, Response res) throws SQLException {
        int id = Integer.parseInt(req.params(":id"));
        Role role = roleService.getRoleById(id);
        if (role != null) {
            roleService.deleteRole(id);
            return "Role deleted successfully";
        } else {
            res.status(404);
            return "Role not found";
        }
    }
}
