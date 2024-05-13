package ru.mgrom;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

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
        getDateFromName();
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

    /**
     * Получение даты из имени файла, если это возможно
     */
    private void getDateFromName() {
        //"yyyy-mm-dd hh-mm-ss"
        String[] partsOfDate = name.split("[-. ]");
        if (partsOfDate.length >= 3) {
            // если компонент даты содержит лишние символы, то это не дата
            for (String part : partsOfDate) {
                if (part.matches(".*\\D.*")) return ;
            }
            int year = Integer.parseInt(partsOfDate[0]),
                month = Integer.parseInt(partsOfDate[1]) - 1, // месяцы в Java начинаются с 0
                day = Integer.parseInt(partsOfDate[2]),
                hour = partsOfDate.length >= 4 ? Integer.parseInt(partsOfDate[3]) : 0,
                mins = partsOfDate.length >= 5 ? Integer.parseInt(partsOfDate[4]) : 0,
                secs = partsOfDate.length >= 6 ? Integer.parseInt(partsOfDate[5]) : 0;
            // проверяем границы частей даты
            if (year < 1970 || year > 3000 || month > 11 || day > 31 || hour > 24 || mins > 60 || secs > 60) return ;
            Calendar calendar = new GregorianCalendar(year, month, day, hour, mins, secs);
            long dateInMillis = calendar.getTimeInMillis();
            // последняя проверка что даты не из будущего
            if (dateInMillis < System.currentTimeMillis()) date = dateInMillis;
        }
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
