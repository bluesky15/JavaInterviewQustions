package com.lkb.basic.colldemo;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class CollectionDemoSet {
    //Collection classes demo
    public static void main(String[] args) {
        hashSetAddElementDemo();
        treeSetDemo();
        linkedHashSetDemo();
    }

    /**
     * No duplicate Items, but the order of the items not maintained.
     * null object can be added.
     */
    public static  void hashSetAddElementDemo(){
        HashSet<Integer> set = new HashSet<>();
        set.add(100);
        set.add(1);
        set.add(5);
        set.add(60);
        set.add(9);
        set.add(10);
        set.add(10);
        set.add(12);
        set.add(null);
        System.out.println(set);
    }

    /**
     * All the Items are sorted and no duplicate items
     * no null object
     */
    public static void treeSetDemo(){
        TreeSet<Integer> tset = new TreeSet<>();
        tset.add(2);
        tset.add(22);
        tset.add(21);
        tset.add(25);
        tset.add(28);
        tset.add(20);
        tset.add(7);
        tset.add(7);
        //tset.add(null);
        tset.add(7);
        System.out.println(tset);
    }

    /**
     * no duplicate & order is maintained
     * null object supported
     */
    public static void linkedHashSetDemo(){
        LinkedHashSet<Integer> lhset = new LinkedHashSet<>();
        lhset.add(50);
        lhset.add(5);
        lhset.add(8);
        lhset.add(1);
        lhset.add(8);
        lhset.add(9);
        lhset.add(null);
        lhset.add(0);
        System.out.println(lhset);
    }

}
