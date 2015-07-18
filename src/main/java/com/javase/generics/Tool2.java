package com.javase.generics;
/*
* After JDK 1.5, if the arg type is not predefined, generic can be used to represent arg
* */
// Use generic on class
public class Tool2<T> {
    private  T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }


    // Use generic on method. It can show any type, even it is different from Tool2 constructor
    public <T> void show(T t) {
        System.out.println("Show: " + t.toString());
    }

    //It can also show any type, even it is different from Tool2 constructor
    public void showObject(Object obj) {
        System.out.println("ShowObject: " + obj.toString());
    }


    // It can ONLY show the same type that is defined in Tool2 constructor
    public void print(T t) {
        System.out.println("Print: " + t.toString());
    }

    /*
    * When method is static, you cannot access the generic type that defined on class.
    * If static method uses generic, the generic type can only defined on method.
    * */
    /*public static void method(T t) {
        System.out.println("Static method: " + t.toString());
    }*/


    public static <X> void method(X x) {
        System.out.println("Static method: " + x.toString());
    }
}
