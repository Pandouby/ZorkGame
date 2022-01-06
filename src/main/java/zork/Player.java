package zork;

import java.util.ArrayList;

public class Player {
    private int health;
    private ArrayList<Item> inventory;
    private String name;

    public Player(int health, ArrayList<Item> inventory, String name) {
        Item punch = new Item("Your own fists", "PUNCH");
        this.health = health;
        this.inventory = inventory;
        this.name = name;
        this.inventory.add(punch);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
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
}
