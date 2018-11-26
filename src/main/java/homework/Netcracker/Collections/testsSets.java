package homework.Netcracker.Collections;

import java.util.*;

public class testsSets {

    private ConstructorTest constructor;
    private HashSet<Integer> hashSet = new HashSet<>();
    private TreeSet<Integer> treeSet = new TreeSet<>();
    private LinkedHashSet<Integer> linkedhashSet = new LinkedHashSet<>();

    public testsSets() {
        constructor = new ConstructorTest();
        constructor.addAll(this.hashSet);
        constructor.addAll(this.treeSet);
        constructor.addAll(this.linkedhashSet);
    }

    public testsSets(int size) {
        constructor = new ConstructorTest(size);
        constructor.addAll(this.hashSet);
        constructor.addAll(this.treeSet);
        constructor.addAll(this.linkedhashSet);
    }

    public void testAddOne(int index, int numberElements) {
        long time1 = constructor.addOneElementTestTime(hashSet,index, numberElements);
        System.out.println();
        long time2 = constructor.addOneElementTestTime(treeSet,index, numberElements);
        System.out.println();
        long time3 = constructor.addOneElementTestTime(linkedhashSet,index, numberElements);
        System.out.println();
        if (time1 < time2 && time1 < time3) {
            System.out.println(hashSet.getClass().getSimpleName() + " win ");
        }
        if (time2 < time1 && time2 < time3) {
            System.out.println(treeSet.getClass().getSimpleName() + " win ");
        }
        if (time3 < time2 && time3 < time1) {
            System.out.println(linkedhashSet.getClass().getSimpleName() + " win ");
        }
        if (time1==time2 && time1 == time3) {
            System.out.println("the speed of operations is the same");
        }
    }

    public void testRemove(int beginIndex, int numberElements) {
        long time1 = constructor.removeTestTime(hashSet, beginIndex, numberElements);
        System.out.println();
        long time2 = constructor.removeTestTime(treeSet,beginIndex, numberElements);
        System.out.println();
        long time3 = constructor.removeTestTime(linkedhashSet, beginIndex, numberElements);
        System.out.println();
        if (time1 < time2 && time1 < time3) {
            System.out.println(hashSet.getClass().getSimpleName() + " win ");
        }
        if (time2 < time1 && time2 < time3) {
            System.out.println(treeSet.getClass().getSimpleName() + " win ");
        }
        if (time3 < time2 && time3 < time1) {
            System.out.println(linkedhashSet.getClass().getSimpleName() + " win ");
        }
        if (time1==time2 && time1 == time3) {
            System.out.println("the speed of operations is the same");
        }
    }

    public void testGet(int index, int numberElements) {
        long time1 = constructor.getTestTime(hashSet, numberElements);
        System.out.println();
        long time2 = constructor.getTestTime(treeSet, numberElements);
        System.out.println();
        long time3 = constructor.getTestTime(linkedhashSet, numberElements);
        System.out.println();
        if (time1 < time2 && time1 < time3) {
            System.out.println(hashSet.getClass().getSimpleName() + " win ");
        }
        if (time2 < time1 && time2 < time3) {
            System.out.println(treeSet.getClass().getSimpleName() + " win ");
        }
        if (time3 < time2 && time3 < time1) {
            System.out.println(linkedhashSet.getClass().getSimpleName() + " win ");
        }
        if (time1==time2 && time1 == time3) {
            System.out.println("the speed of operations is the same");
        }
    }
}
