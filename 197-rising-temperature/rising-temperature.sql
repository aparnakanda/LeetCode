# Write your MySQL query statement below
select w1.id from Weather w1 join Weather w2 on w1.recordDate=date_Add(w2.recordDate, interval 1 day) and w1.temperature>w2.temperature;