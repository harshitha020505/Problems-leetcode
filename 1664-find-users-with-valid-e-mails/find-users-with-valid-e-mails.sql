# Write your MySQL query statement below
select user_id,name,mail from users where mail COLLATE utf8mb3_bin  REGEXP "^[a-zA-Z][a-zA-Z0-9._-]*@leetcode\\.com$"