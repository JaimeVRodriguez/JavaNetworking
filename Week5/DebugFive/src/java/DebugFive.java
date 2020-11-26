/*
 * Jaime Rodriguez
 * Assignment 5.2
 * November 26, 2020
 *
 * Purpose: Purposely insert "bugs" for
 * other students to find and fix
 *
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.Arrays;
import java.util.List;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DebugFive", urlPatterns = {"/DebugFive"})
// Improper prompt in extend
// Should read extends
public class DebugFive extend HttpServlet {
    
    static Charset filesChars = Charset.forName("US-ASCII");
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DebugFive</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DebugFive at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Missing closing parenthesis
        // Should read ... response.getWriter();
        PrintWriter out = response.getWriter;
        
        try {
            printHeader(out);
            
            out.println("<div><h2>User Data Form</h2></div>");
            
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
        
        PrintWriter out = response.getWriter();
        
        try {
            Path target = Paths.get("C:/temp/debugfive.dat");
            
            String country = request.getParameter("COUNTRY");
            String email = request.getParameter("EMAIL");
            String username = request.getParameter("USERNAME");
            String password = request.getParameter("PASSWORD");
            
            List <String> linesToWrite = Arrays.asList(country, email, username, password);
            
            if(Files.notExists(target)) {
                Files.write(target, linesToWrite, filesChars);
            }
            else {
                Files.write(target, linesToWrite, filesChars, StandardOpenOption.APPEND);
            }
            
            Path source = Paths.get("C:/temp/debugfive.dat");
            
            List <String> linesRead = null;
            
            linesRead = Files.readAllLines(source, filesChars);
            
            if(linesRead != null) {
                for(String line : linesRead) {
                    out.println(line + "<br />\n");
                }
            }
        }
        catch(IOException e) {
                
        }
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
    
    public void printForm(PrintWriter out) {
        // Wrong action
        // Should read ... <form action='DebugFive' ....
        out.println("<form action='Debug' method='post'>");
        
        out.println("Country:");
        out.println("<select name='COUNTRY'>");
        out.println("<option value='USA' selected> United States</option>");
        out.println("<option value='Canada' selected> Canada</option>");
        out.println("<option value='Mexico' selected> Mexico</option>");
        out.println("</select>");
        out.println("<br>");
        
        out.println("Email:");
        out.println("<input type='email' name='EMAIL' required/>");
        out.println("<br>");
        
        out.println("Username:");
        out.println("<input type='text' name='USERNAME' required/>");
        out.println("<br>");
        
        out.println("Password:");
        out.println("<input type='password' name='PASSWORD' required/>");
        out.println("<br>");
        
        out.println("<input type='reset' value='Reset' />");
        out.println("<input type='submit' value='Submit' />");
        out.println("</form>");
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
