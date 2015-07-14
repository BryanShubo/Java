package com.javase.collections.map;

import java.util.Comparator;

public class ComparatorByName implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {

        Student s1 = (Student) o1;
        Student s2 = (Student) o2;

        int result = s1.getName().compareTo(s2.getName());

        return result == 0 ? s1.getAge() - s2.getAge() : result;
    }
}