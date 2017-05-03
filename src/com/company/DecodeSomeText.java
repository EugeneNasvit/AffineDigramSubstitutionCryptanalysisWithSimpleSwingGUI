package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Arrays;

/**
 * Created by User on 25.04.2017.
 */
class DecodeSomeText implements ActionListener {

    private AffinitySubstitutionBihramCryptanalysis af = new AffinitySubstitutionBihramCryptanalysis();

    EncodingDecodingOwnTextGUI parent;

    DecodeSomeText(EncodingDecodingOwnTextGUI parent) {
        this.parent = parent;
    }

    public void actionPerformed(ActionEvent e) {

        try {
            int a = Integer.parseInt(parent.getThirdNumber());
            int b = Integer.parseInt(parent.getFourthNumber());

            String file = parent.getSecondFile().replace("\\\\", "\\").replace("\\", "\\\\");
            File file1 = new File(file);
            if (!file1.exists()) {
                parent.setArea1Value("");
                JOptionPane.showMessageDialog(null, "File doesn't exists!");
            } else {
                af.decodingTest(a, b, file);

                String decodedText = af.writeFileIntoStringForEncodedText("C:\\testDecodedText.txt");

                int counter = 0;

                char[] arr = decodedText.toCharArray();
                char first = arr[0];
                for (char ch : arr) {
                    if (ch == first) {
                        counter++;
                    }
                }

                if (!(decodedText.charAt(0) <=1103 && decodedText.charAt(0) >= 1072)) {
                    af.decodingTestForAnotherEncoding(a, b, file);
                    parent.setArea1Value(af.writeFileIntoStringForEncodedText("C:\\testDecodedText.txt"));
                } else if (counter == decodedText.length() / 2) {
                    af.decodingTestForAnotherEncoding(a, b, file);
                    parent.setArea1Value(af.writeFileIntoStringForEncodedText("C:\\testDecodedText.txt"));
                } else {
                    parent.setArea1Value(af.writeFileIntoStringForEncodedText("C:\\testDecodedText.txt"));
                }
            }
        } catch (Exception ex) {
            ex.getStackTrace();
        }
    }
}
