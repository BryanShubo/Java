package com.javase.collections.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        List list = new ArrayList();
        show(list);
    }

    public static void show(List list) {

        //
        list.add("abc1");
        list.add("abc2");
        list.add("abc3");
        System.out.println(list);


//		list.add(1,"abc9");


//		System.out.println("remove:"+list.remove(2));


//		System.out.println("set:"+list.set(1, "abc8"));


//		System.out.println("get:"+list.get(0));


//		System.out.println("sublist:"+list.subList(1, 2));


        System.out.println(list);


    }

    public static void showIterator(List list) {

        list.add("abc1");
        list.add("abc2");
        list.add("abc3");
        list.add("abc4");

        Iterator it = list.iterator();
        while(it.hasNext()){
            System.out.println("next:"+it.next());
        }

        //listÌØÓÐµÄÈ¡³öÔªËØµÄ·½Ê½Ö®Ò»¡£

        for(int x=0; x<list.size(); x++){
            System.out.println("get:"+list.get(x));
        }
    }

    public static void showListIterator() {
        List list = new ArrayList();
//		show(list);


        list.add("abc1");
        list.add("abc2");
        list.add("abc3");

        System.out.println("list:"+list);
        ListIterator it = list.listIterator();
// When using iterator, do not use list to CURD element. It easily cases
// java.util.ConcurrentModificationException

//ListIterator(only exist in List) can solve this problem.You can do iterator and list CRUD at the same time.

        while(it.hasNext()){

            Object obj = it.next();

            if(obj.equals("abc2")){
                it.set("abc9");
            }
        }
//		System.out.println("hasNext:"+it.hasNext());
//		System.out.println("hasPrevious:"+it.hasPrevious());


        while(it.hasPrevious()){
            System.out.println("previous:"+it.previous());
        }
        System.out.println("list:"+list);
    }

}


