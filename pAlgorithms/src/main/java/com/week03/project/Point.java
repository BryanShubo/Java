package com.week03.project;

import edu.princeton.cs.introcs.StdDraw;

import java.util.Comparator;

public class Point implements Comparable<Point> {

    private final int x;                              // x coordinate
    private final int y;                              // y coordinate
    private double inf = Double.POSITIVE_INFINITY;

    // compare points by slope
    public final Comparator<Point> SLOPE_ORDER = new Comparator<Point>() {
        @Override
        public int compare(Point o1, Point o2) {
            double s1 = slopeTo(o1);
            double s2 = slopeTo(o2);

            if (s1 > s2) { return 1; }
            if (s1 < s2) { return -1; }

            return 0;
        }
    };

    // slope between this point and that point
    public double slopeTo(Point that) {
        double x0 = that.x;
        double x1 = x;
        double y0 = that.y;
        double y1 = y;
        double slope = -inf;
        if ((x0 != x1) && (y0 != y1)) {
            slope = (y0 - y1) / (x0 - x1);
            return slope;
        }

        if (x0 != x1 && y0 == y1){
            slope = 0;
            return slope;
        }

        if (x0 == x1 && y0 != y1) {
            slope = inf;
            return slope;
        }

        return slope;
    }

    // is this point lexicographically smaller than that one?
    // comparing y-coordinates and breaking ties by x-coordinates
    public int compareTo(Point that) {
        int x0 = this.x;
        int x1 = that.x;
        int y0 = this.y;
        int y1 = that.y;

        if (x0 == x1 && y0 == y1) { return 0; }
        if (y0 < y1 || (y0 == y1 && x0 < x1)) { return -1; }

        return 1;
    }

    private static void slopeToTest() {
        Point p0 = new Point(0, 0);
        Point p1 = new Point(1, -1);
        Point p2 = new Point(0, 0);
        Point p3 = new Point(0, -10);
        Point p4 = new Point(5, 0);

        System.out.println("p0 to p1: " + p0.slopeTo(p1));
        System.out.println("p0 to p2: " + p0.slopeTo(p2));
        System.out.println("p0 to p3: " + p0.slopeTo(p3));
        System.out.println("p0 to p4: " + p0.slopeTo(p4));
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

    // create the point (x, y)
    public Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
    }

    // plot this point to standard drawing
    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }

    // draw line between this point and that point to standard drawing
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    // return string representation of this point
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }

    // unit test
    public static void main(String[] args) {

        Point a = new Point(19000, 10000);
        Point b = new Point(18000, 10000);
        Point c = new Point(32000, 10000);
        Point d = new Point(21000, 10000);

        if (a.compareTo(b) == 1) { Point t = b; b = a; a = t; }
        if (c.compareTo(d) == 1) { Point t = d; d = c; c = t; }
        if (a.compareTo(c) == 1) { Point t = c; c = a; a = t; }
        if (b.compareTo(d) == 1) { Point t = d; d = b; b = t; }
        if (b.compareTo(c) == 1) { Point t = c; c = b; b = t; }

        Point[] p = {a, b, c, d};
        for (int i = 0; i < p.length; i++) {
            System.out.print(p[i] +  " -> ");
        }
    }
}