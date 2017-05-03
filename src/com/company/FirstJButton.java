package com.company;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by User on 23.04.2017.
 */
class FirstJButton implements ActionListener {

    CryptoGUI parent;

    FirstJButton(CryptoGUI parent) {
        this.parent = parent;
    }

    public void actionPerformed(ActionEvent e) {
        GetBihramsGUI gbg = new GetBihramsGUI();
    }
}
