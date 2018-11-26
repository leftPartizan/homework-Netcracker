package homework.Netcracker.homework2;

import java.util.Arrays;
import java.util.Random;

public class MultyDimensionalArray {
    public static void a() {
        Random random = new Random();
        int size = 8;
        int[][] array = new int[size][size];
        int sumDiag1 = 0;
        int sumDiag2 = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                array[i][j] = random.nextInt(99) + 1;
                if (i == j) {
                    sumDiag1 = sumDiag1 + array[i][j];
                }

                if (i == size - j - 1) {
                    sumDiag2 = sumDiag2 + array[i][j];
                }

            }
        }
        System.out.println("sum diag 1=" + sumDiag1);
        System.out.println("sum diag 2=" + sumDiag2);
    }

    public static void b() {
        Random random = new Random();
        int x = 8;
        int y = 5;
        int[][] array = new int[x][y];
        int max = -99;
        int maxX = 0;
        int maxY = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                array[i][j] = random.nextInt(186) - 99;
                System.out.print(array[i][j] + " ");
                if (array[i][j] > max) {
                    max = array[i][j];
                    maxX = i;
                    maxY = j;
                }
            }
            System.out.println();
        }
        System.out.println("max element " + max + " x=" + maxX + ", y=" + maxY);
    }

    public static void c() {
        Random random = new Random();
        int x = 8;
        int y = 5;
        int[][] array = new int[x][y];
        double maxStroka = 0.;
        int indexStroka = 0;
        for (int i = 0; i < x; i++) {
            double proizvedenieStroki = 1.;
            for (int j = 0; j < y; j++) {
                array[i][j] = random.nextInt(20) - 10;
                proizvedenieStroki = array[i][j] * proizvedenieStroki;
                System.out.print(array[i][j] + " ");
            }
            if (maxStroka < Math.abs(proizvedenieStroki)) {
                maxStroka = Math.abs(proizvedenieStroki);
                indexStroka = i;
            }
            System.out.println();
        }
        System.out.println("index stroki " + indexStroka);
    }

    public static void d() {
        Random random = new Random();
        int x = 3;
        int y = 3;
        int[][] array = new int[x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                array[i][j] = random.nextInt(100);
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        for (int i = 0; i < x; i++) {
            int[] stroka = new int[x];
            for (int j = 0; j < y; j++) {
                stroka[j] = array[i][j];
            }

            Arrays.sort(stroka);

            for (int j = 0; j < y; j++) {
                array[i][j] = stroka[j];
                System.out.print(array[i][j]+ " ");
            }

            System.out.println();
        }
    }
}
