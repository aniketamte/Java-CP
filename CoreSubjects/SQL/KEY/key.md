Perfect! Let’s dive into **Primary Key and Foreign Key** in **SQL**, explained in **simple language** with **real-life examples, queries**, and **interview-focused points**. This is placement-ready.

---

# Primary Key and Foreign Key

In SQL, **keys** are used to uniquely identify records and establish relationships between tables.

---

## 1. **Primary Key (PK)**

**Definition:**

* A **Primary Key** uniquely identifies each record in a table.
* **Cannot have NULL values**.
* Each table can have **only one primary key**, but it can be **composite** (more than one column).

**Example Query:**

```sql
CREATE TABLE Department (
    DeptID INT PRIMARY KEY,  -- Unique ID for each department
    DeptName VARCHAR(50)
);
```

**Insert Example:**

```sql
INSERT INTO Department (DeptID, DeptName)
VALUES (1, 'IT'), (2, 'HR');
```

**Real-life Example:**

* `DeptID` → uniquely identifies each department.
* No two departments can have the same `DeptID`.

**Interview Tips:**

* Always mention **uniqueness** and **NOT NULL** property.
* Can be **single-column** or **composite key**.
* Common question: “What happens if you insert duplicate PK?” → SQL will throw an error.

---

## 2. **Foreign Key (FK)**

**Definition:**

* A **Foreign Key** creates a **relationship between two tables**.
* It ensures **referential integrity**, meaning the value in FK column must exist in the referenced table.
* A table can have **multiple foreign keys**.

**Example Query:**

```sql
CREATE TABLE Employee (
    EmpID INT PRIMARY KEY,         -- Primary Key
    Name VARCHAR(50),
    DeptID INT,                    -- Foreign Key column
    Salary DECIMAL(10,2),
    FOREIGN KEY (DeptID) REFERENCES Department(DeptID)  -- FK relationship
);
```

**Insert Example:**

```sql
INSERT INTO Employee (EmpID, Name, DeptID, Salary)
VALUES (1, 'Amit Sharma', 1, 50000),  -- 1 is DeptID from Department table
       (2, 'Riya Singh', 2, 45000);
```

**Real-life Example:**

* Each employee belongs to a department.
* `DeptID` in Employee table **must exist** in Department table.

**Interview Tips:**

* Often asked: “Difference between PK and FK?”

  * **PK** → uniquely identifies rows in the same table.
  * **FK** → creates a link to another table.
* Can ask about **cascading options**:

  * `ON DELETE CASCADE` → delete employee when department is deleted.
  * `ON UPDATE CASCADE` → update FK automatically when PK changes.

---

## 3. **Combined Example**

```sql
-- Department Table (Primary Key)
CREATE TABLE Department (
    DeptID INT PRIMARY KEY,
    DeptName VARCHAR(50)
);

-- Employee Table (Foreign Key referencing Department)
CREATE TABLE Employee (
    EmpID INT PRIMARY KEY,
    Name VARCHAR(50),
    DeptID INT,
    Salary DECIMAL(10,2),
    FOREIGN KEY (DeptID) REFERENCES Department(DeptID) 
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

-- Insert departments
INSERT INTO Department VALUES (1, 'IT'), (2, 'HR');

-- Insert employees
INSERT INTO Employee VALUES (1, 'Amit Sharma', 1, 50000),
                            (2, 'Riya Singh', 2, 45000);
```

**Explanation:**

* `DeptID` in Department is PK → unique for each department.
* `DeptID` in Employee is FK → must exist in Department.
* Cascading ensures **data consistency** if department is deleted or updated.

---

✅ **Placement Summary Table**

| Key Type    | Purpose                                | Properties                            | Example                                                 |
| ----------- | -------------------------------------- | ------------------------------------- | ------------------------------------------------------- |
| Primary Key | Uniquely identify a row in a table     | Unique, NOT NULL, one per table       | `EmpID` in Employee                                     |
| Foreign Key | Create relationship with another table | Values must exist in referenced table | `DeptID` in Employee referencing `DeptID` in Department |

---

Perfect! Let’s create **one single SQL example** that demonstrates **Primary Key, Foreign Key, and relationships** together. This is **placement-ready** and easy to explain in interviews.

---

````markdown
# SQL Keys – Single Example (Primary & Foreign Key)

## Scenario:
We have a company database with **Departments** and **Employees**.  
- Each department has a **unique ID** → Primary Key.  
- Each employee belongs to a department → Foreign Key.

---

## 1. Create Tables with Keys

```sql
-- Department Table with Primary Key
CREATE TABLE Department (
    DeptID INT PRIMARY KEY,       -- Primary Key
    DeptName VARCHAR(50)
);

-- Employee Table with Primary Key and Foreign Key
CREATE TABLE Employee (
    EmpID INT PRIMARY KEY,        -- Primary Key
    Name VARCHAR(50),
    DeptID INT,                   -- Foreign Key
    Salary DECIMAL(10,2),
    FOREIGN KEY (DeptID) REFERENCES Department(DeptID)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);
````

---

## 2. Insert Data

```sql
-- Insert departments
INSERT INTO Department (DeptID, DeptName)
VALUES (1, 'IT'), (2, 'HR'), (3, 'Finance');

-- Insert employees
INSERT INTO Employee (EmpID, Name, DeptID, Salary)
VALUES (1, 'Amit Sharma', 1, 50000.00),
       (2, 'Riya Singh', 2, 45000.00),
       (3, 'Vikram Patel', 1, 55000.00),
       (4, 'Sana Khan', 3, 60000.00);
```

---

## 3. Query Examples

```sql
-- Select all employees with their department
SELECT E.Name, E.Salary, D.DeptName
FROM Employee E
JOIN Department D ON E.DeptID = D.DeptID;

-- Find all employees in IT department
SELECT Name, Salary
FROM Employee
WHERE DeptID = 1;

-- Delete a department and see cascading effect
DELETE FROM Department WHERE DeptID = 3;  -- Sana Khan will also be deleted
```

---

### ✅ Explanation

* `DeptID` in **Department** → Primary Key, unique for each department.
* `EmpID` in **Employee** → Primary Key, unique for each employee.
* `DeptID` in **Employee** → Foreign Key referencing Department, ensures employees belong to valid department.
* `ON DELETE CASCADE` → deletes all employees in a department if the department is deleted.
* `ON UPDATE CASCADE` → automatically updates Employee’s DeptID if DeptID changes in Department.

---

### Real-life Understanding

* **Primary Key:** `DeptID` and `EmpID` → uniquely identify departments and employees.
* **Foreign Key:** `DeptID` in Employee → links employee to department.
* Ensures **data integrity**: no employee can exist without a valid department.

---

