package com.javase.collections.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashMapDemo {

    public static void main(String[] args) {

        HashMap<Student,String> hm = new HashMap<Student,String>();


        hm.put(new Student("lisi",38),"beijing");
        hm.put(new Student("zhaoliu",24),"shanghai");
        hm.put(new Student("xiaoqiang",31),"shenyang");
        hm.put(new Student("wangcai",28),"dalian");
        hm.put(new Student("zhaoliu",24),"tieling");

//		Set<Student> keySet = hm.keySet();
//		Iterator<Student> it = keySet.iterator();

        Iterator<Student> it = hm.keySet().iterator();

        while(it.hasNext()){
            Student key = it.next();
            String value = hm.get(key);
            System.out.println(key.getName()+":"+key.getAge()+"---"+value);
        }


    }

}
