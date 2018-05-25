package com.lkb.questions;

import com.fasterxml.jackson.databind.ObjectMapper;
import sun.jvm.hotspot.tools.jcore.PackageNameFilter;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.IntStream;

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
        int exponent = number.length();
        if (Integer.parseInt(number) == number.chars()
                .map(n -> n - '0')
                .map(n -> (int) Math.pow(Integer.parseInt("" + n), exponent))
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
     *
     * @param str
     * @return
     */
    public HashMap<Character, Integer> getCharCounts(String str) {
        HashMap<Character, Integer> hm = new HashMap<>();
        final int[] count = new int[]{0};
        str.chars().forEach(ch -> {
            count[0] = hm.get((char) ch) != null ? hm.get((char) ch) : 0;
            hm.put((char) ch, count[0] + 1);
        });
        return hm;
    }

    /**
     * This method generates random number with a specified range.
     *
     * @param range
     * @return
     */
    public int generateRandomNumber(int range) {
        return (int) (Math.random() * range);
    }

    /**
     * This method generates random number with a specified range.
     *
     * @param range
     * @return
     */
    public int generateRandomNumber2(int range) {
        Random random = new Random();
        return random.nextInt(range);
    }

    /**
     * This method checks the string for Anagram.
     * (Two strings are called anagrams if they contain
     * same set of characters but in different order.)
     *
     * @param str1
     * @param str2
     * @return
     */
    public boolean isAnagram(String str1, String str2) {
        return ((str1
                .replaceAll("\\s", "")
                .toLowerCase()
                .codePoints()
                .sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString()
                .contentEquals(str2
                        .replaceAll("\\s", "")
                        .toLowerCase()
                        .codePoints()
                        .sorted()
                        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                        .toString())));
    }

    /**
     * This method will return the duplicate element in a HashMap.
     * eg.- if the sting is "J2EE" the return value will be like {2=0, E=1, J=0}
     * which means only E is repeated once or Only 2 'E' character available in
     * supplied string.
     *
     * @param str
     * @return
     */
    public HashMap<Character, Integer> getDuplicateChar(String str) {
        HashMap<Character, Integer> hm = new HashMap<>();
        final int[] count = new int[]{-1};
        str.chars().forEach(ch -> {
            count[0] = hm.get((char) ch) != null ? hm.get((char) ch) : -1;
            hm.put((char) ch, count[0] + 1);
        });
        return hm;
    }

    /**
     * Method to replace all the Vowels from a string.
     * This method uses replaceAll method with a regular expression.
     *
     * @param str
     * @return
     */
    public String replaceAllVowels(String str) {
        return str.replaceAll("[AEIOUaeiou]", "");
    }

    public static int[] revIntArray(int[] inputArray) {
        return IntStream.range(0, inputArray.length)
                .map(i -> inputArray[inputArray.length - 1 - i])
                .toArray();
    }

    /**
     * Method to reverse each words in a string.
     * @param str
     * @return
     */
    public String revEachWordInAString(String str) {
        return Arrays.stream(str.split(" "))
                .map(ProgramManager::revStr)
                .reduce((x, y) -> x + " " + y)
                .orElse("Error");
    }

    /**
     * Method to reverse one string which contains no space.
     * or - this mehod only revers a single word.
     * @param str
     * @return
     */
    private static String revStr(String str) {
        byte[] strAsByteArray = str.getBytes();
        byte[] result = new byte[strAsByteArray.length];
        IntStream.range(0, strAsByteArray.length).forEach(i -> result[i] = strAsByteArray[strAsByteArray.length - i - 1]);
        return new String(result);
    }

    /**
     * This method will add all the digits of an Integer passed.
     * @param inputNumber
     * @return
     */
    public int sumOfAllDigit(int inputNumber){
     return String.valueOf(inputNumber).chars()
             .map(c->Integer.parseInt(""+(char)c))
             .reduce((x,y)->x+y).orElse(0);
    }

}