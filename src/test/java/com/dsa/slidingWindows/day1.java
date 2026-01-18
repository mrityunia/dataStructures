package com.dsa.slidingWindows;

import java.util.Arrays;

//https://www.youtube.com/watch?v=KtpqeN0Goro&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=3
public class day1 {

    public static void findMaximumSubOfArraySizeBruteforce() {
        int[] array = {2, 3, 5, 2, 9, 7, 1};
        int k = 3;
        int maxSum = 0;
        for (int i = 0; i <= array.length - k; i++) {
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                System.out.printf("%d,", array[j]);
                sum = sum + array[j];
            }
            maxSum = Math.max(maxSum, sum);
            System.out.println();
        }
        System.out.printf("Maximum sum is %d", maxSum);
    }

    public static void findMaximSumOfSubArrSizeK() {
        int[] array = {2, 3, 5, 2, 9, 7, 1};
        int fixedSizeOfTheWindow = 3;
        int expectedResultMaximumSum = Integer.MIN_VALUE;
        // given an array , provided a fixed window size which is  3 always, find the values.
        // find the values when the window size math

        int startWindow = 0;
        int rightWindow = 0;

        int windowSum = 0;

        // loop to all the elements
        while (rightWindow < array.length) {
            // sum one by one because we have to add always
            windowSum = windowSum + array[rightWindow];
            // check the sliding window size right - left + 1 = windows size
            if (rightWindow - startWindow + 1 == fixedSizeOfTheWindow) {
                //if window size match then retrieve the expected values
                expectedResultMaximumSum = Math.max(expectedResultMaximumSum, windowSum);
                // remove the first element because we are always adding the new element at the benging
                windowSum = windowSum - array[startWindow];
                // slide the window so that we can add one more element in next iterations
                startWindow++;
            }
            // move to the new elements
            rightWindow++;

        }
        System.out.printf("Maxim Mum sum of the array is %d", expectedResultMaximumSum);
    }


    public static void main(String[] args) {
        findMaximSumOfSubArrSizeK();
    }


    public static void findMaximumSumSubArrayOfSizeK() {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;

        int windowSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int startIndex = 0;

        for (int right = 0; right < arr.length; right++) {
            windowSum = windowSum + arr[right];   // add current element

            // when window size becomes k
            if (right >= k - 1) {

                if (windowSum > maxSum) {
                    maxSum = windowSum;
                    startIndex = right - (k - 1);
                }

                // remove element leaving the window
                windowSum = windowSum - arr[right - (k - 1)];
            }
        }

        // extract the subarray
        int[] maxSubarray = Arrays.copyOfRange(arr, startIndex, startIndex + k);
        System.out.printf(
                "Sub array which has maximum sum of size %d is %s%n",
                k,
                Arrays.toString(maxSubarray)
        );
    }

    public static void findMaximumSumSubArrayOfSizeK2() {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;

        int startWindow = 0;
        int max = Integer.MIN_VALUE;
        int windowSum = 0;

        for (int right = 0; right < arr.length; right++) {
            windowSum = windowSum + arr[right];

            if (right >= k - 1) {
                if (windowSum > max) {
                    max = windowSum;
                    startWindow = right - (k - 1);
                }
                // removing the start window
                windowSum = windowSum - arr[right - (k - 1)];
            }
        }
        int[] expectedArray = Arrays.copyOfRange(arr, startWindow, startWindow + k);
        System.out.printf("Sub string which has maximum window is %s", Arrays.toString(expectedArray));
    }


    public static void LongestSubArrayWithSumGEqK() {
        int[] arrays = {4, 1, 9, 9, 2, 3, 5};
        int k = 5;

        int left = 0;
        int maxLength = 0;
        int sum = 0;
        int startIndex = 0;

        for (int right = 0; right < arrays.length; right++) {
            sum = sum + arrays[right];
            while (sum > k) {
                sum = sum - arrays[left];
                left++;
            }
            // update max length and starting index
            if (right - left + 1 > maxLength) {
                maxLength = right - left + 1;
                startIndex = left;
            }
        }

        int[] newArrays = Arrays.copyOfRange(arrays, startIndex, startIndex + maxLength);
        System.out.printf("Sub array which has sum of <= %s ", Arrays.toString(newArrays));

    }

    public static void printLongestSubarray() {
        int[] arr = {4, 1, 9, 9, 2, 3, 5};
        int k = 5;
        int left = 0;
        int sum = 0;
        int maxLength = 0;
        int startIndex = 0;

        for (int right = 0; right < arr.length; right++) {
            sum += arr[right];

            // shrink window if sum > k
            while (sum > k) {
                sum -= arr[left];
                left++;
            }

            // update max length and starting index
            if (right - left + 1 > maxLength) {
                maxLength = right - left + 1;
                startIndex = left;
            }
        }

        // store the subarray
        int[] longestSubarray = Arrays.copyOfRange(
                arr, startIndex, startIndex + maxLength
        );

        System.out.println("Length = " + maxLength);
        System.out.println("Subarray = " + Arrays.toString(longestSubarray));
    }


    public static void firstNegativeNumberinEveryWindowOfSizek() {
        int[] array = {12, -1, -7, 8, -15, 30, 16, 28};
        int k = 3;

        int left = 0;
        for (int right = 0; right < array.length; right++) {
            int number = array[right];
            if (number < 0) {

            }

        }


    }
}


