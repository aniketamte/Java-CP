Awesome 🚀 let’s go into **JavaScript Data Types** — one of the most fundamental topics, and a **placement favorite**.

---

# 🔹 JavaScript Data Types

JavaScript has **two categories** of data types:

1. **Primitive Data Types**
2. **Non-Primitive (Reference) Data Types**

---

## 1. **Primitive Data Types**

👉 Stored **directly in memory**, immutable (cannot be changed directly).
There are **7 primitive types**:

### (a) Number

* Represents integers & floating-point numbers.

```javascript
let age = 21;        // integer
let price = 99.99;   // decimal
let infinity = Infinity;
let notNumber = NaN; // "Not a Number"
```

---

### (b) String

* Sequence of characters inside quotes (`''`, `""`, or backticks \`\`\`\`).

```javascript
let name = "Aniket";
let msg = 'Hello World';
let greet = `Hello, ${name}!`; // template literal
```

---

### (c) Boolean

* Only two values: `true` or `false`.

```javascript
let isLoggedIn = true;
let isAdmin = false;
```

---

### (d) Undefined

* Variable declared but **not assigned a value**.

```javascript
let x;
console.log(x); // undefined
```

---

### (e) Null

* **Intentional absence of value**.

```javascript
let y = null;
console.log(y); // null
```

---

### (f) Symbol (ES6)

* Unique identifier (mostly used in objects).

```javascript
let sym1 = Symbol("id");
let sym2 = Symbol("id");
console.log(sym1 === sym2); // false (always unique)
```

---

### (g) BigInt (ES2020)

* Used for very large numbers beyond `Number.MAX_SAFE_INTEGER`.

```javascript
let big = 123456789012345678901234567890n;
console.log(big + 10n); // works
```

---

## 2. **Non-Primitive (Reference) Data Types**

👉 Stored as **references** in memory.
These include **Object, Array, Function, Date**, etc.

### (a) Object

* Collection of key–value pairs.

```javascript
let user = {
    name: "Aniket",
    age: 21,
    isAdmin: true
};
console.log(user.name); // "Aniket"
```

---

### (b) Array

* Ordered list of values (indexed from 0).

```javascript
let fruits = ["apple", "banana", "mango"];
console.log(fruits[1]); // "banana"
```

---

### (c) Function

* Functions are also objects in JS.

```javascript
function add(a, b) {
    return a + b;
}
console.log(add(2, 3)); // 5
```

---

### (d) Date (built-in object)

```javascript
let today = new Date();
console.log(today); // current date & time
```

---

## 3. 🔎 `typeof` Operator

Used to check data type:

```javascript
console.log(typeof 42);       // "number"
console.log(typeof "hello");  // "string"
console.log(typeof true);     // "boolean"
console.log(typeof undefined);// "undefined"
console.log(typeof null);     // "object" (⚠️ JS bug, known issue)
console.log(typeof Symbol()); // "symbol"
console.log(typeof 123n);     // "bigint"
console.log(typeof [1,2,3]);  // "object" (array is object)
console.log(typeof {a:1});    // "object"
console.log(typeof function(){}); // "function"
```

---

## 4. ⚡ Primitive vs Non-Primitive (Key Difference)

| Feature    | Primitive                | Non-Primitive (Reference)  |
| ---------- | ------------------------ | -------------------------- |
| Stored as  | Value itself             | Reference (memory address) |
| Immutable? | ✅ Yes                    | ❌ No (can be modified)     |
| Examples   | Number, String, Boolean… | Object, Array, Function…   |

---

✅ **Placement Tip**:
If interviewer asks **“How many data types in JS?”** → Answer:

> JavaScript has **7 primitive types** (Number, String, Boolean, Undefined, Null, Symbol, BigInt) and **non-primitive types** like Object, Array, Function, etc.

---

Great 👍 now you’re touching the foundation — **ECMAScript (ECMA standard)**.
This is very important for interviews because it shows you understand **why JavaScript behaves the way it does**.

---

# 🔹 ECMAScript (ECMA Standard)

## 1. What is ECMAScript?

* **ECMAScript (ES)** is the **official standard** that defines the core rules, syntax, and features of JavaScript.
* Maintained by **ECMA International** (a standards organization).
* JavaScript is basically an **implementation of ECMAScript**.

👉 In short:

* **ECMAScript** = Rules/Blueprint
* **JavaScript** = Practical Language (follows those rules, plus extra things like DOM, BOM, etc.)

---

## 2. Why ECMA standard?

* To make sure **all browsers** (Chrome, Firefox, Safari, Edge) run JavaScript **consistently**.
* Before the standard, different browsers had different JS versions → messy and buggy.
* Now, thanks to **ECMAScript**, every browser follows the same **core language rules**.

---

## 3. Versions of ECMAScript

Each version introduces new features to JavaScript.
Here are the **important ones for interviews**:

### **ES1 (1997)**

* The very first standard.

### **ES3 (1999)**

* Added: regular expressions, try/catch.

### **ES5 (2009)**

* Strict mode (`"use strict";`)
* Array methods (`forEach`, `map`, `filter`, `reduce`)
* JSON support

### **ES6 (2015)** ⚡ (biggest update ever)

* Introduced:

  * `let`, `const`
  * Arrow functions `()=>{}`
  * Template literals (`` `Hello ${name}` ``)
  * Classes (`class`)
  * Modules (`import`, `export`)
  * Default parameters
  * Spread/rest operators (`...`)
  * Promises (for async code)

👉 Most interview questions are based on ES6 features.

### **ES7 (2016)**

* `Array.includes()`
* Exponentiation operator (`**`)

### **ES8 (2017)**

* `async/await`
* Object methods (`Object.values`, `Object.entries`)

### **ES9 (2018)**

* Rest/Spread for objects
* `Promise.finally()`

### **ES10 (2019)**

* `Array.flat()`, `Array.flatMap()`
* `Object.fromEntries()`

### **ES11 (2020)**

* `BigInt`
* Nullish coalescing (`??`)
* Optional chaining (`?.`)

### **Latest ES (2021–2025)**

* Logical assignment operators (`||=`, `&&=`)
* `String.replaceAll()`
* Top-level `await` in modules
* Class fields & private methods (`#field`)

---

## 4. Example: ES5 vs ES6

```javascript
// ES5 way
var name = "Aniket";
var greet = "Hello " + name + "!";

// ES6 way
let name2 = "Aniket";
let greet2 = `Hello ${name2}!`;  // template literal

console.log(greet);  // Hello Aniket!
console.log(greet2); // Hello Aniket!
```

---

## 5. Interview Tip

If they ask:
**“What is the difference between ECMAScript and JavaScript?”**
👉 Answer:

> ECMAScript is the **standard specification** that defines how the JavaScript language should work. JavaScript is an **implementation** of ECMAScript with extra features like DOM APIs for web development.

---

⚡ Quick Recap:

* **ECMAScript** = Standard
* **JavaScript** = Language built on that standard
* **ES6 (2015)** = Most important update (useful in placements)

---

Perfect ✅ I’ll give you a **single final draft file** with **all data types** (primitive + non-primitive) neatly commented and structured — just like your style.

Here’s the complete **JavaScript Data Types Revision Code**:

```javascript
console.log("=== JavaScript Data Types Revision ===");

// -------------------------------------
// 1. Number
// -------------------------------------
let age = 21; // integer
let price = 99.99; // decimal
let infinity = Infinity;
let notNumber = NaN; // "Not a Number"
console.log("Number examples:", age, price, infinity, notNumber);

// -------------------------------------
// 2. String
// -------------------------------------
let name = "Aniket";
let msg = 'Hello World';
let greet = `Hello, ${name}!`; // template literal
console.log("String examples:", name, msg, greet);

// -------------------------------------
// 3. Boolean
// -------------------------------------
let isLoggedIn = true;
let isAdmin = false;
console.log("Boolean examples:", isLoggedIn, isAdmin);

// -------------------------------------
// 4. Undefined
// -------------------------------------
let x;
console.log("Undefined example:", x); // undefined

// -------------------------------------
// 5. Null
// -------------------------------------
let y = null;
console.log("Null example:", y); // null

// -------------------------------------
// 6. Symbol (ES6)
// -------------------------------------
let sym1 = Symbol("id");
let sym2 = Symbol("id");
console.log("Symbol examples:", sym1, sym2, sym1 === sym2); // false

// -------------------------------------
// 7. BigInt (ES2020)
// -------------------------------------
let big = 123456789012345678901234567890n;
console.log("BigInt example:", big + 10n);

// -------------------------------------
// 8. Object (Non-Primitive)
// -------------------------------------
let user = {
    name: "Aniket",
    age: 21,
    isAdmin: true
};
console.log("Object example:", user);

// -------------------------------------
// 9. Array (Non-Primitive)
// -------------------------------------
let fruits = ["apple", "banana", "mango"];
console.log("Array example:", fruits, "Second fruit:", fruits[1]);

// -------------------------------------
// 10. Function (Non-Primitive)
// -------------------------------------
function add(a, b) {
    return a + b;
}
console.log("Function example: add(2,3) =", add(2, 3));

// -------------------------------------
// 11. Date (Non-Primitive, Built-in Object)
// -------------------------------------
let today = new Date();
console.log("Date example:", today);

// -------------------------------------
// 12. typeof Operator
// -------------------------------------
console.log("typeof examples:");
console.log(typeof 42);        // number
console.log(typeof "hello");   // string
console.log(typeof true);      // boolean
console.log(typeof undefined); // undefined
console.log(typeof null);      // object (special case in JS)
console.log(typeof Symbol());  // symbol
console.log(typeof 123n);      // bigint
console.log(typeof [1,2,3]);   // object (array is object)
console.log(typeof {a:1});     // object
console.log(typeof function(){}); // function
```

---

✅ This file covers:

* All **7 primitive types**
* All **common non-primitive types** (Object, Array, Function, Date)
* `typeof` examples (important for interviews)

---

