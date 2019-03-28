package com.lkb.basic.designpattern.observer.tweet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Celebrity implements Subscriber {
    private String celebrityName;
    private HashSet<Observer> followers;

    public Celebrity(String celebrityName) {
        this.celebrityName = celebrityName;
        this.followers = new HashSet<>();
    }

    @Override
    public void register(Observer observer) {
        this.followers.add(observer);
    }

    @Override
    public void unRegister(Observer observer) {
        this.followers.remove(observer);
    }

    @Override
    public void tweet(String s) {
        followers.forEach(o -> {
            o.update(celebrityName, s);
        });
    }
}
