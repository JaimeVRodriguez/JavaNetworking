/*
 * Jaime Rodriguez
 * Assignment 4.1
 * November 17, 2020
 *
 * Purpose: Create a web application
 * that writes form data to a .dat file
 * and writes the file to the servlet via
 * doPost.
 *
 */
package week4;

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

@WebServlet(name = "RodriguezFormPost", urlPatterns = {"/RodriguezFormPost"})
public class RodriguezFormPost extends HttpServlet {
    
    static Charset filesChars = Charset.forName("US-ASCII");
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RodriguezFormPost</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RodriguezFormPost at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        
        try {
            printHeader(out);
            
            out.println("<div>"
                    + "<h2>User Data Form</h2>"
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
        
        PrintWriter out = response.getWriter();
        
        try {
            Path target = Paths.get("C:/temp/rodriguezweek4.dat");
            
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
            
            Path source = Paths.get("C:/temp/rodriguezweek4.dat");
            
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
    
    // HTML opening code
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
    
    // HTML closing code
    public void printFooter(PrintWriter out) {
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
    
    // HTML code for form
    public void printForm(PrintWriter out) {
        out.println("<form action='RodriguezFormPost' method='post'>");
        // User country dropdown
        out.println("Country:");
        out.println("<select name='COUNTRY'>");
        out.println("<option value='USA' selected> United States</option>");
        out.println("<option value='Canada' selected> Canada</option>");
        out.println("<option value='Mexico' selected> Mexico</option>");
        out.println("</select>");
        out.println("<br>");
        // User email has to be filled
        out.println("Email:");
        out.println("<input type='email' name='EMAIL' required/>");
        out.println("<br>");
        // User username has to be filled
        out.println("Username:");
        out.println("<input type='text' name='USERNAME' required/>");
        out.println("<br>");
        // User password has to be filled
        out.println("Password:");
        out.println("<input type='password' name='PASSWORD' required/>");
        out.println("<br>");
        // Reset and submit button options
        out.println("<input type='reset' value='Reset' />");
        out.println("<input type='submit' value='Submit' />");
        out.println("</form>");
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
