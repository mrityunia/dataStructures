# Data Structures and Algorithms in Java

A comprehensive Java project for learning and practicing Data Structures and Algorithms. This project provides complete implementations of fundamental data structures and algorithms with detailed examples and unit tests.

## 🚀 Features

### Data Structures Implemented
- **Arrays** - Linear and Binary Search, Sorting Algorithms
- **Linked Lists** - Singly Linked List with comprehensive operations
- **Stacks** - Array-based Stack implementation
- **Queues** - Circular Queue implementation
- **Binary Search Trees** - Complete BST with traversal algorithms
- **Hash Tables** - Chaining-based collision resolution

### Algorithms Implemented
- **Searching Algorithms**
  - Linear Search (O(n))
  - Binary Search (O(log n))
- **Sorting Algorithms**
  - Bubble Sort (O(n²))
  - Selection Sort (O(n²))
  - Insertion Sort (O(n²))
  - Merge Sort (O(n log n))
  - Quick Sort (O(n log n) average)
- **Tree Traversal Algorithms**
  - Inorder Traversal
  - Preorder Traversal
  - Postorder Traversal

## 📁 Project Structure

```
dataStructures/
├── src/
│   ├── main/java/com/dsa/
│   │   ├── arrays/
│   │   │   └── ArrayOperations.java
│   │   ├── linkedlist/
│   │   │   └── LinkedList.java
│   │   ├── stack/
│   │   │   └── Stack.java
│   │   ├── queue/
│   │   │   └── Queue.java
│   │   ├── tree/
│   │   │   └── BinarySearchTree.java
│   │   ├── hashtable/
│   │   │   └── HashTable.java
│   │   └── Main.java
│   └── test/java/com/dsa/
│       └── arrays/
│           └── ArrayOperationsTest.java
├── pom.xml
└── README.md
```

## 🛠️ Setup and Installation

### Prerequisites
- Java 11 or higher
- Maven 3.6 or higher

### Installation Steps

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd dataStructures
   ```

2. **Build the project**
   ```bash
   mvn clean compile
   ```

3. **Run the main program**
   ```bash
   mvn exec:java -Dexec.mainClass="com.dsa.Main"
   ```

4. **Run tests**
   ```bash
   mvn test
   ```

## 📖 Usage Examples

### Array Operations
```java
import com.dsa.arrays.ArrayOperations;

int[] arr = {64, 34, 25, 12, 22, 11, 90};

// Linear Search
int index = ArrayOperations.linearSearch(arr, 22); // Returns 4

// Sorting
ArrayOperations.quickSort(arr);

// Binary Search (requires sorted array)
int found = ArrayOperations.binarySearch(arr, 22); // Returns 2
```

### Linked List
```java
import com.dsa.linkedlist.LinkedList;

LinkedList<Integer> list = new LinkedList<>();
list.addLast(10);
list.addLast(20);
list.addFirst(5);

list.display(); // Output: LinkedList: 5 -> 10 -> 20
```

### Stack
```java
import com.dsa.stack.Stack;

Stack<String> stack = new Stack<>();
stack.push("First");
stack.push("Second");

String top = stack.peek(); // Returns "Second"
String popped = stack.pop(); // Returns "Second"
```

### Queue
```java
import com.dsa.queue.Queue;

Queue<Integer> queue = new Queue<>();
queue.enqueue(10);
queue.enqueue(20);

int front = queue.peek(); // Returns 10
int dequeued = queue.dequeue(); // Returns 10
```

### Binary Search Tree
```java
import com.dsa.tree.BinarySearchTree;

BinarySearchTree<Integer> bst = new BinarySearchTree<>();
bst.insert(50);
bst.insert(30);
bst.insert(70);

List<Integer> inorder = bst.inorderTraversal(); // [30, 50, 70]
```

### Hash Table
```java
import com.dsa.hashtable.HashTable;

HashTable<String, Integer> hashTable = new HashTable<>();
hashTable.put("apple", 1);
hashTable.put("banana", 2);

Integer value = hashTable.get("apple"); // Returns 1
```

## 🧪 Testing

The project includes comprehensive unit tests for all data structures and algorithms. Run the tests using:

```bash
mvn test
```

Test coverage includes:
- Edge cases and error conditions
- Performance validation
- Algorithm correctness verification
- Data structure integrity checks

## 📚 Learning Resources

### Books
- "Introduction to Algorithms" by Cormen, Leiserson, Rivest, and Stein
- "Data Structures and Algorithms in Java" by Robert Lafore
- "Algorithms" by Robert Sedgewick and Kevin Wayne

### Online Resources
- [GeeksforGeeks](https://www.geeksforgeeks.org/)
- [LeetCode](https://leetcode.com/)
- [HackerRank](https://www.hackerrank.com/)
- [Codeforces](https://codeforces.com/)

### Time Complexity Reference
| Operation | Array | Linked List | Stack | Queue | BST | Hash Table |
|-----------|-------|-------------|-------|-------|-----|------------|
| Access | O(1) | O(n) | O(1) | O(1) | O(log n) | O(1) |
| Search | O(n) | O(n) | O(n) | O(n) | O(log n) | O(1) |
| Insert | O(n) | O(1) | O(1) | O(1) | O(log n) | O(1) |
| Delete | O(n) | O(1) | O(1) | O(1) | O(log n) | O(1) |

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request. For major changes, please open an issue first to discuss what you would like to change.

### How to Contribute
1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🎯 Learning Path

### Beginner Level
1. Start with Array operations and basic sorting algorithms
2. Understand Linked Lists and their operations
3. Learn Stack and Queue implementations
4. Practice with simple problems using these data structures

### Intermediate Level
1. Master Binary Search Trees and tree traversals
2. Understand Hash Tables and collision resolution
3. Implement more complex algorithms
4. Solve medium-level problems on coding platforms

### Advanced Level
1. Implement advanced data structures (AVL Trees, Red-Black Trees, etc.)
2. Study graph algorithms
3. Learn dynamic programming
4. Solve complex algorithmic problems

## 🚀 Next Steps

After mastering these implementations, consider exploring:
- **Advanced Data Structures**: AVL Trees, Red-Black Trees, B-Trees
- **Graph Algorithms**: DFS, BFS, Dijkstra's, Floyd-Warshall
- **Dynamic Programming**: Memoization, Tabulation
- **Advanced Algorithms**: Divide and Conquer, Greedy Algorithms
- **System Design**: Scalable data structure implementations

## 📞 Support

If you have any questions or need help with the implementations, please:
1. Check the existing issues
2. Create a new issue with a clear description
3. Provide code examples if applicable

Happy Learning! 🎉 