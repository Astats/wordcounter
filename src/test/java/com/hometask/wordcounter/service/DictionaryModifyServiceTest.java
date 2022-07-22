package com.hometask.wordcounter.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DictionaryModifyServiceTest {

    private DictionaryModifyService dictionaryModifyService;

    @Before
    public void setUp() {
        dictionaryModifyService = new DictionaryModifyService();
    }

    @Test
    public void removeNotUsableWordsTest() {
        List<String> resultList = dictionaryModifyService.removeNotUsableWords(createListOfWords());

        assertEquals("Result List should contain 3 objects", 2,  resultList.size());
        assertTrue("List should contain word: 'can'", resultList.contains("can"));
        assertTrue("List should contain word: 'dog'", resultList.contains("dog"));
    }

    private List<String> createListOfWords() {
        List<String> listOfWords = new ArrayList<>();
        listOfWords.add("can");
        listOfWords.add("dog");
        listOfWords.add("candle");
        listOfWords.add("iscandog");

        return listOfWords;
    }
}
