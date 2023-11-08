/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import domain.KeyboardListener;
import domain.WordsReader;
import views.*;

/**
 *
 * @author Miguel
 */
/**
 * La clase "ControllerViewPractice" maneja las acciones del usuario y
 * actualizar la vista "ViewPractice" en base a ellas.
 */
public class ControllerViewPractice implements ActionListener {
    private ViewPractice viewPractice;
    private KeyboardListener keyboardListener;
    private boolean wasStartPressed = false;
    private Random random = new Random();
    private String[] listOfWords;

    /**
     * Constructor de la clase.
     */
    public ControllerViewPractice(ViewPractice viewPractice, KeyboardListener keyboardListener) {
        this.viewPractice = viewPractice;
        this.keyboardListener = keyboardListener;

        setActionListenerToButtons();
        setListenersToTextField();

        initializeView();

        viewPractice.setVisible(true);

        setListOfWords();
    }

    /**
     * La función "actionPerformed" maneja las acciones del usuario en la ventana.
     * 
     * @param event El parámetro es un objeto "ActionEvent" que desencadenó el
     *              método.
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        // Si se elige iniciar la prueba
        if (viewPractice.getButtonStart() == event.getSource()) {
            viewPractice.getButtonStop().setVisible(true);
            viewPractice.getLabelWordBefore().setVisible(true);
            viewPractice.getLabelUserWordBefore().setVisible(true);

            wasStartPressed = true;
            viewPractice.getFieldPractice().requestFocus();

            int indexNextWord = random.nextInt(listOfWords.length);
            viewPractice.getLabelWordActual().setText(listOfWords[indexNextWord]);
        }
        // Si se ha iniciado la prueba
        if (wasStartPressed) {
            this.viewPractice.getLabelWordActual().setVisible(true);
            enterPerformed(event);
        }
        // Si se elige parar la prueba
        if (viewPractice.getButtonStop() == event.getSource()) {
            wasStartPressed = false;
            viewPractice.getButtonStop().setVisible(false);
            viewPractice.getLabelWordActual().setText("");

            viewPractice.getLabelCorrectIcon().setVisible(false);
            viewPractice.getLabelIncorrectIcon().setVisible(false);
            viewPractice.getLabelWordBefore().setVisible(false);
            viewPractice.getLabelUserWordBefore().setVisible(false);
        }
        // Si se elige ver el menú
        if (viewPractice.getButtonMenu() == event.getSource()) {
            this.viewPractice.dispose();
            ViewStart view = new ViewStart();
            ControllerViewStart controller = new ControllerViewStart(view);
        }
    }

    /**
     * Añadé a cada botón un ActionListener.
     */
    private void setActionListenerToButtons() {
        this.viewPractice.getButtonMenu().addActionListener(this);
        this.viewPractice.getButtonStart().addActionListener(this);
        this.viewPractice.getButtonStop().addActionListener(this);
    }

    /**
     * Añadé a cada campo de texto un ActionListener.
     */
    private void setListenersToTextField() {
        this.viewPractice.getFieldPractice().addKeyListener(this.keyboardListener);
        this.viewPractice.getFieldPractice().addActionListener(this);
    }

    /**
     * Inicializa la vista de la práctica.
     */
    private void initializeView() {
        this.viewPractice.getLabelCorrectIcon().hide();
        this.viewPractice.getLabelIncorrectIcon().hide();
        this.viewPractice.getLabelWordBefore().hide();
        this.viewPractice.getLabelUserWordBefore().hide();
        this.viewPractice.getLabelWordActual().hide();
        this.viewPractice.getButtonStop().hide();
    }

    /**
     * La función "enterPerformed" actualiza la interfaz con respecto a la respuesta
     * del usuario.
     * 
     * @param event El parámetro es un objeto "ActionEvent" que desencadenó el
     *              método.
     */
    private void enterPerformed(ActionEvent event) {
        if (this.keyboardListener.getWasEnterPressed()) {
            String wordTyped = this.viewPractice.getFieldPractice().getText();
            String correctWord = this.viewPractice.getLabelWordActual().getText();

            viewPractice.getLabelCorrectIcon().setVisible(false);
            viewPractice.getLabelIncorrectIcon().setVisible(false);

            if (wordTyped.equals(correctWord)) {
                viewPractice.getLabelCorrectIcon().setVisible(true);
            } else {
                viewPractice.getLabelIncorrectIcon().setVisible(true);
            }

            viewPractice.getLabelWordBefore().setText(correctWord);
            viewPractice.getLabelWordBefore().setVisible(true);

            viewPractice.getLabelUserWordBefore().setText(wordTyped);
            viewPractice.getLabelUserWordBefore().setVisible(true);

            int indexNextWord = random.nextInt(listOfWords.length);
            viewPractice.getLabelWordActual().setText(listOfWords[indexNextWord]);
            viewPractice.getFieldPractice().setText("");
            keyboardListener.resetWasEnterPressed();
        }
    }

    /**
     * Inicializa la lista de palabras
     */
    private void setListOfWords() {
        WordsReader listOfWordsToUse = new WordsReader();
        this.listOfWords = listOfWordsToUse.getWords("TypePerfectAnt/words/BothHands.txt");
    }
}
