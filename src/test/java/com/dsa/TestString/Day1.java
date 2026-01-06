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
        if (words == null || words.isEmpty()) {
            return false;
        } else {
            char[] chs = words.toLowerCase().replaceAll(" ", "").toCharArray();
            int left = 0, right = chs.length - 1;
            while (left < right) {
                if (chs[left++] != chs[right--]) {
                    return false;
                }
            }
            return true;
        }
    }

    public static int longestSubstringWithoutRepeatingCharacters(String s) {
        if (s == null || s.isEmpty()) {
            return -1;
        } else {
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

    public static void verifyAnagrams() {
        String string1 = "listen";
        String string2 = "ailent";
        int[] charsIndex = new int[26];
        for (char ch : string1.toCharArray()) {
            int index = ch - 'a';
            charsIndex[index]++;
        }
        for (char ch : string2.toCharArray()) {
            int index = ch - 'a';
            charsIndex[index]--;
        }
        boolean isAnagram = true;
        for (int index : charsIndex) {
            if (index != 0) {
                isAnagram = false;
                break;
            }
        }
        System.out.println("Is anagrams = " + isAnagram);
    }

    public static void main(String[] args) {
        //        String words = "abbcabmqcbb";
        //        System.out.println(longestSubstringWithoutRepeatingCharacters(words));

        isStringRotation();
    }

    public static char findFirstNonRepeatingChar(String str) {
        int[] freq = new int[256];
        for (char ch : str.toCharArray()) {
            freq[ch]++;
        }
        for (char ch : str.toCharArray()) {
            if (freq[ch] == 1) {
                return ch;
            }
        }
        return '\0'; // no non-repeating char
    }

    public static void checkIfStringContainsOnlyUnique() {
        String string  = "abcdesf";
        boolean [] characterSets = new boolean[256];
        boolean isStringContainsUniqueCharacter = true;
        for (char ch : string.toCharArray()) {
           if (characterSets[ch]) {
               isStringContainsUniqueCharacter = false;
               break;
           }
            characterSets[ch] = true;
        }
        System.out.printf(" %s is contains unique character ? ans is %s" ,string,isStringContainsUniqueCharacter);
    }

    public static void reverseWords() {
        String string = "Java Coding";
        String [] eachWord = string.split(" ");
        String newString = "";
        for (String st : eachWord) {
            newString = st.concat(" ").concat(newString);
        }
        System.out.println(newString.trim());
    }

    public static void isStringRotation() {
        String string1 = "waterbottle";
        String string2 = "erbottlewat";
        String newString = string1 + string1;
        if(newString.contains(string2)){
            System.out.println("String are rotatable");
        }
        else
            System.out.println("String are not rotatable");
    }



}
