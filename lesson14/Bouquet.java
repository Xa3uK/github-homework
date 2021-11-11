package lesson14;

import lesson14.flowers.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Bouquet {
    public static void main(String[] args) {
        List<Flower> bouquet = bouquetCreator(userAnswer());
        bouquetPrinter(bouquet);
    }

    public static Flower getRandomFlower() {
        Random r = new Random();
        int random = r.nextInt(4) + 1;
        switch (random) {
            case 1:
                return new Roza();
            case 2:
                return new Gvozdika();
            case 3:
                return new Fialka();
            case 4:
                return new Tulpan();
        }
        return null;
    }

    public static List<Flower> bouquetCreator(int count){
        List<Flower> bouquet = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            bouquet.add(getRandomFlower());
        }
        return bouquet;
    }

    public static void bouquetPrinter(List<Flower> bouquet){
        int counter = 1;
        System.out.println("Сформирован букет из " + bouquet.size() + " цветов");
        for (Flower f : bouquet) {
            System.out.println("#" + counter + " " + f.toString());
            counter++;
        }
        System.out.println("Стоимость букета " + bouquetPrice(bouquet));
    }

    public static int bouquetPrice(List<Flower> bouquet){
        int sum = 0;
        for (Flower f: bouquet) {
            sum += f.getPrice();
        }
        return sum;
    }

    public static int userAnswer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите желаемое кол-во цветов в букете:");
        return scanner.nextInt();
    }
}
