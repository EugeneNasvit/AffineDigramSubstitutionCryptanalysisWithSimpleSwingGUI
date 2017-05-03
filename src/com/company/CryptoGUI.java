package com.company;

import javax.swing.*;
import java.awt.*;

/**
 * Created by User on 18.04.2017.
 */
class CryptoGUI {

    CryptoGUI() {
        JPanel jPanel = new JPanel();
        GridLayout gl = new GridLayout(7, 2);

        jPanel.setLayout(gl);

        JLabel jLabel = new JLabel("Get most frequent bihrams");
        jPanel.add(jLabel);
        JButton jButton = new JButton("test it!");
        jPanel.add(jButton);
        JLabel jLabel1 = new JLabel("Simple Euclidean Algorithm");
        jPanel.add(jLabel1);
        JButton jButton1 = new JButton("test it!");
        jPanel.add(jButton1);
        JLabel jLabel2 = new JLabel("Extended Euclidean Algorithm");
        jPanel.add(jLabel2);
        JButton jButton2 = new JButton("test it!");
        jPanel.add(jButton2);
        JLabel jLabel3 = new JLabel("Test modular inverse");
        jPanel.add(jLabel3);
        JButton jButton3 = new JButton("test it!");
        jPanel.add(jButton3);
        JLabel jLabel4 = new JLabel("Solve linear comparison");
        jPanel.add(jLabel4);
        JButton jButton4 = new JButton("test it!");
        jPanel.add(jButton4);
        JLabel jLabel5 = new JLabel("Encode/Decode with own key");
        jPanel.add(jLabel5);
        JButton jButton5 = new JButton("test it!");
        jPanel.add(jButton5);
        JLabel jLabel6 = new JLabel("Find key and crack some text");
        jPanel.add(jLabel6);
        JButton jButton6 = new JButton("test it!");
        jPanel.add(jButton6);

        FirstJButton firstJButton = new FirstJButton(this);
        SecondJButton secondJButton = new SecondJButton(this);
        ThirdJButton thirdJButton = new ThirdJButton(this);
        FourthJButton fourthJButton = new FourthJButton(this);
        FivethJButton fivethJButton = new FivethJButton(this);
        SixthJButton sixthJButton = new SixthJButton(this);
        SeventhJButton seventhJButton = new SeventhJButton(this);

        jButton.addActionListener(firstJButton);
        jButton1.addActionListener(secondJButton);
        jButton2.addActionListener(thirdJButton);
        jButton3.addActionListener(fourthJButton);
        jButton4.addActionListener(fivethJButton);
        jButton5.addActionListener(sixthJButton);
        jButton6.addActionListener(seventhJButton);

        JFrame jFrame = new JFrame();
        jFrame.setContentPane(jPanel);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.setSize(370, 300);
        jFrame.setVisible(true);
    }
}
