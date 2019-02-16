package com.lkb.basic.java8interface;

public class Tester implements Java8Interface{
    @Override
    public void doSomeWork() {
        System.out.println("Working");
    }

    public static void main(String[] args) {
        Tester t = new Tester();
        t.log("Hello");
    }
}
