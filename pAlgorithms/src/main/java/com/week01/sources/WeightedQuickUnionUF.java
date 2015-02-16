package com.week01.sources;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;


/***********************************************************************
 *  Weighted quick-union by rank with path compression by halving.
 *  1. Modify quick-union to avoid tall trees
 *  2. Keep track of size of each tree(number of objects)
 *  3. Balance by linking root of smaller tree to root of larger tree
 *  4. Path compression
 *
 *  5. Running time: 1) Find: takes time proportional to depth of p and q
 *                   2) Union: takes constant time, given roots
 *
 *  6. Algorithms-----initialize-----union-----connected-----worst cast
 *     quick-find-----N-----N-----1-----M*N
 *     quick-union-----N-----N^-----N-----M*N
 *     weightedUF-----N-----logN-----lgN-----N+M*logN
 **********************************************************************************/
public class WeightedQuickUnionUF {
    private int[] id;    // id[i] = parent of i
    private int[] sz;    // sz[i] = number of objects in subtree rooted at i
    private int count;   // number of components

    /**
     * Initializes an empty union-find data structure with N isolated components 0 through N-1.
     * @throws java.lang.IllegalArgumentException if N < 0
     * @param N the number of objects
     */
    public WeightedQuickUnionUF(int N) {
        count = N;
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
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
     * @return <tt>true</tt> if the two sites <tt>p</tt> and <tt>q</tt>
     *    are in the same component, and <tt>false</tt> otherwise
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

        // make smaller root point to larger one
        if   (sz[rootP] < sz[rootQ]) { id[rootP] = rootQ; sz[rootQ] += sz[rootP]; }
        else                         { id[rootQ] = rootP; sz[rootP] += sz[rootQ]; }
        count--;
    }


    /**
     * Reads in a sequence of pairs of integers (between 0 and N-1) from standard input,
     * where each integer represents some object;
     * if the objects are in different components, merge the two components
     * and print the pair to standard output.
     */
    public static void main(String[] args) {
        In in = new In(args[0]);
        int[] data = in.readAllInts();
        int itr = 0;
        int N = data[itr++];
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
        while (itr < data.length) {
            int p = data[itr++];
            int q = data[itr++];
            if (uf.connected(p, q)) {
                StdOut.println(p + " and " + q + " are connected !");
                continue;
            }
            uf.union(p, q);
            StdOut.println("Union: " + p + " " + q + "     " + p + "->" + uf.find(p) + " " + q + "->" + uf.find(q));

            for(int i = 0; i < N; i++) {
                StdOut.print(uf.id[i] + " ");
            }
            StdOut.println();
        }
        for(int i = 0; i < N; i++) {
            StdOut.print(uf.id[i] + " ");
        }
        StdOut.println();
        StdOut.println(uf.count() + " components");
    }

}

