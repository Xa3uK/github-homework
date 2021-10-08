package lesson2;

import java.util.Arrays;

public class ChallengeTwo {
    public static void main(String[] args) {
        int[] array = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        int a = 2;
        int counter = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == a) {
                counter++;
            }
        }

        int[] arrayTwo = new int[array.length - counter];
        System.out.println(arrayTwo.length);
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != a) {
                arrayTwo[index] = array[i];
                index++;
            }
        }
        System.out.println(Arrays.toString(arrayTwo));
    }
}
