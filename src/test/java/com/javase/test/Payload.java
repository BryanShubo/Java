package com.javase.test;

/**
 * Created by limeng on 8/12/15.
 */
public class Payload {
    private int weight;
    public Payload (int w) { weight = w; }
     public void setWeight(int w) { weight = w; }
     public String toString() { return Integer.toString(weight); }
}
