<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add Task</title>
</head>
<body>
<h2>Add Task</h2>



<form action="task" method="post">
    <input type="hidden" name="action" value="add"/>
    <label for="employeeName">Employee Name:</label>
    <input type="text" id="employeeName" name="employeeName" required/><br/>
    <label for="role">Role:</label>
    <input type="text" id="role" name="role" required/><br/>
    <label for="project">Project:</label>
    <input type="text" id="project" name="project" required/><br/>
    <label for="date">Date:</label>
    <input type="date" id="date" name="date" required/><br/>
    <label for="startTime">Start Time:</label>
    <input type="time" id="startTime" name="startTime" required/><br/>
    <label for="endTime">End Time:</label>
    <input type="time" id="endTime" name="endTime" required/><br/>
    <label for="taskCategory">Task Category:</label>
    <input type="text" id="taskCategory" name="taskCategory" required/><br/>
    <label for="description">Description:</label>
    <textarea id="description" name="description" required></textarea><br/>
    <label for="duration">Duration (HH:MM):</label>
    <input type="text" id="duration" name="duration" required pattern="([0-1][0-9]|2[0-3]):[0-5][0-9]"/><br/>
    <input type="submit" value="Add Task"/>
</form>
<a href="viewTasks.jsp">View Tasks</a>
</body>
</html>
