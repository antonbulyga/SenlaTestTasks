package project.Task6;

import project.util.exception.ExitException;
import java.util.ArrayList;
import java.util.List;
import static project.util.NumberReader.readNumber;


public class BagFiller {

    private List<Item> itemsBeforeOptimize;
    private int capacity;

    public  BagFiller(List<Item> itemsBeforeOptimize, int capacity) {
        this.itemsBeforeOptimize = itemsBeforeOptimize;
        this.capacity = capacity;
    }



    public void display() {
        if (itemsBeforeOptimize != null  &&  !itemsBeforeOptimize.isEmpty()) {
            System.out.println("Bag before optimize");
            System.out.println("Capacity : " + capacity);
            System.out.println("Items :");

            for (Item item : itemsBeforeOptimize) {
                System.out.println("- " + item.str());
            }
        }
    }
    public Backpack getOptimizeBag() {

        int countItems = itemsBeforeOptimize.size();
        int[][] matrix = new int[countItems + 1][capacity + 1];

        for (int i = 0; i <= capacity; i++)
            matrix[0][i] = 0;

        for (int i = 1; i <= countItems; i++) {

            for (int j = 0; j <= capacity; j++) {

                if (itemsBeforeOptimize.get(i - 1).getWeight() > j) {
                    matrix[i][j] = matrix[i - 1][j];
                } else {
                    matrix[i][j] = Math.max(
                            matrix[i - 1][j],
                            matrix[i - 1][j - itemsBeforeOptimize.get(i - 1).getWeight()] + itemsBeforeOptimize.get(i - 1).getCost()
                    );
                }
            }
        }

        int res = matrix[countItems][capacity];
        int freeCapacity = capacity;
        List<Item> fullBag = new ArrayList<>();

        for (int i = countItems; i > 0 && res > 0; i--) {

            if (res != matrix[i - 1][freeCapacity]) {
                fullBag.add(itemsBeforeOptimize.get(i - 1));
                res -= itemsBeforeOptimize.get(i - 1).getCost();
                freeCapacity -= itemsBeforeOptimize.get(i - 1).getWeight();
            }
        }
        return new Backpack(fullBag);
    }
    public static BagFiller create() {

        List<Item> items = new ArrayList<>();
        int capacity;
        int weight;
        int cost;



        System.out.println("Enter capacity. Capacity can't be less than 1");
        try {
            capacity = readNumber();
        }
        catch (ExitException e){
            System.out.println(e.getMessage());
            return null;
        }

        while (true){
            if(capacity >= 1) {
                try {
                    System.out.println("Enter weight and press enter than enter cost and press enter. Press q to next step\"");
                    weight = readNumber();
                    cost = readNumber();
                } catch (ExitException e) {
                    System.out.println("You finished enter weight and cost");
                    break;
                }

                if(weight >0 && cost >0) {
                    items.add(new Item(weight, cost));

                }
                else {
                    System.out.println("Weight or cost can't be negative");
                }
            }
            else {
                System.out.println("Capacity can't be less than one! Try again.");
                create();

            }

        }

        return new BagFiller(items, capacity);
    }

}