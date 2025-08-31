CREATE DATABASE ORG;
SHOW DATABASES;
USE ORG;

CREATE TABLE Worker (
	WORKER_ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	FIRST_NAME CHAR(25),
	LAST_NAME CHAR(25),
	SALARY INT(15),
	JOINING_DATE DATETIME,
	DEPARTMENT CHAR(25)
);

INSERT INTO Worker 
	(WORKER_ID, FIRST_NAME, LAST_NAME, SALARY, JOINING_DATE, DEPARTMENT) VALUES
		(001, 'Monika', 'Arora', 100000, '14-02-20 09.00.00', 'HR'),
		(002, 'Niharika', 'Verma', 80000, '14-06-11 09.00.00', 'Admin'),
		(003, 'Vishal', 'Singhal', 300000, '14-02-20 09.00.00', 'HR'),
		(004, 'Amitabh', 'Singh', 500000, '14-02-20 09.00.00', 'Admin'),
		(005, 'Vivek', 'Bhati', 500000, '14-06-11 09.00.00', 'Admin'),
		(006, 'Vipul', 'Diwan', 200000, '14-06-11 09.00.00', 'Account'),
		(007, 'Satish', 'Kumar', 75000, '14-01-20 09.00.00', 'Account'),
		(008, 'Geetika', 'Chauhan', 90000, '14-04-11 09.00.00', 'Admin');
        
SELECT * FROM Worker;

CREATE TABLE Bonus (
	WORKER_REF_ID INT,
	BONUS_AMOUNT INT(10),
	BONUS_DATE DATETIME,
	FOREIGN KEY (WORKER_REF_ID)
		REFERENCES Worker(WORKER_ID)
        ON DELETE CASCADE
);

INSERT INTO Bonus 
	(WORKER_REF_ID, BONUS_AMOUNT, BONUS_DATE) VALUES
		(001, 5000, '16-02-20'),
		(002, 3000, '16-06-11'),
		(003, 4000, '16-02-20'),
		(001, 4500, '16-02-20'),
		(002, 3500, '16-06-11');
        
select * from Bonus;
        
CREATE TABLE Title (
	WORKER_REF_ID INT,
	WORKER_TITLE CHAR(25),
	AFFECTED_FROM DATETIME,
	FOREIGN KEY (WORKER_REF_ID)
		REFERENCES Worker(WORKER_ID)
        ON DELETE CASCADE
);

INSERT INTO Title 
	(WORKER_REF_ID, WORKER_TITLE, AFFECTED_FROM) VALUES
 (001, 'Manager', '2016-02-20 00:00:00'),
 (002, 'Executive', '2016-06-11 00:00:00'),
 (008, 'Executive', '2016-06-11 00:00:00'),
 (005, 'Manager', '2016-06-11 00:00:00'),
 (004, 'Asst. Manager', '2016-06-11 00:00:00'),
 (007, 'Executive', '2016-06-11 00:00:00'),
 (006, 'Lead', '2016-06-11 00:00:00'),
 (003, 'Lead', '2016-06-11 00:00:00');
 
 Select * from Title;
 
 -- Q-1. Write an SQL query to fetch “FIRST_NAME” from Worker table using the alias name as <WORKER_NAME>.
 
 select FIRST_NAME as WORKER_NAME from Worker;
 
 -- Q-2. Write an SQL query to fetch “FIRST_NAME” from Worker table in upper case.
 
 select UPPER(first_name) from worker;
 
 -- Q-3. Write an SQL query to fetch unique values of DEPARTMENT from Worker table
 
 select distinct department from Worker;
 SELECT department
