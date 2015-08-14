package com.javase.test;

/**
 * Created by limeng on 8/12/15.
 */
public class MultiCal extends SimpleCal{
    public void calculate() { value -= 3; }
    public void calculate(int multiplier) {
        calculate();
        super.calculate();
        value *= multiplier;
    }
    public static void main(String[] args) {
        MultiCal calculator = new MultiCal();
        calculator.calculate(2);
        System.out.println("Value is: " + calculator.value);
    }
}
