package com.lkb.questions;

/**
 * Two dimensional integer matrix.
 */
public class Matrix2D {
    private int row;
    private int col;
    private int[][] elements;

    public Matrix2D() {
        this.row = 2;
        this.col = 2;
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = 0;
            }
        }
        this.elements = matrix;
    }

    public Matrix2D(int row, int col) {
        this.row = row;
        this.col = col;
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = 0;
            }
        }
        this.elements = matrix;
    }

    public Matrix2D(int row, int col, int[][] elements) {
        this.row = row;
        this.col = col;
        this.elements = elements;
    }

    public Matrix2D(int row, int col, int[] elements) {
        this.row = row;
        this.col = col;
        int[][] matrix = new int[row][col];
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = elements[count];
                count++;
            }
        }
        this.elements = matrix;
    }


    public int getRowCount() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColCount() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int[][] getMatrix() {
        return elements;
    }

    public void setMatrix(int[][] elements) {
        row = elements.length;
        col = elements[0].length;
        this.elements = elements;
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                str = str + elements[i][j] + " ";
            }
            str = str + "\n";
        }
        return str;
    }

    /**
     * In a matrix always only 4 corner elements will be available
     * (0,0), (row,col),(0,col),(row,0)
     *
     * @param matrix
     * @return
     */
    public static int[] getCornerElements(Matrix2D matrix) {
        int[][] matrixElements = matrix.getMatrix();
        int row = matrix.getRowCount();
        int col = matrix.getColCount();
        int[] cornerElements = new int[]{matrixElements[0][0],
                matrixElements[0][col - 1],
                matrixElements[row - 1][0],
                matrixElements[row - 1][col - 1]};
        return cornerElements;
    }

    /**
     * Always max neighbour will be 8
     * so if the element is (i,j)
     * then neighbour elements are-
     * (i-1,j-1),(i-1,j),(i-1,j+1),(i,j-1),(i,j+1),(i+1,j-1),(i+1,j),(i+1,j+1)
     *
     * @param matrix
     * @param index_i
     * @param index_j
     * @return
     */
    public int[] getNeighbourElements(Matrix2D matrix, int index_i, int index_j) {
        int count = 0;
        int count2 = 0;
        int[] neighbourElements = new int[]{-1, -1, -1, -1, -1, -1, -1, -1};
        int[] neighbourIndexList = new int[]{
                index_i - 1, index_j - 1,
                index_i - 1, index_j,
                index_i - 1, index_j + 1,
                index_i, index_j - 1,
                index_i, index_j + 1,
                index_i + 1, index_j - 1,
                index_i + 1, index_j,
                index_i + 1, index_j + 1,
        };
        for (int i = 0; i < (neighbourIndexList.length / 2); i++) {
            if ((neighbourIndexList[count] >= 0 && neighbourIndexList[count + 1] >= 0) && (neighbourIndexList[count] < row && neighbourIndexList[count+1] < col)) {
                int x = neighbourIndexList[count++];
                int y = neighbourIndexList[count++];
                neighbourElements[count2] = matrix.getMatrix()[x][y];
                count2++;
            } else count = count + 2;
        }
        return neighbourElements;
    }

//    public static int[] implementSurvivingRule(Matrix2D matrix, int index_i, int index_j, int s1, int s2, int b1, int b2, int filedValue) {
//        int count = 0;
//        int count2 = 0;
//        int[] neighbourElements = new int[]{-1, -1, -1, -1, -1, -1, -1, -1};
//        int[] neighbourIndexList = new int[]{
//                index_i - 1, index_j - 1,
//                index_i - 1, index_j,
//                index_i - 1, index_j + 1,
//                index_i, index_j - 1,
//                index_i, index_j + 1,
//                index_i + 1, index_j - 1,
//                index_i + 1, index_j,
//                index_i + 1, index_j + 1,
//        };
//        for (int i = 0; i < (neighbourIndexList.length / 2); i++) {
//            if (neighbourIndexList[count] >= 0 && neighbourIndexList[count + 1] >= 0) {
//                int x = neighbourIndexList[count++];
//                int y = neighbourIndexList[count++];
//                if (matrix.getMatrix()[x][y] == filedValue) {
//                    neighbourElements[count2] = matrix.getMatrix()[x][y];
//                    count2++;
//                }
//
//            } else count = count + 2;
//        }
//        return neighbourElements;
//    }

    public int getMatrixIndexValue(int indexI, int indexJ) {
        int matrixElement = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == indexI && j == indexJ)
                    matrixElement = elements[indexI][indexJ];
            }

        }
        return matrixElement;
    }

    public void setMatrixIndexValue(int indexI, int indexJ, int value) {
        int matrixElement = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == indexI && j == indexJ)
                    elements[indexI][indexJ] = value;
            }

        }
    }

    public int[] getMatrixElements() {
        int[] ele = new int[row * col];
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ele[count] = elements[i][j];
                count++;

            }

        }
        return ele;
    }
}
