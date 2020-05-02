package project.Task2;


import project.util.exception.ExitException;
import static project.util.NumberReader.readNumber;

public class MathOpportunities {

     int gcd(int a, int b) {
         if (a == 0) {
             return b;
         }
        return gcd(b % a, a);
    }

    // method to return LCM of two numbers
     int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    public void doItAll()  {

        int a;
        int b;

        System.out.println("Enter the first number and press enter. Enter the second number and press Enter. Number should be more than 0 ");
        try {
            a = readNumber();
            b = readNumber();

        } catch (ExitException e) {
            System.out.println(e.getMessage());
            return;
        }
        if(a > 0 & b > 0) {
            System.out.println("Greatest common divisor from " + a + " and " + b + " is " + gcd(a, b));
            System.out.println("Least common multiple from " + a + " and " + b + " is " + lcm(a, b));
        }
        else {
            System.out.println("Wrong input, try again!");
            doItAll();
        }

    }



}









