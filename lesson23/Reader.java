package lesson23;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Reader {
    private final static String fileName = "lesson23/resources/text.txt";

    public static String readFile() {
        String str = null;
        try (Stream<String> lineStream = Files.lines(Path.of(fileName))) {
            str = lineStream
                    .map(String::toLowerCase)
                    .reduce("", (string1, string2) -> string1.concat(string2 + " "))
                    .replaceAll("\\p{Punct}|«|»|—", "");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return str;
    }
}
