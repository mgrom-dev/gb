package ru.mgrom;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        File homeDir = new File("C:\\Users\\mgrom\\Downloads\\test");
        File sourceDir =  new File("C:\\Users\\mgrom\\Downloads\\test\\src");

        File[] files = homeDir.listFiles();
        HashSet<MediaFile> homeFolder = new HashSet<>();

        for (File file : files) {
            if (file.isFile()) {
                homeFolder.add(new MediaFile(file));
            }
        }

        files = sourceDir.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                MediaFile currrent = new MediaFile(file);
                if (!homeFolder.contains(currrent)) {
                    try {
                        Files.copy(file.toPath(), Path.of(homeDir.getPath() + "\\" + file.getName()));
                    } catch (IOException e) {
                        System.out.println("Ошибка при копировании файла");
                    }
                }
            }
        }
    }

    public static void copyFile(File source, File destination) throws IOException {
        try (FileInputStream fis = new FileInputStream(source);
                FileOutputStream fos = new FileOutputStream(destination)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }
        }
    }
}