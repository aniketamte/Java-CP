Sure! Let’s break down **Single Inheritance** in Java in very simple English with a **real-life example**, **code**, and **output**.

---

## 🔹 What is Single Inheritance?

**Single Inheritance** means:

> One class inherits (extends) from only **one parent class**.

It's like a **child inherits features from one parent**.

---

### ✅ Real-Life Example:

* **Parent**: Father
* **Child**: Son

The Son inherits the properties or behavior from Father — like surname, habits, etc.

---

### ✅ Java Code Example:

```java
// Parent class
class Father {
    void display() {
        System.out.println("I am the Father.");
    }
}

// Child class (inherits Father)
class Son extends Father {
    void show() {
        System.out.println("I am the Son.");
    }
}

// Main class to run the code
public class Main {
    public static void main(String[] args) {
        Son s1 = new Son();

        s1.display();  // From Father class
        s1.show();     // From Son class
    }
}
```

---

### 📌 Output:

```
I am the Father.
I am the Son.
```

---

### ✅ Diagram to Understand (Text form):

```
Father class
   ↑
   |
Son class
```

* `Son` **extends** `Father`
* `Son` can use both `show()` and `display()` methods
* But `Father` can't use `show()` (because parent doesn't inherit from child)

---

## 🎯 Summary:

| Term               | Meaning                                   |
| ------------------ | ----------------------------------------- |
| Parent Class       | The class being inherited from (`Father`) |
| Child Class        | The class that inherits (`Son`)           |
| `extends`          | Keyword used for inheritance              |
| Single Inheritance | Only one parent class is inherited        |

---

Would you like examples for **multilevel** or **hierarchical inheritance** next?
