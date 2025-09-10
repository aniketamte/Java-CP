create database cognizant;
use cognizant;

-- -----------------------------
-- 1. Department Table
-- -----------------------------
CREATE TABLE Department (
    DeptID INT PRIMARY KEY,
    DeptName VARCHAR(50),
    Location VARCHAR(50)
);

INSERT INTO Department (DeptID, DeptName, Location) VALUES
(1, 'HR', 'Mumbai'),
(2, 'Finance', 'Delhi'),
(3, 'IT', 'Bangalore'),
(4, 'Marketing', 'Pune'),
(5, 'Sales', 'Chennai');

-- -----------------------------
-- 2. Employee Table
-- -----------------------------
CREATE TABLE Employee (
    EmpID INT PRIMARY KEY,
    EmpName VARCHAR(100),
    Age INT,
    Gender CHAR(1),
    DeptID INT,
    Salary DECIMAL(10,2),
    JoiningDate DATE,
    ExperienceYears INT,
    FOREIGN KEY (DeptID) REFERENCES Department(DeptID)
);

-- Employee Inserts (EmpID 1 to 200)
INSERT INTO Employee (EmpID, EmpName, Age, Gender, DeptID, Salary, JoiningDate, ExperienceYears) VALUES
(1, 'Aniket Amte', 28, 'M', 3, 75000, '2020-03-15', 5),
(2, 'Rohit Sharma', 32, 'M', 2, 85000, '2018-07-20', 7),
(3, 'Sneha Patil', 26, 'F', 1, 60000, '2021-01-05', 3),
(4, 'Pooja Singh', 29, 'F', 4, 65000, '2019-06-10', 4),
(5, 'Karan Mehta', 35, 'M', 5, 95000, '2015-11-30', 10),
(6, 'Amit Kumar', 30, 'M', 3, 78000, '2017-09-14', 6),
(7, 'Priya Joshi', 27, 'F', 2, 72000, '2020-02-01', 4),
(8, 'Neha Reddy', 31, 'F', 1, 68000, '2016-05-23', 8),
(9, 'Vikas Singh', 33, 'M', 4, 70000, '2015-03-18', 9),
(10, 'Rita Sharma', 28, 'F', 5, 82000, '2019-07-12', 5),
(11, 'Siddharth Joshi', 29, 'M', 3, 76000, '2018-09-20', 6),
(12, 'Anjali Gupta', 26, 'F', 2, 68000, '2021-02-25', 3),
(13, 'Rahul Verma', 34, 'M', 1, 90000, '2014-10-15', 11),
(14, 'Shreya Iyer', 27, 'F', 4, 64000, '2020-05-19', 4),
(15, 'Deepak Rao', 31, 'M', 5, 88000, '2016-12-01', 8),
(16, 'Neelam Sharma', 29, 'F', 3, 77000, '2017-08-10', 6),
(17, 'Ramesh Patel', 32, 'M', 2, 81000, '2015-09-25', 9),
(18, 'Kavita Singh', 28, 'F', 1, 62000, '2019-11-05', 5),
(19, 'Aditya Mehta', 30, 'M', 4, 73000, '2018-01-14', 6),
(20, 'Priyanka Reddy', 26, 'F', 5, 70000, '2021-06-22', 3),
(21, 'Vishal Sharma', 27, 'M', 3, 76000, '2019-03-10', 5),
(22, 'Rashmi Patil', 25, 'F', 2, 65000, '2021-08-01', 3),
(23, 'Manish Gupta', 31, 'M', 1, 88000, '2016-04-12', 7),
(24, 'Sonal Reddy', 29, 'F', 4, 67000, '2018-11-05', 5),
(25, 'Kunal Mehta', 33, 'M', 5, 91000, '2015-06-18', 10),
(26, 'Divya Sharma', 28, 'F', 3, 74000, '2020-09-23', 5),
(27, 'Harsh Verma', 30, 'M', 2, 79000, '2017-12-15', 6),
(28, 'Meera Joshi', 27, 'F', 1, 66000, '2019-02-10', 4),
(29, 'Nikhil Rao', 32, 'M', 4, 82000, '2015-10-05', 9),
(30, 'Simran Iyer', 26, 'F', 5, 71000, '2021-04-18', 3);

-- -----------------------------
-- 3. Project Table
-- -----------------------------
CREATE TABLE Project (
    ProjectID INT PRIMARY KEY,
    ProjectName VARCHAR(100),
    DeptID INT,
    StartDate DATE,
    EndDate DATE,
    Budget DECIMAL(15,2),
    FOREIGN KEY (DeptID) REFERENCES Department(DeptID)
);

