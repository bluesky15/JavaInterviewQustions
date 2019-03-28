package com.lkb.basic.inheritance;

public class TestMain {
    public static void main(String[] args) {
        A aa = new B();// Runtime polymorphism
        aa.printMsg();
    }
}
