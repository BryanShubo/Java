package com.week01.sources;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/*
*  Eager: meaning that do everything first.
*  Lazy: meaning that do thing only it is necessary.
* 1. Quick-union is a lazy approach.
* 2. Quick-union only  change set id[p] = root(q)
* 3. Quick-union defect: 1)Trees can get tall.
*                        2) Find too expensive(could be N array accesses)
* 4. Example: Takes N*N array accesses to process sequence of N union commands on N objects
* */

public class QuickUnionUF {
    private int[] id;    // id[i] = parent of i
    private int count;   // number of components

    /**
     * Initializes an empty union-find data structure with N isolated components 0 through N-1.
     * @throws java.lang.IllegalArgumentException if N < 0
     * @param N the number of objects
     */
    public QuickUnionUF(int N) {
        id = new int[N];
        count = N;
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    /**
     * Returns the number of components.
     * @return the number of components (between 1 and N)
     */
    public int count() {
        return count;
    }

    /**
     * Returns the component identifier for the component containing site <tt>p</tt>.
     * @param p the integer representing one site
     * @return the component identifier for the component containing site <tt>p</tt>
     * @throws java.lang.IndexOutOfBoundsException unless 0 <= p < N
     */
    public int find(int p) {
        while (p != id[p])
            p = id[p];
        return p;
    }

    /**
     * Are the two sites <tt>p</tt> and <tt>q</tt> in the same component?
     * @param p the integer representing one site
     * @param q the integer representing the other site
     * @return <tt>true</tt> if the sites <tt>p</tt> and <tt>q</tt> are in the same
     *    component, and <tt>false</tt> otherwise
     * @throws java.lang.IndexOutOfBoundsException unless both 0 <= p < N and 0 <= q < N
     */
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }


    /**
     * Merges the component containing site<tt>p</tt> with the component
     * containing site <tt>q</tt>.
     * @param p the integer representing one site
     * @param q the integer representing the other site
     * @throws java.lang.IndexOutOfBoundsException unless both 0 <= p < N and 0 <= q < N
     */
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        id[rootP] = rootQ;
        count--;
    }

    /**
     * Reads in a sequence of pairs of integers (between 0 and N-1) from standard input,
     * where each integer represents some object;
     * if the objects are in different components, merge the two components
     * and print the pair to standard output.
     */
    public static void main(String[] args) {
        int N = StdIn.readInt();
        QuickUnionUF uf = new QuickUnionUF(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) {
                StdOut.println(p + " and " + q + " are connected !");
                continue;
            }
            uf.union(p, q);
            StdOut.println("Union: " + p + " " + q + "     " + p + "->" + uf.find(p) + " " + q + "->" + uf.find(q));
        }
        StdOut.println(uf.count() + " components");
    }
}
