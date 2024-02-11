import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

public class Home extends Ex004_bFile {
    static Logger LOGGER = Logger.getLogger(Home.class.getName());

    static void loadFile(String path) {
        try {
            Ex004_bFile.loadFile(path);
        } catch (IOException e) {
            LOGGER.warning(e.getMessage());
        }
    }

    static void saveFile(String path) {
        try {
            Ex004_bFile.saveFile(path);
        } catch (IOException e) {
            LOGGER.warning(e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.setProperty("file.encoding", "UTF-8");
        try {
            LOGGER.setLevel(Level.INFO);
            FileHandler fh = new FileHandler("log.xml");
            XMLFormatter xml = new XMLFormatter();
            fh.setFormatter(xml);
        } catch (Exception e) {
            ConsoleHandler ch = new ConsoleHandler();
            LOGGER.addHandler(ch);
            LOGGER.warning("Ошибка! Файл логирования не доступен");
            e.printStackTrace();
        }
        loadFile("test.bin");
        System.out.println(data.toString());
    }
}
