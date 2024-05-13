package ru.mgrom;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class MediaFile {
    private String name;
    private long size;
    private long date;
    File file;

    MediaFile(File file) {
        name = file.getName();
        size = file.length();
        date = file.lastModified();
        this.file = file;
    }

    /**
     * Получить хэш-сумму файла в виде строки hex
     * @return
     */
    public String getHash() {
        String hash = "";
        try {
            byte[] sha512Hash = MediaFile.computeSHA512Hash(file);
            hash = MediaFile.bytesToHex(sha512Hash);
        } catch (Exception ex) {
            throw new RuntimeException("Ошибка при вычислении хэша файла");
        }
        return hash;
    }

    /**
     * Подсчет хэша файла в алгоритме SHA-512
     * @param file - файл, для которого нужно посчитать хэш
     * @return - возвращет массив байтов хэша
     * @throws NoSuchAlgorithmException - исключение если алгоритм не найден
     * @throws FileNotFoundException - исключение файл не найден
     * @throws IOException - исключение ошибки чтения
     */
    public static byte[] computeSHA512Hash(File file) throws NoSuchAlgorithmException, FileNotFoundException, IOException {
        MessageDigest digest = MessageDigest.getInstance("SHA-512");
        try (DigestInputStream dis = new DigestInputStream(new FileInputStream(file), digest)) {
            dis.readAllBytes();
        }
        return digest.digest();
    }

    /**
     * Перевод массива байт в строковое представление в 16-ой с.с.
     * @param bytes
     * @return
     */
    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        return (int)size;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MediaFile other = (MediaFile) obj;
        if (!getHash().equals(other.getHash()))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return String.format("{name = '%s', size = %d bytes, date = %s}", name, size, new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(date));
    }

}
