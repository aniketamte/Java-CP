Great question 👍 Let’s build a **custom ArrayList** step by step in **easy language**.

Normally, Java provides `ArrayList` class in `java.util`, but here we’ll try to **create our own version** (like a simplified ArrayList) to understand how it works internally.

---

# 🌟 Custom ArrayList in Java

### 🔹 Concept

* An `ArrayList` is basically a **resizable array**.
* When the array becomes full, it creates a **new bigger array** and copies old elements into it.
* We can then add, remove, or get elements dynamically.

---

### 🔹 Code: Custom ArrayList

📌 File: `CustomArrayList.java`

```java
package Practice;

import java.util.Arrays;

public class CustomArrayList {
    private int[] data;   // Array to store elements
    private int size;     // Number of elements present
    private static final int DEFAULT_CAPACITY = 10;

    // Constructor
    public CustomArrayList() {
        data = new int[DEFAULT_CAPACITY]; // start with default size
        size = 0;
    }

    // Add element
    public void add(int element) {
        if (size == data.length) {
            resize();  // Increase capacity if full
        }
        data[size] = element;
        size++;
    }

    // Get element at index
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid Index");
        }
        return data[index];
    }

    // Remove last element
    public void remove() {
        if (size > 0) {
            size--;
        }
    }

    // Current size
    public int size() {
        return size;
    }

    // Resize when array is full
    private void resize() {
        int newCapacity = data.length * 2;
        data = Arrays.copyOf(data, newCapacity);
    }

    // Print all elements
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
}
```

---

📌 File: `Main.java`

```java
package Practice;

public class Main {
    public static void main(String[] args) {
        CustomArrayList list = new CustomArrayList();

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        System.out.println("List elements:");
        list.display();

        System.out.println("Element at index 2: " + list.get(2));

        list.remove();
        System.out.println("After removing last element:");
        list.display();

        System.out.println("Current size: " + list.size());
    }
}
```

---

### ✅ Output

```
List elements:
10 20 30 40 
Element at index 2: 30
After removing last element:
10 20 30 
Current size: 3
```

---

### 🔹 Key Points

1. `data` → internal array to hold values.
2. `size` → number of elements currently stored.
3. `resize()` → doubles the array capacity when it gets full.
4. Works almost like Java’s inbuilt `ArrayList`, but simpler.

---

Perfect 👌 you’ve reached the right point — almost everyone faces **problems** when first making a custom `ArrayList`.
Let’s go step by step.

---

## 🔴 Common Problems with Custom ArrayList

### 1. **It only works for `int`**

In my code, we wrote:

```java
private int[] data;
```

➡️ This means you can only store `int` values.
✅ Fix → Make it **generic** (`T[] data`) so it can store any type (`String`, `Double`, `Object`, etc.).

---

### 2. **`remove()` is incomplete**

Right now:

```java
public void remove() {
    if (size > 0) {
        size--;
    }
}
```

➡️ This only removes the **last element**, but not from the middle.
✅ Fix → Add a method to remove element at any index and shift remaining elements.

---

### 3. **Array resizing**

When size is full, we use:

```java
private void resize() {
    int newCapacity = data.length * 2;
    data = Arrays.copyOf(data, newCapacity);
}
```

➡️ Works fine, but resizing too often can be **slow**.
✅ Fix → Balance memory and performance (this is how Java `ArrayList` is optimized).

---

---

## ✅ Improved Version (Generic + Proper Remove)

📌 `CustomArrayList.java`

```java
package Practice;

import java.util.Arrays;

public class CustomArrayList<T> {
    private Object[] data;   // Use Object array (generic simulation)
    private int size;        // Number of elements
    private static final int DEFAULT_CAPACITY = 10;

    // Constructor
    public CustomArrayList() {
        data = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    // Add element
    public void add(T element) {
        if (size == data.length) {
            resize();
        }
        data[size++] = element;
    }

    // Get element
    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid Index");
        }
        return (T) data[index];
    }

    // Remove element at index
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid Index");
        }
        // Shift elements left
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
    }

    // Resize array
    private void resize() {
        int newCapacity = data.length * 2;
        data = Arrays.copyOf(data, newCapacity);
    }

    // Current size
    public int size() {
        return size;
    }

    // Print all elements
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
}
```

