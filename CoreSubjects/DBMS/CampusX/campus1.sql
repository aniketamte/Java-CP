create database campusx1;
use campusx1;

select * from smartphones_cleaned_v6;
SELECT * FROM campusx1.ipl_ball_by_ball_2008_2022;

select brand_name, model, screen_size from smartphones_cleaned_v6
where brand_name = 'samsung'
order by screen_size DESC
LIMIT 5;

SELECT 
    MODEL,
    SUM(num_front_cameras + num_rear_cameras) AS total_camera
FROM smartphones_cleaned_v6
GROUP BY MODEL
ORDER BY total_camera DESC;

SELECT MODEL,
ROUND(SQRT(resolution_width*resolution_width + resolution_height*resolution_height) / screen_size) AS PPI
FROM smartphones_cleaned_v6
ORDER BY PPI DESC;

select MODEL, battery_capacity from smartphones_cleaned_v6
ORDER BY battery_capacity DESC
LIMIT 1,1;

select brand_name, MODEL, rating 
from smartphones_cleaned_v6
WHERE brand_name = 'APPLE'
ORDER BY rating ASC
limit 1; 

select brand_name, COUNT(MODEL) AS `TOTAL PHONE`, 
       AVG(price) AS PRICE, 
       MAX(rating) AS RATING, 
       AVG(screen_size) AS SIZE, 
       AVG(battery_capacity) AS BATTERY
from smartphones_cleaned_v6
group by brand_name
HAVING PRICE > 30000
ORDER BY `TOTAL PHONE` DESC
LIMIT 5;

select has_nfc, AVG(price) AS PRICE, AVG(rating) AS RATING 
from smartphones_cleaned_v6
GROUP BY has_nfc;

select brand_name, processor_brand, 
       COUNT(*) AS TOTAL, 
       ROUND(AVG(primary_camera_rear)) AS PCR 
from smartphones_cleaned_v6
group by brand_name, processor_brand;

select brand_name, ROUND(AVG(price)) AS PRICE 
from smartphones_cleaned_v6
group by brand_name
order by PRICE DESC
LIMIT 5;

select brand_name, ROUND(AVG(screen_size)) AS ss 
from smartphones_cleaned_v6
group by brand_name
order by ss ASC
LIMIT 1;

select brand_name, COUNT(*) AS 'COUNT' 
from smartphones_cleaned_v6
where has_nfc = 'True' AND 'has_ir_blaster' = 'True'
group by brand_name
order by COUNT LIMIT 1;

select has_nfc, AVG(price) AS PRICE
from smartphones_cleaned_v6
WHERE brand_name = 'SAMSUNG'
GROUP BY has_nfc;

select brand_name, model, price 
from smartphones_cleaned_v6
order by price DESC
limit 1;

select brand_name, 
       COUNT(*) AS COUNT, 
       AVG(price) AS PRICE
from smartphones_cleaned_v6
group by brand_name
having count > 20
order by PRICE DESC;

select brand_name,
       COUNT(*) AS COUNT,
       AVG(rating) AS RATING
from smartphones_cleaned_v6
group by brand_name
HAVING COUNT > 40
order by RATING DESC;

select brand_name,
       ROUND(avg(ram_capacity)) as ram
from smartphones_cleaned_v6
where refresh_rate > 90 and fast_charging_available = 1
group by brand_name
having count(*) > 10
order by RAM DESC 
LIMIT 3;

select brand_name,
       ROUND(AVG(price)) AS PRICE
from smartphones_cleaned_v6
WHERE has_5g = 'true'
group by brand_name
HAVING AVG(RATING) > 70 AND COUNT(*) > 10;

SELECT batter, 
       SUM(batsman_run) AS RUN 
FROM campusx1.ipl_ball_by_ball_2008_2022
group by batter
order by RUN DESC LIMIT 5;

SELECT batter, COUNT(*) AS `NUM_SIX` 
FROM campusx1.ipl_ball_by_ball_2008_2022
WHERE batsman_run = 6
group by batter
order by `NUM_SIX` DESC
LIMIT 1, 1;

SELECT * FROM campusx1.ipl_ball_by_ball_2008_2022
where batter = 'V Kohli';

SELECT batter, ID, SUM(batsman_run) AS SCORE 
FROM campusx1.ipl_ball_by_ball_2008_2022
group by batter, ID
HAVING SCORE >= 100;

SELECT * FROM campusx1.ipl_ball_by_ball_2008_2022;

SELECT * FROM campusx1.ipl_ball_by_ball_2008_2022;

SELECT * FROM campusx1.ipl_ball_by_ball_2008_2022;

SELECT * FROM campusx1.ipl_ball_by_ball_2008_2022;













