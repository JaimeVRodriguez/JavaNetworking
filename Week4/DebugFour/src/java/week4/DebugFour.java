/*
 * Jaime Rodriguez
 * Assignment 4.2
 * November 18, 2020
 *
 * Purpose: Purposely insert "bugs" for
 * other students to find and fix
 *
 */

package week4;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DebugFour", urlPatterns = {"/DebugFour"})
public class DebugFour extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DebugFour</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DebugFour at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        
        try {
            // Improper method name
            // Should read printHeader(out)
            Header(out);
            
            out.println("<div>"
                        + "<h2> Addition Program </h2>"
                        + "</div>");
            
            printForm(out);
            printFooter(out);
        }
        finally {
            out.close();
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Incorrect variable name
        // Should read PrintWriter out = .....
        PrintWriter printer = response.getWriter();
        
        int numberOne = Integer.parseInt(request.getParameter("NUMBER_ONE"));
        int numberTwo = Integer.parseInt(request.getParameter("NUMBER_TWO"));
        
        int total = numberOne + numberTwo;
        
        out.println("Total of " + numberOne + " and " + numberTwo + " is " + total);   
    }

    public void printForm(PrintWriter out) {
        out.println("<form action='DebugFour' method='post'>");

        out.println("Number 1:");
        out.println("<input type='text' name='NUMBER_ONE' required/>");
        out.println("<br>");
        
        out.println("Number 2:");
        out.println("<input type='text' name='NUMBER_TWO' required/>");
        out.println("<br>");
        
        out.println("<input type='reset' value='Reset' />");
        out.println("<input type='submit' value='Add' />");
        // Form not properly closed
        // Should read out.println("</form>");
        out.println("<form>");
    }
    
    public void printHeader(PrintWriter out) {
        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>");
        out.println("Simple Data Form");
        out.println("</title>");
        out.println("<meta charset='utf-8'>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div>");
    }
    
    public void printFooter(PrintWriter out) {
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
