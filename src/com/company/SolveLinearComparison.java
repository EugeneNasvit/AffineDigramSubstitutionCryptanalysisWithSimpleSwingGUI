package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

/**
 * Created by User on 24.04.2017.
 */
class SolveLinearComparison implements ActionListener {

    private AffinitySubstitutionBihramCryptanalysis affinitySubstitutionBihramCryptanalysis = new AffinitySubstitutionBihramCryptanalysis();

    LinearComparisonGUI parent;

    SolveLinearComparison(LinearComparisonGUI parent) {
        this.parent = parent;
    }

    public void actionPerformed(ActionEvent e) {

        int a = Integer.parseInt(parent.getFirstNumber());
        int b = Integer.parseInt(parent.getSecondNumber());
        int mod = Integer.parseInt(parent.getModule());

        String solutions = Arrays.toString(affinitySubstitutionBihramCryptanalysis.solveLinearComparison(a, b, mod));

        if (solutions.equals("[]")) {
            parent.setDisplayValue("");
            JOptionPane.showMessageDialog(null, "Comparison has no solutions!");
        } else {
            parent.setDisplayValue(solutions);
        }
    }
}
