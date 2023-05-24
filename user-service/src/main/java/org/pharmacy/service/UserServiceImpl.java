package org.pharmacy.service;
/*
  @author emilia
  @project pharmacy
  @class UserServiceImpl
  @version 1.0.0
  @since 23.04.2023 - 20:23
*/

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.pharmacy.model.User;
import org.pharmacy.repository.UserRepository;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements IUserService{
    private static final Logger logger = LogManager.getLogger("UserServiceImpl");
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User user) throws SQLException {
        userRepository.addUser(user);
        logger.info("createUser");
    }

    public User getUserById(int id) throws SQLException {
        logger.info("getUserById: " + id);
        return userRepository.getUserById(id);
    }

    public List<User> getAllUsers() throws SQLException {
        logger.info("getAllUsers");
        return userRepository.getAllUsers();
    }

    public void updateUser(User user) throws SQLException {
        logger.info("updateUser with id: " + user.getId());
        userRepository.updateUser(user);
    }

    public void deleteUser(int id) throws SQLException {
        logger.info("deleteUser by id: " + id);
        userRepository.deleteUser(id);
    }
}
