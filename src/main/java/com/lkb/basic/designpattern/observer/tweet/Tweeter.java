package com.lkb.basic.designpattern.observer.tweet;

public class Tweeter {
    public static void main(String[] args) {
        Celebrity salman = new Celebrity("Salman");
        Follower ram = new Follower("Ram");
        Follower jhon = new Follower("jhon");
        Follower jane = new Follower("jane");
        Follower tom = new Follower("tom");
        Follower joe = new Follower("joe");
        salman.register(ram);
        salman.register(jhon);
        salman.register(jane);
        salman.register(tom);
        salman.register(joe);
//        salman.register(joe);
//        salman.register(joe);
//        salman.register(joe);
        salman.tweet("Hi there");
    }
}
