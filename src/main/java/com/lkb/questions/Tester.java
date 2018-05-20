package com.lkb.questions;

public class Tester {
    public static void main(String[] args) {
        String[] list = new String[]{"Mango", "Banana", "Apple", "Orange", "Grapes","Avocado","Mango", "Banana", "Apple", "Orange", "Grapes","Avocado"};
        ProgramManager pm = new ProgramManager();
        list = pm.naturalSort(list);
        for (String s : list
                ) {
            System.out.println(s+", " );
        }
        pm.printStarPyramid(9);
    }
}
