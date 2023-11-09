/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import org.junit.jupiter.api.Test;

import com.cds.typeperfectapp.model.WordsReader;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

/**
 *
 * @author diego
 */
public class UnitTests {
    private static int testCounter = 0;
    @BeforeEach 
    public void setUp() {
    testCounter++;
    System.out.println("Setting up test " + testCounter);
    }
    @AfterEach
    public void tearDown() {
    System.out.println("Tearing down test " + testCounter);
    }
    @DisplayName ("Prueba de recuperación de palabras")
    @Test
    public void RetrieveWordsFromFile1() {
      WordsReader wordsReader = new WordsReader();
      String [] testWords = wordsReader.getWords("src/main/resources/words/BothHands.txt");
        assertEquals(testWords[0], "torta");
    }
    @DisplayName ("Prueba de recuperación de palabras")
    @Test
    public void RetrieveWordsFromFile2() {
      WordsReader wordsReader = new WordsReader();
      String [] testWords = wordsReader.getWords("src/main/resources/words/RightHandEnglish.txt");
        assertEquals(testWords[17], "milk");
    }

}
