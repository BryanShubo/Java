package com.javase.ClassesAndObjects.NestedClasses;

public class InnerClass {

        private final static int SIZE = 15;
        private int[] arrayOfInts = new int[SIZE];

        public InnerClass() {
            for (int i = 0; i < SIZE; i++) {
                arrayOfInts[i] = i;
            }
        }

        public void printEven() {
            DataStructureIterator iterator = this.new EvenIterator();
            while (iterator.hasNext()) {
                System.out.print(iterator.next() + " ");
            }
            System.out.println();
        }

        interface DataStructureIterator extends java.util.Iterator<Integer> { }

        // Inner class implements the DataStructureIterator interface,
        // which extends the Iterator<Integer> interface

        private class EvenIterator implements DataStructureIterator {

            // Start stepping through the array from the beginning
            private int nextIndex = 0;

            public boolean hasNext() {
                return (nextIndex <= SIZE - 1);
            }

            public Integer next() {
                Integer retValue = Integer.valueOf(arrayOfInts[nextIndex]);
                nextIndex += 2;
                return retValue;
            }

            @Override
            public void remove() {

            }
        }

        public static void main(String s[]) {
            InnerClass ds = new InnerClass();
            ds.printEven();
        }

}
