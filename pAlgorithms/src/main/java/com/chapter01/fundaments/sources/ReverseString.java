package com.chapter01.fundaments.sources;

import edu.princeton.cs.introcs.StdOut;

/**
 * Created by Shubo on 1/28/2015.
 */
public class ReverseString {

    public static void main(String[] args) {
        String s = "bryan";
        StdOut.println(reverseString(s));
        StdOut.println(reverse(s));
    }

    public static String reverseString(String s) {
        int N = s.length();
        if (N <= 1) return s;

        String a = s.substring(0, N/2);
        String b = s.substring(N/2, N);
        return reverseString(b) + reverseString(a);
    }

    public static String reverse(String s) {
        int N = s.length();
        if (N <= 1) return s;

        String result = "";
        for(int i = s.length() - 1; i >= 0; i--) {
            result += (s.charAt(i));
        }
        return result;
    }
}
