package homework.netcracker.collections;

public class MainCollect {

    public static void main(String[] args) {
//        MyLinkedList<Integer> c = new MyLinkedList<>();
//        c.getFirst();
//        c.add(10);
//        c.addFirst(20);
//        c.addLast(15);
//        c.add(2, 5);
//        System.out.println(c.get(2));
//        System.out.println(c.getFirst());
//        System.out.println(c.getLast());
//        System.out.println(c.size());
//        System.out.println(c.indexOf(20));
//        System.out.println(c.remove(0));
//        System.out.println(c.set(3,100));
//        Integer[] b = c.toArray(new Integer[c.size()]);
//        System.out.println(b[0]);
//        System.out.println(c.toString());
//        Iterator<Integer> itr = c.iterator();
//        System.out.println(itr.next());
//        System.out.println(itr.hasNext());
//        c.clear();
//        System.out.println(c.size());


        TestsArraylistVsLinklist testA = new TestsArraylistVsLinklist();
        TestMyCollVSLinkedList test0 = new TestMyCollVSLinkedList();
        TestsMaps testC = new TestsMaps();
        TestsSets testB = new TestsSets();
        testC.testGet(5000);

    }
}
