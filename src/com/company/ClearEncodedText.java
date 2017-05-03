package com.company;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by User on 25.04.2017.
 */
class ClearEncodedText implements ActionListener {

    EncodingDecodingOwnTextGUI parent;

    ClearEncodedText(EncodingDecodingOwnTextGUI parent) {
        this.parent = parent;
    }

    public void actionPerformed(ActionEvent e) {

        parent.setAreaValue("");
    }
}
