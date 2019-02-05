package com.lkb.basic.colldemo;


import java.util.*;

public class CollectionDemoMap {
    public static void main(String[] args) {
        hashMapDemo();
        hashTableDemo();
        linkedHashMapDemo();
        treeMapDemo();

    }

    /**
     * Can store key value pair, does not maintain the order.
     * can contain one null key , null value can be stored.
     * not synchronized - no thread safe
     */
    static void hashMapDemo() {
        Map<Integer, Integer> hmap = new HashMap<>();
        hmap.put(1, 1);
        hmap.put(2, 5);
        hmap.put(3, 7);
        hmap.put(4, 0);
        hmap.put(5, null);
        hmap.put(null, 1);
        System.out.println(hmap);
    }

    /**
     * Can not store null key nor value. synchronized . Maintain the insertion order .
     */
    static void hashTableDemo() {
        Map<Integer, Integer> hTable = new Hashtable<>();
        hTable.put(1, 1);
        hTable.put(2, 5);
        hTable.put(3, 7);
        hTable.put(4, 0);
        //hTable.put(5,null); can not store null value nor the null key
        //hTable.put(null,1);
        System.out.println(hTable);
    }

    /**
     * Can store null key or multiple null value, keys are sorted Ascending order.
     */
    static void linkedHashMapDemo() {
        Map<Integer, Integer> lhm = new LinkedHashMap<>();
        lhm.put(1, 1);
        lhm.put(2, 5);
        lhm.put(20, 7);
        lhm.put(3, 7);
        lhm.put(4, 0);
        lhm.put(5, null); //can store null value nor the null key
        lhm.put(null, 1);
        System.out.println(lhm);
    }

    /**
     * Keys are in sorted order , does not maintain insertion order.
     * Maintain unique element.
     */
    static void treeMapDemo(){
        Map<Integer, Integer> tm = new TreeMap<>();
        tm.put(1, 20);
        tm.put(7, 20);
        tm.put(2, 5);
        tm.put(20, 7);
        tm.put(3, 7);
        tm.put(4, 0);
        //tm.put(5, null); //can not store null value nor the null key
        //tm.put(null, 1);
        System.out.println(tm);
    }

}
