Let's understand **Polymorphism** in Java in a **very simple way**, with **real-world examples**, **types**, and **code examples**. 🧠💡

---

## 🔷 What is Polymorphism?

**Polymorphism** means:

> "**One thing, many forms**"

In Java:

* A single **function**, **method**, or **object** behaves **differently** based on the **context**.

---

### ✅ Real-World Example:

Imagine a person named **Aniket**:

* At **college**, he's a **student**
* At **home**, he's a **son**
* On the **football ground**, he's a **player**

🧍‍♂️ Aniket = 1 person
🎭 Different **roles** = Different **behaviors**

This is **Polymorphism**.

---

## 🔷 Types of Polymorphism in Java

| Type             | Also Called As         | How it's Achieved                      |
| ---------------- | ---------------------- | -------------------------------------- |
| **Compile-Time** | **Method Overloading** | Same method name, different parameters |
| **Runtime**      | **Method Overriding**  | Same method in parent and child class  |

---

## ✅ 1. Compile-Time Polymorphism (Method Overloading)

Same method name, but different number or type of arguments.

```java
class MathOperations {
    void add(int a, int b) {
        System.out.println(a + b);
    }

    void add(double a, double b) {
        System.out.println(a + b);
    }
}

public class Main {
    public static void main(String[] args) {
        MathOperations obj = new MathOperations();
        obj.add(2, 3);        // Calls int version
        obj.add(2.5, 3.5);    // Calls double version
    }
}
```

### ✅ Output:

```
5
6.0
```

✅ *This is decided at compile time — hence called compile-time polymorphism.*

---

## ✅ 2. Runtime Polymorphism (Method Overriding)

Subclass **overrides** the parent class method.

```java
class Animal {
    void sound() {
        System.out.println("Animal makes sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal obj = new Dog(); // Parent class reference, child class object
        obj.sound();            // Calls Dog's sound()
    }
}
```

### ✅ Output:

```
Dog barks
```

✅ *Which method gets called is decided at runtime — hence called runtime polymorphism.*

---

## 🔸 Key Differences:

| Feature     | Method Overloading       | Method Overriding          |
| ----------- | ------------------------ | -------------------------- |
| Type        | Compile-Time             | Runtime                    |
| Class       | Same class               | Subclass & Superclass      |
| Parameters  | Must be different        | Must be same               |
| Return type | Can be same or different | Must be same or compatible |
| Keyword     | Not needed               | Use `@Override` annotation |

---

## 🔸 Summary in One Line:

> Polymorphism allows the **same method or object** to behave **differently** in **different situations**.

---

