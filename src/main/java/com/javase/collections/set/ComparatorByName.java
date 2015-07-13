package com.javase.collections.set;

import com.javase.collections.Person;

import java.util.Comparator;

public class ComparatorByName implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {

        Person p1 = (Person)o1;
        Person p2 = (Person)o2;

        int temp = p1.getName().compareTo(p2.getName());

        return temp==0?p1.getAge()-p2.getAge(): temp;
//		return 1;// keep inserting order, like list
    }

}
