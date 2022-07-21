package com.hometask.wordcounter.input;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class InputReceiverTest {

    private InputReceiver inputReceiver;

    @Before
    public void setUp() {
        inputReceiver = new InputReceiver();
    }

    @Test
    public void getInputFromUserTest() {
        ByteArrayInputStream in = new ByteArrayInputStream("Some String".getBytes());
        System.setIn(in);

        String result = inputReceiver.getInputStringFromUser();

        assertEquals("Input string should be: 'Some String'", "Some String", result);
    }
}
