package com.company;

import javax.swing.*;
import java.awt.*;

/**
 * Created by User on 24.04.2017.
 */
class LinearComparisonGUI {

    private JTextField jTextField;
    private JTextField jTextField1;
    private JTextArea jTextArea;
    private JTextField jTextField3;

    void setDisplayValue(String str) {
        jTextArea.setText(str);
    }

    String getFirstNumber() {
        return jTextField.getText();
    }

    String getSecondNumber() {
        return jTextField1.getText();
    }

    String getModule() {
        return jTextField3.getText();
    }

    LinearComparisonGUI() {

        JPanel jPanel1 = new JPanel();
        GridBagLayout gridBagLayout = new GridBagLayout();
        jPanel1.setLayout(gridBagLayout);

        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.ipadx = 120;
        gridBagConstraints.ipady = 10;


        jTextField = new JTextField();
        JLabel jLabel = new JLabel("* x   =   ");
        jTextField1 = new JTextField();
        JLabel jLabel1 = new JLabel("   mod  ");
        jTextField3 = new JTextField();

        jPanel1.add(jTextField, gridBagConstraints);
        jPanel1.add(jLabel);
        jPanel1.add(jTextField1, gridBagConstraints);
        jPanel1.add(jLabel1);
        jPanel1.add(jTextField3, gridBagConstraints);

        JPanel jPanel2 = new JPanel();
        jPanel2.setLayout(gridBagLayout);

        JButton jButton = new JButton("Calculate");
        JLabel jLabel2 = new JLabel("       Solutions are : ");

        jTextArea = new JTextArea(5, 25);
        jTextArea.setEditable(false);
        jTextArea.setLineWrap(true);

        JScrollPane jScrollPane = new JScrollPane(jTextArea);
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        gridBagConstraints.ipadx = 25;
        gridBagConstraints.ipady = 15;

        jPanel2.add(jButton, gridBagConstraints);

        jPanel2.add(jLabel2);

        /*gridBagConstraints.ipadx = 245;
        gridBagConstraints.ipady = 10;*/
        jPanel2.add(jScrollPane);

        //jPanel2.add(jTextField2, gridBagConstraints);

        JPanel jPanel = new JPanel();
        GridLayout gridLayout = new GridLayout(2, 1);
        jPanel.setLayout(gridLayout);
        jPanel.add(jPanel1);
        jPanel.add(jPanel2);


        SolveLinearComparison solveLinearComparison = new SolveLinearComparison(this);
        jButton.addActionListener(solveLinearComparison);


        JFrame jFrame = new JFrame("Solving linear comparison");
        jFrame.setSize(540, 230);
        jFrame.setContentPane(jPanel);
        jFrame.setVisible(true);
        jFrame.setResizable(false);
    }
}
