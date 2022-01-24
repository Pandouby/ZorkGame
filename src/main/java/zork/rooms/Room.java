package zork.rooms;/** * Author:  Michael Kolling, Version: 1.1, Date: August 2000 * refactoring: Rinaldo Lanza, September 2020 */import zork.Door;import zork.Enemy;import zork.Item;import java.util.ArrayList;import java.util.HashMap;import java.util.List;import java.util.stream.Collectors;public class Room {    private String description;    private HashMap<String, Door> exits;    private Enemy enemy;    private ArrayList<Item> items;    public Room(String description) {        this(description, null, null);    }    public Room(String description, Item item) {        this(description, item, null);    }    public Room(String description, Enemy enemy) {        this(description, null, enemy);    }    public Room(String description, Item item, Enemy enemy) {        this.description = description;        this.exits = new HashMap<>();        this.enemy = enemy;        this.items = new ArrayList<>();        if (item != null) {            this.items.add(item);        }    }    public void setExits(Door north, Door east, Door south, Door west) {        exits.put("north", north);        exits.put("east", east);        exits.put("south", south);        exits.put("west", west);    }    public String shortDescription() {        return description;    }    public String longDescription() {        StringBuilder stringBuilder = new StringBuilder("You are in " + description + ".\n");        stringBuilder.append(exitString());        return stringBuilder.toString();    }    private String exitString() {        return "Exits:" + String.join(" ", exits.keySet());    }    public Room nextRoom(String direction) {        return exits.get(direction).getOtherRoom(this);    }    public void addItem(Item item) {        items.add(item);    }    public void removeItem(Item item) {        List<Item> newList = items                .stream()                .filter(e -> !item.getName().equals(e.getName()))                .collect(Collectors.toList());        setItems((ArrayList<Item>) newList);    }    public void setItems(ArrayList<Item> items) {        this.items = items;    }    public boolean enemyExists() {        return this.enemy != null;    }    public boolean itemExists() {        return items.isEmpty();    }    public Enemy getEnemy() {        return enemy;    }    public ArrayList<Item> getItems() {        return items;    }    public HashMap<String, Door> getExits() {        return exits;    }}