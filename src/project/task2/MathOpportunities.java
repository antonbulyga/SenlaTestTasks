package project.task2;

import project.Task;
import project.exception.ExitException;

import static project.util.NumberReader.readNumber;

public class MathOpportunities implements Task {

    private int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }

    private int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
    @Override
    public void runTask() {
        System.out.println("Enter the first number and press enter. Enter the second number and press enter." +
                " The number should be more than 0, or press \"e\" to back to the main menu ");
        int a;
        int b;

        try {
            a = readNumber();
            b = readNumber();
        } catch (ExitException e) {
            System.out.println(e.getMessage());
            return;
        }
        if (a > 0 & b > 0) {
            System.out.println("Greatest common divisor from " + a + " and " + b + " is " + gcd(a, b));
            System.out.println("Least common multiple from " + a + " and " + b + " is " + lcm(a, b));
        } else {
            System.out.println("Wrong input, try again!");
            runTask();
        }
    }
}









