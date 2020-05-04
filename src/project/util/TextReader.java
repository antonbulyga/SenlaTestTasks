package project.util;

import project.exception.ExitException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TextReader {

    private static String text;

    public static String readText() throws ExitException {

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            text = reader.readLine();
            if (text.equals("e")) {
                throw new ExitException("User logged out.");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return text;
    }
}
