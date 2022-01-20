package zork;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Player {
    private double health;
    private ArrayList<Item> inventory;
    private String name;
    private double weight;

    public Player(int health, ArrayList<Item> inventory, String name) {
        Item punch = new Item("Your own fists", "PUNCH", 0, 10, 0);
        this.health = health;
        this.inventory = inventory;
        this.name = name;
        this.addToInventory(punch);
        this.weight = 100;
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
    public Boolean addToInventory(Item item){
        if(this.weight - item.getWeight() >= 0){
            this.inventory.add(item);
            return false;
        }
        return true;
    }

    public void dropItem(Item item){
        List<Item> newList = this.inventory.stream().filter(e -> item.getName().equals(e)).collect(Collectors.toList());
        setInventory((ArrayList<Item>) newList);
    }

    public int attack(String selectedItem){
        int dmg = 0;
        while(dmg == 0) {
            listItems();
            System.out.println(">> Select you're Item");
            Item item = getInventory().stream().filter(it -> it.getName().equals(selectedItem)).findAny().orElse(null);
            if (item != null){
                dmg = item.getDmg();
            } else {
                System.out.println("Item doesn't exist");
            }
        }
        return dmg;
    }

    public void listItems(){
        this.inventory.stream().forEach(System.out::println);
    }

    public double getResistance(){
        int resistance = 0;
        List<Item>
    }
}
