package com.hometask.wordcounter.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class TemporaryWordDto {

    private String word;
    private int index;

    public boolean haveIndexOfFound() {
        return this.index != -1;
    }

}
