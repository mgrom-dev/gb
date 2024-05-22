package ru.chat.server;

/**
 * Интерфейс описывающий абстракцию базы данных логов
 */
public interface Repository {

    void save(String text);

    String read();

}
