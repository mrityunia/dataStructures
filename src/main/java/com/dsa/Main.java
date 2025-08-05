package com.dsa;

import com.dsa.arrays.ArrayOperations;
import com.dsa.linkedlist.LinkedList;
import com.dsa.stack.Stack;
import com.dsa.queue.Queue;
import com.dsa.tree.BinarySearchTree;
import com.dsa.hashtable.HashTable;

import java.util.Arrays;
import java.util.List;

/**
 * Main class demonstrating Data Structures and Algorithms in Java
 * This class provides comprehensive examples of all implemented data structures and algorithms.
 */
public class Main {
    
    public static void main(String[] args) {
        System.out.println("=== Data Structures and Algorithms in Java ===\n");
        
        // Demonstrate Array Operations
        demonstrateArrayOperations();
        
        // Demonstrate Linked List
        demonstrateLinkedList();
        
        // Demonstrate Stack
        demonstrateStack();
        
        // Demonstrate Queue
        demonstrateQueue();
        
        // Demonstrate Binary Search Tree
        demonstrateBinarySearchTree();
        
        // Demonstrate Hash Table
        demonstrateHashTable();
        
        System.out.println("\n=== All demonstrations completed successfully! ===");
    }
    
    /**
     * Demonstrate Array Operations and Algorithms
     */
    private static void demonstrateArrayOperations() {
        System.out.println("1. ARRAY OPERATIONS AND ALGORITHMS");
        System.out.println("==================================");
        
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original array: " + Arrays.toString(arr));
        
        // Linear Search
        int target = 22;
        int linearSearchResult = ArrayOperations.linearSearch(arr, target);
        System.out.println("Linear search for " + target + ": " + 
                          (linearSearchResult != -1 ? "Found at index " + linearSearchResult : "Not found"));
        
        // Sorting algorithms
        int[] arrCopy = Arrays.copyOf(arr, arr.length);
        ArrayOperations.bubbleSort(arrCopy);
        System.out.println("After bubble sort: " + Arrays.toString(arrCopy));
        
        arrCopy = Arrays.copyOf(arr, arr.length);
        ArrayOperations.selectionSort(arrCopy);
        System.out.println("After selection sort: " + Arrays.toString(arrCopy));
        
        arrCopy = Arrays.copyOf(arr, arr.length);
        ArrayOperations.insertionSort(arrCopy);
        System.out.println("After insertion sort: " + Arrays.toString(arrCopy));
        
        arrCopy = Arrays.copyOf(arr, arr.length);
        ArrayOperations.mergeSort(arrCopy);
        System.out.println("After merge sort: " + Arrays.toString(arrCopy));
        
        arrCopy = Arrays.copyOf(arr, arr.length);
        ArrayOperations.quickSort(arrCopy);
        System.out.println("After quick sort: " + Arrays.toString(arrCopy));
        
        // Binary Search (requires sorted array)
        int binarySearchResult = ArrayOperations.binarySearch(arrCopy, target);
        System.out.println("Binary search for " + target + " in sorted array: " + 
                          (binarySearchResult != -1 ? "Found at index " + binarySearchResult : "Not found"));
        
        // Other operations
        System.out.println("Maximum element: " + ArrayOperations.findMax(arr));
        System.out.println("Minimum element: " + ArrayOperations.findMin(arr));
        System.out.println("Second largest element: " + ArrayOperations.findSecondLargest(arr));
        
        ArrayOperations.reverse(arrCopy);
        System.out.println("Reversed array: " + Arrays.toString(arrCopy));
        
        System.out.println("Is sorted: " + ArrayOperations.isSorted(arrCopy));
        
        int[] sortedArr = {1, 1, 2, 2, 2, 3, 4, 4, 5};
        int[] uniqueArr = ArrayOperations.removeDuplicates(sortedArr);
        System.out.println("Array after removing duplicates: " + Arrays.toString(uniqueArr));
        
        System.out.println();
    }
    
    /**
     * Demonstrate Linked List Operations
     */
    private static void demonstrateLinkedList() {
        System.out.println("2. LINKED LIST OPERATIONS");
        System.out.println("=========================");
        
        LinkedList<Integer> list = new LinkedList<>();
        
        // Add elements
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addFirst(5);
        list.addAt(15, 2);
        
        System.out.println("Linked List after adding elements:");
        list.display();
        
        // Get and set elements
        System.out.println("Element at index 2: " + list.get(2));
        list.set(25, 2);
        System.out.println("After setting element at index 2 to 25:");
        list.display();
        
        // Search operations
        System.out.println("Contains 20: " + list.contains(20));
        System.out.println("Index of 30: " + list.indexOf(30));
        
        // Remove operations
        System.out.println("Removed first: " + list.removeFirst());
        System.out.println("Removed last: " + list.removeLast());
        System.out.println("Removed at index 1: " + list.removeAt(1));
        list.display();
        
        // Add more elements for demonstration
        list.addLast(40);
        list.addLast(50);
        list.addLast(60);
        list.display();
        
        // Find middle element
        System.out.println("Middle element: " + list.findMiddle());
        
        // Reverse the list
        list.reverse();
        System.out.println("After reversing:");
        list.display();
        
        // Remove duplicates (for sorted list)
        LinkedList<Integer> sortedList = new LinkedList<>();
        sortedList.addLast(1);
        sortedList.addLast(1);
        sortedList.addLast(2);
        sortedList.addLast(2);
        sortedList.addLast(3);
        sortedList.removeDuplicates();
        System.out.println("Sorted list after removing duplicates:");
        sortedList.display();
        
        System.out.println();
    }
    
