package com.lkb.basic.designpattern.observer;

import java.lang.invoke.MutableCallSite;
import java.util.ArrayList;
import java.util.List;

public class MyTopic implements Subject {
    private List<Observer> listOfObservers;
    private String message;
    private boolean changed;
    private final Object MUTEX = new Object();

    public MyTopic() {
        this.listOfObservers = new ArrayList<>();
    }

    @Override
    public void register(Observer observer) {
        if (observer == null) throw new NullPointerException("Null Observer");
        synchronized (MUTEX) {
            if (!listOfObservers.contains(observer)) listOfObservers.add(observer);
        }
    }

    @Override
    public void unregister(Observer observer) {
        synchronized (MUTEX) {
            listOfObservers.remove(observer);
        }
    }

    @Override
    public void notifyObservers() {
        List<Observer> observersLocal = null;
        synchronized (MUTEX) {
            if (!changed) return;
            observersLocal = new ArrayList<>(this.listOfObservers);
            this.changed = false;
        }
        for (Observer ob : observersLocal) {
            ob.update();
        }
    }

    @Override
    public Object getUpdate(Observer observer) {
        return this.message;
    }

    // method to post message to the topic
    public void postMessage(String msg) {
        System.out.println("Message posted to Topics" + msg);
        this.message = msg;
        this.changed = true;
        notifyObservers();
    }
}
