package com.company;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by User on 24.04.2017.
 */
class SixthJButton implements ActionListener {

    CryptoGUI parent;

    SixthJButton(CryptoGUI parent) {
        this.parent = parent;
    }

    public void actionPerformed(ActionEvent e) {

        EncodingDecodingOwnTextGUI encodingDecodingOwnTextGUI = new EncodingDecodingOwnTextGUI();
    }
}
