/*
 *
 * Jaime Rodriguez
 * Assignment 8.1
 * December 16, 2020
 *
 * Purpose: Create a web application
 * that writes data from a form to a
 * database and retrieves the info
 * from that database using a Java Bean
 * and a custom tag.
 *
 */

package tags;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;
import java.util.*;
import java.text.DateFormat;

public class CurrentDateTag extends TagSupport{
    
    @Override
    public int doStartTag() throws JspException {
        Date currentDate = new Date();
        DateFormat shortDate = DateFormat.getDateInstance(DateFormat.SHORT);
        String currentDateFormatted = shortDate.format(currentDate);
        
        try {
            JspWriter out = pageContext.getOut();
            out.println(currentDateFormatted);
        }
        catch(Exception ioe) {
            System.out.println(ioe);
        }
        
        return SKIP_BODY;
    }   
}
