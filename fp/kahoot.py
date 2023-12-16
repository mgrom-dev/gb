import random

# Задаем случайные начальные параметры в определенном диапазоне
holiday = random.choice([True, False])
temperature = random.randint(-40, 40)
age = random.randint(7, 15)
junior_classes_age = 10
no_school_temperature_for_junior_classes = -27

# Сообщаем заданные параметры
if holiday:
    print("Сегодня выходной")
else:
    print("Сегодня обычный день")
print("На улице", temperature, "°C")
print("Нам", age, "лет")

# Выясняем что мы сегодня делаем
if holiday:
    print("Идем к друзьям")
elif temperature >= no_school_temperature_for_junior_classes:
    print("Идем в школу")
elif age < junior_classes_age:
    print("Сидим дома")
else:
    print("Тащимся в школу")