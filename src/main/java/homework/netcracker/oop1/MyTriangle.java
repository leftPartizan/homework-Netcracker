package homework.netcracker.oop1;

public class MyTriangle {
    private MyPoint v1;
    private MyPoint v2;
    private MyPoint v3;

    public MyTriangle(MyPoint v1, MyPoint v2, MyPoint v3) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    public MyTriangle(int x1, int y1, int x2,int y2, int x3, int y3) {
        this.v1 = new MyPoint(x1,y1);
        this.v2 = new MyPoint(x2,y2);
        this.v3 = new MyPoint(x3,y3);
    }

    @Override
    public String toString() {
        return "MyTriangle{" +
                "v1=" + v1.getXY() +
                ", v2=" + v2.getXY() +
                ", v3=" + v3.getXY() +
                '}';
    }

    public double getPerimetr() {
        return v1.distance(v2) + v2.distance(v3) + v3.distance(v1);
    }

    public String getType() {
        if (v1.distance(v2) == v2.distance(v3) && v2.distance(v3) == v3.distance(v1)) return "Equilateral";
        if (v1.distance(v2) == v2.distance(v3) || v2.distance(v3) == v3.distance(v1) || v1.distance(v2) == v1.distance(v3)) return "Isosceles";
        else return "Scalene";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyTriangle that = (MyTriangle) o;
        return v1.equals(that.v1) && v2.equals(that.v2) && v2.equals(that.v2);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = result * 31 + v1.hashCode();
        result = result * 31 + v2.hashCode();
        result = result * 31 + v3.hashCode();
        return result;
    }
}
