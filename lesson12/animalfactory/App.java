package lesson12.animalfactory;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        appRun();
    }

    public static void appRun() {
        System.out.println("Какое животное создать?");
        String userAnswer = userAsk();
        while (AnimalFactory.getAnimalByKey(userAnswer) == null) {
            System.out.println("Не могу создать Animal. Try again:");
            userAnswer = userAsk();
        }
        System.out.println(AnimalFactory.getAnimalByKey(userAnswer).getName());
    }

    public static String userAsk() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}
