/*
 * Jaime Rodriguez
 * Assignment 1.2
 * October 28, 2020
 *
 * Purpose: Purposely insert "bugs" for
 * other students to find and fix
 *
 * To compile the program:
 * javac Reservation.java
 *
 * To execute the program:
 * java Reservation
 *
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Reservation extends JFrame implements ItemListener {
    final int BASE_PRICE = 200;
    final int WEEKEND_PREMIUM = 100;
    final int BREAKFAST_PREMIUM = 20;
    final int GOLF_PREMIUM = 75;
    int totalPrice = BASE_PRICE;

    JCheckBox weekendBox = new JCheckBox("Weekend premium $" + WEEKEND_PREMIUM, false);
    JCheckBox breakfastBox = new JCheckBox("Breakfast $" + BREAKFAST_PREMIUM, false);
    JCheckBox golfBox = new JCheckBox("Golf $" + GOLF_PREMIUM, false);

    JLabel resortLabel = new JLabel("Resort Price Calculator");
    // Missing closing semi-colon
    JLabel priceLabel = new JLabel("The price for your stay is")
    JTextField totPrice = new JTextField(4);
    JLabel optionExplainLabel = new JLabel("Base price for a room is $" + BASE_PRICE + ".");
    JLabel optionExplainLabel2 = new JLabel("Check the option you want.");

    public Reservation() {
        super("Resort Price Estimator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        add(resortLabel);
        add(optionExplainLabel);
        add(optionExplainLabel2);
        add(weekendBox);
        add(breakfastBox);
        add(golfBox);
        add(priceLabel);
        add(totPrice);

        totPrice.setText("$" + totalPrice);
        weekendBox.addItemListener(this);
        breakfastBox.addItemListener(this);
        golfBox.addItemListener(this);
    }

    public void itemStateChanged(ItemEvent event) {
        Object source = event.getSource();
        int select = event.getStateChange();

        if(source == weekendBox) {
            if(select == ItemEvent.SELECTED) {
                totalPrice += WEEKEND_PREMIUM;
            }
            else {
                totalPrice -= WEEKEND_PREMIUM;
            }
            totPrice.setText("$" + totalPrice);
        }
        else if(source == breakfastBox) {
            if(select == ItemEvent.SELECTED) {
                totalPrice += BREAKFAST_PREMIUM;
            }
            else {
                totalPrice -= BREAKFAST_PREMIUM;
            }
            totPrice.setText("$" + totalPrice);
        }
        else if(source == golfBox) {
            if(select == ItemEvent.SELECTED) {
                totalPrice += GOLF_PREMIUM;
            }
            else {
                totalPrice -= GOLF_PREMIUM;
            }
            totPrice.setText("$" + totalPrice);
        }
    }

    public static void main(String[] args) {
        // Wrong name of class used
        // Should read Reservation aFrame...
        Reserve aFrame = new Reservation();
        final int WIDTH = 300;
        final int HEIGHT = 200;
        aFrame.setSize(WIDTH, HEIGHT);
        aFrame.setVisible(true);
    }
}

