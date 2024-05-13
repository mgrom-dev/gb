package ru.mgrom;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.HashSet;

public class Main {
    public static final String homePath = "C:\\Users\\mgrom\\Downloads\\test";
    public static final String sourcePath = "C:\\Users\\mgrom\\Downloads\\test\\src";

    public static void main(String[] args) {
        File homeDir = new File(homePath);
        File sourceDir =  new File(sourcePath);

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
                MediaFile current = new MediaFile(file);
                if (!homeFolder.contains(current)) {
                    try {
                        String name = new SimpleDateFormat("yyyy-dd-MM HH-mm-ss").format(current.getDate());
                        String ext = file.getName().substring(file.getName().lastIndexOf(".") + 1);
                        Files.copy(file.toPath(), Path.of(homeDir.getPath() + "\\" + name + "." + ext));
                        homeFolder.add(current);
                    } catch (IOException e) {
                        System.out.println("Ошибка при копировании файла");
                    }
                }
            }
        }
    }

    /**
     * Копирование файла
     * @param source - источник
     * @param destination - цель
     * @throws IOException
     */
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