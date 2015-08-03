package com.javase.collections.failFastIterator;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by uc0006 on 7/22/2015.
 */
public class FailSafeIterator {


    public static void main(String[] args) {
        FailSafeListAdd();
        FailSafeMapAdd();
    }

    public static void FailSafeListAdd() {
        System.out.println("FailSafeListAdd=============================");
        List<String> cityList = new CopyOnWriteArrayList<String>();
        cityList.add("New York City");
        cityList.add("New Delhi");
        cityList.add("Newark");
        cityList.add("Newport");
        Iterator<String> itr = cityList.iterator();
        while (itr.hasNext())
        {
            System.out.println(itr.next());
            cityList.add("NewCity");
            //itr.remove(); // fail-safe iterator does not support remove, add, and update.
        }
    }

    public static void FailSafeMapAdd() {
        System.out.println("FailSafeMapAdd=============================");
        ConcurrentHashMap<String,String> premiumPhone =
                new ConcurrentHashMap<String,String>();
        premiumPhone.put("Apple", "iPhone");
        premiumPhone.put("HTC", "HTC one");
        premiumPhone.put("Samsung","S5");

        Iterator iterator = premiumPhone.keySet().iterator();

        while (iterator.hasNext())
        {
            System.out.println(premiumPhone.get(iterator.next()));
            premiumPhone.put("Sony", "Xperia Z");
        }
    }
}
