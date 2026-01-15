package com.dsa.TestString;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Day4 {

    public static void reverseString() {
        String s = "hello";
        char[] chs = s.toCharArray();
        int mid = (chs.length / 2);
        for (int i = 0; i < mid; i++) {
            char ch = chs[i];
            chs[i] = chs[chs.length - 1 - i];
            chs[chs.length - 1 - i] = ch;

        }
        String newreverString = new String(chs);
        System.out.printf("Reverse String of %s is %s", s, newreverString);
    }


    public static void checkPalindrome() {
        String input = "madam";
        boolean isPalindrome = true;
        int mid = input.length() / 2;
        for (int i = 0; i < mid; i++) {
            if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }
        System.out.printf("is the string of %s palindrome %b", input, isPalindrome);
    }

    public static void countCharacterCounts() {
        String input = "madama";
        Map<Character, Integer> characterAndCount = new HashMap<>();
        for (char ch : input.toCharArray()) {
            characterAndCount.put(ch, characterAndCount.getOrDefault(ch, 0) + 1);
        }
        characterAndCount.keySet().stream().forEach(character -> System.out.printf("%c character uas value %s \n", character, characterAndCount.get(character)));

    }

    public static void firstNonRepeatingCharacter() {
        String input = "rmadamat";
        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        for (char ch : input.toCharArray()) {
            characterIntegerMap.put(ch, characterIntegerMap.getOrDefault(ch, 0) + 1);
        }
        for (char ch : input.toCharArray()) {
            if (characterIntegerMap.get(ch) == 1) {
                System.out.printf("First unique character is %c of the string %s", ch, input);
                break;
            }
        }
    }

    public static void checkAnagramsOfTwoString() {
        String input1 = "silent";
        String input2 = "listena";
        boolean isAnagram = true;
        int[] characterAsciMapping = new int[26];
        for (char ch : input1.toCharArray()) {
            int a = ch - 'a';
            characterAsciMapping[a]++;
        }

        for (char ch : input2.toCharArray()) {
            int a = ch - 'a';
            characterAsciMapping[a]--;
        }

        for (int a : characterAsciMapping) {
            if (a != 0) {
                isAnagram = false;
                break;
            }
        }
        System.out.printf("Anagram status of both the string %s amd %s are %b ", input1, input2, isAnagram);
    }


    public static void removeDuplicateCharacter() {
        String s = "programming";
        Set<Character> uniqueCharacter = new HashSet<>();
        for (char ch : s.toCharArray()) {
            uniqueCharacter.add(ch);
        }
        String uniqueCharacterString = uniqueCharacter.stream().map(String::valueOf)
                .collect(Collectors.joining());
        System.out.printf("unique character of the string %s is %s", s, uniqueCharacterString);
    }


    public static void findLongestSubstringOfString() {
        String input = "abcacbbcbcbc";
        int left = 0;
        int lengthOfTheSubString = 0;
        int startIndex = 0;
        Set<Character> uniqueCharacter = new HashSet<>();

        for (int right = 0; right < input.length(); right++) {
            while (uniqueCharacter.contains(input.charAt(right))) {
                uniqueCharacter.remove(input.charAt(left));
                left++;
            }
            uniqueCharacter.add(input.charAt(right));
            if (right - left + 1 > lengthOfTheSubString) {
                lengthOfTheSubString = right - left + 1;
                startIndex = left;
            }
        }
        String uniqueSubString = input.substring(startIndex, startIndex + lengthOfTheSubString);
        System.out.printf("Longest unique sub string %s of the String %s", uniqueSubString, input);
    }

    public static void main(String[] args) {
        removeDuplicateCharacter();
    }
}
