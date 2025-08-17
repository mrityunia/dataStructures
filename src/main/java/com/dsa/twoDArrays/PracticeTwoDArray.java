package com.dsa.twoDArrays;

public class PracticeTwoDArray {

    public static void aa(String[] args) {
        int [][] array = {{1,2,3},{4,5,6,22,12},{7,8,9,1,4},{10,11,12}};
        System.out.println("Length of the Column");
        System.out.println(array.length);
        System.out.println("Length of the each Column");
        for (int[] ints : array) {
            System.out.println(ints.length);
        }
        System.out.println("Print the Array in table for");
        for (int i = 0; i < array.length; i++) {
            System.out.print("[");
            for (int j=0; j<array[i].length; j++){
                System.out.print(array[i][j]);
                System.out.print(" ");
            }
            System.out.print("]");
            System.out.println();
        }
        System.out.println("get the Sum of Matrix Elements");
        int sum =0;
        for (int [] arr : array){
            for (int a : arr){
                sum = sum+a;
            }
        }
        System.out.printf("Sum of Matrix Elements %d",sum);

        System.out.println("Row-wise Sum & Column-wise Sum");
        for (int i=0; i<array.length; i++){
            int rowSum = 0;
            for (int j=0;j<array[i].length; j++) {
                rowSum = rowSum + array[i][j];
            }
            System.out.println();
            System.out.printf("%d th row sum is %d", i, rowSum);
        }
        for (int j=0; j < array.length-1; j++){
            int columnSum = 0;
            for (int i=0; i < array.length; i++) {
                columnSum = columnSum + array[i][j];
            }
            System.out.println();
            System.out.printf("%d th column sum is %d", j, columnSum);
        }
    }
    public static void main(String[] args) {
        printPrimaryAndSecondaryDiagonal();
    }
    public static void getDynamicRowColumnSum() {
        int [][] array = {{1,2,3},{4,5,6,7,8},{9,10,11,12,13,22},{14,15,16}};
        for (int [] arr : array ) {
            int rowSum = 0;
            for (int a : arr) {
                rowSum = rowSum + a;
            }
            System.out.printf("%d th row sum is %d", 0, rowSum);
            System.out.println();
        }
        int maxColumnSize = 0;
        for (int [] arr : array) {
            if (array.length > maxColumnSize)
                maxColumnSize = array.length;
        }

        for(int j= 0; j< maxColumnSize; j++){
            int columnWiseSum = 0;
            for(int i= 0; i< array.length; i++ ){
                if (j < array[i].length) {
                    columnWiseSum = columnWiseSum + array[i][j];
                }
            }
            System.out.printf("%d th column sum is %d%n", j, columnWiseSum);
        }
    }

    public static void findMaximumElementInMatrix() {
        int [][] array = {{1,2,3},{4,5,6,7,8},{9,10,11,12,13},{14,15,16}};
        int max = 0;
        int i=0;
        for (int [] arr : array ) {
            int j=0;
            for(int a : arr) {
                    System.out.printf("[%d][%d]",i,j++);
                    System.out.printf("=> %d",a);
                    System.out.print(" ");

            }
            i++;
            System.out.println("");
        }
        System.out.printf("Maximum element in array is %d", max);
    }

    public static void findMaximumElementInMatrix3() {
        int [][] array = {{1,2,3},{4,5,6,7,8},{9,10,11,12,13,22},{14,15,16}};
        int max = 0;
        for (int [] arr : array ) {
            for(int a : arr) {
                if (a > max)
                    max = a;
            }
        }
        System.out.printf("Maximum element in array is %d", max);
    }

    public static void transposeAMatrix() {
        int [][] array = {{1,2,3},{4,5,6,7,8},{9,10,11,12,13,22},{14,15,16}};
        int maxColumn = 0;
        for (int [] arr :  array){
            if (arr.length>maxColumn)
                maxColumn = arr.length;
        }
        int [][] transposeMatrix = new int[maxColumn][array.length];
        for (int j = 0; j < maxColumn; j++) {
            for(int i = 0; i < array.length; i++) {
                if (j < array[i].length)
                    transposeMatrix[j][i] = array[i][j];
            }
        }
        printArray(transposeMatrix);

    }

    public static void printPrimaryAndSecondaryDiagonal() {
        int [][] array = {{1,2,4},{4,5,6},{9,10,11}};
        int sumOfPrimaryDiagonal = 0;
        int sumOfSecondaryDiagonal = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j <array[i].length;j++) {
                if (i == j){
                    sumOfPrimaryDiagonal = sumOfPrimaryDiagonal + array[i][j];
                }
                int diagonalPosition = i+j;
                if (diagonalPosition == (array.length - 1)){
                    sumOfSecondaryDiagonal = sumOfSecondaryDiagonal +  array[i][j];
                }
            }
        }
        System.out.printf("Sum of Primary diagonal in 2D array is %d%n", sumOfPrimaryDiagonal);
        System.out.printf("Sum of secondary diagonal in 2D array is %d", sumOfSecondaryDiagonal);

    }

public static void printArray(int [][] array) {
    for (int [] arr : array ){
        System.out.print("[");
        for(int a : arr) {
            System.out.print(a);
            System.out.print(" ");
        }
        System.out.print("]");
        System.out.println();
    }

}







}
