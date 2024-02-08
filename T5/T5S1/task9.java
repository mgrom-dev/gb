import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class task9 {
    public static void main(String[] args) {
        String fileName = "NameSurnameAge.txt";
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println("Name Surname Age");
            writer.println("Kate Smith 20");
            writer.println("Paul Green 25");
            writer.println("Mike Black 23");
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e);
        }
    }
}
