package com.cds.typeperfectapp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.cds.typeperfectapp.views.*;
import com.cds.typeperfectapp.model.*;

public class ControllerViewConfiguration implements ActionListener {
    private WordsReader modelWordsReader = new WordsReader();
    private ViewConfiguration viewConfiguration = new ViewConfiguration();
    private Boolean allButtonsSelected = false;
    private Configuration configuration = new Configuration();;

    public ControllerViewConfiguration(WordsReader modelWordsReader, ViewConfiguration viewConfiguration) {
        this.modelWordsReader = modelWordsReader;
        this.viewConfiguration = viewConfiguration;

        setActionListenerToButtons();

        this.viewConfiguration.getButtonNext().setEnabled(false);
        this.viewConfiguration.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        checkSelection();
        if (e.getSource() == this.viewConfiguration.getButtonNext()) {
            KeyboardListener keyboardListener = new KeyboardListener();
            ViewPractice viewPractice = new ViewPractice();
            ControllerViewPractice controllerViewPractice = new ControllerViewPractice(viewPractice, keyboardListener,
                    this.configuration);
            this.viewConfiguration.setVisible(false);
            this.viewConfiguration.dispose();
            viewPractice.setVisible(true);

        }
        if (e.getSource() == this.viewConfiguration.getButtonBack()) {
            this.viewConfiguration.setVisible(false);
            this.viewConfiguration.dispose();
            ViewStart viewStart = new ViewStart();
            ControllerViewStart controllerViewStart = new ControllerViewStart(viewStart);
        }
    }

    private void setActionListenerToButtons() {
        this.viewConfiguration.getButtonBack().addActionListener(this);
        this.viewConfiguration.getButtonNext().addActionListener(this);
        this.viewConfiguration.getButton1Min().addActionListener(this);
        this.viewConfiguration.getButton30Seg().addActionListener(this);
        this.viewConfiguration.getButton5Min().addActionListener(this);
        this.viewConfiguration.getButtonBoth().addActionListener(this);
        this.viewConfiguration.getButtonLeft().addActionListener(this);
        this.viewConfiguration.getButtonRight().addActionListener(this);
        this.viewConfiguration.getbuttonEn().addActionListener(this);
        this.viewConfiguration.getbuttonEs().addActionListener(this);
    }

    private void checkSelection() {
        boolean buttonHandsIsSelected = this.viewConfiguration.getGroupHands().getSelection() != null;
        boolean buttonLanguageIsSelected = this.viewConfiguration.getGroupLanguage().getSelection() != null;
        boolean buttonTimeIsSelected = this.viewConfiguration.getGroupTime().getSelection() != null;

        if (buttonHandsIsSelected && buttonLanguageIsSelected && buttonTimeIsSelected) {
            allButtonsSelected = true;
            enableButtonNext();
            checkConfiguration();
            chooseTime();
        }
    }

    private void enableButtonNext() {
        if (allButtonsSelected == true) {
            this.viewConfiguration.getButtonNext().setEnabled(true);
        }
    }

    private void checkConfiguration() {
        HandSelect handSelect = HandSelect.LEFT;
        Language languageSelect;

        if (this.viewConfiguration.getbuttonEn().isSelected() == true) {
            languageSelect = Language.ENGLISH;
        } else {
            languageSelect = Language.SPANISH;
        }

        if (this.viewConfiguration.getButtonBoth().isSelected() == true) handSelect = HandSelect.BOTH;
        if (this.viewConfiguration.getButtonLeft().isSelected() == true) handSelect = HandSelect.LEFT;
        if (this.viewConfiguration.getButtonRight().isSelected() == true) handSelect = HandSelect.RIGHT;

        setConfiguration(handSelect, languageSelect);

        chooseWords();
    }

    public void setConfiguration(HandSelect handSelect, Language language) {
        this.configuration.setHandSelect(handSelect);
        this.configuration.setLanguage(language);
    }

    private void chooseWords() {
        switch (this.configuration.getLanguage()) {
            case ENGLISH:
                switch (this.configuration.getHandSelect()) {
                    case BOTH:
                        this.configuration.setFilePath("src/main/resources/words/BothHandsEnglish.txt");
                        break;
                    case LEFT:
                        this.configuration.setFilePath("src/main/resources/words/LeftHandEnglish.txt");
                        break;
                    case RIGHT:
                        this.configuration.setFilePath("src/main/resources/words/RightHandEnglish.txt");
                        break;
                }
                break;
            case SPANISH:
                switch (this.configuration.getHandSelect()) {
                    case BOTH:
                        this.configuration.setFilePath("src/main/resources/words/BothHands.txt");
                        break;
                    case LEFT:
                        this.configuration.setFilePath("src/main/resources/words/LeftHand.txt");
                        break;
                    case RIGHT:
                        this.configuration.setFilePath("src/main/resources/words/RightHand.txt");
                        break;
                }
                break;
        }
    }

    private void chooseTime() {
        int thousand = 1000;
        if (this.viewConfiguration.getButton30Seg().isSelected())
            this.configuration.setCountDownTime(30 * thousand);

        if (this.viewConfiguration.getButton1Min().isSelected())
            this.configuration.setCountDownTime(60 * thousand);

        if (this.viewConfiguration.getButton5Min().isSelected())
            this.configuration.setCountDownTime(300 * thousand);
    }
}
