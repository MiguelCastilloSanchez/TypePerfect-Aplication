package com.cds.typeperfectapp.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LogsReader {

    private int totalWords = 0;
    private int correctWords = 0;
    private String logsFilePath = "src/main/resources/logs.csv";

    public LogsReader() {
        getLogs();
    }

    public void getLogs() {
        String SEPARATOR = ", ";
        BufferedReader bufferReader = null;

        try {
            bufferReader = new BufferedReader(new FileReader(logsFilePath));
            String linea = bufferReader.readLine();
            while (linea != null) {
                String[] data = linea.split(SEPARATOR);
                if (data[0].equals("TotalWords")) totalWords = Integer.parseInt(data[1]);
                if (data[0].equals("CorrectWords")) correctWords = Integer.parseInt(data[1]);
                linea = bufferReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferReader != null) {
                try {
                    bufferReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void updateLogs(int totalWords, int correctWords) {
        try {
            FileWriter writer = new FileWriter(logsFilePath, false);

            writer.write("TotalWords, " + totalWords + "\n");
            writer.write("CorrectWords, " + correctWords + "\n");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getTotalWords() {
        return totalWords;
    }

    public int getCorrectWords() {
        return correctWords;
    }
}
