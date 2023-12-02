Задача:
----------
**Найти второе максимальное число в массиве, третье и т.д.**

Псевдокод:
```
numbers = [29, 54, 67, 35, 62, 92, 82, 48, 51, 62]
size_numbers = 10
max_number_in_order = 2
index_numbers = 0
max_numbers = [0, 0]
size_max_numbers = max_number_in_order
index_max_numbers = 0
while (index_numbers < size_numbers)
    larger_number = -1
    index_max_numbers = size_max_numbers - 1
    while (index_max_numbers >= 0)
        if (larger_number != -1) then
            new_larger_number = max_numbers[index_max_numbers];
            max_numbers[index_max_numbers] = larger_number;
            larger_number = new_larger_number;
        if (max_numbers[index_max_numbers] < numbers[index_numbers] AND larger_number == -1) then
            larger_number = max_numbers[index_max_numbers];
            max_numbers[index_max_numbers] = numbers[index_numbers];
        index_max_numbers = index_max_numbers - 1
    index_numbers = index_numbers + 1
print(max_numbers[0]);
```