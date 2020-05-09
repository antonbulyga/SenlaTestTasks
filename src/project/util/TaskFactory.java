package project.util;

import project.Interface.Task;
import project.task1.PrimeNumber;
import project.task2.MathOpportunities;
import project.task3.StringOperations;
import project.task4.CountWordInText;
import project.task5.Palindromes;

import static project.util.NumberReader.readNumber;

import project.task6.BagFiller;
import project.exception.ExitException;

public class TaskFactory {
    private Task task;
    public void choose() {
        System.out.println("You are in the main menu." +
                " Enter number of task (integer from 1 to 6). For exit from the program press \"e\"");
        int numberOfTask;

        try {
            numberOfTask = readNumber();
        } catch (ExitException e) {
            System.out.println(e.getMessage());
            return;
        }
        if (numberOfTask >= 1 && numberOfTask <= 6) {
            switch (numberOfTask) {
                case 1:
                    System.out.println("You have chosen task number 1. This program shown to you is entered number prime or even");
                    task = new PrimeNumber();
                    task.runTask();
                    break;
                case 2:
                    System.out.println("You have chosen task number 2. This program show to you Greatest common divisor" +
                            " and Least common multiple of the two entered numbers");
                    task = new MathOpportunities();
                    task.runTask();
                    break;
                case 3:
                    System.out.println("You have chosen task number 3. 1) Calculate words in the sentence " +
                            "2) String where each word is capitalized " +
                            "3) Display words in alphabetical order ");
                    task = new StringOperations();
                    task.runTask();
                    break;
                case 4:
                    System.out.println("You have chosen task number 4. This program calculate how " +
                            "many words contains sentence (case insensitive)");
                    task = new CountWordInText();
                    task.runTask();
                    break;
                case 5:
                    System.out.println("You have chosen task number 5. This program show to you palindrome " +
                            "numbers in a given sequence");
                    task = new Palindromes();
                    task.runTask();
                    break;
                case 6:
                    System.out.println("You have chosen task number 6. This program will optimize a backpack " +
                            "and put only the most valuable items inside");
                    task = BagFiller.create();
                    task.runTask();
                    break;
            }
        } else {
            System.out.println("Incorrect input, try again");
        }
        choose();
    }
}
