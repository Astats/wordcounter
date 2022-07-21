package com.hometask.wordcounter.service;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class WordCountServiceTest {

    private WordCountService wordCountService;

    @Before
    public void setUp() {
        wordCountService = new WordCountService();
    }

    @Test
    public void findWordsInProvidedStringTest() {
        List<String> resultList = wordCountService.findWordsInProvidedString("djkhofjkhacatalogdsahf", createListOfWords());

        assertEquals("Result list size should be: 3", 3, resultList.size());
        assertEquals("Result list should contain: 'of'", "of", resultList.get(0));
        assertEquals("Result list should contain: 'cat'", "cat", resultList.get(1));
        assertEquals("Result list should contain: 'log'", "log", resultList.get(2));

    }

    private List<String> createListOfWords() {
        List<String> listOfWords = new ArrayList<>();
        listOfWords.add("can");
        listOfWords.add("cat");
        listOfWords.add("dog");
        listOfWords.add("log");
        listOfWords.add("able");
        listOfWords.add("of");
        listOfWords.add("an");

        return listOfWords;
    }
}
