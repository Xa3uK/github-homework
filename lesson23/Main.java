package lesson23;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String allLines = Reader.readStr();
        Set<String> words = Sorter.stringsToSet(allLines);
        souter(words);
    }

    static void souter(Set<String> words) {
        Iterator it = words.iterator();
        String temp = null;
        while (it.hasNext()) {
            String word = (String) it.next();
            if (temp == null || temp.equals(String.valueOf(word.charAt(0)))) {
                temp = String.valueOf(word.charAt(0));
                System.out.print(word + " ");
            } else {
                temp = String.valueOf(word.charAt(0));
                System.out.print("\n" + word + " ");
            }
        }
    }
}
