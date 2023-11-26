#pip install Pillow numpy
from PIL import Image
import turtle

# Получаем PIL.image и определяем размеры лабиринта
path = '\\'.join(__file__.split("\\")[:-1]) + '\\'
path_img = path + 'maze.gif'
im = Image.open(path_img).convert('L')
w, h = im.size
sx, sy = w - 97, h - 5

# Создаем окно для отображения лабиринта
window = turtle.Screen()
window.setup(w + 36, h + 40)
window.title("Лабиринт")
window.bgpic(path_img)

# Создаем черепашку
t = turtle.Turtle()
t.speed(0)
t.shape("turtle")
t.color("black")

# Задаем начальную позицию
t.penup()
t.goto((-w//2), (h//2))
t.forward(sx)
t.right(90)
t.forward(sy)
t.right(180)
cx, cy = sx, sy

# Создаем функцию для проверки выхода из лабиринта
def is_out():
    return cy < 5

# Создаем функцию проверки касания левой руки стены
def wall_on_left():
    angle = {0: 'right', 90: 'up', 180: 'left', 270: 'down'}[t.heading()]
    if angle == 'right':
        return im.getpixel((cx, cy - 1)) != 255
    if angle == 'up':
        return im.getpixel((cx - 1, cy)) != 255
    if angle == 'left':
        return im.getpixel((cx, cy + 1)) != 255
    if angle == 'down':
        return im.getpixel((cx + 1, cy)) != 255

# Создаем функцию проверки возможности шага вперед
def step_forward():
    angle = {0: 'right', 90: 'up', 180: 'left', 270: 'down'}[t.heading()]
    if angle == 'right':
        return im.getpixel((cx + 1, cy)) == 255
    if angle == 'up':
        return im.getpixel((cx, cy - 1)) == 255
    if angle == 'left':
        return im.getpixel((cx - 1, cy)) == 255
    if angle == 'down':
        return im.getpixel((cx, cy + 1)) == 255

# Создаем функцию шага вперед
def move_forward():
    global cx, cy
    angle = {0: 'right', 90: 'up', 180: 'left', 270: 'down'}[t.heading()]
    if angle == 'right':
        cx += 1
    if angle == 'up':
        cy -= 1
    if angle == 'left':
        cx -= 1
    if angle == 'down':
        cy += 1
    t.forward(1)

# Ищем выход
t.pendown()
while is_out() != True:
    if wall_on_left():
        if step_forward():
            move_forward()
        else:
            t.right(90)
    else:
        t.left(90)
        move_forward()

print("Turtle is out")

# Завершаем программу
window.mainloop()