Alright 👍 Let’s go step by step and make **Generics in Java** crystal clear.

---

# 🔹 What are Generics?

Generics = **Type parameters**.
They let you **write code once** and use it for **any data type**.

👉 Without Generics (old days, before Java 5), you had to write different classes/methods for `int`, `String`, `Double`, etc.

With Generics → You write **one class/method** and it works for all types.

---

# 🔹 Simple Example (Without Generics)

```java
class Box {
    Object item;   // can store anything

    public void set(Object item) {
        this.item = item;
    }

    public Object get() {
        return item;
    }
}
```

Usage:

```java
Box box = new Box();
box.set("Hello");   // Store String
String str = (String) box.get();  // Need casting
```

👉 Problem: If you mistakenly do

```java
box.set(123);   // Integer
String str = (String) box.get(); // ❌ Runtime error
```

---

# 🔹 With Generics

```java
class Box<T> {     // <T> is a placeholder for Type
    private T item;

    public void set(T item) {
        this.item = item;
    }

    public T get() {
        return item;
    }
}
```

Usage:

```java
Box<String> strBox = new Box<>();  
strBox.set("Hello");
String str = strBox.get();   // ✅ No casting, type-safe

Box<Integer> intBox = new Box<>();
intBox.set(123);
Integer num = intBox.get();  // ✅ Works for Integer
```

---

# 🔹 Why Use Generics?

✅ Type Safety → Catches errors at compile time.
✅ Code Reusability → One class works for many types.
✅ No Casting → Cleaner, safer code.
✅ Performance → No unnecessary type conversions.

---

# 🔹 Generic Methods

```java
class Utils {
    // Generic method
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
```

Usage:

```java
public class Main {
    public static void main(String[] args) {
        Integer[] intArr = {1, 2, 3};
        String[] strArr = {"A", "B", "C"};

        Utils.printArray(intArr);  // Works with Integer[]
        Utils.printArray(strArr);  // Works with String[]
    }
}
```

Output:

```
1 2 3 
A B C 
```

---

# 🔹 Bounded Generics (Restrict Type)

```java
class Calculator<T extends Number> {   // only Numbers allowed
    private T value;

    Calculator(T value) {
        this.value = value;
    }

    double doubleValue() {
        return value.doubleValue();
    }
}
```

Usage:

```java
Calculator<Integer> calc1 = new Calculator<>(10);
Calculator<Double> calc2 = new Calculator<>(3.14);

// ❌ Calculator<String> calc3 = new Calculator<>("Hello"); // Not allowed
```

---

# 🔹 Wildcards (`?`)

When you don’t know the exact type.

```java
public static void printList(List<?> list) {
    for (Object obj : list) {
        System.out.println(obj);
    }
}
```

Usage:

```java
List<Integer> intList = Arrays.asList(1, 2, 3);
List<String> strList = Arrays.asList("A", "B");

printList(intList);
printList(strList);
```

---

# 🔹 Real-Life Analogy

Think of a **Tiffin Box** 🍱

* Old way → You buy 1 box for rice, 1 for roti, 1 for sabzi. (like making multiple classes for each type)
* Generics → You buy **one tiffin box** but say, “Today this box will carry rice” or “Today it’ll carry roti.”
  ➡ Flexible and reusable.

---

# 🔹 Interview-Friendly One-Liner

**Generics in Java allow classes, interfaces, and methods to operate on objects of various types while providing compile-time type safety.**

---

Perfect 👍 You want the **rules of Generics** in Java in **simple language** so you can revise fast.
Here’s a clean and easy list 👇

---

# ✅ Rules of Generics in Java

### 1. **Generics work only with Objects, not primitives**

```java
Box<int> box = new Box<>();   // ❌ Not allowed
Box<Integer> box = new Box<>();  // ✅ Allowed
```

---

### 2. **Type is checked at compile time**

If you give the wrong type → compiler error.

```java
Box<String> box = new Box<>();
box.set("Hello");
// box.set(123); // ❌ Compile error
```

---

### 3. **No type information at runtime (Type Erasure)**

Generics exist only at **compile time**.
JVM replaces `T` with `Object` (or bounded type).

```java
Box<String> strBox = new Box<>();
Box<Integer> intBox = new Box<>();
System.out.println(strBox.getClass() == intBox.getClass()); // ✅ true
```

---

### 4. **Cannot create objects of type parameter**

```java
class Box<T> {
    // T item = new T();  // ❌ Not allowed
}
```

---

### 5. **Cannot use `static` with type parameters**

```java
class Box<T> {
    // static T item;  // ❌ Not allowed
}
```

Because `static` belongs to the class, not to each object with different type `T`.

---

### 6. **You can use Generics with classes, methods, and interfaces**

```java
class Box<T> { }                 // Generic class
interface Container<T> { }        // Generic interface
<T> void print(T item) { }        // Generic method
```

---

### 7. **Bounded Types (`extends`)**

You can restrict generics using `extends` keyword.

```java
class Calc<T extends Number> { }  // only Number & subclasses
```

---

### 8. **Wildcards (`?`)**

* `<?>` → unknown type
* `<? extends Number>` → any subclass of Number
* `<? super Integer>` → Integer or its superclasses

Example:

```java
List<?> list1;             // any type
List<? extends Number> l2; // Number or subclasses
List<? super Integer> l3;  // Integer, Number, Object
```

---

### 9. **Cannot create generic arrays**

```java
// T[] arr = new T[10]; // ❌ Not allowed
```

But you can create `Object[]` and cast.

---

### 10. **Multiple bounds are allowed**

```java
class Box<T extends Number & Comparable<T>> { }
```

➡ `T` must be a subclass of Number **and** implement Comparable.

---

# 🔹 Quick Interview Summary (One-liners)

* Works only with objects (use wrapper classes for primitives).
* Type checking happens at compile time.
* No type info at runtime (type erasure).
* Cannot make objects/arrays of generic type.
* Cannot use static with generic type.
* Can restrict types with `extends`.
* Wildcards `?`, `? extends`, `? super`.
* Multiple bounds allowed.

---

