package com.usermanagement;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;

public class RequestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getSession().getAttribute("userId").toString());
        int softwareId = Integer.parseInt(request.getParameter("softwareId"));
        String accessType = request.getParameter("accessType");
        String reason = request.getParameter("reason");

        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/yourdb", "user", "password")) {
            String sql = "INSERT INTO requests (user_id, software_id, access_type, reason, status) VALUES (?, ?, ?, ?, 'Pending')";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, userId);
            statement.setInt(2, softwareId);
            statement.setString(3, accessType);
            statement.setString(4, reason);
            statement.executeUpdate();
            response.sendRedirect("requestAccess.jsp?success=true");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("requestAccess.jsp?error=true");
        }
    }
}
