package com.chapter01.fundaments.sources;

/*************************************************************************
 *  Compilation:  javac MutableInteger.java
 *  Execution:    java MutableInteger
 *
 *  Shows that Integerss are mutable if you allow reflection.
 *
 *************************************************************************/

import edu.princeton.cs.introcs.StdOut;

import java.lang.reflect.Field;

public class MutableInteger {

    public static void main(String[] args) {
        Integer x = new Integer("17");
        StdOut.println(x);
        mutate(x);
        StdOut.println(x);
    }

    // change the Integer to 9999999
    public static void mutate(Integer x) {
        try {
            Field value = Integer.class.getDeclaredField("value");
            value.setAccessible(true);
            value.setInt(x, 999999999);
        } catch (Exception e) { e.printStackTrace(); }
    }

}
