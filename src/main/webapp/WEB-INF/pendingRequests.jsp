<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Pending Requests</title>
</head>
<body>
    <h2>Pending Access Requests</h2>
    <!-- Implementation to list pending requests with options to approve or reject -->
    <form action="ApprovalServlet" method="post">
        Request ID: <input type="number" name="requestId" required><br>
        Status: <select name="status">
            <option value="Approved">Approve</option>
            <option value="Rejected">Reject</option>
        </select><br>
        <input type="submit" value="Submit Decision">
    </form>
</body>
</html>
