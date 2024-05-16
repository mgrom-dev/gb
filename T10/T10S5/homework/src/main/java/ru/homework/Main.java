package ru.homework;

import java.io.File;
import java.nio.file.Files;

public class Main {
    public static void main(String[] args) {
        backupFolder(".\\");
        CrossZeroGame game = new CrossZeroGame();
        game.startGame();
    }

    /**
     * копирование всех файлов в директории (без поддиректорий) во вновь созданную папку ./backup
     * @param path
     */
    private static void backupFolder(String path) {
        /* создаем новую директорию, если она еще не создана */
        File backupDir = new File("./backup");
        if (!backupDir.exists() || !backupDir.isDirectory()) {
            backupDir.mkdir();
        }
        File[] files = backupDir.listFiles();
        for (File file : files)
            if (file.isFile()) {
                Files.
            }
    }
}