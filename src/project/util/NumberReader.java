package project.util;


import project.util.exception.ExitException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class NumberReader {

    private static Integer number;

    public static Integer readNumber() throws ExitException {
    String earlyNumber = "";


        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            earlyNumber = reader.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (earlyNumber.equals("q")) {
            throw new ExitException("User logged out.");
        }
        try {
            number = Integer.parseInt(earlyNumber);
        } catch (NumberFormatException err) {
            System.out.println("You entered not integer, try again");
            readNumber();
        }
        return number;
    }
}
