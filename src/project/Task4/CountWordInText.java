package project.Task4;

import static project.util.TextReader.readText;
import java.util.HashMap;

public class CountWordInText {

    private String myWord;

    public void doItAll() {

        System.out.println("Enter text and press enter");
        String string = readText();
        string.toLowerCase();
        string = string.toLowerCase();
        System.out.println("Enter word and press enter");
        String word = readText();
        word = word.toLowerCase();
        myWord = word;
        String[] words = string.replaceAll("\\p{Punct}|\\d", "").split("\\s+");
        counter(words);
    }

    public void counter(String[] words ) {
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
            }
        }
    }

}
