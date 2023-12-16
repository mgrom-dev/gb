import random

# Генерация пяти случайных чисел
number1 = random.randint(1, 100)
number2 = random.randint(1, 100)
number3 = random.randint(1, 100)
number4 = random.randint(1, 100)
number5 = random.randint(1, 100)

# Инициализация переменной max
max_number = number1

# Обновление переменной max при необходимости
if number2 > max_number:
    max_number = number2
if number3 > max_number:
    max_number = number3
if number4 > max_number:
    max_number = number4
if number5 > max_number:
    max_number = number5

# Вывод сгенерированных чисел и результата
print("Generated numbers:", number1, ",", number2, ",", number3, ",", number4, ",", number5)
print("The maximum number is:", max_number)