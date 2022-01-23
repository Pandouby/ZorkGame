package zork;import zork.riddle.HigherLower;import zork.riddle.Pythagoras;import zork.riddle.QuadraticEquation;import zork.rooms.Room;import java.util.ArrayList;import java.util.Scanner;/** * Class Game - the main class of the "Zork" game. * <p> * Author:  Michael Kolling, 1.1, March 2000 * refactoring: Rinaldo Lanza, September 2020 */public class Game {    private Parser parser;    private Room currentRoom;    private Room lastRoom;    private Player player;    private Scanner keyBoard = new Scanner(System.in);    private Room entrance, study, library, kitchen, dungeon, attic, dining, exit;    public Game(String name) {        parser = new Parser(keyBoard);        ArrayList<Item> list = new ArrayList<>();        this.player = new Player(100, list, name);        Item studyKey = new Item("The key to the Study room", "study Key", 1, 0, 0);        Item librarykey = new Item("The key to the old Library", "library Key", 1, 0, 0);        Item sword = new Item("An acient magical sword", "sword", 1, 50, 0.9);        Item shield = new Item("A shield", "shield", 1, 0, 0.4);        Enemy dragon = new Enemy("dragon", 200, 40, librarykey);        Enemy goblin = new Enemy("goblin", 100, 50, shield);        entrance = new Room("Entrance to the building");        dining = new Room("The dining room");        attic = new Room("The attic", goblin);        study = new Room("The Study");        library = new Room("The old library", dragon);        kitchen = new Room("The kitchen", dragon);        dungeon = new Room("The musty dungeon");        exit = new Room("You found the exit");        Door entranceKitchen = new Door(entrance, kitchen, new Lock(new QuadraticEquation(), keyBoard));        Door kitchenDining = new Door(kitchen, dining);        Door entranceStudy = new Door(entrance, study, new Lock(studyKey));        Door dungeonStudy = new Door(dungeon, study, new Lock(new Pythagoras(), keyBoard));        Door studyAttic = new Door(study, attic, new Lock(new HigherLower(), keyBoard));        Door studyLibrary = new Door(study, library, new Lock(librarykey));        Door libraryExit = new Door(library, exit);        entrance.setExits(null, entranceKitchen, entranceStudy, null);        kitchen.setExits(null, kitchenDining, null, entranceKitchen);        dining.setExits(null, null, null, kitchenDining);        study.setExits(entranceStudy, studyAttic, studyLibrary, dungeonStudy);        dungeon.setExits(null, dungeonStudy, null, null);        attic.setExits(null, null, null, studyAttic);        library.setExits(studyLibrary, null, libraryExit, null);        exit.setExits(libraryExit, null, null, null);        currentRoom = entrance; // start game outside    }    /**     * Main play routine.  Loops until end of play.     */    public void play() {        printWelcome();        // Enter the main command loop.  Here we repeatedly read commands and        // execute them until the game is over.        boolean finished = false;        while (!finished) {            Command command = parser.getCommand();            finished = processCommand(command);        }        System.out.println("Thank you for playing.  Good bye.");        keyBoard.close();    }    private void printWelcome() {        System.out.println();        System.out.println("Welcome to Zork!");        System.out.println("Zork is a simple adventure game.");        System.out.println("Type 'help' if you need help.");        System.out.println();        System.out.println(currentRoom.longDescription());    }    private boolean processCommand(Command command) {        if (command.isUnknown()) {            System.out.println("I don't know what you mean...");            return false;        }        String commandWord = command.getCommandWord();        if (commandWord.equals("help")) {            printHelp();        } else if (commandWord.equals("go")) {            try {                System.out.println(command);                goRoom(command);            } catch (NullPointerException e) {                System.out.println("There's no Door there!");            }        } else if (commandWord.equals("quit")) {            if (command.hasSecondWord()) {                System.out.println("Quit what?");            } else {                return true; // signal that we want to quit            }        } else if (commandWord.equals("back")) {            if (lastRoom != null) {                System.out.println("You're leaving: " + currentRoom.shortDescription() + "and Going back to: " + lastRoom.shortDescription());                currentRoom = lastRoom;            } else {                System.out.println("This is your first room. Can't go back");            }        } else if (commandWord.equals("collect")) {            if (!currentRoom.itemExists()) {                ArrayList<Item> items = currentRoom.getItems();                if (items.size() > 1) {                    System.out.println("There are more than 1 Item, which one do you choose?\n");                    items.stream().forEach(e -> System.out.println(e.getName()));                    String itemChosen = keyBoard.nextLine();                    Item item = items.stream().filter(item1 -> item1.getName().equals(itemChosen)).findAny().get();                    while (item == null) {                        System.out.println("Choose one again");                        items.stream().forEach(System.out::println);                        String newItemChosen = keyBoard.nextLine();                        item = items.stream().filter(item1 -> item1.getName().equals(newItemChosen)).findAny().get();                    }                    if (player.addToInventory(item)) {                        currentRoom.removeItem(item);                        System.out.println("Item added successfully, to add other run again");                    } else {                        System.out.println("Could not add Item due to weight: " + items.get(0).getWeight() + "\n");                        System.out.println("Your weight currently: " + player.getWeight());                    }                } else if (items.size() == 1) {                    if (player.addToInventory(items.get(0))) {                        System.out.println("Item: " + items.get(0).getName() + " added successfully");                        currentRoom.removeItem(items.get(0));                    } else {                        System.out.println("Could not add Item due to weight: " + items.get(0).getWeight() + "\n");                        System.out.println("Your weight currently: " + player.getWeight());                    }                }            } else {                System.out.println("There are no items to collect");            }        } else if (commandWord.equals("inventory")) {            player.listItems();        } else if (commandWord.equals("drop")) {            if (command.hasSecondWord()) {                Item selectedItem = player.checkIfItemExists(command.getSecondWord());                if (selectedItem == null) {                    System.out.println("Item was not found, did you spell it right?");                } else {                    player.dropItem(selectedItem);                    System.out.println("Item dropped successfully");                }            } else {                System.out.println("What do you want to drop(second argument)?");                player.listItems();            }        } else if(commandWord.equals("map")){            Map.map(currentRoom);        }        return false;    }    private void printHelp() {        System.out.println("You are lost. You are alone. You wander");        System.out.println("around at Monash Uni, Peninsula Campus.");        System.out.println();        System.out.println("Your command words are:");        System.out.println(parser.showCommands());    }    private void goRoom(Command command) {        if (!command.hasSecondWord()) {            System.out.println("Go where?");        } else {            String direction = command.getSecondWord();            // Try to leave current room.            Room nextRoom = currentRoom.nextRoom(direction);            Door door = currentRoom.getExits().get(direction);            Lock lock = door.getLock();            if (nextRoom == null) {                System.out.println("There is no door!");            } else {                if (lock.isLocked() && lock.getRiddle() != null) {                    if (!lock.lockUnlock(null)) {                        switchRooms(nextRoom);                    }                } else if (lock.isLocked() && lock.getRiddle() == null) {                    System.out.println("You need a key to continue");                    System.out.println("Here is your Inventory: ");                    player.listItems();                    String selectedItem = keyBoard.nextLine();                    Item keySelected = player.checkIfItemExists(selectedItem);                    if(keySelected != null){                        if(lock.lockUnlock(keySelected)){                            switchRooms(nextRoom);                        }                    }                } else if (!lock.isLocked()) {                    switchRooms(nextRoom);                }            }        }    }    private void switchRooms(Room nextRoom) {        lastRoom = currentRoom;        currentRoom = nextRoom;        System.out.println(currentRoom.longDescription());        if (currentRoom.enemyExists()) {            System.out.println("Oh no you've encountered " + currentRoom.getEnemy().getName() + ". You have no choice but to fight");            Fight fight = new Fight(currentRoom.getEnemy(), player, keyBoard);            if (fight.fight()) {                System.out.println("\n Collect your loot from the enemy with collect command");                currentRoom.addItem(currentRoom.getEnemy().getLoot());            } else {                System.exit(0);            }        }    }}