/*
 * Jaime Rodriguez
 * Assignment 4.2
 * November 22, 2020
 *
 * Purpose: Correct bug error in classmates
 * program to function properly
 *
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String target = "localhost:7070"; 

    public Servlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
    	
		PrintWriter out = response.getWriter();
		
		try {
			printHeader(out);
			printForm(out);
			printFooter(out);
		}
		finally{
			out.close();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		final int BUFFER_LENGTH = 40;
		String data = null;
		
		RandomAccessFile randomAccessFile = new RandomAccessFile("C:/temp/ErikLeathWeek4.dat", "rw");
		
		StringBuffer buffer = new StringBuffer(request.getParameter("myName"));
		StringBuffer buffer2 = new StringBuffer(request.getParameter("myEmail"));
		StringBuffer buffer3 = new StringBuffer(request.getParameter("myPhoneNumber"));
		
		response.setContentType("text/html");
		
		// Request is wrong variable
		// Should read response instead of request
		PrintWriter out = response.getWriter();
		
		try {
			printHeader(out);
			
			printForm(out);
			
			// Wrong variable
			// Should read BUFFER_LENGTH
			buffer.setLength(BUFFER_LENGTH);
			buffer.setCharAt(BUFFER_LENGTH - 1, '\n');
			
			randomAccessFile.seek(randomAccessFile.length());
			randomAccessFile.writeChars(buffer.toString());
			randomAccessFile.writeChars(buffer2.toString());
			randomAccessFile.writeChars(buffer3.toString());
			randomAccessFile.seek(0);
			
			while((data = randomAccessFile.readLine()) != null) {
				out.println(data + "<br/>");
			}
			printFooter(out);
		}
		
		finally {
			// Missing out
			out.close();
		}
	}
	
	public void printHeader(PrintWriter out) {
		out.println("<html>");
		out.println("<head>");
		out.println("<title>");
		out.println("Form Post and Get");
		out.println("</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div>");
	}
	
	public void printFooter(PrintWriter out) {
		out.println("</div>");
		out.println("</body>");
		out.println("<html>");
	}
	
	public void printForm(PrintWriter out) {
    	// Form missing email and phone number fields
    	// Action Spelled wrong
		// Was spelled Servlt
		out.println("<Form method='post' action='Servlet'>");
		out.println("<label>Enter Name</label>");
		// Name variable spelled incorrectly
		out.println("<input type='text' name='myName' size='40' maxlength='40'/>");
		out.println("<label>Enter Email</label>");
		out.println("<input type='text' name='myEmail' size='40' maxlength='40'/>");
		out.println("<label>Enter Phone Number</label>");
		out.println("<input type='text' name='myPhoneNumber' size='40' maxlength='40'/>");
		out.println("<input type='submit' />");
		out.println("</form>");
	}
}