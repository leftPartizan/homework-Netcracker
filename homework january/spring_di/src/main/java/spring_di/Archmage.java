package spring_di;

import java.util.List;

public class Archmage {

    private String name;
    private Staff staff;
    private List<String> enemy;
    private int level;

    public Archmage() {
    }

    public Archmage(Staff staff, int level) {
        this.staff = staff;
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public List<String> getEnemy() {
        return enemy;
    }

    public void setEnemy(List<String> enemy) {
        this.enemy = enemy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Staff getStaff() {
        return staff;
    }

    @Override
    public String toString() {
        return "Archmage{" +
                "name='" + name + '\'' +
                ", staff=" + staff +
                ", enemy=" + enemy +
                ", level=" + level +
                '}';
    }
}