📌 `Main.java`

```java
package Practice;

public class Main {
    public static void main(String[] args) {
        CustomArrayList<String> list = new CustomArrayList<>();

        list.add("Apple");
        list.add("Banana");
        list.add("Mango");
        list.add("Orange");

        System.out.println("List elements:");
        list.display();

        System.out.println("Element at index 1: " + list.get(1));

        list.remove(2); // remove Mango
        System.out.println("After removing index 2:");
        list.display();

        System.out.println("Current size: " + list.size());
    }
}
```

---

### ✅ Output:

```
List elements:
Apple Banana Mango Orange 
Element at index 1: Banana
After removing index 2:
Apple Banana Orange 
Current size: 3
```

---

⚡ Now your custom `ArrayList` is **generic** (works with any type), supports **remove at index**, and behaves closer to Java’s built-in `ArrayList`.

---

Got it 👍 Let me explain **step by step in very simple words**.
We’ll go slowly from your code (only for `int`) → to **Generic ArrayList** (works for all types).

---

## 1️⃣ Your Code (Only for `int`)

```java
private int data[];
```

This means your `customArrayList` can **only** store integers.
So you can do:

```java
list.add(10);
list.add(20);
```

✅ Works fine.

But if you try:

```java
list.add("Hello");
```

❌ Error → because `"Hello"` is not an `int`.

---

## 2️⃣ What if we want it to store anything? (String, Double, etc.)

👉 We use **Generics (`<T>`)**.

`<T>` is just a **placeholder for a type**.

* If you write `CustomArrayList<Integer>`, `T = Integer`.
* If you write `CustomArrayList<String>`, `T = String`.

---

## 3️⃣ How Generic Code Looks

Instead of `int[]`, we write:

```java
private Object[] data;
```

Why?

* Because `Object` is the parent of **all classes** in Java.
* That means it can store **anything**: Integer, String, Double, etc.

But later when we **get it back**, we must **cast** to the correct type (`(T)`).

---

## 4️⃣ Full Example in Simple Code

📌 `CustomArrayList.java`

```java
import java.util.Arrays;

public class CustomArrayList<T> {   // <T> = Generic Type
    private Object[] data;          // Store elements in Object[]
    private static int DEFAULT_SIZE = 10;
    private int size = 0;

    public CustomArrayList() {
        data = new Object[DEFAULT_SIZE];
    }

    // Add element
    public void add(T element) {
        if (isFull()) {
            resize();
        }
        data[size++] = element;
    }

    // Get element
    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T) data[index];   // Cast back to T
    }

    // Remove last element
    @SuppressWarnings("unchecked")
    public T remove() {
        T removed = (T) data[--size];
        data[size] = null; // clean memory
        return removed;
    }

    // Set element
    public void set(int index, T value) {
        data[index] = value;
    }

    public int size() {
        return size;
    }

    private boolean isFull() {
        return size == data.length;
    }

    private void resize() {
        Object[] temp = new Object[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(data, size));
    }
}
```

📌 `Main.java`

```java
public class Main {
    public static void main(String[] args) {
        // Integer list
        CustomArrayList<Integer> intList = new CustomArrayList<>();
        intList.add(10);
        intList.add(20);
        System.out.println(intList);

        // String list
        CustomArrayList<String> strList = new CustomArrayList<>();
        strList.add("Hello");
        strList.add("World");
        System.out.println(strList);

        // Double list
        CustomArrayList<Double> doubleList = new CustomArrayList<>();
        doubleList.add(3.14);
        doubleList.add(9.81);
        System.out.println(doubleList);

        // Get element
        System.out.println("Element at index 1: " + strList.get(1));
    }
}
```

---

## 5️⃣ Output

```
[10, 20]
[Hello, World]
[3.14, 9.81]
Element at index 1: World
```

---

## 6️⃣ Super Simple Analogy

Think of **your old code** like a **box that can only store apples (`int`)**.

* Good for apples, but can’t put bananas or oranges.

Now with **Generics `<T>`**, the box says:
➡ “Tell me what fruit I’ll store before using me.”

* If you say `<Integer>` → box stores only numbers.
* If you say `<String>` → box stores only text.
* If you say `<Double>` → box stores only decimals.

---

