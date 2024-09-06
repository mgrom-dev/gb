## Урок 2. SQL – создание объектов, изменение данных, логические операторы

### Получение данных, блок FROM

Прежде чем смотреть данные и написать самый простой запрос, давайте разберемся, как обратиться к нужной таблице. Для этого используется блок FROM. В данном блоке мы указываем, какую таблицу хотим использовать.
```sql
FROM server.schema.table
```
В общем случае необходимо через точку указать SQL server, schema и table. давайте разбираться.

Server — это та база данных, к которой вы делаете подключение. При работе вы можете одновременно писать запросы к различным базам данных, и чтобы знать из какой базы брать данные нужно указывать сервер. Причем это желательно делать всегда, поскольку вы можете отдать скрипт коллеги, а он не будет знать куда коннектиться.

Schema — это именованный контейнер для объектов базы данных, который позволяет группировать объекты в отдельные пространства имен. Другими словами это некий префикс к таблицам, который их объединяет и характеризует. Вы можете настраивать права доступа на такой префикс, удалять сразу все таблицы по выбранной схеме. Для боевых баз данных используется схема dbo, которая является схемой по умолчанию для каждой базы данных. Если вам необходимо создать временные таблицы, можно использовать личные схемы, такие как tmp.

Table — это собственно сама таблица, которую необходимо использовать.

Поскольку мы будем работать с фиксированной базой данных, то мы будем сразу обращаться к таблице без указания сервера и схемы.

### Получение данных, блок SELECT

Теперь вы можете посмотреть данные, которые содержатся в таблицах. Самый простой способ — нажать правой кнопкой мыши на нужную таблицу и в контекстном меню выбрать SELECT. Необходимо заметить, что такой функционал реализован во всех менеджерах баз данных и даже в более развернутом виде.

Когда вы выбрали команду SELECT в окне ввода скрипта появляется соответствующий скрипт, который можно запустить с помощью кнопки Run. Давайте разберем этот простой скрипт
```sql
SELECT * FROM Categories
```
В данном скрипте используется всего две инструкции для получения данных. Как мы говорили на прошлой лекции, сначала выполняется инструкция FROM и вы обращаетесь к таблице Categories. Дальше выполняется инструкция SELECT *. То есть мы выбираем все колонки, которые имеются в данной таблице. Необходимо сразу отметить, что запускать подобный скрипт на реальной базе опасно. В нашем случае данных в таблице мало, и этот скрипт успешно может быть выполнен. Если вы попытаетесь загрузить все данные из продуктовой таблицы где много данных, это может привести к зависанию базы данных. Поэтому, если вы пишете скрипт, то для проведения тестов необходимо и обязательно указывать ограничение по выгружаемым данным. Давайте перепишем скрипт следующим образом.
```sql
SELECT TOP(5) * FROM Categories
```
Сейчас мы вывели только 5 записей из нашей таблицы. На практике обычно используют число 1000, чтобы с одной стороны получить достаточно большое число записей и увидеть все разнообразие в данных, с другой стороны это число не такое большое и не приведет к зависанию БД. При этом SQL позволяет писать как TOP(5), так и TOP 5, здесь нет никакой разницы. В некоторых диалектах вместо инструкции TOP может использоваться инструкция LIMIT, так что не пугайтесь.

Другая важная особенность, которую мы видим в запросе — это использование оператора *. Данный оператор позволяет быстро понять структуру таблицы, какие существуют колонки и какие там данные. Однако если вы хотите, чтобы чтобы ваш код читался хорошо, то лучше прописывать с новой строки те колонки, которые хотите видеть в выгрузке.

Кстати, для того чтобы получить список всех колонок таблицы Categories можно использовать следующий запрос.
```sql
SELECT name
FROM sys.columns
WHERE object_id = OBJECT_ID('Categories')
```
Таким образом, чтобы вывести первые пять названий категорий можно использовать следующий запрос
```sql
SELECT TOP(5) CategoryName
FROM Categories
```
Если нам необходимо вывести несколько столбцов, то мы их указываем через запятую. При этом очевидно, что порядок вывода столбцов будет определяться тем порядком, в котором мы их указали. Если есть необходимость, то можно один столбец указать в запросе несколько раз. Например, мы можем написать такой запрос к таблице Cluster.
```sql
SELECT TOP 100
credit_amount
,age
,education
,region
,credit_amount
FROM Clusters
```
Как видно, в результате мы получили 100 записей, которые содержат информацию о клиентах, такую как запрашиваемый кредит, возраст, образование и регион.

