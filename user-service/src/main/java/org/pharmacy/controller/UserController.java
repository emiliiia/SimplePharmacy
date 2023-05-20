package org.pharmacy.controller;
/*
  @author emilia
  @project pharmacy
  @class UserController
  @version 1.0.0
  @since 15.04.2023 - 3:17
*/
import com.google.gson.Gson;
import org.pharmacy.model.User;
import org.pharmacy.service.UserServiceImpl;
import spark.Request;
import spark.Response;

import java.sql.SQLException;
import java.util.List;

public class UserController {
    private final UserServiceImpl userService;
    private final Gson gson;

    public UserController(UserServiceImpl userService, Gson gson) {
        this.userService = userService;
        this.gson = gson;
    }

    public void createUser(User user) throws SQLException {
        userService.createUser(user);
    }

    public String getUserById(Request req, Response res) throws SQLException {
        int id = Integer.parseInt(req.params(":id"));
        User user = userService.getUserById(id);
        if (user != null) {
            return gson.toJson(user);
        } else {
            res.status(404);
            return "User not found";
        }
    }

    public String getAllUsers(Request req, Response res) throws SQLException {
        List<User> users = userService.getAllUsers();
        return gson.toJson(users);
    }

    public void updateUser(Request req, User updatedUser) throws SQLException {
        int id = Integer.parseInt(req.params(":id"));
        User user = userService.getUserById(id);
        if (user != null) {
            updatedUser.setId(id);
            userService.updateUser(updatedUser);
        }
    }

    public String deleteUser(Request req, Response res) throws SQLException {
        int id = Integer.parseInt(req.params(":id"));
        User user = userService.getUserById(id);
        if (user != null) {
            userService.deleteUser(id);
            return "User deleted successfully";
        } else {
            res.status(404);
            return "User not found";
        }
    }
}
