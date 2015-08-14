package com.javase.test;

/**
 * Created by limeng on 8/12/15.
 */
public class TestException {
   /* static void test() throws Error {
        if (true) throw new AssertionError();
        System.out.print("test ");
    }
    public static void main(String[] args) {
        try { test(); }
        catch (Exception ex) { System.out.print("exception "); }
        System.out.print("end ");
    }*/


   /* static void test() throws Exception {
        if (true) throw new Exception();
        System.out.print("test ");
    }
    public static void main(String[] args) {
        try { test(); }
        catch (Exception ex) { System.out.print("exception "); }
        System.out.print("end ");
    }*/

    static void test() throws Error {
        if (true) throw new AssertionError();
        System.out.print("test ");
    }
    public static void main(String[] args) {
        try { test(); }
        catch (Error error) { System.out.print("error "); }
        System.out.print("end ");
    }
}
