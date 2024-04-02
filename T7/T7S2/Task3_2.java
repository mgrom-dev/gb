import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.stream.Stream;

public class Task3_2 {
    public static void main(String[] args){
        HashMap<String, String> result = handleFile();
        System.out.println(result);
        try {
            saveResult(result);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(result);
    }
    public static HashMap<String, String> handleFile(){
        HashMap<String, String> result = new HashMap<>();
        File file = new File("1.txt");
        try {
            Stream<String> lines = Files.lines(file.toPath());
            lines.forEach(line -> {
                String[] res = line.split("=");
                result.put(res[0], res[1]);
            });
            lines.close();
        } catch (IOException e ){
            System.out.println("Не удалось считать файл.");
        }

        return result;
    }
    public static void saveResult(HashMap<String, String> map) throws NumberFormatException, FileNotFoundException {
        for (String key: map.keySet()) {
            if(map.get(key).equals("?")){
                Integer size = key.length();
                map.replace(key, size.toString());
            }
        }
        for (String value : map.values()) {
            Integer.parseInt(value);
        }
        PrintWriter writer = new PrintWriter(new File("File.txt"));
        for (String key: map.keySet()) {
            String line = key + "=" + map.get(key);
            writer.println(line);
        }
        writer.close();
    }
}