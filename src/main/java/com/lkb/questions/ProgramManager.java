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

    /**
     * This method demonstrate how you can start an out side application using
     * Java runtime mehtod.
     *
     * @param name
     */
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

    /**
     * This method is for finding the duplicate element in an array.
     *
     * @param list
     * @return
     */
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

    /**
     * This method is for finding the duplicate element in an array.
     *
     * @param list
     * @return
     */
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

    /**
     * This method retains the elements which are common in two Lists.
     *
     * @param a
     * @param b
     * @param <E>
     * @return
     */
    public <E> List<E> findCommonElement(List<E> a, List<E> b) {
        a.retainAll(b);
        return a;
    }

    /**
     * This method retains the elements which are common in two Lists.
     * It do not use the inbuilt API. Uses the iteration.
     *
     * @param a
     * @param b
     * @param <E>
     * @return
     */
    public <E> List<E> findCommonElement2(List<E> a, List<E> b) {
        List<E> list = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < b.size(); j++) {
                if (a.get(i).equals(b.get(j))) {
                    list.add(a.get(i));
                }

            }

        }
        return list;

    }

    /**
     * Method to check two arrays are same or not.
     *
     * @param array1
     * @param array2
     * @return
     */
    public boolean isArraysEqual(String[] array1, String[] array2) {
        return Arrays.equals(array1, array2);
    }

    public boolean isArraysEqual2(String[] array1, String[] array2) {
        boolean isEqual = true;
        if (array1.length == array2.length) {
            for (int i = 0; i < array1.length; i++) {
                if (array1[i] != array2[i]) {
                    isEqual = false;
                }

            }
        } else {
            isEqual = false;
        }
        return isEqual;
    }

    private static boolean checkBinary(Character e) {
        return !(e.compareTo('1') == 0 || e.compareTo('0') == 0);
    }

    /**
     * @param strNumber
     */
    public boolean isNumberBinary(String strNumber) {
        return !(strNumber.chars().mapToObj(e -> (char) e)
                .anyMatch(ProgramManager::checkBinary));
    }

    public boolean isArmstrongNumber(String number) {
        if (Integer.parseInt(number) == number.chars()
                .map(n -> n - '0')
                .map(n -> (int) Math.pow(Integer.parseInt("" + n), 3))
                .sum())
            return true;
        else return false;
    }

    /**
     * This method returns largest number in an array.
     *
     * @param list
     * @return
     */
    public int largestNumberInArray(int[] list) {
        return Arrays.stream(list).sorted().reduce((int first, int second) -> second).orElse(0);
    }

    /**
     * Method to find second largest element of an int array.
     *
     * @param list
     * @return
     */
    public int secondLargestNumberInArray(int[] list) {
        int size = list.length;
        return Arrays.stream(list)
                .sorted()
                .skip(size - 2)
                .findFirst()
                .getAsInt();
    }

    /**
     * Method to count Number of char in a input string.
     * @param str
     * @return
     */
    public HashMap<Character, Integer> getCharCounts(String str) {
        HashMap<Character, Integer> hm = new HashMap<>();
        final int[] count = new int[] {0};
        str.chars().forEach(ch -> {
            count[0] = hm.get((char) ch) != null ? hm.get((char) ch) : 0;
            hm.put((char) ch, count[0] + 1);
        });
        return hm;
    }
}