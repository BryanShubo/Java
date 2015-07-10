package com.javase.collections;



import java.util.ArrayList;
import java.util.Collection;

public class CollectionAPI {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Collection coll = new ArrayList();

//		show(coll);

        Collection c1 = new ArrayList();
        Collection c2 = new ArrayList();
        show(c1,c2);

    }

    public static void show(Collection c1,Collection c2){

        c1.add("abc1");
        c1.add("abc2");
        c1.add("abc3");
        c1.add("abc4");

        c2.add("abc1");
        c2.add("abc2");
        c2.add("abc3");
        c2.add("abc4");
        c2.add("abc5");

        System.out.println("c1:"+c1);
        System.out.println("c2:"+c2);


        c1.addAll(c2);//


        //removeAll: Removes all of this collection's elements that are also contained in the specified collection (optional operation).
        boolean removeAll = c1.removeAll(c2);
        System.out.println("removeAll:"+removeAll);

        //containsAll: Returns true if this collection contains all of the elements in the specified collection.
        boolean containsAll = c1.containsAll(c2);
        System.out.println("containsAll:"+containsAll);

        //retainAll: Retains only the elements in this collection that are contained in the specified collection (optional operation).
        boolean retainAll = c1.retainAll(c2);
        System.out.println("retainAll:"+removeAll);
        System.out.println("c1:"+c1);


    }

    public static void show(Collection coll){


        coll.add("abc1");
        coll.add("abc2");
        coll.add("abc3");
        System.out.println(coll);


        //2 remove
        coll.remove("abc2");//

        coll.clear();

        System.out.println(coll.contains("abc3"));


        System.out.println(coll);

    }

}
