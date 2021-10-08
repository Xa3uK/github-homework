package lesson2;

import java.util.Arrays;
import java.util.Scanner;

public class ChallengeThree {
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter number of array length");
        int counter = scan.nextInt();
        System.out.println("Min value" + findMin(readIntegers(counter)));
    }

    private static int[] readIntegers(int counter) {
        int[] array = new int[counter];

        for (int i = 0; i < array.length; i++) {
            System.out.println("Enter number");
            array[i] = scan.nextInt();
        }
        System.out.println(Arrays.toString(array));
        return array;
    }

    private static int findMin(int[] array) {
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }
}
