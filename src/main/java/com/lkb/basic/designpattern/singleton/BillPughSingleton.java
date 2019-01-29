package com.lkb.basic.designpattern.singleton;

import java.io.Serializable;

public class BillPughSingleton implements Serializable {
    private static final long serialVersionUID = -7604766932017737115L;
    private BillPughSingleton() {
    }

    private static class SingletonHelper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }

    protected Object readResolve(){
        return getInstance();
    }

}
