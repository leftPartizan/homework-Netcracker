package homework.netcracker.homework2;

public class Factorials {

    public static int notRecursive(int n) {
        int fact = 1;
        for(int i = 1; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }
    public static int recursively(int n) {
        int fact = 0;
        if (n != 0) {
            fact = n * recursively(n-1);
        }
        return fact;
    }

    public static void compareTime2methods(int n) {
        long begin1 = System.nanoTime();
        notRecursive(n);
        long end1  = System.nanoTime();
        long time1 = end1-begin1;
        System.out.println("not recursive " + time1 + " nano sec");
        long begin2 = System.nanoTime();
        recursively(n);
        long end2  = System.nanoTime();
        long time2 = end2-begin2;
        System.out.println("recursively " + time2 + " nano sec");
    }
}
