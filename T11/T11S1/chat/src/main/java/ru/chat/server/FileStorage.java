package ru.chat.server;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Абстракция базы логов
 */
public class FileStorage implements Repository {
    private final String PATH_LOG;

    FileStorage(String pathToLog) {
        PATH_LOG = pathToLog;
    }

    @Override
    public void save(String text) {
        try {
            FileWriter writer = new FileWriter(PATH_LOG, true);
            writer.write(text);
            writer.close();
        } catch (IOException e) {
            System.out.println("Error logging: " + e.getMessage());
        }
    }

    @Override
    public String read() {
        String textLog = "";
        Path pathLog = Paths.get(PATH_LOG);

        if (Files.exists(pathLog)) {
            try {
                textLog = new String(Files.readAllBytes(pathLog));
            } catch (IOException e) {
                System.out.println("Error read log file: " + e.getMessage());
            }
        }

        return textLog;
    }
    
}
