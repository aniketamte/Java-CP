console.log("=== JavaScript Data Types Comparison ===");

// -------------------------------------
// 1. Equality Comparisons
// -------------------------------------

let equalityComparisons = [
  { Expression: '5 == "5"', Result: 5 == "5", Type: "Loose Equality" },
  { Expression: '5 === "5"', Result: 5 === "5", Type: "Strict Equality" },
  { Expression: "0 == false", Result: 0 == false, Type: "Loose Equality" },
  { Expression: "0 === false", Result: 0 === false, Type: "Strict Equality" },
  {
    Expression: "null == undefined",
    Result: null == undefined,
    Type: "Loose Equality",
  },
  {
    Expression: "null === undefined",
    Result: null === undefined,
    Type: "Strict Equality",
  },
  { Expression: "1 == true", Result: 1 == true, Type: "Loose Equality" },
  { Expression: "1 === true", Result: 1 === true, Type: "Strict Equality" },
];

console.log("\n--- Equality Comparisons ---");
console.table(equalityComparisons);

// -------------------------------------
// 2. Relational Comparisons
// -------------------------------------

let relationalComparisons = [
  { Expression: "10 > 5", Result: 10 > 5 },
  { Expression: "5 <= 5", Result: 5 <= 5 },
  { Expression: '"apple" > "banana"', Result: "apple" > "banana" },
  { Expression: '"cat" < "dog"', Result: "cat" < "dog" },
  { Expression: '"5" > 2', Result: "5" > 2 },
  { Expression: '"10" < 2', Result: "10" < 2 },
];

console.log("\n--- Relational Comparisons ---");
console.table(relationalComparisons);

// -------------------------------------
// 3. Boolean Comparisons
// -------------------------------------

let booleanComparisons = [
  { Expression: "true > false", Result: true > false },
  { Expression: "false == 0", Result: false == 0 },
  { Expression: "true == 1", Result: true == 1 },
  { Expression: "false < 1", Result: false < 1 },
];

console.log("\n--- Boolean Comparisons ---");
console.table(booleanComparisons);

// -------------------------------------
// 4. Null and Undefined Comparisons
// -------------------------------------

let nullUndefinedComparisons = [
  { Expression: "null == 0", Result: null == 0 },
  { Expression: "null > 0", Result: null > 0 },
  { Expression: "null >= 0", Result: null >= 0 },
  { Expression: "undefined == 0", Result: undefined == 0 },
  { Expression: "undefined > 0", Result: undefined > 0 },
  { Expression: "undefined < 0", Result: undefined < 0 },
];

console.log("\n--- Null & Undefined Comparisons ---");
console.table(nullUndefinedComparisons);

// -------------------------------------
// 5. Object Comparisons
// -------------------------------------

let obj1 = { name: "A" };
let obj2 = { name: "A" };
let obj3 = obj1;

let objectComparisons = [
  { Expression: "{} == {}", Result: {} == {} },
  { Expression: "{} === {}", Result: {} === {} },
  { Expression: "obj1 == obj2", Result: obj1 == obj2 },
  { Expression: "obj1 === obj2", Result: obj1 === obj2 },
  { Expression: "obj1 === obj3", Result: obj1 === obj3 },
];

console.log("\n--- Object Comparisons ---");
console.table(objectComparisons);

// -------------------------------------
// 6. Array Comparisons
// -------------------------------------

let arr1 = [1, 2];
let arr2 = [1, 2];
let arr3 = arr1;

let arrayComparisons = [
  { Expression: "[1,2] == [1,2]", Result: [1, 2] == [1, 2] },
  { Expression: "[1,2] === [1,2]", Result: [1, 2] === [1, 2] },
  { Expression: "arr1 === arr3", Result: arr1 === arr3 },
];

console.log("\n--- Array Comparisons ---");
console.table(arrayComparisons);
