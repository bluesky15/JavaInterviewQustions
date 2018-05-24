package com.lkb.questions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ProgramManagerTest {
    private ProgramManager pm;

    @BeforeEach
    void setUp() {
        pm = new ProgramManager();
    }

    @AfterEach
    void tearDown() {
        pm = null;
    }

    //    @Test
//    void naturalSort() {
//    }
//
//    @Test
//    void printStarPyramid() {
//    }
//
//    @Test
//    void printNumberPyramid() {
//    }
//
//    @Test
//    void isItANumber() {
//    }
//
//    @Test
//    void launchApplication() {
//    }
//
//    @Test
//    void revString() {
//    }
//
//    @Test
//    void findDuplicateString() {
//    }
//
//    @Test
//    void findDuplicateString2() {
//    }
//
//    @Test
//    void readJsonArray() {
//    }
//
//    @Test
//    void removeSpaces() {
//    }
//
//    @Test
//    void findCommonElement() {
//    }
//
//    @Test
//    void findCommonElement2() {
//    }
    @DisplayName(" Test both arrays are same or not")
    @Test
    void isArraysEqual() {
        String[] array1 = new String[]{"1", "2", "3"};
        String[] array2 = new String[]{"1", "2", "3", "4"};
        String[] array3 = new String[]{"1", "2", "3"};
        assertEquals(pm.isArraysEqual(array1, array2), false);
        assertEquals(pm.isArraysEqual(array1, array3), true);
    }

    @Test
    @DisplayName("is the number binary!")
    void binaryNumberCheck() {
        String number = "101016010";
        String number2 = "1000101110";
        assertEquals(pm.isNumberBinary(number), false);
        assertEquals(pm.isNumberBinary(number2), true);
    }

    @Test
    @DisplayName("Test the method isArmstrongNumber")
    void testIsArmstrongNumber() {
        assertEquals(false, pm.isArmstrongNumber("111"));
        assertEquals(true, pm.isArmstrongNumber("153"));
        assertEquals(true, pm.isArmstrongNumber("371"));
        assertEquals(true, pm.isArmstrongNumber("54748"));
        assertEquals(false, pm.isArmstrongNumber("1674"));
        assertEquals(true, pm.isArmstrongNumber("9474"));
    }

    @Test
    @DisplayName("Test for the isAnagram method")
    void testIsAnagram() {
        assertEquals(true, pm.isAnagram("Astronomers", "No more stars"));
        assertEquals(true, pm.isAnagram("Mother In Law", "Hitler Woman"));
        assertEquals(true, pm.isAnagram("SiLeNt CAT", "LisTen AcT"));
        assertEquals(false, pm.isAnagram("Toss", "Shot"));
    }

    @Test
    @DisplayName("Test for the replaceAllVowels")
    void testReplaceAllVowels() {
        assertEquals("strnmrs", pm.replaceAllVowels("Astronomers"));
        assertEquals("Mthr n Lw", pm.replaceAllVowels("Mother In Law"));
        assertEquals("SLNt CT", pm.replaceAllVowels("SiLeNt CAT"));
        assertEquals("Tss", pm.replaceAllVowels("Toss"));
        assertEquals("", pm.replaceAllVowels("AEIOUaeiou"));
    }

    @Test
    @DisplayName("Test for the array reverse")
    void testRevIntArray() {
        assertEquals(true, Arrays.equals(pm.revIntArray(new int[]{1, 3, 5, 6, 4}), new int[]{4, 6, 5, 3, 1}));
        assertEquals(false, Arrays.equals(pm.revIntArray(new int[]{1, 3, 5, 10, 4}), new int[]{1, 3, 5, 10, 4}));
    }
}