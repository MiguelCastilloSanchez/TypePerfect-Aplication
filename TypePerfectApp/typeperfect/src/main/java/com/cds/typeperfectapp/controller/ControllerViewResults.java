package com.cds.typeperfectapp.controller;

import com.cds.typeperfectapp.model.ResultsReader;
import com.cds.typeperfectapp.views.ViewResults;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerViewResults implements ActionListener {
    private ViewResults viewResults;
    private ResultsReader resultsReader = new ResultsReader();
    private int totalWords = resultsReader.getTotalWords();
    private int correctWords = resultsReader.getCorrectWords();

    public ControllerViewResults(ViewResults viewResults) {
        this.viewResults = viewResults;

        setActionListenerToButtons();

        initializeView();

        viewResults.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (viewResults.getButtonAccept() == event.getSource()) {
            this.viewResults.dispose();
        }
    }

    private void setActionListenerToButtons() {
        this.viewResults.getButtonAccept().addActionListener(this);
    }

    private void initializeView() {
        viewResults.getLabelTotalWords().setText(String.valueOf(totalWords));
        viewResults.getLabelCorrectWords().setText(String.valueOf(correctWords));
        viewResults.getLabelPercentage().setText(String.valueOf(calculatePercentage()) + "%");
    }

    public double calculatePercentage() {
        if (totalWords != 0) {
            return (correctWords * 100) / totalWords;
        }
        return 0;
    }

}
