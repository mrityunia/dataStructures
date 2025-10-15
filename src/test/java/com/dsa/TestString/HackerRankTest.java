package com.dsa.TestString;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HackerRankTest {

    /**
     * Compares two strings lexicographically without using built-in compareTo method
     * @param str1 First string
     * @param str2 Second string
     * @return negative value if str1 < str2, 0 if equal, positive value if str1 > str2
     */
    public static int lexicographicalCompare(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int minLength = Math.min(len1, len2);
        
        // Compare characters up to the minimum length
        for (int i = 0; i < minLength; i++) {
            char char1 = str1.charAt(i);
            char char2 = str2.charAt(i);
            
            if (char1 != char2) {
                return char1 - char2;
            }
        }
        
        // If all characters are equal up to minLength, compare lengths
        return len1 - len2;
    }

    public static void asdasd(String[] args) {
        // Test cases for lexicographical comparison
        String[] testCases = {
            "java", "java",     // Equal strings
            "apple", "banana",  // Different strings  
            "cat", "cats",      // One is prefix of other
            "cats", "cat",      // Reverse case
            "a", "z",           // Single characters
            "hello", "world",   // Different lengths
            "abc", "abcd",      // One is prefix
            "xyz", "abc"        // Different starting characters
        };
        
        System.out.println("Lexicographical Comparison Results:");
        System.out.println("=====================================");
        
        for (int i = 0; i < testCases.length; i += 2) {
            String str1 = testCases[i];
            String str2 = testCases[i + 1];
            
            int result = lexicographicalCompare(str1, str2);
            
            System.out.printf("Comparing '%s' and '%s':\n", str1, str2);
            System.out.printf("  Result: %d (negative=first smaller, 0=equal, positive=first larger)\n", result);
            
            // Original logic interpretation
            if (result <= 0) {
                System.out.println("  Output: No");
            } else {
                System.out.println("  Output: Yes");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        //System.out.println(getSmallestAndLargest("welcometojava", 3));
        verifySplit();
    }
    public static String getSmallestAndLargest(String s, int k) {

        String [] aa = new String[s.length()-k+1];
        for(int i = 0; i <=s.length()- k; i++) {
            aa[i]= s.substring(i, k+i);
        }
        for(int j=0; j < aa.length -1 ; j++){
            for (int i=0; i<aa.length - j -1 ;i++){
                int order = aa[i].compareTo(aa[i+1]);
                if (order > 0) {
                    String temp = aa[i];
                    aa[i] = aa[i+1];
                    aa[i+1] = temp;

                }
            }
        }

        String smallest = aa[0];
        String largest = aa[aa.length-1];



        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'

        return smallest + "\n" + largest;

    }

    public  static void StringReverse() {
        String A = "madam";
        String palam = "";
        for (int i= A.length()-1; i>=0 ; i--) {
            palam = palam + A.charAt(i);
        }
        if (palam.equals(A))
            System.out.println("Yes");
        else
            System.out.println("No");


        String B = A.chars().
                mapToObj(a->(char)a)
                        .reduce("", (s,a)->a+s, (s1,s2)->s1+s2);

        String LL = A.chars()
                .mapToObj(c -> (char) c)
                .reduce("", (s, c) -> c + s, (s1, s2) -> s2 + s1);
        System.out.println(B);
    }

    public static void verifyAnagrams() {
        String a = "CAT";
        String b = "tac";

        boolean isAnagram;
        if (a.length() == b.length()) {
            int aAsciSum  = a.toLowerCase().chars().mapToObj(res -> (int )res).reduce(0,(r,s)->r+s);
            System.out.println(aAsciSum);
            int bAsciSum = b.toLowerCase().chars().reduce(0, (res, num) -> res + num);
            if (aAsciSum == bAsciSum) {
                isAnagram = true;
            }
        }
    }

    public static void verifyAnagramUsingBinarySorting() {
        String input = "madam";
        char []  beforeSorting = input.toLowerCase().toCharArray();
        for (int a = 0; a < beforeSorting.length; a++) {
            for (int b  = 0; b < beforeSorting.length -1 - a ; b++) {
                if (beforeSorting[b] > beforeSorting [b + 1]) {
                    char temp = beforeSorting [b +1];
                    beforeSorting [b +1] = beforeSorting [b];
                    beforeSorting [b] =  temp;
                }
            }
        }


    }

    public static void verifySplit() {
        String s = "           ";
        String [] tokenArray =  s.trim().isEmpty() ? new String[0] : s.trim().split("[ !,?._'@]+");
        System.out.println(tokenArray.length);
        for(int a = 0; a< tokenArray.length; a++) {
            System.out.println(tokenArray[a]);
        }
    }
}

