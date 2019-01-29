package com.lkb.basic.colldemo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class CollectionDemoList {
    public static void main(String[] args) {
        arrayListDemo();
        vectorDemo();
        linkedListDemo();
    }

    /**
     * Duplicate can be added, null value can be added,
     * Maintain the sequence.
     */
    public static void arrayListDemo(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(7);
        list.add(7);
        list.add(0);
        list.add(null);

        System.out.println(list);
    }
    /**
     * Duplicate can be added, null value can be added,
     * Maintain the sequence.
     * Thread safe so its slower than ArrayList, its comes under legacy class
     */
    public static void vectorDemo(){
        List<Integer> list = new Vector<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(7);
        list.add(7);
        list.add(0);
        list.add(null);
        System.out.println(list);
    }

    /**
     * Duplicate can be added, null value can be added,
     * Maintains the sequence.
     */
    public static void linkedListDemo(){
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(7);
        list.add(7);
        list.add(0);
        list.add(null);
        System.out.println(list);
    }
}
