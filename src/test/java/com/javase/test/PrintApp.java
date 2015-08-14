package com.javase.test;

/**
 * Created by limeng on 8/13/15.
 */
public class PrintApp {

    public static void main(String[] args) {
        PrintApp printApp = new PrintApp();
        printApp.method(5);
    }

    private void method(int num) {
        try {
            if (num <= 0) {
                throw new Exception();
            } else {
                for(int i = 1; i <= 2 * num -1; i++) {
                    if(i <= num) {
                        for(int j = i; j > 1; j--) {
                            System.out.print("$");
                        }
                        System.out.println(i);

                    } else {
                        for(int j = i+1; j < 2*num; j++) {
                            System.out.print("$");
                        }
                        System.out.println(2*num - i);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
