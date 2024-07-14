<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Reports</title>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
<body>
<h2>Reports</h2>
<h3>Daily Tasks</h3>
<canvas id="dailyTasksChart"></canvas>
<h3>Weekly Tasks</h3>
<canvas id="weeklyTasksChart"></canvas>
<h3>Monthly Tasks</h3>
<canvas id="monthlyTasksChart"></canvas>
<script>
    const dailyTasksCtx = document.getElementById('dailyTasksChart').getContext('2d');
    const weeklyTasksCtx = document.getElementById('weeklyTasksChart').getContext('2d');
    const monthlyTasksCtx = document.getElementById('monthlyTasksChart').getContext('2d');

    const dailyTasksChart = new Chart(dailyTasksCtx, {
        type: 'pie',
        data: {
            labels: [<c:forEach var="label" items="${dailyLabels}"> '${label}', </c:forEach>],
            datasets: [{
                label: 'Daily Tasks',
                data: [<c:forEach var="data" items="${dailyData}"> ${data}, </c:forEach>],
                backgroundColor: [<c:forEach var="color" items="${colors}"> '${color}', </c:forEach>],
            }]
        }
    });

    const weeklyTasksChart = new Chart(weeklyTasksCtx, {
        type: 'bar',
        data: {
            labels: [<c:forEach var="label" items="${weeklyLabels}"> '${label}', </c:forEach>],
            datasets: [{
                label: 'Weekly Tasks',
                data: [<c:forEach var="data" items="${weeklyData}"> ${data}, </c:forEach>],
                backgroundColor: [<c:forEach var="color" items="${colors}"> '${color}', </c:forEach>],
            }]
        }
    });

    const monthlyTasksChart = new Chart(monthlyTasksCtx, {
        type: 'bar',
        data: {
            labels: [<c:forEach var="label" items="${monthlyLabels}"> '${label}', </c:forEach>],
            datasets: [{
                label: 'Monthly Tasks',
                data: [<c:forEach var="data" items="${monthlyData}"> ${data}, </c:forEach>],
                backgroundColor: [<c:forEach var="color" items="${colors}"> '${color}', </c:forEach>],
            }]
        }
    });
</script>
<a href="viewTasks.jsp">View Tasks</a>
</body>
</html>
