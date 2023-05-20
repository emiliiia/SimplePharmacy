package org.pharmacy.service;
/*
  @author emilia
  @project pharmacy
  @class UserServiceImpl
  @version 1.0.0
  @since 23.04.2023 - 20:23
*/

import org.pharmacy.model.User;
import org.pharmacy.repository.UserRepository;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements IUserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User user) throws SQLException {
        userRepository.addUser(user);
    }

    public User getUserById(int id) throws SQLException {
        return userRepository.getUserById(id);
    }

    public List<User> getAllUsers() throws SQLException {
        return userRepository.getAllUsers();
    }

    public void updateUser(User user) throws SQLException {
        userRepository.updateUser(user);
    }

    public void deleteUser(int id) throws SQLException {
        userRepository.deleteUser(id);
    }
}
