package com.dsa.twoDArrays;

/**
 * Basic 2D Array Operations and Problems
 * This class covers fundamental concepts and operations on 2D arrays
 */
public class TwoDArrayBasics {
    
    /**
     * Print a 2D array in a formatted way
     */
    public static void print2DArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    /**
     * Create a 2D array with sequential numbers
     */
    public static int[][] createSequentialArray(int rows, int cols) {
        int[][] arr = new int[rows][cols];
        int count = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr[i][j] = count++;
            }
        }
        return arr;
    }
    
    /**
     * Find the sum of all elements in a 2D array
     */
    public static int sumOfElements(int[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                sum += arr[i][j];
            }
        }
        return sum;
    }
    
    /**
     * Find the maximum element in a 2D array
     */
    public static int findMax(int[][] arr) {
        int max = arr[0][0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                }
            }
        }
        return max;
    }
    
    /**
     * Find the minimum element in a 2D array
     */
    public static int findMin(int[][] arr) {
        int min = arr[0][0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] < min) {
                    min = arr[i][j];
                }
            }
        }
        return min;
    }
    
    /**
     * Calculate the sum of elements in a specific row
     */
    public static int sumOfRow(int[][] arr, int rowIndex) {
        if (rowIndex < 0 || rowIndex >= arr.length) {
            return -1; // Invalid row index
        }
        
        int sum = 0;
        for (int j = 0; j < arr[0].length; j++) {
            sum += arr[rowIndex][j];
        }
        return sum;
    }
    
    /**
     * Calculate the sum of elements in a specific column
     */
    public static int sumOfColumn(int[][] arr, int colIndex) {
        if (colIndex < 0 || colIndex >= arr[0].length) {
            return -1; // Invalid column index
        }
        
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i][colIndex];
        }
        return sum;
    }
    
    /**
     * Find the row with maximum sum
     */
    public static int findRowWithMaxSum(int[][] arr) {
        int maxSum = Integer.MIN_VALUE;
        int maxRowIndex = 0;
        
        for (int i = 0; i < arr.length; i++) {
            int rowSum = sumOfRow(arr, i);
            if (rowSum > maxSum) {
                maxSum = rowSum;
                maxRowIndex = i;
            }
        }
        return maxRowIndex;
    }
    
    /**
     * Find the column with maximum sum
     */
    public static int findColumnWithMaxSum(int[][] arr) {
        int maxSum = Integer.MIN_VALUE;
        int maxColIndex = 0;
        
        for (int j = 0; j < arr[0].length; j++) {
            int colSum = sumOfColumn(arr, j);
            if (colSum > maxSum) {
                maxSum = colSum;
                maxColIndex = j;
            }
        }
        return maxColIndex;
    }
    
    /**
     * Check if a 2D array is a square matrix (rows == columns)
     */
    public static boolean isSquareMatrix(int[][] arr) {
        return arr.length == arr[0].length;
    }
    
    /**
     * Get the diagonal elements (main diagonal)
     */
    public static int[] getMainDiagonal(int[][] arr) {
        if (!isSquareMatrix(arr)) {
            return null; // Not a square matrix
        }
        
        int[] diagonal = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            diagonal[i] = arr[i][i];
        }
        return diagonal;
    }
    
    /**
     * Get the anti-diagonal elements
     */
    public static int[] getAntiDiagonal(int[][] arr) {
        if (!isSquareMatrix(arr)) {
            return null; // Not a square matrix
        }
        
        int[] antiDiagonal = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            antiDiagonal[i] = arr[i][arr.length - 1 - i];
        }
        return antiDiagonal;
    }
    
    /**
     * Calculate the sum of main diagonal elements
     */
    public static int sumOfMainDiagonal(int[][] arr) {
        if (!isSquareMatrix(arr)) {
            return -1; // Not a square matrix
        }
        
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i][i];
        }
        return sum;
    }
    
    /**
     * Calculate the sum of anti-diagonal elements
     */
    public static int sumOfAntiDiagonal(int[][] arr) {
        if (!isSquareMatrix(arr)) {
            return -1; // Not a square matrix
        }
        
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i][arr.length - 1 - i];
        }
        return sum;
    }
    
    /**
     * Transpose a 2D array (swap rows and columns)
     */
    public static int[][] transpose(int[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;
        int[][] transpose = new int[cols][rows];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transpose[j][i] = arr[i][j];
            }
        }
        return transpose;
    }
    
    /**
     * Rotate a 2D array 90 degrees clockwise
     */
    public static int[][] rotate90DegreesClockwise(int[][] arr) {
        if (!isSquareMatrix(arr)) {
            return null; // Not a square matrix
        }
        
        int n = arr.length;
        int[][] rotated = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][n - 1 - i] = arr[i][j];
            }
        }
        return rotated;
    }
    
    /**
     * Check if two 2D arrays are equal
     */
    public static boolean areArraysEqual(int[][] arr1, int[][] arr2) {
        if (arr1.length != arr2.length || arr1[0].length != arr2[0].length) {
            return false;
        }
        
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[0].length; j++) {
                if (arr1[i][j] != arr2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * Count the frequency of a given element in a 2D array
     */
    public static int countElement(int[][] arr, int target) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == target) {
                    count++;
                }
            }
        }
        return count;
    }
    
    /**
     * Check if a 2D array contains a specific element
     */
    public static boolean containsElement(int[][] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * Find the position (row, col) of a given element
     * Returns int array [row, col] or null if not found
     */
    public static int[] findElementPosition(int[][] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null; // Element not found
    }
}
