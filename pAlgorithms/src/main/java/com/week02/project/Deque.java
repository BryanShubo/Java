/*
package com.week02.project;

import java.util.Iterator;
import java.util.NoSuchElementException;

*/
/**
 * Your deque implementation must support each deque operation
 * in constant worst-case time and use space proportional to the number of items currently in the deque.
 * Additionally, your iterator implementation must support each operation (including construction)
 * in constant worst-case time.
 *//*

public class Deque<Item> implements Iterable<Item> {
    private int N;
    private Node first;
    private Node last;

    private class Node {
        private Item item;
        private Node next;
        private Node pre;
    }

    // construct an empty deque
    public Deque() {
        first = new Node();
        last = new Node();
        first.next = last;
        first.pre = null;
        last.pre = first;
        last.next = null;
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

        Node oldFirst = first;

        first = new Node();
        first.item = item;
        first.next = oldFirst;
        first.pre = oldFirst.pre;
        oldFirst.pre = first;

        if (N == 0) {
            last = first;
        }
        N++;
    }

    // add the item to the end
    public void addLast(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }

        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.pre = oldLast;
        last.next = oldLast.next;
        oldLast.next = last;
        if (N == 0) { first = last; }

        N++;

    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (N == 0) {
            throw new NoSuchElementException();
        }

        Item result = first.item;
        first = first.next;
        N--;
        return result;
    }


    // remove and return the item from the end
    public Item removeLast() {
        if (N == 0) {
            throw new NoSuchElementException();
        }

        Item result = last.item;
        last = last.pre;
       // last.next = null;
        //System.out.println(last.next);
        N--;
        return result;
    }

    // return an iterator over items in order from front to end
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public boolean hasNext() {
            return current != null;
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

        Deque<String> d = new Deque<String>();

        */
/*String s1 = "A";
        System.out.println("isEmpty: " + d.isEmpty());
        System.out.println("size is: " + d.size());

        d.addFirst(s1);
        System.out.println("Add item: " + s1);
        System.out.println("isEmpty: " + d.isEmpty());
        System.out.println("size is: " + d.size());
        System.out.println("d.first.item: " + d.first.item);

        System.out.println("remove first: " + d.removeFirst());
        System.out.println("isEmpty: " + d.isEmpty());
        System.out.println("size is: " + d.size());

        d.addFirst(s1);
        System.out.println("Add item: " + s1);
        System.out.println("isEmpty: " + d.isEmpty());
        System.out.println("size is: " + d.size());
        System.out.println("d.last.item: " + d.last.item);

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
        System.out.println("d.last.item: " + d.last.item);

        System.out.println("remove last: " + d.removeLast());
        System.out.println("isEmpty: " + d.isEmpty());
        System.out.println("size is: " + d.size());*//*


        String s3 = "C";
        String s4 = "D";
        String s5 = "E";
        String s6 = "F";

        d.addFirst(s3);
        d.addFirst(s4);
        d.addFirst(s5);
        d.addFirst(s6);

       */
/* Iterator itr = d.iterator();
        while (itr.hasNext()) {
            Object i = itr.next();
            System.out.println(i);
        }*//*



        System.out.println(d.first.pre + " : " + d.first.item + " : " + d.first.next);
        System.out.println(d.first.next.pre + " : " + d.first.next.item + " : " + d.first.next.next);

        System.out.println(d.last.pre.pre+ " : " + d.last.pre.item + " : " + d.last.pre.next);
        System.out.println(d.last.pre + " : " + d.last.item + " : " + d.last.next);

        System.out.println(d.last.next.pre + " : " + d.last.next.item + " : " + d.last.next.next);
    }
}*/
