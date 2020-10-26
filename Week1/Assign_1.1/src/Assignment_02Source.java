/*
 * Jaime Rodriguez
 * Assignment 1.1
 * October 26, 2020
 *
 * Purpose: Complete the program
 * by adding action listeners for
 * all appropriate "buttons in order
 * for GUI application to function
 * properly
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

public class Assignment_02Source extends JFrame{

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

    DataClass [] DataClassArray = {
            new DataClass("Fred", "Wayne", "101 Here", "NE", "55551"),
            new DataClass("Goerge", "Thomas", "102 There", "ME", "55552"),
            new DataClass("Mike", "Johnson", "103 No Where", "OK", "55553")
    };

    int arrayPointer = 0;

    public Assignment_02Source(String title){

        super(title);

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

        arrayPointer = 0;
        setFields(arrayPointer);

        addWindowListener(new java.awt.event.WindowAdapter() {

            public void windowClosing(java.awt.event.WindowEvent evt) {

                shutDown();
            }
        });

        buttonPrev.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {

                if(arrayPointer > 0){

                    --arrayPointer;
                } else {
                    arrayPointer = DataClassArray.length - 1;
                }

                setFields(arrayPointer);
            }
        });

        // Addition of "Next button" action listener in order to cycle through array of data
        // Works in same fashion as "Reverse button"
        buttonNext.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {

                if(arrayPointer < DataClassArray.length - 1) {
                    ++arrayPointer;
                } else {
                    arrayPointer = 0;
                }

                setFields(arrayPointer);
            }
        });

        // Addition of "Reset button" action listener
        // Cycles displayed data back to the originally displayed data set
        buttonReset.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {

                arrayPointer = 0;
                setFields(arrayPointer);
            }
        });
    }

    private void setFields(int position){

        textFieldName.setText(DataClassArray[position].getName());
        textFieldAddress.setText(DataClassArray[position].getAddress());
        textFieldCity.setText(DataClassArray[position].getCity());
        textFieldState.setText(DataClassArray[position].getState());
        textFieldZip.setText(DataClassArray[position].getZip());
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
}

class DataClass{

    // To save space I declared all String objects on a single line
    String name, address, city, state, zipCode;

    DataClass(String name, String address, String city, String state, String zipCode){

        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    // To save space I placed the methods on a single line
    String getName(){return this.name;}
    String getAddress(){return this.address;}
    String getCity(){return this.city;}
    String getState(){return this.state;}
    String getZip(){return this.zipCode;}
}