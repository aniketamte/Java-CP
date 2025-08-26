![alt text](image-3.png)

Perfect! Let’s dive into the **`HAVING` clause in SQL** with **simple explanations, examples, real-life use cases, and interview-focused points**.

---

# SQL HAVING Clause

The **`HAVING` clause** is used to **filter groups** created by the **`GROUP BY` clause** based on **aggregate function results**.

> Unlike `WHERE`, which filters **rows before aggregation**, `HAVING` filters **after aggregation**.

---

## 1. **Basic Syntax**

```sql
SELECT column1, AGGREGATE_FUNCTION(column2)
FROM table_name
GROUP BY column1
HAVING AGGREGATE_FUNCTION(column2) condition;
```

* `column1` → the column to group by
* `AGGREGATE_FUNCTION(column2)` → function like `COUNT()`, `SUM()`, `AVG()`, etc.
* `condition` → condition on the aggregated value

---

## 2. **Example – Employee Table**

Assume the same **Employee table with 10 rows**:

| EmpID | Name         | Department | Salary |
| ----- | ------------ | ---------- | ------ |
| 1     | Amit Sharma  | IT         | 55000  |
| 2     | Riya Singh   | HR         | 48000  |
| 3     | Vikram Patel | IT         | 60000  |
| 4     | Sana Khan    | NULL       | 45000  |
| 5     | Karan Mehta  | Finance    | 70000  |
| 6     | Anita Roy    | HR         | 52000  |
| 7     | Rahul Verma  | IT         | 53000  |
| 8     | Priya Sharma | Finance    | 65000  |
| 9     | Neha Gupta   | HR         | 47000  |
| 10    | Aditya Singh | IT         | 58000  |

---

## 3. **Example 1 – Filter Departments with Average Salary > 50000**

```sql
SELECT Department, AVG(Salary) AS AvgSalary
FROM Employee
WHERE Department IS NOT NULL
GROUP BY Department
HAVING AVG(Salary) > 50000;
```

**Result:**

| Department | AvgSalary |
| ---------- | --------- |
| IT         | 55500     |
| Finance    | 67500     |

**Explanation:**

* Groups employees by department
* Calculates `AVG(Salary)` for each department
* `HAVING` filters out departments where average salary ≤ 50000

---

## 4. **Example 2 – Departments with More Than 3 Employees**

```sql
SELECT Department, COUNT(EmpID) AS EmployeeCount
FROM Employee
WHERE Department IS NOT NULL
GROUP BY Department
HAVING COUNT(EmpID) > 3;
```

**Result:**

| Department | EmployeeCount |
| ---------- | ------------- |
| IT         | 4             |

**Explanation:**

* `COUNT(EmpID)` counts employees per department
* `HAVING COUNT(EmpID) > 3` filters only departments with **more than 3 employees**

---

## 5. **Example 3 – Multiple Conditions in HAVING**

```sql
SELECT Department,
       COUNT(EmpID) AS EmployeeCount,
       AVG(Salary) AS AvgSalary
FROM Employee
WHERE Department IS NOT NULL
GROUP BY Department
HAVING COUNT(EmpID) >= 2 AND AVG(Salary) > 50000;
```

**Result:**

| Department | EmployeeCount | AvgSalary |
| ---------- | ------------- | --------- |
| IT         | 4             | 55500     |
| Finance    | 2             | 67500     |

**Explanation:**

* Filters departments having **at least 2 employees**
* And **average salary greater than 50000**

---

## 6. **Real-life Use Cases**

1. **HR Reports:** Only show departments with **high average salaries** or **many employees**
2. **Sales Data:** Show regions with **total sales above a threshold**
3. **Analytics:** Group users by category and show only **popular categories**

---

### ✅ Interview Tips

1. `HAVING` is always used with **aggregate functions**
2. `WHERE` filters rows **before grouping**, `HAVING` filters **after grouping**
3. Often combined with **GROUP BY**, `ORDER BY`, and `LIMIT`
4. Common question:

   * Difference between `WHERE` and `HAVING`
   * Example: “Why can’t we use `AVG(Salary) > 50000` in `WHERE`?” → Aggregates work **after rows are grouped**, so only `HAVING` can filter

