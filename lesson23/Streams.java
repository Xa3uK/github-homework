package lesson23;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Streams {
    private final static String fileName = "lesson23/resources/text.txt";

    private static List<String> readStrings() {
        List<String> strings = null;
        try {
            strings = Files.lines(Path.of(fileName))
                    .map(x -> x.split("\\p{Punct}|«|»|—| "))
                    .map(List::of)
                    .flatMap(Collection::stream)
                    .filter(x -> x.length() > 0)
                    .map(String::toLowerCase)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strings;
    }

    private static Map<Character, List<String>> mapper(List<String> strings) {
        return strings.stream()
                .distinct()
                .collect(Collectors.groupingBy(s -> s.charAt(0)));

    }

    public static void printer() {
        Map<Character, List<String>> mapa = mapper(readStrings());
        mapa.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(s -> System.out.println(s.getValue()
                        .toString().replaceAll("\\p{Punct}", "")));
    }
}
