# Write your MySQL query statement below
select employee_id from Employees
where salary < 30000 and manager_id is not null 
and manager_id not in(select employee_id from Employees)  
#check ki mmanager ka id exust nahi krta n employee-id me
order by employee_id;   #increasing order me sort ans ko