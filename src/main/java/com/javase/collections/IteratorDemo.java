package com.javase.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratorDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {

        Collection coll = new ArrayList();
        coll.add("abc1");
        coll.add("abc2");
        coll.add("abc3");
        coll.add("abc4");

//		System.out.println(coll);


//		Iterator it = coll.iterator();
//		while(it.hasNext()){
//			System.out.println(it.next());
//		}

        for(Iterator it = coll.iterator(); it.hasNext(); ){
            System.out.println(it.next());
        }

/*
		System.out.println(it.next());
		System.out.println(it.next());
		System.out.println(it.next());
		System.out.println(it.next());
		System.out.println(it.next());//java.util.NoSuchElementException
*/

    }

}







