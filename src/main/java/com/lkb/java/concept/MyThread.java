package com.lkb.java.concept;

public class MyThread implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread is Running....");
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
