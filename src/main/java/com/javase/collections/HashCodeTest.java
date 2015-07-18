package com.javase.collections;

import java.util.Comparator;

/**
 * Created by uc0006 on 7/17/2015.
 */
public class HashCodeTest implements Comparable{


    private String firstName;
    private String lastName;


    public HashCodeTest(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    @Override
    public int hashCode() {
        return firstName.hashCode() + lastName.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof HashCodeTest) {
            return (this.firstName.equals(((HashCodeTest)obj).getFirstName()) &&
                    this.getLastName().equals(((HashCodeTest)obj).getLastName()));
        } else {
           throw new RuntimeException("Wrong data type");
        }

    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof HashCodeTest) {

            HashCodeTest obj = (HashCodeTest)o;
            int result = this.getFirstName().compareTo(obj.getFirstName());

            return result==0 ? this.getLastName().compareTo(obj.getLastName()) : result;
        } else {
            throw new RuntimeException("Wrong data type");
        }

    }


}
