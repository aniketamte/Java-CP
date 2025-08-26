Perfect! Let’s dive into **`DUAL` table in SQL**, explained **simply**, with **queries, real-life examples, and interview tips**.

---

# DUAL Table in SQL

The `DUAL` table is a **special one-row, one-column table** in SQL. It is commonly used in **Oracle SQL** and supported by many databases for **selecting a value without referencing an actual table**.

---

## 1. **Key Points about DUAL Table**

* **Contains one row and one column** by default.
* Used when a **query requires a table reference** but you don’t need actual data.
* In Oracle, it has a column called `DUMMY` with a value `'X'`.
* Useful for **calculations, functions, or system values** without touching real tables.

---

## 2. **Basic Syntax**

```sql
SELECT <expression> FROM DUAL;
```

---

## 3. **Examples**

### a) Select a Constant Value

```sql
SELECT 'Hello, World!' AS Greeting
FROM DUAL;
```

**Result:**

| GREETING      |
| ------------- |
| Hello, World! |

**Explanation:**

* No actual table needed; just returned the string.

---

### b) Perform Arithmetic Calculation

```sql
SELECT 10 + 20 AS Sum FROM DUAL;
```

**Result:**

| SUM |
| --- |
| 30  |

**Explanation:**

* Useful for testing expressions, formulas, or calculations in SQL.

---

### c) Get System Date or Function Output

```sql
SELECT SYSDATE AS Today FROM DUAL;
```

**Result:**

| TODAY             |
| ----------------- |
| 26-AUG-2025 22:00 |

**Explanation:**

* Retrieve current date/time without a real table.

---

### d) Using Functions

```sql
SELECT UPPER('aniket') AS NameUpper FROM DUAL;
```

**Result:**

| NAMEUPPER |
| --------- |
| ANIKET    |

---

## 4. **Interview Points**

* `DUAL` is **mostly used in Oracle**, but other DBMS like MySQL or SQL Server allow `SELECT <expr>` without a table.
* Common interview question:

  * “What is the DUAL table used for?” → For **selecting a value, performing calculations, or calling functions** without a table.
* Can be combined with **expressions, string manipulation, or system functions**.

---

## 5. **Real-life Use Cases**

1. **Testing Queries:** Quickly check calculation or function outputs.
2. **Generating Dummy Data:** For reports or scripts without accessing real tables.
3. **System Info:** Fetch current date, time, or system values.

---

### ✅ Summary Table

| Feature      | Description                                                       |
| ------------ | ----------------------------------------------------------------- |
| Rows/Columns | 1 row, 1 column (`DUMMY`)                                         |
| Purpose      | Execute expressions, functions, or constants without a real table |
| Common Use   | SELECT calculations, system date, string functions                |
| Database     | Mostly Oracle (MySQL/SQL Server allow SELECT without table)       |

---

Perfect! Let’s break down **SQL SELECT queries with filters** including `WHERE`, `BETWEEN`, `IN`, `AND`, `OR`, `NOT`, `IS NULL` in a **simple, placement-ready way** with **real-life examples and queries**.

---

# SQL SELECT & Filtering Commands

The **SELECT statement** is used to **retrieve data from one or more tables**. To filter results, we use the **WHERE clause** and logical operators.

---

## 1. **SELECT**

**Purpose:** Retrieve data from a table.

```sql
-- Select all columns
SELECT * FROM Employee;

-- Select specific columns
SELECT Name, Salary FROM Employee;
```

**Real-life example:**

* HR wants to see all employee names and salaries.

---

## 2. **WHERE**

**Purpose:** Filter records based on a condition.

```sql
-- Select employees with salary > 50000
SELECT * FROM Employee
WHERE Salary > 50000;
```

**Real-life example:**

* Find employees eligible for a bonus.

---

## 3. **BETWEEN**

**Purpose:** Filter values within a range (inclusive).

```sql
-- Employees with salary between 40000 and 60000
SELECT Name, Salary FROM Employee
WHERE Salary BETWEEN 40000 AND 60000;
```

**Real-life example:**

* Find employees whose salary falls in a particular bracket.

---

## 4. **IN**

**Purpose:** Filter values that match any value in a list.

```sql
-- Employees in IT or HR department
SELECT Name, Department FROM Employee
WHERE Department IN ('IT', 'HR');
```

**Real-life example:**

* Select employees from specific departments.

---

## 5. **AND, OR, NOT**

**Purpose:** Combine multiple conditions.

