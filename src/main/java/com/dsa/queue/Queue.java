package com.dsa.queue;

import java.util.NoSuchElementException;

/**
 * Queue Implementation using Array
 * This class provides a complete implementation of a queue with common operations.
 */
public class Queue<T> {
    
    private T[] elements;
    private int front;
    private int rear;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    
    /**
     * Constructor with default capacity
     */
    @SuppressWarnings("unchecked")
    public Queue() {
        this.elements = (T[]) new Object[DEFAULT_CAPACITY];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }
    
    /**
     * Constructor with custom capacity
     * @param capacity the initial capacity
     */
    @SuppressWarnings("unchecked")
    public Queue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        this.elements = (T[]) new Object[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }
    
    /**
     * Add an element to the rear of the queue
     * @param element the element to add
     */
    public void enqueue(T element) {
        if (size == elements.length) {
            resize();
        }
        
        rear = (rear + 1) % elements.length;
        elements[rear] = element;
        size++;
    }
    
    /**
     * Remove and return the element from the front of the queue
     * @return the removed element
     * @throws NoSuchElementException if queue is empty
     */
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        
        T element = elements[front];
        elements[front] = null; // Help with garbage collection
        front = (front + 1) % elements.length;
        size--;
        
        return element;
    }
    
    /**
     * Peek at the front element without removing it
     * @return the front element
     * @throws NoSuchElementException if queue is empty
     */
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return elements[front];
    }
    
    /**
     * Peek at the rear element without removing it
     * @return the rear element
     * @throws NoSuchElementException if queue is empty
     */
    public T peekRear() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return elements[rear];
    }
    
    /**
     * Check if queue is empty
     * @return true if empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * Check if queue is full
     * @return true if full, false otherwise
     */
    public boolean isFull() {
        return size == elements.length;
    }
    
    /**
     * Get the size of the queue
     * @return the number of elements in the queue
     */
    public int size() {
        return size;
    }
    
    /**
     * Get the capacity of the queue
     * @return the capacity
     */
    public int capacity() {
        return elements.length;
    }
    
    /**
     * Clear the queue
     */
    public void clear() {
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
        }
        front = 0;
        rear = -1;
        size = 0;
    }
    
    /**
     * Resize the internal array when needed
     */
    @SuppressWarnings("unchecked")
    private void resize() {
        T[] newElements = (T[]) new Object[elements.length * 2];
        
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[(front + i) % elements.length];
        }
        
        elements = newElements;
        front = 0;
        rear = size - 1;
    }
    
    /**
     * Search for an element in the queue
     * @param element the element to search for
     * @return 1-based position from the front, -1 if not found
     */
    public int search(T element) {
        for (int i = 0; i < size; i++) {
            int index = (front + i) % elements.length;
            if (elements[index].equals(element)) {
                return i + 1;
            }
        }
        return -1;
    }
    
    /**
     * Check if queue contains an element
     * @param element the element to check
     * @return true if found, false otherwise
     */
    public boolean contains(T element) {
        return search(element) != -1;
    }
    
    /**
     * Convert queue to array
     * @return array representation of the queue
     */
    public Object[] toArray() {
        Object[] array = new Object[size];
        for (int i = 0; i < size; i++) {
            array[i] = elements[(front + i) % elements.length];
        }
        return array;
    }
    
    /**
     * Display the queue
     */
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        
        System.out.print("Queue (front to rear): ");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % elements.length;
            System.out.print(elements[index]);
            if (i < size - 1) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }
    
    @Override
    public String toString() {
        if (isEmpty()) {
            return "Queue: []";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("Queue: [");
        
        for (int i = 0; i < size; i++) {
            int index = (front + i) % elements.length;
            sb.append(elements[index]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        
        return sb.toString();
    }
} 