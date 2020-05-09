package project.task4;

import project.Interface.Task;
import project.exception.ExitException;

import java.util.HashMap;

import static project.util.TextReader.readText;

public class CountWordInText implements Task {

    private String myWord;
    @Override
    public void runTask() {
        System.out.println("Enter text and press enter or press \"e\" to back to the main menu");
        String string;
        String word;

        try {
            string = readText();
        } catch (ExitException e) {
            System.out.println(e.getMessage());
            return;
        }
        string = string.toLowerCase();
        System.out.println("Enter the word and press enter or press \"e\" to back to the main menu");
        try {
            word = readText();
        } catch (ExitException e) {
            System.out.println(e.getMessage());
            return;
        }
        word = word.toLowerCase();
        myWord = word;
        String[] words = string.replaceAll("\\p{Punct}|\\d", "").split("\\s+");
        counter(words);
    }

    private void counter(String[] words) {
        HashMap<String, Integer> wordToCount = new HashMap<>();
        for (String word : words) {
            if (!wordToCount.containsKey(word)) {
                wordToCount.put(word, 0);
            }
            wordToCount.put(word, wordToCount.get(word) + 1);
        }
        for (String word : wordToCount.keySet()) {
            if (word.equals(myWord)) {
                System.out.println("Word " + word + " found in the text " + wordToCount.get(word) + " time(s)");
                return;
            } else {
                System.out.println("The word does not appear in the text");
                return;
            }
        }
    }
}
