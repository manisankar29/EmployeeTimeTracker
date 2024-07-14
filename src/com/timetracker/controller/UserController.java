package com.timetracker.controller;

import com.timetracker.model.User;
import com.timetracker.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user")
public class UserController extends HttpServlet {
    private UserService userService = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action.equals("login")) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            User user = userService.authenticateUser(username, password);
            if (user != null) {
                request.getSession().setAttribute("user", user);
                response.sendRedirect("viewTasks.jsp");
            } else {
                response.sendRedirect("login.jsp?error=Invalid username or password");
            }
        } else if (action.equals("register")) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String role = request.getParameter("role");
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setRole(role);
            userService.registerUser(user);
            response.sendRedirect("login.jsp?message=Registration successful");
        }
    }
}
