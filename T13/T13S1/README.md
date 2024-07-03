## Урок 1. Системы сборки Maven и Gradle для разработки Java приложений
создание проекта по шаблону maven, через терминал
```sh
mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```
запуск проекта через терминал
```sh
# mvn package
mvn clean compile assembly:single
java -cp .\target\main-1.0-SNAPSHOT-jar-with-dependencies.jar ru.gb.App
```

### Домашнее задание

1. Из терминала или из IDE создать простой maven-проект:
    - pom.xml
    - src/main/java/ru/gb/Main.java (hello world)
1. *Собрать jar-файл
2. *Запустить jar-файл командой java -jar myjar.jar