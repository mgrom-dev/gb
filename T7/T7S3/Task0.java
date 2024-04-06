import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Перепишите следующий код, используя ресурсный try
 */
public class Task0 {
    public static void main(String[] args) {
        try {
            rwLine(Path.of("1.txt"), Path.of("2.txt"));
        } catch (IOException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
    }

    public static void rwLine(Path pathRead, Path pathWrite) throws IOException {
        try (BufferedReader in = Files.newBufferedReader(pathRead);
                BufferedWriter out = Files.newBufferedWriter(pathWrite)) {
            out.write(in.readLine());
        }
    }
}