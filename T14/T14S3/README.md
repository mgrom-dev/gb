## SQL: Объединение таблиц

### Задание 1: Анализ прибыли по категориям продуктов

**Задание**: Определите общую прибыль для каждой категории продуктов, используя таблицы OrderDetails, Orders и Products. Для расчета прибыли умножьте цену продукта на количество, а затем суммируйте результаты по категориям.

**Подсказка**: Используйте JOIN для объединения таблиц OrderDetails, Orders, Products и Categories. Примените агрегацию с функцией SUM.

```sql
SELECT
c.CategoryName,
SUM(p.Price * od.Quantity) as SUM
FROM Orders o
JOIN OrderDetails od ON o.OrderID = od.OrderID
JOIN Products p ON od.ProductID = p.ProductID
JOIN Categories c ON p.CategoryID = c.CategoryID
GROUP BY CategoryName
ORDER BY SUM DESC
```

### Задание 2: Количество заказов по регионам

**Задание**: Определите количество заказов, размещенных клиентами из различных стран, за каждый месяц.

**Подсказка**: Используйте JOIN для объединения таблиц Orders и Customers. Для извлечения месяца и года из даты используйте функцию EXTRACT.

```sql
SELECT
c.Country AS Country,
strftime('%m', o.OrderDate) AS month,
strftime('%Y', o.OrderDate) AS year,
COUNT(o.OrderID) AS OrderCount
FROM Orders o
JOIN Customers c ON o.CustomerID = c.CustomerID
GROUP BY c.Country, month, year
ORDER BY OrderCount DESC;
```

### Задание 3: Средняя продолжительность кредитного срока для клиентов

**Задание**: Рассчитайте среднюю продолжительность кредитного срока для клиентов по категориям образования.

**Подсказка**: Используйте таблицу Clusters и функцию AVG для вычисления средней продолжительности кредитного срока.

```sql
SELECT
education AS Education,
AVG(credit_term) AS AverageCreditTerm
FROM Clusters
GROUP BY education
ORDER BY AverageCreditTerm DESC;
```