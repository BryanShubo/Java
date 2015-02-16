package com.week01.project;

import edu.princeton.cs.introcs.StdRandom;

import java.util.Random;


public class PercolationStats {

    private double[] x;
    private int T;
    private int N;
    private Percolation[] P;
    // perform T independent experiments on an N-by-N grid
    public PercolationStats(int n, int t) {
        if (n <= 0 || t <= 0) { throw new IllegalArgumentException(); }

        this.T = t;
        this.N = n;
        P = new Percolation[T];
        x = new double[T];

        for (int i = 0; i < T; i++) {
            P[i] = new Percolation(N);
        }
    }

    // sample mean of percolation threshold
    public double mean() {

        double xSum = 0;
        for (int i = 0; i < T; i++) {
            xSum += x[i];
        }
        return xSum / T;
    }

    // sample standard deviation of percolation threshold
    public double stddev() {

        double u = mean();
        double sum = 0;
        for (int i = 0; i < T; i++) {
            sum += (x[i] - u) * (x[i] - u);
        }
        return sum / (T - 1);
    }

    // low  endpoint of 95% confidence interval
    public double confidenceLo() {

        double u = mean();
        double theta = Math.sqrt(stddev());
        double result = u - 1.96 * theta / Math.sqrt(T);
        return result;
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi()  {
        double u = mean();
        double theta = Math.sqrt(stddev());
        double result = u + 1.96 * theta / Math.sqrt(T);
        return result;
    }

    // test client (described below)
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        int t = Integer.parseInt(args[1]);
        PercolationStats pTest = new PercolationStats(n, t);

        for (int i = 0; i < t; i++) {
            double openSites = 0;
            while (!pTest.P[i].percolates()) {
                int x = StdRandom.uniform(1, n + 1);
                int y = StdRandom.uniform(1, n + 1);

                if (pTest.P[i].isOpen(x, y)) { continue; }
                pTest.P[i].open(x, y);
                openSites++;
            }

            pTest.x[i] = openSites / (n * n);
        }

        for (int i = 0; i < t; i++) {
            System.out.println(pTest.x[i]);
        }

        System.out.println("mean: " + pTest.mean());
        System.out.println("stddev: " + pTest.stddev());
        System.out.println("confidence interval: " + pTest.confidenceLo() + " " + pTest.confidenceHi());


    }
}
