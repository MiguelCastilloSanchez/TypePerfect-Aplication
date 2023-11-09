/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cds.typeperfectapp.model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author Miguel
 */
/**
 * La clase "WordsReader" regresa la lista de palabras
 * escritas en un archivo.
 */
public class WordsReader {
    
    /*
     * Constructor de la clase.
     */
    public WordsReader(){
    }

    /**
     * La función "getWords" regresa las palabras contenidas en un archivo.
     * 
     * @param filePath El parámetro representa la ruta al archivo.
     * 
     * @return El método regresa la lista de palabras del archivo.
     */
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