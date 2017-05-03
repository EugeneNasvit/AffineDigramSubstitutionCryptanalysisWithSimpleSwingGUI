package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by User on 25.04.2017.
 */
class EncodeOwnText implements ActionListener {


    private AffinitySubstitutionBihramCryptanalysis affinitySubstitutionBihramCryptanalysis = new AffinitySubstitutionBihramCryptanalysis();

    EncodingDecodingOwnTextGUI parent;

    EncodeOwnText(EncodingDecodingOwnTextGUI parent) {
        this.parent = parent;
    }

    public void actionPerformed(ActionEvent e) {

        try {
            int a = Integer.parseInt(parent.getFirstNumber());
            int b = Integer.parseInt(parent.getSecondNumber());

            String filePath = parent.getFirstFile().replace("\\\\", "\\").replace("\\", "\\\\");
            File file1 = new File(filePath);
            if (!file1.exists()) {
                JOptionPane.showMessageDialog(null, "File doesn't exists!");
            } else {
                affinitySubstitutionBihramCryptanalysis.encodingTest(a, b, filePath);

                String res = affinitySubstitutionBihramCryptanalysis.writeFileIntoStringForEncodedText("C:\\testEncodedText.txt");

                if (res.length() < 2) {
                    parent.jTextArea.setText("");
                    JOptionPane.showMessageDialog(null, "Wrong file encoding!");
                } else {
                    parent.jTextArea.setText(affinitySubstitutionBihramCryptanalysis.writeFileIntoStringForEncodedText("C:\\testEncodedText.txt"));
                }
            }
        } catch (Exception ex) {
            ex.getStackTrace();
        }
    }
}
