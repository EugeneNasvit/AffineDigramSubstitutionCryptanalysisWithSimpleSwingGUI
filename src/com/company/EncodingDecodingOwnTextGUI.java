package com.company;

import javax.swing.*;
import java.awt.*;

/**
 * Created by User on 24.04.2017.
 */
class EncodingDecodingOwnTextGUI {

    private JTextField jTextField;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JTextField jTextField3;
    private JTextField jTextField4;
    private JTextField jTextField5;
    JTextArea jTextArea;
    private JTextArea jTextArea1;

    void setAreaValue(String str) {
        jTextArea.setText(str);
    }

    void setArea1Value(String str) {
        jTextArea1.setText(str);
    }

    String getFirstFile() {
        return jTextField4.getText();
    }

    String getSecondFile() {
        return jTextField5.getText();
    }

    String getFirstNumber() {
        return jTextField.getText();
    }

    String getSecondNumber() {
        return jTextField1.getText();
    }

    String getThirdNumber() {
        return jTextField2.getText();
    }

    String getFourthNumber() {
        return jTextField3.getText();
    }

    EncodingDecodingOwnTextGUI() {

        JPanel jPanel2 = new JPanel();
        GridBagLayout gridBagLayout = new GridBagLayout();

        JLabel jLabel11 = new JLabel("File   ");
        jTextField4 = new JTextField();
        jTextField4.setPreferredSize(new Dimension(270, 25));
        JLabel jLabel0 = new JLabel("   Key");
        JButton jButton = new JButton("Encode");
        JLabel jLabel2 = new JLabel("   (");
        jTextField = new JTextField();
        jTextField.setPreferredSize(new Dimension(45, 25));
        JLabel jLabel3 = new JLabel(",");
        jTextField1 = new JTextField();
        jTextField1.setPreferredSize(new Dimension(45, 25));
        JLabel jLabel4 = new JLabel(")      ");
        JLabel jLabel8 = new JLabel("       ");
        JButton jButton3 = new JButton("Clear");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            stringBuilder.append(" ");
        }
        JLabel jLabel12 = new JLabel(stringBuilder.toString() + "File  ");
        jTextField5 = new JTextField();
        jTextField5.setPreferredSize(new Dimension(270, 25));
        JLabel jLabel00 = new JLabel("   Key");
        JButton jButton1 = new JButton("Decode");
        JLabel jLabel5 = new JLabel("   (");
        jTextField2 = new JTextField();
        jTextField2.setPreferredSize(new Dimension(45, 25));
        JLabel jLabel6 = new JLabel(",");
        jTextField3 = new JTextField();
        jTextField3.setPreferredSize(new Dimension(45, 25));
        JLabel jLabel7 = new JLabel(")     ");
        JLabel jLabel9 = new JLabel("       ");
        JButton jButton4 = new JButton("Clear");

        jPanel2.add(jLabel11);
        jPanel2.add(jTextField4);
        jPanel2.add(jLabel0);
        jPanel2.add(jLabel2);
        jPanel2.add(jTextField);
        jPanel2.add(jLabel3);
        jPanel2.add(jTextField1);
        jPanel2.add(jLabel4);
        jPanel2.add(jButton);
        jPanel2.add(jLabel8);
        jPanel2.add(jButton3);
        jPanel2.add(jLabel12);
        jPanel2.add(jTextField5);
        jPanel2.add(jLabel00);
        jPanel2.add(jLabel5);
        jPanel2.add(jTextField2);
        jPanel2.add(jLabel6);
        jPanel2.add(jTextField3);
        jPanel2.add(jLabel7);
        jPanel2.add(jButton1);
        jPanel2.add(jLabel9);
        jPanel2.add(jButton4);

        //---------------------------------------------------------------------------

        JPanel jPanel3 = new JPanel();
        jPanel2.setLayout(gridBagLayout);

        jTextArea = new JTextArea(38, 58);
        jTextArea.setEditable(false);
        jTextArea.setLineWrap(true);

        jTextArea1 = new JTextArea(38, 58);
        jTextArea1.setEditable(false);
        jTextArea1.setLineWrap(true);

        JScrollPane jScrollPane = new JScrollPane(jTextArea);
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        JScrollPane jScrollPane1 = new JScrollPane(jTextArea1);
        jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        jPanel3.add(jScrollPane);
        jPanel3.add(jScrollPane1);

        //---------------------------------------------------------------------------------

        JPanel jPanel = new JPanel();
        jPanel.add(jPanel2);
        jPanel.add(jPanel3);

        EncodeOwnText encodeOwnText = new EncodeOwnText(this);
        jButton.addActionListener(encodeOwnText);
        ClearEncodedText clearEncodedText = new ClearEncodedText(this);
        jButton3.addActionListener(clearEncodedText);
        DecodeSomeText decodeSomeText = new DecodeSomeText(this);
        jButton1.addActionListener(decodeSomeText);
        ClearDecodedText clearDecodedText = new ClearDecodedText(this);
        jButton4.addActionListener(clearDecodedText);

        JFrame jFrame = new JFrame("Working with own text and keys");
        jFrame.setSize(1368, 730);
        jFrame.setContentPane(jPanel);
        jFrame.setVisible(true);
        jFrame.setResizable(false);
    }
}
