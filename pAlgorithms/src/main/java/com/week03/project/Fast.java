package com.week03.project;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdOut;

import java.util.*;

public class Fast {

    private double inf = Double.POSITIVE_INFINITY;
    private static int N;
    private static List<Set<Point>> lines;
    private static Set<Point> line;

    private static void refresh() {
        N = 0;
        lines = new ArrayList<Set<Point>>();
        line = new HashSet<Point>();
    }

    private static void addLine() {
        if (lines.size() == 0) {
            lines.add(line);
            line = new HashSet<Point>();
        } else {
            boolean newLine = true;
            for (int k = 0; k < lines.size(); k++) {
                if (lines.get(k).size() >= line.size()) {
                    int duplicate = 0;
                    for (Point p : line) {
                        for (Point lp : lines.get(k)) {
                            if (lp.toString().equals(p.toString())) {
                                duplicate++;
                                break;
                            }
                        }
                    }
                    if (duplicate == line.size()) {
                        newLine = false;
                    }

                } else {
                    int duplicate = 0;
                    for (Point lp : lines.get(k)) {
                        for (Point p : line) {
                            if (lp.toString().equals(p.toString())) {
                                duplicate++;
                                break;
                            }
                        }
                    }
                    if (duplicate == lines.get(k).size()) {
                        newLine = false;
                    }
                }
                if (!newLine) { break; }
            }
            if (newLine) {
                lines.add(line);
                line = new HashSet<Point>();
            }
        }
    }

    public static void main(String[] args) {
        setDraw();
        refresh();
        Point[] points = readPoints(args[0]);

        for (int i = 0; i < points.length; i++) {
            points[i].draw();
        }

        for (int i = 0; i < N; i++) {
            Point[] temp = Arrays.copyOf(points, N);
            Arrays.sort(temp, points[i].SLOPE_ORDER);
            int counter = 1;
            for (int j = 0; j < N - 1; j++) {
                if (points[i].slopeTo(temp[j]) == points[i].slopeTo(temp[j + 1])) {
                    counter++;
                    if (j == N -2 && counter >= 3) {
                        line.add(points[i]);
                        for (int k = 0; k < counter; k++) {
                            line.add(temp[j + 1 - k]);
                        }
                        addLine();
                    }
                } else if (points[i].slopeTo(temp[j]) != points[i].slopeTo(temp[j + 1]) && (counter >= 3)) {
                    line.add(points[i]);
                    for (int k = 0; k < counter; k++) {
                        line.add(temp[j - k]);
                    }
                    counter = 1;
                    addLine();

                } else if (points[i].slopeTo(temp[j]) != points[i].slopeTo(temp[j + 1]) && counter < 3) {
                    counter = 1;
                }

            }
            line = new HashSet<Point>();
        }

        collinear();
    }

    private static void collinear() {
        for (Set<Point> l : lines) {
            List<Point> result = new ArrayList<Point>();
            for (Point p : l) {
                result.add(p);
            }

            Point[] orderedLine = new Point[result.size()];
            orderedLine = result.toArray(orderedLine);
            orderedLine = sort(orderedLine);

            orderedLine[0].drawTo(orderedLine[orderedLine.length - 1]);
            //System.out.println(orderedLine[0].toString() + " -> " + orderedLine[orderedLine.length - 1].toString());
            for (int j = 0; j < orderedLine.length; j++) {

                if (j == orderedLine.length - 1) {
                    System.out.print(orderedLine[j].toString());
                } else {
                    System.out.print(orderedLine[j].toString() + " -> ");
                }

            }
            System.out.println();
        }
    }

    private static void setDraw() {
        //StdDraw.clear();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);

        // clear the background
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.filledSquare(32768 / 2, 32768 / 2, 32768);

        // draw ball on the screen
        StdDraw.setPenColor(StdDraw.BLACK);
    }

    private static Point[] readPoints(String input) {
        In in = new In(input);
        int[] data = in.readAllInts();
        int itr = 0;
        N = data[itr++];
        Point[] points = new Point[N];
        int counter = 0;
        while (itr < data.length) {
            int x = data[itr++];
            int y = data[itr++];
            points[counter++] = new Point(x, y);
        }
        return points;
    }

//    private static void showSlopOrder(Point[] temp, Point p) {
//        for (int i = 0; i < temp.length; i++) {
//            System.out.print(temp[i].toString() + " -> ");
//        }
//        System.out.println();
//        for (int i = 0; i < temp.length; i++) {
//            System.out.print(p.slopeTo(temp[i]) + " : ");
//        }
//        System.out.println();
//    }

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
    private static Point[] sort(Point[] a) {
        Point[] aux = new Point[a.length];
        return sort(a, aux, 0, a.length-1);

    }

    // mergesort a[lo..hi] using auxiliary array aux[lo..hi]
    private static Point[] sort(Point[] a, Point[] aux, int lo, int hi) {
        if (hi <= lo) return null;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
        return a;
    }

    // stably merge a[lo .. mid] with a[mid+1 ..hi] using aux[lo .. hi]
    private static void merge(Point[] a, Point[] aux, int lo, int mid, int hi) {
        // precondition: a[lo .. mid] and a[mid+1 .. hi] are sorted subarrays
        assert isSorted(a, lo, mid);
        assert isSorted(a, mid+1, hi);

        // copy to aux[]
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        // merge back to a[]
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)              a[k] = aux[j++];   // this copying is unnecessary
            else if (j > hi)               a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else                           a[k] = aux[i++];
        }

        // postcondition: a[lo .. hi] is sorted
        assert isSorted(a, lo, hi);
    }

    // is v < w ?
    private static boolean less(Point v, Point w) {
        return (v.compareTo(w) < 0);
    }

    // exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static boolean isSorted(Point[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    private static boolean isSorted(Point[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }


}



