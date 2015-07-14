package com.javase.collections.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapDemo {

    public static void main(String[] args) {

        Map<Integer,String> map = new HashMap<Integer,String>();
        testKeySet(map);
    }

    public static void testKeySet(Map<Integer,String> map) {
        map.put(8,"zhaoliu");
        map.put(2,"zhaoliu");
        map.put(7,"xiaoqiang");
        map.put(6,"wangcai");

        //Fetch all elements from map
        // KeySet gets all keys from a map
        //
        Set<Integer> keySet = map.keySet();
        Iterator<Integer> itr = keySet.iterator();

        while(itr.hasNext()){
            Integer key = itr.next();
            String value = map.get(key);
            System.out.println(key+":"+value);

        }
    }

    public static void testEntrySet(Map<Integer,String> map){

        map.put(8,"zhaoliu");
        map.put(2,"zhaoliu");
        map.put(7,"xiaoqiang");
        map.put(6,"wangcai");


        Collection<String> values = map.values();

        Iterator<String> it2 = values.iterator();
        while(it2.hasNext()){
            System.out.println(it2.next());
        }

        Set<Map.Entry<Integer, String>> entrySet = map.entrySet();

        Iterator<Map.Entry<Integer, String>> it = entrySet.iterator();

        while(it.hasNext()){
            Map.Entry<Integer, String> me = it.next();
            Integer key = me.getKey();
            String value = me.getValue();
            System.out.println(key+"::::"+value);

        }
    }


    public static void mapMethod(Map<Integer,String> map){
        // add
        System.out.println(map.put(8, "wangcai"));//null
        System.out.println(map.put(8, "xiaoqiang"));//wangcai
        map.put(2,"zhangsan");
        map.put(7,"zhaoliu");

        //remove
		System.out.println("remove:"+map.remove(2));

        // select
		System.out.println("containskey:"+map.containsKey(7));

        //retrieve
        System.out.println("get:"+map.get(6));


        System.out.println(map);

        Outer.Inner.show();
    }

}

interface MyMap{
    public static interface MyEntry{//
        void get();
    }
}

class MyDemo implements MyMap.MyEntry{
    public void get(){}
}

class Outer{
    static class Inner{
        static void show(){}
    }
}





