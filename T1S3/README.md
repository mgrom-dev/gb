Задача 1
----------
![Задача 1](task1.jpg)
```
numbers = [2, -5, 13, -7, 6, -4]
size = 6
count = 0
index = 0
while (index < size)
    if (numbers[index] > 0) then
        count = count + 1
    index = index + 1
print(count)
```
Задача 2
----------
![Задача 2](task2.jpg)
```
numbers = [2, 5, 13, 7, 6, 4]
size = 6
sum = 0
avg = 0
index = 0
while (index < size)
    sum = sum + numbers[index]
    index = index + 1
avg = sum / size
print(avg)
```
Задача 3
----------
![Задача 3](task3.jpg)
```
numbers = [2, 5, 13, 7, 6, 4]
size = 6
index = 0
max_idx = 0
max = numbers[max_idx]
while (index < size)
    if (numbers[index] > max) then
        max_idx = index
        max = numbers[index]
    index = index + 1
numbers[max_idx] = numbers[size - 1]
numbers[size - 1] = max
print(numbers)
```
Задача 4
----------
![Задача 4](task4.jpg)
![Решение 4 задачи](home4.png)
Задача 5
----------
![Задача 5](task5.jpg)
![Решение 5 задачи](home5.png)
Задача 6
----------
![Задача 6](task6.jpg)
![Решение 6 задачи](home6.png)