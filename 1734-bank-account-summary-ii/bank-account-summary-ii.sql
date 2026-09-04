# Write your MySQL query statement below
select 
u.name, sum(t.amount) as balance
from Users u
join Transactions t
on u.account = t.account
group by u.account, u.name
having sum(t.amount) > 10000;