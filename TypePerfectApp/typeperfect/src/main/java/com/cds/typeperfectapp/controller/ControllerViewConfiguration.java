package com.cds.typeperfectapp.controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.cds.typeperfectapp.views.*;
import com.cds.typeperfectapp.model.*;

/**
 * La clase "ControllerViewConfiguration" maneja las acciones del usuario y
 * actualizar la vista "ViewConfiguration" en base a ellas.
 */
public class ControllerViewConfiguration implements ActionListener{
    private WordsReader modelWordsReader = new WordsReader();
    private ViewConfiguration viewConfiguration = new ViewConfiguration();
    private ControllerViewPractice controllerViewPractice;
    private ViewStart viewStart = new ViewStart();
    private ControllerViewStart controllerViewStart = new ControllerViewStart(viewStart);
    private Boolean allButtonsSelected = false;
    private Boolean englishRight = false;
    private Boolean spanishRight = false;
    private Boolean englishLeft = false;
    private Boolean spanishLeft = false;
    private Boolean englishBoth = false;
    private Boolean spanishBoth = false;
    private String filePath = "";

    /**
     * Constructor de la clase.
     */
    public ControllerViewConfiguration(WordsReader modelWordsReader, ViewConfiguration viewConfiguration){
        this.modelWordsReader = modelWordsReader;
        this.viewConfiguration = viewConfiguration;
        this.viewConfiguration.setVisible(true);
        this.viewConfiguration.getButtonBack().addActionListener(this);
        this.viewConfiguration.getButtonNext().addActionListener(this);
        this.viewConfiguration.getButton1Min().addActionListener(this);
        this.viewConfiguration.getButton30Seg().addActionListener(this);
        this.viewConfiguration.getButton5Min().addActionListener(this);
        this.viewConfiguration.getButtonBoth().addActionListener(this);
        this.viewConfiguration.getButtonLeft().addActionListener(this);
        this.viewConfiguration.getButtonRight().addActionListener(this);
        this.viewConfiguration.getbuttonEn().addActionListener(this);
        this.viewConfiguration.getbuttonEs().addActionListener(this);
        this.viewConfiguration.getButtonNext().setEnabled(false);
         
    }

    /**
     * La función "actionPerformed" maneja las acciones del usuario en la ventana.
     * 
     * @param event El parámetro es un objeto "ActionEvent" que desencadenó el
     *              método.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        checkSelection();
        // Si se guarda la configuración.
        if(e.getSource() == this.viewConfiguration.getButtonNext()){
            this.controllerViewStart.setFilePath(filePath);
            System.out.println("Se ha guardado la configuración");
        }
        // Si se regresa la vista anterior.
        if(e.getSource() == this.viewConfiguration.getButtonBack()){
            this.viewConfiguration.setVisible(false);
            this.viewConfiguration.dispose();
            this.viewStart.setVisible(true);
        }
    }

    /**
     * La función "checkSelection" habilita los botones.
     */
    public void checkSelection(){
          if(this.viewConfiguration.getGroupHands().getSelection() != null && this.viewConfiguration.getGroupLanguage().getSelection() != null && this.viewConfiguration.getGroupTime().getSelection() != null){
            allButtonsSelected = true;
            enableButtonNext();
            checkConfiguration();
        }
    }

    /**
     * La función "enableButtonNext" habilita el siguiente botón.
     */
    public void enableButtonNext(){
        if(allButtonsSelected == true){
            this.viewConfiguration.getButtonNext().setEnabled(true);
        }
    }

    /**
     * La función "checkConfiguration" modifica la configuración de la aplicación.
     */
    public void checkConfiguration(){
        if(this.viewConfiguration.getbuttonEn().isSelected() == true && this.viewConfiguration.getButtonBoth().isSelected() == true){
            this.englishBoth = true;
        }
        if(this.viewConfiguration.getbuttonEs().isSelected() == true && this.viewConfiguration.getButtonBoth().isSelected() == true){
            this.spanishBoth = true;
        }
        if(this.viewConfiguration.getbuttonEn().isSelected() == true && this.viewConfiguration.getButtonLeft().isSelected() == true){
            this.englishLeft = true;
        }
        if(this.viewConfiguration.getbuttonEs().isSelected() == true && this.viewConfiguration.getButtonLeft().isSelected() == true){
            this.spanishLeft = true;
        }
        if(this.viewConfiguration.getbuttonEn().isSelected() == true && this.viewConfiguration.getButtonRight().isSelected() == true){
            this.englishRight = true;
        }
        if(this.viewConfiguration.getbuttonEs().isSelected() == true && this.viewConfiguration.getButtonRight().isSelected() == true){
            this.spanishRight = true;
        }
        chooseWords();
    }

    /**
     * La función "chooseWords" elige un archivo para practicar.
     */
    public void chooseWords(){
        if(this.englishBoth == true){
            this.filePath = "src/main/resources/words/BothHandsEnglisht.txt";
        }
        if(this.spanishBoth == true){
            this.filePath = "src/main/resources/words/BothHands.txt";
        }
        if(this.englishLeft == true){
            this.filePath = "src/main/resources/words/LeftHandEnglish.txt";
        }
        if(this.spanishLeft == true){
            this.filePath = "src/main/resources/words/LeftHand.txt";
        }
        if(this.englishRight == true){
            this.filePath = "src/main/resources/words/RightHandEnglish.txt";
        }
        if(this.spanishRight == true){
            this.filePath = "src/main/resources/words/RightHand.txt";
        }
    }
}
