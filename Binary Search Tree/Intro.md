Got it! Here's a beautifully formatted **digital notes version** of **Binary Search Tree (BST)** using emojis, clean headers, and structured lines — perfect for **Notion, OneNote, Evernote**, or other digital note-taking apps:

---

# 🌳 **Binary Search Tree (BST) – Digital Notes**

---

## 📌 **1. What is a BST?**

📎 A **Binary Search Tree (BST)** is a type of binary tree where:

* 🔹 **Left subtree** contains nodes with values **less than** the parent.
* 🔹 **Right subtree** contains nodes with values **greater than** the parent.
* 🔹 Follows this rule **recursively** for every node.
* 🚫 Usually **does not allow duplicates**.

---

## 🧠 **2. Key Properties**

| 🏷️ Property          | 📋 Description                                           |
| --------------------- | -------------------------------------------------------- |
| ⏱️ Time Complexity    | Average: **O(log n)**, Worst-case: **O(n)**              |
| 📐 Balanced Tree      | Keeps operations efficient                               |
| 📈 In-order Traversal | Always returns elements in **sorted order**              |
| ⚠️ Skewed Tree        | Happens when inserted in sorted order (acts like a list) |

---

## ⚙️ **3. Core Operations**

### 🔍 **Search**

➡ Go **left** if value < current node
➡ Go **right** if value > current node

### ➕ **Insert**

📌 Traverse to correct position and insert while maintaining BST rules.

### 🗑️ **Delete**

1. 🟢 Node has **no children** → Remove directly
2. 🟡 Node has **one child** → Replace with the child
3. 🔴 Node has **two children** → Replace with **inorder successor** (smallest in right subtree)

---

## 🔄 **4. Tree Traversals**

| 🔄 Traversal   | 🔢 Order            | 🧾 Purpose                     |
| -------------- | ------------------- | ------------------------------ |
| 📥 In-order    | Left → Root → Right | Returns sorted order           |
| 📤 Pre-order   | Root → Left → Right | Used for tree serialization    |
| 🔚 Post-order  | Left → Right → Root | Used for deletion              |
| 🔁 Level-order | BFS (Top to Bottom) | Used for visual representation |

---

## 💡 **5. Real-Life Applications**

* 🧠 Search engines & autocomplete
* 📚 Databases (indexing & range queries)
* 💻 Compiler symbol tables
* 📅 Scheduling & memory management
* 🗺️ Maps (`TreeMap`, `TreeSet` in Java)

---

## ⚖️ **6. Balanced BSTs**

❗ BSTs can degrade to linked lists (O(n))
✅ Use **Balanced BSTs** for optimal performance:

| Tree Type         | Balancing Method |
| ----------------- | ---------------- |
| 🔵 AVL Tree       | Height-balanced  |
| 🔴 Red-Black Tree | Color-balanced   |

👉 Java’s `TreeSet` and `TreeMap` use **Red-Black Trees** internally.

---

## 📊 **7. Comparison: Binary Tree vs BST**

| Feature       | 🌲 Binary Tree   | 🌳 Binary Search Tree (BST) |
| ------------- | ---------------- | --------------------------- |
| Ordering Rule | ❌ None           | ✅ Left < Root < Right       |
| Efficiency    | 🔻 Slower Search | 🚀 Faster Search (O log n)  |
| Structure     | 🌀 Flexible      | 📏 Strictly Ordered         |

---

## 🧾 **8. Java-Specific Notes**

* 🚫 Java does **not** have a built-in BST class.
* ✅ Use `TreeMap<K,V>` or `TreeSet<E>` for BST behavior.
* ✍️ Custom implementation needs a `TreeNode` class and manual logic.

---

## ✅ **Quick Summary**

* BST is **fast and sorted**: O(log n) for key operations (if balanced).
* Important in many **Java libraries** and **real-world applications**.
* Keep it **balanced** to avoid performance issues.

---

Would you like this exported as:

* 📄 A **PDF**
* 🖼️ An **image**
* 🧾 A **Notion-ready format**

Let me know and I’ll generate it!
