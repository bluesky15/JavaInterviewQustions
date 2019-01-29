package com.lkb.basic.designpattern.observer.simple;

abstract class Observer {
    protected Subject subject;
    public abstract void update();
}
