![alt text](image.png)

Perfect! Let’s dive into **Aggregate Functions in SQL** with **simple explanations, queries, real-life examples, and interview-focused points**.

---

# SQL Aggregate Functions

**Aggregate functions** perform calculations on **a set of values** and return **a single value**. They are often used with the **`GROUP BY`** clause.

---

## 1. **Common Aggregate Functions**

| Function  | Description              | Example                             |
| --------- | ------------------------ | ----------------------------------- |
| `COUNT()` | Counts number of rows    | `SELECT COUNT(*) FROM Employee;`    |
| `SUM()`   | Adds values of a column  | `SELECT SUM(Salary) FROM Employee;` |
| `AVG()`   | Calculates average value | `SELECT AVG(Salary) FROM Employee;` |
| `MAX()`   | Finds maximum value      | `SELECT MAX(Salary) FROM Employee;` |
| `MIN()`   | Finds minimum value      | `SELECT MIN(Salary) FROM Employee;` |

---

## 2. **Examples Using Employee Table**

Assuming the same **10-row Employee table**:

```sql
-- Count total employees
SELECT COUNT(*) AS TotalEmployees FROM Employee;

-- Sum of all salaries
SELECT SUM(Salary) AS TotalSalary FROM Employee;

-- Average salary
SELECT AVG(Salary) AS AverageSalary FROM Employee;

-- Highest salary
SELECT MAX(Salary) AS HighestSalary FROM Employee;

-- Lowest salary
SELECT MIN(Salary) AS LowestSalary FROM Employee;
```

**Results Example:**

| TotalEmployees | TotalSalary | AverageSalary | HighestSalary | LowestSalary |
| -------------- | ----------- | ------------- | ------------- | ------------ |
| 10             | 578000      | 57800         | 70000         | 45000        |

---

## 3. **GROUP BY with Aggregate Functions**

**Goal:** Find **average salary per department**.

```sql
SELECT Department, AVG(Salary) AS AvgSalary
FROM Employee
WHERE Department IS NOT NULL
GROUP BY Department;
```

**Result Example:**

| Department | AvgSalary |
| ---------- | --------- |
| IT         | 55500     |
| HR         | 49000     |
| Finance    | 67500     |

**Explanation:**

* `GROUP BY Department` groups employees by their department.
* `AVG(Salary)` calculates **average per group**.
* `WHERE Department IS NOT NULL` avoids NULL departments.

---

## 4. **HAVING Clause with Aggregate Functions**

**Goal:** Get departments where **average salary > 50000**.

```sql
SELECT Department, AVG(Salary) AS AvgSalary
FROM Employee
GROUP BY Department
HAVING AVG(Salary) > 50000;
```

**Result Example:**

| Department | AvgSalary |
| ---------- | --------- |
| IT         | 55500     |
| Finance    | 67500     |

**Explanation:**

* `HAVING` filters groups based on aggregate results.
* Unlike `WHERE`, which filters rows **before aggregation**, `HAVING` filters **after aggregation**.

---

## 5. **Real-life Use Cases**

1. HR wants **total salary expense** → use `SUM(Salary)`
2. Find **highest-paid employee** → use `MAX(Salary)`
3. Department-wise reports → use `AVG`, `MIN`, `MAX` with `GROUP BY`
4. Filter groups → `HAVING` clause

---

### ✅ Interview Tips

* Remember difference:

  * `WHERE` → filters rows **before aggregation**
  * `HAVING` → filters **after aggregation**
* Common interview question:

  * “Difference between `COUNT(*)` and `COUNT(column)`?”

    * `COUNT(*)` counts all rows
    * `COUNT(column)` counts only non-NULL values

---

Perfect! Let’s create **one complete, placement-ready query example** using **Aggregate Functions**, **GROUP BY**, **HAVING**, **ORDER BY**, and **LIMIT** together, with **10 rows of Employee table**. I’ll explain everything in detail.

---

# SQL Aggregate Functions – Full Example

## 1. Employee Table with 10 Rows

```sql
CREATE TABLE Employee (
    EmpID INT PRIMARY KEY,
    Name VARCHAR(50),
    Department VARCHAR(50),
    Salary DECIMAL(10,2),
    JoiningDate DATE
);

-- Insert 10 sample employees
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

## 2. Combined Aggregate Query Example

**Goal:**

* Get **department-wise employee count and average salary**
* Only include departments with **average salary > 50000**
* Sort results by **average salary descending**
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

3. **Aggregate Functions**

   * `COUNT(EmpID)` → number of employees in each department
   * `AVG(Salary)` → average salary in the department
   * `MAX(Salary)` → highest salary in the department
   * `MIN(Salary)` → lowest salary in the department

4. **`HAVING AVG(Salary) > 50000`**

   * Filters groups to include only departments with average salary greater than 50000
   * Unlike `WHERE`, `HAVING` works **after aggregation**

5. **`ORDER BY AvgSalary DESC`**

   * Sorts results by average salary from **highest to lowest**

6. **`LIMIT 2`**

   * Returns only **top 2 departments**

---

## 4. Expected Result

| Department | EmployeeCount | AvgSalary | HighestSalary | LowestSalary |
| ---------- | ------------- | --------- | ------------- | ------------ |
| Finance    | 2             | 67500     | 70000         | 65000        |
| IT         | 4             | 55500     | 60000         | 53000        |

**Explanation:**

* **Finance** → 2 employees, average 67500, highest 70000, lowest 65000
* **IT** → 4 employees, average 55500, highest 60000, lowest 53000
* **HR** is excluded because its average salary is 49000 (< 50000)

---

## 5. Real-life Use Case

* HR wants a **report of departments with high average salary**, including:

  * Number of employees
  * Average salary
  * Highest and lowest salary
* Can combine with **LIMIT** to show **top N departments** on dashboard

---

### ✅ Interview Tips

1. Explain difference between `WHERE` and `HAVING`.
2. Know how aggregate functions like `COUNT`, `AVG`, `MAX`, `MIN` work.
3. Highlight **ORDER BY** and **LIMIT** usage for top-N results.
4. Be prepared to **modify the query** to include more filters or join with other tables.

---

