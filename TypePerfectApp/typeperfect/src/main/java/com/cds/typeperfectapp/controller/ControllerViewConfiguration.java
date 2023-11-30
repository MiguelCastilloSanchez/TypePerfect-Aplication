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
    private Configuration configuration;

    public ControllerViewConfiguration(WordsReader modelWordsReader, ViewConfiguration viewConfiguration){
        this.modelWordsReader = modelWordsReader;
        this.viewConfiguration = viewConfiguration;
        this.configuration = new Configuration();
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
            ControllerViewPractice controllerViewPractice = new ControllerViewPractice(viewPractice, keyboardListener, this.configuration);
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
            this.configuration.setHandSelect(HandSelect.BOTH);
            this.configuration.setLanguage(Language.ENGLISH);
        }
        if(this.viewConfiguration.getbuttonEs().isSelected() == true && this.viewConfiguration.getButtonBoth().isSelected() == true){
            this.configuration.setHandSelect(HandSelect.BOTH);
            this.configuration.setLanguage(Language.SPANISH);
        }
        if(this.viewConfiguration.getbuttonEn().isSelected() == true && this.viewConfiguration.getButtonLeft().isSelected() == true){
            this.configuration.setHandSelect(HandSelect.LEFT);
            this.configuration.setLanguage(Language.ENGLISH);
        }
        if(this.viewConfiguration.getbuttonEs().isSelected() == true && this.viewConfiguration.getButtonLeft().isSelected() == true){
            this.configuration.setHandSelect(HandSelect.LEFT);
            this.configuration.setLanguage(Language.SPANISH);
        }
        if(this.viewConfiguration.getbuttonEn().isSelected() == true && this.viewConfiguration.getButtonRight().isSelected() == true){
            this.configuration.setHandSelect(HandSelect.RIGHT);
            this.configuration.setLanguage(Language.ENGLISH);
        }
        if(this.viewConfiguration.getbuttonEs().isSelected() == true && this.viewConfiguration.getButtonRight().isSelected() == true){
            this.configuration.setHandSelect(HandSelect.RIGHT);
            this.configuration.setLanguage(Language.SPANISH);
        }
        chooseWords();

    }

    private void chooseWords(){
        switch (this.configuration.getLanguage()){
            case ENGLISH:
                switch(this.configuration.getHandSelect()){
                    case BOTH:
                         this.configuration.setFilePath("src/main/resources/words/BothHandsEnglish.txt");
                    break;
                    case LEFT:
                        this.configuration.setFilePath("src/main/resources/words/LeftHandEnglish.txt");
                    break;
                    case RIGHT:
                        this.configuration.setFilePath("src/main/resources/words/RightHandEnglish.txt");
                    break;
                }
                break;
            case SPANISH:
                switch(this.configuration.getHandSelect()){
                    case BOTH:
                         this.configuration.setFilePath("src/main/resources/words/BothHands.txt");
                    break;
                    case LEFT:
                        this.configuration.setFilePath("src/main/resources/words/LeftHand.txt");
                    break;
                    case RIGHT:
                        this.configuration.setFilePath("src/main/resources/words/RightHand.txt");
                    break;
                }
                break;
        }
    }

    private void chooseTime(){
        int thousand = 1000;
        if(this.viewConfiguration.getButton30Seg().isSelected())
            this.configuration.setCountDownTime(30 * thousand);
        
        if(this.viewConfiguration.getButton1Min().isSelected())
            this.configuration.setCountDownTime(60 * thousand);

        if(this.viewConfiguration.getButton5Min().isSelected())
            this.configuration.setCountDownTime(300 * thousand);
    }
}
