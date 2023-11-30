/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cds.typeperfectapp.model;

/**
 *
 * @author Daniel Garcia
 */

public class Configuration {
    private String filePath;
    private Language language;
    private HandSelect handSelect;
    private int countDownTime;

    public Configuration() {
        this.filePath = "src/main/resources/words/BothHandsEnglish.txt";
        this.language = Language.ENGLISH;
        this.handSelect = handSelect.BOTH;
        this.countDownTime = 30;
    }

    public Configuration(Language language, HandSelect handSelect, int timeSelect) {
        this.language = language;
        this.handSelect = handSelect;
        this.countDownTime = timeSelect;
    }
    
    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    
    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public HandSelect getHandSelect() {
        return handSelect;
    }

    public void setHandSelect(HandSelect handSelect) {
        this.handSelect = handSelect;
    }
    
    public int getCountDownTime() {
        return countDownTime;
    }

    public void setCountDownTime(int timeSelect) {
        if(timeSelect > 0){
            this.countDownTime = timeSelect;
        }
        else{
            throw new IllegalArgumentException("El valor de timeSelect debe ser mayor que cero.");
        }
    }
    
}
