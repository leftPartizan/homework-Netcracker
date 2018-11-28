package homework.netcracker.oop2;

public class Ball {
    private float x;
    private float y;
    private int radius;
    private float xDelta;
    private float yDelta;

    public Ball(float x, float y, int radius, int speed, int direction  ) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.xDelta = (float) (speed * Math.cos(direction));
        this.yDelta = (float) (- speed * Math.sin(direction));
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public float getxDelta() {
        return xDelta;
    }

    public void setxDelta(float xDelta) {
        this.xDelta = xDelta;
    }

    public float getyDelta() {
        return yDelta;
    }

    public void setyDelta(float yDelta) {
        this.yDelta = yDelta;
    }

    public void move() {
        x+=xDelta;
        y+=yDelta;
    }

    public void reflectHorizontal() {
        xDelta = -xDelta;
    }

    public void reflectVertical() {
        yDelta = - yDelta;
    }

    @Override
    public String toString() {
        return "Ball[(" + x + "," + y + "),speed=(" + xDelta + "," + yDelta + ")]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return ball.x == x &&
                y == ball.y &&
                radius == ball.radius &&
                xDelta == ball.xDelta &&
                yDelta == ball.yDelta ;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = result * 31 + Float.hashCode(x);
        result = result * 31 + Float.hashCode(y);
        result = result * 31 + Float.hashCode(xDelta);
        result = result * 31 + Float.hashCode(yDelta);
        return result;
    }
}
