package com.company;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by User on 25.04.2017.
 */
class ClearDecodedText implements ActionListener {

    EncodingDecodingOwnTextGUI parent;

    ClearDecodedText(EncodingDecodingOwnTextGUI parent) {
        this.parent = parent;
    }

    public void actionPerformed(ActionEvent e) {

        parent.setArea1Value("");
    }
}
