package com.dsa.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Binary Search Tree Implementation
 * This class provides a complete implementation of a binary search tree with common operations.
 */
public class BinarySearchTree<T extends Comparable<T>> {
    
    private Node<T> root;
    private int size;
    
    /**
     * Node class for Binary Search Tree
     */
    private static class Node<T> {
        T data;
        Node<T> left;
        Node<T> right;
        
        Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    /**
     * Constructor
     */
    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }
    
    /**
     * Insert a new element into the BST
     * @param data the data to insert
     */
    public void insert(T data) {
        root = insertRecursive(root, data);
        size++;
    }
    
    private Node<T> insertRecursive(Node<T> node, T data) {
        if (node == null) {
            return new Node<>(data);
        }
        
        if (data.compareTo(node.data) < 0) {
            node.left = insertRecursive(node.left, data);
        } else if (data.compareTo(node.data) > 0) {
            node.right = insertRecursive(node.right, data);
        }
        // If data is equal, we don't insert duplicates
        
        return node;
    }
    
    /**
     * Search for an element in the BST
     * @param data the data to search for
     * @return true if found, false otherwise
     */
    public boolean search(T data) {
        return searchRecursive(root, data);
    }
    
    private boolean searchRecursive(Node<T> node, T data) {
        if (node == null) {
            return false;
        }
        
        if (data.compareTo(node.data) == 0) {
            return true;
        } else if (data.compareTo(node.data) < 0) {
            return searchRecursive(node.left, data);
        } else {
            return searchRecursive(node.right, data);
        }
    }
    
    /**
     * Delete an element from the BST
     * @param data the data to delete
     */
    public void delete(T data) {
        root = deleteRecursive(root, data);
        size--;
    }
    
    private Node<T> deleteRecursive(Node<T> node, T data) {
        if (node == null) {
            return null;
        }
        
        if (data.compareTo(node.data) < 0) {
            node.left = deleteRecursive(node.left, data);
        } else if (data.compareTo(node.data) > 0) {
            node.right = deleteRecursive(node.right, data);
        } else {
            // Node to delete found
            
            // Case 1: Node is a leaf
            if (node.left == null && node.right == null) {
                return null;
            }
            // Case 2: Node has only one child
            else if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
            // Case 3: Node has two children
            else {
                // Find the inorder successor (smallest value in right subtree)
                Node<T> successor = findMin(node.right);
                node.data = successor.data;
                node.right = deleteRecursive(node.right, successor.data);
            }
        }
        
        return node;
    }
    
    private Node<T> findMin(Node<T> node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
    
    /**
     * Find the minimum value in the BST
     * @return the minimum value
     * @throws IllegalStateException if tree is empty
     */
    public T findMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Tree is empty");
        }
        return findMin(root).data;
    }
    
    /**
     * Find the maximum value in the BST
     * @return the maximum value
     * @throws IllegalStateException if tree is empty
     */
    public T findMax() {
        if (isEmpty()) {
            throw new IllegalStateException("Tree is empty");
        }
        return findMax(root).data;
    }
    
    private Node<T> findMax(Node<T> node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }
    
    /**
     * Inorder traversal (Left -> Root -> Right)
     * @return list of elements in inorder traversal
     */
    public List<T> inorderTraversal() {
        List<T> result = new ArrayList<>();
        inorderRecursive(root, result);
        return result;
    }
    
    private void inorderRecursive(Node<T> node, List<T> result) {
        if (node != null) {
            inorderRecursive(node.left, result);
            result.add(node.data);
            inorderRecursive(node.right, result);
        }
    }
    
    /**
     * Preorder traversal (Root -> Left -> Right)
     * @return list of elements in preorder traversal
     */
    public List<T> preorderTraversal() {
        List<T> result = new ArrayList<>();
        preorderRecursive(root, result);
        return result;
    }
    
    private void preorderRecursive(Node<T> node, List<T> result) {
        if (node != null) {
            result.add(node.data);
            preorderRecursive(node.left, result);
            preorderRecursive(node.right, result);
        }
    }
    
    /**
     * Postorder traversal (Left -> Right -> Root)
     * @return list of elements in postorder traversal
     */
    public List<T> postorderTraversal() {
        List<T> result = new ArrayList<>();
        postorderRecursive(root, result);
        return result;
    }
    
    private void postorderRecursive(Node<T> node, List<T> result) {
        if (node != null) {
            postorderRecursive(node.left, result);
            postorderRecursive(node.right, result);
            result.add(node.data);
        }
    }
    
    /**
     * Get the height of the tree
     * @return the height of the tree
     */
    public int getHeight() {
        return getHeightRecursive(root);
    }
    
    private int getHeightRecursive(Node<T> node) {
        if (node == null) {
            return -1;
        }
        
        int leftHeight = getHeightRecursive(node.left);
        int rightHeight = getHeightRecursive(node.right);
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
    
    /**
     * Get the number of nodes in the tree
     * @return the size of the tree
     */
    public int size() {
        return size;
    }
    
    /**
     * Check if the tree is empty
     * @return true if empty, false otherwise
     */
    public boolean isEmpty() {
        return root == null;
    }
    
    /**
     * Clear the tree
     */
    public void clear() {
        root = null;
        size = 0;
    }
    
    /**
     * Check if the tree is a valid BST
     * @return true if valid BST, false otherwise
     */
    public boolean isValidBST() {
        return isValidBSTRecursive(root, null, null);
    }
    
    private boolean isValidBSTRecursive(Node<T> node, T min, T max) {
        if (node == null) {
            return true;
        }
        
        if ((min != null && node.data.compareTo(min) <= 0) ||
            (max != null && node.data.compareTo(max) >= 0)) {
            return false;
        }
        
        return isValidBSTRecursive(node.left, min, node.data) &&
               isValidBSTRecursive(node.right, node.data, max);
    }
    
    /**
     * Get the kth smallest element in the BST
     * @param k the kth position (1-indexed)
     * @return the kth smallest element
     * @throws IllegalArgumentException if k is invalid
     */
    public T getKthSmallest(int k) {
        if (k < 1 || k > size) {
            throw new IllegalArgumentException("Invalid k value: " + k);
        }
        
        List<T> inorder = inorderTraversal();
        return inorder.get(k - 1);
    }
    
    /**
     * Get the kth largest element in the BST
     * @param k the kth position (1-indexed)
     * @return the kth largest element
     * @throws IllegalArgumentException if k is invalid
     */
    public T getKthLargest(int k) {
        if (k < 1 || k > size) {
            throw new IllegalArgumentException("Invalid k value: " + k);
        }
        
        List<T> inorder = inorderTraversal();
        return inorder.get(size - k);
    }
    
    /**
     * Print the tree structure
     */
    public void printTree() {
        if (isEmpty()) {
            System.out.println("Tree is empty");
            return;
        }
        
        System.out.println("Binary Search Tree:");
        printTreeRecursive(root, "", true);
    }
    
    private void printTreeRecursive(Node<T> node, String prefix, boolean isLeft) {
        if (node != null) {
            System.out.println(prefix + (isLeft ? "└── " : "┌── ") + node.data);
            printTreeRecursive(node.left, prefix + (isLeft ? "    " : "│   "), true);
            printTreeRecursive(node.right, prefix + (isLeft ? "    " : "│   "), false);
        }
    }
    
    @Override
    public String toString() {
        if (isEmpty()) {
            return "BinarySearchTree: []";
        }
        
        List<T> inorder = inorderTraversal();
        return "BinarySearchTree: " + inorder.toString();
    }
} 