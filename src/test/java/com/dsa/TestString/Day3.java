package com.dsa.TestString;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Day3 {

    public static void LongestUniqueSubstringLength() {
        String input = "abcabcbb";
        int left = 0;
        int max = 0;
        Set<Character> uniqueCharacter = new HashSet<>();
        for (int right = 0; right < input.length(); right++) {
            char ch = input.charAt(right);
            while (uniqueCharacter.contains(input.charAt(right))) {
                uniqueCharacter.remove(input.charAt(left));
                left++;
            }
            uniqueCharacter.add(ch);
            max = Math.max(max, (right - left + 1));
        }
        System.out.printf("Maximum length of the subString is %d", max);
    }

    public static void longestUniqueSubstring() {
        String input = "abcabctbb";
        int left = 0;
        int max = 0;
        int startIndex = 0;
        Set<Character> uniqueString = new HashSet<>();
        for (int right = 0; right < input.length(); right++) {
            char ch = input.charAt(right);
            while (uniqueString.contains(ch)) {
                uniqueString.remove(input.charAt(left));
                left++;
            }
            uniqueString.add(ch);
            if (right - left + 1 > max) {
                max = right - left + 1;
                startIndex = left;
            }
        }
        String string = input.substring(startIndex, startIndex + max);
        System.out.printf("%s is the substring and the length is %d", string, max);
    }

    public static void LongestSubstringWithAtMostKDistinctCharacters() {
        String s = "ecebabb";
        Map<Character, Integer> freqMap = new HashMap<>();
        int left = 0;
        int maxLen = 0;
        int k = 2;
        int startIndex = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);

            // shrink window if distinct characters > k
            while (freqMap.size() > k) {
                char leftChar = s.charAt(left);
                freqMap.put(leftChar, freqMap.get(leftChar) - 1);

                if (freqMap.get(leftChar) == 0) {
                    freqMap.remove(leftChar);
                }
                left++;
            }

            // update maximum window
            if (right - left + 1 > maxLen) {
                maxLen = right - left + 1;
                startIndex = left;
            }
        }
        String ss = s.substring(startIndex, startIndex + maxLen);

    }

    public static void LongestSubstringWithAtMostKDistinctCharacters2(int K) {
        String s = "ecebabb";
        // base case
        if (K == 0) {
            System.out.println("no distinct");
        }
        char [] chars = s.toCharArray();
        // define pointer
        int l = 0; int r =0;
        // define a table
        Map<Character, Integer> table = new HashMap<>();
        // define maxLength = 0;
        int maxLen = 0;
        int n = s.length();
        // find the substring with k distinct char
        while (r < n) {
            // put element into the table with count
            table.put(chars[r], table.getOrDefault(chars[r], 0) + 1);
            // contract the window if we don't meet the conditions
            while (table.size() > K) {
                table.put(chars[l], table.get(chars[l]) -1);
                if(table.get(chars[l]) ==0) {
                    table.remove(chars[l]);
                }
                l++;
            }
            // update the max length
            maxLen = Math.max(maxLen, r - l + 1);
            // move R to the right
            r++;
        }
    }
    public static void LongestSubstringWithAtMostKDistinctCharacters3(int k) {
        String input = "babbcbebebe";
        // define starting pointers
        int left = 0;
        // defin the uniqueChar and respective counts
        Map<Character, Integer> uniqueCharCounts = new HashMap<>();
        // define max length and number elements
        int maxLen = 0; int n =  input.length();
        for (int right = 0; right < n; right++) {
            uniqueCharCounts.put(input.charAt(right), uniqueCharCounts.getOrDefault(input.charAt(right),0) + 1);
            while (uniqueCharCounts.size() > k) {
                uniqueCharCounts.put(input.charAt(left), uniqueCharCounts.get(input.charAt(left)) -1);
                if (uniqueCharCounts.get(input.charAt(left)) ==0) {
                    uniqueCharCounts.remove(input.charAt(left));
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left +1);
        }
        String subStringValue = input.substring(left, maxLen+left);
        System.out.printf("Maximum length of the substring %s is %d",subStringValue, maxLen);
    }
    public static void longestUniqueSubstring3() {
        String string = "abcbbcbbcar";
        int left = 0, max = 0;
        Set<Character> set = new HashSet<>();
        for (int right = 0; right < string.length(); right++) {
            char s = string.charAt(right);
            while (set.contains(s)){
                set.remove(string.charAt(left));
                left++;
            }
            set.add(s);
            max = Math.max(max, right - left + 1);
        }
        System.out.printf("Length of the unique substring is %d", max);
    }

    public static void main(String[] args) {
        int fac = factorial(5);
        System.out.printf("value of factorial %d us %d ", 5, fac);
    }

    public static int factorial(int k) {
        System.out.println(k);
      if(k ==0 || k ==1) {
          return 1;
      }
      return k*factorial(k-1);
    }
}
