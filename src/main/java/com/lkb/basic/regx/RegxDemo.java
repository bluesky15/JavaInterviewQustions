package com.lkb.basic.regx;

import java.util.regex.Pattern;

public class RegxDemo {
    public static void main(String[] args) {
        String s = "ab";
        System.out.println(Pattern.matches("[a][a-z]",s));
    }
}
