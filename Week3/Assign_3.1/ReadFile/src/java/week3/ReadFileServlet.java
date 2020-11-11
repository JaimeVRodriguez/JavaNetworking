/*
 * Jaime Rodriguez
 * Assignment 3.1
 * November 11, 2020
 *
 * Purpose: Create a web application
 * that displays an ASCII file utilizing
 * a servlet.
 *
 */

package week3;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ReadFileServlet", urlPatterns = {"/ReadFileServlet"})
public class ReadFileServlet extends HttpServlet {

    static Charset fileChars = Charset.forName("US-ASCII");
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ReadFileServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ReadFileServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        try{
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Read File Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div>");

            Path source = Paths.get("C:/temp/servlet1.dat");

            List <String> linesRead = null;

            linesRead = Files.readAllLines(source, fileChars);      

            if(linesRead != null){
              for(String line : linesRead){
                out.println(line+ "<br />\n");
              }
            }
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
        finally{
            out.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Servlet to retrieve information to servlet1.dat";
    }
}
