package com.cds.typeperfectapp.model;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardListener extends KeyAdapter {
    private boolean wasEnterPressed;

    public void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == keyEvent.VK_ENTER) {
            this.wasEnterPressed = true;
        }
    }

    public void resetWasEnterPressed() {
        this.wasEnterPressed = false;
    }

    public boolean getWasEnterPressed() {
        return this.wasEnterPressed;
    }

}
