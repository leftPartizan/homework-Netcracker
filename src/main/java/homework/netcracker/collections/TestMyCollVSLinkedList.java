package homework.netcracker.collections;

import java.util.*;

public class TestMyCollVSLinkedList {
    private ConstructorTest constructor;
    private MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
    private LinkedList<Integer> linkedList = new LinkedList<>();

    public TestMyCollVSLinkedList() {
        constructor = new ConstructorTest();
        constructor.addAll(this.myLinkedList);
        constructor.addAll(this.linkedList);
    }

    public TestMyCollVSLinkedList(int size) {
        constructor = new ConstructorTest(size);
        constructor.addAll(this.myLinkedList);
        constructor.addAll(this.linkedList);
    }

    public void testAddOne(int index, int numberElements) {
        long time1 = constructor.addOneElementTestTime(myLinkedList, index, numberElements);
        System.out.println();
        long time2 = constructor.addOneElementTestTime(linkedList, index, numberElements);
        System.out.println();
        if (time1 < time2) {
            long time = time2 - time1;
            System.out.println(myLinkedList.getClass().getSimpleName() + " faster "
                    + linkedList.getClass().getSimpleName() + " for " + time + " nanSec.");
        }
        else {
            long time = time1 - time2;
            System.out.println(linkedList.getClass().getSimpleName() + " faster "
                    + myLinkedList.getClass().getSimpleName() + " for " + time + " nanSec.");
        }

        if (time1==time2) {
            System.out.println("the speed of operations is the same");
        }
    }

    public void testRemove(int index, int numberElements) {
        long time1 = constructor.removeTestTime(myLinkedList , index, numberElements);
        System.out.println();
        long time2 = constructor.removeTestTime(linkedList, index, numberElements);
        System.out.println();
        if (time1 < time2) {
            long time = time2 - time1;
            System.out.println(myLinkedList.getClass().getSimpleName() + " faster "
                    + linkedList.getClass().getSimpleName() + " for " + time + " nanSec.");
        }
        else {
            long time = time1 - time2;
            System.out.println(linkedList.getClass().getSimpleName() + " faster "
                    + myLinkedList.getClass().getSimpleName() + " for " + time + " nanSec.");
        }

        if (time1==time2) {
            System.out.println("the speed of operations is the same");
        }
    }

    public void testGet(int index, int numberElements) {
        long time1 = constructor.getTestTime(myLinkedList , index, numberElements);
        System.out.println();
        long time2 = constructor.getTestTime(linkedList, index, numberElements);
        System.out.println();
        if (time1 < time2) {
            long time = time2 - time1;
            System.out.println(myLinkedList.getClass().getSimpleName() + " faster "
                    + linkedList.getClass().getSimpleName() + " for " + time + " nanSec.");
        }
        else {
            long time = time1 - time2;
            System.out.println(linkedList.getClass().getSimpleName() + " faster "
                    + myLinkedList.getClass().getSimpleName() + " for " + time + " nanSec.");
        }

        if (time1==time2) {
            System.out.println("the speed of operations is the same");
        }
    }

}
