package project.Task5;

import project.util.exception.ExitException;

import static project.util.NumberReader.readNumber;

import java.util.ArrayList;

public class Palindromes {

    public void runTask() {
        ArrayList listOfPalindromes = new ArrayList();
        System.out.println("Input number from 0 to 100 or press \"e\" to back to the main menu");
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

    public static Boolean isPalindrome(String original) {
        return original.equals((new StringBuilder(original)).reverse().toString());
    }
}


