package com.javase.collections.set;

import com.javase.collections.HashCodeTest;
import com.javase.collections.Person;
import com.javase.collections.PersonTest;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo {

    public static void main(String[] args) {

        /*
        testing comparator
        */
        //test1();
        //test2();
        //testPerson1();
        //testPerson2();


        /*
        * Test duplicate hash code
         *  */

        testDuplicateHashCode();

    }



    /**
     * If object has its own compareTo method, comparator is not necessary
     */
    public static void test1() {
        TreeSet ts = new TreeSet();

        ts.add("abc");
        ts.add("zaa");
        ts.add("aa");
        ts.add("nba");
        ts.add("cba");

        Iterator it = ts.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }
    }



    /*
    * Change define your own comparator
    * */
    public static void test2() {
        TreeSet ts = new TreeSet(new ComparatorByLength());

        ts.add("aaaaa");
        ts.add("zz");
        ts.add("nbaq");
        ts.add("cba");
        ts.add("abc");

        Iterator it = ts.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }
    }

    /*
  * PersonTest must implement Comparable or TreeSet constructed with comparator.
  * PersonTest implements Comparable
  * */
    public static void testPerson1() {
        TreeSet ts = new TreeSet();

        ts.add(new PersonTest("Bobby",10));
        ts.add(new PersonTest("Arron",20));
        ts.add(new PersonTest("Zack",28));
        ts.add(new PersonTest("Zack",21));
        ts.add(new PersonTest("Zoe",29));
        ts.add(new PersonTest("Simon",29));
        ts.add(new PersonTest("William",21));
        ts.add(new PersonTest("William", 21));

        Iterator it = ts.iterator();

        while(it.hasNext()){
            PersonTest p = (PersonTest)it.next();

            System.out.println(p.getName()+":"+p.getAge());
        }
    }

    /*
    * Person object does not have compare method, you have to assign one.
    * TreeSet is constructed with a comparator
    * */
    public static void testPerson2() {
        TreeSet ts = new TreeSet(new ComparatorByName());

        ts.add(new Person("zhangsan",28));
        ts.add(new Person("lisi",21));
        ts.add(new Person("zhouqi",29));
        ts.add(new Person("zhaoliu",25));
        ts.add(new Person("wangu",24));

        Iterator it = ts.iterator();

        while(it.hasNext()){
            Person p = (Person)it.next();

            System.out.println(p.getName()+":"+p.getAge());
        }
    }

    public static void testDuplicateHashCode() {

        Set<HashCodeTest> set = new TreeSet<>();
        set.add(new HashCodeTest("John", "Doe"));
        set.add(new HashCodeTest("Doe", "John"));

        Iterator<HashCodeTest> itr = set.iterator();

        while (itr.hasNext()) {
            HashCodeTest obj = itr.next();
            System.out.println(obj.getFirstName() + " : " + obj.getLastName());
        }
    }

}
