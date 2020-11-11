/*
 * Jaime Rodriguez
 * Assignment 3.2
 * November 11, 2020
 *
 * Purpose: Purposely insert "bugs" for
 * other students to find and fix
 *
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.util.*;

// Servlets is wrong extension
// Should read HttpServlet
public class DebugThree extends Servlets {

    @WebServlet(name = "DebugThreeServlet", urlPatters = { "/debug_three_servlet"})

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

            // Wrong variable
            // Should read response
            respond.setContentType("text/html");

            // Wrong variable
            // Should read response
            PrintWriter out = respond.getWriter();

            out.println("<!DOCTYPE html>");
            out.println("<html lang='en'>");
            out.println("<head>");
            out.println("<title>");
            out.println("<Debug Servlet>");
            out.println("</title>");
            out.println("<meta charset='utf-8'>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div>");
            out.println("<"">");
            out.println("This servlet serves as the debug problem for Week 3");
            out.println("</div>");
            out.println("</body>");
            // Missing closing ";"
            out.println("</html>")
        }
}