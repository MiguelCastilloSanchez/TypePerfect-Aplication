package com.cds.typeperfectapp.controller;

import com.cds.typeperfectapp.model.LogsReader;
import com.cds.typeperfectapp.views.ViewResults;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerViewResults implements ActionListener {
    private ViewResults viewLogs;
    private LogsReader logsReader = new LogsReader();
    private int totalWords = logsReader.getTotalWords();
    private int correctWords = logsReader.getCorrectWords();

    public ControllerViewResults(ViewResults viewLogs) {
        this.viewLogs = viewLogs;

        setActionListenerToButtons();

        initializeView();

        viewLogs.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (viewLogs.getButtonAccept() == event.getSource()) {
            this.viewLogs.dispose();
        }
    }

    private void setActionListenerToButtons() {
        this.viewLogs.getButtonAccept().addActionListener(this);
    }

    private void initializeView() {
        viewLogs.getLabelTotalWords().setText(String.valueOf(totalWords));
        viewLogs.getLabelCorrectWords().setText(String.valueOf(correctWords));
        viewLogs.getLabelPercentage().setText(String.valueOf(calculatePercentage()) + "%");
    }

    public double calculatePercentage() {
        if (totalWords != 0) {
            return (correctWords * 100) / totalWords;
        }
        return 0;
    }

}
