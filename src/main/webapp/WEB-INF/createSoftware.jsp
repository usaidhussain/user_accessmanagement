<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Create Software</title>
</head>
<body>
    <h2>Create New Software</h2>
    <form action="SoftwareServlet" method="post">
        Software Name: <input type="text" name="name" required><br>
        Description: <textarea name="description" required></textarea><br>
        Access Levels: <input type="text" name="accessLevels" required><br>
        <input type="submit" value="Create">
    </form>
</body>
</html>