---

Perfect! Let’s create **one complete, placement-ready SQL example** using **`GROUP BY`**, **aggregate functions**, **`HAVING`**, **`ORDER BY`**, and **`LIMIT`** together with **10 rows of Employee table**. I’ll explain everything step by step.

---

# SQL HAVING Clause – Full Example

## 1. Employee Table (10 Rows)

```sql
CREATE TABLE Employee (
    EmpID INT PRIMARY KEY,
    Name VARCHAR(50),
    Department VARCHAR(50),
    Salary DECIMAL(10,2),
    JoiningDate DATE
);

INSERT INTO Employee (EmpID, Name, Department, Salary, JoiningDate)
VALUES 
(1, 'Amit Sharma', 'IT', 55000, '2023-06-15'),
(2, 'Riya Singh', 'HR', 48000, '2022-11-20'),
(3, 'Vikram Patel', 'IT', 60000, '2021-09-10'),
(4, 'Sana Khan', NULL, 45000, '2024-01-05'),
(5, 'Karan Mehta', 'Finance', 70000, '2020-03-12'),
(6, 'Anita Roy', 'HR', 52000, '2023-02-18'),
(7, 'Rahul Verma', 'IT', 53000, '2022-05-30'),
(8, 'Priya Sharma', 'Finance', 65000, '2021-12-11'),
(9, 'Neha Gupta', 'HR', 47000, '2023-08-01'),
(10, 'Aditya Singh', 'IT', 58000, '2022-10-22');
```

---

## 2. Complete HAVING Example Query

**Goal:**

* Group employees by **Department**
* Show **employee count, average salary, max & min salary**
* Only include departments where **average salary > 50000**
* Sort by **average salary descending**
* Return **top 2 departments only**

```sql
SELECT 
    Department,
    COUNT(EmpID) AS EmployeeCount,
    AVG(Salary) AS AvgSalary,
    MAX(Salary) AS HighestSalary,
    MIN(Salary) AS LowestSalary
FROM Employee
WHERE Department IS NOT NULL
GROUP BY Department
HAVING AVG(Salary) > 50000
ORDER BY AvgSalary DESC
LIMIT 2;
```

---

## 3. Step-by-Step Explanation

1. **`WHERE Department IS NOT NULL`**

   * Excludes employees without a department (like Sana Khan).

2. **`GROUP BY Department`**

   * Groups employees by their department (`IT`, `HR`, `Finance`).

3. **Aggregate Functions:**

   * `COUNT(EmpID)` → number of employees per department
   * `AVG(Salary)` → average salary per department
   * `MAX(Salary)` → highest salary per department
   * `MIN(Salary)` → lowest salary per department

4. **`HAVING AVG(Salary) > 50000`**

   * Filters groups with average salary greater than 50000
   * `HAVING` works **after aggregation**, unlike `WHERE`

5. **`ORDER BY AvgSalary DESC`**

   * Sorts grouped results by average salary descending

6. **`LIMIT 2`**

   * Returns **top 2 departments only**

---

## 4. Expected Result

| Department | EmployeeCount | AvgSalary | HighestSalary | LowestSalary |
| ---------- | ------------- | --------- | ------------- | ------------ |
| Finance    | 2             | 67500     | 70000         | 65000        |
| IT         | 4             | 55500     | 60000         | 53000        |

**Explanation:**

* **Finance:** 2 employees, average 67500
* **IT:** 4 employees, average 55500
* **HR** is excluded because its average salary is 49000 (< 50000)

---

## 5. Real-life Use Case

* HR wants a **department-wise summary report**:

  * Number of employees
  * Average salary
  * Salary range (max/min)
* Can combine with **LIMIT** to display **top N departments** on a dashboard

---

### ✅ Interview Tips

1. `HAVING` filters **aggregated results**, while `WHERE` filters **individual rows**.
2. Can combine `HAVING` with `GROUP BY`, `ORDER BY`, `LIMIT` for **top-N aggregated insights**.
3. Common interview questions:

   * Difference between `WHERE` and `HAVING`
   * Explain why aggregate functions cannot be used in `WHERE`

---

