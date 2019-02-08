package com.lkb.basic.comparator;

import java.util.Arrays;

public class ComparatorDemo {
    public static void main(String[] args) {
//          int[] arr = new int[]{1,1,1,1,1,0,0,0,0,0,0,0};
        Employee[] empArray = new Employee[4];
        empArray[0] = new Employee(1,"Lk","b",32);
        empArray[1] = new Employee(3,"Ram","sharma",23);
        empArray[2] = new Employee(5,"Sandip","Sing",32);
        empArray[3] = new Employee(2,"Rabi","Kumar",25);
        Arrays.sort(empArray);
        Arrays.stream(empArray).forEach(System.out::println);
//        Arrays.sort(arr);
//        Arrays.stream(arr).forEach(System.out::print);
    }
}
