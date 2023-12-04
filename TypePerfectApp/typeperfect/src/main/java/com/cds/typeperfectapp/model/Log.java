package com.cds.typeperfectapp.model;

import java.util.Date;

public class Log {
    private int testNumber;
    private Date dateAndTime;
    private int wordCount;
    private int testDuration;
    private int correctWords;
    private int incorrectWords;
    private HandSelect selectedHand;
    private Language language;

    public Log() {
        this.dateAndTime = new Date();
    }

    public int getTestNumber() {
        return testNumber;
    }

    public void setTestNumber(int testNumber) {
        this.testNumber = testNumber;
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

    public String getSelectedHandString() {
        return selectedHand.toString();
    }

    public void setSelectedHand(HandSelect selectedHand) {
        this.selectedHand = selectedHand;
    }

    public String getLanguageString() {
        return language.toString();
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Date getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(Date dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

}
