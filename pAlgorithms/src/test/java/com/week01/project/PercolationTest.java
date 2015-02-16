package com.week01.project;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

//@RunWith(Parameterized.class)
public class PercolationTest {

  /*  private int n;

    @Parameterized.Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0},
                {1},
                {2},
                {-3},
                {4},
                {-5}
        });
    }

    public PercolationTest(int n) {
        this.n = n;
    }

    @Test//(expected = IllegalArgumentException.class)
    public void testPercolatesConstructor() throws Exception {
        if (n <= 0) {
            System.out.println("Percolation constructor with parameter " + n);
            new Percolation(n);
        } else {
            System.out.println("Percolation constructor with parameter " + n);
            Percolation p = new Percolation(n);
            for (int i = 0; i < n * n + 2; i++) {
                System.out.print(p.grid[i] + " ");
            }
            System.out.println();
        }
    }*/



    @Test
    public void testOpen() throws Exception {

        int N = 10;
        Percolation p = new Percolation(N);
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.print(p.isOpen(i, j) + " ");
            }
            System.out.println();
        }
        System.out.println("++++++++++++++++++++++++++++++++++");
        p.open(1,2);
        p.open(2,3);
        p.open(3,4);

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.print(p.isOpen(i, j) + " ");
            }
            System.out.println();
        }
        System.out.println("++++++++++++++++++++++++++++++++++");

        System.out.println("(1, 2) connect to peak: " + p.isFull(1, 2));
        System.out.println("(2, 3) connect to peak: " + p.isFull(2, 3));

        p.open(10, 10);
        p.open(9, 10);
        System.out.println("++++++++++++++++++++++++++++++++++");

        System.out.println("percolate: " + p.percolates());

    }

    @Test
    public void testPercolate() throws Exception {

        int N = 10;
        Percolation p = new Percolation(N);

        double openSites = 0;
        while(!p.percolates()) {
            Random rand = new Random();
            int min = 1;
            int x = rand.nextInt(N - min + 1) + min;
            int y = rand.nextInt(N - min + 1) + min;

            if(p.isOpen(x, y)) { continue;}
            p.open(x, y);
            openSites++;
        }

        System.out.println(openSites);

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.print(p.isOpen(i, j) + " ");
            }
            System.out.println();
        }
    }
}