//Got it 👍 Sliding Window is a *must-master* topic for **DSA interviews**. Below is a **clean, interview-style list of Sliding Window problems** (ISA/FAANG-level), grouped by **type**, with **clear input & output examples**.
//
//        ---
//
//        ## 1️⃣ Fixed-Size Sliding Window Problems
//
//### 1. Maximum Sum Subarray of Size K
//
//**Problem:**
//Given an array of integers and a number `k`, find the maximum sum of any contiguous subarray of size `k`.
//
//        **Input:**
//        `arr = [2, 1, 5, 1, 3, 2], k = 3`
//
//        **Output:**
//        `9`
//        **Explanation:** Subarray `[5,1,3]`
//
//        ---
//
//        ### 2. First Negative Number in Every Window of Size K
//
//**Input:**
//        `arr = [12, -1, -7, 8, -15, 30, 16, 28], k = 3`
//
//        **Output:**
//        `[-1, -1, -7, -15, -15, 0]`
//
//        ---
//
//        ### 3. Count Occurrences of Anagrams
//
//**Input:**
//        `text = "forxxorfxdofr", pattern = "for"`
//
//        **Output:**
//        `3`
//
//        ---
//
//        ### 4. Maximum of All Subarrays of Size K
//
//**Input:**
//        `arr = [1, 3, -1, -3, 5, 3, 6, 7], k = 3`
//
//        **Output:**
//        `[3, 3, 5, 5, 6, 7]`
//
//        ---
//
//        ## 2️⃣ Variable-Size Sliding Window Problems
//
//### 5. Longest Subarray with Sum ≤ K
//
//**Input:**
//        `arr = [4, 1, 1, 1, 2, 3, 5], k = 5`
//
//        **Output:**
//        `4`
//        **Explanation:** `[1,1,1,2]`
//
//        ---
//
//        ### 6. Longest Substring Without Repeating Characters
//
//**Input:**
//        `"abcabcbb"`
//
//        **Output:**
//        `3`
//        **Explanation:** `"abc"`
//
//        ---
//
//        ### 7. Longest Substring with At Most K Distinct Characters
//
//**Input:**
//        `"eceba", k = 2`
//
//        **Output:**
//        `3`
//        **Explanation:** `"ece"`
//
//        ---
//
//        ### 8. Longest Substring with Exactly K Distinct Characters
//
//**Input:**
//        `"aabacbebebe", k = 3`
//
//        **Output:**
//        `7`
//        **Explanation:** `"cbebebe"`
//
//        ---
//
//        ### 9. Minimum Size Subarray Sum
//
//**Input:**
//        `arr = [2,3,1,2,4,3], target = 7`
//
//        **Output:**
//        `2`
//        **Explanation:** `[4,3]`
//
//        ---
//
//        ## 3️⃣ Sliding Window + HashMap / Frequency Map
//
//### 10. Smallest Window Containing All Characters of Another String
//
//**Input:**
//        `str = "timetopractice", pattern = "toc"`
//
//        **Output:**
//        `"toprac"`
//
//        ---
//
//        ### 11. Find All Anagrams in a String
//
//**Input:**
//        `str = "cbaebabacd", pattern = "abc"`
//
//        **Output:**
//        `[0, 6]`
//
//        ---
//
//        ### 12. Longest Repeating Character Replacement
//
//**Input:**
//        `"AABABBA", k = 1`
//
//        **Output:**
//        `4`
//        **Explanation:** `"AABA"`
//
//        ---
//
//        ## 4️⃣ Advanced / Interview-Heavy Sliding Window
//
//### 13. Fruits Into Baskets (LeetCode 904)
//
//**Input:**
//        `fruits = [1,2,1,2,3,2,2]`
//
//        **Output:**
//        `4`
//
//        ---
//
//        ### 14. Binary Subarray With Sum
//
//**Input:**
//        `nums = [1,0,1,0,1], goal = 2`
//
//        **Output:**
//        `4`
//
//        ---
//
//        ### 15. Subarrays with At Most K Distinct Integers
//
//**Input:**
//        `nums = [1,2,1,2,3], k = 2`
//
//        **Output:**
//        `7`
//
//        ---
//
//        ## 5️⃣ Classic Interview Pattern Summary 🧠
//
//        | Pattern         | Key Idea             |
//        | --------------- | -------------------- |
//        | Fixed window    | Window size constant |
//        | Variable window | Expand → shrink      |
//        | HashMap         | Count frequency      |
//        | Deque           | Max / Min window     |
//        | Two windows     | Exactly K problems   |
//
//        ---
//
//        ## 🔥 Interview Tip (Very Important)
//
//Most **“Exactly K”** problems are solved using:
//
//        ```
//Exactly K = AtMost(K) - AtMost(K-1)
//```
//
//        ---
//
//If you want next:
//
//        * ✅ **Java code templates**
//        * ✅ **Dry-run diagrams**
//        * ✅ **ISA → FAANG mapping**
//        * ✅ **Sliding Window cheat sheet**
//
//Just tell me 😄





