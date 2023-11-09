/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cds.typeperfectapp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.cds.typeperfectapp.model.*;
import com.cds.typeperfectapp.views.*;

/**
 *
 * @author Miguel
 */
/**
 * La clase "ControllerViewStart" maneja las acciones del usuario y
 * actualizar la vista "ViewStart" en base a ellas.
 */
public class ControllerViewStart implements ActionListener{
    private ViewStart view;
    private String filePath = "";

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
    public void actionPerformed(ActionEvent event){
        // Si se elige salir de la aplicación
        if(this.view.getButtonExit() == event.getSource()){
            System.exit(0);
        }
        // Si se elige practicar
        else if(this.view.getButtonPractice() == event.getSource()){
            this.view.dispose();
            ViewPractice viewPractice = new ViewPractice();
            KeyboardListener keyboardListener = new KeyboardListener();
            ControllerViewPractice controllerViewPractice = new ControllerViewPractice(viewPractice, keyboardListener,filePath);
        }
        // Si se elige configurar la aplicación
        else if(this.view.getButtonConfig()== event.getSource()){
            this.view.dispose();
            ViewConfiguration viewConfiguration = new ViewConfiguration();
            WordsReader modelWordsReader = new WordsReader();
            ControllerViewConfiguration controllerViewConfiguration = new ControllerViewConfiguration(modelWordsReader,viewConfiguration);
        }
        // Si se elige ver los registros
        else if(this.view.getButtonLogs() == event.getSource()){
            
        }
    }
        
    /**
     * Inicializa la vista de inicio.
     */
    private void initializeView(){
        this.view.getButtonExit().addActionListener(this);
        this.view.getButtonPractice().addActionListener(this);
        this.view.getButtonConfig().addActionListener(this);
        this.view.getButtonLogs().addActionListener(this);
    }

    /**
     * Añade una dirección de archivo
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
