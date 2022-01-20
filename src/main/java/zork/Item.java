package zork;

public class Item {
    private String description;
    private String name;
    private int weight;
    private int dmg;
    private double resitence;

    public Item(String description, String name, int weight, int dmg, double resitence) {
        this.description = description;
        this.name = name;
        this.dmg = dmg;
        this.weight = weight;
        this.resitence = resitence;
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

    public double getResitence() {
        return resitence;
    }

    public void setResitence(double resitence) {
        this.resitence = resitence;
    }
}
