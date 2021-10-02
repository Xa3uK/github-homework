package lesson5;

import java.util.Arrays;

public class RecursionSimple {
    public static void main(String[] args) {
        int[] array = new int[]{6, 2, 8, 7, 1};
        System.out.println("Input array: " + Arrays.toString(array));
        System.out.println("Sum of array elements: " + sumArray(array, array.length - 1));
        System.out.println("Max element of array: " + maxArray(array, array.length - 1));
        int number = 57401;
        System.out.println("\nSum of all digits of number " + number + " is: " + sumNumber(number));
        System.out.println("Reverse number of " + number + " is: " + reverseNumber(number, 0));
    }

    public static int sumArray(int[] array, int index) {
        if (index == 0) {
            return array[0];
        } else {
            return array[index] + sumArray(array, index - 1);
        }
    }

    public static int maxArray(int[] array, int index) {
        if (index == 0) {
            return array[0];
        } else {
            return Math.max(array[index], maxArray(array, index - 1));
        }
    }

    public static int sumNumber(int number) {
        if (number < 10) {
            return number;
        } else {
            int firstDigits = number / 10;
            int lastDigit = number % 10;
            return lastDigit + (sumNumber(firstDigits));
        }
    }

    public static int reverseNumber(int number, int result) {
        if (number == 0) {
            return result;
        } else {
            return reverseNumber(number / 10, result * 10 + number % 10);
        }
    }
}

