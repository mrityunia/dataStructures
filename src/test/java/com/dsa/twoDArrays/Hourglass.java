package com.dsa.twoDArrays;

import java.util.ArrayList;
import java.util.List;

public class Hourglass {

//    You are given a  2D array. An hourglass in an array is a portion shaped like this:
//    a b c
//            d
//    e f g

//    For example, if we create an hourglass using the number 1 within an array full of zeros, it may look like this:
//            1 1 1 0 0 0
//            0 1 0 0 0 0
//            1 1 1 0 0 0
//            0 0 0 0 0 0
//            0 0 0 0 0 0
//            0 0 0 0 0 0
//    Actually, there are many hourglasses in the array above. The three leftmost hourglasses are the following:
//            1 1 1     1 1 0     1 0 0
//            1         0         0
//            1 1 1     1 1 0     1 0 0
//    The sum of an hourglass is the sum of all the numbers within it. The sum for the hourglasses above are 7, 4, and 2, respectively.
//            In this problem you have to print the largest sum among all the hourglasses in the array.
//            Input Format
//    There will be exactly  lines, each containing  integers seperated by spaces. Each integer will be between  and  inclusive.
//            Output Format
//    Print the answer to this problem on a single line.
//            Sample Input
//1 1 1 0 0 0
//        0 1 0 0 0 0
//        1 1 1 0 0 0
//        0 0 2 4 4 0
//        0 0 0 2 0 0
//        0 0 1 2 4 0
//    Explanation
//    The hourglass which has the largest sum is:
//            2 4 4
//            2
//            1 2 4

    public static void findSumOfHourGlass() {
        int[][] array = {
                {1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 2, 4, 4, 0},
                {0, 0, 0, 2, 0, 0},
                {0, 0, 1, 2, 4, 0}
        };
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i< 4; i++) {
            for (int j = 0 ; j< 4; j ++) {
                int sum = array[i][j] + array[i][j+1] + array[i][j+2]
                        + array[i+1][j+1]
                        + array[i+2][j] + array[i+2][j+1] + array[i+2][j+2];
                maxSum = Math.max(maxSum, sum);
            }
        }
        System.out.println(maxSum);
    }

    public static void main(String[] args) {
        int  [] game = {0,1,0,1,0,1};
        int leape = 2;
        boolean results = canWin(leape, game);
        System.out.println(results);
    }


    public static boolean canWin(int leap, int[] game) {
        // Return true if you can win the game; otherwise, return false.

        int postions = 0;
        for (int i=0; i< game.length; i++) {
            if (game[i+leap] == 0) {
                postions = postions + leap;
            }
            else if (game[i] == 0) {
                postions ++;
            }

            else {
                break;
            }
        }
        if (postions == game.length || postions + leap >= game.length){
            return true;
        }
        else
            return false;

    }
}
