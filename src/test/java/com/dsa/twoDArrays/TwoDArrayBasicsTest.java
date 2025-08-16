package com.dsa.twoDArrays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Basic test class for TwoDArrayBasics
 */
public class TwoDArrayBasicsTest {
    
    @Test
    public void testCreateSequentialArray() {
        int[][] arr = TwoDArrayBasics.createSequentialArray(3, 3);
        assertEquals(3, arr.length);
        assertEquals(3, arr[0].length);
        assertEquals(1, arr[0][0]);
        assertEquals(9, arr[2][2]);
    }
    
    @Test
    public void testSumOfElements() {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        assertEquals(45, TwoDArrayBasics.sumOfElements(arr));
    }
    
    @Test
    public void testFindMax() {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        assertEquals(9, TwoDArrayBasics.findMax(arr));
    }
    
    @Test
    public void testFindMin() {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        assertEquals(1, TwoDArrayBasics.findMin(arr));
    }
    
    @Test
    public void testIsSquareMatrix() {
        int[][] squareArr = {{1, 2}, {3, 4}};
        int[][] nonSquareArr = {{1, 2, 3}, {4, 5, 6}};
        
        assertTrue(TwoDArrayBasics.isSquareMatrix(squareArr));
        assertFalse(TwoDArrayBasics.isSquareMatrix(nonSquareArr));
    }
    
    @Test
    public void testSumOfRow() {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        assertEquals(6, TwoDArrayBasics.sumOfRow(arr, 0));
        assertEquals(15, TwoDArrayBasics.sumOfRow(arr, 1));
        assertEquals(24, TwoDArrayBasics.sumOfRow(arr, 2));
    }
    
    @Test
    public void testSumOfColumn() {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        assertEquals(12, TwoDArrayBasics.sumOfColumn(arr, 0));
        assertEquals(15, TwoDArrayBasics.sumOfColumn(arr, 1));
        assertEquals(18, TwoDArrayBasics.sumOfColumn(arr, 2));
    }
    
    @Test
    public void testContainsElement() {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        assertTrue(TwoDArrayBasics.containsElement(arr, 5));
        assertFalse(TwoDArrayBasics.containsElement(arr, 10));
    }
    
    @Test
    public void testFindElementPosition() {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] position = TwoDArrayBasics.findElementPosition(arr, 5);
        assertNotNull(position);
        assertEquals(1, position[0]);
        assertEquals(1, position[1]);
    }
}
