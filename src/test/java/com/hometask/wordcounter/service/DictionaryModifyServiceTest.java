package com.hometask.wordcounter.service;

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
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class DictionaryModifyServiceTest {

    @InjectMocks
    private DictionaryModifyService dictionaryModifyService;
    @Mock
    private WordCountService wordCountService;

    @Test
    public void removeNotUsableWordsTest_FilterStartsWith() {
        when(wordCountService.findWordsInProvidedString(anyString(), anyList())).thenReturn(Collections.emptyList());

        List<String> resultList = dictionaryModifyService.removeNotUsableWords(createListOfWords());

        assertEquals("Result List should contain 3 objects", 3,  resultList.size());
        assertTrue("List should contain word: 'can'", resultList.contains("can"));
        assertTrue("List should contain word: 'dog'", resultList.contains("dog"));
        assertTrue("List should contain word: 'iscandog'", resultList.contains("iscandog"));

        verify(wordCountService, times(3)).findWordsInProvidedString(anyString(), anyList());
    }

    @Test
    public void removeNotUsableWordsTest_FilterHaveMoreThanOneWordIn() {
        when(wordCountService.findWordsInProvidedString("iscandog", Collections.emptyList())).thenReturn(createListOfWords());

        List<String> resultList = dictionaryModifyService.removeNotUsableWords(Collections.singletonList("iscandog"));

        assertTrue("Result List should contain no objects", resultList.isEmpty());
        verify(wordCountService).findWordsInProvidedString("iscandog", Collections.emptyList());
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
