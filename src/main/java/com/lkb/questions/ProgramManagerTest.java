package com.lkb.questions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

    @Test
    void isArraysEqual() {
    boolean result = pm.isArraysEqual();
    }
}