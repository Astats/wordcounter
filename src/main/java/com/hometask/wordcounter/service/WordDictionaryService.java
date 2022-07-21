package com.hometask.wordcounter.service;

import com.hometask.wordcounter.file.FileReader;
import com.hometask.wordcounter.input.InputReceiver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WordDictionaryService implements CommandLineRunner {

    private final FileReader fileReader;
    private final InputReceiver inputReceiver;
    private final WordCountService wordCountService;

    @Override
    public void run(String... args) {
        if (args.length == 0) {
            System.out.println("No file name provided - closing application");
            return;
        }

        List<String> listOfWords = fileReader.getListOfWordsFromFile(args[0]);

        if (listOfWords.isEmpty()) {
            return;
        }

        System.out.println("Words in dictionary after filter: " + listOfWords);

        String input = inputReceiver.getInputStringFromUser().toLowerCase();

        List<String> foundWords = wordCountService.findWordsInProvidedString(input, listOfWords);

        System.out.printf("Found %d words: %s%n", foundWords.size(), foundWords);

    }

}
