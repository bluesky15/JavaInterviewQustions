package com.lkb.basic.colldemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("w");
        list.add("x");
        list.add("c");
        list.add("a");
        list.add("n");
        list.add("m");
        list.add("y");

        Collections.sort(list);
        System.out.println(list);
    }
}
