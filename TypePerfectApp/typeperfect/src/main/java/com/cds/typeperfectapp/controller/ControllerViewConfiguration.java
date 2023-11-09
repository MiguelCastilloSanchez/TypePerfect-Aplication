package com.cds.typeperfectapp.controller;
import java.util.EventListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.cds.typeperfectapp.views.*;
import com.cds.typeperfectapp.model.*;

public class ControllerViewConfiguration implements ActionListener{
    WordsReader modelWordsReader = new WordsReader();
    ViewConfiguration viewConfiguration = new ViewConfiguration();
    ControllerViewPractice controllerViewPractice;
    ViewStart viewStart = new ViewStart();
    ControllerViewStart controllerViewStart = new ControllerViewStart(viewStart);
    Boolean allButtonsSelected = false;
    Boolean englishRight = false;
    Boolean spanishRight = false;
    Boolean englishLeft = false;
    Boolean spanishLeft = false;
    Boolean englishBoth = false;
    Boolean spanishBoth = false;
    String filePath = "";

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

    @Override
    public void actionPerformed(ActionEvent e) {
        checkSelection();
        if(e.getSource() == this.viewConfiguration.getButtonNext()){
            this.controllerViewStart.setFilePath(filePath);
            System.out.println("Se ha guardado la configuaracion");
        }
        if(e.getSource() == this.viewConfiguration.getButtonBack()){
            this.viewConfiguration.setVisible(false);
            this.viewConfiguration.dispose();
            this.viewStart.setVisible(true);
        }
    }

    public void checkSelection(){
          if(this.viewConfiguration.getGroupHands().getSelection() != null && this.viewConfiguration.getGroupLanguage().getSelection() != null && this.viewConfiguration.getGroupTime().getSelection() != null){
            allButtonsSelected = true;
            enableButtonNext();
            checkConfiguration();
        }
    }

    public void enableButtonNext(){
        if(allButtonsSelected == true){
            this.viewConfiguration.getButtonNext().setEnabled(true);
        }
    }

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