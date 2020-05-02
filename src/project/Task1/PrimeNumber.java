package project.Task1;
import project.util.exception.ExitException;

import static project.util.NumberReader.readNumber;

public class PrimeNumber {
    public void doItAll() {

        System.out.println("Enter an integer and press Enter:");
        int number;

        try {
            number = readNumber();
        } catch (ExitException e) {
            System.out.println(e.getMessage());
            return;
        }


        if (Even(number)) {
            System.out.println(number + " - number is odd");
        } else {
            System.out.println(number + " - number is even");
        }
        if(number != 0 && number != 1) {
            if (Prime(number)) {
                System.out.println(Math.abs(number) + " - number is prime (the number is taken modulo because prime number can't be negative)");
            } else {
                System.out.println(Math.abs(number) + " - number is composite (the number is taken modulo because composite number can't be negative)");
            }
        }
        else {
            System.out.println("The number isn't prime and isn't composite");
        }
    }

    public boolean Prime(int number) {
        int temp;
        int worknumber;
        boolean isPrime = true;
        worknumber = Math.abs(number);
        if(worknumber == 1){
            return false;
        }

            for (int i = 2; i <= worknumber / 2; i++) {
                temp = worknumber % i;
                if (temp == 0) {
                    isPrime = false;
                    break;
                }
            }

        return isPrime;
    }

    public boolean Even(int number) {
        boolean isEven = true;
        if (number % 2 == 0) {
            isEven = false;

        }
    return isEven;
    }

}

