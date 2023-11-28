package com.cds.typeperfectapp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.cds.typeperfectapp.views.*;
import com.cds.typeperfectapp.model.*;

import javax.swing.Timer;

public class ControllerViewConfiguration implements ActionListener{
    private WordsReader modelWordsReader = new WordsReader();
    private ViewConfiguration viewConfiguration = new ViewConfiguration();
    private Boolean allButtonsSelected = false;
    private Boolean englishRight = false;
    private Boolean spanishRight = false;
    private Boolean englishLeft = false;
    private Boolean spanishLeft = false;
    private Boolean englishBoth = false;
    private Boolean spanishBoth = false;
    private String filePath = "";
    private String handSelected;
    private int timeSelected;

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
           
            
            KeyboardListener keyboardListener = new KeyboardListener();
            ViewPractice viewPractice = new ViewPractice(); 
            ControllerViewPractice controllerViewPractice = new ControllerViewPractice(viewPractice, keyboardListener, filePath, this.timeSelected);
            this.viewConfiguration.setVisible(false);
            this.viewConfiguration.dispose();
            viewPractice.setVisible(true);
           
        }
        if(e.getSource() == this.viewConfiguration.getButtonBack()){
            this.viewConfiguration.setVisible(false);
            this.viewConfiguration.dispose();
            ViewStart viewStart = new ViewStart();
            ControllerViewStart controllerViewStart = new ControllerViewStart(viewStart);
        }
    }

    private void checkSelection(){
          if(this.viewConfiguration.getGroupHands().getSelection() != null && this.viewConfiguration.getGroupLanguage().getSelection() != null && this.viewConfiguration.getGroupTime().getSelection() != null){
            allButtonsSelected = true;
            enableButtonNext();
            checkConfiguration();
            chooseTime();
        }
    }

    private void enableButtonNext(){
        if(allButtonsSelected == true){
            this.viewConfiguration.getButtonNext().setEnabled(true);
        }
    }

    private void checkConfiguration(){
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

    private void chooseWords(){
        if(this.englishBoth == true){
            this.filePath = "src/main/resources/words/BothHandsEnglish.txt";
            this.handSelected = "Ambas Manos";
            
        }
        if(this.spanishBoth == true){
            this.filePath = "src/main/resources/words/BothHands.txt";
            this.handSelected = "Ambas Manos";
        }
        if(this.englishLeft == true){
            this.filePath = "src/main/resources/words/LeftHandEnglish.txt";
            this.handSelected = "Mano Izquierda";
        }
        if(this.spanishLeft == true){
            this.filePath = "src/main/resources/words/LeftHand.txt";
            this.handSelected = "Mano Izquierda";
        }
        if(this.englishRight == true){
            this.filePath = "src/main/resources/words/RightHandEnglish.txt";
             this.handSelected = "Mano Derecha";
        }
        if(this.spanishRight == true){
            this.filePath = "src/main/resources/words/RightHand.txt";
            this.handSelected = "Mano Derecha";
        }
    }

    private void chooseTime(){
        int thousand = 1000;
        if(this.viewConfiguration.getButton30Seg().isSelected())
            this.timeSelected = 30 * thousand;
        
        if(this.viewConfiguration.getButton1Min().isSelected())
            this.timeSelected = 60 * thousand;

        if(this.viewConfiguration.getButton5Min().isSelected())
            this.timeSelected = 300 * thousand;
    }
}
