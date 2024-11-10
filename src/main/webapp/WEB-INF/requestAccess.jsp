<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Request Access</title>
</head>
<body>
    <h2>Request Access to Software</h2>
    <form action="RequestServlet" method="post">
        Software ID: <input type="number" name="softwareId" required><br>
        Access Type: <select name="accessType">
            <option value="Read">Read</option>
            <option value="Write">Write</option>
            <option value="Admin">Admin</option>
        </select><br>
        Reason: <textarea name="reason" required></textarea><br>
        <input type="submit" value="Request Access">
    </form>
</body>
</html>
