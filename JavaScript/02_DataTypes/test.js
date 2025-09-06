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
let msg = "Hello World";
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
  isAdmin: true,
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
console.log(typeof 42); // number
console.log(typeof "hello"); // string
console.log(typeof true); // boolean
console.log(typeof undefined); // undefined
console.log(typeof null); // object (special case in JS)
console.log(typeof Symbol()); // symbol
console.log(typeof 123n); // bigint
console.log(typeof [1, 2, 3]); // object (array is object)
console.log(typeof { a: 1 }); // object
console.log(typeof function () {}); // function

//primitive
//no
//bigint
//string = ""
//boolean
//null => standalone value
//undefined
//symbol ==> use for uniqueness