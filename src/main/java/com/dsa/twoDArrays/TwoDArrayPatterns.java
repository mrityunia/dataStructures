package com.dsa.twoDArrays;

/**
 * Common 2D Array Problem Patterns and Traversal Techniques
 * This class covers various traversal patterns and common problem-solving approaches
 */
public class TwoDArrayPatterns {
    
    /**
     * Spiral Traversal - Print elements in spiral order
     * Starting from top-left, going right, then down, then left, then up
     */
    public static void spiralTraversal(int[][] arr) {
        if (arr == null || arr.length == 0) return;
        
        int rows = arr.length;
        int cols = arr[0].length;
        int top = 0, bottom = rows - 1;
        int left = 0, right = cols - 1;
        
        while (top <= bottom && left <= right) {
            // Print top row (left to right)
            for (int j = left; j <= right; j++) {
                System.out.print(arr[top][j] + " ");
            }
            top++;
            
            // Print right column (top to bottom)
            for (int i = top; i <= bottom; i++) {
                System.out.print(arr[i][right] + " ");
            }
            right--;
            
            // Print bottom row (right to left)
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    System.out.print(arr[bottom][j] + " ");
                }
                bottom--;
            }
            
            // Print left column (bottom to top)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    System.out.print(arr[i][left] + " ");
                }
                left++;
            }
        }
        System.out.println();
    }
    
    /**
     * Zigzag Traversal - Print elements in zigzag pattern
     * First row left to right, second row right to left, and so on
     */
    public static void zigzagTraversal(int[][] arr) {
        if (arr == null || arr.length == 0) return;
        
        int rows = arr.length;
        int cols = arr[0].length;
        
        for (int i = 0; i < rows; i++) {
            if (i % 2 == 0) {
                // Left to right
                for (int j = 0; j < cols; j++) {
                    System.out.print(arr[i][j] + " ");
                }
            } else {
                // Right to left
                for (int j = cols - 1; j >= 0; j--) {
                    System.out.print(arr[i][j] + " ");
                }
            }
        }
        System.out.println();
    }
    
    /**
     * Boundary Traversal - Print only the boundary elements
     * Top row, right column, bottom row, left column
     */
    public static void boundaryTraversal(int[][] arr) {
        if (arr == null || arr.length == 0) return;
        
        int rows = arr.length;
        int cols = arr[0].length;
        
        // Print top row
        for (int j = 0; j < cols; j++) {
            System.out.print(arr[0][j] + " ");
        }
        
        // Print right column (excluding first and last elements)
        for (int i = 1; i < rows - 1; i++) {
            System.out.print(arr[i][cols - 1] + " ");
        }
        
        // Print bottom row (if more than one row)
        if (rows > 1) {
            for (int j = cols - 1; j >= 0; j--) {
                System.out.print(arr[rows - 1][j] + " ");
            }
        }
        
        // Print left column (excluding first and last elements)
        if (cols > 1) {
            for (int i = rows - 2; i > 0; i--) {
                System.out.print(arr[i][0] + " ");
            }
        }
        System.out.println();
    }
    
    /**
     * Diagonal Traversal - Print elements diagonally
     * Starting from top-left corner
     */
    public static void diagonalTraversal(int[][] arr) {
        if (arr == null || arr.length == 0) return;
        
        int rows = arr.length;
        int cols = arr[0].length;
        
        // Print diagonals starting from first row
        for (int k = 0; k < rows; k++) {
            int i = k;
            int j = 0;
            while (i >= 0 && j < cols) {
                System.out.print(arr[i][j] + " ");
                i--;
                j++;
            }
            System.out.println();
        }
        
        // Print diagonals starting from last column
        for (int k = 1; k < cols; k++) {
            int i = rows - 1;
            int j = k;
            while (i >= 0 && j < cols) {
                System.out.print(arr[i][j] + " ");
                i--;
                j++;
            }
            System.out.println();
        }
    }
    
    /**
     * Wave Traversal - Print elements in wave pattern
     * First column top to bottom, second column bottom to top, and so on
     */
    public static void waveTraversal(int[][] arr) {
        if (arr == null || arr.length == 0) return;
        
        int rows = arr.length;
        int cols = arr[0].length;
        
        for (int j = 0; j < cols; j++) {
            if (j % 2 == 0) {
                // Top to bottom
                for (int i = 0; i < rows; i++) {
                    System.out.print(arr[i][j] + " ");
                }
            } else {
                // Bottom to top
                for (int i = rows - 1; i >= 0; i--) {
                    System.out.print(arr[i][j] + " ");
                }
            }
        }
        System.out.println();
    }
    
    /**
     * Print elements in a specific pattern (hourglass shape)
     * Useful for matrix pattern problems
     */
    public static void printHourglassPattern(int[][] arr) {
        if (arr == null || arr.length < 3) return;
        
        int rows = arr.length;
        int cols = arr[0].length;
        
        for (int i = 0; i <= rows - 3; i++) {
            for (int j = 0; j <= cols - 3; j++) {
                System.out.println("Hourglass starting at (" + i + "," + j + "):");
                
                // Print top row
                System.out.println(" " + arr[i][j] + " " + arr[i][j+1] + " " + arr[i][j+2]);
                
                // Print middle element
                System.out.println("   " + arr[i+1][j+1]);
                
                // Print bottom row
                System.out.println(" " + arr[i+2][j] + " " + arr[i+2][j+1] + " " + arr[i+2][j+2]);
                System.out.println();
            }
        }
    }
    
    /**
     * Print elements in a cross pattern
     * Main diagonal and anti-diagonal
     */
    public static void printCrossPattern(int[][] arr) {
        if (arr == null || !TwoDArrayBasics.isSquareMatrix(arr)) return;
        
        int n = arr.length;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || i + j == n - 1) {
                    System.out.print(arr[i][j] + " ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
    
    /**
     * Print elements in a plus pattern
     * Middle row and middle column
     */
    public static void printPlusPattern(int[][] arr) {
        if (arr == null || !TwoDArrayBasics.isSquareMatrix(arr)) return;
        
        int n = arr.length;
        int mid = n / 2;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == mid || j == mid) {
                    System.out.print(arr[i][j] + " ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
    
    /**
     * Print elements in a diamond pattern
     * Diamond shape using the matrix
     */
    public static void printDiamondPattern(int[][] arr) {
        if (arr == null || !TwoDArrayBasics.isSquareMatrix(arr)) return;
        
        int n = arr.length;
        int mid = n / 2;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int distance = Math.abs(i - mid) + Math.abs(j - mid);
                if (distance <= mid) {
                    System.out.print(arr[i][j] + " ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
    
    /**
     * Print elements in a butterfly pattern
     * Upper and lower triangular parts
     */
    public static void printButterflyPattern(int[][] arr) {
        if (arr == null || !TwoDArrayBasics.isSquareMatrix(arr)) return;
        
        int n = arr.length;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j <= i || j >= n - 1 - i) {
                    System.out.print(arr[i][j] + " ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
