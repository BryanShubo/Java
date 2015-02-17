package com.week02.project;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private int N;
    private Node front;
    private Node end;

    private class Node {
        private Item item;
        private Node next;
        private Node pre;
    }

    // construct an empty deque
    public Deque() {
        front = new Node();
        end = new Node();
        front.next = end;
        front.pre = null;
        end.pre = front;
        end.next = null;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return N == 0;
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

        Node temp = end.pre;
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

        Deque<Object> d = new Deque<Object>();

        double[] a = {0.8, 0.0, 0.0, 0.1,0.1,0.0};
        d.addFirst(a[0]);
        d.addFirst(a[1]);
        d.addFirst(a[2]);
        d.addFirst(a[3]);
        d.addFirst(a[4]);
        System.out.println(d.removeLast());

    }
}