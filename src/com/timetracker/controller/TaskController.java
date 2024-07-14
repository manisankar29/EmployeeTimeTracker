package com.timetracker.controller;

import com.timetracker.model.Task;
import com.timetracker.model.User;
import com.timetracker.service.TaskService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

@WebServlet("/task")
public class TaskController extends HttpServlet {
    private TaskService taskService = new TaskService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action.equals("add")) {
            String employeeName = request.getParameter("employeeName");
            String role = request.getParameter("role");
            String project = request.getParameter("project");
            Date date = Date.valueOf(request.getParameter("date"));
            Time startTime = Time.valueOf(request.getParameter("startTime") + ":00");
            Time endTime = Time.valueOf(request.getParameter("endTime") + ":00");
            String taskCategory = request.getParameter("taskCategory");
            String description = request.getParameter("description");
            Time duration = Time.valueOf(request.getParameter("duration") + ":00");

            Task task = new Task();
            task.setEmployeeName(employeeName);
            task.setRole(role);
            task.setProject(project);
            task.setDate(date);
            task.setStartTime(startTime);
            task.setEndTime(endTime);
            task.setTaskCategory(taskCategory);
            task.setDescription(description);
            task.setDuration(duration);

            taskService.addTask(task);
            response.sendRedirect("viewTasks.jsp");
        } else if (action.equals("update")) {
            int taskId = Integer.parseInt(request.getParameter("taskId"));
            String project = request.getParameter("project");
            Date date = Date.valueOf(request.getParameter("date"));
            Time startTime = Time.valueOf(request.getParameter("startTime") + ":00");
            Time endTime = Time.valueOf(request.getParameter("endTime") + ":00");
            String taskCategory = request.getParameter("taskCategory");
            String description = request.getParameter("description");
            Time duration = Time.valueOf(request.getParameter("duration") + ":00");

            Task task = new Task();
            task.setTaskId(taskId);
            task.setProject(project);
            task.setDate(date);
            task.setStartTime(startTime);
            task.setEndTime(endTime);
            task.setTaskCategory(taskCategory);
            task.setDescription(description);
            task.setDuration(duration);

            taskService.updateTask(task);
            response.sendRedirect("viewTasks.jsp");
        } else if (action.equals("delete")) {
            int taskId = Integer.parseInt(request.getParameter("taskId"));
            taskService.deleteTask(taskId);
            response.sendRedirect("viewTasks.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            List<Task> tasks = taskService.getTasksByUser(user.getUsername());
            request.setAttribute("tasks", tasks);
            request.getRequestDispatcher("viewTasks.jsp").forward(request, response);
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}
