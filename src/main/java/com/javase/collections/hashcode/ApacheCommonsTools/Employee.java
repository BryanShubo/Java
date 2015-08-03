package com.javase.collections.hashcode.ApacheCommonsTools;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Employee {

    private int id;
    private String name;
    private int deptId;
    private String designation;

    public Employee(int id, String name, int deptId, String designation) {
        this.id = id;
        this.name = name;
        this.deptId = deptId;
        this.designation = designation;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Employee == false) {
            return false;
        }

        if (this == obj) {
            return true;
        }
        Employee other = (Employee) obj;
        return new EqualsBuilder().append(this.id , other.id)
                .append(this.name , other.name)
                .append(this.deptId, other.deptId)
                .append(this.designation , other.designation).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.id)
                .append(this.name)
                .append(this.deptId)
                .append(this.designation)
                .hashCode();
    }
}