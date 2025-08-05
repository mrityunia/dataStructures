package com.dsa.linkedlist;

/**
 * Singly Linked List Implementation
 * This class provides a complete implementation of a singly linked list with common operations.
 */
public class LinkedList<T> {
    
    private Node<T> head;
    private int size;
    
    /**
     * Node class for LinkedList
     */
    private static class Node<T> {
        T data;
        Node<T> next;
        
        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
    
    /**
     * Constructor
     */
    public LinkedList() {
        this.head = null;
        this.size = 0;
    }
    
    /**
     * Add element at the beginning of the list
     * @param data the data to add
     */
    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
        size++;
    }
    
    /**
     * Add element at the end of the list
     * @param data the data to add
     */
    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }
    
    /**
     * Add element at a specific position
     * @param data the data to add
     * @param position the position (0-indexed)
     */
    public void addAt(T data, int position) {
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException("Position: " + position + ", Size: " + size);
        }
        
        if (position == 0) {
            addFirst(data);
            return;
        }
        
        Node<T> newNode = new Node<>(data);
        Node<T> current = head;
        
        for (int i = 0; i < position - 1; i++) {
            current = current.next;
        }
        
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }
    
    /**
     * Remove first element
     * @return the removed element
     */
    public T removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        
        T data = head.data;
        head = head.next;
        size--;
        return data;
    }
    
    /**
     * Remove last element
     * @return the removed element
     */
    public T removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        
        if (size == 1) {
            T data = head.data;
            head = null;
            size--;
            return data;
        }
        
        Node<T> current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        
        T data = current.next.data;
        current.next = null;
        size--;
        return data;
    }
    
    /**
     * Remove element at specific position
     * @param position the position (0-indexed)
     * @return the removed element
     */
    public T removeAt(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Position: " + position + ", Size: " + size);
        }
        
        if (position == 0) {
            return removeFirst();
        }
        
        Node<T> current = head;
        for (int i = 0; i < position - 1; i++) {
            current = current.next;
        }
        
        T data = current.next.data;
        current.next = current.next.next;
        size--;
        return data;
    }
    
    /**
     * Get element at specific position
     * @param position the position (0-indexed)
     * @return the element at the position
     */
    public T get(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Position: " + position + ", Size: " + size);
        }
        
        Node<T> current = head;
        for (int i = 0; i < position; i++) {
            current = current.next;
        }
        
        return current.data;
    }
    
    /**
     * Set element at specific position
     * @param data the new data
     * @param position the position (0-indexed)
     */
    public void set(T data, int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Position: " + position + ", Size: " + size);
        }
        
        Node<T> current = head;
        for (int i = 0; i < position; i++) {
            current = current.next;
        }
        
        current.data = data;
    }
    
    /**
     * Check if list contains an element
     * @param data the data to search for
     * @return true if found, false otherwise
     */
    public boolean contains(T data) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    /**
     * Find index of an element
     * @param data the data to search for
     * @return index of the element, -1 if not found
     */
    public int indexOf(T data) {
        Node<T> current = head;
        int index = 0;
        
        while (current != null) {
            if (current.data.equals(data)) {
                return index;
            }
            current = current.next;
            index++;
        }
        
        return -1;
    }
    
    /**
     * Clear the list
     */
    public void clear() {
        head = null;
        size = 0;
    }
    
    /**
     * Check if list is empty
     * @return true if empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * Get the size of the list
     * @return the size
     */
    public int size() {
        return size;
    }
    
    /**
     * Reverse the linked list
     */
    public void reverse() {
        Node<T> prev = null;
        Node<T> current = head;
        Node<T> next = null;
        
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        head = prev;
    }
    
    /**
     * Find the middle element of the list
     * @return the middle element
     */
    public T findMiddle() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        
        Node<T> slow = head;
        Node<T> fast = head;
        
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow.data;
    }
    
    /**
     * Detect if there is a cycle in the linked list
     * @return true if cycle exists, false otherwise
     */
    public boolean hasCycle() {
        if (head == null || head.next == null) {
            return false;
        }
        
        Node<T> slow = head;
        Node<T> fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * Remove duplicates from sorted linked list
     */
    public void removeDuplicates() {
        if (head == null || head.next == null) {
            return;
        }
        
        Node<T> current = head;
        while (current.next != null) {
            if (current.data.equals(current.next.data)) {
                current.next = current.next.next;
                size--;
            } else {
                current = current.next;
            }
        }
    }
    
    /**
     * Convert list to array
     * @return array representation of the list
     */
    public Object[] toArray() {
        Object[] array = new Object[size];
        Node<T> current = head;
        int index = 0;
        
        while (current != null) {
            array[index++] = current.data;
            current = current.next;
        }
        
        return array;
    }
    
    /**
     * Display the linked list
     */
    public void display() {
        Node<T> current = head;
        System.out.print("LinkedList: ");
        
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LinkedList: ");
        
        Node<T> current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }
        
        return sb.toString();
    }
} 