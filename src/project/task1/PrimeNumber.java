package project.task1;

import project.exception.ExitException;

import static project.util.NumberReader.readNumber;

public class PrimeNumber {
    public void runTask() {
        System.out.println("Enter an integer and press enter or press \"e\" to back to the main menu");
        int number;

        try {
            number = readNumber();
        } catch (ExitException e) {
            System.out.println(e.getMessage());
            return;
        }

        if (isEven(number)) {
            System.out.println(number + " - number is odd");
        } else {
            System.out.println(number + " - number is even");
        }

        if (number != 0 && number != 1) {
            if (isPrime(number)) {
                System.out.println(Math.abs(number) + " - number is prime (the number is taken modulo because prime number can't be negative)");
            } else {
                System.out.println(Math.abs(number) + " - number is composite (the number is taken modulo because composite number can't be negative)");
            }
        } else {
            System.out.println("The number isn't prime and isn't composite");
        }
    }

    private boolean isPrime(int number) {
        int temp;
        int worknumber;
        boolean prime = true;

        worknumber = Math.abs(number);
        if (worknumber == 1) {
            return false;
        }
        for (int i = 2; i <= worknumber / 2; i++) {
            temp = worknumber % i;
            if (temp == 0) {
                prime = false;
                break;
            }
        }
        return prime;
    }

    private boolean isEven(int number) {
        boolean even = true;

        if (number % 2 == 0) {
            even = false;
        }
        return even;
    }
}

