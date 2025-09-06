console.log("=== JavaScript Type Conversion & Operations ===");

// -------------------------------------
// 1. Explicit Conversion
// -------------------------------------

console.log("\n--- 1. Explicit Conversion ---");

// Number Conversion
let strNum = "123";
console.log(Number(strNum)); // 123
console.log(Number("abc")); // NaN
console.log(parseInt("100.5")); // 100
console.log(parseFloat("100.5")); // 100.5

// String Conversion
let num = 99;
console.log(String(num)); // "99"
console.log((123).toString()); // "123"

// Boolean Conversion
console.log(Boolean(1)); // true
console.log(Boolean(0)); // false
console.log(Boolean("hello")); // true
console.log(Boolean("")); // false
console.log(Boolean(null)); // false
console.log(Boolean(undefined)); // false

// -------------------------------------
// 2. Implicit Conversion (Type Coercion)
// -------------------------------------

console.log("\n--- 2. Implicit Conversion ---");

// Number + String
console.log("5" + 1); // "51"  (number → string)
console.log("10" + 20); // "1020"

// Number - String
console.log("10" - 5); // 5
console.log("10" * 2); // 20
console.log("10" / 2); // 5

// Boolean in Arithmetic
console.log(true + 1); // 2  (true → 1)
console.log(false + 1); // 1  (false → 0)

// Null and Undefined
console.log(null + 1); // 1  (null → 0)
console.log(undefined + 1); // NaN (undefined → NaN)

// -------------------------------------
// 3. Tricky Examples (Common in Interviews)
// -------------------------------------

console.log("\n--- 3. Tricky Examples ---");

console.log("5" + 1); // "51"  (string concatenation)
console.log("5" - 1); // 4     (string → number)
console.log("5" * "2"); // 10    (both converted to numbers)
console.log(1 + true); // 2     (true → 1)
console.log(1 + false); // 1     (false → 0)
console.log(1 + null); // 1     (null → 0)
console.log(1 + undefined); // NaN    (undefined → NaN)

// -------------------------------------
// 4. Equality Operators (== vs ===)
// -------------------------------------

console.log("\n--- 4. Equality Operators ---");

// Loose equality (==) does type conversion
console.log(5 == "5"); // true
console.log(null == undefined); // true

// Strict equality (===) checks type + value
console.log(5 === "5"); // false
console.log(null === undefined); // false

// -------------------------------------
// 5. Summary Examples
// -------------------------------------
console.log("\n--- 5. Summary Examples ---");

console.log('"5" + 2 =', "5" + 2); // "52" (string)
console.log('"5" - 2 =', "5" - 2); // 3    (number)
console.log("true + 1 =", true + 1); // 2
console.log("false + 1 =", false + 1); // 1
console.log("null + 1 =", null + 1); // 1
console.log("undefined + 1 =", undefined + 1); // NaN
console.log('5 == "5" →', 5 == "5"); // true
console.log('5 === "5" →', 5 === "5"); // false


console.log("=== JavaScript Data Types & Conversion Revision ===");

// -------------------------------------
// 1. Primitive Data Types
// -------------------------------------

let age = 21; // Number
let price = 99.99;
let infinity = Infinity;
let notNumber = NaN;

let name = "Aniket"; // String
let msg = "Hello World";
let greet = `Hello, ${name}!`;

let isLoggedIn = true; // Boolean
let isAdmin = false;

let x; // Undefined
let y = null; // Null

let sym1 = Symbol("id"); // Symbol
let sym2 = Symbol("id");

let big = 123456789012345678901234567890n; // BigInt

// Display primitive types in table
console.table([
  { Type: "Number", Examples: `${age}, ${price}, ${infinity}, ${notNumber}` },
  { Type: "String", Examples: `${name}, ${msg}, ${greet}` },
  { Type: "Boolean", Examples: `${isLoggedIn}, ${isAdmin}` },
  { Type: "Undefined", Examples: x },
  { Type: "Null", Examples: y },
  { Type: "Symbol", Examples: `${sym1.toString()}, ${sym2.toString()}` },
  { Type: "BigInt", Examples: big },
]);

// -------------------------------------
// 2. Non-Primitive Types
// -------------------------------------

let user = { name: "Aniket", age: 21, isAdmin: true };
let fruits = ["apple", "banana", "mango"];
function add(a, b) {
  return a + b;
}
let today = new Date();

// Display objects/arrays in table
console.table(user);
console.table(fruits.map((fruit, i) => ({ Index: i, Fruit: fruit })));

// -------------------------------------
// 3. Type Conversion Examples
// -------------------------------------

let explicitConversions = [
  { Expression: 'Number("123")', Result: Number("123") },
  { Expression: 'Number("abc")', Result: Number("abc") },
  { Expression: 'parseInt("100.5")', Result: parseInt("100.5") },
  { Expression: 'parseFloat("100.5")', Result: parseFloat("100.5") },
  { Expression: "String(99)", Result: String(99) },
  { Expression: "Boolean(1)", Result: Boolean(1) },
  { Expression: "Boolean(0)", Result: Boolean(0) },
];

console.table(explicitConversions);

// -------------------------------------
// 4. Implicit Conversion / Tricky Operations
// -------------------------------------

let trickyOperations = [
  { Expression: '"5" + 1', Result: "5" + 1 },
  { Expression: '"5" - 1', Result: "5" - 1 },
  { Expression: '"5" * "2"', Result: "5" * "2" },
  { Expression: "1 + true", Result: 1 + true },
  { Expression: "1 + false", Result: 1 + false },
  { Expression: "1 + null", Result: 1 + null },
  { Expression: "1 + undefined", Result: 1 + undefined },
  { Expression: '5 == "5"', Result: 5 == "5" },
  { Expression: '5 === "5"', Result: 5 === "5" },
];

console.table(trickyOperations);

// -------------------------------------
// 5. Primitive vs Reference Types
// -------------------------------------

let a = 10;
let b = a;
b = 20;

let obj1 = { name: "Aniket" };
let obj2 = obj1;
obj2.name = "Rahul";

let arr1 = [1, 2, 3];
let arr2 = arr1;
arr2.push(4);

// Show results in table
console.table([
  { Type: "Primitive Copy", a, b },
  {
    Type: "Object Copy (Reference)",
    obj1: JSON.stringify(obj1),
    obj2: JSON.stringify(obj2),
  },
  {
    Type: "Array Copy (Reference)",
    arr1: arr1.join(","),
    arr2: arr2.join(","),
  },
]);
