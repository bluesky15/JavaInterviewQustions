package com.lkb.basic.java8interface;

public interface Java8Interface {
    void doSomeWork();
    default void log(String str){
        System.out.println("Java8Interfac logger:"+str);
    }
}
