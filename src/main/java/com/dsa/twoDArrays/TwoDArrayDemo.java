package com.dsa.twoDArrays;

/**
 * Demo class to showcase all 2D array operations and problems
 * This class demonstrates how to use the various methods from the 2D array package
 */
public class TwoDArrayDemo {
    
    public static void main(String[] args) {
        System.out.println("=== 2D Array Basics Demo ===\n");
        
        // Create sample arrays
        int[][] sampleArray = TwoDArrayBasics.createSequentialArray(4, 4);
        int[][] sampleArray2 = TwoDArrayBasics.createSequentialArray(3, 5);
        
        System.out.println("Sample 4x4 Array:");
        TwoDArrayBasics.print2DArray(sampleArray);
        
        System.out.println("\nSample 3x5 Array:");
        TwoDArrayBasics.print2DArray(sampleArray2);
        
        // Basic operations
        System.out.println("\n=== Basic Operations ===");
        System.out.println("Sum of all elements: " + TwoDArrayBasics.sumOfElements(sampleArray));
        System.out.println("Maximum element: " + TwoDArrayBasics.findMax(sampleArray));
        System.out.println("Minimum element: " + TwoDArrayBasics.findMin(sampleArray));
        System.out.println("Sum of row 1: " + TwoDArrayBasics.sumOfRow(sampleArray, 1));
        System.out.println("Sum of column 2: " + TwoDArrayBasics.sumOfColumn(sampleArray, 2));
        System.out.println("Row with max sum: " + TwoDArrayBasics.findRowWithMaxSum(sampleArray));
        System.out.println("Column with max sum: " + TwoDArrayBasics.findColumnWithMaxSum(sampleArray));
        
        // Diagonal operations
        System.out.println("\n=== Diagonal Operations ===");
        System.out.println("Is square matrix: " + TwoDArrayBasics.isSquareMatrix(sampleArray));
        System.out.println("Main diagonal sum: " + TwoDArrayBasics.sumOfMainDiagonal(sampleArray));
        System.out.println("Anti-diagonal sum: " + TwoDArrayBasics.sumOfAntiDiagonal(sampleArray));
        
        int[] mainDiagonal = TwoDArrayBasics.getMainDiagonal(sampleArray);
        System.out.print("Main diagonal elements: ");
        for (int num : mainDiagonal) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        // Search operations
        System.out.println("\n=== Search Operations ===");
        System.out.println("Contains element 7: " + TwoDArrayBasics.containsElement(sampleArray, 7));
        System.out.println("Count of element 5: " + TwoDArrayBasics.countElement(sampleArray, 5));
        int[] position = TwoDArrayBasics.findElementPosition(sampleArray, 10);
        if (position != null) {
            System.out.println("Element 10 found at: (" + position[0] + ", " + position[1] + ")");
        }
        
        // Transpose and rotation
        System.out.println("\n=== Matrix Transformations ===");
        System.out.println("Transpose of 3x5 array:");
        int[][] transposed = TwoDArrayBasics.transpose(sampleArray2);
        TwoDArrayBasics.print2DArray(transposed);
        
        System.out.println("\n90-degree clockwise rotation of 4x4 array:");
        int[][] rotated = TwoDArrayBasics.rotate90DegreesClockwise(sampleArray);
        TwoDArrayBasics.print2DArray(rotated);
        
        // Array comparison
        System.out.println("\n=== Array Comparison ===");
        System.out.println("Are arrays equal: " + TwoDArrayBasics.areArraysEqual(sampleArray, sampleArray));
        
        System.out.println("\n=== 2D Array Patterns Demo ===\n");
        
        // Pattern demonstrations
        System.out.println("Spiral Traversal:");
        TwoDArrayPatterns.spiralTraversal(sampleArray);
        
        System.out.println("\nZigzag Traversal:");
        TwoDArrayPatterns.zigzagTraversal(sampleArray);
        
        System.out.println("\nBoundary Traversal:");
        TwoDArrayPatterns.boundaryTraversal(sampleArray);
        
        System.out.println("\nWave Traversal:");
        TwoDArrayPatterns.waveTraversal(sampleArray);
        
        System.out.println("\nDiagonal Traversal:");
        TwoDArrayPatterns.diagonalTraversal(sampleArray);
        
        System.out.println("\nCross Pattern:");
        TwoDArrayPatterns.printCrossPattern(sampleArray);
        
        System.out.println("\nPlus Pattern:");
        TwoDArrayPatterns.printPlusPattern(sampleArray);
        
        System.out.println("\nDiamond Pattern:");
        TwoDArrayPatterns.printDiamondPattern(sampleArray);
        
        System.out.println("\nButterfly Pattern:");
        TwoDArrayPatterns.printButterflyPattern(sampleArray);
        
        System.out.println("\nHourglass Pattern:");
        TwoDArrayPatterns.printHourglassPattern(sampleArray);
        
        System.out.println("\n=== 2D Array Problems Demo ===\n");
        
        // Problem demonstrations
        int[][] sortedArray = {
            {1, 4, 7, 11, 15},
            {2, 5, 8, 12, 19},
            {3, 6, 9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        };
        
        System.out.println("Sorted 2D Array:");
        TwoDArrayBasics.print2DArray(sortedArray);
        
        int[] searchResult = TwoDArrayProblems.searchInSorted2DArray(sortedArray, 9);
        if (searchResult != null) {
            System.out.println("Element 9 found at: (" + searchResult[0] + ", " + searchResult[1] + ")");
        }
        
        System.out.println("\nMaximum sum of 2x2 submatrix: " + TwoDArrayProblems.maxSum2x2Submatrix(sampleArray));
        System.out.println("Maximum sum of 3x3 submatrix: " + TwoDArrayProblems.maxSum3x3Submatrix(sampleArray));
        
        // Magic square example
        int[][] magicSquare = {
            {8, 1, 6},
            {3, 5, 7},
            {4, 9, 2}
        };
        
        System.out.println("\nMagic Square:");
        TwoDArrayBasics.print2DArray(magicSquare);
        System.out.println("Is magic square: " + TwoDArrayProblems.isMagicSquare(magicSquare));
        
        // Saddle point example
        int[][] saddleArray = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        System.out.println("\nSaddle Point Array:");
        TwoDArrayBasics.print2DArray(saddleArray);
        int[] saddlePoint = TwoDArrayProblems.findSaddlePoint(saddleArray);
        if (saddlePoint != null) {
            System.out.println("Saddle point found at: (" + saddlePoint[0] + ", " + saddlePoint[1] + ")");
        } else {
            System.out.println("No saddle point found");
        }
        
        // Toeplitz matrix example
        int[][] toeplitzArray = {
            {1, 2, 3, 4},
            {5, 1, 2, 3},
            {9, 5, 1, 2}
        };
        
        System.out.println("\nToeplitz Matrix:");
        TwoDArrayBasics.print2DArray(toeplitzArray);
        System.out.println("Is Toeplitz matrix: " + TwoDArrayProblems.isToeplitzMatrix(toeplitzArray));
        
        // Islands example
        int[][] islandGrid = {
            {1, 1, 0, 0, 0},
            {1, 1, 0, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 0, 1, 1}
        };
        
        System.out.println("\nIsland Grid:");
        TwoDArrayBasics.print2DArray(islandGrid);
        System.out.println("Number of islands: " + TwoDArrayProblems.numberOfIslands(islandGrid));
        
        // Longest increasing path example
        int[][] pathMatrix = {
            {9, 9, 4},
            {6, 6, 8},
            {2, 1, 1}
        };
        
        System.out.println("\nPath Matrix:");
        TwoDArrayBasics.print2DArray(pathMatrix);
        System.out.println("Longest increasing path length: " + TwoDArrayProblems.longestIncreasingPath(pathMatrix));
        
        System.out.println("\n=== Demo Complete ===");
    }
}
