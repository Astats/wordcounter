package com.hometask.wordcounter.service;

import com.hometask.wordcounter.file.FileReader;
import com.hometask.wordcounter.input.InputReceiver;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class WordDictionaryServiceTest {

    @InjectMocks
    private WordDictionaryService wordDictionaryService;
    @Mock
    private FileReader fileReader;
    @Mock
    private InputReceiver inputReceiver;
    @Mock
    private WordCountService wordCountService;
    @Mock
    private List<String> foundWords;

    @Test
    public void runTest_argsEmpty() {
        wordDictionaryService.run();
        verifyNoInteractions(fileReader, inputReceiver, wordCountService);
    }

    @Test
    public void runTest_listOfWordsEmpty() {
        when(fileReader.getListOfWordsFromFile("file")).thenReturn(Collections.emptyList());

        wordDictionaryService.run("file");

        verify(fileReader).getListOfWordsFromFile("file");
        verifyNoInteractions(inputReceiver, wordCountService);
    }

    @Test
    public void runTest_WordsFound() {
        List<String> listOfWords = Collections.singletonList("word");
        when(fileReader.getListOfWordsFromFile("file")).thenReturn(listOfWords);
        when(inputReceiver.getInputStringFromUser()).thenReturn("someword");
        when(wordCountService.findWordsInProvidedString("someword", listOfWords))
                .thenReturn(foundWords);

        wordDictionaryService.run("file");

        verify(fileReader).getListOfWordsFromFile("file");
        verify(inputReceiver).getInputStringFromUser();
        verify(wordCountService).findWordsInProvidedString("someword", listOfWords);
        verify(foundWords).size();
    }


}
