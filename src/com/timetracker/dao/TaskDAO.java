package com.timetracker.dao;

import com.timetracker.model.Task;
import com.timetracker.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaskDAO {
    public List<Task> getTasksByUser(String employeeName) {
        List<Task> tasks = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM Tasks WHERE employee_name = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, employeeName);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Task task = new Task();
                task.setTaskId(resultSet.getInt("task_id"));
                task.setEmployeeName(resultSet.getString("employee_name"));
                task.setRole(resultSet.getString("role"));
                task.setProject(resultSet.getString("project"));
                task.setDate(resultSet.getDate("date"));
                task.setStartTime(resultSet.getTime("start_time"));
                task.setEndTime(resultSet.getTime("end_time"));
                task.setTaskCategory(resultSet.getString("task_category"));
                task.setDescription(resultSet.getString("description"));
                task.setDuration(resultSet.getTime("duration"));
                tasks.add(task);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }

    public void addTask(Task task) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO Tasks (employee_name, role, project, date, start_time, end_time, task_category, description, duration) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, task.getEmployeeName());
            statement.setString(2, task.getRole());
            statement.setString(3, task.getProject());
            statement.setDate(4, task.getDate());
            statement.setTime(5, task.getStartTime());
            statement.setTime(6, task.getEndTime());
            statement.setString(7, task.getTaskCategory());
            statement.setString(8, task.getDescription());
            statement.setTime(9, task.getDuration());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateTask(Task task) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "UPDATE Tasks SET project = ?, date = ?, start_time = ?, end_time = ?, task_category = ?, description = ?, duration = ? WHERE task_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, task.getProject());
            statement.setDate(2, task.getDate());
            statement.setTime(3, task.getStartTime());
            statement.setTime(4, task.getEndTime());
            statement.setString(5, task.getTaskCategory());
            statement.setString(6, task.getDescription());
            statement.setTime(7, task.getDuration());
            statement.setInt(8, task.getTaskId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTask(int taskId) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "DELETE FROM Tasks WHERE task_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, taskId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
