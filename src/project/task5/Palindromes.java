package project.task5;

import project.Task;
import project.exception.ExitException;

import static project.util.NumberReader.readNumber;

import java.util.ArrayList;
import java.util.List;

public class Palindromes implements Task {

    @Override
    public void runTask() {
        System.out.println("Input number from 0 to 100 or press \"e\" to back to the main menu");
        List<String> listOfPalindromes = new ArrayList();
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
            for(String i: listOfPalindromes){
                System.out.println(i);
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


