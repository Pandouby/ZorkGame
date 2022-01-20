package zork;

public class Enemy {
    private String name;
    private double health;
    private double damage;
    private Item loot;

    public Enemy(String name, double health, double damage, Item loot) {
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

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }
}
