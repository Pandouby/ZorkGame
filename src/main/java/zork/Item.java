package zork;

public class Item {
    private String description;
    private String name;
    private int weight;
    private int dmg;
    private double resistance;

    public Item(String description, String name, int weight, int dmg, double resistance) {
        this.description = description;
        this.name = name;
        this.dmg = dmg;
        this.weight = weight;
        this.resistance = resistance;
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getResistance() {
        return resistance;
    }

    public void setResistance(double resistance) {
        this.resistance = resistance;
    }
}
