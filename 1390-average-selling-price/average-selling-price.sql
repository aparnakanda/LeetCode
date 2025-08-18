# Write your MySQL query statement below
SELECT p.product_id, 
  Round(IFNULL((sum(p.price*u.units)/sum(u.units)),0),2) AS average_price
FROM Prices p LEFT JOIN UnitsSold u ON p.product_id=u.product_id AND purchase_date BETWEEN p.start_date AND p.end_date
GROUP BY p.product_id;