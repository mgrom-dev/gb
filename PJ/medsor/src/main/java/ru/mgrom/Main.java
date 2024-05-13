package ru.mgrom;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import static java.nio.file.LinkOption.NOFOLLOW_LINKS;

public class Main {
    public static final String homePath = "H:\\Media";
    public static final String sourcePath = "H:\\YandexDisk\\Фотокамера";

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
        int i = 0, len = files.length;
        for (File file : files) {
            if (file.isFile()) {
                MediaFile current = new MediaFile(file);
                i++;
                if (!homeFolder.contains(current)) {
                    try {
                        String name = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(current.getDate());
                        int index = 0;
                        while (fileExist(getFileName(homePath, name, current.getExt(), index))) {
                            index++;
                        }
                        Path target = Path.of(getFileName(homePath, name, current.getExt(), index));
                        Files.copy(file.toPath(), target);
                        Files.setAttribute(target, "basic:creationTime", FileTime.fromMillis(current.getDate()), NOFOLLOW_LINKS);
                        Files.setAttribute(target, "basic:lastModifiedTime", FileTime.fromMillis(current.getDate()), NOFOLLOW_LINKS);
                        System.out.println("File: " + current.getName() + " copied. Progress: " + (i * 100 / len) + " %");
                        homeFolder.add(current);
                    } catch (IOException e) {
                        System.out.println("Ошибка при копировании файла");
                    }
                } else
                    System.out.println("File: " + current.getName() + " already exist. Progress: " + (i * 100 / len) + " %");
            }
        }
    }

    public static String getFileName(String path, String name, String ext, int index) {
        return String.format("%s\\%s%s.%s", path, name, (index > 0 ? "_" + index: ""), ext);
    }

    /**
     * Проверка существования файла
     * @param path - путь к файлу
     * @return - истина если существует
     */
    public static boolean fileExist(String path) {
        return new File(path).exists();
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