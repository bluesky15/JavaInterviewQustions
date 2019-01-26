package com.lkb.basic.thread;

public class OddEvenJob implements Runnable {
    private static int counter = -1;
    private volatile boolean running = true;
    @Override
    public void run() {
        while (running){
            Thread t  = Thread.currentThread();
            //System.out.println("Thread Name:"+ t.getName());
            increament(t.getName());
            terminate();
        }

    }

    void terminate(){
        running = false;
    }

    public static void main(String[] args) {
        OddEvenJob worker = new OddEvenJob();
        Thread thread = new Thread(worker);

        Thread t2 = new Thread(worker);

        thread.start();
        t2.start();
    }

    synchronized void increament(String name){
        counter+=1;
        System.out.print(name + " : "+counter +" ;");
    }

}

