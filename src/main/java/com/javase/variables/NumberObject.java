package com.javase.variables;

/**
 * The abstract class Number is the superclass of classes
 * BigDecimal,
 * BigInteger,
 * Byte, Double, Float, Integer, Long, and Short.
 *
 * Subclasses of Number must provide methods to convert the represented numeric value to byte, double,
 * float, int, long, and short.
 */
public class NumberObject {

    public static void main(String[] args) {


       /* addTwoNum(10.2, 30.8);
        addTwoNum(-10.2, 30.8);
        addTwoNum(10.2, -30.8);
        addTwoNum(-10.2, -30.8);
        addTwoNum(null, 10.0);
        addTwoNum(null, null);
        addTwoNum(14L, null);*/
        
    }

   /* public static void addTwoNum(Number num1, Number num2) {

       if (validNum(num1) && validNum(num2)) {
           System.out.println(num1.doubleValue() + num2.doubleValue());
       } else {
           System.out.println("Wrong number format");
        }


    }*/
/*    public static boolean validNum(Number num) {

        if (num == null) { return false;}
        String objName = num.getClass().getName();

        switch (objName.substring(10)) {
            case "Double": return true;
            case "Long": return true;
            case "Float": return true;
            case "Integer": return true;
            default:
                return false;
        }
    }*/

}
