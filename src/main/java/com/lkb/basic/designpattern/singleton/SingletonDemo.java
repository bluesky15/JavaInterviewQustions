package com.lkb.basic.designpattern.singleton;

public class SingletonDemo {
    public static void main(String[] args) {
//        Singleton instance = Singleton.getInstance();
//        Singleton instance1 = Singleton.getInstance();
        BillPughSingleton instance = BillPughSingleton.getInstance();
        BillPughSingleton instance1 = BillPughSingleton.getInstance();
        System.out.println(instance.hashCode());
        System.out.println(instance1.hashCode());
        System.out.println(instance.equals(instance1));
    }
}
