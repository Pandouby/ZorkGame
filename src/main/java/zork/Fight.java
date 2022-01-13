package zork;

import java.util.Scanner;

public class Fight {
    private Enemy enemy;
    private Player player;
    private String winner;

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
        scanner.close();
    }
}