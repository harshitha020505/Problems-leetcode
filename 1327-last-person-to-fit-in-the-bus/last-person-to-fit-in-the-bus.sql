# Write your MySQL query statement below
 select person_name from (select person_name,sum(weight) over(order by turn asc) as wt from queue ) t where wt<=1000 order by wt desc limit 1;

