package com.hometask.wordcounter.file;

import com.hometask.wordcounter.service.DictionaryModifyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FileReaderTest {

    @InjectMocks
    private FileReader fileReader;
    @Mock
    private DictionaryModifyService dictionaryModifyService;

    @Captor
    private ArgumentCaptor<List<String>> listCaptor;

    @Test
    public void getListOfWordsFromFileTest_fileFound() {
        when(dictionaryModifyService.removeNotUsableWords(listCaptor.capture())).thenReturn(Collections.singletonList("otherWord"));

        List<String> result = fileReader.getListOfWordsFromFile("./src/test/resources/testinput.txt");
        List<String> capturedList = listCaptor.getValue();

        verify(dictionaryModifyService).removeNotUsableWords(capturedList);

        assertFalse(capturedList.isEmpty());
        assertEquals("Word in list should be: 'word'", "word", capturedList.get(0));
        assertFalse(result.isEmpty());
        assertEquals("Word in list should be: 'otherWord'", "otherWord", result.get(0));
    }

    @Test
    public void getListOfWordsFromFileTest_fileNotFound() {
        List<String> result = fileReader.getListOfWordsFromFile("other");

        assertTrue(result.isEmpty());
    }
}
