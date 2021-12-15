package lesson23;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Sorter {
    public static Set<String> stringsToSet(String str) {
        String[] words = str.split(" ");
        Set<String> uniqueWords = new TreeSet(Arrays.asList(words));
        uniqueWords.remove("");
        return uniqueWords;
    }
}
