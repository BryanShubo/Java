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

        Iterator<Student> it = hm.keySet().iterator();

        while(it.hasNext()){
            Student key = it.next();
            String value = hm.get(key);
            System.out.println(key.getName()+":"+key.getAge()+"---"+value);
        }


    }

}


// Three ways to iterate map

// 1. using keySet()

/*        Set<Integer> keySet = map.keySet();
        Iterator<Integer> itr = keySet.iterator();

        while (itr.hasNext()) {
            Integer key = itr.next();
            System.out.println(key + " : " + map.get(key));
        }*/


// 2. using entrySet()
 /*       Iterator<Map.Entry<Integer,Integer>> itr = map.entrySet().iterator();

        while(itr.hasNext()) {
            Map.Entry<Integer,Integer> mapEntry = itr.next();
            Integer key = mapEntry.getKey();
            Integer value = mapEntry.getValue();

            System.out.println(key + " : " + value);
        }*/

// 3. Enhanced for loop entrySet: this is faster because it converts the map to one object, so just need to
// access map once.
// keySet need to search map twice.
        /*for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry);
        }*/
