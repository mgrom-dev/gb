## Урок 3. Классы и объекты

### Ссылки
- [Шпаргалка Lombok](https://habr.com/ru/articles/345520/)
- [mvnrepository репозиторий](https://mvnrepository.com/)
- [Lobok maven](https://mvnrepository.com/artifact/org.projectlombok/lombok)

Подключение lombok через сборщик Maven pom.xml
```xml
<dependencies>
    <!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <version>1.18.32</version>
        <scope>provided</scope>
    </dependency>
</dependencies>
```

### Рекомендации
- Библиотека для тестов Junit5