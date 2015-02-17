package com.week02.project;

import edu.princeton.cs.introcs.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Your randomized queue implementation must support each randomized
 * queue operation (besides creating an iterator) in constant amortized time and use space
 * proportional to the number of items currently in the queue. That is, any sequence of
 * M randomized queue operations (starting from an empty queue) should take at most cM steps
 * in the worst case, for some constant c. Additionally, your iterator implementation must
 * support operations next() and hasNext() in constant worst-case time; and construction in
 * linear time; you may use a linear amount of extra memory per iterator.
 */
public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] a;         // array of items
    private int N;            // number of elements on queue

    // construct an empty randomized queue
    public RandomizedQueue() {
        a = (Item[]) new Object[2];
    }


    // is the queue empty?
    public boolean isEmpty() {
        return N == 0;
    }


    // return the number of items on the queue
    public int size() {
        return N;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }

        if (N == a.length) resize(2 * a.length);    // double size of array if necessary
        a[N++] = item;                            // add item

    }


    // remove and return a random item
    public Item dequeue() {
        if (N == 0) {
            throw new NoSuchElementException();
        }

        int x = StdRandom.uniform(0, N);
        Item result = a[x];

        for (int i = x; i < N - 1; i++) {
            a[i] = a[i + 1];
        }

        if (N > 0 && N == a.length/4) resize(a.length/2);
        N--;
        return result;
    }

    // return (but do not remove) a random item
    public Item sample() {
        if (N == 0) {
            throw new NoSuchElementException();
        }

        int x = StdRandom.uniform(0, N);
        return a[x];
    }


    // return an independent iterator over items in random order

    // return an iterator over items in order from front to end
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private int[] seq = getShuffle();
        private Item current = a[seq[0]];
        private int counter = 0;

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public boolean hasNext() {
            return counter < N;
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current;
            current = a[seq[counter++]];
            return item;
        }

    }


    // resize the underlying array holding the elements
    private void resize(int capacity) {
        assert capacity >= N;
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    private int[] getShuffle() {
        int[] x = new int[N];
        for (int i = 0; i < N; i++) {
            x[i] = i;
        }
        StdRandom.shuffle(x);
        return x;
    }

    // unit testing
    public static void main(String[] args) {
        RandomizedQueue rq = new RandomizedQueue();
        int[] data1 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] data2 = data1;
        StdRandom.shuffle(data2);
        for (int i = 0; i < 10; i++) {
            rq.enqueue(data1[i]);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(rq.dequeue());
        }


    }
}