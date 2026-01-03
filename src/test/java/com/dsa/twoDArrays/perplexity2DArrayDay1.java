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
}
