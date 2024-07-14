package com.timetracker.service;

import com.timetracker.dao.UserDAO;
import com.timetracker.model.User;

public class UserService {
    private UserDAO userDAO = new UserDAO();

    public User authenticateUser(String username, String password) {
        User user = userDAO.getUserByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public void registerUser(User user) {
        userDAO.addUser(user);
    }
}
