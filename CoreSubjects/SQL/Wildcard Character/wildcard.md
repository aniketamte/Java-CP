Perfect! Let’s dive into **Wildcard Characters in SQL** with **simple explanations, queries, and real-life examples**. This is placement-friendly.

---

# Wildcard Characters in SQL

**Wildcard characters** are used with the **`LIKE` operator** to search for patterns in strings.

---

## 1. **Common Wildcards**

| Wildcard | Meaning                              | Example Pattern | Matches                  |
| -------- | ------------------------------------ | --------------- | ------------------------ |
| `%`      | Zero or more characters              | `'A%'`          | `Amit`, `Aniket`, `Aman` |
| `_`      | Exactly one character                | `'A_It'`        | `Amit`, `Abit`           |
| `[ ]`    | Any single character within brackets | `'[AB]mit'`     | `Amit`, `Bmit`           |
| `[^ ]`   | Any single character NOT in brackets | `'[^AB]mit'`    | `Cmit`, `Dmit`           |

> Note: `[ ]` and `[^ ]` are mostly supported in **SQL Server**; `%` and `_` are universal.

---

## 2. **Basic Usage**

### a) Using `%` (Zero or more characters)

```sql
-- Find employees whose name starts with 'A'
SELECT Name FROM Employee
WHERE Name LIKE 'A%';
```

**Matches:** Amit, Aniket, Aman

```sql
-- Find employees whose name ends with 'n'
SELECT Name FROM Employee
WHERE Name LIKE '%n';
```

**Matches:** Riyan, Karan

```sql
-- Find employees whose name contains 'it'
SELECT Name FROM Employee
WHERE Name LIKE '%it%';
```

**Matches:** Amit, Vikram Patel

---

### b) Using `_` (Single character)

```sql
-- Find employees with 4-letter names starting with 'A'
SELECT Name FROM Employee
WHERE Name LIKE 'A___';
```

**Matches:** Amit

---

### c) Using `[ ]` (Character set – SQL Server)

```sql
-- Names starting with A or R
SELECT Name FROM Employee
WHERE Name LIKE '[AR]%';
```

**Matches:** Amit, Riya

### d) Using `[^ ]` (Negation – SQL Server)

```sql
-- Names not starting with A or R
SELECT Name FROM Employee
WHERE Name LIKE '[^AR]%';
```

**Matches:** Vikram, Sana, Karan

---

## 3. **Real-life Examples**

1. **Search employees starting with 'A'** → HR wants quick lookup of employees.
2. **Find email domains** → `%@gmail.com` matches all Gmail users.
3. **Validate codes or IDs** → `_1__` matches IDs with specific pattern.

---

## 4. **Combined Example**

```sql
-- Find employees whose name starts with 'A' and contains 'it'
SELECT Name FROM Employee
WHERE Name LIKE 'A%it%';
```

**Explanation:**

* `A%` → starts with A
* `%it%` → contains "it" anywhere after A

---

### ✅ Interview Tips

* `%` → zero or more characters, `_` → exactly one character.
* Often asked in **pattern matching questions** or **string searches**.
* Can combine with **WHERE, AND, OR** for complex filtering.
* Remember: `[ ]` and `[^ ]` are **SQL Server specific**, `%` and `_` are universal.

---

Perfect! Let’s create **one single combined SQL example** that uses:

* `SELECT`
* `WHERE`
* `BETWEEN`
* `IN`
* `AND`, `OR`, `NOT`
* `IS NULL`
* `LIKE` and **wildcards**

This will be **placement-ready** and demonstrates multiple operators together.

---

````markdown
# SQL Combined Example – Filtering & Wildcards

## Scenario:
We have an `Employee` table. We want to **retrieve employees** using multiple filters and patterns.

---

## Employee Table Example

```sql
CREATE TABLE Employee (
    EmpID INT PRIMARY KEY,
    Name VARCHAR(50),
    Department VARCHAR(50),
    Salary DECIMAL(10,2),
    JoiningDate DATE
);

-- Sample Data
INSERT INTO Employee (EmpID, Name, Department, Salary, JoiningDate)
VALUES 
(1, 'Amit Sharma', 'IT', 55000.00, '2023-06-15'),
(2, 'Riya Singh', 'HR', 48000.00, '2022-11-20'),
(3, 'Vikram Patel', 'IT', 60000.00, '2021-09-10'),
(4, 'Sana Khan', NULL, 45000.00, '2024-01-05'),
(5, 'Karan Mehta', 'Finance', 70000.00, '2020-03-12'),
(6, 'Anita Roy', 'HR', 52000.00, '2023-02-18');
````

---

## Combined Query Example

```sql
-- Retrieve employees who:
-- 1. Are in IT or HR department
-- 2. Have salary between 45000 and 60000
-- 3. Name starts with 'A'
-- 4. Exclude employees with NULL department
SELECT Name, Department, Salary
FROM Employee
WHERE Department IN ('IT','HR')        -- IT or HR
  AND Salary BETWEEN 45000 AND 60000    -- Salary range
  AND Name LIKE 'A%'                    -- Name starts with 'A'
  AND Department IS NOT NULL            -- Exclude NULL department
  AND NOT Name = 'Anita Roy';           -- Exclude specific employee
```

**Result:**

| Name        | Department | Salary   |
| ----------- | ---------- | -------- |
| Amit Sharma | IT         | 55000.00 |

---

### Explanation:

1. **Department IN ('IT','HR')** → select IT or HR employees
2. **Salary BETWEEN 45000 AND 60000** → salary range filter
3. **Name LIKE 'A%'** → names starting with 'A' (wildcard `%`)
4. **Department IS NOT NULL** → exclude employees without a department
5. **NOT Name = 'Anita Roy'** → exclude specific employee

**Real-life Example:**

* HR wants a list of IT and HR employees eligible for a bonus, starting with ‘A’, ignoring exceptions, and avoiding unassigned employees.

---

### ✅ Interview Tips:

* This type of **combined query** shows your understanding of multiple operators together.
* Use **parentheses** if mixing `AND` and `OR` to avoid logical errors.
* Recruiters may ask:

  * Explain how each filter works
  * Difference between `BETWEEN` and `>= … AND <= …`
  * Difference between `IN` and multiple `OR` conditions

---

