package com.week01.project;

import com.chapter01.fundaments.sources.WeightedQuickUnionUF;

/**
 * Created by Shubo on 2/8/2015.
 */
public class Percolation {

    private boolean[] grid;
    private int N;
    private int peak;
    private int bottom;
    private WeightedQuickUnionUF uf;
    private WeightedQuickUnionUF uf1;

    // create N-by-N grid, with all sites blocked
    public Percolation(int input) {
        if (input <= 0) {
            throw new IllegalArgumentException();
        }
        this.N = input;
        this.peak = N * N;
        this.bottom = N * N + 1;
        uf = new WeightedQuickUnionUF(N * N + 2);
        uf1 = new WeightedQuickUnionUF(N * N + 1);

        grid = new boolean[N * N + 2];
        grid[peak] = true;
        grid[bottom] = true;
    }

    // open site (row i, column j) if it is not open already
    public void open(int i, int j) {
        validIndex(i, j);

        if (isOpen(i, j)) { return; }

        setGrid(i, j);

        if (i == 1) {
            uf.union(id(i, j), peak);
            uf1.union(id(i, j), peak);
        }
        if (i == N) uf.union(id(i, j), bottom);

        //connect to left site
        if (validBound(i, j - 1) && isOpen(i, j - 1)) {
            uf.union(id(i, j), id(i, j - 1));
            uf1.union(id(i, j), id(i, j - 1));
        }

        //connect to right site
        if (validBound(i, j + 1) && isOpen(i, j + 1)) {
            uf.union(id(i, j), id(i, j + 1));
            uf1.union(id(i, j), id(i, j + 1));
        }

        //connect to up site
        if (validBound(i - 1, j) && isOpen(i - 1, j)) {
            uf.union(id(i, j), id(i - 1, j));
            uf1.union(id(i, j), id(i - 1, j));
        }

        //connect to down site
        if (validBound(i + 1, j) && isOpen(i + 1, j)) {
            uf.union(id(i, j), id(i + 1, j));
            uf1.union(id(i, j), id(i + 1, j));

        }

    }

    // is site (row i, column j) open?
    public boolean isOpen(int i, int j) {
        validIndex(i, j);
        if (getGrid(i, j)) {
            return true;
        }
        return false;

    }

    // is site (row i, column j) full?
    public boolean isFull(int i, int j) {

        validIndex(i, j);
        if (uf1.connected(id(i, j), peak)) {
            return true;
        }
        return false;
    }

    // does the system percolate?
    public boolean percolates() {

        if (uf.connected(peak, bottom)) {
            return true;
        }
        return false;
    }

    private boolean validBound(int i, int j) {
        if (i <= 0 || i > N || j <= 0 || j > N) {
            return false;
        }
        return true;
    }

    private void validIndex(int i, int j) {
        if (i <= 0 || i > N || j <= 0 || j > N) {
            throw new IndexOutOfBoundsException("Index is out of bound");
        }
    }

    private boolean getGrid(int i, int j) {
        int pos = (i - 1) * N + (j - 1);
        return grid[pos];
    }

    private void setGrid(int i, int j) {
        int pos = (i - 1) * N + (j - 1);
        grid[pos] = true;
    }

    private int id(int i, int j) {
        return (i - 1) * N + (j - 1);
    }

}
