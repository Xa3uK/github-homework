package lesson23;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String allLines = Reader.readFile();
        Set<String> words = Util.stringsToSet(allLines);
        Util.printer(words);
    }
}
