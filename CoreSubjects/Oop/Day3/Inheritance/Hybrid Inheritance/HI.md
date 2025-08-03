## 🔷 What is Hybrid Inheritance in Java?

> **Hybrid Inheritance** means **combining two or more types of inheritance** (like single, multilevel, hierarchical, etc.).

But ❌ **Java does not support hybrid inheritance using classes alone** because it can lead to **ambiguity** (like the Diamond Problem).
✅ Instead, Java supports **hybrid inheritance** using **interfaces** to safely avoid that problem.

---

## ✅ Simple Explanation:

Imagine this combination:

* **Class A** is the base.
* **Class B and Class C** extend A (Hierarchical Inheritance).
* **Class D** extends both B and C. (This would create **Multiple Inheritance**, which Java doesn't allow with classes.)

So we **use interfaces** to allow D to inherit from B and C **without conflict**.

---

### ⚠️ Problem with Classes:

```java
class A {
    void display() {
        System.out.println("Hello from A");
    }
}

class B extends A { }

class C extends A { }

// ❌ Java will NOT allow this
class D extends B, C { } // Error: Java doesn't support multiple inheritance with classes
```

---

### ✅ Correct Approach Using Interfaces:

```java
interface A {
    void show();
}

interface B extends A {
    void displayB();
}

interface C extends A {
    void displayC();
}

// D implements B and C (Hybrid Inheritance using interfaces)
class D implements B, C {
    public void show() {
        System.out.println("Hello from A");
    }

    public void displayB() {
        System.out.println("Hello from B");
    }

    public void displayC() {
        System.out.println("Hello from C");
    }
}

public class Main {
    public static void main(String[] args) {
        D obj = new D();
        obj.show();       // from A
        obj.displayB();   // from B
        obj.displayC();   // from C
    }
}
```

---

### ✅ Output:

```
Hello from A
Hello from B
Hello from C
```

---

## ✅ Real-World Example:

Let’s say:

* `Vehicle` interface: has method `start()`
* `Electric` interface: has method `charge()`
* `Car` class implements both

This is **Hybrid** because it combines **multiple inheritance** (via interfaces) and **single inheritance** (Car is one class).

---

### ✅ Summary:

| Term                   | Meaning                                         |
| ---------------------- | ----------------------------------------------- |
| **Hybrid Inheritance** | Combination of two or more types of inheritance |
| **Supported in Java?** | ❌ Not with classes only, ✅ Yes with interfaces  |
| **Avoids issues like** | Diamond Problem                                 |
| **How to implement**   | Use interfaces + classes                        |

---
