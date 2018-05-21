package com.lkb.questions;

import com.sun.xml.internal.xsom.impl.scd.Iterators;

import java.io.IOException;
import java.util.Arrays;

public class ProgramManager {
    public static final String REVERSE_INGINE_SB = "API";
    public static final String REVERSE_INGINE_ITR = "ITERATIVE";
    public static final String REVERSE_INGINE_REC = "RECURSIVE";

    public ProgramManager() {
    }

    /**
     * This method sort the strings in alphabetical order.
     *
     * @param list
     * @return
     */

    public String[] naturalSort(String[] list) {
        Arrays.sort(list);
        return list;
    }

    /**
     * Pyramid creation using the '*' character.
     *
     * @param height
     */
    public void printStarPyramid(int height) {
        int maxHeight = 10;
        int rowCount = 1;
        if (height > maxHeight) {
            System.out.println("Max height is " + maxHeight + " supported!");
            return;
        }
        // do if height is  maxHeight or less than maxHeight
        for (int i = height; i > 0; i--) {

            for (int j = 1; j <= i; j++)
                System.out.print(" ");

            for (int k = 1; k <= rowCount; k++)
                System.out.print("* ");

            System.out.println();
            rowCount++;

        }
    }

    /**
     * This method prints number pyramid.
     *
     * @param height
     */
    public void printNumberPyramid(int height) {
        int maxHeight = 10;
        int rowCount = 1;
        if (height > maxHeight) {
            System.out.println("Max height is " + maxHeight + " supported!");
            return;
        }
        for (int i = height; i > 0; i--) {
            //Printing i*2 spaces at the beginning of each row

            for (int j = 1; j <= i * 2; j++) {
                System.out.print(" ");
            }

            //Printing j value where j value will be from 1 to rowCount

            for (int j = 1; j <= rowCount; j++) {
                System.out.print(j + " ");
            }

            //Printing j value where j value will be from rowCount-1 to 1

            for (int j = rowCount - 1; j >= 1; j--) {
                System.out.print(j + " ");
            }

            System.out.println();

            //Incrementing the rowCount

            rowCount++;
        }

    }

    /**
     * This method checks the string is a number or not.
     *
     * @param input
     * @return
     */
    public boolean isItANumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            return false;
        }

        return true;
    }

    public void launchApplication(String name) {
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec(name);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Method to reverse a string.
     *
     * @param input
     * @return
     */
    public String revString(String input, String engine) {
        String output = "";
        switch (engine) {
            case REVERSE_INGINE_SB:
                output = revStrUsingSB(input);
                break;
            case REVERSE_INGINE_REC:
                break;
            case REVERSE_INGINE_ITR:
                break;

            default:
                output = revStrUsingSB(input);
        }
        return output;
    }

    public String revStrUsingSB(String str) {
        StringBuffer sb = new StringBuffer(str);
        return sb.reverse().toString();

    }
}
