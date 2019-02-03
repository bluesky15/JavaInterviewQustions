package com.lkb.basic.generics;

public class GenericAddDemo<T> {

    public static <T extends Number> Object add(T x, T y) {
        if (x.getClass().getSimpleName().equalsIgnoreCase("Integer"))
            return (x.intValue() + y.intValue());

        else if (x.getClass().getSimpleName().equalsIgnoreCase("Double"))
            return (x.doubleValue() + y.doubleValue());

        else if (x.getClass().getSimpleName().equalsIgnoreCase("Float"))
            return (x.floatValue() + y.floatValue());
        else throw new RuntimeException("Unsupported type");
    }
}
