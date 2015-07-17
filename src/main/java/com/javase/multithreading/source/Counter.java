package com.javase.multithreading.source;

/**
 * Created by uc0006 on 7/17/2015.
 */
public class Counter {

    protected  int num = 0;

    public void setNum(int i) {
        this.num = num + i;
    }

    public  int getNum() {
        return this.num;
    }
}
