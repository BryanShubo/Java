package com.javase.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class GenericAdvancedDemo {

    public static void main(String[] args){

        test1();

        test2();

        test3();
    }

    // test wild card: ?
    public static void test1() {
        ArrayList<Person> al = new ArrayList<Person>();
        al.add(new Person("abc",30));
        al.add(new Person("abc4",34));

        ArrayList<Student> al2 = new ArrayList<Student>();
        al2.add(new Student("stu1",11));
        al2.add(new Student("stu2",22));

        ArrayList<String> al3 = new ArrayList<String>();
        al3.add("stu3331");
        al3.add("stu33332");

        printCollection(al2);
        printCollection(al);
        printCollection(al3);
        printCollection1(al2);
        printCollection1(al);
        printCollection1(al3);
    }

    // Generic T can operate t
    public static <T> void  printCollection(Collection<T> c) {
        Iterator<T> itr = c.iterator();

        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

    // wild card: ?
    public static void  printCollection1(Collection<?> c) {
        Iterator<?> itr = c.iterator();

        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

    // ? extends E : accept E and E's son
    public static void test2() {

        ArrayList<Person> al = new ArrayList<Person>();
        al.add(new Person("abc",30));
        al.add(new Person("abc4",34));

        ArrayList<Student> al2 = new ArrayList<Student>();
        al2.add(new Student("stu1",11));
        al2.add(new Student("stu2",22));

        ArrayList<Worker> al3 = new ArrayList<Worker>();
        al3.add(new Worker("work1",30));
        al3.add(new Worker("work2",34));

        printCollection2(al);
        printCollection2(al2);
        printCollection2(al3);

    }

    public static void printCollection2(Collection<? extends Person> al) {
        Iterator<? extends Person> it = al.iterator();

        Person person = it.next();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }


    // ? super E: accept E and E's father. Note: Does not accept father's other son.
    public static void test3() {

        ArrayList<Person> al = new ArrayList<Person>();
        al.add(new Person("person_print3",30));
        al.add(new Person("person_print3",34));

        ArrayList<Student> al2 = new ArrayList<Student>();
        al2.add(new Student("student_print3",11));
        al2.add(new Student("student_print3",22));

        printCollection3(al);
        printCollection3(al2);
    }

    public static void printCollection3(Collection<? super Student> al) {
        Iterator<? super Student> it = al.iterator();

        while(it.hasNext()){

            System.out.println(it.next());
        }
    }

}
