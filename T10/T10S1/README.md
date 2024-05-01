## Урок 1. Компиляция и интерпретация кода

### План урока:
— Закрепить полученные на лекции знания, касающиеся компиляции, интерпретации кода и создания программной документации;
— Получить практический навык настройки терминала ОС для компиляции и исполнения кода, установки сторонних библиотек для интерпретации;
— Попрактиковаться в написании терминальных команд и простых проектов. Лучше понять принцип импортирования кода и сборки проекта.

### Компиляция со всеми зависимостями главного класса
javac -d ourclasses -sourcepath .\ .\ru\mgrom\Main.java -encoding utf-8
### Запуск программы
java -cp .\ourclasses\ ru.mgrom.Main
### Создание документации
javadoc -d mydoc -sourcepath .\ -cp .\ourclasses\ -subpackages ru -encoding utf-8

### Задания:
Создать Makefile с задачами сборки, очистки и создания документации на весь проект
```Makefile
SRC_DIR := ./
OUT_DIR := ourclasses
DOC_DIR := mydoc
ENC := -encoding utf-8

JC := javac
JDOC := javadoc
JSRC := -sourcepath ./$(SRC_DIR)
JCLASS := -cp ./$(OUT_DIR)
JCDEST := -d $(OUT_DIR)
JDOCDEST := -d $(DOC_DIR)
MAIN_SOURCE := ru/mgrom/Main
MAIN_CLASS := ru.mgrom.Main

all:
	${JC} ${JSRC} ${JCDEST} ${SRC_DIR}/${MAIN_SOURCE}.java

clean:
	rm -R ${OUT_DIR} ${DOC_DIR}

run:
	cd ${OUT_DIR} && java ${MAIN_CLASS}

docs:
	${JDOC} ${JDOCDEST} ${JSRC} ${JCLASS} -subpackages ru ${ENC}
```
*Создать два Docker-образа. Один должен компилировать Java-проект обратно в папку на компьютере пользователя, а второй забирать скомпилированные классы и исполнять их.
```yml
services:
    app:
        image: bellsoft/liberica-openjdk-alpine:11.0.16.1-1
        command: javac -sourcepath /app/src -d /app/out /app/src/ru/mgrom/Main.java
        volumes:
            - ./ourclasses:/app/out
            - ./:/app/src
```
docker compose -f docker-compose-class.yml up
```yml
services:
    app:
        image: bellsoft/liberica-openjdk-alpine:11.0.16.1-1
        command: java -classpath /app/out ru.mgrom.Main
        volumes:
            - ./ourclasses:/app/out
```
docker compose -f docker-compose-exec.yml up

### Задание № 2
Настроить окружение Jupyter Notebook с ядром IJava, создать одну ячейку с переменной, а вторую с выводом значения этой переменной стандартным способом. Дополнить ячейки описанием markdown.

### Задание № 3
К проекту из задания 1 добавить ещё один класс в соседнем пакете, как это было показано на лекции, и комментарии в стиле Javadoc. Комментарии необходимо добавить как к методам, так и к классам. Сгенерировать общую программную документацию.  
`javadoc -d mydoc -sourcepath . -cp ./ourclasses -subpackages ru -encoding utf-8`  
*создать документацию на каждый пакет по отдельности. 
```bash
javadoc -d mydoc .\ru\mgrom\Main.java
javadoc -d mydoc .\ru\mgrom\regular\OtherClass.java
javadoc -d mydoc .\ru\mgrom\regular\Decorator.java
```

### Домашнее задание
1. Решить все задания (в том числе «со звёздочкой»), если они не были решены на семинаре, без ограничений по времени;
2. Создать докер образ для формирования полной документации по проекту
```yml
services:
    app:
        image: bellsoft/liberica-openjdk-alpine:11.0.16.1-1
        command: javadoc -sourcepath /app/src -cp /app/out -d /app/doc -subpackages ru
        volumes:
            - ./ourclasses:/app/out
            - ./:/app/src
            - ./mydoc:/app/doc
```
docker compose -f docker-compose-doc.yml up