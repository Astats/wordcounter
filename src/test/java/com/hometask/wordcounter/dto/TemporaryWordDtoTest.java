package com.hometask.wordcounter.dto;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TemporaryWordDtoTest {

    @Test
    public void temporaryWordDtoTest() {
        TemporaryWordDto dto = TemporaryWordDto.builder()
                .word("someWord")
                .index(3)
                .build();

        assertEquals("Word in TemporaryWordDto don't match", "someWord", dto.getWord());
        assertEquals("Index in TemporaryWordDto don't match", 3, dto.getIndex());
    }
}
