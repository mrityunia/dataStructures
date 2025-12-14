package com.dsa.TestString;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class Day1 {

    // took 6 mins
    public static String reverseAString(String words) {
        if (words == null || words.isEmpty())
            return null;
        else {
            int left = 0, right = words.length() - 1;
            char[] chs = words.toCharArray();
            while (left < right) {
                char temp = chs[left];
                chs[left++] = chs[right];
                chs[right--] = temp;
            }
            return new String(chs);
        }
    }

    public static boolean isPalindrome(String words) {
        if (words == null || words.isEmpty()){
            return false;
        }
        else {
            char[] chs = words.toLowerCase().replaceAll(" ","").toCharArray();
            int left = 0, right = chs.length -1;
            while (left < right) {
                if (chs[left++] != chs[right--]){
                    return false;
                }
            }
            return true;
        }
    }

    public static int longestSubstringWithoutRepeatingCharacters(String s) {
        if (s == null || s.isEmpty()){
            return -1;
        }
        else {
            Set<Character> set = new HashSet<>();
            int left = 0, longest = 0;

            for (int right = 0; right < s.length(); right++) {
                char sd = s.charAt(right);
                while (set.contains(sd)) {
                    set.remove(s.charAt(left));
                    left++;
                }
                set.add(s.charAt(right));
                longest = Math.max(longest, right - left + 1);
            }

            return longest;
        }
    }

    public static void main(String[] args) {
        String words = "abbcabmqcbb";
        System.out.println(longestSubstringWithoutRepeatingCharacters(words));
    }

}
