package com.company;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * Created by User on 23.04.2017.
 */
class CrackTextGUI {

    CrackTextGUI() {
        try {
            AffinitySubstitutionBihramCryptanalysis af = new AffinitySubstitutionBihramCryptanalysis();
            JPanel jPanel = new JPanel();
            FlowLayout flowLayout = new FlowLayout();
            jPanel.setLayout(flowLayout);

            JTextArea jTextArea = new JTextArea(43, 115);
            String res = af.writeFileIntoStringForEncodedText("C:\\cracked.txt");
            jTextArea.setText(res);
            jTextArea.setEditable(false);
            jTextArea.setLineWrap(true);

            JScrollPane jScrollPane = new JScrollPane(jTextArea);
            jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            jPanel.add(jScrollPane, BorderLayout.CENTER);

            JFrame jFrame = new JFrame("Cracking text");

            jFrame.setContentPane(jPanel);
            jFrame.setResizable(false);
            jFrame.setSize(1360, 740);
            jFrame.setVisible(true);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
