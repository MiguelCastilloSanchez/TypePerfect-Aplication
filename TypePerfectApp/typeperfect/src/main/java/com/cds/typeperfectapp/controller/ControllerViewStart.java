package com.cds.typeperfectapp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.cds.typeperfectapp.model.*;
import com.cds.typeperfectapp.views.*;

public class ControllerViewStart implements ActionListener {
    private ViewStart view;

    public ControllerViewStart(ViewStart view) {
        this.view = view;
        this.view.setVisible(true);
        setActionListenerToButtons();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (this.view.getButtonExit() == event.getSource()) {
            System.exit(0);
        }

        if (this.view.getButtonPractice() == event.getSource()) {
            this.view.dispose();
            ViewConfiguration viewConfiguration = new ViewConfiguration();
            WordsReader modelWordsReader = new WordsReader();
            ControllerViewConfiguration controllerViewConfiguration = new ControllerViewConfiguration(modelWordsReader,
                    viewConfiguration);
        }

        if (this.view.getButtonLogs() == event.getSource()) {
            this.view.dispose();
            ViewLogs viewLogs = new ViewLogs();
            ControllerViewLogs controllerViewLogs = new ControllerViewLogs(viewLogs);
        }
    }

    private void setActionListenerToButtons() {
        this.view.getButtonExit().addActionListener(this);
        this.view.getButtonPractice().addActionListener(this);
        this.view.getButtonLogs().addActionListener(this);
    }
}
