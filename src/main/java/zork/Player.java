package zork;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Player {
    private double health;
    private ArrayList<Item> inventory;
    private String name;
    private double weight;

    public Player(double health, ArrayList<Item> inventory, String name) {
        Item punch = new Item("Your own fists", "PUNCH", 0, 10, 1);
        this.health = health;
        this.inventory = inventory;
        this.name = name;
        this.addToInventory(punch);
        this.weight = 3;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Boolean addToInventory(Item item) {
        if (weight - item.getWeight() >= 0) {
            inventory.add(item);
            setWeight(getWeight() - item.getWeight());
            return true;
        } else {
            return false;
        }
    }

    public void dropItem(Item item) {
        List<Item> newList = inventory
                .stream()
                .filter(e -> !item.getName().equals(e.getName()))
                .collect(Collectors.toList());
        if (!item.getName().equals("PUNCH")) {
            setWeight(weight + item.getWeight());
            setInventory((ArrayList<Item>) newList);
        } else {
            System.out.println("You can't drop you're hands ;)");
        }
    }

    public Item checkIfItemExists(String selectedItem) {
        Item item = getInventory()
                .stream()
                .filter(it -> it.getName().toLowerCase().equals(selectedItem))
                .findAny()
                .orElse(null);
        return item;
    }

    public void listItems() {
        this.inventory.stream().forEach(item -> System.out.println(item.getName()));
    }
}
