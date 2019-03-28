package com.lkb.basic.designpattern.observer.tweet;

public interface Subscriber {
    void register(Observer observer);
    void unRegister(Observer observer);
    void tweet(String s);
}
