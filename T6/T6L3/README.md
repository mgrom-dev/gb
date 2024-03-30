## Урок 3. Некоторые стандартные интерфейсы Java и примеры их использования
План урока:
- Iterator\<E\>
- Iterable\<E\>
- Comparator\<E\>
- Comparable\<E\>
- Comparable, equals, ==
- foreach для своих типов
- Примеры
### Iterator\<E\>
Итератор над «коллекцией». Iterator занимает место Enumeration’в Java Collections Framework. 
- hasNext()
- next()
### Iterable\<E\>
Позволяет собственному типу быть типом оператора «for-each loop»
### Comparator\<E\>
Предназначен для упорядочивания собственных типов.
- obj.compare(x, y) <= 1
- obj.compare(x, y) <= 0
- obj.compare(x, y) <= -1
### Comparable\<E\>
Списки (и массивы) собственных типов позволяют автоматически сортироваться при помощи
- Collections.sort
- Arrays.sort
### Итоги
Интерфейсов много
- Cloneable
- Serializable
- *able и др.
- 
Их цель «заставить» работать стандартный функционал.  
Работа со своими свои типы «как нужно».  
Определить «свою» логику работы.  