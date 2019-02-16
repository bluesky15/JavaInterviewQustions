package com.lkb.basic.staticdemo;

public class StaticDemo {

    private static int anInt;
    private static byte aByte;
    private static double aDouble;
    private static float aFloat;
    private static long aLong;

    private  int anIntNonStatic;
    private  byte aByteNonStatic;
    private  double aDoubleNonStatic;
    private  float aFloatNonStatic;
    private  long aLongNonStatic;

    public static void main(String[] args) {
       StaticDemo d = new StaticDemo();

        System.out.println("static int default value: "+anInt);
        System.out.println("static byte default value: "+aByte);
        System.out.println("static double default value: "+aDouble);
        System.out.println("static float default value: "+aFloat);
        System.out.println("static long default value: "+aLong);
        System.out.println("--------------------------------------");
        System.out.println("int default value: "+d.anIntNonStatic);
        System.out.println("byte default value: "+d.aByteNonStatic);
        System.out.println("double default value: "+d.aDoubleNonStatic);
        System.out.println("float default value: "+d.aFloatNonStatic);
        System.out.println("ong default value: "+d.aLongNonStatic);
    }

}
