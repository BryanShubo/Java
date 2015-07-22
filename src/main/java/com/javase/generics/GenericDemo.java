package com.javase.generics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class GenericDemo {

    public static void main(String[] args) {

        test1();

        test2();

        test3();

        test4();

        test5();

        GenericDemo genericDemo = new GenericDemo();
        genericDemo.test6();
        genericDemo.test7();

    }

    public static void test1() {
        int[] arr = new int[4];

        ArrayList<String> al = new ArrayList<String>();

        al.add("abc");//public boolean add(Object obj)
        al.add("hahah");
//		al.add(4);//al.add(new Integer(4));

        Iterator<String> it = al.iterator();
        while(it.hasNext()){

            String str = it.next();
            System.out.println(str);
        }
    }

    public static void test2() {
        TreeSet<Person> ts = new TreeSet<Person>(new ComparatorByName());
        ts.add(new Person("lisi8",21));
        ts.add(new Person("lisi3",23));
        ts.add(new Person("lisi",21));
        ts.add(new Person("lis0",20));

        Iterator<Person> it = ts.iterator();

        while(it.hasNext()){
            Person p = it.next();
            System.out.println(p.getName()+":"+p.getAge());
        }
    }



    // If we don't use generic, ClassCastException will appear in runtime
    public static void test3() {

        Tool1 tool1 = new Tool1();
        tool1.setObject(new Worker());
       // Student student = (Student)tool1.getObject(); // throw ClassCastException
       // System.out.println(student);

    }


    // Use generic on class
    public static void test4() {
        Tool2<Student> tool2 = new Tool2<Student>();
        //tool2.setT(new Worker()); // compile error if you try to insert a different object
        tool2.setT(new Student());
        Student student = tool2.getT();
        System.out.println(student);
    }


    // Use generic on method
    public static void test5() {
        Tool2<String> tool2 = new Tool2<String>();

        // print any type, not only String
        tool2.show("Arron");
        tool2.show(new Integer(10));

        // print any type, not only String
        tool2.showObject("Bistro");
        tool2.showObject(new Integer(11));

        // Only string
        tool2.print("Cate");
        //tool2.print(new Integer(12)); // tool2 only accepts String


        Tool2.method("Darren");
        Tool2.method(new Integer(13));
    }

    // generic interface
    public void test6() {

        InterImpl in = new InterImpl();
        in.show("Edward");
    }

    // generic interface
    public void test7() {

        InterImpl2<Integer> in = new InterImpl2<Integer>();
        in.show(14);
    }

    interface  Inter<T> {
        public void show(T t);
    }

    class InterImpl implements Inter<String> {
        public void show(String str) {
            System.out.println("Show: " + str);
        }
    }

    class InterImpl2<T> implements Inter<T> {
        public void show(T t) {
            System.out.println("Show2: " + t.toString());
        }
    }

}



