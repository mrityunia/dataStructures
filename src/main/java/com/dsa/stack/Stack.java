package com.dsa.stack;

import java.util.EmptyStackException;

/**
 * Stack Implementation using Array
 * This class provides a complete implementation of a stack with common operations.
 */
public class Stack<T> {
    
    private T[] elements;
    private int top;
    private static final int DEFAULT_CAPACITY = 10;
    
    /**
     * Constructor with default capacity
     */
    @SuppressWarnings("unchecked")
    public Stack() {
        this.elements = (T[]) new Object[DEFAULT_CAPACITY];
        this.top = -1;
    }
    
    /**
     * Constructor with custom capacity
     * @param capacity the initial capacity
     */
    @SuppressWarnings("unchecked")
    public Stack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        this.elements = (T[]) new Object[capacity];
        this.top = -1;
    }
    
    /**
     * Push an element onto the stack
     * @param element the element to push
     */
    public void push(T element) {
        if (top == elements.length - 1) {
            resize();
        }
        elements[++top] = element;
    }
    
    /**
     * Pop an element from the stack
     * @return the popped element
     * @throws EmptyStackException if stack is empty
     */
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T element = elements[top];
        elements[top--] = null; // Help with garbage collection
        return element;
    }
    
    /**
     * Peek at the top element without removing it
     * @return the top element
     * @throws EmptyStackException if stack is empty
     */
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elements[top];
    }
    
    /**
     * Check if stack is empty
     * @return true if empty, false otherwise
     */
    public boolean isEmpty() {
        return top == -1;
    }
    
    /**
     * Get the size of the stack
     * @return the number of elements in the stack
     */
    public int size() {
        return top + 1;
    }
    
    /**
     * Clear the stack
     */
    public void clear() {
        for (int i = 0; i <= top; i++) {
            elements[i] = null;
        }
        top = -1;
    }
    
    /**
     * Check if stack is full
     * @return true if full, false otherwise
     */
    public boolean isFull() {
        return top == elements.length - 1;
    }
    
    /**
     * Get the capacity of the stack
     * @return the capacity
     */
    public int capacity() {
        return elements.length;
    }
    
    /**
     * Resize the internal array when needed
     */
    @SuppressWarnings("unchecked")
    private void resize() {
        T[] newElements = (T[]) new Object[elements.length * 2];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        elements = newElements;
    }
    
    /**
     * Search for an element in the stack
     * @param element the element to search for
     * @return 1-based position from the top, -1 if not found
     */
    public int search(T element) {
        for (int i = top; i >= 0; i--) {
            if (elements[i].equals(element)) {
                return top - i + 1;
            }
        }
        return -1;
    }
    
    /**
     * Convert stack to array
     * @return array representation of the stack (top element at index 0)
     */
    public Object[] toArray() {
        Object[] array = new Object[size()];
        for (int i = 0; i <= top; i++) {
            array[top - i] = elements[i];
        }
        return array;
    }
    
    /**
     * Display the stack
     */
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        
        System.out.print("Stack (top to bottom): ");
        for (int i = top; i >= 0; i--) {
            System.out.print(elements[i]);
            if (i > 0) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }
    
    @Override
    public String toString() {
        if (isEmpty()) {
            return "Stack: []";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("Stack: [");
        
        for (int i = top; i >= 0; i--) {
            sb.append(elements[i]);
            if (i > 0) {
                sb.append(", ");
            }
        }
        sb.append("]");
        
        return sb.toString();
    }
} 