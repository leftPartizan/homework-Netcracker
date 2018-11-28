package homework.netcracker.collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class TestsMaps {
    private ConstructorTest constructor;
    private HashMap<Integer,Integer> hashMap = new HashMap<>();
    private TreeMap<Integer,Integer> treeMap = new TreeMap<>();
    private LinkedHashMap<Integer,Integer> linkedhashMap = new LinkedHashMap<>();

    public TestsMaps() {
        constructor = new ConstructorTest();
        constructor.setRandomArrayForMap();
        constructor.addAll(this.hashMap);
        constructor.addAll(this.treeMap);
        constructor.addAll(this.linkedhashMap);
    }

    public TestsMaps(int size) {
        constructor = new ConstructorTest(size);
        constructor.setRandomArrayForMap();
        constructor.addAll(this.hashMap);
        constructor.addAll(this.treeMap);
        constructor.addAll(this.linkedhashMap);
    }

    public void testAddOne(int numberElements) {
        hashMap.clear();
        treeMap.clear();
        linkedhashMap.clear();
        long time1 = constructor.addOneElementTestTime(hashMap, numberElements);
        System.out.println();
        long time2 = constructor.addOneElementTestTime(treeMap,numberElements);
        System.out.println();
        long time3 = constructor.addOneElementTestTime(linkedhashMap, numberElements);
        System.out.println();
        if (time1 < time2 && time1 < time3) {
            System.out.println(hashMap.getClass().getSimpleName() + " win ");
        }
        if (time2 < time1 && time2 < time3) {
            System.out.println(treeMap.getClass().getSimpleName() + " win ");
        }
        if (time3 < time2 && time3 < time1) {
            System.out.println(linkedhashMap.getClass().getSimpleName() + " win ");
        }
        if (time1==time2 && time1 == time3) {
            System.out.println("the speed of operations is the same");
        }
    }

    public void testRemove(int numberElements) {
        long time1 = constructor.removeTestTime(hashMap, numberElements);
        System.out.println();
        long time2 = constructor.removeTestTime(treeMap,numberElements);
        System.out.println();
        long time3 = constructor.removeTestTime(linkedhashMap, numberElements);
        System.out.println();
        if (time1 < time2 && time1 < time3) {
            System.out.println(hashMap.getClass().getSimpleName() + " win ");
        }
        if (time2 < time1 && time2 < time3) {
            System.out.println(treeMap.getClass().getSimpleName() + " win ");
        }
        if (time3 < time2 && time3 < time1) {
            System.out.println(linkedhashMap.getClass().getSimpleName() + " win ");
        }
        if (time1==time2 && time1 == time3) {
            System.out.println("the speed of operations is the same");
        }
    }

    public void testGet(int numberElements) {
        long time1 = constructor.getTestTime(hashMap, numberElements);
        System.out.println();
        long time2 = constructor.getTestTime(treeMap, numberElements);
        System.out.println();
        long time3 = constructor.getTestTime(linkedhashMap, numberElements);
        System.out.println();
        if (time1 < time2 && time1 < time3) {
            System.out.println(hashMap.getClass().getSimpleName() + " win ");
        }
        if (time2 < time1 && time2 < time3) {
            System.out.println(treeMap.getClass().getSimpleName() + " win ");
        }
        if (time3 < time2 && time3 < time1) {
            System.out.println(linkedhashMap.getClass().getSimpleName() + " win ");
        }
        if (time1==time2 && time1 == time3) {
            System.out.println("the speed of operations is the same");
        }
    }
}
