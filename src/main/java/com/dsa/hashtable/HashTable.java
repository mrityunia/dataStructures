package com.dsa.hashtable;

import java.util.ArrayList;
import java.util.List;

/**
 * Hash Table Implementation using Chaining for collision resolution
 * This class provides a complete implementation of a hash table with common operations.
 */
public class HashTable<K, V> {
    
    private static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;
        
        Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
    
    private Entry<K, V>[] table;
    private int size;
    private static final int DEFAULT_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;
    
    /**
     * Constructor with default capacity
     */
    @SuppressWarnings("unchecked")
    public HashTable() {
        this.table = new Entry[DEFAULT_CAPACITY];
        this.size = 0;
    }
    
    /**
     * Constructor with custom capacity
     * @param capacity the initial capacity
     */
    @SuppressWarnings("unchecked")
    public HashTable(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        this.table = new Entry[capacity];
        this.size = 0;
    }
    
    /**
     * Put a key-value pair into the hash table
     * @param key the key
     * @param value the value
     * @return the previous value associated with the key, or null if none
     */
    public V put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        
        if ((double) size / table.length >= LOAD_FACTOR) {
            resize();
        }
        
        int index = hash(key);
        Entry<K, V> current = table[index];
        
        // Check if key already exists
        while (current != null) {
            if (current.key.equals(key)) {
                V oldValue = current.value;
                current.value = value;
                return oldValue;
            }
            current = current.next;
        }
        
        // Add new entry at the beginning of the chain
        Entry<K, V> newEntry = new Entry<>(key, value);
        newEntry.next = table[index];
        table[index] = newEntry;
        size++;
        
        return null;
    }
    
    /**
     * Get the value associated with a key
     * @param key the key
     * @return the value associated with the key, or null if not found
     */
    public V get(K key) {
        if (key == null) {
            return null;
        }
        
        int index = hash(key);
        Entry<K, V> current = table[index];
        
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        
        return null;
    }
    
    /**
     * Remove a key-value pair from the hash table
     * @param key the key to remove
     * @return the value associated with the key, or null if not found
     */
    public V remove(K key) {
        if (key == null) {
            return null;
        }
        
        int index = hash(key);
        Entry<K, V> current = table[index];
        Entry<K, V> prev = null;
        
        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    table[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return current.value;
            }
            prev = current;
            current = current.next;
        }
        
        return null;
    }
    
    /**
     * Check if the hash table contains a key
     * @param key the key to check
     * @return true if the key exists, false otherwise
     */
    public boolean containsKey(K key) {
        return get(key) != null;
    }
    
    /**
     * Check if the hash table contains a value
     * @param value the value to check
     * @return true if the value exists, false otherwise
     */
    public boolean containsValue(V value) {
        for (Entry<K, V> entry : table) {
            Entry<K, V> current = entry;
            while (current != null) {
                if ((value == null && current.value == null) ||
                    (value != null && value.equals(current.value))) {
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }
    
    /**
     * Get all keys in the hash table
     * @return list of all keys
     */
    public List<K> keySet() {
        List<K> keys = new ArrayList<>();
        for (Entry<K, V> entry : table) {
            Entry<K, V> current = entry;
            while (current != null) {
                keys.add(current.key);
                current = current.next;
            }
        }
        return keys;
    }
    
    /**
     * Get all values in the hash table
     * @return list of all values
     */
    public List<V> values() {
        List<V> values = new ArrayList<>();
        for (Entry<K, V> entry : table) {
            Entry<K, V> current = entry;
            while (current != null) {
                values.add(current.value);
                current = current.next;
            }
        }
        return values;
    }
    
    /**
     * Get all key-value pairs in the hash table
     * @return list of all entries
     */
    public List<Entry<K, V>> entrySet() {
        List<Entry<K, V>> entries = new ArrayList<>();
        for (Entry<K, V> entry : table) {
            Entry<K, V> current = entry;
            while (current != null) {
                entries.add(current);
                current = current.next;
            }
        }
        return entries;
    }
    
    /**
     * Clear the hash table
     */
    public void clear() {
        for (int i = 0; i < table.length; i++) {
            table[i] = null;
        }
        size = 0;
    }
    
    /**
     * Check if the hash table is empty
     * @return true if empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * Get the number of key-value pairs in the hash table
     * @return the size
     */
    public int size() {
        return size;
    }
    
    /**
     * Get the capacity of the hash table
     * @return the capacity
     */
    public int capacity() {
        return table.length;
    }
    
    /**
     * Get the load factor of the hash table
     * @return the current load factor
     */
    public double getLoadFactor() {
        return (double) size / table.length;
    }
    
    /**
     * Hash function
     * @param key the key to hash
     * @return the hash value
     */
    private int hash(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % table.length;
    }
    
    /**
     * Resize the hash table when load factor is exceeded
     */
    @SuppressWarnings("unchecked")
    private void resize() {
        Entry<K, V>[] oldTable = table;
        table = new Entry[oldTable.length * 2];
        size = 0;
        
        for (Entry<K, V> entry : oldTable) {
            Entry<K, V> current = entry;
            while (current != null) {
                put(current.key, current.value);
                current = current.next;
            }
        }
    }
    
    /**
     * Get the number of collisions in the hash table
     * @return the number of collisions
     */
    public int getCollisionCount() {
        int collisions = 0;
        for (Entry<K, V> entry : table) {
            if (entry != null && entry.next != null) {
                Entry<K, V> current = entry.next;
                while (current != null) {
                    collisions++;
                    current = current.next;
                }
            }
        }
        return collisions;
    }
    
    /**
     * Get the longest chain length in the hash table
     * @return the longest chain length
     */
    public int getLongestChainLength() {
        int maxLength = 0;
        for (Entry<K, V> entry : table) {
            int length = 0;
            Entry<K, V> current = entry;
            while (current != null) {
                length++;
                current = current.next;
            }
            maxLength = Math.max(maxLength, length);
        }
        return maxLength;
    }
    
    /**
     * Display the hash table structure
     */
    public void display() {
        System.out.println("Hash Table Structure:");
        for (int i = 0; i < table.length; i++) {
            System.out.print("Bucket " + i + ": ");
            Entry<K, V> current = table[i];
            if (current == null) {
                System.out.println("null");
            } else {
                while (current != null) {
                    System.out.print("(" + current.key + "=" + current.value + ")");
                    if (current.next != null) {
                        System.out.print(" -> ");
                    }
                    current = current.next;
                }
                System.out.println();
            }
        }
        System.out.println("Size: " + size + ", Capacity: " + table.length + 
                          ", Load Factor: " + String.format("%.2f", getLoadFactor()));
    }
    
    @Override
    public String toString() {
        if (isEmpty()) {
            return "HashTable: {}";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("HashTable: {");
        
        boolean first = true;
        for (Entry<K, V> entry : table) {
            Entry<K, V> current = entry;
            while (current != null) {
                if (!first) {
                    sb.append(", ");
                }
                sb.append(current.key).append("=").append(current.value);
                first = false;
                current = current.next;
            }
        }
        
        sb.append("}");
        return sb.toString();
    }
} 