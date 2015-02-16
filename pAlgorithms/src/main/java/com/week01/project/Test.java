package com.week01.project;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdRandom;

/**
 * Created by Shubo on 2/11/2015.
 */
public class Test {

    public static void main(String[] args){
        In in = new In(args[0]);      // input file
        int N = in.readInt();         // N-by-N percolation system
        System.out.println("N is : " + N);

        // repeatedly read in sites to open and draw resulting system
        Percolation perc = new Percolation(N);
        while (!in.isEmpty()) {
            int i = in.readInt();
            int j = in.readInt();
            perc.open(i, j);
            System.out.println("Open site: (" + i + ", " + j + ")");
            System.out.println("isOpen: " + perc.isOpen(i, j));
            System.out.println("isFull: " + perc.isFull(i, j));
            System.out.println("percolation: " + perc.percolates());
        }
    }

}