FROM Worker
GROUP BY department;

 
 -- Q-4. Write an SQL query to print the first three characters of  FIRST_NAME from Worker table.
 
 SELECT substring(FIRST_NAME, 1, 3) FROM Worker;
 
 -- Q-5. Write an SQL query to find the position of the alphabet (‘b’) in the first name column ‘Amitabh’ from Worker table.
 
 select INSTR(FIRST_NAME, 'B') FROM Worker where FIRST_NAME = 'Amitabh';
 
 -- Q-6. Write an SQL query to print the FIRST_NAME from Worker table after removing white spaces from the right side.
 
 select rtrim(FIRST_NAME) from Worker;
 
 -- Q-7. Write an SQL query to print the DEPARTMENT from Worker table after removing white spaces from the left side.
 
 select ltrim(department) from Worker;
 
 -- Q-8. Write an SQL query that fetches the unique values of DEPARTMENT from Worker table and prints its length.
 
 select distinct department, LENGTH(department) from Worker;
 
 -- Q-9. Write an SQL query to print the FIRST_NAME from Worker table after replacing ‘a’ with ‘A’.
 
 SELECT REPLACE(FIRST_NAME, 'a', 'A') FROM Worker; 
 
 -- Q-10. Write an SQL query to print the FIRST_NAME and LAST_NAME from Worker table into a single column COMPLETE_NAME.
-- A space char should separate them.
 
 select concat(FIRST_NAME, ' ', LAST_NAME) as COMPLETE_NAME from Worker;
 
 -- Q-11. Write an SQL query to print all Worker details from the Worker table order by FIRST_NAME Ascending.
 
 select * FROM Worker order by FIRST_NAME asc;
 
 -- Q-12. Write an SQL query to print all Worker details from the Worker table order by 
-- FIRST_NAME Ascending and DEPARTMENT Descending.

select * FROM Worker order by FIRST_NAME, department desc;
 
 -- Q-13. Write an SQL query to print details for Workers with the first name as “Vipul” and “Satish” from Worker table.
 
 select * from Worker where FIRST_NAME IN('Vipul', 'Satish');
 
 -- Q-14. Write an SQL query to print details of workers excluding first names, “Vipul” and “Satish” from Worker table.
 
  select * from Worker where FIRST_NAME NOT IN('Vipul', 'Satish');
 
 -- Q-15. Write an SQL query to print details of Workers with DEPARTMENT name as “Admin*”.
 
 SELECT * FROM Worker where department = 'Admin';
 
 -- Q-16. Write an SQL query to print details of the Workers whose FIRST_NAME contains ‘a’.
 
 select * from Worker where FIRST_NAME LIKE '%a%';
 
 -- Q-17. Write an SQL query to print details of the Workers whose FIRST_NAME ends with ‘a’.
 
 select * from Worker where FIRST_NAME LIKE '%a';
 
 -- Q-18. Write an SQL query to print details of the Workers whose FIRST_NAME ends with ‘h’ and contains six alphabets.
 
 select * from Worker where FIRST_NAME LIKE '_____h';
 
 -- Q-19. Write an SQL query to print details of the Workers whose SALARY lies between 100000 and 500000.
 
 select * from Worker where SALARY between 100000 and 500000;
 
 -- Q-20. Write an SQL query to print details of the Workers who have joined in Feb’2014.
 
 select * from Worker where YEAR(JOINING_DATE) = 2014 AND MONTH(JOINING_DATE) = 02;
 
 -- Q-21: Write an SQL query to fetch the count of employees working in the department ‘Admin’.
 
 select department, count(*) from Worker where department = 'Admin';

-- Q-22: Write an SQL query to fetch worker full names with salaries >= 50000 and <= 100000.

select concat(FIRST_NAME, ' ', LAST_NAME) AS full_name, Salary from Worker where Salary between 50000 and 100000;

-- Q-23: Write an SQL query to fetch the number of workers for each department in descending order.

SELECT department, count(worker_id) as No_Of_Worker from Worker group by department
order by No_Of_Worker desc;

-- Q-24: Write an SQL query to print details of the workers who are also managers.

select w.* from Worker as w
inner join
title as t
on
w.worker_id = t.worker_ref_id
where
t.WORKER_TITLE = 'Manager';

-- Q-25: Write an SQL query to fetch number (more than 1) of same titles in the organization of different types.

select WORKER_TITLE, count(*) as count from title group by WORKER_TITLE having count > 1;

-- Q-26: Write an SQL query to show only odd rows from a table.

select * from Worker where MOD(worker_id, 2) != 0;

-- Q-27: Write an SQL query to show only even rows from a table.

select * from Worker where MOD(worker_id, 2) = 0;

-- Q-28: Write an SQL query to clone a new table from another table.

create table worker_clone LIKE Worker;
insert into worker_clone select * from Worker;
select * from worker_clone;

