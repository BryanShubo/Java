package com.javase.collections.hashcode.ApacheCommonsTools;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;


/*
* EqualsBuilder uses reflection to determine if the two Objects are equal or
* HashCodeBuilder uses reflection to build a valid hash code.
* But reflection hits the performance of application, so use it where the performance is
* not very critical.
* */
public class EmployeeReflection {

    private int id;
    private String name;
    private int deptId;
    private String designation;

    public EmployeeReflection(int id, String name, int deptId, String designation) {
        this.id = id;
        this.name = name;
        this.deptId = deptId;
        this.designation = designation;
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    // You can also exclude a field to calculate equals or hashcode
   /* @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals
                (this, obj,new String[] {"deptId"});
    }*/

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

   /* @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode
                (this,new String[] {"deptId"});
    }*/
}