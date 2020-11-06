/*
 * Jaime Rodriguez
 * Assignment 2.1
 * November 5, 2020
 *
 * Purpose: Display the appropriate 
 * information stored in a database
 * through the use of a GUI 
 * application
 *
 * To compile the program:
 * javac Assignment_02Source.java
 *
 * To execute the program:
 * java Assignment_02Source
 *
 *

 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.net.URL;
import java.sql.*;


import oracle.jdbc.OracleDriver;
import oracle.jdbc.OracleResultSetMetaData;


/*
* DataClass - Structure of data to display
*/
class DataClass{

    String name, address, city, state, zipCode;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = new String(name);
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = new String(address);
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = new String(city);
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = new String(state);
    }
    public String getZip() {
        return zipCode;
    }
    public void setZip(String zipCode) {
        this.zipCode = new String(zipCode);
    }
    
    public String toString() {
        return new String(name.toString().trim() + ", " + 
                        address.toString().trim() + ", " + 
                        city.toString().trim() + ", " +
                        state.toString().trim() + ", " +
                        zipCode.toString().trim());
    }
}


/*
* Get data from database
* Methods to utilize for buttons
*/
class SelectData {
    // JDBC Variables
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    public SelectData() {
        
        try {
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "student1", "pass");
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } 
        catch (Exception e) {
            System.out.println("Error connection to database.");
            System.exit(0);
        }
        
