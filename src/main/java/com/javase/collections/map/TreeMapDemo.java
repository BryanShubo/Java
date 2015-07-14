package com.javase.collections.map;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;


public class TreeMapDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {

        TreeMap<Student,String> tm = new TreeMap<Student,String>(new ComparatorByName());

        tm.put(new Student("lisi",38),"±±¾©");
        tm.put(new Student("zhaoliu",24),"ÉÏº£");
        tm.put(new Student("xiaoqiang",31),"ÉòÑô");
        tm.put(new Student("wangcai",28),"´óÁ¬");
        tm.put(new Student("zhaoliu",24),"ÌúÁë");


        Iterator<Map.Entry<Student, String>> it = tm.entrySet().iterator();

        while(it.hasNext()){
            Map.Entry<Student,String> me = it.next();
            Student key = me.getKey();
            String value = me.getValue();

            System.out.println(key.getName()+":"+key.getAge()+"---"+value);
        }

    }

}
