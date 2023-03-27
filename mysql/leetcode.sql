create database leetcode;
use leetcode;
Create table If Not Exists Employee (id int, salary int);
Truncate table Employee;
insert into Employee (id, salary) values ('1', '100');
insert into Employee (id, salary) values ('2', '200');
insert into Employee (id, salary) values ('3', '50');
select * from employee;

select distinct salary from employee order by salary desc;

with tmp as (select salary from employee group by salary order by salary desc limit 3)
select 
	case 
		when (select count(salary) from tmp) = 3 then min(salary)
        else null
    end as data
from tmp;
select min(salary) from tmp;


select salary from employee order by salary limit 2;

with tmp as (select salary from employee group by salary order by salary desc limit 2 )
select 
	case
		when min(salary) != max(salary) then min(salary)
        else null
    end as SecondHighestSalary
from tmp;

select 3-2;

with tmp as (select salary from employee group by salary order by salary desc limit 3) ,  min_tmp as (select min(tmp.salary) salary from tmp) ,
res as (select salary from tmp where tmp.salary != (select salary from min_tmp)) 
select salary from res;
select salary from employee where salary not in (select salary from res);

select salary from employee where salary not in (select salary from employee where salary != 50 order by salary desc);

select 
	case 
		when 1=1 then "hello"
        else "world"
	end as hello_world;
