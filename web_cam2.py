# https://obsproject.com/welcome
# pip install pyvirtualcam
import cv2
import pyvirtualcam
import numpy as np

# Загрузка картинки
image_path = 'image.png'
image = cv2.imread(image_path)

# Запуск web-камеры
cap = cv2.VideoCapture(0)

# Получение размеров кадра
ret, frame = cap.read()
height, width, _ = frame.shape

# Создание виртуальной камеры
with pyvirtualcam.Camera(width=width, height=height, fps=30) as cam:
    while True:
        # Захват кадра с реальной камеры
        ret, frame = cap.read()

        # Замена картинки в кадре
        frame = image

        # Отображение кадра
        cv2.imshow('Virtual Camera', frame)

        # Отправка кадра в виртуальную камеру
        cam.send(frame)

        # Обработка нажатия клавиши 'q' для выхода из цикла
        if cv2.waitKey(1) & 0xFF == ord('q'):
            break

# Освобождение ресурсов
cap.release()
cv2.destroyAllWindows()