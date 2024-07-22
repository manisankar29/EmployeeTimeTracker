package com.timetracker.dao;

import com.timetracker.model.User;
import com.timetracker.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    public User getUserByUsername(String username) {
        User user = null;
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM Users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setUserId(resultSet.getInt("user_id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setName(resultSet.getString("name"));
                user.setEmployeeId(resultSet.getString("employeeId"));
                user.setIdProof(resultSet.getString("idProof"));
                user.setPhoneNumber(resultSet.getString("phoneNumber"));
                user.setEmail(resultSet.getString("email"));
                user.setRole(resultSet.getString("role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void addUser(User user) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO Users (username, password, name, employeeId, idProof, phoneNumber, email, role) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getName());
            statement.setString(4, user.getEmployeeId());
            statement.setString(5, user.getIdProof());
            statement.setString(6, user.getPhoneNumber());
            statement.setString(7, user.getEmail());
            statement.setString(8, user.getRole());
            int rows = statement.executeUpdate();
            if (rows > 0) {
                System.out.println("A new user has been inserted.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
