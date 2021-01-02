<%-- 
 *
 * Carina Cardona, Erik Leath, Jaime Rodriguez
 * Pilot Program
 * Assignment 9.3 - Milesstone 4 
 * December 2020
 *
 * Purpose: Create a pilot program
 * for All Aboard Toys. Utilizing 
 * servlets, JSP, and Java Beans program
 * create, inserts, and display data to/from
 * associated tables. Program also allows
 * for data to be written to an aspect
 * of the the database through a form.
 *
--%>

<%@page import="java.sql.*"%>
<%@page import="oracle.jdbc.OracleResultSetMetaData"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Tables</title>
    </head>
    <body>
        <h1>Create Tables</h1>
        
        <%
            Connection con = null;
            Statement stmt = null;
            ResultSet rset = null;
            
            if(request.getMethod().equals("GET")) {
                
                try {
                    DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
                    con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "student1", "pass");
                    
                    stmt = con.createStatement();
                    
                    stmt.executeUpdate("CREATE TABLE WAREHOUSE(STOCK_NUMBER INT NOT NULL, QUANTITY INT NOT NULL, PRIMARY KEY (STOCK_NUMBER))");
                    stmt.executeUpdate("CREATE TABLE ITEM(ITEM_NUMBER INT NOT NULL, STOCK_NUMBER INT NOT NULL, ITEM_NAME VARCHAR(50) NOT NULL, ITEM_DESCRIPTION VARCHAR(255), ITEM_PRICE DECIMAL (6,2) NOT NULL, PRIMARY KEY (ITEM_NUMBER), FOREIGN KEY (STOCK_NUMBER) REFERENCES WAREHOUSE(STOCK_NUMBER))");                   
                    stmt.executeUpdate("CREATE TABLE TOY_CUSTOMER(CUSTOMER_ID INT NOT NULL, CUSTOMER_NAME VARCHAR2(50) NOT NULL, CUSTOMER_EMAIL VARCHAR2(255) NOT NULL, CUSTOMER_ADDRESS VARCHAR2(255), PRIMARY KEY (CUSTOMER_ID))");
                    stmt.executeUpdate("CREATE TABLE ACCOUNT(ACCOUNT_NUMBER INT NOT NULL, CUSTOMER_NAME VARCHAR2(50) NOT NULL, PRIMARY KEY (ACCOUNT_NUMBER))");
                    stmt.executeUpdate("CREATE TABLE CUSTOMER_ORDER(ORDER_NUMBER INT NOT NULL, ACCOUNT_NUMBER INT NOT NULL, DATE_PLACED DATE, PRIMARY KEY(ORDER_NUMBER),FOREIGN KEY (ACCOUNT_NUMBER) REFERENCES ACCOUNT (ACCOUNT_NUMBER))");                   
                    stmt.executeUpdate("CREATE TABLE ORDER_ITEM(ID INT NOT NULL, ITEM_NUMBER INT NOT NULL, QUANTITY INT NOT NULL, ACCOUNT_NUMBER INT NOT NULL, ORDER_NUMBER INT NOT NULL, PRIMARY KEY (ID), FOREIGN KEY (ITEM_NUMBER) REFERENCES ITEM (ITEM_NUMBER), FOREIGN KEY (ACCOUNT_NUMBER) REFERENCES ACCOUNT (ACCOUNT_NUMBER), FOREIGN KEY (ORDER_NUMBER) REFERENCES CUSTOMER_ORDER (ORDER_NUMBER))");                    
                    stmt.executeUpdate("CREATE TABLE CUSTOMER_INVOICE(INVOICE_NUMBER INT NOT NULL, ORDER_NUMBER INT, ACCOUNT_NUMBER INT, ORDER_DATE DATE, SUBTOTAL DECIMAL (7,2), TAX DECIMAL (7,2), TOTAL DECIMAL (7,2), PRIMARY KEY (INVOICE_NUMBER), FOREIGN KEY (ORDER_NUMBER) REFERENCES CUSTOMER_ORDER (ORDER_NUMBER), FOREIGN KEY (ACCOUNT_NUMBER) REFERENCES ACCOUNT (ACCOUNT_NUMBER))");                   
                    stmt.executeUpdate("CREATE SEQUENCE seq_id MINVALUE 1 START WITH 1 INCREMENT BY 1 CACHE 1");
                
                    stmt.close();
                    con.close();
                }
                catch(Exception e) {
                    
                }           
        %>
        
        <h3> Tables have been created </h3><br>
        <p>To insert data hit submit</p>
        
        <form action="CreateInsert.jsp" method='post'>
            Submit
            <input type='submit' value='Submit' />
        </form>
        
        <%
            }
            if(request.getMethod().equals("POST")) {
                
                try {
                    DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
                    
                    con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "student1", "pass");
                    
                    stmt = con.createStatement();
                   
                    stmt.executeUpdate("INSERT INTO WAREHOUSE VALUES(1,5)");
                    stmt.executeUpdate("INSERT INTO WAREHOUSE VALUES(2,8)");
                    stmt.executeUpdate("INSERT INTO WAREHOUSE VALUES(3, 15)");
                    stmt.executeUpdate("INSERT INTO WAREHOUSE VALUES(4, 3)");
                    stmt.executeUpdate("INSERT INTO WAREHOUSE VALUES(5, 11)");
                    
                    stmt.executeUpdate("INSERT INTO ITEM VALUES(755, 1, 'Bachman Train Set', 'Christmas Train Set', 206.63)");
                    stmt.executeUpdate("INSERT INTO ITEM VALUES(24022, 2, 'Lionel Train Set', 'Santa Fe Starter Set', 202.07)");
                    stmt.executeUpdate("INSERT INTO ITEM VALUES(957, 3, 'Woodland Scenics Kit', 'Shaper Sheet Kit', 14.23)");
                    stmt.executeUpdate("INSERT INTO ITEM VALUES(1580, 4, 'Woodland Scenics Trees', 'Ready Made Trees', 26.07)");
                    stmt.executeUpdate("INSERT INTO ITEM VALUES(2100, 5, 'Xuro Tool Kit', 'Plier Tool Kit', 40.73)");

                    stmt.executeUpdate("INSERT INTO TOY_CUSTOMER VALUES(seq_id.nextval, 'Jaime Rodriguez', 'jaime@gmail.com', '123 Up St.')");
                    stmt.executeUpdate("INSERT INTO TOY_CUSTOMER VALUES(seq_id.nextval, 'Carina Cardona', 'cc01@yahoo.com', '1928 Down Rd.')");
                    stmt.executeUpdate("INSERT INTO TOY_CUSTOMER VALUES(seq_id.nextval, 'Erik Leath', 'leath99@gmail.com', '513 Left Dr.')");
                    stmt.executeUpdate("INSERT INTO TOY_CUSTOMER VALUES(seq_id.nextval, 'Doug Duke', 'duke123@outlook.com', '3111 Right St.')");
                    stmt.executeUpdate("INSERT INTO TOY_CUSTOMER VALUES(seq_id.nextval, 'Nick Jacobs', 'njacobs@yahoo.com', '1211 North Dr.')");

                    stmt.executeUpdate("INSERT INTO ACCOUNT VALUES(90001, 'Jaime Rodriguez')");
                    stmt.executeUpdate("INSERT INTO ACCOUNT VALUES(90002, 'Carina Cardona')");
                    stmt.executeUpdate("INSERT INTO ACCOUNT VALUES(90003, 'Erik Leath')");
                    stmt.executeUpdate("INSERT INTO ACCOUNT VALUES(90004, 'Doug Duke')");
                    stmt.executeUpdate("INSERT INTO ACCOUNT VALUES(90005, 'Nick Jacobs')");

                    stmt.executeUpdate("INSERT INTO CUSTOMER_ORDER VALUES(1111, 90001, TO_DATE('20/11/2020', 'DD/MM/YYYY'))");
                    stmt.executeUpdate("INSERT INTO CUSTOMER_ORDER VALUES(1112, 90002, TO_DATE('24/11/2020', 'DD/MM/YYYY'))");
                    stmt.executeUpdate("INSERT INTO CUSTOMER_ORDER VALUES(1113, 90003, TO_DATE('29/11/2020', 'DD/MM/YYYY'))");
                    stmt.executeUpdate("INSERT INTO CUSTOMER_ORDER VALUES(1114, 90004, TO_DATE('01/12/2020', 'DD/MM/YYYY'))");
                    stmt.executeUpdate("INSERT INTO CUSTOMER_ORDER VALUES(1115, 90005, TO_DATE('02/12/2020', 'DD/MM/YYYY'))");

                    stmt.executeUpdate("INSERT INTO ORDER_ITEM VALUES(1, 755, 1, 90001, 1111)");
                    stmt.executeUpdate("INSERT INTO ORDER_ITEM VALUES(2, 1580, 3, 90001, 1111)");
                    stmt.executeUpdate("INSERT INTO ORDER_ITEM VALUES(3, 24022, 1, 90002, 1112)");
                    stmt.executeUpdate("INSERT INTO ORDER_ITEM VALUES(4, 2100, 1, 90003, 1113)");
                    stmt.executeUpdate("INSERT INTO ORDER_ITEM VALUES(5, 957, 3, 90004, 1114)");
                    stmt.executeUpdate("INSERT INTO ORDER_ITEM VALUES(6, 1580, 3, 90004, 1114)");
                    stmt.executeUpdate("INSERT INTO ORDER_ITEM VALUES(7, 755, 1, 90005, 1115)");

                    stmt.executeUpdate("INSERT INTO CUSTOMER_INVOICE VALUES(11001, 1111, 90001, TO_DATE('20/11/2020', 'DD/MM/YYYY'), 220.86, 16.56, 237.42)");
                    stmt.executeUpdate("INSERT INTO CUSTOMER_INVOICE VALUES(11002, 1112, 90002, TO_DATE('20/11/2020', 'DD/MM/YYYY'), 202.07, 15.16, 217.23)");
                    stmt.executeUpdate("INSERT INTO CUSTOMER_INVOICE VALUES(11003, 1113, 90003, TO_DATE('20/11/2020', 'DD/MM/YYYY'), 40.73, 3.05, 43.78)");
                    stmt.executeUpdate("INSERT INTO CUSTOMER_INVOICE VALUES(11004, 1114, 90004, TO_DATE('20/11/2020', 'DD/MM/YYYY'), 40.30, 3.02, 43.32)");
                    stmt.executeUpdate("INSERT INTO CUSTOMER_INVOICE VALUES(11005, 1115, 90005, TO_DATE('20/11/2020', 'DD/MM/YYYY'), 206.63, 15.50, 222.13)");

                    stmt.close();
                    con.close();                                      
        %>
        
        <a href="index.jsp"> Homepage </a>
        
        <%
                }
                catch(Exception e) {
                    
                }
            }
        %>
        
    </body>
</html>
