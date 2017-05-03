package com.company;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by User on 24.04.2017.
 */
class SecondJButton  implements ActionListener {

    CryptoGUI parent;

    SecondJButton(CryptoGUI parent) {
        this.parent = parent;
    }

    public void actionPerformed(ActionEvent e) {

        SimpleEuclideanAlgorythmGUI s = new SimpleEuclideanAlgorythmGUI();
    }
}
