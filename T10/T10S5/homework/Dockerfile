# образ jdk 11
FROM bellsoft/liberica-openjdk-alpine-musl:13.0.2

# Установка рабочей директории внутри контейнера
WORKDIR /app

# Копирование JAR-файла в контейнер
COPY ./target/homework-1.0-SNAPSHOT.jar /app/homework-1.0-SNAPSHOT.jar
COPY ./testcopy.txt /app/testcopy.txt

# Команда для запуска приложения
CMD ["java", "-jar", "homework-1.0-SNAPSHOT.jar"]