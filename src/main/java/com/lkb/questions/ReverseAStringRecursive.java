package com.lkb.questions;

public class ReverseAStringRecursive {

    public String revString(String str) {
        String reverse = "";
        if(str.length()<1){
            return str;
        }else {
            reverse += str.charAt(str.length() - 1) + revString(str.substring(0, str.length() - 1));
            return reverse;
        }

    }

    public static void main(String[] args) {
        ReverseAStringRecursive srev = new ReverseAStringRecursive();
        System.out.println(srev.revString("Hello"));
    }

}