-- Q-29: Write an SQL query to fetch intersecting records of two tables.

select worker.* from Worker 
inner join 
worker_clone
using(worker_id);

-- Q-30: Write an SQL query to show records from one table that another table does not have.

select worker.* from Worker 
left join 
worker_clone
using(worker_id)
where
worker_clone.worker_id is NULL;

-- Q-31: Write an SQL query to show the current date and time.
select current_date();
select current_time();
select now();

-- Q-32: Write an SQL query to show the top n (say 5) records of a table ordered by descending salary.

select * from Worker order by Salary desc limit 5;

-- Q-33: Write an SQL query to determine the nth (say n=5) highest salary from a table.

select * from Worker order by Salary desc limit 4, 1;

-- Q-34: Write an SQL query to determine the 5th highest salary without using LIMIT keyword.

SELECT Salary 
FROM Worker w1
WHERE 4 = (
    SELECT COUNT(DISTINCT w2.Salary)
    FROM Worker w2
    WHERE w2.Salary >= w1.Salary
);


-- Q-35: Write an SQL query to fetch the list of employees with the same salary.

select * from Worker w1, Worker w2 where w1.Salary = w2.Salary and w1.worker_id != w2.worker_id;

-- Q-36: Write an SQL query to show the second highest salary from a table using sub-query.

select max(Salary) from Worker
where Salary not in (select max(Salary) from Worker);

-- Q-37: Write an SQL query to show one row twice in results from a table.

select * from Worker
UNION ALL
select * from Worker order by worker_id;

-- Q-38: Write an SQL query to list worker_id who does not get bonus.
select * from Worker;
select * from Bonus;

select DISTINCT(Worker_id) from Worker
Join
Bonus as B
where Worker_id not in (select Worker_ref_id from Bonus);

select Worker_id from Worker where Worker_id not in (select Worker_ref_id from Bonus);

-- Q-39: Write an SQL query to fetch the first 50% records from a table.

select * from Worker where Worker_id <= (select count(Worker_id)/2 from Worker);

-- Q-40: Write an SQL query to fetch the departments that have less than 4 people in it.

select department, count(department) as deptCount from worker group by department having deptCount<4;

-- Q-41: Write an SQL query to show all departments along with the number of people in there.

select department, count(department) as deptCount from worker group by department;

-- Q-42: Write an SQL query to show the last record from a table.

select * from Worker where Worker_id = (select max(Worker_id) from Worker);

-- Q-43: Write an SQL query to fetch the first row of a table.

select * from Worker where Worker_id = (select min(Worker_id) from Worker);

-- Q-44: Write an SQL query to fetch the last five records from a table.

(select * from Worker order by Worker_id desc limit 5) order by Worker_id;

-- Q-45: Write an SQL query to print the name of employees having the highest salary in each department.

select concat(FIRST_NAME, ' ', LAST_NAME) AS Name, 
department, 
Salary as maxSalary 
from Worker w 
where Salary = (
select max(Salary)
from Worker
where 
department = w.department
);

select max(Salary) as maxSalary, department from Worker group by department;

-- Q-46: Write an SQL query to fetch three max salaries from a table using co-related subquery.

SELECT DISTINCT salary
FROM worker w1
WHERE 3 >= (
    SELECT COUNT(DISTINCT w2.salary)
    FROM worker w2
    WHERE w2.salary >= w1.salary
)
ORDER BY salary DESC;

-- Q-47: Write an SQL query to fetch three min salaries from a table using co-related subquery.

SELECT DISTINCT salary
FROM worker w1
WHERE 3 >= (
    SELECT COUNT(DISTINCT w2.salary)
    FROM worker w2
    WHERE w2.salary <= w1.salary
)
ORDER BY salary ASC;

-- Q-48: Write an SQL query to fetch nth max salaries from a table.

SELECT DISTINCT salary
FROM worker w1
WHERE 5 = (
    SELECT COUNT(DISTINCT w2.salary)
    FROM worker w2
    WHERE w2.salary >= w1.salary
)
ORDER BY salary DESC;

-- Q-49: Write an SQL query to fetch departments along with the total salaries paid for each of them.

-- Q-50: Write an SQL query to fetch the names of workers who earn the highest salary.

 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 