package com.dsa.twoDArrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class perplexity2DArrayDay1 {


    public static void printMatrixInSpiralOrder() {
        int[][] matrix = {
                {1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18},
                {19, 20, 21, 22, 23, 24},
                {25, 26, 27, 28, 29, 30}
        };
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            // 1️⃣ Top row
            for (int col = left; col <= right; col++)
                System.out.print(matrix[top][col] + " ");
            top++;
            // 2️⃣ Right column
            for (int row = top; row <= bottom; row++)
                System.out.print(matrix[row][right] + " ");
            right--;

            // 3️⃣ Bottom row (ONLY if rows remain)
            if (top <= bottom) {
                for (int col = right; col >= left; col--) {
                    System.out.print(matrix[bottom][col] + " ");
                }
                bottom--;
            }
            // 4️⃣ Left column (ONLY if columns remain)
            if (left <= right) {
                for (int row = bottom; row >= top; row--)
                    System.out.print(matrix[row][left] + " ");
                left++;
            }
        }
    }


    public static void main(String[] args) {
        SetMatrixZeroes();
    }

    public static void SetMatrixZeroes() {
        int[][] array =
                {{1, 2, 3},
                        {4, 0, 6},
                        {7, 8, 9}};
        // find row and cols
        int rows = array.length;
        int cols = array[0].length;

        // Step 0: copy original array to output
        int[][] arrayOutput2 = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arrayOutput2[i][j] = array[i][j];
            }
        }
        // find the zero rows and cols
        for (int i = 0; i < rows; i++) {
            int foundColumn =-1;
            boolean isZeroPresent = false;
            for (int j = 0; j < cols; j++) {
                if (array[i][j] == 0) {
                    isZeroPresent = true;
                    foundColumn = j;
                    break;
                }

            }
            // 1,2 => make all 1 and make 2 columns zero
            if (isZeroPresent) {
                // zero entire row
                for (int j = 0; j < cols; j++) {
                    arrayOutput2[i][j] = 0;
                }

                // zero entire column
                for (int r = 0; r < rows; r++) {
                    arrayOutput2[r][foundColumn] = 0;
                }
            }

        }
        Arrays.stream(arrayOutput2)
                .flatMapToInt(Arrays::stream)
                .forEach(a -> System.out.printf("%d ", a));

    }

    public static void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean firstRowZero = false;
        boolean firstColZero = false;

        // Check first row
        for (int j = 0; j < cols; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // Check first column
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        // Mark rows and columns
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Set zeroes based on markers
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Update first row
        if (firstRowZero) {
            for (int j = 0; j < cols; j++) {
                matrix[0][j] = 0;
            }
        }

        // Update first column
        if (firstColZero) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
    }
//[
//  [1, 2, 3],
//  [4, 0, 6],
//  [7, 8, 9]
//]



    public static void setSquareMatrixZero() {
        int[][] inputArray =
                {{1, 0, 3},
                        {4, 2, 6},
                        {7, 8, 9}};
        int row = inputArray.length;
        int rowCol = inputArray[0].length;

        // find the zeros and mark the corresponding first row and colum as zero
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < rowCol; j++) {
                if (inputArray[i][j] == 0) {
                    inputArray[i][0] = 0;
                    inputArray[0][j] = 0;
                }
            }
        }
//[
//  [1, 0, 3],
//  [0, 0, 0],
//  [7, 0, 9]
//]

        // check the first row and column which positions as = zero then make the remaining corresponding rows and column as zero
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < rowCol; j++) {
                if (inputArray[i][0] == 0 || inputArray[0][j] == 0) {
                    inputArray[i][j] = 0;
                }

            }
        }

        //[
//  [1, 0, 3],
//  [4, 2, 6],
//  [7, 8, 9]
//]
        // check  if the first row is zero
        boolean isFirstRowZero = false;
        for (int i = 0; i < row; i++) {
            if (inputArray[0][i] == 0){
                isFirstRowZero = true;
                break;
            }
        }
        boolean isFirstColumnZero = false;
        for (int i = 0; i < rowCol; i++) {
            if (inputArray[i][0] == 0) {
                isFirstColumnZero = true;
                break;
            }
        }

        // update the row
        if (isFirstRowZero) {
            for (int j = 0; j< rowCol; j++) {
                inputArray[0][j] =0;
            }
        }
        // update the cols
        if (isFirstColumnZero) {
            for (int i = 0; i < row; i++) {
                inputArray[i][0] = 0;
            }
        }

    }
}
