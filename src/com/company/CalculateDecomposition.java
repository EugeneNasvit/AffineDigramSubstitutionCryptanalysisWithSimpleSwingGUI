package com.company;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by User on 24.04.2017.
 */
class CalculateDecomposition implements ActionListener {

    private AffinitySubstitutionBihramCryptanalysis affinitySubstitutionBihramCryptanalysis = new AffinitySubstitutionBihramCryptanalysis();

    ExtendedEAGUI parent;

    CalculateDecomposition(ExtendedEAGUI parent) {
        this.parent = parent;
    }

    public void actionPerformed(ActionEvent e) {

        int a = Integer.parseInt(parent.getFirstNumber());
        int b = Integer.parseInt(parent.getSecondNumber());

        parent.setDisplayValue(affinitySubstitutionBihramCryptanalysis.useExtendedEA(a,b));
    }
}