INSERT INTO Project (ProjectID, ProjectName, DeptID, StartDate, EndDate, Budget) VALUES
(1, 'HR Automation', 1, '2022-01-01', '2022-12-31', 500000),
(2, 'Finance Dashboard', 2, '2021-03-01', '2021-11-30', 750000),
(3, 'Website Redesign', 3, '2023-02-15', '2023-10-31', 1000000),
(4, 'Marketing Campaign', 4, '2022-05-01', '2022-09-30', 300000),
(5, 'Sales CRM', 5, '2023-01-15', '2023-12-31', 600000);

-- -----------------------------
-- 4. Employee_Project Table (Many-to-Many)
-- -----------------------------
CREATE TABLE Employee_Project (
    EmpID INT,
    ProjectID INT,
    AssignedDate DATE,
    PRIMARY KEY (EmpID, ProjectID),
    FOREIGN KEY (EmpID) REFERENCES Employee(EmpID),
    FOREIGN KEY (ProjectID) REFERENCES Project(ProjectID)
);

-- Sample assignments
-- Employee_Project assignments (sample 50, continue to assign 200 employees)
INSERT INTO Employee_Project (EmpID, ProjectID, AssignedDate) VALUES
(1, 3, '2023-02-15'),
(2, 2, '2021-03-01'),
(3, 1, '2022-01-01'),
(4, 4, '2022-05-01'),
(5, 5, '2023-01-15'),
(6, 3, '2023-02-15'),
(7, 2, '2021-03-01'),
(8, 1, '2022-01-01'),
(9, 4, '2022-05-01'),
(10, 5, '2023-01-15'),
(11, 3, '2023-02-20'),
(12, 2, '2021-04-05'),
(13, 1, '2022-02-10'),
(14, 4, '2022-06-12'),
(15, 5, '2023-01-18'),
(16, 3, '2023-02-22'),
(17, 2, '2021-05-15'),
(18, 1, '2022-03-10'),
(19, 4, '2022-07-01'),
(20, 5, '2023-01-20');

select * from department;
select * from employee;
select * from employee_project;
select * from project;

select * from employee
INNER JOIN project;

select * from employee e
LEFT JOIN project p
ON e.DeptID = P.DeptID;

select * from project p 
RIGHT JOIN employee e
ON e.DeptID = P.DeptID;

-- Employee2 Table
CREATE TABLE employee2 (
    EmpID INT PRIMARY KEY,
    EmpName VARCHAR(50),
    Dept VARCHAR(50),
    ProjectID INT
);

INSERT INTO employee2 VALUES
(101, 'Amit', 'IT', 201),
(102, 'Sneha', 'HR', NULL),
(103, 'Rahul', 'IT', 202),
(104, 'Priya', 'Finance', 203),
(105, 'Vikram', 'IT', 204);

-- Project2 Table
CREATE TABLE project2 (
    ProjectID INT PRIMARY KEY,
    ProjectName VARCHAR(100),
    Budget INT
);

INSERT INTO project2 VALUES
(201, 'Payroll System', 500000),
(202, 'Inventory App', 300000),
(203, 'Banking System', 800000),
(206, 'Mobile App', 200000);

select * from employee2
INNER JOIN project2;

select * from employee2 e
LEFT JOIN project2 p
ON e.ProjectID = P.ProjectID;

select EmpID, ProjectName, EmpName, Dept, Budget from project2 p 
LEFT JOIN employee2 e
ON e.ProjectID = P.ProjectID
UNION
select EmpID, ProjectName, EmpName, Dept, Budget from project2 p 
RIGHT JOIN employee2 e
ON e.ProjectID = P.ProjectID;

CREATE TABLE employee3(
    id INT PRIMARY KEY,
    name VARCHAR(50),
    manager_id INT
);

INSERT INTO employee3 (id, name, manager_id)
VALUES
(101, "adam", 103),
(102, "bob", 104),
(103, "casey", NULL),
(104, "donald", 103);

SELECT a.name as Manager_Name, b.name 
FROM employee3 as a 
JOIN employee3 as b
on a.id = b.manager_id;

CREATE TABLE student (
    rollno INT PRIMARY KEY,
    name VARCHAR(50),
    marks INT
);

INSERT INTO student (rollno, name, marks)
VALUES
(1, 'Amit', 85),
(2, 'Sneha', 92),
(3, 'Rahul', 76),
(4, 'Priya', 64),
(5, 'Vikram', 55);

select * from student;

CREATE TABLE student2 (
    rollno INT PRIMARY KEY,
    name VARCHAR(50),
    marks INT,
    grade CHAR(2),
    city VARCHAR(50)
);

INSERT INTO student2 (rollno, name, marks, grade, city) VALUES
(1, 'Amit', 85, 'A', 'Pune'),
(2, 'Sneha', 92, 'A+', 'Mumbai'),
(3, 'Rahul', 67, 'B', 'Delhi'),
(4, 'Priya', 74, 'B+', 'Chennai'),
(5, 'Vikram', 55, 'C', 'Kolkata');



