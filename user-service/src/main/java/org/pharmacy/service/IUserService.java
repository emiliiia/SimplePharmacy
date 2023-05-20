package org.pharmacy.service;

import org.pharmacy.model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserService {
    void createUser(User user) throws SQLException;
    User getUserById(int id) throws SQLException;
    List<User> getAllUsers() throws SQLException;
    void updateUser(User user) throws SQLException;
    void deleteUser(int id) throws SQLException;
}
