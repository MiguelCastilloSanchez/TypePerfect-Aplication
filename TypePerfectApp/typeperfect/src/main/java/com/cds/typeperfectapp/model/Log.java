package com.cds.typeperfectapp.model;


import java.util.Date;

/**
 *
 * @author Daniel Garcia
 */
public class Log {
    private int testNumber; 
    private Date dateAndTime; 
    private int wordCount; 
    private int testDuration; // Tiempo en segundos
    private int correctWords; 
    private int incorrectWords; 
    private String selectedHand; 
    private int wordsPerMinute;
    
    public Log(int testNumber, Date dateAndTime, int wordCount, int testDuration) {
        this.testNumber = testNumber;
        this.dateAndTime = dateAndTime;
        this.wordCount = wordCount;
        this.testDuration = testDuration;
    }

    public Log() {
        
    }

    public int getTestNumber() {
        return testNumber;
    }

    public void setTestNumber(int testNumber) {
        this.testNumber = testNumber;
    }

    public Date getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(Date dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public int getWordCount() {
        return wordCount;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    public int getTestDuration() {
        return testDuration;
    }

    public void setTestDuration(int testDuration) {
        this.testDuration = testDuration;
    }

    public int getCorrectWords() {
        return correctWords;
    }

    public void setCorrectWords(int correctWords) {
        this.correctWords = correctWords;
    }

    public int getIncorrectWords() {
        return incorrectWords;
    }

    public void setIncorrectWords(int incorrectWords) {
        this.incorrectWords = incorrectWords;
    }

    public String getSelectedHand() {
        return selectedHand;
    }

    public void setSelectedHand(String selectedHand) {
        this.selectedHand = selectedHand;
    }

    public int getWordsPerMinute() {
        return wordsPerMinute;
    }

    public void setWordsPerMinute(int wordsPerMinute) {
        this.wordsPerMinute = wordsPerMinute;
    }
    
}
