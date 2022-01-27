package zork;

import java.util.Comparator;
import java.util.Scanner;

/**
 * @Author: Alex Smolders & Silvan Dubach
 * @Date: 27.01.2022
 * This class is used to initiate the fight between the player and the monster. Tracks winner and Loser
 */
public class Fight {
    private Enemy enemy;
    private Player player;
    private Scanner keyBoard;

    public Fight(Enemy enemy, Player player, Scanner keyBoard) {
        this.enemy = enemy;
        this.player = player;
        this.keyBoard = keyBoard;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * Here's where the logic of the fight takes, place until one dies.
     * It handles inputs
     * @return
     */
    public boolean fight() {
        boolean playerWin = true;

        if(player.getHealth() < 100){
            System.out.println("Player has regenerated his health");
            player.setHealth(100);
        }
        
        while (player.getHealth() > 0 || enemy.getHealth() > 0) {
            System.out.println("Select your Item: ");
            player.listItems();
            String selectedItem = keyBoard.nextLine();
            Item itemSelected = player.checkIfItemExists(selectedItem);
            if (itemSelected == null){
                while (itemSelected == null){
                    String newName = keyBoard.nextLine();
                    itemSelected = player.checkIfItemExists(newName);
                }
            }
            System.out.println("You have made this much damage: " + itemSelected.getDmg());
            enemy.setHealth(enemy.getHealth() - itemSelected.getDmg());
            if(!(enemy.getHealth() <= 0)){
                System.out.println("Enemy is attacking...");
                int temp = (Math.random() <= 0.5) ? 1 : 2;
                player.setHealth(player.getHealth() - (enemy.getDamage() * temp * getHighestResistance().getResistance()));
                System.out.println("You have this much HP: " + player.getHealth());
            }
            if (enemy.getHealth() <= 0 && player.getHealth() > 0) {
                playerWin = true;
                break;
            } else if (enemy.getHealth() > 0 && player.getHealth() <= 0) {
                playerWin = false;
                break;
            }
            System.out.println("Enemy has " + enemy.getHealth() + "HP");
        }
        if (playerWin) {
            System.out.println("YOU WIN");
        } else {
            System.out.println("YOU LOSE");
        }
        return playerWin;
    }

    /**
     * Gets the lowest percentage of resistance for the shielding of the player
     * @return
     */
    public Item getHighestResistance(){
        Item resistance = player.getInventory()
                .stream()
                .min(Comparator.comparing(item -> item.getResistance()))
                .get();
        System.out.println(resistance.getName());
        return resistance;
    }
}