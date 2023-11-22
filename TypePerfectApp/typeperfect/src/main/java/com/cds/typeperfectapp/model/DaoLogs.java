package com.cds.typeperfectapp.model;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Daniel Garcia
 */
public class DaoLogs {
    
    private String filePath; 

    public DaoLogs(String filePath) {
        this.filePath = filePath;
    }

    public void saveLog(Log log) throws IOException {
        ArrayList<Log> logs = this.loadLogs();
        log.setTestNumber(createNewUniqueID());
        logs.add(log);
        
        try (FileWriter fileWriter = new FileWriter(filePath, false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            
            for(Log registro : logs){
                String logString = logToCsvString(registro);     
                bufferedWriter.write(logString);
                bufferedWriter.newLine();
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int createNewUniqueID() throws FileNotFoundException, IOException{
        ArrayList<Log> logs = this.loadLogs();
        ArrayList<Integer> idList = new ArrayList<>();

        for (Log log : logs) {
            idList.add(log.getTestNumber());
        }
        int newID = idList.get(idList.size()-1)+1;
        return newID;
    }

    public ArrayList<Log> loadLogs() throws FileNotFoundException, IOException {
        ArrayList<Log> logs = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {       
                Log log = logFromCsvString(line);
                logs.add(log);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return logs;
    }
    
    public Log findLogByTestNumber(int testNumber) throws IOException {
    ArrayList<Log> logs = this.loadLogs();
        for (Log log : logs) {
            if (log.getTestNumber() == testNumber) {
                return log; 
            }
        }
        return null; 
    }

    private String logToCsvString(Log log) {
       SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

       String testNumber = String.valueOf(log.getTestNumber());
       String dateAndTime = dateFormat.format(log.getDateAndTime());
       String wordCount = String.valueOf(log.getWordCount());
       String testDuration = String.valueOf(log.getTestDuration());
       String correctWords = String.valueOf(log.getCorrectWords());
       String incorrectWords = String.valueOf(log.getIncorrectWords());
       String selectedHand = log.getSelectedHand();
       String wordsPerMinute = String.valueOf(log.getWordsPerMinute());

       String logTxt = testNumber + ","
               + dateAndTime + ","
               + wordCount + ","
               + testDuration + ","
               + correctWords + ","
               + incorrectWords + ","
               + selectedHand + ","
               + wordsPerMinute;
       
       return logTxt;
   }

    private Log logFromCsvString(String csvString) {
        // Convierte una cadena de texto en formato CSV a un objeto Log
        String[] parts = csvString.split(",");
        Log log = new Log();
        
        log.setTestNumber(Integer.parseInt(parts[0]));
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = dateFormat.parse(parts[1]);
            log.setDateAndTime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        log.setWordCount(Integer.parseInt(parts[2]));
        log.setTestDuration(Integer.parseInt(parts[3])); 
        log.setCorrectWords(Integer.parseInt(parts[4]));
        log.setIncorrectWords(Integer.parseInt(parts[5]));
        log.setSelectedHand(parts[6]);
        log.setWordsPerMinute(Integer.parseInt(parts[7]));
        
        return log;
    }
    
}