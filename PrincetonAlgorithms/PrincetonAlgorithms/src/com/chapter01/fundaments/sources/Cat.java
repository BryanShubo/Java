package com.chapter01.fundaments.sources;

/*************************************************************************
 *  Compilation:  javac Cat.java
 *  Execution:    java Cat input0.txt input1.txt ... output.txt
 *  Dependencies: In.java Out.java
 *
 *  Reads in text files specified as the first command-line
 *  arguments, concatenates them, and writes the result to
 *  filename specified as the last command-line arguments.
 *************************************************************************/

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.Out;

public class Cat {

    // this class should not be instantiated
    private Cat() { }

    /**
     * Reads in a sequence of text files specified as the first command-line
     * arguments, concatenates them, and writes the results to the file
     * specified as the last command-line argument.
     */
    public static void main(String[] args) {
        Out out = new Out(args[args.length - 1]);
        for (int i = 0; i < args.length - 1; i++) {
            In in = new In(args[i]);
            String s = in.readAll();
            out.println(s);
            in.close();
        }
        out.close();
    }

}

