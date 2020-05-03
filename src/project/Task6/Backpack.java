package project.Task6;

import java.util.List;

public class Backpack {

    private List<Item> items;
    private int weight;

    public Backpack(List<Item> items) {
        this.items = items;
        initWeight(items);
    }

    private void initWeight(List<Item> items) {
        int weight = 0;

        for (Item item : items) {
            weight += item.getWeight();
        }
        this.weight = weight;
    }

    public void display() {
        if (items != null && !items.isEmpty()) {
            System.out.println("Bag after optimize");
            System.out.println("Weight of the bag : " + this.weight);
            System.out.println("Items :");

            for (Item item : items) {
                System.out.println("- " + item.str());
            }
        } else {
            System.out.println("Sorry, no item was placed in the backpack");
            return;
        }
    }
}
