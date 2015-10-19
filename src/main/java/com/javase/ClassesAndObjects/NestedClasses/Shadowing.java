package com.javase.ClassesAndObjects.NestedClasses;

public class Shadowing {

    public int x = 0;

    class FirstLevel {

        public int x = 1;

        void methodInFirstLevel(int x) {
            System.out.println("x = " + x);
            System.out.println("this.x = " + this.x);
            System.out.println("ShadowTest.this.x = " + Shadowing.this.x);
        }
    }

    public static void main(String... args) {
        Shadowing st = new Shadowing();
        Shadowing.FirstLevel fl = st.new FirstLevel();
        fl.methodInFirstLevel(23);
    }
}
