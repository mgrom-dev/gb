"""Переменные. Присваивания значения."""

x = 5
name = "Харитон"

print(x)
print(name)

print("Hello, World!")

name = input("Введите ваше имя: ")
print(f"Привет, {name}!")

age = int(input("Введите ваш возраст: ")) # приведение к типу int
after = 10
print(f"Тебя зовут {name} и через {after} лет тебе исполнится {age + after} лет.")