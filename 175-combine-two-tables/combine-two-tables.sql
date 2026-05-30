# Write your MySQL query statement below
select Person.firstName,Person.lastName,Address.city,Address.state 
from Person Left JOIN Address on Address.PersonId=Person.personId;


