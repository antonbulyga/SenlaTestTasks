package project.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TextReader {

    private static String text;


    public static String readText() {

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            text = reader.readLine();

        } catch (IOException ex) {
            ex.printStackTrace();
        }


        return text;
    }
}
