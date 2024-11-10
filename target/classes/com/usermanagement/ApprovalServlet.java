package com.usermanagement;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;

public class ApprovalServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int requestId = Integer.parseInt(request.getParameter("requestId"));
        String status = request.getParameter("status"); // Expected to be "Approved" or "Rejected"

        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/yourdb", "user", "password")) {
            String sql = "UPDATE requests SET status = ? WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, status);
            statement.setInt(2, requestId);
            statement.executeUpdate();
            response.sendRedirect("pendingRequests.jsp?success=true");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("pendingRequests.jsp?error=true");
        }
    }
}
