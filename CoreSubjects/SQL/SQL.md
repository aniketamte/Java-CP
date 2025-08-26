Great! Let’s break down **SQL Datatypes** in a simple, placement-friendly way that you can directly add to your `README.md`. I’ll explain the **types**, **real-life examples**, and **queries**.

---

# SQL Datatypes

In SQL, **datatypes** define the type of data that can be stored in a column of a table. Choosing the correct datatype is important because it ensures **data integrity**, **efficient storage**, and **faster queries**.

---

## 1. **Numeric Datatypes**

Used to store numbers.

| Datatype                         | Description                                          | Example                           |
| -------------------------------- | ---------------------------------------------------- | --------------------------------- |
| `INT`                            | Integer numbers (whole numbers)                      | `25`, `-100`                      |
| `SMALLINT`                       | Smaller range integers                               | `1000`                            |
| `BIGINT`                         | Very large integers                                  | `1234567890123`                   |
| `DECIMAL(p,s)` or `NUMERIC(p,s)` | Fixed-point numbers with precision `p` and scale `s` | `DECIMAL(5,2)` can store `123.45` |
| `FLOAT` / `REAL`                 | Approximate decimal numbers                          | `3.14159`                         |

**Example Query:**

```sql
CREATE TABLE Employee (
    EmpID INT,
    Salary DECIMAL(10,2),
    Bonus FLOAT
);
```

**Real-life example:**

* `EmpID` → always a whole number
* `Salary` → exact amount, needs 2 decimal points
* `Bonus` → can have approximate decimal

---

## 2. **Character/String Datatypes**

Used to store text.

| Datatype     | Description                                  | Example                         |
| ------------ | -------------------------------------------- | ------------------------------- |
| `CHAR(n)`    | Fixed-length string, always `n` characters   | `'Amit   '` (if `n=6`)          |
| `VARCHAR(n)` | Variable-length string, up to `n` characters | `'Amit'`                        |
| `TEXT`       | Large text, like paragraphs                  | `'This is a long description.'` |

**Example Query:**

```sql
CREATE TABLE Customer (
    CustomerID INT,
    Name VARCHAR(50),
    Address TEXT
);
```

**Real-life example:**

* `Name` → variable length, because names can be short or long
* `Address` → can be very long, so we use `TEXT`

---

## 3. **Date and Time Datatypes**

Used to store dates and times.

| Datatype                 | Description               | Example                 |
| ------------------------ | ------------------------- | ----------------------- |
| `DATE`                   | Stores date only          | `'2025-08-26'`          |
| `TIME`                   | Stores time only          | `'14:30:00'`            |
| `DATETIME` / `TIMESTAMP` | Stores both date and time | `'2025-08-26 14:30:00'` |
| `YEAR`                   | Stores only year          | `2025`                  |

**Example Query:**

```sql
CREATE TABLE Orders (
    OrderID INT,
    OrderDate DATE,
    DeliveryTime TIME,
    CreatedAt DATETIME
);
```

**Real-life example:**

* `OrderDate` → only the date of order
* `DeliveryTime` → exact time of delivery
* `CreatedAt` → timestamp of order creation

---

## 4. **Boolean / Logical Datatype**

Stores `TRUE` or `FALSE`.

| Datatype          | Description   | Example         |
| ----------------- | ------------- | --------------- |
| `BOOLEAN` / `BIT` | True or False | `TRUE`, `FALSE` |

**Example Query:**

```sql
CREATE TABLE Tasks (
    TaskID INT,
    TaskName VARCHAR(50),
    IsCompleted BOOLEAN
);
```

**Real-life example:**

* `IsCompleted` → marks whether a task is done or not

---

## ✅ Summary / Tips for Placement

1. Use **INT** for IDs, counts.
2. Use **DECIMAL** for money values.
3. Use **VARCHAR** for text with variable length.
4. Use **DATE/DATETIME** for date/time-related columns.
5. Use **BOOLEAN** for yes/no flags.
6. Avoid using `TEXT` for small strings — `VARCHAR` is more efficient.

---

# SQL Datatypes - Quick Reference

| Category         | Datatype       | Description | Example Value | Real-life Use Case |
|-----------------|----------------|------------|---------------|------------------|
| Numeric          | INT            | Whole numbers | 25, -100      | Employee ID, Count of items |
|                  | SMALLINT       | Small range integers | 1000       | Age, Ratings |
|                  | BIGINT         | Large integers | 1234567890123 | Bank account numbers |
|                  | DECIMAL(p,s)   | Fixed-point numbers with precision `p` and scale `s` | 123.45     | Salary, Price |
|                  | FLOAT / REAL   | Approximate decimal numbers | 3.14159    | Scientific calculations |
| String / Text    | CHAR(n)        | Fixed-length string | 'Amit  '   | Fixed-length codes |
|                  | VARCHAR(n)     | Variable-length string | 'Amit'    | Names, Emails |
|                  | TEXT           | Large text | 'This is a long description.' | Address, Comments |
| Date / Time      | DATE           | Stores date only | '2025-08-26' | Birthdate, Order date |
|                  | TIME           | Stores time only | '14:30:00' | Delivery time |
|                  | DATETIME / TIMESTAMP | Stores both date and time | '2025-08-26 14:30:00' | Order creation timestamp |
|                  | YEAR           | Stores year only | 2025       | Graduation year |
| Boolean / Logical| BOOLEAN / BIT  | True or False | TRUE, FALSE | Task completed, Active/Inactive status |


Perfect! Let’s add a **mini example table with queries** that uses all the main SQL datatypes we just discussed. This is **placement-ready** and easy to understand.

````markdown
# SQL Datatypes - Example Table with Queries

## 1. Create Table Example

```sql
CREATE TABLE Employee (
    EmpID INT,                -- Numeric: Employee ID
    Name VARCHAR(50),         -- String: Employee Name
    Age SMALLINT,             -- Numeric: Age
    Salary DECIMAL(10,2),     -- Numeric: Salary with 2 decimal places
    JoiningDate DATE,         -- Date: Date of joining
    LastLogin DATETIME,       -- Datetime: Last login timestamp
    IsActive BOOLEAN,         -- Boolean: Active status
    Address TEXT              -- Text: Full address
);
````

---

## 2. Insert Data Example

```sql
INSERT INTO Employee (EmpID, Name, Age, Salary, JoiningDate, LastLogin, IsActive, Address)
VALUES
(1, 'Amit Sharma', 28, 55000.50, '2023-06-15', '2025-08-26 09:30:00', TRUE, '123, MG Road, Mumbai'),
(2, 'Riya Singh', 32, 72000.00, '2022-11-20', '2025-08-25 18:45:00', FALSE, '45, Park Street, Kolkata');
```

---

## 3. Select Data Example

```sql
-- Select all employees
SELECT * FROM Employee;

-- Select only active employees
SELECT Name, Salary FROM Employee WHERE IsActive = TRUE;

-- Select employees who joined after 2023-01-01
SELECT Name, JoiningDate FROM Employee WHERE JoiningDate > '2023-01-01';
```

---

### ✅ Real-life Understanding

* `EmpID` → always numeric (whole number) to uniquely identify employees
* `Name` → variable-length string because names can vary in length
* `Salary` → decimal for exact money value
* `JoiningDate` → date only
* `LastLogin` → datetime for timestamp of last login
* `IsActive` → boolean to track if employee is currently active
* `Address` → large text to store complete address

```

