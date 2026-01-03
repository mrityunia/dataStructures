package com.dsa.twoDArrays;

public class perplexity2DArrayDay2 {


    //If a cell is 0, set its entire row and column to 0.
// input
//    [
//            [1, 2, 3],
//            [4, 0, 6],
//            [7, 8, 9]
//            ]
// Output
//            [
//            [1, 0, 3],
//            [0, 0, 0],
//            [7, 0, 9]
//            ]

    public static void main(String[] args) {
        countNumberOfIslands();
    }

    public static void setMatrixZeroes() {
        int[][] inputArray =
                {{1, 2, 3},
                        {4, 0, 8},
                        {7, 8, 9}};

        int row = inputArray.length;
        int col = inputArray[0].length;

        // check if the first row or column has zero
        boolean isFirstRowZero = false;
        boolean isFirstColumnZero = false;

        for (int i = 0; i < row; i++) {
            if (inputArray[0][i] == 0) {
                isFirstRowZero = true;
                break;
            }
        }

        for (int i = 0; i < col; i++) {
            if (inputArray[i][0] == 0) {
                isFirstColumnZero = true;
                break;
            }
        }

        // find the zero from 1 1 row , and if found make the corresponding first row and column as zero
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (inputArray[i][j] == 0) {
                    inputArray[0][j] = 0;
                    inputArray[i][0] = 0;
                }
            }
        }

        // mark the remaining rows and columns as zero for the zeros founds on middle
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (inputArray[i][0] == 0 || inputArray[0][j] == 0) {
                    inputArray[i][j] = 0;
                }
            }
        }
        // update the rows and column when first row and column was zero
        if (isFirstRowZero) {
            for (int j = 0; j < col; j++) {
                inputArray[0][j] = 0;
            }
        }
        if (isFirstColumnZero) {
            for (int i = 0; i < row; i++) {
                inputArray[i][0] = 0;

            }
        }
        printArray(inputArray);
    }


    //Rotate Matrix 90° Clockwise
//    🔢 Input
//[
//        [1, 2, 3],
//        [4, 5, 6],
//        [7, 8, 9]
//        ]
//        ✅ Output
//[
//        [7, 4, 1],
//        [8, 5, 2],
//        [9, 6, 3]
//        ]


    public static void rotateMatrix90Clockwise() {
        int[][] inputArray = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        int n = inputArray.length;
        // transpose the Matrix AT
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = inputArray[i][j];
                inputArray[i][j] = inputArray[j][i];
                inputArray[j][i] = temp;
            }
        }
        // reverse the matrix
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int temp = inputArray[i][left];
                inputArray[i][left] = inputArray[i][right];
                inputArray[i][right] = temp;
                left++;
                right--;
            }
        }
        printArray(inputArray);
    }
//3️⃣ Spiral Matrix Traversal
//🔢 Input
//[
//        [1, 2, 3],
//        [4, 5, 6],
//        [7, 8, 9]
//        ]
//        ✅ Output
//1 2 3 6 9 8 7 4 5


    public static void spiralMatrixTraversal() {
        int[][] inputArray = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        int top = 0, left = 0;
        int bottom = inputArray.length - 1, right = inputArray.length - 1;

        // left to right
        while (left <= right && top <= bottom) {
            // print the top details from left to right
            for (int col = left; col <= right; col++) {
                System.out.printf("%d ", inputArray[top][col]);
            }
            top++;
            //print the right details from top to button
            for (int row = top; row <= bottom; row++) {
                System.out.printf("%d ", inputArray[row][right]);
            }
            right--;

            // print the button details from right to left
            if (top <= bottom) {
                for (int col = right; col >= left; col--) {
                    System.out.printf("%d ", inputArray[bottom][col]);
                }
                bottom--;
            }
            // print the left details from button to top
            if (left <= right) {
                for (int row = bottom; row >= top; row--) {
                    System.out.printf("%d ", inputArray[row][left]);
                }
            }
            left++;

        }
    }
//
//    Search in Sorted 2D Matrix
//    Rows & columns are sorted.
//🔢 Input
//            Matrix =
//[
//        [1, 3, 5, 7],
//        [10, 11, 16, 20],
//        [23, 30, 34, 60]
//        ]
//    Target = 16
//            ✅ Output
//true

    public static void searchInSorted2DMatrix() {
        int targetedNumber = 16;
        int[][] inputArray = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}};

        int row = inputArray.length;
        int col = inputArray[0].length;

        int r = 0;
        int c = col - 1;
        while (r < row && c >= 0) {
            if (inputArray[r][c] == targetedNumber) {
                System.out.printf("Number is present %d", targetedNumber);
                break;
            }
            // compare the values of last columns ; if the value is greater the compare with the previous column value
            else if (inputArray[r][c] > targetedNumber) {
                c--;
            }
            // if the value is greater move the next row
            else {
                r++;
            }

        }
    }

//    5️⃣ Maximum Hourglass Sum
//🔢 Input
//[
//        [1, 1, 1, 0, 0, 0],
//        [0, 1, 0, 0, 0, 0],
//        [1, 1, 1, 0, 0, 0],
//        [0, 0, 2, 4, 4, 0],
//        [0, 0, 0, 2, 0, 0],
//        [0, 0, 1, 2, 4, 0]
//        ]
//        ✅ Output
//19

    public static void maximumHourglassSum() {
        int[][] matrix = {
                {1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 2, 4, 4, 0},
                {0, 0, 0, 2, 0, 0},
                {0, 0, 1, 2, 4, 0}
        };

        int max = Integer.MIN_VALUE;
        int possibleRow = matrix.length - 3;
        int possibleCol = matrix[0].length - 3;

        for (int i = 0; i <= possibleRow; i++) {
            for (int j = 0; j <= possibleCol; j++) {
                int sum = matrix[i][j] + matrix[i][j + 1]+matrix[i][j + 2]
                                        + matrix[i + 1][j + 1] +
                          matrix[i + 2][j] + matrix[i + 2][j + 1] + matrix[i + 2][j + 2];
                max = Math.max(max, sum);
            }
        }
        System.out.printf("Sum of Maximum hourglass is %d", max);
    }


//    6️⃣ Count Number of Islands explains
//    An island is formed by connected land cells ('1') horizontally or vertically (not diagonally).
//            🟩 Example Input
//1 1 0 0 0
//        1 1 0 0 0
//        0 0 1 0 0
//        0 0 0 1 1
//        ✅ Output
//3 islands

public static void countNumberOfIslands() {
//    int[][] grid = {
//            {1, 1, 0, 0, 0},
//            {1, 1, 0, 0, 0},
//            {0, 0, 1, 0, 0},
//            {0, 0, 1, 1, 1}
//    };
    int[][] grid = {
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
    };
    int row = grid.length;
    int col = grid[0].length;
    int island = 0;
    for (int i = 0; i < row; i++) {
        for (int j = 0; j < col -1; j++) {
            if (grid[i][j] == 1) {
                if (grid[i][j+1] == 1){
                    island++;
                    break;
                }
                else if (grid[i+1][j] ==1)
                    island++;
            }

        }
    }
    System.out.printf("Number of Islands %d", island);

}

    public static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.printf("%d ", array[i][j]);
            }
            System.out.println();
        }
    }
}
