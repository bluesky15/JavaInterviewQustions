package com.lkb.questions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ProgramManagerTest {
    private ProgramManager pm;

    @BeforeEach
    void setUp() {
        pm = ProgramManager.getInstance();
    }

    @AfterEach
    void tearDown() {
        pm = null;
    }


    @DisplayName(" Test both arrays are same or not")
    @Test
    void isArraysEqual() {
        String[] array1 = new String[]{"1", "2", "3"};
        String[] array2 = new String[]{"1", "2", "3", "4"};
        String[] array3 = new String[]{"1", "2", "3"};
        assertEquals(false, pm.isArraysEqual(array1, array2));
        assertEquals(true, pm.isArraysEqual(array1, array3));
    }

    @Test
    @DisplayName("Test for is the number binary!")
    void binaryNumberCheck() {
        String number = "101016010";
        String number2 = "1000101110";
        assertEquals(false, pm.isNumberBinary(number));
        assertEquals(true, pm.isNumberBinary(number2));
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

    @Test
    @DisplayName("Test for harshad or Niven number")
    void testIsHarshadOrNivenNumber() {
        assertEquals(true, pm.isHarshadOrNivenNumber(153));
        assertEquals(true, pm.isHarshadOrNivenNumber(21));
        assertEquals(false, pm.isHarshadOrNivenNumber(71));

    }

    @Test
    @DisplayName("Test for isprime method")
    void testIsPrimeNumber() {
        assertEquals(true, pm.isPrime(2));
        assertEquals(true, pm.isPrime(3));
        assertEquals(false, pm.isPrime(4));
        assertEquals(false, pm.isPrime(-1));
        assertEquals(false, pm.isPrime(1));
        assertEquals(false, pm.isPrime(0));
        assertEquals(false, pm.isPrime(-1100));
        assertEquals(true, pm.isPrime(13));


    }

    @Test
    @DisplayName(" Test for isPalindrome number")
    void testIsPalindromeNumber() {
        assertEquals(true, pm.isPalindrome(121));
        assertEquals(false, pm.isPalindrome(1214));
        assertEquals(true, pm.isPalindrome(12321));
        assertEquals(true, pm.isPalindrome(123454321));
    }

    @Test
    @DisplayName("Test for sort all charecter of string")
    void testSortAllCharecterOfString() {
        assertEquals("abc", pm.sortAllCharacterOfString("cba"));
    }

    @Test
    @DisplayName("Test for second largest number in an array")
    void testSecondLargestNumberInArray() {
        assertEquals(4, pm.secondLargestNumberInArray(new int[]{1, 2, 3, 4, 5}));
        assertEquals(4, pm.secondLargestNumberInArray(new int[]{4, 2, 1, 3, 5}));
        assertEquals(4, pm.secondLargestNumberInArray(new int[]{1, 2, 3, 5, 4}));
    }

    @Test
    @DisplayName("Test for Max repeating char in string")
    void testgetMaxReapeatingChInString(){
        assertEquals('a',pm.getMaxRepeatCharCountInString("aabbaaccaa"));
        assertEquals('a',pm.getMaxRepeatCharCountInString("abc"));
    }

    @Test
    @DisplayName("Test for Number count in an array")
    void testGetNumberCuntInArray(){
        HashMap<Integer,Integer> hmExpected = new HashMap<>();
        hmExpected.put(1,2);
        hmExpected.put(2,4);
        assertEquals(hmExpected,pm.getNumberCuntInArray(new int[] {1,1,2,2,2,2}));
    }

    @Test
    @DisplayName("Test for checkTheFirstCharPresent array")
    void testCheckTheFirstCharPresent(){
        assertEquals(false,pm.checkTheFirstCharPresent("SS"));
        assertEquals(true,pm.checkTheFirstCharPresent("as"));
    }
}