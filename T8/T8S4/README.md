## Урок 8. Семинар. Dockerfile и слои
```bash
# попробуем добавить локальный файл в наш контейнер
echo "Hello World" >> test.txt
nano Dockerfile
# содержимое Dockerfile:
# FROM ubuntu:22.04
# RUN apt-get update && \
#     apt-get install -y cowsay && \
#     ln -s /usr/games/cowsay /usr/bin/cowsay && \
#     rm -rf /var/lib/apt/lists/*
# COPY test.txt /
# CMD ["cowsay"]
docker build -t cowsaytest .
docker run cowsaytest cowsay "Hello World"
```

```bash
# разница между CMD
# первый Dockerfile
FROM ubuntu:22.04
COPY test.txt /
CMD sleep 600

# второй Dockerfile
FROM ubuntu:22.04
COPY test.txt /
CMD sleep 5

# запустим наши Dockerfile в режиме демона -d
docker build -t test .
docker run --name test -d test
```
Разница в том что во втором случае при запуске контейнера, он будет завершаться через 5 секунд, так как эта команда будет запускаться каждый раз и контейнер будет работать до тех пор, пока эта команда не выполнится. Однако ее можно переопределить.
```bash
# разница между CMD и ENTRYPOINT
FROM ubuntu:22.04
COPY test.txt /
ENTRYPOINT sleep 600
# соберем его, запустим и зайдем в него
docker build -t test .
docker run --name test -d test
docker exec -it test bash
# все работает, однако, если мы попробуем переопределить точку входа и выполнить другую команду при сборке контейнера run, то мы не сможем этого сделать, так как ENTRYPOINT переопределить нельзя, пример:
docker run -it test bash
# консоль зависнет, войти в него мы не сможем таким способом
```

Теперь давайте запустим контейнер с nginx
```bash
# Dockerfile
FROM ubuntu:22.04
RUN apt-get update && \
    apt-get install -y nginx && \
    rm -rf /var/lib/apt/lists/*
RUN echo 'Hi, I am in your container' > /usr/share/nginx/html/index.html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
# Запускаем и проверяем работу
docker build -t test .
docker run -d -p 8081:80 test
curl localhost:8081
```

### Домашнее задание
Дома необходимо собрать образ и запустить из него контейнер:  
Основой образа должна быть alpine.  
Установить необходимо mariaDB.  
Также не забудьте об уменьшении размера образа. Способ обсуждался на лекции.  
Необходимо открыть порт для коммуникации с другими сущностями.  
Для проверки решения необходимо подключить к такому контейнеру phpmyadmin.   Необходимо, чтобы в нем вы увидели данные из вашей БД.  
Также при запуске необходимо смонтировать внешнюю папку для хранения данных БД вне контейнера

2. Вариант  
Задание: необходимо создать Dockerfile, основанный на любом образе (вы в праве выбрать самостоятельно). В него необходимо поместить приложение, написанное на любом известном вам языке программирования (Python, Java, C, С#, C++). При запуске контейнера должно запускаться самостоятельно написанное приложение.
```bash
# Dockerfile
FROM alpine:3.19.1
LABEL maintainer="mgrom-dev"
LABEL version="1.0"
ADD https://raw.githubusercontent.com/mgrom-dev/gb/main/PJ/exercises/src/main/java/book/chapter4/Vampire.c /home/vampire.c
RUN apk add --no-cache gcc && \
    apk add --no-cache libc-dev && \
    gcc /home/vampire.c -o /bin/vampire && \
    apk info --installed | grep -E '^gcc' | cut -d ' ' -f 1 | xargs apk del && \
    apk del gcc && \
    rm -rf /var/cache/apk/
CMD ["vampire"]
# посмотреть список установленных файлов: apk info -L gcc
# сборка Dockerfile
docker build -t vampire:1.0 .
docker run vampire:1.0
```