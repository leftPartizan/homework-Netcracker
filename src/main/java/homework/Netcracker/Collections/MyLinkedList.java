package homework.Netcracker.Collections;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements ILinkedList<E> {

    private int size = 0;
    private Node<E> last = new Node<>(null, null);
    private Node<E> first = new Node<>(null, last);

    private static class Node<E> {
        E thing;
        Node<E> next;

        Node(E element, Node<E> next) {
            this.thing = element;
            this.next = next;
        }
    }

    private Node<E> getNodeFirst() {
        return first;
    }

    public Iterator<E> iterator() {
        return new itr();
    }

    private class itr implements Iterator<E> {

        private Node<E> next;
        private Node<E> previous;

        public itr() {
            next = getNodeFirst();
        }

        @Override
        public E next() {
            previous = next;
            next = next.next;
            return previous.thing;
        }

        @Override
        public boolean hasNext() {
            return next.next != null ? true : false;
        }

        @Override
        public void remove() {
            if (next.next != null) {
                previous.next = next.next;
                next = null;
            } else {
                next = null;
                previous.next = null;
            }
        }
    }

    @Override
    public void add(E element) {
        addLast(element);
    }

    public void addFirst(E element) {
        if (size == 0) {
            last = new Node(element, null);
            first = new Node(element, last);
        } else {
            Node<E> tmp = new Node(element, first);
            first = tmp;
        }
        size++;
    }

    public void addLast(E element) {
        if (size == 0) {
            last = new Node(element, null);
            first = new Node(element, last);
        } else {
            Node<E> tmp = new Node(element, null);
            last.next = tmp;
            last = tmp;
        }
        size++;
    }

    @Override
    public void add(int index, E element) {
        Node<E> node = first;
        for (int i = 0; i < index - 1; i++) {
            node = node.next;
        }
        Node<E> newNode = new Node(element, node.next);
        node.next = newNode;
        size++;
    }

    @Override
    public void clear() {
        for (Node<E> node = first; node != null; ) {
            Node<E> next = node.next;
            node.thing = null;
            node.next = null;
            node = next;
        }
        first = last = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        if (node == null)
            throw new NoSuchElementException();
        return node.thing;
    }

    public E getFirst() {
        if (first == null)
            throw new NoSuchElementException();
        return first.thing;
    }

    public E getLast() {
        if (last == null)
            throw new NoSuchElementException();
        return last.thing;
    }

    @Override
    public int indexOf(E element) {
        int index = 0;
        if (element == null) {
            for (Node<E> node = first; node.next != null; node = node.next) {
                if (node.thing == null)
                    return index;
                index++;
            }
            return -1;
        } else {
            for (Node<E> node = first; node.next != null; node = node.next) {
                if (element.equals(node))
                    return index;
            }
            return -1;
        }
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException();
        }
        Node<E> node = first;
        if (index == 0){
            first = first.next;
            E element = node.thing;
            node.next = null;
            node.thing = null;
            size--;
            return element;
        }
        else {
            for (int i = 0; i < index - 1; i++) {
                node = node.next;
            }
            E element = node.thing;
            Node<E> removeElement = node.next;
            node.next = node.next.next;
            removeElement.thing = null;
            removeElement.next = null;
            size--;
            return element;
        }
    }

    @Override
    public E set(int index, E element) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException();
        }
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        node.thing = element;
        return node.thing;
    }

    @Override
    public int size() {
        return size;
    }

    //метод с сигнатурой  - public E[] toArray() нельза реализовать или я не знаю как это сделать
    @Override
    @ SuppressWarnings ("unchecked")
    public E[] toArray(E[] a) {
        if (a.length < size)
            a = (E[]) Array.newInstance(
                    a.getClass().getComponentType(), size);
        Object[] result = a;
        System.out.println(a.length);
        Node<E> x = first;
        for (int i = 0; i < a.length; i++) {
            result[i] = x.thing;
            x = x.next;
        }

        if (a.length > size)
            a[size] = null;
        return a;
    }

    @Override
    public String toString() {
        String string = MyLinkedList.class.getSimpleName() + "[";
        for (Node<E> i = first; i.next != null; i = i.next ) {
            string = string + i.thing.toString() + ", ";
        }
        string = string.substring(0,string.length()-2);
        string+= "]";
        return string;
    }
}
