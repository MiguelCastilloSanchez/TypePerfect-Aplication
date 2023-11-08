/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import domain.KeyboardListener;
import views.ViewPractice;
import views.ViewStart;

/**
 *
 * @author Miguel
 */
/**
 * La clase "ControllerViewStart" maneja las acciones del usuario y
 * actualizar la vista "ViewStart" en base a ellas.
 */
public class ControllerViewStart implements ActionListener {
    private ViewStart view;

    /**
     * Constructor de la clase.
     */
    public ControllerViewStart(ViewStart view) {
        this.view = view;
        this.view.setVisible(true);
        initializeView();
    }

    /**
     * La función "actionPerformed" abre y cierra ventanas para el usuario.
     * 
     * @param event El parámetro es un objeto "ActionEvent" que desencadenó el
     *              método.
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        // Si se elige salir de la aplicación
        if (this.view.getButtonExit() == event.getSource()) {
            System.exit(0);
        }
        // Si se elige practicar
        else if (this.view.getButtonPractice() == event.getSource()) {
            this.view.dispose();
            ViewPractice viewPractice = new ViewPractice();
            KeyboardListener keyboardListener = new KeyboardListener();
            ControllerViewPractice controllerViewPractice = new ControllerViewPractice(viewPractice, keyboardListener);
        }
        // Si se elige configurar la aplicación
        else if (this.view.getButtonConfig() == event.getSource()) {

        }
        // Si se elige ver los registros
        else if (this.view.getButtonLogs() == event.getSource()) {

        }
    }

    /**
     * Inicializa la vista de la inicio.
     */
    private void initializeView() {
        this.view.getButtonExit().addActionListener(this);
        this.view.getButtonPractice().addActionListener(this);
        this.view.getButtonConfig().addActionListener(this);
        this.view.getButtonLogs().addActionListener(this);
    }
}
