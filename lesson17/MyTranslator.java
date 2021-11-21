package lesson17;

import java.util.HashMap;
import java.util.List;

public class MyTranslator {
    private HashMap<String, String> wordList;

    public MyTranslator() {
        this.wordList = new HashMap<>();
    }

    public void addWords(String eng, String rus) {
        wordList.put(eng, rus);
    }

    public String translate(String phrase) {
        String translate = phrase.toLowerCase();
        StringBuilder stringBuilder = new StringBuilder();
        List<String> words = List.of(translate.split(" "));
        for (String s : words) {
            if (wordList.containsKey(s)) {
                stringBuilder.append(wordList.get(s)).append(" ");
            }
            translate = String.valueOf(stringBuilder);
        }
        return translate;
    }
}
