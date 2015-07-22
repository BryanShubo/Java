package com.javase.collections.failFastIterator;

import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * For both map and list, update an element is not structural modification.
 * Add and delete are structural modifications.
 *
 * fail-fast iterator supports remove, set, and add operations, but fail-safe doe not.
 */
public class FailFastIterator {


    public static void main(String[] args) {

        FailFastMapUpdate(); // Update is not structural modification, so no exception
        FailFastMapAdd(); // Add is structural modification, so expect exception
        FailFastMapDelete(); // Delete is structural modification, so expect exception
        //FailFastMultithreadDelete();
        //FailFastMultithreadUpdate();

    }

    public static void FailFastMapUpdate() {
        System.out.println("FailFastMapUpdate==========================");
        Map<String,String> cityMap = new HashMap<String,String>();
        cityMap.put("1","New York City" );
        cityMap.put("2", "New Delhi");
        cityMap.put("3", "Newark");
        cityMap.put("4", "Newport");

        try {
            Iterator<String> itr = cityMap.keySet().iterator();
            while (itr.hasNext()){
                System.out.println(cityMap.get(itr.next()));
                cityMap.put("2", "Ellicott City");
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("ConcurrentModificationException");
        }

    }

    public static void FailFastMapAdd() {
        System.out.println("FailFastMapAdd========================");
        Map<String,String> cityMap = new HashMap<String,String>();
        cityMap.put("1","JFK" );
        cityMap.put("2", "MIA");
        cityMap.put("3", "EWR");
        cityMap.put("4", "LGA");

        try {
            Iterator<String> itr = cityMap.keySet().iterator();
            while (itr.hasNext()){
                System.out.println(cityMap.get(itr.next()));
                cityMap.put("5", "BWI");
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("ConcurrentModificationException");
        }

    }

    public static void FailFastMapDelete() {
        System.out.println("FailFastMapDelete===================");
        Map<String,String> cityMap = new HashMap<String,String>();
        cityMap.put("1","JFK" );
        cityMap.put("2", "MIA");
        cityMap.put("3", "EWR");
        cityMap.put("4", "LGA");

        try {
            Iterator<String> itr = cityMap.keySet().iterator();
            while (itr.hasNext()){
                System.out.println(cityMap.get(itr.next()));
                cityMap.remove("3");
                //itr.remove(); // Working fine because this scenario is not concurrent modification.
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("ConcurrentModificationException");
        }

    }


    /**
     * thread1 iterates collection
     * thread2 deletes an element from collection
     */
    public static void FailFastMultithreadDelete() {
        System.out.println("FailFastMultithreadDelete=============================");
        final Map<String,String> cityMap = new HashMap<String,String>();
        cityMap.put("1","NYC" );
        cityMap.put("2", "SFO");
        cityMap.put("3", "CLT");
        cityMap.put("4", "LAS");
        //This thread will print the map values
        Thread thread1 = new Thread(){
            public void run(){
                try{
                    Iterator i = cityMap.keySet().iterator();
                    while (i.hasNext()){
                        System.out.println(i.next());
                        // Using sleep to simulate concurrency
                        Thread.sleep(1000);
                    }
                }catch(ConcurrentModificationException e){
                    System.out.println("thread1 : Concurrent modification detected on this map");
                }catch(InterruptedException e){

                }
            }
        };
        thread1.start();
        // This thread will try to remove value from the collection,
        // while the collection is iterated by another thread.
        Thread thread2 = new Thread(){
            public void run(){
                try{
                    // Using sleep to simulate concurrency
                    Thread.sleep(2000);
                    // removing value from the map
                    cityMap.remove("2");
                    System.out.println("city with key 2 removed successfully");
                }catch(ConcurrentModificationException e){
                    System.out.println("thread2 : Concurrent modification detected on this map");
                } catch(InterruptedException e){}
            }
        };
        thread2.start();
    }

    public static void FailFastMultithreadUpdate() {
        System.out.println("FailFastMultithreadUpdate=====================");
        final Map<String,String> cityMap = new HashMap<String,String>();
        cityMap.put("1","New York City" );
        cityMap.put("2", "New Delhi");
        cityMap.put("3", "Newark");
        cityMap.put("4", "Newport");
        //This thread will print the map values
        Thread thread1 = new Thread(){
            public void run(){
                try{
                    Iterator i = cityMap.keySet().iterator();
                    while (i.hasNext()){
                        System.out.println(cityMap.get(i.next()));
                        // Using sleep to simulate concurrency
                        Thread.sleep(1000);
                    }
                }catch(ConcurrentModificationException e){
                    System.out.println("thread1 : Concurrent modification detected on this map");
                }catch(InterruptedException e){

                }
            }
        };
        thread1.start();

        Thread thread2 = new Thread(){
            public void run(){
                try{
                    // Using sleep to simulate concurrency
                    Thread.sleep(500);
                    // removing value from the map
                    cityMap.put("2", "New City");
                    System.out.println("city with key 2 updated successfully");
                }catch(ConcurrentModificationException e){
                    System.out.println("thread2 : Concurrent modification detected on this map");
                } catch(InterruptedException e){}
            }
        };
        thread2.start();
    }
}
