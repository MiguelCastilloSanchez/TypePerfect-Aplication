package com.cds.typeperfectapp.model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class WordsReader {
    
    public WordsReader(){
        
    }

    public String[] getWords(String filePath) {
        
        String[] listOfWords = null;
        try(BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8))){
        listOfWords = fileReader.lines().toArray(String[]::new);
        }catch(Exception e){
            e.printStackTrace();
        }
        return listOfWords;
    }

    
    }