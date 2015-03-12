package com.week03.project;

import edu.princeton.cs.introcs.In;
        import edu.princeton.cs.introcs.StdDraw;

        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.List;

public class Brute {
    private static int N;

    public static void main(String[] args) {
        setDraw();
        N = 0;
        Point[] points = readPoints(args[0]);

        for (int i = 0; i < N - 3; i++) {
            for (int j = i + 1; j < N - 2; j++) {
                for (int k = j + 1; k < N - 1; k++) {
                    for (int l = k + 1; l < N; l++) {
                        Point p1 = points[i];
                        Point p2 = points[j];
                        Point p3 = points[k];
                        Point p4 = points[l];

                        double s1 = p1.slopeTo(p2);
                        double s2 = p1.slopeTo(p3);
                        double s3 = p1.slopeTo(p4);

                        if (s1 == s2 && s1 == s3 ) {
                            Point[] line = {p1, p2, p3, p4};
                            Point[] orderedLine = sort(line);

                            orderedLine[0].drawTo(orderedLine[3]);
                            System.out.println(orderedLine[0].toString() + " -> " + orderedLine[1].toString()
                                    + " -> " + orderedLine[2].toString() + " -> " + orderedLine[3].toString());
                        }
                    }
                }
            }
        }

    }

    private static Point[] sort(Point[] p) {
        Point a = p[0];
        Point b = p[1];
        Point c = p[2];
        Point d = p[3];

        if (a.compareTo(b) == 1) { Point t = b; b = a; a = t; }
        if (c.compareTo(d) == 1) { Point t = d; d = c; c = t; }
        if (a.compareTo(c) == 1) { Point t = c; c = a; a = t; }
        if (b.compareTo(d) == 1) { Point t = d; d = b; b = t; }
        if (b.compareTo(c) == 1) { Point t = c; c = b; b = t; }

        Point[] result = {a, b, c, d};
        return result;
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

    private static Point[] readPoints (String input) {
        In in = new In(input);
        int[] data = in.readAllInts();
        int itr = 0;
        N = data[itr++];

        Point[] points = new Point[N];
        int counter = 0;
        while (itr < data.length) {
            int x = data[itr++];
            int y = data[itr++];

            Point p = new Point(x, y);
            p.draw();
            points[counter++] = p;
        }

        return points;
    }

}
