# 2D Arrays Package

This package provides comprehensive tools and algorithms for working with 2D arrays (matrices) in Java. It covers basic operations, traversal patterns, and common problem-solving techniques.

## Package Structure

```
com.dsa.twoDArrays/
├── TwoDArrayBasics.java      # Basic operations and utilities
├── TwoDArrayPatterns.java    # Traversal patterns and visual patterns
├── TwoDArrayProblems.java    # Problem-solving algorithms
├── TwoDArrayDemo.java        # Demonstration and examples
└── README.md                 # This file
```

## Classes Overview

### 1. TwoDArrayBasics.java

**Basic Operations:**
- `print2DArray(int[][] arr)` - Print array in formatted way
- `createSequentialArray(int rows, int cols)` - Create array with sequential numbers
- `sumOfElements(int[][] arr)` - Calculate sum of all elements
- `findMax(int[][] arr)` - Find maximum element
- `findMin(int[][] arr)` - Find minimum element

**Row and Column Operations:**
- `sumOfRow(int[][] arr, int rowIndex)` - Sum of specific row
- `sumOfColumn(int[][] arr, int colIndex)` - Sum of specific column
- `findRowWithMaxSum(int[][] arr)` - Row with maximum sum
- `findColumnWithMaxSum(int[][] arr)` - Column with maximum sum

**Diagonal Operations:**
- `isSquareMatrix(int[][] arr)` - Check if array is square
- `getMainDiagonal(int[][] arr)` - Get main diagonal elements
- `getAntiDiagonal(int[][] arr)` - Get anti-diagonal elements
- `sumOfMainDiagonal(int[][] arr)` - Sum of main diagonal
- `sumOfAntiDiagonal(int[][] arr)` - Sum of anti-diagonal

**Matrix Transformations:**
- `transpose(int[][] arr)` - Transpose the matrix
- `rotate90DegreesClockwise(int[][] arr)` - Rotate 90° clockwise

**Search and Comparison:**
- `containsElement(int[][] arr, int target)` - Check if element exists
- `countElement(int[][] arr, int target)` - Count element frequency
- `findElementPosition(int[][] arr, int target)` - Find element position
- `areArraysEqual(int[][] arr1, int[][] arr2)` - Compare two arrays

### 2. TwoDArrayPatterns.java

**Traversal Patterns:**
- `spiralTraversal(int[][] arr)` - Spiral order traversal
- `zigzagTraversal(int[][] arr)` - Zigzag pattern traversal
- `boundaryTraversal(int[][] arr)` - Boundary elements only
- `diagonalTraversal(int[][] arr)` - Diagonal pattern traversal
- `waveTraversal(int[][] arr)` - Wave pattern traversal

**Visual Patterns:**
- `printHourglassPattern(int[][] arr)` - Hourglass shape pattern
- `printCrossPattern(int[][] arr)` - Cross pattern
- `printPlusPattern(int[][] arr)` - Plus pattern
- `printDiamondPattern(int[][] arr)` - Diamond pattern
- `printButterflyPattern(int[][] arr)` - Butterfly pattern

### 3. TwoDArrayProblems.java

**Search Algorithms:**
- `searchInSorted2DArray(int[][] arr, int target)` - Search in sorted matrix
- `findSaddlePoint(int[][] arr)` - Find saddle point

**Submatrix Problems:**
- `maxSum2x2Submatrix(int[][] arr)` - Maximum 2x2 submatrix sum
- `maxSum3x3Submatrix(int[][] arr)` - Maximum 3x3 submatrix sum

**Matrix Properties:**
- `isMagicSquare(int[][] arr)` - Check if magic square
- `isToeplitzMatrix(int[][] arr)` - Check if Toeplitz matrix
- `isValidSudoku(int[][] board)` - Validate Sudoku board

**Graph Problems:**
- `numberOfIslands(int[][] grid)` - Count connected islands
- `maxAreaOfIsland(int[][] grid)` - Find largest island area
- `longestIncreasingPath(int[][] matrix)` - Longest increasing path

### 4. TwoDArrayDemo.java

A comprehensive demonstration class that showcases all the functionality of the package with practical examples.

## Usage Examples

### Basic Operations
```java
// Create a 4x4 array with sequential numbers
int[][] arr = TwoDArrayBasics.createSequentialArray(4, 4);

// Print the array
TwoDArrayBasics.print2DArray(arr);

// Find sum of all elements
int sum = TwoDArrayBasics.sumOfElements(arr);

// Find maximum element
int max = TwoDArrayBasics.findMax(arr);
```

### Traversal Patterns
```java
// Spiral traversal
TwoDArrayPatterns.spiralTraversal(arr);

// Zigzag traversal
TwoDArrayPatterns.zigzagTraversal(arr);

// Boundary traversal
TwoDArrayPatterns.boundaryTraversal(arr);
```

### Problem Solving
```java
// Search in sorted 2D array
int[] position = TwoDArrayProblems.searchInSorted2DArray(sortedArr, target);

// Find maximum submatrix sum
int maxSum = TwoDArrayProblems.maxSum3x3Submatrix(arr);

// Check if magic square
boolean isMagic = TwoDArrayProblems.isMagicSquare(arr);
```

## Common Use Cases

1. **Matrix Operations**: Basic arithmetic, transformations, and manipulations
2. **Pattern Recognition**: Visual patterns, traversal algorithms
3. **Search Problems**: Finding elements, paths, and optimal solutions
4. **Game Development**: Sudoku validation, game board operations
5. **Image Processing**: Matrix transformations, pattern matching
6. **Graph Algorithms**: Island counting, path finding
7. **Competitive Programming**: Common 2D array problems and solutions

## Time Complexity

- **Basic Operations**: O(m×n) where m = rows, n = columns
- **Search in Sorted Array**: O(m + n)
- **Submatrix Sum**: O(m×n) for k×k submatrix
- **Pattern Traversal**: O(m×n)
- **Island Problems**: O(m×n) with DFS
- **Longest Path**: O(m×n) with memoization

## Space Complexity

- **Most Operations**: O(1) additional space
- **Transpose/Rotation**: O(m×n) for new array
- **DFS Problems**: O(m×n) for recursion stack
- **Memoization**: O(m×n) for DP array

## Best Practices

1. **Always check bounds** before accessing array elements
2. **Use appropriate traversal patterns** for specific problems
3. **Consider space-time tradeoffs** when choosing algorithms
4. **Handle edge cases** like null arrays, empty arrays, and single elements
5. **Use memoization** for recursive problems to avoid recomputation

## Running the Demo

To see all functionality in action, run the `TwoDArrayDemo` class:

```bash
cd dataStructures/src/main/java
javac com/dsa/twoDArrays/*.java
java com.dsa.twoDArrays.TwoDArrayDemo
```

## Contributing

Feel free to add more algorithms, patterns, or problem solutions to this package. Ensure all methods have proper documentation and test cases.

## Learning Path

1. Start with `TwoDArrayBasics` to understand fundamental operations
2. Move to `TwoDArrayPatterns` to learn traversal techniques
3. Practice with `TwoDArrayProblems` to solve complex scenarios
4. Run `TwoDArrayDemo` to see everything in action
5. Implement your own variations and extensions

This package provides a solid foundation for mastering 2D array problems and can be extended for more advanced matrix operations and algorithms.
