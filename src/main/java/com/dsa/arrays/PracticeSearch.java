package com.dsa.arrays;

public class PracticeSearch {  
    // https://www.youtube.com/watch?v=4_HOnhB64Dg

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target)
                return mid;
            else if (arr[mid] > target)
                right = mid -1;
            else left = mid +1;
        }
        return  -1;
    }

    public static void main(String [] args) {
        int [] array = {7,9,13,14,17,19,20,22};
        int target = 20;
        System.out.println(binarySearch(array, target));
        System.out.println(ArrayOperations.binarySearch(array, target));


    }
    public static int bubbleSort(int a[]) {
        int n= a.length;
        for(int i=0; i<n-1; i++) {
            for(int j=0; j<n-i-1; j++) {
                if(a[j]>a[j+1]) {
                    int temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
        return -1;
    }
}
