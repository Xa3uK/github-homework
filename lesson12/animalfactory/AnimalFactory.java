package lesson12.animalfactory;

import java.util.ArrayList;
import java.util.List;

public class AnimalFactory {

    private static final List<String> animalsKeyList = animalsKeyList();

    public static Animal getAnimalByKey(String key) {
        Animal animal = null;
        if (!animalsKeyList.contains(key)) {
            return null;
        } else {
            switch (key) {
                case "da":
                    animal = new Dog("Арамис");
                    break;
                case "db":
                    animal = new Dog("Блек");
                    break;
                case "dc":
                    animal = new Dog("Спайки");
                    break;
                case "ca":
                    animal = new Cat("Амадей");
                    break;
                case "cb":
                    animal = new Cat("Баксик");
                    break;
                case "cc":
                    animal = new Cat("Снежок");
                    break;
            }
        }
        return animal;
    }

    private static List<String> animalsKeyList() {
        List<String> animals = new ArrayList();
        animals.add("da");
        animals.add("db");
        animals.add("dc");
        animals.add("ca");
        animals.add("cb");
        animals.add("cd");
        return animals;
    }
}
