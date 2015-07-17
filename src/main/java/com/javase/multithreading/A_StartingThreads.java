package com.javase.multithreading;

import com.javase.multithreading.source.MyRunnable;
import com.javase.multithreading.source.MyThread;

/**
 * Created by uc0006 on 7/17/2015.
 */
public class A_StartingThreads {

    public static void main(String[] args) {

        MyThread myThread = new MyThread();
        myThread.run();


        /*
        * Runnable way is preferable.
        * 1. When having the Runnable's executed by a thread pool
        * it is easy to queue up the Runnable instances until a thread from the pool is idle.
        *
        * 2. Sometimes you may have to implement Runnable as well as subclass Thread.
        * For instance, if creating a subclass of Thread that can execute more than one Runnable.
        * */
        MyRunnable myRunnable = new MyRunnable();
        myRunnable.run();


        /*
        * Common pitfall: Calling run() instead of start()
        * */
        Thread thread = new Thread(new MyRunnable());
        thread.start();


        for (int i = 0; i < 10; i++) {

            new Thread("" + i){
                public void run() {
                    System.out.println("Thread: " + getName() + " is running" );
                }
            }.start();
        }
    }
}
