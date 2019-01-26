package com.lkb.basic.thread.oddevenproblem.semaphore;

import java.util.concurrent.Semaphore;

public class OddEvenWithSemaphore {
    public static void main(String[] args) {
        SharedPrinter sp = new SharedPrinter();
        Thread odd = new Thread(new Odd(sp, 10), "Odd");
        Thread even = new Thread(new Even(sp, 10), "Even");
        even.start();
        odd.start();

    }
}

class Odd implements Runnable {
    private SharedPrinter sp;
    private int max;

    public Odd(SharedPrinter sp, int i) {
        this.sp = sp;
        this.max = i;
    }

    @Override
    public void run() {
        for (int i = 1; i <= max; i += 2) {
            sp.printOdd(i);
        }
    }
}

class Even implements Runnable {

    private SharedPrinter sp;
    private int max;

    public Even(SharedPrinter sp, int i) {
        this.sp = sp;
        this.max = i;
    }

    @Override
    public void run() {
        for (int i = 0; i <= max; i += 2) {
            sp.printEven(i);
        }
    }
}

class SharedPrinter {
private Semaphore semEven = new Semaphore(1);
private Semaphore semOdd = new Semaphore(0);
    public void printEven(int i) {
        try {
            semEven.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
        System.out.println(Thread.currentThread().getName() +" : "+ i);
        semOdd.release();
    }

    public void printOdd(int i) {
        try {
            semOdd.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
        System.out.println(Thread.currentThread().getName() +" : "+ i);
        semEven.release();
    }
}