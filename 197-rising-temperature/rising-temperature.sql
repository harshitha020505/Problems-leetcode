# Write your MySQL query statement below
select w.id from weather as w join weather w1 on DateDiff(w.recorddate,w1.recorddate)=1 
where w.temperature>w1.temperature order by w.recordDate Asc;