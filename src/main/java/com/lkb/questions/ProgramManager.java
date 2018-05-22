package com.lkb.questions;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class ProgramManager {
    public static final String REVERSE_ENGINE_SB = "API";
    public static final String REVERSE_ENGINE_ITR = "ITERATIVE";
    public static final String REVERSE_ENGINE_REC = "RECURSIVE";


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
            case REVERSE_ENGINE_SB:
                output = revStrUsingSB(input);
                break;
            case REVERSE_ENGINE_REC:
                output = revStrUsingRecursion(input);
                break;
            case REVERSE_ENGINE_ITR:
                output = revStrUsingIteration(input);
                break;

            default:
                output = revStrUsingSB(input);
        }
        return output;
    }

    /**
     * @param input
     * @return
     */
    private String revStrUsingRecursion(String input) {
        if ((null == input) || (input.length() <= 1)) {
            return input;
        }

        return revStrUsingRecursion(input.substring(1)) + input.charAt(0);
    }

    /**
     * Method to reverse the string using StringBuffer.
     *
     * @param str
     * @return
     */
    private String revStrUsingSB(String str) {
        StringBuffer sb = new StringBuffer(str);
        return sb.reverse().toString();

    }

    /**
     * Method to reverse the string using the iteration logic.
     *
     * @return
     */
    private String revStrUsingIteration(String str) {
        char[] strArray = str.toCharArray();
        String revStr = "";
        for (int i = strArray.length - 1; i >= 0; i--) {
            revStr = revStr + strArray[i];
        }
        return revStr;
    }

    public String[] findDuplicateString(String[] list) {
        List<String> duplicates = new ArrayList<>();
        for (int i = 0; i < list.length; i++) {
            for (int j = i + 1; j < list.length; j++) {
                if (list[i].equals(list[j]) && (i != j)) {
                    duplicates.add(list[j]);
                }

            }
        }
        return duplicates.toArray(new String[0]);
    }

    public String[] findDuplicateString2(String[] list) {
        List<String> duplicates = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (String s : list) {
            if (!set.add(s)) {
                duplicates.add(s);
            }
        }
        return duplicates.toArray(new String[0]);
    }

    public String[] readJsonArray(File file) {
        ObjectMapper mapper = new ObjectMapper();
        Animals obj = new Animals();
        try {
            obj = mapper.readValue(file, Animals.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return obj.getAnimalList();
    }

    /**
     * Method to remove spaces from a string.
     *
     * @param str
     * @return
     */
    public String removeSpaces(String str) {
        final String[] filteredString = {""};
        str.chars().mapToObj(e -> (char) e)
                .filter(e -> e.compareTo(' ') != 0)
                .forEach(e -> filteredString[0] += e);
        return filteredString[0];
    }

    public <E> List<E> findCommonElement(List<E> a, List<E> b) {
        a.retainAll(b);
        return a;
    }

}
