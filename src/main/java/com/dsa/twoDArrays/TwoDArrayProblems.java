package com.dsa.twoDArrays;

/**
 * Common 2D Array Problem-Solving Algorithms
 * This class covers various algorithms and techniques for solving 2D array problems
 */
public class TwoDArrayProblems {
    
    /**
     * Search for an element in a sorted 2D array (row-wise and column-wise sorted)
     * Time Complexity: O(m + n) where m = rows, n = columns
     */
    public static int[] searchInSorted2DArray(int[][] arr, int target) {
        if (arr == null || arr.length == 0) return null;
        
        int rows = arr.length;
        int cols = arr[0].length;
        int i = 0, j = cols - 1; // Start from top-right corner
        
        while (i < rows && j >= 0) {
            if (arr[i][j] == target) {
                return new int[]{i, j};
            } else if (arr[i][j] > target) {
                j--; // Move left
            } else {
                i++; // Move down
            }
        }
        return null; // Element not found
    }
    
    /**
     * Find the maximum sum of a 2x2 submatrix
     */
    public static int maxSum2x2Submatrix(int[][] arr) {
        if (arr == null || arr.length < 2 || arr[0].length < 2) return -1;
        
        int rows = arr.length;
        int cols = arr[0].length;
        int maxSum = Integer.MIN_VALUE;
        
        for (int i = 0; i <= rows - 2; i++) {
            for (int j = 0; j <= cols - 2; j++) {
                int sum = arr[i][j] + arr[i][j+1] + 
                         arr[i+1][j] + arr[i+1][j+1];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
    
    /**
     * Find the maximum sum of a 3x3 submatrix (hourglass)
     */
    public static int maxSum3x3Submatrix(int[][] arr) {
        if (arr == null || arr.length < 3 || arr[0].length < 3) return -1;
        
        int rows = arr.length;
        int cols = arr[0].length;
        int maxSum = Integer.MIN_VALUE;
        
        for (int i = 0; i <= rows - 3; i++) {
            for (int j = 0; j <= cols - 3; j++) {
                int sum = arr[i][j] + arr[i][j+1] + arr[i][j+2] +
                         arr[i+1][j+1] +
                         arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
    
    /**
     * Check if a 2D array is a magic square
     * Magic square: sum of each row, column, and diagonal is equal
     */
    public static boolean isMagicSquare(int[][] arr) {
        if (arr == null || !TwoDArrayBasics.isSquareMatrix(arr)) return false;
        
        int n = arr.length;
        int magicSum = n * (n * n + 1) / 2; // Formula for magic sum
        
        // Check rows
        for (int i = 0; i < n; i++) {
            if (TwoDArrayBasics.sumOfRow(arr, i) != magicSum) {
                return false;
            }
        }
        
        // Check columns
        for (int j = 0; j < n; j++) {
            if (TwoDArrayBasics.sumOfColumn(arr, j) != magicSum) {
                return false;
            }
        }
        
        // Check main diagonal
        if (TwoDArrayBasics.sumOfMainDiagonal(arr) != magicSum) {
            return false;
        }
        
        // Check anti-diagonal
        if (TwoDArrayBasics.sumOfAntiDiagonal(arr) != magicSum) {
            return false;
        }
        
        return true;
    }
    
    /**
     * Find the saddle point in a 2D array
     * Saddle point: minimum in its row and maximum in its column
     */
    public static int[] findSaddlePoint(int[][] arr) {
        if (arr == null || arr.length == 0) return null;
        
        int rows = arr.length;
        int cols = arr[0].length;
        
        for (int i = 0; i < rows; i++) {
            // Find minimum in current row
            int minInRow = arr[i][0];
            int minColIndex = 0;
            
            for (int j = 1; j < cols; j++) {
                if (arr[i][j] < minInRow) {
                    minInRow = arr[i][j];
                    minColIndex = j;
                }
            }
            
            // Check if this minimum is maximum in its column
            boolean isMaxInCol = true;
            for (int k = 0; k < rows; k++) {
                if (arr[k][minColIndex] > minInRow) {
                    isMaxInCol = false;
                    break;
                }
            }
            
            if (isMaxInCol) {
                return new int[]{i, minColIndex};
            }
        }
        return null; // No saddle point found
    }
    
    /**
     * Check if a 2D array is a Toeplitz matrix
     * Toeplitz: all diagonals have the same elements
     */
    public static boolean isToeplitzMatrix(int[][] arr) {
        if (arr == null || arr.length == 0) return false;
        
        int rows = arr.length;
        int cols = arr[0].length;
        
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (arr[i][j] != arr[i-1][j-1]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * Find the number of islands in a 2D array (1 represents land, 0 represents water)
     * Islands are connected horizontally and vertically
     */
    public static int numberOfIslands(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    count++;
                    dfsMarkIsland(grid, i, j, rows, cols);
                }
            }
        }
        return count;
    }
    
    private static void dfsMarkIsland(int[][] grid, int i, int j, int rows, int cols) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] == 0) {
            return;
        }
        
        grid[i][j] = 0; // Mark as visited
        
        // Check all 4 directions
        dfsMarkIsland(grid, i+1, j, rows, cols); // Down
        dfsMarkIsland(grid, i-1, j, rows, cols); // Up
        dfsMarkIsland(grid, i, j+1, rows, cols); // Right
        dfsMarkIsland(grid, i, j-1, rows, cols); // Left
    }
    
    /**
     * Find the maximum area of an island in a 2D array
     */
    public static int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        
        int rows = grid.length;
        int cols = grid[0].length;
        int maxArea = 0;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfsGetArea(grid, i, j, rows, cols));
                }
            }
        }
        return maxArea;
    }
    
    private static int dfsGetArea(int[][] grid, int i, int j, int rows, int cols) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] == 0) {
            return 0;
        }
        
        grid[i][j] = 0; // Mark as visited
        
        return 1 + dfsGetArea(grid, i+1, j, rows, cols) + // Down
                   dfsGetArea(grid, i-1, j, rows, cols) + // Up
                   dfsGetArea(grid, i, j+1, rows, cols) + // Right
                   dfsGetArea(grid, i, j-1, rows, cols);  // Left
    }
    
    /**
     * Check if a 2D array is a valid Sudoku board
     * Valid Sudoku: no duplicates in rows, columns, and 3x3 boxes
     */
    public static boolean isValidSudoku(int[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) return false;
        
        // Check rows
        for (int i = 0; i < 9; i++) {
            if (!isValidSet(board[i])) return false;
        }
        
        // Check columns
        for (int j = 0; j < 9; j++) {
            int[] col = new int[9];
            for (int i = 0; i < 9; i++) {
                col[i] = board[i][j];
            }
            if (!isValidSet(col)) return false;
        }
        
        // Check 3x3 boxes
        for (int box = 0; box < 9; box++) {
            int[] boxArray = new int[9];
            int startRow = (box / 3) * 3;
            int startCol = (box % 3) * 3;
            int index = 0;
            
            for (int i = startRow; i < startRow + 3; i++) {
                for (int j = startCol; j < startCol + 3; j++) {
                    boxArray[index++] = board[i][j];
                }
            }
            if (!isValidSet(boxArray)) return false;
        }
        
        return true;
    }
    
    private static boolean isValidSet(int[] arr) {
        boolean[] seen = new boolean[10];
        for (int num : arr) {
            if (num != 0 && seen[num]) {
                return false;
            }
            if (num != 0) {
                seen[num] = true;
            }
        }
        return true;
    }
    
    /**
     * Find the longest increasing path in a 2D array
     * Path can go in any of the 4 directions
     */
    public static int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        int maxLength = 0;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maxLength = Math.max(maxLength, dfsLongestPath(matrix, i, j, dp, rows, cols));
            }
        }
        return maxLength;
    }
    
    private static int dfsLongestPath(int[][] matrix, int i, int j, int[][] dp, int rows, int cols) {
        if (dp[i][j] != 0) return dp[i][j];
        
        int maxLength = 1;
        int current = matrix[i][j];
        
        // Check all 4 directions
        if (i > 0 && matrix[i-1][j] > current) {
            maxLength = Math.max(maxLength, 1 + dfsLongestPath(matrix, i-1, j, dp, rows, cols));
        }
        if (i < rows-1 && matrix[i+1][j] > current) {
            maxLength = Math.max(maxLength, 1 + dfsLongestPath(matrix, i+1, j, dp, rows, cols));
        }
        if (j > 0 && matrix[i][j-1] > current) {
            maxLength = Math.max(maxLength, 1 + dfsLongestPath(matrix, i, j-1, dp, rows, cols));
        }
        if (j < cols-1 && matrix[i][j+1] > current) {
            maxLength = Math.max(maxLength, 1 + dfsLongestPath(matrix, i, j+1, dp, rows, cols));
        }
        
        dp[i][j] = maxLength;
        return maxLength;
    }
}
