package com.company;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by User on 24.04.2017.
 */
class FourthJButton implements ActionListener {

    CryptoGUI parent;

    FourthJButton(CryptoGUI parent) {
        this.parent = parent;
    }

    public void actionPerformed(ActionEvent e) {

        ModularInverseGUI modularInverseGUI = new ModularInverseGUI();
    }
}
