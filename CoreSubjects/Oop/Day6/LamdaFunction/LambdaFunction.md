# 🔹 What is a Lambda Function?

* **Lambda function** = a **short way to write a function/method** without creating a whole class.
* Introduced in **Java 8**.
* Mostly used with **functional interfaces** (interfaces with only one abstract method).

---

### ✅ Syntax of Lambda

```java
(parameters) -> expression
```

or for multiple statements:

```java
(parameters) -> {
    // statements
}
```

---

### 1️⃣ Example with Runnable (No parameters, no return value)

```java
public class Main {
    public static void main(String[] args) {
        // Old way using anonymous class
        Runnable r1 = new Runnable() {
            public void run() {
                System.out.println("Hello from thread!");
            }
        };
        new Thread(r1).start();

        // Lambda way
        Runnable r2 = () -> System.out.println("Hello from lambda thread!");
        new Thread(r2).start();
    }
}
```

Output:

```
Hello from thread!
Hello from lambda thread!
```

---

### 2️⃣ Example with Parameters

```java
interface MathOperation {
    int operate(int a, int b);
}

public class Main {
    public static void main(String[] args) {
        // Lambda to add two numbers
        MathOperation addition = (a, b) -> a + b;
        System.out.println(addition.operate(5, 3)); // Output: 8

        // Lambda to multiply two numbers
        MathOperation multiply = (a, b) -> a * b;
        System.out.println(multiply.operate(5, 3)); // Output: 15
    }
}
```

---

### 3️⃣ Example with Return Statement

```java
MathOperation subtract = (a, b) -> {
    return a - b;  // curly braces needed if using return
};
System.out.println(subtract.operate(10, 4)); // Output: 6
```

---

### 4️⃣ Lambda with Collections (forEach)

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Aniket", "Arpit", "Amte");

        // Old way
        for(String name : names) {
            System.out.println(name);
        }

        // Lambda
        names.forEach(name -> System.out.println(name));
    }
}
```

---

### 🔑 Key Points About Lambda Functions

1. **No class needed** → short and clean.
2. **Can access final or effectively final variables** from outside.
3. Works **only with functional interfaces** (interfaces with **single abstract method**).
4. Makes code **concise**, especially for **collections, threads, event handling**.

---

### 🔹 Functional Interface Example

```java
@FunctionalInterface
interface Greeting {
    void sayHello(String name);
}
```

Usage:

```java
Greeting greet = (name) -> System.out.println("Hello " + name);
greet.sayHello("Aniket"); // Output: Hello Aniket
```

---

