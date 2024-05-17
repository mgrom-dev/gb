import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Vector;

/**
 * Cоздать пару-тройку текстовых файлов. Для упрощения (чтобы не разбираться с
 * кодировками) внутри файлов следует писать текст только латинскими буквами.
 * 
 * Написать метод, осуществляющий конкатенацию (объединение) переданных ей в
 * качестве параметров файлов (не важно, в первый допишется второй или во второй
 * первый, или файлы вовсе объединятся в какой-то третий);
 * 
 * Написать метод поиска слова внутри файла.
 */

public class Main {
    public static void main(String[] args) {
        System.out.println();
        printTextFiles("test1.txt", "test2.txt", "test3.txt");
        System.out.println();
        searchTextInFiles("or", "test1.txt", "test2.txt", "test3.txt");
        System.out.println();
    }

    private static SequenceInputStream getInputStream(String ... pathToFiles) {
        /* Создаем последовательность потока файлов */
        Vector<FileInputStream> files = new Vector<>();
        for (String path : pathToFiles)
            try {
                files.add(new FileInputStream(path));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        return new SequenceInputStream(files.elements());
    }

    public static void printTextFiles(String ... pathToFiles) {
        SequenceInputStream sin = getInputStream(pathToFiles);
        try {
            int i = 0;
            while((i = sin.read()) != -1) {
                System.out.print((char) i);
            }
            sin.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void searchTextInFiles(String text, String ... pathToFiles) {
        SequenceInputStream sin = getInputStream(pathToFiles);
        try {
            String data = new String(sin.readAllBytes());
            System.out.println(data.substring(data.indexOf(text)));
            sin.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}