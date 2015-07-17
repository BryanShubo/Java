package com.javase.multithreading.source;

/**
 * Created by uc0006 on 7/17/2015.
 */
public class MyRunnable implements Runnable {

    @Override
    public void run() {
        for(int i = 0; i < 20; i++) {

            System.out.println("MyRunnable is running");

        }
    }
}
