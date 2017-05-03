package com.company;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by User on 24.04.2017.
 */
class ThirdJButton implements ActionListener {

    CryptoGUI parent;

    ThirdJButton(CryptoGUI parent) {
        this.parent = parent;
    }

    public void actionPerformed(ActionEvent e) {

        ExtendedEAGUI extendedEAGUI = new ExtendedEAGUI();
    }
}
