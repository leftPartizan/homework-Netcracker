package homework.netcracker.oop1;

public class Rectangle {
    private float length = 1.0f;
    private float width = 1.0f;

    public Rectangle() {
    }

    public Rectangle(float length, float width) {
        this.length = length;
        this.width = width;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getwidth() {
        return width;
    }

    public void setwidth(float width) {
        this.width = width;
    }

    public double getArea() {
        return width*length;
    }

    public double getPerimeter() {
        return 4*width;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "length=" + length +
                ",width=" + width +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return length == rectangle.length &&
                width == rectangle.width;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = result * 31 + Float.hashCode(length);
        result = result * 31 + Float.hashCode(width);
        return result;
    }
}
