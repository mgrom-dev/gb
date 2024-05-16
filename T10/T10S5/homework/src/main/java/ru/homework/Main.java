package ru.homework;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        backupFolder(File.separator);
        CrossZeroGame game = new CrossZeroGame();
        game.startGame();
    }

    /**
     * копирование всех файлов в директории (без поддиректорий) во вновь созданную папку ./backup
     * @param path
     */
    private static void backupFolder(String path) {
        /* создаем новую директорию, если она еще не создана */
        File backupDir = new File(File.separator + "backup");
        if (!backupDir.exists() || !backupDir.isDirectory()) {
            backupDir.mkdir();
        }

        File[] files = new File(path).listFiles();
        System.out.println(files.length);
        for (File file : files)
            if (file.isFile()) {
                try {
                    Files.copy(Path.of(file.getPath()), Path.of(backupDir.getPath() + File.separator + file.getName()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
    }
}