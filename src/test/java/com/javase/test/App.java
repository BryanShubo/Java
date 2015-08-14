package com.javase.test;

import java.util.*;

/**
 * Created by limeng on 8/11/15.
 */
public class App {
    public static void main(String[] args) {
        Test test = new Test(10, 20);
        test.method(test);
        System.out.println(test.i + ": " + test.j);


        GenericStack genericStack = new GenericStack<String>();
        genericStack.push("hello");
        genericStack.pop();

        GenericStack genericStack1 = new GenericStack<Integer>();
        genericStack1.push(12);
        genericStack1.pop();


        char[] chars = new char[]{'\u0097'};
        String str = new String(chars);
        byte[] bytes = str.getBytes();
        System.out.println(Arrays.toString(bytes));

        S2 s2 = new S2();
        s2.display();

        S1 s1 = new S1();
        System.out.println(s1.getStr());

        System.out.println(s2.getStr());


        PriorityQueue<String> pq = new PriorityQueue<String>();
        pq.add("banana");
        pq.add("pear");
        pq.add("apple");
        System.out.println(pq.poll() + " " + pq.peek());


        Set<Integer> set = new HashSet<Integer>();
        Integer i1 = 45;
        Integer i2 = 46;
        set.add(i1);
        set.add(i1);
        set.add(i2); System.out.print(set.size() + " ");
        set.remove(i1); System.out.print(set.size() + " ");
        i2 = 47;
        set.remove(i2); System.out.print(set.size() + " ");
        System.out.println("====================================");

        TreeSet<Integer> s = new TreeSet<Integer>();
        TreeSet<Integer> subs = new TreeSet<Integer>();
        for(int i = 606; i < 613; i++)
            if(i%2 == 0) s.add(i);
        subs = (TreeSet)s.subSet(608, true, 611, true);
        System.out.println("s:" + s + "subs: " + subs);
        s.add(609);
        System.out.println(s + " " + subs);


         HashMap props = new HashMap();
         props.put("key45", "some value");
         props.put("key12", "some other value");
         props.put("key39", "yet another value");
         Set set1 = props.keySet();

        //Arrays.sort;
        //Collections.sort(set1);
        set1 = new TreeSet(set1);

        new B().process();



    }
}
