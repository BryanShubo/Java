package com.chapter01.fundaments.sources;

import edu.princeton.cs.introcs.StdOut;

/**
 * Created by Shubo on 1/28/2015.
 */
public class CircularRotation {


    public static void main(String[] args) {

        String s1 = args[0];
        String s2 = args[1];

        if((s1.length() == s2.length()) && (s1.concat(s1).indexOf(s2) >= 0)) {
            StdOut.println("These two strings are circular rotation !");
        } else {
            StdOut.println("These two strings are NOT circular rotation !");
        }

    }

}
