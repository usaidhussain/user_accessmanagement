package com.usermanagement;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import javax.servlet.http.*;
import org.junit.*;
import java.io.*;

public class SoftwareServletTest {
    private SoftwareServlet servlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;

    @Before
    public void setUp() {
        servlet = new SoftwareServlet();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        session = mock(HttpSession.class);
        when(request.getSession()).thenReturn(session);
    }

    @Test
    public void testDoPost() throws Exception {
        when(request.getParameter("name")).thenReturn("New Software");
        when(request.getParameter("description")).thenReturn("Description here");
        when(request.getParameter("accessLevels")).thenReturn("Admin");

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        servlet.doPost(request, response);

        verify(request, atLeast(1)).getParameter("name");
        writer.flush();
        assertTrue(stringWriter.toString().contains("success"));
    }
}
