package project.task3;

import project.Task;
import project.exception.ExitException;

import static project.util.TextReader.readText;

import java.util.Arrays;

public class StringOperations implements Task {

    private String[] wordsCounter(String message) {
        String[] words = message.replaceAll("\\p{Punct}|\\d", "").split("\\s+");
        System.out.println("Number of words in a sentence: " + words.length);
        return words;
    }

    private void sorter(String[] words) {
        Arrays.sort(words);
        System.out.println("Display words in alphabetical order: ");
        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]);
        }
    }

    private String[] capitalSymbol(String[] words) {
        StringBuilder outputTemp = new StringBuilder();
        String output = "";
        for (String word : words) {
            String first = word.substring(0, 1).toUpperCase();
            String all = word.substring(1);
           output = outputTemp.append(first).append(all).append(" ").toString();
        }
        String[] newWord = output.split("\\s+");
        System.out.println("String where each word is capitalized : " + output);
        return newWord;
    }
    @Override
    public void runTask() {
        System.out.println("Enter the sentence and press enter or press \"e\" to back to the main menu");
        String message;

        try {
            message = readText();
        } catch (ExitException e) {
            System.out.println(e.getMessage());
            return;
        }
        String[] wordsAfterReplaceSymbol = wordsCounter(message);
        String[] wordsAfterCapitalSymbol = capitalSymbol(wordsAfterReplaceSymbol);
        sorter(wordsAfterCapitalSymbol);
    }
}



