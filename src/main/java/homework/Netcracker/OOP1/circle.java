package homework.Netcracker.OOP1;

import java.util.Objects;

public class circle {
    private double  radius = 1.0;
    private String color = "red";

    public circle() {
    }

    public circle(double radius) {
        this.radius = radius;
    }

    public circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "circle{" +
                "radius=" + radius +
                ", color=" + color +
                '}';
    }

    public double getArea() {
        return 2*Math.PI*radius*radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        circle circle = (circle) o;
        return radius == circle.radius &&
                color.equals(this.color);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = result * 31 + Double.hashCode(radius);
        result = result * 31 + color.hashCode();
        return result;
    }
}
