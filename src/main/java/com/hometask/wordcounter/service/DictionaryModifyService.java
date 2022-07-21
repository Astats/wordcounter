package com.hometask.wordcounter.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DictionaryModifyService {

    private final WordCountService countService;

    public List<String> removeNotUsableWords(List<String> listOfWords) {
        return listOfWords.stream()
                .filter(word -> isUsable(word, listOfWords))
                .collect(Collectors.toList());
    }

    private boolean isUsable(String word, List<String> listOfWords) {
        List<String> listToProcess = listOfWords.stream()
                .filter(w -> !word.equals(w))
                .collect(Collectors.toList());

        return notStartWithOtherWord(word, listToProcess) && doesNotContainMoreThanOneOtherWord(word, listToProcess);
    }

    private boolean notStartWithOtherWord(String word, List<String> listOfWords) {
        return listOfWords.stream()
                .noneMatch(word::startsWith);
    }

    private boolean doesNotContainMoreThanOneOtherWord(String word, List<String> listOfWords) {
       return countService.findWordsInProvidedString(word, listOfWords).size() <= 1;
    }

}
