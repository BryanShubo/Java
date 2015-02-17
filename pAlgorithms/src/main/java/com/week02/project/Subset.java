package com.week02.project;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/**
 * Created by Shubo on 2/15/2015.
 */
public class Subset {

    public static void main(String[] args) {

        RandomizedQueue<String> rq = new RandomizedQueue();
        while (!StdIn.isEmpty()) {
            rq.enqueue(StdIn.readString());
        }

        int k = Integer.parseInt(args[0]);
        for (int i = 0; i < k; i++) {
            StdOut.println(rq.dequeue());
        }
    }
}
