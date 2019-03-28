package com.lkb.questions;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ProgramManager {
    public static final String REVERSE_ENGINE_SB = "API";
    public static final String REVERSE_ENGINE_ITR = "ITERATIVE";
    public static final String REVERSE_ENGINE_REC = "RECURSIVE";
    public static ProgramManager instance;

    private ProgramManager() {
    }

    // Its called lazy initialization.
    public static synchronized ProgramManager getInstance() {
        if (instance == null) {
            instance = new ProgramManager();
        }
        return instance;
    }

    /**
     * This method counts the Numbers in an array.
     *
     * @param nums
     * @return
     */
    public HashMap<Integer, Integer> getNumberCuntInArray(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int n : nums) {
            if (hm.get(n) != null) {
                hm.put(n, hm.get(n) + 1);
            } else {
                hm.put(n, 1);
            }

        }
        return hm;
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
     * This method removes the duplicate elements.
     *
     * @param list
     * @param <E>
     * @return
     */
    public <E> List<E> removeDuplicateElement(List<E> list) {
        List<E> list2 = new ArrayList<>();
        list.stream().distinct().forEach(e -> list2.add(e));
        return list2;
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
     * Returns the Max repeating char in a string
     * if no repeating then returns first char.
     *
     * @param str
     * @return
     */
    public char getMaxRepeatCharCountInString(String str) {
        AtomicReference<Character> repeatChar = new AtomicReference<>((char) 0);
        AtomicInteger temp = new AtomicInteger();
        temp.set(0);
        HashMap<Character, Integer> hm = getCharCounts(str);
        hm.forEach((ch, x) -> {
            if (x > temp.get()) {
                temp.set(x);
                repeatChar.set(ch);
            }

        });
        return repeatChar.get();
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
        return str1
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
                        .toString());
    }

    /**
     * This methid sort all the character of a string
     *
     * @param str
     * @return
     */
    public String sortAllCharacterOfString(String str) {
        return str.replaceAll("\\s", "")
                .toLowerCase()
                .codePoints()
                .sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
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
     *
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
     *
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
     *
     * @param inputNumber
     * @return
     */
    public int sumOfAllDigit(int inputNumber) {
        return String.valueOf(inputNumber).chars()
                .map(c -> Integer.parseInt("" + (char) c))
                .reduce((x, y) -> x + y).orElse(0);
    }


    public int[][] getMatrix(int row, int col, int[] elements) {
        int[][] matrix = new int[row][col];
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = elements[count];
                count++;
            }
        }
        return matrix;
    }

    /**
     * Method to count the word in string.
     *
     * @param string
     * @return
     */
    public long getWordCount(String string) {
        return Arrays.stream(string.trim().split(" "))
                .filter(s -> !s.contentEquals(""))
                .count();
    }

    /**
     * Swap Characters at position
     *
     * @param a string value
     * @param i position 1
     * @param j position 2
     * @return swapped string
     */
    public String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    /**
     * permutation function
     *
     * @param str string to calculate permutation for
     * @param l   starting index
     * @param r   end index
     */
    private void permute(String str, int l, int r) {
        if (l == r)
            System.out.println(str);
        else {
            for (int i = l; i <= r; i++) {
                str = swap(str, l, i);
                permute(str, l + 1, r);
                str = swap(str, l, i);
            }
        }
    }

    /**
     * Method to check if a number is Niven number of not.
     *
     * @param number
     * @return
     */
    public boolean isHarshadOrNivenNumber(int number) {
        int sum = sumOfAllDigit(number);
        if (number % sum == 0) {
            return true;
        } else return false;
    }

    /**
     * Method to generate fibonacci numbers.
     *
     * @param n
     * @param t0
     * @param t1
     * @return
     */
    public long[] fibGen(int n, int t0, int t1) {
        long[] fibNumbers = new long[n];
        fibNumbers[0] = t0;
        fibNumbers[1] = t1;
        for (int i = 2; i < n; i++) {
            int next = t0 + t1;
            t0 = t1;
            t1 = next;
            fibNumbers[i] = next;
        }
        return fibNumbers;
    }

    /**
     * Fibonacci number checking.
     *
     * @param num
     * @return
     */
    public boolean isNumberBelongToFibonacciSeries(long num) {
        long t0 = 0;
        long t1 = 1;
        long next = 0;
        while (next < num) {
            next = t0 + t1;
            t0 = t1;
            t1 = next;
        }
        if (next == num) return true;
        else return false;
    }

    public int[] survivalCells(int[] input1, int[] input2) {
        int row = input1[0];
        int col = input1[1];
        int s1 = input1[2];
        int s2 = input1[3];
        int b1 = input1[4];
        int b2 = input1[5];
        int gen = input1[6];

        Matrix2D field = new Matrix2D(row, col, input2);
        Matrix2D nextGenMatrix = null;
        for (int g = 0; g < gen; g++) {
            System.out.println(field);
            nextGenMatrix = new Matrix2D(row, col);
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    int fieldValue = field.getMatrixIndexValue(i, j);
                    int[] getNeighbour = field.getNeighbourElements(field, i, j);
                    int s = 0;
                    int b = 0;
                    for (int k = 0; k < getNeighbour.length; k++) {
                        if (getNeighbour[k] == 0)
                            b = b + 1;
                        else if (getNeighbour[k] == 1)
                            s = s + 1;

                    }
                    if ((fieldValue == 1 && (s >= s1 && s <= s2)) || (fieldValue == 0 && (s >= b1 && s <= b2))) {
                        nextGenMatrix.setMatrixIndexValue(i, j, 1);
                    }


                }

            }
            field = nextGenMatrix;
        }
        return field.getMatrixElements();
    }

    /**
     * Generate integer stream with provided range.
     *
     * @param range
     * @return
     */
    public IntStream generateNumbers(int range) {
        return IntStream.range(1, range);
    }

    public IntStream isDivisibleBy(int divisor, int numberRange) {
        return generateNumbers(numberRange).filter(i -> i % divisor == 0);
    }

    /**
     * Method to find sum of all the multiples of X or Y
     *
     * @param x
     * @param y
     * @param exclusiveRange
     * @return
     */
    public int sumOfAllMultiplesOfXORY(int x, int y, int exclusiveRange) {
        return IntStream.range(1, exclusiveRange)
                .filter(i -> i % x == 0)
                .sum() + IntStream.range(1, exclusiveRange)
                .filter(i -> i % y == 0)
                .sum() - IntStream.range(1, exclusiveRange)
                .filter(i -> i % (x * y) == 0)
                .sum();
    }

    /**
     * Method to find the prime number.
     *
     * @param n
     * @return
     */
    public List<Integer> findPrimes(int n) {
        return IntStream
                .rangeClosed(0, n)
                .filter(this::isPrime)
                .boxed()
                .collect(Collectors.toList());
    }

    public boolean isPrime(int num) {
        if (num <= 1) return false;
        return IntStream
                .rangeClosed(2, num / 2)
                .noneMatch(divisor -> num % divisor == 0);
    }

    /**
     * Method to check for Number is Palindrome or not
     *
     * @param num
     * @return
     */
    public boolean isPalindrome(int num) {
        int temp = num;
        int sum = 0;
        while (num > 0) {
            int remainder = num % 10;
            sum = (sum * 10) + remainder;
            num = num / 10;

        }
        if (temp == sum) return true;
        else return false;
    }

    public void createFile(String fileName, String path, String content) {
        String msg = content;
        FileWriter fw = null;
        File file = new File(path + "" + fileName);
        try {
            fw = new FileWriter(file);
            fw.write(msg);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void stringToCharDemo(String str) {
//        char[] charArray = str.toCharArray();
//        for(char c:charArray){
//            System.out.println(c);
//        }
        // str.chars().mapToObj(c-> (char)c).forEach(System.out::println);
        Stream<String> strStream = str.codePoints().mapToObj(c -> String.valueOf((char) c));
        strStream.forEach(System.out::println);
    }

    public boolean checkTheFirstCharPresent(String s) {
        // get the first char of the string

        char c = s.charAt(0);

        Pattern p = Pattern.compile(""+c);

        List<String> list = new ArrayList<>();
        list.add("ab");
        list.add("ba");
        list.add("cd");
        list.add("fg");
        list.add("to");
        list.add("op");
        list.add("pq");
        list.add("rq");
        list.add("mq");
        list.add("kl");
        list.add("li");
        boolean s2 = list.stream().filter(e -> e.matches("[" + c + "][a-z]")).findAny().isPresent();
        if (s2) {
            return true;
        } else {
            list.add(s);
            return false;
        }
    }

}