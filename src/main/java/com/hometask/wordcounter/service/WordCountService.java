package com.hometask.wordcounter.service;

import com.hometask.wordcounter.dto.TemporaryWordDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class WordCountService {

    public List<String> findWordsInProvidedString(String providedString, List<String> listOfWords) {
        List<String> foundWords = new ArrayList<>();

        boolean loopCondition = true;
        String stringToCompare = providedString;
        List<String> listOfWordsToCompare = listOfWords;

        while (loopCondition) {
            final String loopString = stringToCompare;
            List<TemporaryWordDto> temporaryWordDtoList = createTemporaryWordDtoList(loopString, listOfWordsToCompare);

            listOfWordsToCompare = temporaryWordDtoList.stream()
                    .map(TemporaryWordDto::getWord)
                    .collect(Collectors.toList());

            Optional<TemporaryWordDto> foundWordOptional = temporaryWordDtoList.stream()
                    .min(Comparator.comparing(TemporaryWordDto::getIndex));

            if (foundWordOptional.isPresent()) {
                TemporaryWordDto foundWord = foundWordOptional.get();
                foundWords.add(foundWord.getWord());
                stringToCompare = stringToCompare.substring(foundWord.getIndex() + foundWord.getWord().length());
            } else {
                loopCondition = false;
            }
        }
        return foundWords;
    }

    private TemporaryWordDto createTemporaryWordDto(String providedString, String wordFromDictionary) {
        return TemporaryWordDto.builder()
                .word(wordFromDictionary)
                .index(getIndexOfFoundWord(providedString, wordFromDictionary))
                .build();
    }

    private int getIndexOfFoundWord(String inputString, String wordFromDictionary) {
        return inputString.indexOf(wordFromDictionary);
    }

    private List<TemporaryWordDto> createTemporaryWordDtoList(String inputString, List<String> wordList) {
        return wordList.stream()
                .map(word -> createTemporaryWordDto(inputString, word))
                .filter(TemporaryWordDto::haveIndexOfFound)
                .collect(Collectors.toList());
    }

}