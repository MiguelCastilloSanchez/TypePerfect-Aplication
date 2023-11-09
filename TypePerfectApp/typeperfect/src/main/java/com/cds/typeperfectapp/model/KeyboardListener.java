package com.cds.typeperfectapp.model;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * La clase "KeyboardListener" vigila si se presionó
 * la tecla Enter.
 */
public class KeyboardListener extends KeyAdapter{
    private boolean wasEnterPressed;  

    /**
     * La función "keyPressed" establece si se presionó la tecla "Enter"
     * 
     * @param keyEvent El parámetro es un objeto "KeyEvent" que representa
     *                 la tecla presionada
     */
    public void keyPressed(KeyEvent keyEvent){
        // Si se presionó la tecla "Enter"
        if(keyEvent.getKeyCode() == keyEvent.VK_ENTER){
            this.wasEnterPressed = true;
        }
    }

    /**
     * Establece que no se presión la tecla "Enter".
     */
    public void resetWasEnterPressed(){
        this.wasEnterPressed = false;
    }

    /**
     * La función "getWasEnterPressed" dice si se presionó o no la tecla "Enter".
     * 
     * @return la función regresa el valor de "wasEnterPressed".
     */
    public boolean getWasEnterPressed(){
        return this.wasEnterPressed;
    }

}
