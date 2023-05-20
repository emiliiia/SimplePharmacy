package org.pharmacy.repository;
/*
  @author emilia
  @project pharmacy
  @class UserRepository
  @version 1.0.0
  @since 15.04.2023 - 3:17
*/

import org.pharmacy.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private static final String SELECT_ALL_USERS = "SELECT * FROM users";
    private static final String SELECT_USER_BY_ID = "SELECT * FROM users WHERE id = ?";
    private static final String INSERT_USER =
            "INSERT INTO users(user_name, user_date_birth, user_phone_num, user_email, role_id) VALUES(?, ?, ?, ?, ?)";
    private static final String UPDATE_USER = "UPDATE users SET " +
            "user_name = ?, user_date_birth = ?, user_phone_num = ?, user_email = ?, role_id = ? WHERE id = ?";
    private static final String DELETE_USER = "DELETE FROM users WHERE id = ?";

    private final Connection conn;

    public UserRepository(Connection conn) {
        this.conn = conn;
    }

    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(SELECT_ALL_USERS);
            while (rs.next()) {
                User user = new User(
                        rs.getInt("id"),
                        rs.getString("user_name"),
                        rs.getDate("user_date_birth"),
                        rs.getString("user_phone_num"),
                        rs.getString("user_email"),
                        rs.getInt("role_id"),
                        rs.getDate("created_at"),
                        rs.getDate("updated_at")
                );
                users.add(user);
            }
        }
        return users;
    }

    public User getUserById(int id) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(SELECT_USER_BY_ID)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getInt("id"),
                        rs.getString("user_name"),
                        rs.getDate("user_date_birth"),
                        rs.getString("user_phone_num"),
                        rs.getString("user_email"),
                        rs.getInt("role_id"),
                        rs.getDate("created_at"),
                        rs.getDate("updated_at")
                );
            } else {
                return null;
            }
        }
    }

    public void addUser(User user) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(INSERT_USER)) {
            stmt.setString(1, user.getUserName());
            stmt.setDate(2, user.getUserDateBirth());
            stmt.setString(3, user.getUserPhoneNum());
            stmt.setString(4, user.getUserEmail());
            stmt.setInt(5, user.getRoleId());
            stmt.executeUpdate();
        }
    }

    public void updateUser(User user) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(UPDATE_USER)) {
            stmt.setString(1, user.getUserName());
            stmt.setDate(2, user.getUserDateBirth());
            stmt.setString(3, user.getUserPhoneNum());
            stmt.setString(4, user.getUserEmail());
            stmt.setInt(5, user.getRoleId());
            stmt.setInt(6, user.getId());
            stmt.executeUpdate();
        }
    }

    public void deleteUser(int id) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(DELETE_USER)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
