package lesson23;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Util {
    public static Set<String> stringsToSet(String str) {
        String[] words = str.split(" ");
        Set<String> uniqueWords = new TreeSet(Arrays.asList(words));
        uniqueWords.remove("");
        return uniqueWords;
    }

    public static void printer(Set<String> words) {
        Iterator<String> it = words.iterator();
        String temp = it.next();
        System.out.print(temp);
        temp = String.valueOf(temp.charAt(0));
        while (it.hasNext()) {
            String word = it.next();
            if (temp.equals(String.valueOf(word.charAt(0)))) {
                temp = String.valueOf(word.charAt(0));
                System.out.print(" " + word);
            } else {
                temp = String.valueOf(word.charAt(0));
                System.out.print("\n" + word);
            }
        }
    }
}
