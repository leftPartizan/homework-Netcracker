package homework.Netcracker.homework2;
import java.util.*;

public class OneDimensionalArray {

    public static void a() {
        List<Integer> array = new ArrayList<>();
        for(int i = 1; i < 100; i++) {
            if (i % 2 != 0) {
                array.add(i);
            }
        }
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    public static void b() {
        Random random = new Random();
        int[] array = new int[20];
        int count1 = 0;
        int count2 = 0;
        for (int i=0; i < 20; i++) {
            array[i] = random.nextInt(10);
            System.out.print(array[i] + " ");
            if (array[i] % 2 == 0) {
                count1++;
            }
            else {
                count2++;
            }
        }
        System.out.println();
        System.out.println("positive numbers " + count1);
        System.out.println("negative numbers " + count2);
    }

    public static void c() {
        Random random = new Random();
        int[] array = new int[10];
        for (int i=0; i < 10; i++) {
            array[i] = random.nextInt(99) + 1;
            System.out.print(array[i] + " ");
        }

        System.out.println();
        System.out.println();

        for (int i=0; i < 10; i++) {
            if (i % 2 != 0){
                array[i] = 0;
            }
            System.out.print(array[i] + " ");
        }
    }

    public static void d() {
        Random random = new Random();
        ArrayList<Integer> array = new ArrayList<>();
        for (int i=0; i < 15; i++) {
            array.add(random.nextInt(100) - 50);
        }
        array.forEach(x -> System.out.print(x + " "));
        System.out.println();
        int max = Collections.max(array);
        int indexMax = array.lastIndexOf(max);
        int min = Collections.min(array);
        int indexMin  = array.lastIndexOf(min);
        System.out.println(max + " ,Last index = " + indexMax );
        System.out.println(min + " ,Last index = " + indexMin);
    }

    public static void e() {
        Random random = new Random();
        ArrayList<Integer> array1 = new ArrayList<>();
        ArrayList<Integer> array2 = new ArrayList<>();
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < 10; i++) {
            int value1 = random.nextInt(10);
            int value2 = random.nextInt(10);
            sum1 = sum1 + value1;
            sum2 = sum2 + value2;
            array1.add(value1);
            array2.add(value2);
        }

        if (sum1/10 > sum2/10) {
            System.out.println("array 1 mean > array 2 mean");
        }

        if (sum1/10 < sum2/10) {
            System.out.println("array 1 mean < array 2 mean");
        }

        if (sum1/10 == sum2/10) {
            System.out.println("array 1 mean = array 2 mean");
        }
    }

    public static void f() {
        Random random = new Random();
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            array.add(random.nextInt(3) - 1);

        }

        array.forEach(x -> System.out.print(x + " "));
        System.out.println();
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i: array) {
            if (map.containsKey(i) == false) {
                map.put(i, 0);
            }
            if (map.containsKey(i)){
                map.replace(i,map.get(i) + 1);
            }
        }
        map.values().forEach(x -> System.out.print(x + " "));
        int max = Collections.max(map.values());
        System.out.println();
        for (int i : map.keySet()) {
            if (map.get(i) == max) {
                System.out.println("number " + i + " count=" + max);
            }
        }
    }

}
