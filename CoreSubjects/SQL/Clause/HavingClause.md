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

