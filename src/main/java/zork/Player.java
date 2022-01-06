package zork;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Player {
    private int health;
    private ArrayList<Items> inventory;
    private String name;
    private int weight;

    public Player(int health, ArrayList<Items> inventory, String name) {
        Items punch = new Items("Your own fists", "PUNCH", 0);
        this.health = health;
        this.inventory = inventory;
        this.name = name;
        this.inventory.add(punch);
        this.weight = 100;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public ArrayList<Items> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Items> inventory) {
        this.inventory = inventory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Boolean addToInventory(Items item){
        if(this.weight - item.getWeight() >= 0){
            this.inventory.add(item);
            return false;
        }
        return true;
    }

    public void dropItem(Items item){
        List<Items> newList = this.inventory.stream().filter(e -> item.getName().equals(e)).collect(Collectors.toList());
        setInventory((ArrayList<Items>) newList);
    }
}
