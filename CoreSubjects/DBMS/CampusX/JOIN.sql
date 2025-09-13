create database joins;
use joins;

select * from category;
select * from class;
select * from gp;
select * from membership;
select * from order_details;
select * from orders;
select * from person1;
select * from person2;
select * from students;
select * from users;
select * from users1;


select * from users1 t1
CROSS JOIN gp t2;

select * from membership T1
INNER JOIN users1 T2
ON T1.user_id = T2.user_id;

select * from membership T1
LEFT JOIN users1 T2
ON T1.user_id = T2.user_id;

select * from membership T1
RIGHT JOIN users1 T2
ON T1.user_id = T2.user_id;

select * from person1
UNION
select * from person2;

select * from person1
UNION ALL
select * from person2;

select * from person1
INTERSECT
select * from person2;

select * from person1
EXCEPT
select * from person2;

select * from membership T1
LEFT JOIN users1 T2
ON T1.user_id = T2.user_id
UNION
select * from membership T1
RIGHT JOIN users1 T2
ON T1.user_id = T2.user_id;

select * from membership T1
LEFT JOIN users1 T2
ON T1.user_id = T2.user_id
UNION ALL
select * from membership T1
RIGHT JOIN users1 T2
ON T1.user_id = T2.user_id;

select * from users1 T1
JOIN users1 T2
ON T1.emergency_contact = T2.user_id;

select * from students T1
JOIN class T2
ON T1.class_id = T2.class_id AND T1.enrollment_year = T2.class_year;

select * from users;
select * from order_details;
select * from orders;


select T1.order_id,
	   T1.amount,
       T1.profit,
       T3.name,
       T3.city
from order_details T1
JOIN orders T2
ON T1.order_id = T2.order_id
JOIN users T3
ON T2.user_id = T3.user_id;

select * from users T1
JOIN orders T2
ON T1.user_id = T2.user_id
WHERE T1.city = 'PUNE' AND T1.name = 'Priyanka';

select * from order_details T1
JOIN category T2
ON T1.category_id = T2.category_id
WHERE vertical = 'Chairs';

select * from users;
select * from order_details;
select * from orders;

select T1.order_id, SUM(T2.profit) AS PROFIT from orders T1
JOIN order_details T2
ON T1.order_id = T2.order_id
GROUP BY T1.order_id
HAVING PROFIT > 0;

select * from users;
select * from order_details;
select * from orders;

select T2.NAME, COUNT(*)  from orders T1
JOIN USERS T2
ON T1.user_id = T2.user_id
GROUP BY T2.NAME
ORDER BY COUNT(*) DESC LIMIT 1;

SELECT T1.VERTICAL, SUM(T2.profit) AS PROFIT FROM CATEGORY T1
JOIN order_details T2
ON T1.category_id = T2.category_id
GROUP BY T1.VERTICAL
ORDER BY PROFIT DESC
LIMIT 1;

select state, SUM(PROFIT) AS PROFIT from order_details T1
JOIN orders T2
ON T1.order_id = T2.order_id
JOIN USERS T3
ON T2.user_id = T3.user_id
GROUP BY state
ORDER BY PROFIT DESC LIMIT 1;

SELECT T1.VERTICAL, SUM(profit) AS PROFIT FROM CATEGORY T1
JOIN order_details T2
ON T1.category_id = T2.category_id
GROUP BY T1.VERTICAL
HAVING PROFIT > 3000
ORDER BY PROFIT DESC;
































