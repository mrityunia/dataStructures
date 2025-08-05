package com.dsa.arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

/**
 * Unit tests for ArrayOperations class
 */
public class ArrayOperationsTest {
    
    private int[] testArray;
    private int[] sortedArray;
    
    @BeforeEach
    void setUp() {
        testArray = new int[]{64, 34, 25, 12, 22, 11, 90};
        sortedArray = new int[]{11, 12, 22, 25, 34, 64, 90};
    }
    
    @Test
    void testLinearSearch() {
        assertEquals(4, ArrayOperations.linearSearch(testArray, 22));
        assertEquals(0, ArrayOperations.linearSearch(testArray, 64));
        assertEquals(6, ArrayOperations.linearSearch(testArray, 90));
        assertEquals(-1, ArrayOperations.linearSearch(testArray, 100));
    }
    
    @Test
    void testBinarySearch() {
        assertEquals(2, ArrayOperations.binarySearch(sortedArray, 22));
        assertEquals(0, ArrayOperations.binarySearch(sortedArray, 11));
        assertEquals(6, ArrayOperations.binarySearch(sortedArray, 90));
        assertEquals(-1, ArrayOperations.binarySearch(sortedArray, 100));
    }
    
    @Test
    void testBubbleSort() {
        int[] arr = Arrays.copyOf(testArray, testArray.length);
        ArrayOperations.bubbleSort(arr);
        assertArrayEquals(sortedArray, arr);
    }
    
    @Test
    void testSelectionSort() {
        int[] arr = Arrays.copyOf(testArray, testArray.length);
        ArrayOperations.selectionSort(arr);
        assertArrayEquals(sortedArray, arr);
    }
    
    @Test
    void testInsertionSort() {
        int[] arr = Arrays.copyOf(testArray, testArray.length);
        ArrayOperations.insertionSort(arr);
        assertArrayEquals(sortedArray, arr);
    }
    
    @Test
    void testMergeSort() {
        int[] arr = Arrays.copyOf(testArray, testArray.length);
        ArrayOperations.mergeSort(arr);
        assertArrayEquals(sortedArray, arr);
    }
    
    @Test
    void testQuickSort() {
        int[] arr = Arrays.copyOf(testArray, testArray.length);
        ArrayOperations.quickSort(arr);
        assertArrayEquals(sortedArray, arr);
    }
    
    @Test
    void testFindMax() {
        assertEquals(90, ArrayOperations.findMax(testArray));
    }
    
    @Test
    void testFindMin() {
        assertEquals(11, ArrayOperations.findMin(testArray));
    }
    
    @Test
    void testFindSecondLargest() {
        assertEquals(64, ArrayOperations.findSecondLargest(testArray));
    }
    
    @Test
    void testReverse() {
        int[] arr = Arrays.copyOf(testArray, testArray.length);
        ArrayOperations.reverse(arr);
        int[] expected = {90, 11, 22, 12, 25, 34, 64};
        assertArrayEquals(expected, arr);
    }
    
    @Test
    void testIsSorted() {
        assertFalse(ArrayOperations.isSorted(testArray));
        assertTrue(ArrayOperations.isSorted(sortedArray));
    }
    
    @Test
    void testRemoveDuplicates() {
        int[] arrWithDuplicates = {1, 1, 2, 2, 2, 3, 4, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        int[] result = ArrayOperations.removeDuplicates(arrWithDuplicates);
        assertArrayEquals(expected, result);
    }
    
    @Test
    void testFindMaxEmptyArray() {
        assertThrows(IllegalArgumentException.class, () -> {
            ArrayOperations.findMax(new int[]{});
        });
    }
    
    @Test
    void testFindMinEmptyArray() {
        assertThrows(IllegalArgumentException.class, () -> {
            ArrayOperations.findMin(new int[]{});
        });
    }
    
    @Test
    void testFindSecondLargestInsufficientElements() {
        assertThrows(IllegalArgumentException.class, () -> {
            ArrayOperations.findSecondLargest(new int[]{1});
        });
    }
} 