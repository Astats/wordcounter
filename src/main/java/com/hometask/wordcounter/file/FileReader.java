package com.hometask.wordcounter.file;

import com.hometask.wordcounter.service.DictionaryModifyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class FileReader {

    private final DictionaryModifyService dictionaryModifyService;

    public List<String> getListOfWordsFromFile(String fileName) {
        List<String> listOfWords;
        try {
            listOfWords = Files.readAllLines(Paths.get(fileName));
        } catch (IOException e) {
            System.out.println(("Error reading file, message:" + e.getMessage()));
            return Collections.emptyList();
        }

        System.out.println(("Words in file: " + listOfWords));

        return dictionaryModifyService.removeNotUsableWords(listOfWords);
    }
}
