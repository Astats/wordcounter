package com.hometask.wordcounter.input;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@NoArgsConstructor
public class InputReceiver {

    public String getInputStringFromUser() {
        System.out.println("Please input string of characters");
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        System.out.println("Your input was: " +  input);

        return input;
    }

    public Boolean shouldCompareCaseSensitive() {
        System.out.println("Should compare case sensitive input TRUE (case insensitive input) if 'yes' " +
                "(any other input will mean false)");

        Scanner scanner = new Scanner(System.in);

        return Boolean.valueOf(scanner.nextLine());
    }


}
