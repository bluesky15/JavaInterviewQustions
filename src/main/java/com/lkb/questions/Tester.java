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
        pm.printNumberPyramid(10);
        String input = "89774560";
        System.out.println("Is this string("+input+") a Number: "+pm.isItANumber(input));
        pm.launchApplication("/Applications/Notes.app/Contents/MacOS/Notes");
    }
}
