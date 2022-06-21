# Write your MySQL query statement below


WITH ops_ranks AS (
    SELECT *,
      DENSE_RANK() OVER(PARTITION BY stock_name, operation ORDER BY operation_day) AS ops_rnk  
    FROM Stocks
)

SELECT s1.stock_name,
    SUM(s2.price) - SUM(s1.price) AS capital_gain_loss
FROM ops_ranks s1
# Get buy-sell pairs based on their rank
JOIN ops_ranks s2
    ON s1.stock_name = s2.stock_name
        AND s1.operation = 'Buy'
        AND s2.operation = 'Sell'
        AND s1.ops_rnk = s2.ops_rnk
GROUP BY 1