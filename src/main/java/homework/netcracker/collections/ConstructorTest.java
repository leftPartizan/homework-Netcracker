package homework.netcracker.collections;
import java.util.*;


public class ConstructorTest {
    private Random random = new Random();
    private int sizeArray = 10000;
    private int[] randomArray = new int[sizeArray];
    private int[] randomArrayForMap = new int[sizeArray];

    public ConstructorTest() {
        setRandomArray();
    }

    public ConstructorTest(int size) {
        this.sizeArray = size;
        setRandomArray();
    }

    public void setRandomArray() {
        int[] array = new int[this.sizeArray];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(50);
        }
        this.randomArray = array;
    }

    public void setRandomArrayForMap() {
        int[] array = new int[this.sizeArray];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(50);
        }
        this.randomArrayForMap = array;
    }

    public void addAll(AbstractSet<Integer> collection) {
        for (int i : randomArray) {
            collection.add(i);
        }
    }

    public void addAll(AbstractList<Integer> collection) {
        for (int i : randomArray) {
            collection.add(i);
        }
    }

    public void addAll(MyLinkedList<Integer> collection) {
        for (int i : randomArray) {
            collection.add(i);
        }
    }

    public void addAll(Map<Integer, Integer> collection) {
        for (int i = 0; i < randomArray.length; i++) {
            collection.put(randomArrayForMap[i], randomArray[i]);
        }
    }

    public long addOneElementTestTime(AbstractList<Integer> collection, int index, int numberElements) {
        long begin = System.nanoTime();
        int i;
        for (i = 0; i < numberElements; i = i + 1) {
            collection.add(index, 1);
        }
        long end = System.nanoTime();
        long time = end - begin;
        System.out.println("get speed of collection " + Integer.toString(i) + " elements "
                + collection.getClass().getSimpleName() + " = " + time + " nanSec.");
        return time;
    }

    public long addOneElementTestTime(MyLinkedList<Integer> collection, int index, int numberElements) {
        long begin = System.nanoTime();
        int i;
        for (i = 0; i < numberElements; i = i + 1) {
            collection.add(index, 1);
        }
        long end = System.nanoTime();
        long time = end - begin;
        System.out.println("get speed of collection " + Integer.toString(i) + " elements "
                + collection.getClass().getSimpleName() + " = " + time + " nanSec.");
        return time;
    }

    public long addOneElementTestTime(AbstractSet<Integer> collection,int index, int numberElements) {
        long begin = System.nanoTime();
        int i;
        for (i = 0; i < numberElements; i = i + 1) {
            collection.remove(index);
        }
        long end = System.nanoTime();
        long time = end - begin;
        System.out.println("adding speed of collection " + Integer.toString(i) + " elements "
                + collection.getClass().getSimpleName() + " = " + time + " nanSec.");
        return time;
    }

    public long addOneElementTestTime(Map<Integer, Integer> collection, int numberElements) {
        long begin = System.nanoTime();
        int i;
        for (i = 0; i < numberElements; i = i + 1) {
            collection.put(randomArray[i], i);
        }
        long end = System.nanoTime();
        long time = end - begin;
        System.out.println("adding speed of collection "
                + collection.getClass().getSimpleName() + " = " + time + " nanSec.");
        return time;
    }

    public long removeTestTime(AbstractList<Integer> collection, int index, int numberElements) {
        long begin = System.nanoTime();
        int i;
        for (i = 0; i < numberElements; i = i + 1) {
            collection.remove(index);
        }
        long end = System.nanoTime();
        long time = end - begin;
        System.out.println("get speed of collection " + Integer.toString(i) + " elements "
                + collection.getClass().getSimpleName() + " = " + time + " nanSec.");
        return time;
    }

    public long removeTestTime(MyLinkedList<Integer> collection, int index, int numberElements) {
        long begin = System.nanoTime();
        int i;
        for (i = 0; i < numberElements; i = i + 1) {
            collection.remove(index);
        }
        long end = System.nanoTime();
        long time = end - begin;
        System.out.println("get speed of collection " + Integer.toString(i) + " elements "
                + collection.getClass().getSimpleName() + " = " + time + " nanSec.");
        return time;
    }

    public long removeTestTime(AbstractSet<Integer> collection, int beginIndex, int numberElements ) {
        long begin = System.nanoTime();
        int i;
        for (i = beginIndex; i < numberElements; i = i + 1) {
            collection.remove(i);
        }
        long end = System.nanoTime();
        long time = end - begin;
        System.out.println("removing speed of collection " + Integer.toString(i) + " elements "
                + collection.getClass().getSimpleName() + " = " + time + " nanSec.");
        return time;
    }

    public long removeTestTime(Map<Integer, Integer> collection, int numberElements) {
        long begin = System.nanoTime();
        int i;
        for (i = 0; i < numberElements; i ++) {
            collection.remove(randomArrayForMap[i]);
        }
        long end = System.nanoTime();
        long time = end - begin;
        System.out.println("removing speed of collection "
                + collection.getClass().getSimpleName() + " = " + time + " nanSec.");
        return time;
    }

    public long getTestTime(AbstractList<Integer> collection, int index, int numberElements) {
        long begin = System.nanoTime();
        int i;
        for (i = 0; i < numberElements; i = i + 1) {
            collection.get(index + i);
        }
        long end = System.nanoTime();
        long time = end - begin;
        System.out.println("get speed of collection " + Integer.toString(i) + " elements "
                + collection.getClass().getSimpleName() + " = " + time + " nanSec.");
        return time;
    }

    public long getTestTime(MyLinkedList<Integer> collection, int index, int numberElements) {
        long begin = System.nanoTime();
        int i;
        for (i = 0; i < numberElements; i = i + 1) {
            collection.get(index + i);
        }
        long end = System.nanoTime();
        long time = end - begin;
        System.out.println("get speed of collection " + Integer.toString(i) + " elements "
                + collection.getClass().getSimpleName() + " = " + time + " nanSec.");
        return time;
    }

    public long getTestTime(AbstractSet<Integer> collection, int numberElements) {
        long begin = System.nanoTime();
        int i;
        for (i = 0; i < numberElements; i = i + 1) {
            collection.contains(i);
        }
        long end = System.nanoTime();
        long time = end - begin;
        System.out.println("get speed of collection " + Integer.toString(i) + " elements "
                + collection.getClass().getSimpleName() + " = " + time + " nanSec.");
        return time;
    }

    public long getTestTime(Map<Integer, Integer> collection, int numberElements) {
        long begin = System.nanoTime();
        int i;
        for (i = 0; i < numberElements; i = i + 1) {
            collection.containsValue(randomArrayForMap[i]);
        }
        long end = System.nanoTime();
        long time = end - begin;
        System.out.println("get value speed of collection " + Integer.toString(i) + " elements "
                + collection.getClass().getSimpleName() + " = " + time + " nanSec.");
        return time;
    }
}