package com.lkb.basic.colldemo;

import java.util.PriorityQueue;
import java.util.Queue;

public class CollectionDemoQueue {
    public static void main(String[] args) {
        priorityQueueDemo();
    }

    /**
     *
     */
    public static void priorityQueueDemo() {
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(4);
        queue.add(7);
        queue.add(7);
        queue.add(7);
        queue.add(9);
        queue.add(1);
        queue.add(0);
        queue.add(0);
        /*queue.add(null); can not add null (null is a
        literal in Java not a keyword or object)*/
//        queue.remove();
//        queue.remove();
//        queue.remove();
//        queue.remove();

        System.out.println(queue);

    }
}
