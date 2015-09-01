package com.javase.variables;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Pass primitive type data, the arg WILL NOT be updated.
 * Pass reference, the object WILL be updated.
 */
public class PassByValue {

    public static void main(String[] args) {
        int x = 1;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(1, 100);
        map.put(2, 200);

        System.out.println("Before pass x: " + x);
        passPrimitive(x);
        System.out.println("After pass x: " + x);

        System.out.println("======================================");

        System.out.println("Before pass map: " + map);
        passReference(map);
        System.out.println("After pass map: " + map);
    }

    public static void passPrimitive(int x) {
        int result = x * 10;
        System.out.println("passPrimitive: " + result);
    }

    public static void passReference(Map<Integer, Integer> map) {
        map.put(2, 250);
        map.put(3, 300);
        System.out.println("passReference: " + map);

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

    }


}