```sql
-- Employees in IT department AND salary > 50000
SELECT Name, Salary FROM Employee
WHERE Department = 'IT' AND Salary > 50000;

-- Employees in IT OR HR department
SELECT Name, Department FROM Employee
WHERE Department = 'IT' OR Department = 'HR';

-- Employees NOT in HR department
SELECT Name, Department FROM Employee
WHERE NOT Department = 'HR';
```

**Real-life example:**

* AND → Employees eligible for bonus (IT department AND high salary)
* OR → Employees from multiple departments
* NOT → Exclude a department or condition

---

## 6. **IS NULL / IS NOT NULL**

**Purpose:** Check for missing or NULL values.

```sql
-- Employees with no department assigned
SELECT Name FROM Employee
WHERE Department IS NULL;

-- Employees who have a department assigned
SELECT Name FROM Employee
WHERE Department IS NOT NULL;
```

**Real-life example:**

* HR wants to find employees not yet assigned to a department.

---

## 7. **Combined Example Query**

```sql
-- Select employees from IT or HR with salary between 40000 and 60000, excluding NULL departments
SELECT Name, Department, Salary
FROM Employee
WHERE Department IN ('IT', 'HR')
  AND Salary BETWEEN 40000 AND 60000
  AND Department IS NOT NULL;
```

**Explanation:**

* `IN` → select IT or HR
* `BETWEEN` → salary in range
* `AND` → combine multiple conditions
* `IS NOT NULL` → exclude employees without department

---

### ✅ Summary Table for Placement

| Keyword     | Purpose                       | Example                                |
| ----------- | ----------------------------- | -------------------------------------- |
| SELECT      | Retrieve data                 | `SELECT Name, Salary FROM Employee;`   |
| WHERE       | Filter records                | `WHERE Salary > 50000`                 |
| BETWEEN     | Range filtering               | `WHERE Salary BETWEEN 40000 AND 60000` |
| IN          | Match values in list          | `WHERE Department IN ('IT','HR')`      |
| AND         | Combine conditions (all true) | `WHERE Dept='IT' AND Salary>50000`     |
| OR          | Combine conditions (any true) | `WHERE Dept='IT' OR Dept='HR'`         |
| NOT         | Negate condition              | `WHERE NOT Dept='HR'`                  |
| IS NULL     | Check missing value           | `WHERE Department IS NULL`             |
| IS NOT NULL | Check not missing             | `WHERE Department IS NOT NULL`         |

---

Perfect! Let’s create **one single combined example** that uses **SELECT, WHERE, BETWEEN, IN, AND, OR, NOT, IS NULL** together in a **realistic company scenario**. This is **placement-ready** and easy to explain.

---

````markdown
# SQL Filtering – Combined Example

## Scenario:
We have an `Employee` table containing employee details. We want to **retrieve specific employees** using multiple filters.

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

-- Insert sample data
INSERT INTO Employee (EmpID, Name, Department, Salary, JoiningDate)
VALUES 
(1, 'Amit Sharma', 'IT', 55000.00, '2023-06-15'),
(2, 'Riya Singh', 'HR', 48000.00, '2022-11-20'),
(3, 'Vikram Patel', 'IT', 60000.00, '2021-09-10'),
(4, 'Sana Khan', NULL, 45000.00, '2024-01-05'),
(5, 'Karan Mehta', 'Finance', 70000.00, '2020-03-12');
````

---

## Combined SELECT Query Example

```sql
-- Find employees from IT or HR departments,
-- with salary between 45000 and 60000,
-- excluding employees with NULL department
SELECT Name, Department, Salary
FROM Employee
WHERE Department IN ('IT', 'HR')           -- IT or HR
  AND Salary BETWEEN 45000 AND 60000       -- Salary range
  AND Department IS NOT NULL               -- Exclude NULL
  AND NOT Name = 'Riya Singh';             -- Exclude specific employee
```

**Result:**

| Name         | Department | Salary   |
| ------------ | ---------- | -------- |
| Amit Sharma  | IT         | 55000.00 |
| Vikram Patel | IT         | 60000.00 |

---

### Explanation:

1. **Department IN ('IT','HR')** → Select only employees in IT or HR.
2. **Salary BETWEEN 45000 AND 60000** → Filter employees with salary in the given range.
3. **Department IS NOT NULL** → Exclude employees who don’t have a department assigned.
4. **NOT Name = 'Riya Singh'** → Exclude a specific employee.

**Real-life Example:**

* HR wants a list of IT and HR employees eligible for a bonus, ignoring employees without department or specific exceptions.

---

### ✅ Interview Tip:

* Combined queries like this **test your understanding of multiple operators** together.
* Always mention **priority**: `AND` has higher precedence than `OR`, use parentheses if needed.
* Recruiters may ask: “Explain how this query works step by step.”

---

