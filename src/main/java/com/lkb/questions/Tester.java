package com.lkb.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Tester {
    public static void main(String[] args) {
        ProgramManager pm = ProgramManager.getInstance();
//        String[] list = new String[]{"Mango", "Banana", "Apple", "Orange", "Grapes", "Avocado", "Banana", "Avocado"};
//        list = pm.naturalSort(list);
//        for (String s : list
//                ) {
//            System.out.println(s+", " );
//        }
//        pm.printStarPyramid(9);
//        pm.printNumberPyramid(10);
//        String input = "89774560";
//        System.out.println("Is this string("+input+") a Number: "+pm.isItANumber(input));
//        pm.launchApplication("/Applications/Notes.app/Contents/MacOS/Notes");
//        System.out.println(pm.revString("new branch",pm.REVERSE_INGINE_ITR));
//        System.out.println(pm.revStrUsingRecursion("Hello"));
//        list = pm.findDuplicateString(list);
//        for (int i = 0; i < list.length; i++) {
//            String s = list[i];
//            System.out.println(s);
//        }
//        File jsonFile = new File("D:\\Code\\JavaInterviewQuestion\\JavaInterviewQustions\\src\\main\\resources\\animal.json");
//        String[] dataList = pm.readJsonArray(jsonFile);
//        Arrays.stream(dataList).forEach(System.out::println);
//        System.out.println("Output String :" + pm.removeSpaces(" A b so l ut e"));
//        List<String> a = new ArrayList<>(Arrays.asList(new String[]{"One", "Two", "Four"}));
//        List<String> b = new ArrayList<>(Arrays.asList(new String[]{"One", "Two", "Three"}));
//        ArrayList c = new ArrayList<>(Arrays.asList(new Integer[]{ 1,2,3,4,5,6,7,8,9,10 }));
//        ArrayList d = new ArrayList<>(Arrays.asList(new Integer[] {1, 2, 3}));
//        System.out.println(pm.findCommonElement2(a, b));
//        System.out.println(pm.findCommonElement2(c, d));
//        String number ="157";
//        pm.isArmstrongNumber(number);
//        int number = 103450;
//
//        (number+"").chars().mapToObj(e -> (char) e).map(e -> Integer.parseInt(""+e)).forEach(System.out::println);
//        pm.largestNumberInArray(new int[]{1,8,5,9,2,3,7,55});
//        System.out.println(pm.secondLargestNumberInArray(new int[]{1,8,5,9,2,44,3,7,55}));
//        System.out.println(pm.getCharCounts("Hello world"));
//        for (int i = 0; i < 200; i++) {
//            System.out.println(pm.generateRandomNumber2(300));
//        }
//        pm.isAnagram("keep", "peek");
//        System.out.println(pm.getDuplicateChar("J2EE"));
//        System.out.println( pm.revEachWordInAString("Java is Excellent"));
//        System.out.println(pm.sumOfAllDigit(934559180));
//
//        Matrix2D matrix = new Matrix2D(4, 3, new int[]{
//                0, 2, 1,
//                1, 5, 2,
//                6, 1, 9,
//                5, 4, 8});
//        System.out.println(matrix);
//        int[] cornerElements = Matrix2D.getCornerElements(matrix);
//        for (int i = 0; i < cornerElements.length; i++) {
//            System.out.println(cornerElements[i]);
//        }
//        int[] ne = Matrix2D.getNeighbourElements(matrix,1,1);
//        for (int i = 0; i < ne.length; i++) {
//            int i1 = ne[i];
//            if(i1!=-1)
//            System.out.println(i1);
//        }
//
//        System.out.println(pm.getWordCount("    Hello    world   "));
//        long[] fibnum = pm.fibGen(33, 0, 1);
//        for (int i = 0; i < fibnum.length; i++) {
//            System.out.println(fibnum[i]);
//        }
//        System.out.println(pm.isNumberBelongToFibonacciSeries(4123));
//        ArrayList<Integer> num = (ArrayList<Integer>) pm.removeDuplicateElement(Arrays.asList(new Integer[]{
//                1,1,2,3
//        }));
//        for (int i = 0; i < num.size(); i++) {
//            System.out.println(num.get(i));
//        }
//        int[] r = pm.survivalCells(new int[]{6, 6, 2, 3, 3, 3,3}, new int[]{0, 0, 0, 0, 0, 0,
//                0, 1, 0, 0, 0, 0,
//                0, 1, 1, 0, 1, 1,
//                0, 0, 0, 1, 1, 1,
//                0, 0, 0, 0, 0, 1,
//                0, 0, 0, 0, 0, 1});
//        for (int i = 0; i < r.length; i++) {
//            int i1 = r[i];
//            System.out.println(i1);
//
//        }
//      pm.generateNumbers(1001).forEach(System.out::println);
//
//        final long[] count = new long[]{0};
//        System.out.println((pm.isDivisibleBy(3, 1000).sum())
//                + (pm.isDivisibleBy(5, 1000).sum())
//                - (pm.isDivisibleBy(15, 1000).sum()));
//
//
//        System.out.println(pm.sumOfAllMultiplesOfXORY(3,5,1000));
//        pm.createFile("hello.txt","/Users/leo/projects/allprojects/", "Hello world!");
//        ParkingSpace space = new ParkingSpace(new int[]{1,4,4,6});
//        System.out.println(space.getAllSquareBlocks());
        //pm.stringToCharDemo("Hello world")
        pm.checkTheFirstCharPresent("ad");
    }
}
