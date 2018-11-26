package homework.Netcracker.Collections;

import java.util.*;

public class testsArraylistVsLinklist {
    private ConstructorTest constructor;
    private ArrayList<Integer> arrayList = new ArrayList<>();
    private LinkedList<Integer> linkedList = new LinkedList<>();

    public testsArraylistVsLinklist() {
        constructor = new ConstructorTest();
        constructor.addAll(this.arrayList);
        constructor.addAll(this.linkedList);
    }

    public testsArraylistVsLinklist(int size) {
        constructor = new ConstructorTest(size);
        constructor.addAll(this.arrayList);
        constructor.addAll(this.linkedList);
    }

    public void testAddOne(int index, int numberElements) {
        long time1 = constructor.addOneElementTestTime(arrayList, index, numberElements);
        System.out.println();
        long time2 = constructor.addOneElementTestTime(linkedList, index, numberElements);
        System.out.println();
        if (time1 < time2) {
            long time = time2 - time1;
            System.out.println(arrayList.getClass().getSimpleName() + " faster "
                    + linkedList.getClass().getSimpleName() + " for " + time + " nanSec.");
        }
        else {
            long time = time1 - time2;
            System.out.println(linkedList.getClass().getSimpleName() + " faster "
                    + arrayList.getClass().getSimpleName() + " for " + time + " nanSec.");
        }

        if (time1==time2) {
            System.out.println("the speed of operations is the same");
        }
    }

    public void testRemove(int index, int numberElements) {
        long time1 = constructor.removeTestTime(arrayList , index, numberElements);
        System.out.println();
        long time2 = constructor.removeTestTime(linkedList, index, numberElements);
        System.out.println();
        if (time1 < time2) {
            long time = time2 - time1;
            System.out.println(arrayList.getClass().getSimpleName() + " faster "
                    + linkedList.getClass().getSimpleName() + " for " + time + " nanSec.");
        }
        else {
            long time = time1 - time2;
            System.out.println(linkedList.getClass().getSimpleName() + " faster "
                    + arrayList.getClass().getSimpleName() + " for " + time + " nanSec.");
        }

        if (time1==time2) {
            System.out.println("the speed of operations is the same");
        }
    }

    public void testGet(int index, int numberElements) {
        long time1 = constructor.getTestTime(arrayList , index, numberElements);
        System.out.println();
        long time2 = constructor.getTestTime(linkedList, index, numberElements);
        System.out.println();
        if (time1 < time2) {
            long time = time2 - time1;
            System.out.println(arrayList.getClass().getSimpleName() + " faster "
                    + linkedList.getClass().getSimpleName() + " for " + time + " nanSec.");
        }
        else {
            long time = time1 - time2;
            System.out.println(linkedList.getClass().getSimpleName() + " faster "
                    + arrayList.getClass().getSimpleName() + " for " + time + " nanSec.");
        }

        if (time1==time2) {
            System.out.println("the speed of operations is the same");
        }
    }


}
