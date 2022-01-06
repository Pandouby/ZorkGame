package zork;

public class Enemy {
    private String name;
    private int health;
    private int damage;
    private Item loot;

    public Enemy(String name, int health, int damage, Item loot) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.loot = loot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
