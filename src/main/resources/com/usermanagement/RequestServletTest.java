package com.usermanagement;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import javax.servlet.http.*;
import org.junit.*;
import java.io.*;

public class RequestServletTest {
    private RequestServlet servlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;

    @Before
    public void setUp() {
        servlet = new RequestServlet();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        session = mock(HttpSession.class);
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("userId")).thenReturn("1");
    }

    @Test
    public void testDoPost() throws Exception {
        when(request.getParameter("softwareId")).thenReturn("1001");
        when(request.getParameter("accessType")).thenReturn("Read");
        when(request.getParameter("reason")).thenReturn("Need access for project");

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        servlet.doPost(request, response);

        verify(request, atLeast(1)).getParameter("softwareId");
        writer.flush();
        assertTrue(stringWriter.toString().contains("success"));
    }
}
