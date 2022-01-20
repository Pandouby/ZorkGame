package zork;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Fight {
    private Enemy enemy;
    private Player player;

    public Fight(Enemy enemy, Player player) {
        this.enemy = enemy;
        this.player = player;
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

    public void fight() {
        Scanner scanner = new Scanner(System.in);
        boolean playerWin = true;
        while (player.getHealth() > 0 || enemy.getHealth() > 0) {
            System.out.println("Select your Item: ");
            player.listItems();
            String selectedItem = scanner.nextLine();
            Item itemSelected = player.checkIfItemExists(selectedItem);
            if (itemSelected == null){
                while (itemSelected == null){
                    String newName = scanner.nextLine();
                    itemSelected = player.checkIfItemExists(newName);
                }
            }
            System.out.println("You have made this much damage: " + itemSelected.getDmg());
            enemy.setHealth(enemy.getHealth() - itemSelected.getDmg());
            System.out.println("Enemy is attacking...");
            int temp = (Math.random() <= 0.5) ? 1 : 2;
            player.setHealth(player.getHealth() - (enemy.getDamage() * temp * getHighestResistance().getResitence()));
            System.out.println("You have this much HP: " + player.getHealth());
            if (enemy.getHealth() < 0 && player.getHealth() > 0) {
                playerWin = true;
                break;
            } else if (enemy.getHealth() > 0 && player.getHealth() < 0) {
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
        scanner.close();
    }

    private Item getHighestResistance(){
        Item resistanceItem = null;
        List<Item> resistance = player.getInventory().stream().filter(item -> item.getResitence() > 0).collect(Collectors.toList());
        if (resistance != null){
            resistanceItem = resistance.get(1);
        }
        return resistanceItem;
    }
}