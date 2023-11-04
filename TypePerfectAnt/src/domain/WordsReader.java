/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;

/**
 *
 * @author Miguel
 */
public class WordsReader {
    
    public WordsReader(){
        
    }

    public String[] getWords(String filePath) {
        
         String[] listOfWords = null;
        try( BufferedReader fileReader = new BufferedReader(new FileReader(filePath))){
        listOfWords = fileReader.lines().toArray(String[]::new);
        this.randomizeWords(listOfWords);
        }catch(Exception e){
            e.printStackTrace();
        }
        return listOfWords;

    }

    private void randomizeWords(String[] listOfWords){
          Random random = new Random();
          for (int i = listOfWords.length - 1; i > 0; i--)
          {
            int index = random.nextInt(i + 1);
            String randomWord= listOfWords[index];
            listOfWords[index] = listOfWords[i];
            listOfWords[i] = randomWord;
          }
        }
    }