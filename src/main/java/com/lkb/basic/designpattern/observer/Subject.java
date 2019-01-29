package com.lkb.basic.designpattern.observer;

public interface Subject {
    // methods to register and unregister
    public void register(Observer observer);
    public void unregister(Observer observer);

    // method to notify observers of change
    public void notifyObservers();

    //method to get updates from subject
    public Object getUpdate(Observer observer);

}
