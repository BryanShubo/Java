package com.chapter01.fundaments.sources;

/*************************************************************************
 *  Compilation:  javac Whitelist.java
 *  Execution:    java Whitelist whitelist.txt < data.txt
 *  Dependencies: StaticSetOfInts.java In.java StdOut.java
 *
 *  Data files:   http://algs4.cs.princeton.edu/11model/tinyW.txt
 *                http://algs4.cs.princeton.edu/11model/tinyT.txt
 *                http://algs4.cs.princeton.edu/11model/largeW.txt
 *                http://algs4.cs.princeton.edu/11model/largeT.txt
 *
 *  Whitelist filter.
 *
 *
 *  % java Whitelist tinyW.txt < tinyT.txt
 *  50
 *  99
 *  13
 *
 *  % java Whitelist largeW.txt < largeT.txt | more
 *  499569
 *  984875
 *  295754
 *  207807
 *  140925
 *  161828
 *  [367,966 total values]
 *
 *************************************************************************/

import edu.princeton.cs.algs4.StaticSETofInts;
import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;


public class Whitelist {

    /**
     * Reads in a sequence of integers from the whitelist file, specified as
     * a command-line argument. Reads in integers from standard input and
     * prints to standard output those integers that are not in the file.
     */
    public static void main(String[] args) {
        In in = new In(args[0]);
        int[] white = in.readAllInts();
        StaticSETofInts set = new StaticSETofInts(white);

        // Read key, print if not in whitelist.
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (!set.contains(key))
                StdOut.println(key);
        }
    }
}