select name
from student2
where marks > (select AVG(marks) as Marks from student2);

select rollno, name 
from student2
where rollno IN (
	select rollno 
    from student2 
    where rollno % 2 = 0);

-- 1. List all employees along with their department names and locations.
select e.EmpID, e.EmpName, d.DeptName, d.Location
from employee e 
Join Department d
ON e.DeptID = d.DeptID;

-- 2. Find all employees with salary greater than 80,000.
select * from employee
where Salary > 80000;

-- 3. Retrieve employees from IT or Finance department.
select e.EmpID, e.EmpName, d.DeptName, d.Location
from employee e 
Join Department d
ON e.DeptID = d.DeptID
where d.DeptName IN('IT', 'Finance');

-- 4. List employees whose names start with ‘P’ and are younger than 30.
select * from employee
where EmpName Like ('P%') AND Age < 30;

-- 5. Count the number of employees in each department.
select d.DeptName, COUNt(e.EmpID) AS EmployeeCount
from Department d
LEFT JOIN employee e
ON d.DeptID = e.DeptID
group by d.DeptName;

-- 6. Find the average salary per department.
select d.DeptName, AVG(e.Salary) AS AvgSalary
from Department d
LEFT JOIN employee e
ON d.DeptID = e.DeptID
group by d.DeptName;

-- 7. Display maximum and minimum salary in the company.

select MAX(Salary) AS MaxSalary, MIN(Salary) AS MinSalary
from employee;

-- 8. List employees with experience greater than the average experience.
select AVG(ExperienceYears) FROM employee;

select * 
from employee
where ExperienceYears > (select AVG(ExperienceYears) FROM employee);

-- 9. Concatenate employee names with their department names.
select CONCAT(e.EmpName, ' - ', d.DeptName) AS Emp_Dept
from employee e 
Join Department d
ON d.DeptID = e.DeptID;

-- 10. Show employees who joined in 2020.
SELECT * 
FROM employee
WHERE year(JoiningDate) = 2020;

-- 11. Extract the year from each employee’s JoiningDate.
SELECT EmpID, EmpName, year(JoiningDate) As JoiningYear
FROM employee;

-- 12. Find total salary paid per department.
SELECT d.DeptName, SUM(e.Salary) as TotalSalary
from Department d
JOIN employee e
ON d.DeptID = e.DeptID
group by DeptName;

-- 13. List departments having more than 30 employees.
SELECT d.DeptName, COUNT(e.EmpID) AS EmployeeCount
from Department d
JOIN employee e
ON d.DeptID = e.DeptID
group by DeptName
HAVING COUNT(e.EmpID) > 2;

-- 14. Find the maximum salary in each department.
SELECT d.DeptName, MAX(e.Salary) as MaxSalary
from Department d
JOIN employee e
ON d.DeptID = e.DeptID
group by DeptName;

-- 15. Retrieve the top 10 highest paid employees.

select EmpID, EmpName, Salary 
from employee
order by Salary desc
LIMIT 10;

-- 16. List employees in descending order of experience.

select EmpID, EmpName, ExperienceYears
from employee
order by ExperienceYears desc;

-- 17. Display the first 5 employees who joined most recently.

select EmpID, EmpName, JoiningDate
from employee
order by JoiningDate desc
LIMIT 5;

-- 18. Show employee names with their department names (JOIN Employee & Department).

select e.EmpID, e.EmpName, d.DeptName
from employee e
join Department d
on e.DeptID = d.DeptID;

-- 19. List all projects along with their department names.

select p.ProjectID, p.ProjectName, d.DeptName  
from Project p
JOIN Department d
on p.DeptID = d.DeptID;

-- 20. Find employees working on projects (JOIN Employee_Project & Project).
select * from employee;
select * from Project;

select e.EmpID, e.EmpName, p.ProjectName
from employee e
JOIN Project p
on p.DeptID = e.DeptID;

-- 21. Inner join Employee and Project based on DeptID.

select e.EmpID, e.EmpName, e.DeptID, p.ProjectName
from employee e
INNER JOIN Project p
on p.DeptID = e.DeptID
order by e.EmpID
limit 10;

-- 22. Left join Employee and Project to show all employees even if not assigned.

select e.EmpID, e.EmpName, p.ProjectName
from employee e
LEFT JOIN Employee_Project ep ON e.EmpID = ep.EmpID
LEFT JOIN Project p ON ep.ProjectID = p.ProjectID;

-- 23. Right join Employee and Project to show all projects even if no employee assigned.

select e.EmpID, e.EmpName, p.ProjectName
from Employee_Project ep
Right JOIN Project p ON ep.ProjectID = p.ProjectID
LEFT JOIN employee e ON e.EmpID = ep.EmpID;

