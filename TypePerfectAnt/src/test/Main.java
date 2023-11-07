/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

import controllers.ControllerViewPractice;
import domain.KeyboardListener;
import views.*;

/**
 *
 * @author Miguel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ViewPractice viewPractice = new ViewPractice();
        KeyboardListener keyboardListener = new KeyboardListener();
        ControllerViewPractice controllerViewPractice = new ControllerViewPractice(viewPractice, keyboardListener);
    } 
}