        try {
            rs = stmt.executeQuery("SELECT * FROM ADDRESS");
        }
        catch(SQLException e) {
            System.out.println(e);
            System.out.println("Result Request Failed");
        }
    }
    
    // Method to get previous dataset
    public DataClass getPrevious() {  
        DataClass personData = new DataClass();

        try {
            rs.previous();

            personData.setName(rs.getString(rs.findColumn("FIRSTNAME")) + " " + rs.getString(rs.findColumn("LASTNAME")));
            personData.setAddress(rs.getString(rs.findColumn("STREET")));
            personData.setCity(rs.getString(rs.findColumn("CITY")));
            personData.setState(rs.getString(rs.findColumn("STATE")));
            personData.setZip(rs.getString(rs.findColumn("ZIP")));
        }
        catch(SQLException e) {
            return this.getLast();
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return personData;
    }
    
    // Method to get next dataset
    public DataClass getNext() {
        DataClass personData = new DataClass();
            
        try {
            rs.next();
              
            personData.setName(rs.getString(rs.findColumn("FIRSTNAME")) + " " +  rs.getString(rs.findColumn("LASTNAME")));
            personData.setAddress(rs.getString(rs.findColumn("STREET")));
            personData.setCity(rs.getString(rs.findColumn("CITY")));
            personData.setState(rs.getString(rs.findColumn("STATE")));
            personData.setZip(rs.getString(rs.findColumn("ZIP")));
        }
        catch(SQLException e) {
            return this.getFirst();
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return personData;
    }
        
    // Method to get first item or "reset" dataset
    public DataClass getFirst() {
        DataClass personData = new DataClass();
         
        try {
            rs.first();
              
            personData.setName(rs.getString(rs.findColumn("FIRSTNAME")) + " " +  rs.getString(rs.findColumn("LASTNAME")));
            personData.setAddress(rs.getString(rs.findColumn("STREET")));
            personData.setCity(rs.getString(rs.findColumn("CITY")));
            personData.setState(rs.getString(rs.findColumn("STATE")));
            personData.setZip(rs.getString(rs.findColumn("ZIP")));
        }
            
        catch(Exception e) {
            System.out.println(e);
        }
        return personData;
    }  
    
    // Method to get last item for complete cycle through
    public DataClass getLast() {
        DataClass personData = new DataClass();
            
        try {
            rs.last();
                
            personData.setName(rs.getString(rs.findColumn("FIRSTNAME")) + " " +  rs.getString(rs.findColumn("LASTNAME")));
            personData.setAddress(rs.getString(rs.findColumn("STREET")));
            personData.setCity(rs.getString(rs.findColumn("CITY")));
            personData.setState(rs.getString(rs.findColumn("STATE")));
            personData.setZip(rs.getString(rs.findColumn("ZIP")));
        }
            
        catch(Exception e) {
            System.out.println(e);
        }
        return personData;
    }
}

public class Assignment_02Source extends JFrame{

    SelectData selectData = new SelectData();

    private JButton buttonPrev=new JButton("Prev");
    private JButton buttonReset=new JButton("Reset");
    private JButton buttonNext=new JButton("Next");

    private JLabel labelHeader=new JLabel("Database Browser",JLabel.CENTER);
    private JLabel labelName=new JLabel("Name");
    private JLabel labelAddress=new JLabel("Address");
    private JLabel labelCity=new JLabel("City");
    private JLabel labelState=new JLabel("State");
    private JLabel labelZip=new JLabel("Zip");

    private JTextField textFieldName=new JTextField();
    private JTextField textFieldAddress=new JTextField();
    private JTextField textFieldCity=new JTextField();
    private JTextField textFieldState=new JTextField();
    private JTextField textFieldZip=new JTextField();
    
    // ActionListeners for buttons utilizing previously made methods
    private ActionListener buttonListener = new ActionListener(){
        public void actionPerformed(ActionEvent e){
            String buttonSelected = ((JButton)e.getSource()).getText();
 
            if(buttonSelected.equals("Reset")){
                setFields(selectData.getFirst());
            }     

            if(buttonSelected.equals("Prev")){
                setFields(selectData.getPrevious());
            }     

            if(buttonSelected.equals("Next")){
                setFields(selectData.getNext());
            }         
        }
    };
    
    private void setFields(DataClass personData){
        textFieldName.setText(personData.getName());
        textFieldAddress.setText(personData.getAddress());
        textFieldCity.setText(personData.getCity());
        textFieldState.setText(personData.getState());
        textFieldZip.setText(personData.getZip());
    }
    
    private void shutDown(){
        int returnVal=JOptionPane.showConfirmDialog(this, "Are you sure you want to quit?");

        if(returnVal==JOptionPane.YES_OPTION){

            System.exit(0);
        }
    }
    
     public static void main(String args[]){
        Assignment_02Source a2 = new Assignment_02Source("Database Browser");

        a2.setSize(400,350);
        a2.setVisible(true);
    }

    
    public Assignment_02Source(String title){
        
        super(title);
        
        SelectData selectData = new SelectData();

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        JPanel cp=(JPanel)getContentPane();

        labelHeader.setFont(new Font("TimesRoman",Font.BOLD,24));
        labelHeader.setBounds(40,10,300,50);

        buttonPrev.setBounds(30,250,80,25);
        buttonReset.setBounds(150,250,80,25);
        buttonNext.setBounds(270,250,80,25);

        labelName.setBounds(10,80,80,25);
        labelAddress.setBounds(10,110,80,25);
        labelCity.setBounds(10,140,80,25);
        labelState.setBounds(10,170,80,25);
        labelZip.setBounds(10,200,80,25);

        textFieldName.setBounds(120,80,250,25);
        textFieldAddress.setBounds(120,110,250,25);
        textFieldCity.setBounds(120,140,250,25);
        textFieldState.setBounds(120,170,250,25);
        textFieldZip.setBounds(120,200,250,25);

        cp.setLayout(null);
        cp.add(labelHeader);
        cp.add(buttonPrev);
        cp.add(buttonReset);
        cp.add(buttonNext);
        cp.add(labelName);
        cp.add(textFieldName);
        cp.add(labelAddress);
        cp.add(textFieldAddress);
        cp.add(labelCity);
        cp.add(textFieldCity);
        cp.add(labelState);
        cp.add(textFieldState);
        cp.add(labelZip);
        cp.add(textFieldZip);
        
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                shutDown();
            }
        });
        
        buttonPrev.addActionListener(buttonListener);
        buttonReset.addActionListener(buttonListener);
        buttonNext.addActionListener(buttonListener);
    }
}

