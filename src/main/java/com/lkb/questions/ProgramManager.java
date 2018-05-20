package com.lkb.questions;

import com.sun.xml.internal.xsom.impl.scd.Iterators;

import java.util.Arrays;

public class ProgramManager {
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
     * @param height
     */
    public void printStarPyramid(int height) {
        int maxHeight = 10;
        int rowCount = 1;
        if (height > maxHeight) {
            System.out.println("Max height is "+ maxHeight+" supported!");
            return;
        }
        // do if height is 6 or less than 6
        for (int i = height; i > 0; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= rowCount; k++) {
                System.out.print("* ");
            }
            System.out.println();
            rowCount++;

        }
    }
}
