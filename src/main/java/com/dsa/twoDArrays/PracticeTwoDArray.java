package com.dsa.twoDArrays;

public class PracticeTwoDArray {

    public static void main(String[] args) {
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
}
