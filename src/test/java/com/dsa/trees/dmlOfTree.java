package com.dsa.trees;

import static com.dsa.trees.traversal.LevelOrderTraversal_BFS;

public class dmlOfTree {

    /*
    * Insertion in a Binary Tree in level order
    * Given a binary tree and a key, the task is to
    * insert the key into the binary tree at the first position available
     *        10
     *     20     30
     * 40       50    60
    * */


    public static void insetItemIntoNode(Node node, int item) {
        if (node.left == null) {
            Node newNode = new Node(item);
            node.left = newNode.left;
            return;
        }
        if(node.right == null) {
            Node newNode = new Node(item);
            node.right = newNode.right;
            return;
        }
        insetItemIntoNode(node.left, item);
        insetItemIntoNode(node.right, item);
    }

    public static void main (String [] args) {
        Node firstNode = new Node(10);
        Node secondNode = new Node(20);
        Node thirdNode = new Node(30);
        Node fourthNode = new Node(40);
        Node fithNode = new Node(50);

        firstNode.left = secondNode;
        firstNode.right = thirdNode;
        thirdNode.left = fourthNode;
        thirdNode.right = fithNode;
        insetItemIntoNode(firstNode, 12);
        LevelOrderTraversal_BFS(firstNode);
    }
}
