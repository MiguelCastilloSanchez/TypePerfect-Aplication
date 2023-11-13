
package com.cds.typeperfectapp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.cds.typeperfectapp.model.*;
import com.cds.typeperfectapp.views.*;


public class ControllerViewStart implements ActionListener{
    private ViewStart view;
    private String filePath = "";

    public ControllerViewStart(ViewStart view) {
        this.view = view;
        this.view.setVisible(true);
        initializeView();
    }
    
    @Override
    public void actionPerformed(ActionEvent event){
        if(this.view.getButtonExit() == event.getSource()){
            System.exit(0);
        }else if(this.view.getButtonPractice() == event.getSource()){
            this.view.dispose();
            ViewPractice viewPractice = new ViewPractice();
            KeyboardListener keyboardListener = new KeyboardListener();
            ControllerViewPractice controllerViewPractice = new ControllerViewPractice(viewPractice, keyboardListener,filePath);
        }else if(this.view.getButtonConfig()== event.getSource()){
            this.view.dispose();
            ViewConfiguration viewConfiguration = new ViewConfiguration();
            WordsReader modelWordsReader = new WordsReader();
            ControllerViewConfiguration controllerViewConfiguration = new ControllerViewConfiguration(modelWordsReader,viewConfiguration);

            
        }else if(this.view.getButtonLogs() == event.getSource()){
            
        }
    }
    
    private void initializeView(){
        this.view.getButtonExit().addActionListener(this);
        this.view.getButtonPractice().addActionListener(this);
        this.view.getButtonConfig().addActionListener(this);
        this.view.getButtonLogs().addActionListener(this);
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
