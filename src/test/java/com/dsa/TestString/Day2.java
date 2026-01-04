package com.dsa.TestString;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day2 {

    public static void main(String [] arg) {
        findAnagrams2();
    }
    public static void reverseString() {
        String input = "hello";
        char [] chars =  input.toCharArray();
        int start = 0;
        int end = input.length() - 1;
        while (start < end) {
            char a = chars[start];
            chars[start++] = chars[end];
            chars[end--] = a;
        }
        String reverseString = new String(chars);

        System.out.printf(" reverse String is %s", reverseString);
        "hello".chars()
                .mapToObj(a -> String.valueOf((char)a))
                .reduce("", (a,b) -> b +a);
    }

    public static void longestUniqueSubstring() {
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

    public static void sumOfList() {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        int sum = list.stream().reduce(0,(a,b)->a+b);
        System.out.printf("Sum of the list is %d ", sum);
    }

    public static void findAnagrams() {
        String string = "listen";
        String string1 = "silent";
        if (string1.length() == string.length() && !string1.isEmpty() && !string.isEmpty()) {

            String reverString = string1.chars()
                    .mapToObj(c -> String.valueOf((char) c))
                    .sorted()
                    .collect(Collectors.joining());
            String reverseString2 = string.chars()
                    .mapToObj(a-> String.valueOf((char) a))
                    .sorted()
                    .collect(Collectors.joining());
            if (reverString.equals(reverseString2)){

                System.out.println("Anagrams");
            }
            else {
                System.out.println("not Anagrams");
            }
        }
        else {
            System.out.println("not Anagrams");
        }
    }
    public static void findAnagrams2() {
        String s1 = "llsten";
        String s2 = "sllent";

        // Debug 1: Length check
        System.out.println("Lengths: s1=" + s1.length() + ", s2=" + s2.length());
        if (s1.length() != s2.length()) {
            System.out.println("Not Anagrams");
            return;
        }

        int[] freq = new int[26];
        System.out.println("Initial freq array: " + java.util.Arrays.toString(freq));

        // Debug 2: s1 processing
        System.out.println("\n--- Processing s1: " + s1 + " ---");
        for (char c : s1.toCharArray()) {
            int index = c - 'a';
            freq[index]++;
            System.out.printf("char '%c' (index %d): freq[%d] = %d%n", c, index, index, freq[index]);
        }
        System.out.println("After s1: " + java.util.Arrays.toString(freq));

        // Debug 3: s2 processing
        System.out.println("\n--- Processing s2: " + s2 + " ---");
        for (char c : s2.toCharArray()) {
            int index = c - 'a';
            freq[index]--;
            System.out.printf("char '%c' (index %d): freq[%d] = %d%n", c, index, index, freq[index]);
        }
        System.out.println("After s2: " + java.util.Arrays.toString(freq));

        // Debug 4: Check non-zero
        System.out.println("\n--- Checking for non-zero ---");
        boolean isAnagram = true;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) {
                System.out.printf("Non-zero at index %d: freq[%d] = %d%n", i, i, freq[i]);
                isAnagram = false;
                break;
            }
        }

        if (isAnagram) {
            System.out.println("Anagrams");
        } else {
            System.out.println("Not Anagrams");
        }
    }


}
