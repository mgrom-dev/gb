## SQL: Оконные функции

[онлайн тестирование БД](https://sqliteonline.com/)

### Задание 1: Ранжирование продуктов по средней цене

**Задание**: Ранжируйте продукты в каждой категории на основе их средней цены (AvgPrice). Используйте таблицы OrderDetails и Products.

**Результат**: В результате запроса будут следующие столбцы:
- CategoryID: идентификатор категории продукта,
- ProductID: идентификатор продукта,
- ProductName: название продукта,
- AvgPrice: средняя цена продукта,
- ProductRank: ранг продукта внутри своей категории на основе средней цены в порядке убывания.

**Подсказка**:
1. Рассчитайте среднюю цену продукта: Начните с создания подзапроса (или CTE), в котором будете вычислять среднюю цену (AVG(Price)) для каждого продукта. Объедините таблицы OrderDetails и Products с помощью JOIN.
2. Ранжируйте продукты по средней цене: Используйте оконную функцию RANK() для ранжирования продуктов по средней цене внутри каждой категории. Убедитесь, что вы применяете PARTITION BY для разделения по категориям и ORDER BY для упорядочивания по убыванию средней цены.

```sql
WITH ProductAvgPrice AS (
SELECT
p.CategoryID,
p.ProductID,
p.ProductName,
AVG(p.Price) AS AvgPrice
FROM Products p
JOIN OrderDetails od ON p.ProductID = od.ProductID
GROUP BY p.CategoryID, p.ProductID, p.ProductName
)
SELECT
CategoryID,
ProductID,
ProductName,
AvgPrice,
RANK() OVER (PARTITION BY CategoryID ORDER BY AvgPrice DESC) AS
ProductRank
FROM ProductAvgPrice;
```

### Задание 2: Средняя и максимальная сумма кредита по месяцам

**Задание**: Рассчитайте среднюю сумму кредита (AvgCreditAmount) для каждого кластера в каждом месяце и сравните её с максимальной суммой кредита (MaxCreditAmount) за тот же месяц. Используйте таблицу Clusters.

**Подсказка**:
1. Рассчитайте среднюю сумму кредита: Используйте подзапрос (или CTE) для вычисления средней суммы кредита (AVG(credit_amount)) для каждого кластера в каждом месяце.
2. Рассчитайте максимальную сумму кредита: Создайте другой подзапрос для вычисления максимальной суммы кредита (MAX(credit_amount)) для каждого месяца.
3. Объедините результаты: Используйте JOIN для объединения результатов двух подзапросов по месяцу и выведите нужные столбцы.

**Результат**: В результате запроса будут следующие столбцы:
- month: месяц,
- cluster: кластер,
- AvgCreditAmount: средняя сумма кредита для каждого кластера в каждом месяце,
- MaxCreditAmount: максимальная сумма кредита в каждом месяце.

```sql
WITH avg_credit AS (
  SELECT month,
  cluster,
  AVG(credit_amount) as avg_credit
  FROM Clusters
  GROUP BY month, cluster
),
max_credit AS (
  SELECT month,
  cluster,
  MAX(credit_amount) as max_credit
  FROM Clusters
  GROUP BY month, cluster
)
SELECT ac.month, 
ac.cluster, 
avg_credit, 
max_credit 
from avg_credit ac
JOIN max_credit mc ON ac.month = mc.month and ac.cluster = mc.cluster
ORDER BY max_credit;
```

### Задание 3: Разница в суммах кредита по месяцам

**Задание**: Создайте таблицу с разницей (Difference) между суммой кредита и предыдущей суммой кредита по месяцам для каждого кластера. Используйте таблицу Clusters.

**Подсказка**:
1. Получите сумму кредита и сумму кредита в предыдущем месяце: Используйте функцию оконного анализа LAG() для получения суммы кредита в предыдущем месяце в рамках каждого кластера.
2. Вычислите разницу: Используйте результат предыдущего шага для вычисления разницы между текущей и предыдущей суммой кредита. Примените COALESCE() для обработки возможных значений NULL.

**Примечания**:
- Функция RANK() в MySQL 8.0 и выше позволяет вычислять ранг записей в рамках заданного окна.
- Функция LAG() используется для получения значения предыдущей строки в рамках окна.
- Функция MAX() может быть использована как оконная функция для получения максимального значения в рамках окна данных.

**Результат**: В результате запроса будут следующие столбцы:
- month: месяц,
- cluster: кластер,
- credit_amount: сумма кредита,
- PreviousCreditAmount: сумма кредита в предыдущем месяце,
- Difference: разница между текущей и предыдущей суммой кредита.

```sql
-- Рассчитываем сумму кредита и сумму кредита в предыдущем месяце
WITH CreditWithPrevious AS (
SELECT
month,
cluster,
credit_amount,
LAG(credit_amount) OVER (PARTITION BY cluster ORDER BY
month) AS PreviousCreditAmount
FROM Clusters
)
-- Вычисляем разницу между текущей и предыдущей суммой кредита
SELECT
month,
cluster,
credit_amount,
PreviousCreditAmount,
COALESCE(credit_amount - PreviousCreditAmount, 0) AS Difference
FROM CreditWithPrevious;
```