    /**
     * Demonstrate Stack Operations
     */
    private static void demonstrateStack() {
        System.out.println("3. STACK OPERATIONS");
        System.out.println("===================");
        
        Stack<String> stack = new Stack<>();
        
        // Push elements
        stack.push("First");
        stack.push("Second");
        stack.push("Third");
        stack.push("Fourth");
        
        System.out.println("Stack after pushing elements:");
        stack.display();
        
        // Peek and pop operations
        System.out.println("Peek: " + stack.peek());
        System.out.println("Pop: " + stack.pop());
        System.out.println("After popping:");
        stack.display();
        
        // Search operation
        System.out.println("Position of 'Second' from top: " + stack.search("Second"));
        
        // Stack properties
        System.out.println("Size: " + stack.size());
        System.out.println("Is empty: " + stack.isEmpty());
        System.out.println("Is full: " + stack.isFull());
        
        // Convert to array
        Object[] stackArray = stack.toArray();
        System.out.println("Stack as array: " + Arrays.toString(stackArray));
        
        // Clear stack
        stack.clear();
        System.out.println("After clearing:");
        stack.display();
        
        System.out.println();
    }
    
    /**
     * Demonstrate Queue Operations
     */
    private static void demonstrateQueue() {
        System.out.println("4. QUEUE OPERATIONS");
        System.out.println("===================");
        
        Queue<Integer> queue = new Queue<>();
        
        // Enqueue elements
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        
        System.out.println("Queue after enqueuing elements:");
        queue.display();
        
        // Peek operations
        System.out.println("Front element: " + queue.peek());
        System.out.println("Rear element: " + queue.peekRear());
        
        // Dequeue operations
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("After dequeuing:");
        queue.display();
        
        // Search operation
        System.out.println("Position of 40 from front: " + queue.search(40));
        System.out.println("Contains 30: " + queue.contains(30));
        
        // Queue properties
        System.out.println("Size: " + queue.size());
        System.out.println("Is empty: " + queue.isEmpty());
        System.out.println("Is full: " + queue.isFull());
        
        // Convert to array
        Object[] queueArray = queue.toArray();
        System.out.println("Queue as array: " + Arrays.toString(queueArray));
        
        // Clear queue
        queue.clear();
        System.out.println("After clearing:");
        queue.display();
        
        System.out.println();
    }
    
    /**
     * Demonstrate Binary Search Tree Operations
     */
    private static void demonstrateBinarySearchTree() {
        System.out.println("5. BINARY SEARCH TREE OPERATIONS");
        System.out.println("================================");
        
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        
        // Insert elements
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);
        
        System.out.println("Binary Search Tree after inserting elements:");
        bst.printTree();
        
        // Traversal operations
        List<Integer> inorder = bst.inorderTraversal();
        System.out.println("Inorder traversal: " + inorder);
        
        List<Integer> preorder = bst.preorderTraversal();
        System.out.println("Preorder traversal: " + preorder);
        
        List<Integer> postorder = bst.postorderTraversal();
        System.out.println("Postorder traversal: " + postorder);
        
        // Search operations
        System.out.println("Contains 40: " + bst.search(40));
        System.out.println("Contains 90: " + bst.search(90));
        
        // Min and Max
        System.out.println("Minimum value: " + bst.findMin());
        System.out.println("Maximum value: " + bst.findMax());
        
        // Kth smallest and largest
        System.out.println("3rd smallest element: " + bst.getKthSmallest(3));
        System.out.println("2nd largest element: " + bst.getKthLargest(2));
        
        // Tree properties
        System.out.println("Height: " + bst.getHeight());
        System.out.println("Size: " + bst.size());
        System.out.println("Is valid BST: " + bst.isValidBST());
        
        // Delete operation
        bst.delete(30);
        System.out.println("After deleting 30:");
        bst.printTree();
        
        System.out.println();
    }
    
    /**
     * Demonstrate Hash Table Operations
     */
    private static void demonstrateHashTable() {
        System.out.println("6. HASH TABLE OPERATIONS");
        System.out.println("========================");
        
        HashTable<String, Integer> hashTable = new HashTable<>();
        
        // Put operations
        hashTable.put("apple", 1);
        hashTable.put("banana", 2);
        hashTable.put("cherry", 3);
        hashTable.put("date", 4);
        hashTable.put("elderberry", 5);
        
        System.out.println("Hash Table after putting elements:");
        hashTable.display();
        
        // Get operations
        System.out.println("Value for 'banana': " + hashTable.get("banana"));
        System.out.println("Value for 'grape': " + hashTable.get("grape"));
        
        // Contains operations
        System.out.println("Contains key 'cherry': " + hashTable.containsKey("cherry"));
        System.out.println("Contains value 3: " + hashTable.containsValue(3));
        
        // Update operation
        hashTable.put("banana", 20);
        System.out.println("After updating 'banana' to 20:");
        hashTable.display();
        
        // Remove operation
        Integer removed = hashTable.remove("date");
        System.out.println("Removed 'date': " + removed);
        hashTable.display();
        
        // Get all keys and values
        System.out.println("All keys: " + hashTable.keySet());
        System.out.println("All values: " + hashTable.values());
        
        // Hash table properties
        System.out.println("Size: " + hashTable.size());
        System.out.println("Capacity: " + hashTable.capacity());
        System.out.println("Load factor: " + String.format("%.2f", hashTable.getLoadFactor()));
        System.out.println("Collision count: " + hashTable.getCollisionCount());
        System.out.println("Longest chain length: " + hashTable.getLongestChainLength());
        
        // Clear hash table
        hashTable.clear();
        System.out.println("After clearing:");
        hashTable.display();
        
        System.out.println();
    }
} 