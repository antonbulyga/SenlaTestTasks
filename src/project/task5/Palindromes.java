package project.task5;

import project.exception.ExitException;

import static project.util.NumberReader.readNumber;

import java.util.ArrayList;
import java.util.List;

public class Palindromes {

    public void runTask() {
        System.out.println("Input number from 0 to 100 or press \"e\" to back to the main menu");
        List listOfPalindromes = new ArrayList();
        int number;

        try {
            number = readNumber();
        } catch (ExitException e) {
            System.out.println(e.getMessage());
            return;
        }
        if (number >= 0 && number <= 100) {
            for (int i = 0; i < number; i++) {
                String original = String.valueOf(i);
                if (isPalindrome(original)) {
                    listOfPalindromes.add(original);
                }
            }
            for (int i = 0; i < listOfPalindromes.size(); i++) {
                System.out.println(listOfPalindromes.get(i));
            }

        } else {
            System.out.println("Incorrect input! Try again.");
            runTask();
        }
    }

    private static boolean isPalindrome(String original) {
        return original.equals((new StringBuilder(original)).reverse().toString());
    }
}


