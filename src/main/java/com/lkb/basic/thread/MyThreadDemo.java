package com.lkb.basic.thread;

import java.util.Currency;

public class MyThreadDemo {
    public static void main(String[] args) {
        MyPrintJob job = new MyPrintJob();
        JobOne j1 = new JobOne(job);
        JobTwo j2 = new JobTwo(job);
        Thread t1 = new Thread(j1,"t1");
        Thread t2 = new Thread(j2,"t2");

        t1.start();
//        try {
//            t1.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        t2.start();

//        try {
//            Thread.sleep(5000);
//            j1.stopThread();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }
}


class JobOne implements Runnable {
    private volatile boolean stopped;
    MyPrintJob job;

    public JobOne(MyPrintJob job) {
        this.job = job;
    }

    @Override
    public void run() {
        while (!stopped) {
            job.print();
//            try {
//                job.print();
//                Thread.sleep(2000);
//                job.isTrue = false;
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
           // System.out.println("JobOne Running");
        }
    }

    void stopThread() {
        stopped = true;
    }
}

class JobTwo implements Runnable {
    private volatile boolean stopped;
    MyPrintJob job;

    public JobTwo(MyPrintJob job) {
        this.job = job;
    }

    @Override
    public void run() {
        while (!stopped) {
            job.print();
//            try {
//                job.print();
//                Thread.sleep(2000);
//                job.isTrue = false;
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            //System.out.println("JobTwo Running");
        }
    }

    void stopThread() {
        stopped = true;
    }
}

class MyPrintJob {
    static boolean isTrue = true;
    static int count = 0;
    synchronized void print() {
        System.out.println(Thread.currentThread().getName()+"Print Job"+count++);
        try {

            Thread.sleep(2000);
            Thread.yield();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}