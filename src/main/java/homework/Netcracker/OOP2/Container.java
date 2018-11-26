package homework.Netcracker.OOP2;

import java.util.Objects;

public class Container {
    // нижняя левая точка
    private int x1;
    private int x2;
    // верхнее правая точка
    private int y1;
    private int y2;

    public Container(int x, int y, int width, int height) {
        this.x1 = x;
        this.x2 = x + width;
        this.y1 = y + height;
        this.y2 = y;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public int Getwidth() {
        return x2-x1;
    }

    public int Getheight() {
        return y2-y1;
    }

    public boolean collidesWidth(Ball ball) {
        if (ball.getX() + ball.getRadius() > getX2()){ return false;}
        if (ball.getX() - ball.getRadius() < getX1()){ return false;}
        if (ball.getY() + ball.getRadius() > getY1()){ return false;}
        if (ball.getX() - ball.getRadius() < getY2()){ return false;}
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Container container = (Container) o;
        return x1 == container.x1 &&
                x2 == container.x2 &&
                y1 == container.y1 &&
                y2 == container.y2;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = result * 31 + x1;
        result = result * 31 + x2;
        result = result * 31 + y1;
        result = result * 31 + y2;
        return result;
    }
}
