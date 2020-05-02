package project.util;


import project.Task1.PrimeNumber;
import project.Task2.MathOpportunities;
import project.Task3.StringOperations;
import project.Task4.CountWordInText;
import project.Task5.Palindromes;

import static project.util.NumberReader.readNumber;


import project.Task6.Backpack;
import project.Task6.BagFiller;
import project.util.exception.ExitException;

public class ChooseTask {
    public void chooser() throws ExitException {
        System.out.println("Enter number of task (integer from 1 to 5). For exit press \"q\"");
        int numberOfTask;
        try {
            numberOfTask = readNumber();
        } catch (ExitException e) {
            System.out.println(e.getMessage());
            return;
        }

            if (numberOfTask >= 1 && numberOfTask <= 6) {
                switch (numberOfTask) {
                    case 1:
                        PrimeNumber primeNumber = new PrimeNumber();
                        primeNumber.doItAll();
                        break;
                    case 2:
                        MathOpportunities mathOpportunities = new MathOpportunities();
                        mathOpportunities.doItAll();
                        break;
                    case 3:
                        StringOperations stringOperations = new StringOperations();
                        stringOperations.doItAll();
                        break;
                    case 4:
                        CountWordInText countWordInText = new CountWordInText();
                        countWordInText.doItAll();
                        break;
                    case 5:
                        Palindromes palindromes = new Palindromes();
                        palindromes.doItAll();
                        break;
                    case 6:
                        BagFiller bagFiller = BagFiller.create();
                        bagFiller.display();

                        Backpack backpack = bagFiller.getOptimizeBag();
                        backpack.display();
                        break;

                }

            } else {
                System.out.println("Incorrect input, try again");
                chooser();
        }

        }

}