-- 24. Retrieve employees earning more than the average salary of the company.
select EmpID, EmpName, Salary
from employee
where Salary > (SELECT AVG(Salary) from employee);

-- 25. Find departments with the highest number of employees.

SELECT d.DeptName, COUNT(e.EmpID) AS EmployeeCount
from Department d
JOIN employee e
on d.DeptID = e.DeptID
group by DeptName
order by EmployeeCount DESC;

-- 26. List employees working on the project with the highest budget.

-- 27. Find employees whose experience is greater than the average experience in their department.

-- 28. Classify employees as ‘Junior’ (<5 years), ‘Mid’ (5–10 years), or ‘Senior’ (>10 years) using CASE.

SELECT EmpID, EmpName, ExperienceYears,
CASE
when ExperienceYears < 5 THEN 'Junior'
when ExperienceYears BETWEEN 5 AND 10 THEN 'Mid'
ELSE 'Senior'
END as Level
FROM employee;

-- 29. Calculate a bonus: 10% if salary < 70,000, else 5%.

SELECT EmpID, EmpName, Salary,
CASE
WHEN Salary < 70000 THEN Salary * 0.10
ELSE Salary * 0.05
END AS Bonus
from employee;

-- Sample Question from youtube
select * 
FROM employee
where JoiningDate >= date_sub(curdate(), INTERVAL 2 MONTH)
OR MONTH(JoiningDate) between 7 AND 9;

-- 30. Create a view of employees with salary greater than 80,000.
-- 31. Create a view for all employees in the IT department.
-- 32. Create an index on Employee(Salary).
-- 33. Compute the total budget allocated per department.

SELECT d.DeptName, sum(p.Budget) AS TotalBudget
FROM Project P
JOIN Department d
on p.DeptID = d.DeptID
group by DeptName;

-- 34. List employees not assigned to any project.

SELECT e.EmpID, e.EmpName
FROM employee e
LEFT JOIN employee_Project ep ON e.EmpID = ep.EmpID
WHERE ep.ProjectID IS NULL;

-- 35. Count male and female employees in the company.
select Gender, COUNT(*) AS Count 
from employee
group by Gender;

-- 36. Find employees working on multiple projects.
-- 37. Identify departments without any employees.
-- 38. Find employees whose names end with ‘i’.

SELECT EmpID, EmpName
FROM employee
WHERE EmpName LIKE '%i';

-- 39. List employees who joined last year.

SELECT EmpID, EmpName, JoiningDate
FROM employee
WHERE YEAR(JoiningDate) = 2021;

-- 40. Calculate tenure in years for all employees.
-- 41. Display the month name of each employee’s JoiningDate.
-- 42. Find employees earning more than their department’s average salary.
-- 43. List employees working on projects with budget greater than 500,000.
-- 44. Identify departments where total salary exceeds 10,000,000.
-- 45. Retrieve employees not in HR or Finance departments.
-- 46. Find employees whose salary is between the minimum and maximum salary of their department.
-- 47. Select the employee with the second highest salary.
-- 48. Write a query to find the Nth highest salary in the company dynamically.
-- 49. Delete employees with experience less than 2 years.
-- 50. Update the salary of all IT employees by 10%.
-- 51. List employees who joined in a leap year.
-- 52. Display all employee names in uppercase.
-- 53. Find employee names containing both ‘a’ and ‘e’.
-- 54. Count the number of employees per gender in each department.
-- 55. Identify departments with no ongoing projects.
-- 56. Find the total number of projects each employee is assigned to.
-- 57. List employees who have not been assigned to any project in 2023.
-- 58. Find employees whose salary is above the average salary of employees in IT.
-- 59. Show the most recent project assigned to each employee.
-- 60. List departments where all employees earn more than 50,000.
-- 61. Display employees whose experience is equal to the minimum experience in their department.
-- 62. Find projects without any employee assigned.
-- 63. Retrieve employees assigned to multiple projects in the same department.
-- 64. Find the oldest employee in each department.
-- 65. Count the number of employees who joined in each year.
-- 66. List employees along with the total budget of their assigned projects.
-- 67. Find employees whose salary is higher than the project budget they are assigned to.
-- 68. Display employees whose name has exactly 5 characters.
-- 69. List employees who joined before the start date of their assigned project.
-- 70. Find employees who work in the same department as their manager (assume manager field exists).
-- 71. Retrieve employees who have never worked on ‘Sales CRM’ project.
-- 72. List employees whose joining month is July or August.
-- 73. Find employees who are assigned to projects outside their department.
-- 74. Calculate average salary of employees assigned to more than one project.
-- 75. Show departments where the highest-paid employee earns more than 100,000.
