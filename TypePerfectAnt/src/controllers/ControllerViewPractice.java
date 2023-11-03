/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.*;

/**
 *
 * @author Miguel
 */
public class ControllerViewPractice implements ActionListener{
    private ViewPractice viewPractice;
    
    public ControllerViewPractice(ViewPractice viewPractice){
       this.viewPractice = viewPractice; 
       
       setActionListenerToButtons();
       
       initializeView();
       
       viewPractice.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
    }
    
    private void setActionListenerToButtons(){
        this.viewPractice.getButtonMenu().addActionListener(this);
        this.viewPractice.getButtonStart().addActionListener(this);
        this.viewPractice.getButtonStop().addActionListener(this);
    }
    
    private void initializeView(){
        this.viewPractice.getLabelCorrectIcon().hide();
        this.viewPractice.getLabelIncorrectIcon().hide();
        this.viewPractice.getLabelWordBefore().hide();
        this.viewPractice.getLabelUserWordBefore().hide();
        this.viewPractice.getLabelWordActual().hide();
        this.viewPractice.getButtonStop().hide();
    }
}
