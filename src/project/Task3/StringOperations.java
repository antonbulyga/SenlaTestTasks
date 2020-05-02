package project.Task3;
import static project.util.TextReader.readText;

import java.util.Arrays;


public class StringOperations {

    public String[] wordsCounter(String message){
        String[] words = message.replaceAll("\\p{Punct}|\\d", "").split("\\s+");
        System.out.println("Number of words in a sentence: " + words.length);
        return words;
    }

    public String[] sorter(String[] words){
        Arrays.sort(words);
        System.out.println("Display words in alphabetical order: ");
        for (int i = 0; i < words.length ; i++) {
            System.out.println(words[i]);
        }
        return words;
    }

    public String[] capitalSymbol(String[] words){
        String output = "";
        for(String word:words){
            String first = word.substring(0,1).toUpperCase();
            String all = word.substring(1);
            output += first+all + " ";
        }

        String[] newWord = output.split("\\s+");

        System.out.println("String where each word is capitalized : " + output);
        return newWord;
    }

    public void doItAll(){
        System.out.println("Enter the sentence and press enter: ");
        String message = readText();
        String[] wordsAfterReplaceSymbol = wordsCounter(message);
        String[] wordsAfterCapitalSymbol =  capitalSymbol(wordsAfterReplaceSymbol);
        sorter(wordsAfterCapitalSymbol);
    }

}



