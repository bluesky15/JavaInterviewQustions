package com.lkb.basic.thread.oddevenproblem;

public class OddEvenJob implements Runnable {
    private int max;
    private Printer print;
    private boolean isEvenNumber;

    public OddEvenJob(int max, Printer print, boolean isEvenNumber) {
        this.max = max;
        this.print = print;
        this.isEvenNumber = isEvenNumber;
    }

    @Override
    public void run() {
        int number = isEvenNumber ? 0 : 1;
        while (number < max) {
            if (isEvenNumber) {
                print.printEven(number);
            } else {
                print.printOdd(number);
            }
            number += 2;
        }

    }

    public static void main(String[] args) {
        Printer print = new Printer();
        Thread t1 = new Thread(new OddEvenJob(10, print, false), "Odd");
        Thread t2 = new Thread(new OddEvenJob(10, print, true), "Even");
        t1.start();
        t2.start();


    }


}

class Printer {
    private volatile boolean isEven;

    synchronized void printEven(int number) {
        while (isEven) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(Thread.currentThread().getName() + ":" + number);
        //System.out.print(number);
        isEven = true;
        notify();
    }

    synchronized void printOdd(int number) {
        while (!isEven) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(Thread.currentThread().getName() + ":" + number);
        //System.out.print(number);
        isEven = false;
        notify();
    }
}
