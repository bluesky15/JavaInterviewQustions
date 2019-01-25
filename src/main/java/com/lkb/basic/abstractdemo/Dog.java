package com.lkb.basic.abstractdemo;

public class Dog extends Animal implements AnimalWithTail {
    /**
     * This explains that two interfaces can have same methods and can be implemented in one class.
     * But only one override method will be present . The method return type should be same.
     */
    public Dog(){
        super();
    }

    @Override
    public void noise() {

    }

    @Override
    public void color() {

    }

    @Override
    public void kind() {

    }

    public static void main(String[] args) {
        Dog d = new Dog();
        System.out.println("DOg");
    }
}
