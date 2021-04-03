package pl.java.zadrekrut;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Reader {

    public static List<String> readFile() {
        try {
            return Files.readAllLines(Path.of("file.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
