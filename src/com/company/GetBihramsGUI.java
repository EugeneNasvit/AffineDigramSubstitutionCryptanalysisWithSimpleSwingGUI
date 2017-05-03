package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

/**
 * Created by User on 23.04.2017.
 */
class GetBihramsGUI {

    private JTextField jTextField1;
    private JTextField jTextField2;

    void setDisplayValue(String str) {
        jTextField1.setText(str);
    }

    String getFilePath() {
        return jTextField2.getText();
    }

    GetBihramsGUI() {
        try {
            AffinitySubstitutionBihramCryptanalysis a = new AffinitySubstitutionBihramCryptanalysis();

            JPanel jPanel0 = new JPanel();

            JLabel jLabel2 = new JLabel("Filepath :  ");
            jTextField2 = new JTextField();
            jTextField2.setPreferredSize(new Dimension(300, 25));
            JButton jButton = new JButton("Get");

            jPanel0.add(jLabel2);
            jPanel0.add(jTextField2);
            jPanel0.add(jButton);

            JPanel jPanel = new JPanel();

            JPanel jPanel1 = new JPanel();
            GridLayout gl = new GridLayout(2, 1);
            jPanel1.setLayout(gl);

            JLabel jLabel = new JLabel("5 russian most frequent bihrams        ");

            JTextField jTextField = new JTextField(Arrays.toString(a.mostFrequentRussianBihrams));
            jTextField.setEditable(false);

            jPanel1.add(jLabel);
            jPanel1.add(jTextField);

            JPanel jPanel2 = new JPanel();
            jPanel2.setLayout(gl);

            JLabel jLabel1 = new JLabel("5 most frequent bihrams in your text");

            jTextField1 = new JTextField();
            jTextField1.setEditable(false);

            jPanel2.add(jLabel1);
            jPanel2.add(jTextField1);

            GetBihrams getBihrams = new GetBihrams(this);
            jButton.addActionListener(getBihrams);

            jPanel.add("North", jPanel0);
            jPanel.add("West", jPanel1);
            jPanel.add("East", jPanel2);

            JFrame jFrame = new JFrame("Bihram Frequency");
            jFrame.setContentPane(jPanel);
            jFrame.setResizable(false);
            jFrame.setSize(550, 150);
            jFrame.setVisible(true);
            } catch (Exception e) {
                e.getStackTrace();
        }
    }
}
