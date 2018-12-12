public class SolveQquation {
    private double a;
    private double b;
    private double c;
    private double D;
    private String answer;

    public SolveQquation(String as, String bs, String cs) {
        a = Double.parseDouble(as);
        b = Double.parseDouble(bs);
        c = Double.parseDouble(cs);
        D = b * b - 4 * a * c;
        if (D > 0 && a!=0 && b!=0) {
            double x1, x2;
            x1 = (-b - Math.sqrt(D)) / (2 * a);
            x2 = (-b + Math.sqrt(D)) / (2 * a);
            answer = "x1 = " + x1 + ", x2 = " + x2;
        }
        else if (b==0 && a==0){
            answer = "как оригинально)";
        }
        else if (D > 0 && a==0){
            double x;
            x = -c/b;
            answer = "x = " + x;
        }
        else if (D > 0 && b==0){
            double x;
            x = -c/b;
            answer = "x = " + x;
        }

        else if (D == 0) {
            double x;
            x = -b / (2 * a);
            answer = "x = " + x;
        }
        else {
            answer = "нет корней!";
        }
    }

    public String getAnswer() {
        return answer;
    }
}
