package com.javase.multithreading;

import com.javase.multithreading.source.Counter;

/**
 * Created by uc0006 on 7/17/2015.
 */
public class B_RaceConditions {

    public static void main(String[] args) {


        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    Counter counter = new Counter();
                    System.out.println("Thread 1 before add counter: " + counter.getNum());
                    System.out.println("Thread 1 add 10 on counter: ");
                    counter.setNum(10);
                    System.out.println("Thread 1 after add counter: " + counter.getNum());
                }

            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    Counter counter = new Counter();
                    System.out.println("Thread 2 before add counter: " + counter.getNum());
                    System.out.println("Thread 2 add 1000 on counter: ");
                    counter.setNum(1000);
                    System.out.println("Thread 2 after add counter: " + counter.getNum());
                }

            }
        });

        thread1.run();
        thread2.run();

    }
}
