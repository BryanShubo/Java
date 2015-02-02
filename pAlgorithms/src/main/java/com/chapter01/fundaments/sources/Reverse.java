package com.chapter01.fundaments.sources;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/*************************************************************************
 *  Compilation:  javac Reverse.java
 *  Execution:    java Reverse
 *  Dependencies: Stack.java StdOut.java StdIn.java
 *
 *  Read a sequence of integers from standard input and print them
 *  in reverse order.
 *
 *  % java Reverse
 *  1 2 3 4 5
 *  5
 *  4
 *  3
 *  2
 *  1

 *************************************************************************/

public class Reverse {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
/*        while (!StdIn.isEmpty()) {
            stack.push(StdIn.readInt());
        }*/
        stack.push(100);
        stack.push(10);
        stack.push(1);
        for (int i : stack) {
            StdOut.println(i);
        }
    }
}