Таким образом блок SELECT говорит, какие данные мы хотим видеть в результирующей таблице. Помимо данных (колонок) мы можем здесь написать константу (например 100) и эта константа распространиться на все кортежи. Как видно, мы добавили константу, однако это поле получилось без названия. Чтобы добавить название или переименовать колонку необходимо использовать ключевое слово AS. Давайте разберем следующий запрос,в котором мы переименовали первую колонку и сделали название для колонки с константой
```sql
SELECT TOP 100
credit_amount AS кредит
,age
,education
,region
,credit_amount AS [кредит для различных нужд]
,100 AS value
FROM Clusters
```
В целом можно заметить, что правила хорошего тона говорят нам писать все элементы на английском языке. Если вы создаете таблицы, представления, то желательно использовать английский алфавит. При этом формально ничто не запрещает вам использовать и русские названия. Но лучше не делать так как показано на примере. Другая особенность заключается в том, что для составных названий колонок или названий таблиц можно использовать подчеркивания. Но если вам по какой-то причине нужно написать название элемента через пробелы, то для этого нужно использовать прямые скобки как в примере.

Важно, что переименовывать поля приходится регулярно. С одной стороны, чтобы дать им более осмысленные названия для конечной выборки, которую вы будете отдавать заказчику. С другой стороны, чтобы не было пересечения названий колонок при Join разных таблиц. Здесь важно отметить, что переименование происходит в самый последний в блоке SELECT. То есть сейчас мы не сможем обратиться к полю кредит для фильтрации и упорядочения.

В блоке SELECT можно делать различные операции над данными. Например мы можем посчитать для клиентов отношение запрашиваемого кредита к их доходу в процентах. Однако если мы просто посчитаем credit_amount / income то не произойдет преобразования типов данных (обе колонки у нас INT) и мы получим целочисленное деление. Поэтому для преобразования типов данных следует использовать такой подход (при умножении INT на FLOAT (100.0) мы получаем FLOAT).
```sql
SELECT TOP 100
credit_amount * 100.0 / income as part_income
FROM Clusters
```
Раз мы начали говорить про преобразование типов, то для этого есть специальная инструкция CAST. Параметрами данной функции будут сама колонка и тип данных, который мы хотим получить. Например, вы можете преобразовать число в строку следующим образом.
```sql
SELECT TOP 10
CAST(income AS VARCHAR) as string
FROM Clusters
```
Самый частый способ применения преобразования типов заключается в работе с датами. Часто даты в таблице хранятся как строковые переменны. Чтобы SQL мог понять, что это дата, необходимо сделать преобразования. Посмотрим на типичные примеры.
```sql
SELECT
CAST('2022-3-1' AS DATE) AS DateValue -- 03/01/2022 (Display Mode)
```

```sql
SELECT
CAST('2021-02-29' AS DATE) AS InvalidDate -- 12/31/1840 (Display Mode)
```
В первом случае у нас корректно отрабатывает запрос поскольку дата является валидной. Во втором случае, из-за отсутствия 29 февраля в 21 году мы получаем значение по умолчанию.

Иногда CAST может не помочь при работе с датой. Тогда нужно использовать прямой метод преобразования строковых величин в дату TODATE, в котором можно указывать формат строки для получения дня, месяца, года. На своей практике я сталкивался с тем, что в двух смежных таблицах данные хранились в в разном виде. В одной таблице был стандартный вид ‘YYYY-MM-DD’, а в другой - ‘YYYY-DD-MM’. Естественно, это вызывало кучу ошибок, особенно когда скрипт писался например 11 ноября и в этот день все работало корректно, а на следующий день все падало.

Над колонками можно делать не только алгебраические операции, но и любые другие преобразования. Например можно работать со строками. В данном примере мы сделали соединение двух элементов. Это может быть полезно, когда у вас в разных колонках есть Имя и Фамилия человека, а вы хотите получить их вместе.
```sql
SELECT TOP 10
education + ' ' + sex
from Clusters
```
Очень большой пласт команд есть по вопросам работы с датами и календарями. Среди простых команд вы можете посмотреть день, месяц или год. Взять разницу дат. В целом с помощью поиска вы сможете решить любые задачи. В этом примере мы приведены базовые команды при работе с датой.
```sql
SELECT TOP 10
YEAR(OrderDate) AS year
,DAY(OrderDate) AS day
,DATEDIFF(DAY, OrderDate, '2023-01-01') AS diff_day
,OrderDate
FROM Orders
```
Следующим важным модификатором блока SELECT является DISTINCT, которые позволяет получить уникальные значения по колонкам. Это один из важных операторов, который в первую очередь можно использовать для аналитики, когда мы хотим узнать как у нас устроены данные и какие уникальные значения содержатся в таблице. Например с помощью следующего запроса мы можем получить уникальные записи видов образования наших клиентов. Видим, что существует только шесть видов образования.
```sql
SELECT
DISTINCT education
FROM Clusters
```