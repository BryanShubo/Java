package com.chapter01.fundaments.sources;

/*************************************************************************
 *  Compilation:  javac RandomSeq.java
 *  Execution:    java RandomSeq N lo hi
 *
 *  Prints N numbers between lo and hi.
 *
 *  % java RandomSeq 5 100.0 200.0
 *  123.43
 *  153.13
 *  144.38
 *  155.18
 *  104.02
 *
 *************************************************************************/

import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;


public class RandomSeq {

    // this class should not be instantiated
    private RandomSeq() { }


    /**
     * Reads in two command-line arguments lo and hi and prints N uniformly
     * random real numbers in [lo, hi) to standard output.
     */
    public static void main(String[] args) {

        // command-line arguments
        int N = Integer.parseInt(args[0]);

        // for backward compatibility with Intro to Programming in Java version of RandomSeq
        if (args.length == 1) {
            // generate and print N numbers between 0.0 and 1.0
            for (int i = 0; i < N; i++) {
                double x = StdRandom.uniform();
                StdOut.println(x);
            }
        }

        else if (args.length == 3) {
            double lo = Double.parseDouble(args[1]);
            double hi = Double.parseDouble(args[2]);

            // generate and print N numbers between lo and hi
            for (int i = 0; i < N; i++) {
                double x = StdRandom.uniform(lo, hi);
                StdOut.printf("%.2f\n", x);
            }
        }

        else {
            throw new IllegalArgumentException("Invalid number of arguments");
        }
    }
}