package com.week02.project;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Your deque implementation must support each deque operation
 * in constant worst-case time and use space proportional to the number of items currently in the deque.
 * Additionally, your iterator implementation must support each operation (including construction)
 * in constant worst-case time.
 */
public class Deque1<Item> implements Iterable<Item> {
    private int N;
    private Node front;
    private Node end;

    private class Node {
        private Item item;
        private Node next;
        private Node pre;
    }

    // construct an empty deque
    public Deque1() {
        front = new Node();
        end = new Node();
        front.next = end;
        front.pre = null;
        end.pre = front;
        end.next = null;
    }

    // is the deque empty?
    public boolean isEmpty() {
        if (N == 0) {
            return true;
        }
        return false;
    }

    // return the number of items on the deque
    public int size() {
        return N;
    }


    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }

        Node first = new Node();
        first.item = item;
        front.next.pre = first;
        first.next = front.next;

        front.next = first;
        first.pre = front;

        N++;
    }

    // add the item to the end
    public void addLast(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }

        Node last = new Node();
        last.item = item;
        last.pre = end.pre;
        end.pre = last;
        last.next = end;
        last.pre.next = last;

        N++;

    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (N == 0) {
            throw new NoSuchElementException();
        }

        Node temp = front.next;
        Item result = temp.item;


        front.next = front.next.next;
        front.next.pre = front;

        temp.pre = null;
        temp.next = null;
        temp.item = null;
        N--;
        return result;
    }


    // remove and return the item from the end
    public Item removeLast() {
        if (N == 0) {
            throw new NoSuchElementException();
        }

        Node temp = new Node();
        Item result = temp.item;

        end.pre = end.pre.pre;
        end.pre.next = end;

        temp.item = null;
        temp.pre = null;
        temp.next = null;
        N--;
        return result;
    }

    // return an iterator over items in order from front to end
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = front.next;

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public boolean hasNext() {
            return current.item != null;
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }

    }

    // unit testing
    public static void main(String[] args) {

        Deque1<String> d = new Deque1<String>();

        String s1 = "A";
        System.out.println("isEmpty: " + d.isEmpty());
        System.out.println("size is: " + d.size());

        d.addFirst(s1);
        System.out.println("Add item: " + s1);
        System.out.println("isEmpty: " + d.isEmpty());
        System.out.println("size is: " + d.size());
        System.out.println("d.first.item: " + d.front.next.item);

        System.out.println("remove first: " + d.removeFirst());
        System.out.println("isEmpty: " + d.isEmpty());
        System.out.println("size is: " + d.size());

        d.addFirst(s1);
        System.out.println("Add item: " + s1);
        System.out.println("isEmpty: " + d.isEmpty());
        System.out.println("size is: " + d.size());
        System.out.println("d.last.item: " + d.end.pre.item);

        System.out.println("remove last: " + d.removeLast());
        System.out.println("isEmpty: " + d.isEmpty());
        System.out.println("size is: " + d.size());

        String s2 = "B";
        System.out.println("isEmpty: " + d.isEmpty());
        System.out.println("size is: " + d.size());

        d.addLast(s2);
        System.out.println("Add item: " + s2);
        System.out.println("isEmpty: " + d.isEmpty());
        System.out.println("size is: " + d.size());
        System.out.println("d.last.item: " + d.end.pre.item);

        System.out.println("remove last: " + d.removeLast());
        System.out.println("isEmpty: " + d.isEmpty());
        System.out.println("size is: " + d.size());

        String s3 = "C";
        String s4 = "D";
        String s5 = "E";
        String s6 = "F";

        d.addFirst(s1);
        d.addFirst(s2);
        d.addFirst(s3);
        d.addFirst(s4);
        d.addFirst(s5);
        d.addFirst(s6);

        d.addLast(s1);
        d.addLast(s2);
        d.addLast(s3);
        d.addLast(s4);
        d.addLast(s5);
        d.addLast(s6);

        Iterator itr = d.iterator();
        while (itr.hasNext()) {
            Object i = itr.next();
            System.out.println(i);
        }
    }
}