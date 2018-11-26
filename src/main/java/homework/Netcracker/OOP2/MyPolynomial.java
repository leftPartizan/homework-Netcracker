package homework.Netcracker.OOP2;

import java.util.Arrays;

public class MyPolynomial {
    private double[] coeffs;

    public MyPolynomial(double[] coeffs) {
        this.coeffs = new double[coeffs.length + 1];
        for (int i = 0; i < coeffs.length; i++) {
            this.coeffs[i] = coeffs[i];

        }
        this.coeffs[coeffs.length] = 0.;
    }

    public int getDegree() {
        return coeffs.length - 1;
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = coeffs.length - 1; i > 0; i--) {
            str = str + coeffs[coeffs.length - 1 - i] + "*x^" + i + " + ";
        }
        str = str + coeffs[coeffs.length - 1];
        return str;
    }

    public double[] getCoeffs() {
        return coeffs;
    }

    public MyPolynomial add(MyPolynomial right) {
        double[] rightCoeffs = right.getCoeffs();
        double[] thisCoeffs = this.coeffs;
        int max_index = Math.max(this.getDegree(),right.getDegree()) - 1;
        double[] a = new double[max_index + 1];
        int raz = Math.max(this.getDegree(),right.getDegree()) - Math.min(this.getDegree(),right.getDegree());

        if (this.getDegree() > right.getDegree()) {
            for (int i = max_index; i >= 0; i--) {
                if (i >= raz) {
                    a[i] = thisCoeffs[i] + rightCoeffs[i - raz];
                }
                else {
                    a[i] =thisCoeffs[i];
                }
            }
        }
        if (this.getDegree() < right.getDegree()) {
            for (int i = max_index; i >= 0; i--) {
                if (i >= raz) {
                    a[i] = thisCoeffs[i - raz] + rightCoeffs[i];
                }
                else {
                    a[i] = rightCoeffs[i];
                }
            }
        }

        if (this.getDegree() < right.getDegree()) {
            a = new double[right.getDegree()];
            for (int i = max_index; i >= 0; i--) {
                a[i] = thisCoeffs[i] + rightCoeffs[i];
            }
        }

        return new MyPolynomial(a);
    }

    public MyPolynomial multiply(MyPolynomial right) {
        double[] rightCoeffs = right.getCoeffs();
        double[] thisCoeffs = this.coeffs;
        int rightMaxDegree = right.getDegree();
        double[] aCoeffsBegin = {0};
        MyPolynomial a = new MyPolynomial(aCoeffsBegin);
        double[] coffs;

        for(int i = 0, thisDegreeDown = this.getDegree(); i < this.getDegree(); i++, thisDegreeDown--) {
            coffs = new double[thisDegreeDown + rightMaxDegree];
            for(int j = 0; j < right.getDegree(); j++) {
                coffs[j] = rightCoeffs[j] * thisCoeffs[i];
            }
            if (i == 0) {
                a = new MyPolynomial(coffs);
            }
            else {
                a = a.add(new MyPolynomial(coffs));
            }

        }
        return a;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyPolynomial that = (MyPolynomial) o;
        return Arrays.equals(coeffs, that.coeffs);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = result * 31 + Arrays.hashCode(coeffs);
        return result;
    }
}