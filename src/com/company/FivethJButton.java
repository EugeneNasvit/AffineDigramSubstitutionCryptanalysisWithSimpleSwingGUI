package com.company;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by User on 24.04.2017.
 */
class FivethJButton implements ActionListener {

    CryptoGUI parent;

    FivethJButton(CryptoGUI parent) {
        this.parent = parent;
    }

    public void actionPerformed(ActionEvent e) {

        LinearComparisonGUI linearComparisonGUI = new LinearComparisonGUI();
    }
}
