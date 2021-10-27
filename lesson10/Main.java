package lesson10;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] userAnswer = userAnswer();
        Fraction num1 = new Fraction(userAnswer[0]);
        Fraction num2 = new Fraction(userAnswer[2]);
        switch (userAnswer[1]) {
            case "plus" -> System.out.println(Arrays.toString(Fraction.addition(num1, num2)));
            case "minus" -> System.out.println(Arrays.toString(Fraction.subtraction(num1, num2)));
            default -> System.out.println("Unknown operation");
        }
    }

    public static String[] userAnswer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter: 'number operation number'    (operation: plus/minus), (number format: *,*)");
        String answer = scanner.nextLine();
        String[] userAnswer = answer.split(" ");
        if (userAnswer.length != 3) {
            throw new IllegalArgumentException("You need enter three arguments in 'number operation number' format");
        }
        return userAnswer;
    }
}