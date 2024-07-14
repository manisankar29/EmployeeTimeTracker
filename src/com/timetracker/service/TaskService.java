package com.timetracker.service;

import com.timetracker.dao.TaskDAO;
import com.timetracker.model.Task;

import java.util.List;

public class TaskService {
    private TaskDAO taskDAO = new TaskDAO();

    public List<Task> getTasksByUser(String employeeName) {
        return taskDAO.getTasksByUser(employeeName);
    }

    public void addTask(Task task) {
        taskDAO.addTask(task);
    }

    public void updateTask(Task task) {
        taskDAO.updateTask(task);
    }

    public void deleteTask(int taskId) {
        taskDAO.deleteTask(taskId);
    }
}
