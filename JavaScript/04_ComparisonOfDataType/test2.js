console.log("=== JavaScript Data Types Comparison ===");

// -------------------------------------
// 1. Equality Comparisons
// -------------------------------------

console.log("\n--- Equality Comparisons ---");
console.log('5 == "5" →', 5 == "5"); // true (loose equality)
console.log('5 === "5" →', 5 === "5"); // false (strict equality)
console.log("0 == false →", 0 == false); // true
console.log("0 === false →", 0 === false); // false
console.log("null == undefined →", null == undefined); // true
console.log("null === undefined →", null === undefined); // false
console.log("1 == true →", 1 == true); // true
console.log("1 === true →", 1 === true); // false

// -------------------------------------
// 2. Relational Comparisons
// -------------------------------------

console.log("\n--- Relational Comparisons ---");
console.log("10 > 5 →", 10 > 5); // true
console.log("5 <= 5 →", 5 <= 5); // true
console.log('"apple" > "banana" →', "apple" > "banana"); // false
console.log('"cat" < "dog" →', "cat" < "dog"); // true
console.log('"5" > 2 →', "5" > 2); // true (string → number)
console.log('"10" < 2 →', "10" < 2); // false

// -------------------------------------
// 3. Boolean Comparisons
// -------------------------------------

console.log("\n--- Boolean Comparisons ---");
console.log("true > false →", true > false); // true (true → 1, false → 0)
console.log("false == 0 →", false == 0); // true
console.log("true == 1 →", true == 1); // true
console.log("false < 1 →", false < 1); // true

// -------------------------------------
// 4. Null and Undefined Comparisons
// -------------------------------------

console.log("\n--- Null & Undefined Comparisons ---");
console.log("null == 0 →", null == 0); // false
console.log("null > 0 →", null > 0); // false
console.log("null >= 0 →", null >= 0); // true
console.log("undefined == 0 →", undefined == 0); // false
console.log("undefined > 0 →", undefined > 0); // false
console.log("undefined < 0 →", undefined < 0); // false

// -------------------------------------
// 5. Object Comparisons
// -------------------------------------

console.log("\n--- Object Comparisons ---");
let obj1 = { name: "A" };
let obj2 = { name: "A" };
let obj3 = obj1;

console.log("{} == {} →", {} == {}); // false (different references)
console.log("{} === {} →", {} === {}); // false
console.log("obj1 == obj2 →", obj1 == obj2); // false
console.log("obj1 === obj2 →", obj1 === obj2); // false
console.log("obj1 === obj3 →", obj1 === obj3); // true (same reference)

// -------------------------------------
// 6. Array Comparisons
// -------------------------------------

console.log("\n--- Array Comparisons ---");
let arr1 = [1, 2];
let arr2 = [1, 2];
let arr3 = arr1;

console.log("[1,2] == [1,2] →", [1, 2] == [1, 2]); // false
console.log("[1,2] === [1,2] →", [1, 2] === [1, 2]); // false
console.log("arr1 === arr3 →", arr1 === arr3); // true (same reference)
