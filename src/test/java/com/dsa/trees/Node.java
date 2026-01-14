package com.dsa.trees;

//https://www.geeksforgeeks.org/dsa/binary-tree-data-structure/
public class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}
    class gfg {

        public static void main (String [] args) {
            // initialize the node
            Node firstNode = new Node(2);
            Node secondNode = new Node(3);
            Node thirdNode = new Node(4);
            Node fourthNode = new Node(5);
            // Connect binary tree nodes
            firstNode.left = secondNode;
            firstNode.right = thirdNode;
            secondNode.left = fourthNode;
        }

    }
