package com.company;

import javax.swing.*;
import java.awt.*;

/**
 * Created by User on 24.04.2017.
 */
class ExtendedEAGUI {

    private JTextField jTextField;
    private JTextField jTextField1;
    private JTextField jTextField2;

    void setDisplayValue(String str) {
        jTextField2.setText(str);
    }

    String getFirstNumber() {
        return jTextField.getText();
    }

    String getSecondNumber() {
        return jTextField1.getText();
    }

    ExtendedEAGUI() {

        JPanel jPanel1 = new JPanel();
        GridBagLayout gridBagLayout = new GridBagLayout();
        jPanel1.setLayout(gridBagLayout);

        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.ipadx = 120;
        gridBagConstraints.ipady = 10;

        JLabel jLabel = new JLabel("First num : ");
        jTextField = new JTextField();
        JLabel jLabel1 = new JLabel("     Second num : ");
        jTextField1 = new JTextField();

        jPanel1.add(jLabel);
        jPanel1.add(jTextField, gridBagConstraints);
        jPanel1.add(jLabel1);
        jPanel1.add(jTextField1, gridBagConstraints);

        JPanel jPanel2 = new JPanel();
        jPanel2.setLayout(gridBagLayout);

        JButton jButton = new JButton("Calculate");
        JLabel jLabel2 = new JLabel("       Result : ");
        jTextField2 = new JTextField();
        jTextField2.setEditable(false);

        //gridBagConstraints.ipadx = 200;

        gridBagConstraints.ipadx = 25;
        gridBagConstraints.ipady = 15;

        jPanel2.add(jButton, gridBagConstraints);

        jPanel2.add(jLabel2);

        gridBagConstraints.ipadx = 200;
        gridBagConstraints.ipady = 10;

        jPanel2.add(jTextField2, gridBagConstraints);

        JPanel jPanel = new JPanel();
        GridLayout gridLayout = new GridLayout(2, 1);
        jPanel.setLayout(gridLayout);
        jPanel.add(jPanel1);
        jPanel.add(jPanel2);

        CalculateDecomposition calculateDecomposition = new CalculateDecomposition(this);
        jButton.addActionListener(calculateDecomposition);

        JFrame jFrame = new JFrame("Extended Euclidean Algorithm");
        jFrame.setSize(450, 150);
        jFrame.setContentPane(jPanel);
        jFrame.setVisible(true);
        jFrame.setResizable(false);
    }
}
