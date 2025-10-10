package com.dsa.TestString;

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

    public static void main(String[] args) {
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
}

