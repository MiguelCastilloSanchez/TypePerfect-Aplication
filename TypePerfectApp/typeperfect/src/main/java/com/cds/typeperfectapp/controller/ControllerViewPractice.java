package com.cds.typeperfectapp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Date;
import java.util.Random;
import com.cds.typeperfectapp.model.*;
import com.cds.typeperfectapp.views.*;

public class ControllerViewPractice implements ActionListener {

    private ViewPractice viewPractice;
    private KeyboardListener keyboardListener;
    private boolean wasStartPressed = false;
    private String filepath;
    private Random random = new Random();
    private String[] listOfWords;
    private ResultsReader resultsReader = new ResultsReader();
    private int totalWords = 0;
    private int correctWords = 0;

    public ControllerViewPractice(ViewPractice viewPractice, KeyboardListener keyboardListener, String filePath) {
        this.viewPractice = viewPractice;
        this.keyboardListener = keyboardListener;
        this.filepath = filePath;
        setActionListenerToButtons();
        setListenersToTextField();

        initializeView();

        viewPractice.setVisible(true);

        setListOfWords(filePath);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (viewPractice.getButtonStart() == event.getSource()) {
            totalWords = 0;
            correctWords = 0;
            viewPractice.getButtonStop().setVisible(true);
            viewPractice.getLabelWordBefore().setVisible(true);
            viewPractice.getLabelUserWordBefore().setVisible(true);

            wasStartPressed = true;
            viewPractice.getFieldPractice().requestFocus();

            int indexNextWord = random.nextInt(listOfWords.length);
            viewPractice.getLabelWordActual().setText(listOfWords[indexNextWord]);
        }
        if (wasStartPressed) {
            this.viewPractice.getLabelWordActual().setVisible(true);
            enterPerformed(event);
        }
        if (viewPractice.getButtonStop() == event.getSource()) {
            wasStartPressed = false;
            viewPractice.getButtonStop().setVisible(false);
            viewPractice.getLabelWordActual().setText("");

            viewPractice.getLabelCorrectIcon().setVisible(false);
            viewPractice.getLabelIncorrectIcon().setVisible(false);
            viewPractice.getLabelWordBefore().setVisible(false);
            viewPractice.getLabelUserWordBefore().setVisible(false);

            createNewLog();
            resultsReader.updateResults(totalWords, correctWords);
            showResults();
        }
        if (viewPractice.getButtonMenu() == event.getSource()) {
            this.viewPractice.dispose();
            ViewStart view = new ViewStart();
            ControllerViewStart controller = new ControllerViewStart(view);

            resultsReader.updateResults(totalWords, correctWords);
        }
    }

    private void setActionListenerToButtons() {
        this.viewPractice.getButtonMenu().addActionListener(this);
        this.viewPractice.getButtonStart().addActionListener(this);
        this.viewPractice.getButtonStop().addActionListener(this);
    }

    private void setListenersToTextField() {
        this.viewPractice.getFieldPractice().addKeyListener(this.keyboardListener);
        this.viewPractice.getFieldPractice().addActionListener(this);
    }

    private void initializeView() {
        this.viewPractice.getLabelCorrectIcon().hide();
        this.viewPractice.getLabelIncorrectIcon().hide();
        this.viewPractice.getLabelWordBefore().hide();
        this.viewPractice.getLabelUserWordBefore().hide();
        this.viewPractice.getLabelWordActual().hide();
        this.viewPractice.getButtonStop().hide();
    }

    private void enterPerformed(ActionEvent event) {
        if (this.keyboardListener.getWasEnterPressed()) {
            String wordTyped = this.viewPractice.getFieldPractice().getText();
            String correctWord = this.viewPractice.getLabelWordActual().getText();

            viewPractice.getLabelCorrectIcon().setVisible(false);
            viewPractice.getLabelIncorrectIcon().setVisible(false);

            if (wordTyped.equals(correctWord)) {
                viewPractice.getLabelCorrectIcon().setVisible(true);
                correctWords++;
            } else {
                viewPractice.getLabelIncorrectIcon().setVisible(true);
            }

            viewPractice.getLabelWordBefore().setText(correctWord);
            viewPractice.getLabelWordBefore().setVisible(true);

            viewPractice.getLabelUserWordBefore().setText(wordTyped);
            viewPractice.getLabelUserWordBefore().setVisible(true);

            int indexNextWord = random.nextInt(listOfWords.length);
            totalWords++;
            viewPractice.getLabelWordActual().setText(listOfWords[indexNextWord]);
            viewPractice.getFieldPractice().setText("");
            keyboardListener.resetWasEnterPressed();
        }
    }

    private void setListOfWords(String filePath) {
        WordsReader listOfWordsToUse = new WordsReader();
        this.listOfWords = listOfWordsToUse.getWords(filePath);
    }

    private void showResults() {
        ViewResults viewLogs = new ViewResults();
        ControllerViewResults controllerViewResults = new ControllerViewResults(viewLogs);
    }

    private void createNewLog(){
        Log log = new Log(1, new Date(), totalWords, 60);
            log.setCorrectWords(correctWords);
            log.setIncorrectWords(totalWords-correctWords);
            log.setSelectedHand(this.filepath);
        DaoLogs daoLogs = new DaoLogs("src/main/resources/logs.txt");
        try {
            daoLogs.saveLog(log);
            System.out.println("se creó un nuevo log");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
