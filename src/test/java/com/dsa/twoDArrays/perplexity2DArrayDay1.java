package com.dsa.twoDArrays;

public class perplexity2DArrayDay1 {


    public static void printMatrixInSpiralOrder() {
        int[][] matrix = {
                {  1,  2,  3,  4,  5,  6},
                {  7,  8,  9, 10, 11, 12},
                { 13, 14, 15, 16, 17, 18},
                { 19, 20, 21, 22, 23, 24},
                { 25, 26, 27, 28, 29, 30}
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


    public static void main (String [] args) {
        printMatrixInSpiralOrder();
    }
}
