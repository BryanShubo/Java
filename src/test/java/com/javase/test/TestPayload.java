package com.javase.test;

/**
 * Created by limeng on 8/12/15.
 */
public class TestPayload {
    static void changePayload(Payload p) { p.setWeight(420);}
     public static void main(String[] args) {
      Payload p = new Payload(200);
         p.setWeight(1024);
         changePayload(p);
         System.out.println("p is " + p);
         }
}
