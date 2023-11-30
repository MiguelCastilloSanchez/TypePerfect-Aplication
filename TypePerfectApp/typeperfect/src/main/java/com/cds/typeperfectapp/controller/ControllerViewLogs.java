package com.cds.typeperfectapp.controller;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
*/

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

import com.cds.typeperfectapp.model.DaoLogs;
import com.cds.typeperfectapp.model.Log;
import com.cds.typeperfectapp.views.ViewLogs;
import com.cds.typeperfectapp.views.ViewStart;

/**
 *
 * @author Daniel Garcia
 */
public class ControllerViewLogs implements ActionListener{
    
    private ViewLogs viewLog;
    private List<Log> testList;
    private DaoLogs daoLog;

    public ControllerViewLogs(ViewLogs viewLog) {
        this.viewLog = viewLog;
        this.visible();
        this.daoLog = new DaoLogs("src/main/resources/logs.txt"); 
        
        try {
            this.testList = this.daoLog.loadLogs();
            
            if(this.testList != null){
                this.updateTable(this.testList);
            }
        } catch (IOException ex) {
           System.out.println("Error en guardar en lista logs: Controlador");
        }
        this.viewLog.getButtonBack().addActionListener(this);
        this.viewLog.getjButtonSelectLog().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
       if(this.viewLog.getjButtonSelectLog() == event.getSource()){
           int testNumber = 0;
           int selectedRow = this.viewLog.getjTableLogTest().getSelectedRow();
           System.out.println(selectedRow);
             if (selectedRow != -1) {
                 Object value = this.viewLog.getjTableLogTest().getValueAt(selectedRow, 0);
                 if (value != null) {
                     testNumber = Integer.parseInt(value.toString());
                     Log selectedLog = null;
                     try {
                         selectedLog = this.daoLog.findLogByTestNumber(testNumber);
                     } catch (IOException ex) {
                         Logger.getLogger(ControllerViewLogs.class.getName()).log(Level.SEVERE, null, ex);
                     }
                     String wordCountString = String.valueOf(selectedLog.getWordCount());
                     String timeString = String.valueOf(selectedLog.getTestDuration());
                     String handSelectString = selectedLog.getSelectedHandString();
                     String languageSelectString = selectedLog.getLanguageString();
                     int percentCorrect;
                     try{
                        percentCorrect = (selectedLog.getCorrectWords() * 100) / selectedLog.getWordCount();
                     }catch(ArithmeticException exception){
                        percentCorrect = 0;
                     }
                     
                     int percentIncorrect = 100 - percentCorrect;
                     
                     this.viewLog.getjTextNumberWords().setText(wordCountString);
                     this.viewLog.getjTextTestTime().setText(timeString + " segundos");
                     this.viewLog.getjTextFieldHandSelect().setText(handSelectString);
                     this.viewLog.getjProgressBarRightWords().setValue(percentCorrect);
                     this.viewLog.getjProgressBarBadWords().setValue(percentIncorrect);
                     this.viewLog.getjTextFieldWordAccuracy().setText(String.valueOf(percentCorrect)); 
                     this.viewLog.getjTextFieldLanguage().setText(languageSelectString);
                }
            }
            this.updateTable(this.testList);
       }
       if (this.viewLog.getButtonBack() == event.getSource()){
            this.viewLog.dispose();
            ViewStart viewStart = new ViewStart();
            ControllerViewStart controllerViewStart = new ControllerViewStart(viewStart);
       }
       
    }
    
    public void visible(){
        this.viewLog.setVisible(true);
    }
    
    private void updateTable(List<Log> testList){
        DefaultTableModel tableModel = (DefaultTableModel) this.viewLog.getjTableLogTest().getModel();
        tableModel.setRowCount(0); // Borra todas las filas actuales

        for (Log log : testList) {
            // Agrega cada registro como una nueva fila en la tabla
            Object[] row = {
                log.getTestNumber(),
                log.getDateAndTime().toString(),
            };
            tableModel.addRow(row);
        }
    }
        
}

