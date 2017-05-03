package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by User on 23.04.2017.
 */
class SeventhJButton implements ActionListener {

    CryptoGUI parent;

    SeventhJButton(CryptoGUI parent) {
        this.parent = parent;
    }

    public void actionPerformed(ActionEvent e) {
        try {
            File fileToCrack = new File("C:\\text.txt");
            if (!fileToCrack.exists()) {
                JOptionPane.showMessageDialog(null, "File must be in C:\\\\ directory and named as text.txt");
            } else {
                AffinitySubstitutionBihramCryptanalysis af = new AffinitySubstitutionBihramCryptanalysis();
                af.keyBust();

                String decodedText = af.writeFileIntoStringForEncodedText("C:\\cracked.txt");
                char[] text = decodedText.toCharArray();
                StringBuilder builder = new StringBuilder();
                List<Character> list = new LinkedList<>();
                for (int i = 1; i < text.length; i++) {
                    if (text[i] == 'k') {
                        break;
                    } else {
                        list.add(text[i]);
                    }
                }

                builder.append("k");
                for (Character c : list) {
                    builder.append(c);
                }

                File file = new File("C:\\cracked.txt");
                FileWriter writer = new FileWriter(file);
                writer.write(builder.toString());
                writer.flush();
                writer.close();

                CrackTextGUI crackTextGUI = new CrackTextGUI();
            }
        } catch (Exception ex) {
            ex.getStackTrace();
        }

    }
}
