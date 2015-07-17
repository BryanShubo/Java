package com.javase.collections;

import java.util.IllegalFormatException;

/**
 * Created by uc0006 on 7/17/2015.
 */
public class PersonTest implements Comparable{

    private String name;
    private int age;


    public PersonTest() {
    }

    public PersonTest(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /*
     * compare by age, and then name.
     * 1. Compare by age only: second element with same age but different name will not be added.
     * */
    @Override
    public int compareTo(Object o) {
        if (o instanceof PersonTest) {
            PersonTest personTest = (PersonTest)o;
            int ageDiff = this.getAge() - ((PersonTest) o).getAge();

            if (ageDiff != 0) {
                return ageDiff;
            } else {

                return this.getName().compareTo(((PersonTest) o).getName());
            }
        } else {
            throw new RuntimeException("Wrong object");
        }
    }



}
