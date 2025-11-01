package company;

import java.util.HashSet;
import java.util.Set;

public class Google {

//    Find the longest substring without repeating characters
//    Rotate an array by k steps (in-place)
//    Merge overlapping intervals
//    Product of array except self
//    Set matrix zeroes
//    Maximum subarray sum (Kadane’s algorithm)
//    Trapping rain water
//3Sum / 4Sum problem
//    Longest palindromic substring
//    Minimum window substring

    public static void main(String [] args) {
        findLongestSubStringWithoutRepeating();
    }

    public static void findLongestSubStringWithoutRepeating() {
        String SS = "dvdf";
        String longestString = "";
        Set<String> uniqueString = new HashSet<>();
        for(int i =0 ; i < SS.length(); i++) {
            if (!longestString.contains(String.valueOf(SS.charAt(i)))) {
                longestString = longestString.concat(String.valueOf(SS.charAt(i)));
            }
            else {
                uniqueString.add(longestString);
                longestString = "";
                longestString = longestString.concat(String.valueOf(SS.charAt(i)));
            }

        }
        String finalString = "";
        for (int a = 0; a < uniqueString.size(); a ++){
            if (finalString.length() < uniqueString.toArray()[a].toString().length()) {
                finalString = uniqueString.toArray()[a].toString();
            }
        }
        System.out.println(finalString);
    }


}
