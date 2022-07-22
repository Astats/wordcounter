package com.hometask.wordcounter.service;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DictionaryModifyService {

    public List<String> removeNotUsableWords(List<String> listOfWords) {
        return listOfWords.stream()
                .filter(word -> isUsable(word, listOfWords))
                .collect(Collectors.toList());
    }

    private boolean isUsable(String word, List<String> listOfWords) {
        List<String> listToProcess = listOfWords.stream()
                .filter(w -> !word.equals(w))
                .collect(Collectors.toList());

        return doesNotContainOtherWord(word, listToProcess);
    }

    private boolean doesNotContainOtherWord(String word, List<String> listOfWords) {
        return listOfWords.stream()
                .noneMatch(word::contains);
    }

}
