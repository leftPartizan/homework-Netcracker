package homework.netcracker.homework2;
import java.util.Arrays;
import java.util.Random;

public class Sorts {
    private int[] array;

    public void setArray(int n) {
        final Random random = new Random();
        this.array = new int[n];
        for(int i = 0; i<this.array.length; i++) {
            this.array[i] = random.nextInt(100);
        }
    }

    public int[] getArray() {
        return array;
    }

    public int[] arrayCloneSort() {
        int[] arrayClone = this.array.clone();
        long begin = System.nanoTime();
        Arrays.sort(arrayClone);
        long end = System.nanoTime();
        long a = end - begin;
        System.out.println("time array sort " + a + " nano sec");
        return arrayClone;
    }

    public int[] arrayCloneSelectionsSort() {
        int[] arrayClone = this.array.clone();
        long begin = System.nanoTime();
        for (int i = 0; i < arrayClone.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arrayClone.length; j++) {
                if (arrayClone[j] < arrayClone[min]) {
                    min = j;
                }
            }
            int tmp = arrayClone[i];
            arrayClone[i] = arrayClone[min];
            arrayClone[min] = tmp;
        }
        long end = System.nanoTime();
        long a = end - begin;
        System.out.println("time selections sort " + a + " nano sec");
        return arrayClone;
    }

    public int[] arrayCloneBubbleSort() {
        int[] arrayClone = this.array.clone();
        long begin = System.nanoTime();
        int count = 0;
        while (count != arrayClone.length - 1) {
            count = 0;
            for (int i = 0; i < arrayClone.length - 1; i++) {
                if (arrayClone[i] > arrayClone[i + 1]) {
                    int tmp = arrayClone[i];
                    arrayClone[i] = arrayClone[i + 1];
                    arrayClone[i + 1] = tmp;
                } else {
                    count++;
                }
            }
        }
        long end = System.nanoTime();
        long a = end - begin;
        System.out.println("time bubble sort " + a + " nano sec");
        return arrayClone;
    }

    public void testSorts() {
        arrayCloneSort();
        arrayCloneSelectionsSort();
        arrayCloneBubbleSort();
    }
}
