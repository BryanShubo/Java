package com.javase.test;

/**
 * Created by limeng on 8/13/15.
 */
public class TestChar {

    public void method(int i) {
        System.out.println(i);
    }
    public void method(String str) {
        System.out.println(str);
    }

    public static void main(String[] args) {
        char c = 'a';
        TestChar testChar = new TestChar();
        testChar.method(c);
    }
}
