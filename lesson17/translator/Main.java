package lesson17.translator;

public class Main {
    public static void main(String[] args) {
        MyTranslator myTranslator = new MyTranslator();
        myTranslator.addWords("dog", "собака");
        myTranslator.addWords("cat", "кот");
        myTranslator.addWords("animal", "животное");
        myTranslator.addWords("is", "это");
        myTranslator.addWords("and", "и");

        String userPhrase = "Dog and cat is ANIMAL";
        System.out.println(myTranslator.translate(userPhrase));
    }
}
