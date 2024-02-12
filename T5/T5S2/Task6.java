import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Напишите метод, который определит тип (расширение) файлов из текущей папки и
 * выведет в консоль результат вида
 * 1 Расширение файла: txt
 * 2 Расширение файла: pdf
 * 3 Расширение файла:
 * 4 Расширение файла: jpg
 */
public class Task6 {
    public static void main(String[] args) {
        printExtFromCurFolder();
    }

    public static void printExtFromCurFolder() {
        String[] files = Task5.getCureFoldeStrings();
        Set<String> extensions = new HashSet<>();
        for (String str : files) {
            int i = str.lastIndexOf('.');
            String ext = i > 0 ? str.substring(i + 1) : "";
            extensions.add(ext);
        }
        Iterator<String> ext = extensions.iterator();
        int i = 0;
        while (ext.hasNext())
            System.out.printf("%d Расширение файла: %s\n", ++i, ext.next());
    }
}
