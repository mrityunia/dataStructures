package com.dsa.trees;

public class traversal {
    //Inorder Traversal of Binary Tree
//    Inorder Traversal is a method to traverse a tree such that for each node,
//    you first traverse its left subtree, then visit the node itself,
//    and finally traverse its right subtree.

    public static void main(String[] args) {
        Node firstNode = new Node(10);
        Node secondNode = new Node(20);
        Node thirdNode = new Node(30);
        Node fourthNode = new Node(40);
        Node fithNode = new Node(50);

        firstNode.left = secondNode;
        firstNode.right = thirdNode;
        thirdNode.left = fourthNode;
        thirdNode.right = fithNode;
        /*    10
         * 20       30
         *       40     50
         * */
        LevelOrderTraversal_BFS(firstNode);
    }

    public static void inorderTraversalOfBinaryTree(Node node) {
        if (node != null) {
            inorderTraversalOfBinaryTree(node.left);
            System.out.printf("%d ", node.data);
            inorderTraversalOfBinaryTree(node.right);
        }
    }
    /*
     *  inorderTraversalOfBinaryTree(10)
     *      inorderTraversalOfBinaryTree(20)
     *           inorderTraversalOfBinaryTree(null)
     *           print(20)
     *           inorderTraversalOfBinaryTree(null)
     *       print(10)
     *      inorderTraversalOfBinaryTree(30)
     *           inorderTraversalOfBinaryTree(40)
     *              inorderTraversalOfBinaryTree(null)
     *              print(40)
     *              inorderTraversalOfBinaryTree(null)
     *          print(30)
     *          inorderTraversalOfBinaryTree(50)
     *               inorderTraversalOfBinaryTree(null)
     *               print(50)
     *               inorderTraversalOfBinaryTree(null)
     *
     *
     * */


    //Preorder Traversal is a method to traverse a tree such that for each node,
    // you first visit the node itself,
    // then traverse its left subtree, and finally traverse its right subtree.
    public static void preorderTraversalOfBinaryTree(Node node) {
        if (node != null) {
            System.out.printf("%d ", node.data);
            preorderTraversalOfBinaryTree(node.left);
            preorderTraversalOfBinaryTree(node.right);
        }


        /*
         * preorderTraversalOfBinaryTree(10)
         *   print(10)
         *   preorderTraversalOfBinaryTree(20)
         *      print(20)
         *      preorderTraversalOfBinaryTree(null)
         *      preorderTraversalOfBinaryTree(null)
         *   preorderTraversalOfBinaryTree(30)
         *      print(30)
         *      preorderTraversalOfBinaryTree(40)
         *            print(40)
         *            preorderTraversalOfBinaryTree(null)
         *            preorderTraversalOfBinaryTree(null)
         *      preorderTraversalOfBinaryTree(50)
         *            print(50)
         *            preorderTraversalOfBinaryTree(null)
         *            preorderTraversalOfBinaryTree(null)
         *
         *
         * */
    }

    public static void PostorderTraversalOfBinaryTree(Node node) {
        if (node != null) {
            PostorderTraversalOfBinaryTree(node.left);
            PostorderTraversalOfBinaryTree(node.right);
            System.out.printf("%d ", node.data);
        }

    }
    /*    10
     * 20       30
     *       40     50
     * */


    /*  PostorderTraversalOfBinaryTree(10)
            PostorderTraversalOfBinaryTree(20)
                PostorderTraversalOfBinaryTree(null)
                PostorderTraversalOfBinaryTree(null)
                print(20)
            PostorderTraversalOfBinaryTree(30)
              PostorderTraversalOfBinaryTree(40)
                 PostorderTraversalOfBinaryTree(null)
                 PostorderTraversalOfBinaryTree(null)
                 print(40)
              PostorderTraversalOfBinaryTree(50)
                 PostorderTraversalOfBinaryTree(null)
                 PostorderTraversalOfBinaryTree(null)
                 print(50)
              print(30)
    *    print(10)
    *
    * */


    public static void LevelOrderTraversal_BFS(Node node) {
        // find the height of the tree = depth
        // from 0 to depth
        // if node of (nth) is null - exit
        // if nth == zero then print current node->data
        // if nth > 0
        // then go to left and reduce depth node>left,nth-1
        // then go to right and reduce depth node>right nth -1
        int depth = findHeightOfTheTree(node);
        for (int i = 0; i < depth; i++) {
            printBFS(node, i);
        }
    }

    public static void printBFS(Node node, int depth) {
        if (node == null)
            return;
        if (depth == 0)
            System.out.printf("%d ", node.data);
        else if (depth > 0) {
            printBFS(node.left, depth - 1);
            printBFS(node.right, depth - 1);
        }
    }
        /*    10
         * 20       30
         *       40     50
         * */
        /*
         * i =0
         * printBFS(10,0)
         *    print(10)
         * i = 1
         * printBFS(10, 1)
         *   printBFS(20,0)
         *       print(20)
         *   printBFS(30,0)
         *      print(30)
         *i = 2
         * printBFS(10,2)
         *     printBFS(20,1)
         *        printBFS(null, 0) -> exit
         *        printBFS(null, 0) exit
         *     printBFS(30,1)
         *          printBFS(40,0)
         *             print(40)
         *         printBFS(50,0)
         *              print(50)
         *
         * 10 , 20, 30,40,50
         *
         *
         *
         * */


    public static int findHeightOfTheTree(Node node) {
        if (node == null)
            return 0;
        int leftHeight = findHeightOfTheTree(node.left);
        int rightHeight = findHeightOfTheTree(node.right);
        int actualHeight = Math.max(leftHeight, rightHeight) + 1;
        return actualHeight;
    }

}
