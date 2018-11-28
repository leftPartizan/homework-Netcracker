package homework.netcracker.oop2;

public class MyComplex {
    private double real = 0.;
    private double imag = 0.;

    public MyComplex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public void setValue(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    @Override
    public String toString() {
        return "(" + real +
                "+" + imag +
                "i)";
    }

    public boolean isReal() {
        if (real != 0) {return Boolean.TRUE;}
        else {return Boolean.FALSE;}
    }

    public boolean isImaginary() {
        if (imag != 0) {return Boolean.TRUE;}
        else {return Boolean.FALSE;}
    }

    public boolean equals(double real, double imag) {
        if (this.real == real && this.imag == imag) {return Boolean.TRUE;}
        else {return Boolean.FALSE;}
    }

    public boolean equals(MyComplex another) {
        if (this.real == another.real && this.imag == another.imag) {return Boolean.TRUE;}
        else {return Boolean.FALSE;}
    }

    public double magnitude() {
        return Math.sqrt(real*real + imag*imag);
    }

    public double argument() {
        return Math.atan2(imag, real);
    }

    public MyComplex add(MyComplex right) {
        real = real + right.real;
        imag = imag + right.imag;
        return this;
    }

    public MyComplex addNew(MyComplex right) {
        double a = real + right.real;
        double b = imag + right.imag;
        return new MyComplex(a,b);
    }

    public MyComplex substract(MyComplex right) {
        real = real - right.real;
        imag = imag - right.imag;
        return this;
    }

    public MyComplex substractNew(MyComplex right) {
        double a = real - right.real;
        double b = imag - right.imag;
        return new MyComplex(a,b);
    }

    public MyComplex multiply(MyComplex right) {
        real = real * right.real;
        imag = imag * right.imag;
        return this;
    }

    public MyComplex divide(MyComplex right) {
        real = real / right.real;
        imag = imag / right.imag;
        return this;
    }

    public MyComplex conjugate() {
        return new MyComplex(real, -imag);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyComplex myComplex = (MyComplex) o;
        return myComplex.real == real &&
                myComplex.imag == imag;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = result * 31 + Double.hashCode(real);
        result = result * 31 + Double.hashCode(imag);
        return result;
    }
}
