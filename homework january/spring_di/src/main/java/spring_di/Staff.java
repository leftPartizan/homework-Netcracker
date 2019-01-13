package spring_di;

public class Staff {

    private String name;
    private int level;
    private int damage_radius;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getDamage_radius() {
        return damage_radius;
    }

    public void setDamage_radius(int damage_radius) {
        this.damage_radius = damage_radius;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", damage_radius=" + damage_radius +
                ", description='" + description + '\'' +
                '}';
    }
}
