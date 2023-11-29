package com.cds.typeperfectapp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Date;
import java.util.Random;
import com.cds.typeperfectapp.model.*;
import com.cds.typeperfectapp.views.*;
import javax.swing.Timer;

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
    private String handSelected;
    private int timeSelected;
    private Timer countdownTimer;
    private boolean isTimeFinished;
    private int remainingTime;
    private Timer remainingTimer;
    private int countDownTime;
    

    public ControllerViewPractice(ViewPractice viewPractice, KeyboardListener keyboardListener, String filePath, int countDownTime) {
        this.viewPractice = viewPractice;
        this.keyboardListener = keyboardListener;
        this.filepath = filePath;
        this.countDownTime = countDownTime;
        //Al timer se le da un tiempo adicional, esto para que el temporizador tenga tiempo para poder actualizarce a 00:00 una vez que termina la practica
        this.countdownTimer = new Timer(this.countDownTime + 350, this);
        this.countdownTimer.setRepeats(false);

        setActionListenerToButtons();
        setListenersToTextField();

        initializeView();

        viewPractice.setVisible(true);

        setListOfWords(filePath);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if(!countdownTimer.isRunning()){
            isTimeFinished = true;
        }

        if (viewPractice.getButtonStart() == event.getSource()) {
            totalWords = 0;
            correctWords = 0;
            viewPractice.getButtonStop().setVisible(true);
            viewPractice.getLabelWordBefore().setVisible(true);
            viewPractice.getLabelUserWordBefore().setVisible(true);

            this.countdownTimer.start();
            this.isTimeFinished = false;
            calculateRemainingTime(this.countDownTime);
            
                

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
            this.countdownTimer.stop();
            this.remainingTimer.stop();

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
        if(isTimeFinished && wasStartPressed){
            wasStartPressed = false;
            event.setSource(viewPractice.getButtonStop());
            this.actionPerformed(event);
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
        Log log = new Log(new Date(), totalWords, 60);
            log.setCorrectWords(correctWords);
            log.setIncorrectWords(totalWords-correctWords);
            log.setSelectedHand(this.handSelected);
        DaoLogs daoLogs = new DaoLogs("src/main/resources/logs.txt");
        try {
            daoLogs.saveLog(log);
            System.out.println("se creó un nuevo log");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getHandSelected() {
        return handSelected;
    }

    public void setHandSelected(String handSelected) {
        this.handSelected = handSelected;
    }

    public int getTimeSelected() {
        return timeSelected;
    }

    public void setTimeSelected(int timeSelected) {
        this.timeSelected = timeSelected;
    }

    //Todos los tiempos se manejan en milisegundos
    public void calculateRemainingTime(int miliSeconds) {
    remainingTime = miliSeconds;

    //Actualiza la etiqueta del temporizador inmediatamente, lo que evita que se muestre un segundo de retraso
    viewPractice.getLabelTimer().setText("Tiempo restante: " + convertTime(remainingTime));

    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (remainingTime <= 0) {
                ((Timer) e.getSource()).stop();
                viewPractice.getLabelTimer().setText("Tiempo restante: 00:00");
            } else {
                remainingTime -= 1000;
                viewPractice.getLabelTimer().setText("Tiempo restante: " + convertTime(remainingTime));
            }
        }
    };

    this.remainingTimer = new Timer(1000, actionListener);
    this.remainingTimer.start();
}


    public String convertTime(int miliSeconds) {
        int minutes = miliSeconds / 60000;
        int seconds = (miliSeconds % 60000) / 1000;
        return String.format("%02d:%02d", minutes, seconds);
    }
    
    

}
