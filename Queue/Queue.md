

# 📚 Java Queue & Deque - Detailed Notes with Code Examples

## 🔷 Queue in Java

### ✅ What is a Queue?

A **Queue** is a **linear data structure** that follows the **FIFO** (First-In-First-Out) principle. The element inserted first is removed first.

### ✅ Queue Interface

In Java, `Queue` is an interface that is part of the `java.util` package. It is typically implemented by:

* `LinkedList`
* `PriorityQueue`
* `ArrayDeque`

```java
Queue<Integer> que = new LinkedList<>();
```

### ✅ Common Queue Operations

| Operation      | Method      | Description                                                  |
| -------------- | ----------- | ------------------------------------------------------------ |
| Enqueue (add)  | `add(e)`    | Inserts element; throws exception if queue is full           |
| Enqueue (safe) | `offer(e)`  | Inserts element; returns `false` if queue is full            |
| Peek           | `peek()`    | Returns head of queue without removing it                    |
| Dequeue        | `remove()`  | Removes and returns head; throws exception if queue is empty |
| Dequeue (safe) | `poll()`    | Removes and returns head; returns `null` if empty            |
| Check empty    | `isEmpty()` | Checks if queue is empty                                     |
| Size           | `size()`    | Returns number of elements                                   |

### ✅ Example Output

```java
Queue<Integer> que = new LinkedList<>();
que.add(10); que.add(20); que.add(30);
System.out.println(que);       // [10, 20, 30]
System.out.println(que.peek());   // 10
System.out.println(que.remove()); // 10
System.out.println(que);          // [20, 30]
```

---

## 🔷 Deque in Java

### ✅ What is a Deque?

**Deque** stands for **Double-Ended Queue**. It allows insertion and deletion from **both ends** (front and rear).

### ✅ Deque Interface

Java provides `Deque` interface and `ArrayDeque` class for its implementation.

```java
Deque<Integer> deque = new ArrayDeque<>();
```

### ✅ Common Deque Operations

| Operation              | Method                   | Description                         |
| ---------------------- | ------------------------ | ----------------------------------- |
| Add at tail            | `add(e)` / `offer(e)`    | Adds to the end (rear)              |
| Add at head            | `addFirst(e)`            | Adds to the front                   |
| Add at tail (explicit) | `addLast(e)`             | Adds to the end                     |
| Remove from head       | `poll()` / `pollFirst()` | Removes from front                  |
| Remove from tail       | `pollLast()`             | Removes from the end                |
| Peek front             | `peek()` / `peekFirst()` | Retrieves first element             |
| Peek rear              | `peekLast()`             | Retrieves last element              |
| Check empty            | `isEmpty()`              | Checks if deque is empty            |
| Clear all elements     | `clear()`                | Removes all elements from the deque |

### ✅ Example Usage

```java
Deque<Integer> deque = new ArrayDeque<>();
deque.add(10);
deque.addFirst(20);
deque.addLast(30);
System.out.println(deque); // [20, 10, 30]

System.out.println(deque.pollFirst()); // 20
System.out.println(deque.pollLast());  // 30
System.out.println(deque);             // [10]
```

---

## 📝 Additional Methods You Can Use

| Method                 | Description                                           |
| ---------------------- | ----------------------------------------------------- |
| `contains(Object o)`   | Checks if a specific element exists                   |
| `iterator()`           | Returns iterator to traverse the queue                |
| `descendingIterator()` | Traverses a deque from end to start                   |
| `removeFirst()`        | Removes the first element (throws exception if empty) |
| `removeLast()`         | Removes the last element                              |
| `getFirst()`           | Gets the first element without removal                |
| `getLast()`            | Gets the last element without removal                 |

---

## 📌 Use Cases

### Queue

* Order processing systems
* Job scheduling
* Printer spooler
* BFS traversal in graphs

### Deque

* Palindrome checker
* Sliding window problems
* Undo/Redo functionality
* BFS with optimization (0-1 BFS)

---

## 🚫 Exception Handling

* `remove()` / `element()` → throws `NoSuchElementException` if empty
* `add()` → throws `IllegalStateException` if capacity is full (in bounded queues)

Always prefer `offer()` and `poll()` when safety is needed.

---

## ✅ Conclusion

* Use `Queue` when you need FIFO structure.
* Use `Deque` when you need flexibility to insert/remove from both ends.
* For thread-safe queues, consider `ConcurrentLinkedQueue` or `BlockingQueue`.

---

## 🧪 Tip for Practice

Try implementing:

1. Reverse a Queue using Deque
2. Implement Stack using Deque
3. BFS traversal using Queue

---
