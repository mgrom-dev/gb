## Урок 1. SQL: получение данных

**Задание №1**

Провести первый анализ данных: посмотреть отдельно уникальные значения по полям sex (пол), education (образование), product_type (тип продукта), family_status (семейное положение).
```sql
SELECT DISTINCT sex
FROM Clusters
```

**Задание №2**

Получить клиентов банка женщин, с семейным статусом Another
```sql
SELECT * FROM Clusters
where family_status = 'Another'
AND sex = 'female'
```

**Задание №3**

Получите клиентов пенсионного возраста с сортировкой по полу и возрасту (женщины 60 лет включительно, мужчины 65 лет).
```sql
SELECT * FROM Clusters
where (sex = 'female' AND age >= 60) or
(sex = 'male' AND age >= 65)
ORDER BY sex, age
```

**Задание №4**

Получите только женатых пенсионеров.
```sql
SELECT * FROM Clusters
where ((sex = 'female' AND age >= 60) or (sex = 'male'
AND age >= 65)) and family_status = 'Married'
ORDER BY sex, age
```

**Задание №5**

Вывести первых 10 человек с наибольшей и наименьшей заработной платой (два запроса)
```sql
SELECT TOP 10 * FROM Clusters
ORDER BY income (desc)
```

**Задание №6**

Вывести первых 10 человек с наибольшей разницей между доходом и запрашиваемым кредит.

То есть люди много зарабатывают и мало просят
```sql
SELECT TOP 10 *, income - credit_amount FROM Clusters
ORDER BY income - credit_amount DESC
```

**Задание №7**

Получить список всех клиентов с образованием Higher education
```sql
SELECT * FROM Clusters
where education = 'Higher education'
```

**Задание №8**

Получить список всех клиентов из третьего кластера с доходом больше 120000.

Сколько таких клиентов?
```sql
SELECT * FROM Clusters
where cluster = 3 and income > 120000
```

**Задание №9**

Получить список клиентов из 3 и 5 кластера с доходом больше 120000 (нужны скобки при операции OR?).

Сколько сейчас таких клиентов?
```sql
SELECT * FROM Clusters
where (cluster = 3 or cluster = 5) and income > 120000

ИЛИ

SELECT * FROM Clusters
where cluster IN (3,5) and income > 120000
```

**Задание №10**

Выведите клиентов, у которых цель кредита заканчивается на ‘ces’
```sql
SELECT * FROM Clusters
where product_type like '%ces'
```

**Задание №11**

Получите клиентов, у которых в цели кредита есть как минимум две буквы n
```sql
SELECT * FROM Clusters
where product_type like '%n%n%'
```

**Задание №12**

Получите клиентов, у которых цель кредита менее 9 символов. Пояснение: произвольный обязательный символ обозначается как подчеркивание.

Второе решение через LEN
```sql
SELECT * FROM Clusters
where product_type not like '%_________%'

ИЛИ

SELECT * FROM Clusters
where LEN (product_type) < 9
```

**Задание №13**

Получите клиентов, у которых доход находится в пределах 20000 и 30000 (включительно)

```sql
SELECT * FROM Clusters
where income BETWEEN 20000
and 25000
order by income desc
```

**Задание №14**

Получите новое поле из полей education, sex вида education(sex). Буквы привести к нижнему регистру.

Подсказка: Для соединения слов в MSSQL используется знак +, в других диалектах может использоваться || или concat()
```sql
SELECT LOWER(education) + '(' +
LOWER(sex) + ')'
FROM Clusters
```

**Задание №15**

Сколько различных кредитных программ (credit_term) существует
```sql
SELECT count(DISTINCT credit_term) FROM Clusters
```

**Задание №16**

Сколько различных целей кредитов (product_type) существует
```sql
SELECT count(DISTINCT product_type)
FROM Clusters
```

**Задание №17**

Посчитайте, сколько денег в декабре месяце просили всего (суммарно) клиенты банка.
```sql
SELECT sum(credit_amount)
FROM Clusters
where month = 12 and is_client = 1
```

**Задание №18**

Определите переменные ‘2023-09-01’ ‘20-09-15’ и посчитайте, какое количество заказов было сделано за этот период (включительно).
```sql
DECLARE @start date =
'2023-09-01', @finish date =
'2023-09-15'
SELECT count(*) FROM Orders
where orderdate BETWEEN @start
AND @finish
```

### Customers

```sql
-- Определите, сколько уникальных стран представлено среди клиентов.
SELECT COUNT(DISTINCT Country) AS count_countries
FROM Customers;

-- Определите количество клиентов, которые проживают в Бразилии
SELECT COUNT(*) as from_Brazil
FROM Customers
WHERE country = 'Brazil';
```

### Products

```sql
-- Посчитайте среднюю цену и общее количество товаров в категории с идентификатором 5.
SELECT 
AVG(Price) AS average_price,
COUNT(*) as count_products
FROM Products
WHERE categoryid = 5;
```

### Employees

```sql
-- Вычислите средний возраст сотрудников на дату 2024-01-01.
SELECT AVG(age) AS AverageAge
FROM (
    SELECT 
        (julianday('2024-01-01') - julianday(BirthDate)) / 365.25 AS age
    FROM Employees
);
```

### Oders

```sql
-- Найдите заказы, сделанные в период с 16 января по 15 февраля 2024 года, и отсортируйте их по дате заказа.
SELECT *
FROM Orders
WHERE OrderDate BETWEEN '2024-01-16' AND '2024-02-15'
ORDER BY OrderDate;

-- Определите количество заказов, сделанных в ноябре 2023 года, используя начальную и конечную дату месяца.
SELECT COUNT(*) as count_orders_nov_2023
FROM Orders
WHERE OrderDate >= '2023-11-01' AND OrderDate <= '2023-11-30';

-- Найдите количество заказов за январь 2024 года, используя оператор LIKE для фильтрации даты.
SELECT COUNT(*) as count_orders_jan_2023
FROm Orders
WHERE OrderDate LIKE '2024-01%';

-- Определите количество заказов за 2024 года, используя функцию STRFTIME для извлечения года.
SELECT COUNT(*) AS order_count
FROM Orders
WHERE strftime('%Y', OrderDate) = '2024';
```