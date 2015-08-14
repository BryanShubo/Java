package com.javase.test;

/**
 * Created by limeng on 8/13/15.
 */
public class Z extends X{

    Y y = new Y();

    public Z(){
        System.out.println("Z");
    }

    public static void main(String[] args) {
        int i = 0;
        new Z();
    }

}
