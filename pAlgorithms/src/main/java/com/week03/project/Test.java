package com.week03.project;

import java.util.Arrays;

/**
 * Created by Shubo on 2/27/2015.
 */
public class Test {

    public static void main(String[] args){
        double a = 1.0;
        double x = (a - a) /  a;   // positive zero ( 0.0)
        double y = (a - a) / -a;   // negative zero (-0.0)
        System.out.println(x + " : " + y);
        testComparator();
    }

    private static void testComparator() {
        double[] s = {2,5,1, 4};
        double[] d = s;

        Arrays.sort(d);

        for (int i = 0; i < s.length; i++) {
            System.out.print(d[i] + " ");
        }

        System.out.println();
        for (int i = 0; i < s.length; i++) {
            System.out.print(s[i] + " ");
        }
    }
}
