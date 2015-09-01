package com.javase.collections.hashcode.ApacheCommonsTools;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        testEmployeeReflection();
        testEmployee();

    }

    public static void testEmployeeReflection(){
        EmployeeReflection emp1 = new EmployeeReflection(1, "Allen", 12, "Accountant");
        EmployeeReflection emp2 = new EmployeeReflection(1, "Allen", 13, "Accountant");
        System.out.println
                ("Is emp1 equals to emp2: " + emp1.equals(emp2));
        Set<EmployeeReflection> employees = new HashSet<EmployeeReflection>();
        employees.addAll(Arrays.asList(emp1,emp2));

        System.out.println("Size of set: " + employees.size());
    }

    public static void testEmployee() {

        Employee emp1 = new Employee(1, "Allen", 12, "Accountant");
        Employee emp2 = new Employee(1, "Allen", 13, "Accountant");
        System.out.println
                ("Is emp1 equals to emp2: " + emp1.equals(emp2));
        Set<Employee> employees = new HashSet<Employee>();
        employees.addAll(Arrays.asList(emp1,emp2));

        System.out.println("Size of set: " + employees.size());
    }
}