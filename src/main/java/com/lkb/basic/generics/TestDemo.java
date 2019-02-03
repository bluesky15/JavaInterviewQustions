package com.lkb.basic.generics;

public class TestDemo {
    public static void main(String[] args) {
        GenericAddDemo<Number> gd = new GenericAddDemo<>();
        System.out.println(gd.add(7,7.6));
    }
}
