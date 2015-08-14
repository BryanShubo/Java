package com.javase.test;

/**
 * Created by limeng on 8/11/15.
 */
public class Test {


    int i;
    int j;

    public Test(int i, int j) {
        this.i = i;
        this.j = j;

    }

    public void method(Test test) {
        test.i *= 2;
        test.j /= 2;

    }
}
