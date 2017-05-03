package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Arrays;

/**
 * Created by User on 26.04.2017.
 */
class GetBihrams implements ActionListener {

    AffinitySubstitutionBihramCryptanalysis a = new AffinitySubstitutionBihramCryptanalysis();

    GetBihramsGUI parent;

    GetBihrams(GetBihramsGUI parent) {
        this.parent = parent;
    }

    public void actionPerformed(ActionEvent e) {

        try {
            String file = parent.getFilePath().replace("\\\\", "\\").replace("\\", "\\\\");
            File file1 = new File(file);
            if (!file1.exists()) {
                parent.setDisplayValue("");
                JOptionPane.showMessageDialog(null, "File doesn't exists!");
            } else {
                String[] str = a.getBihramFrequency(file);
                if (str[0].equals("")) {
                    parent.setDisplayValue("");
                    JOptionPane.showMessageDialog(null, "Wrong file encoding!");
                } else {
                    parent.setDisplayValue(Arrays.toString(a.getBihramFrequency(file)));
                }
            }
        } catch (Exception ex) {
            ex.getStackTrace();
        }
    }
}
