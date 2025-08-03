Great! Let's now understand **Multiple Inheritance** in Java — in **easy English** with **real-world logic**, **Java syntax**, and **example**.

---

## 🔹 What is Multiple Inheritance?

**Multiple Inheritance** means:

> A class **inherits from more than one class**.

---

### ❌ Java Does **NOT** Support Multiple Inheritance With Classes

Java does **not** allow a class to inherit from **more than one class directly** using `extends`.

This is because:

> It causes **ambiguity** (confusion) when two parent classes have the **same method name**.

---

### ✅ So, How to Do Multiple Inheritance in Java?

Java supports **multiple inheritance through interfaces** (not classes).

---

### ✅ Real-Life Example:

* Suppose you have:

  * `Camera` → takes photos
  * `Phone` → makes calls
* You want to make a **SmartPhone** that does **both**.

This is possible using interfaces.

---

## ✅ Java Code Example:

```java
// Interface 1
interface Camera {
    void takePhoto();
}

// Interface 2
interface Phone {
    void makeCall();
}

// Class implementing both interfaces
class SmartPhone implements Camera, Phone {
    public void takePhoto() {
        System.out.println("Taking a photo...");
    }

    public void makeCall() {
        System.out.println("Making a call...");
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        SmartPhone sp = new SmartPhone();
        sp.takePhoto();  // from Camera
        sp.makeCall();   // from Phone
    }
}
```

---

### 📌 Output:

```
Taking a photo...
Making a call...
```

---

## 🧠 Why Interfaces?

Interfaces solve the **diamond problem** (method conflict from two parent classes).
Each interface is like a **contract** the child class agrees to follow.

---

## 🎯 Summary:

| Concept                  | Inheritance Type        | Java Supports? | How to do it?           |
| ------------------------ | ----------------------- | -------------- | ----------------------- |
| **Single Inheritance**   | One parent class        | ✅ Yes          | Using `extends`         |
| **Multiple Inheritance** | Multiple parent classes | ❌ No           | ✅ Only via `interfaces` |

---
