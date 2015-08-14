package com.javase.test;

/**
 * Created by limeng on 8/11/15.
 */
public class InnerClassTest {

    public static void main(String[] args) {
        final class Constants{
            public  String name = "PI";
        }

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(" ");
            }
        });
        thread.start();
    }
}
