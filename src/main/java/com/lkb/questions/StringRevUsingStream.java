package com.lkb.questions;

import java.util.stream.IntStream;

public class StringRevUsingStream {
    public String revString(String str){
        return IntStream.range(0, str.length())
                .map(i -> str.charAt(str.length() - i - 1))
                .collect(StringBuilder::new, (sb, c) -> sb.append((char) c), StringBuilder::append)
                .toString();

    }

    public static void main(String[] args) {
        StringRevUsingStream srus = new StringRevUsingStream();
        System.out.println(srus.revString("Hello"));
    }
}
