/*
 * Jaime Rodriguez
 * Assignment 1.2
 * October 28, 2020
 *
 * Purpose: Correct bug error in classmates
 * program to function properly
 *
 * To compile the program:
 * javac Error.java
 *
 * To execute the program:
 * java Error
 *
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Error extends JFrame {

    JButton b1, b2;
    int counter = 0;

    public Error() {
        super("Error program.");
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());

        class MyActionListener implements ActionListener{
            String buttonMessage;
            public void actionPerformed(ActionEvent event) {
                // .getText method not call properly
                // Was missing ()
                String id = ((JButton)event.getSource()).getText();
                if(id.equals("Plus")) {
                    ++counter;
                }
				
				else {
				    --counter;
				}

				System.out.println(counter);
            }

                MyActionListener(String msg){
                    buttonMessage = msg;
                }
        }
		
		cp.add(b1 = new JButton("Plus"));
		b1.addActionListener(new MyActionListener("Button 1"));
		
		cp.add(b2 = new JButton("Minus"));
		b2.addActionListener(new MyActionListener("Button 2"));

            pack();
        }

        public static void main(String[] args) {
            // Was set to "false"
            // Meaning no window would pop up
            // Changed to true
            new Error().setVisible(true);

        }

    }