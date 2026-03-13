CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
      select Max(salary) from (select salary,dense_rank() over (order by salary desc) as rnk from employee) e where rnk=N

  );
END