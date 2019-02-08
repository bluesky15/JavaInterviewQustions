package com.lkb.basic.comparator;

import org.jetbrains.annotations.NotNull;

public class Employee implements Comparable<Employee> {
    private int id;
    private String firstName;
    private String lastName;
    private int age;

    public Employee(int id, String firstName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Employee Id "+getId()+" FirstName: "+getFirstName()+" LastName: "+getLastName()+" Age: "+getAge();
    }

    @Override
    public int compareTo(@NotNull Employee employee) {
        return (this.age-employee.age);
    }
}
