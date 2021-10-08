package lesson2;

import java.util.Arrays;

public class Challenge {
    public static void main(String[] args) {
        int[] randomArray = new int[40];
        int min = 10;
        int max = 98;

        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = (int) (min + (Math.random()) * max);
        }
        System.out.println(Arrays.toString(randomArray));
        boolean arr = false;
        for (int i = 0; i < randomArray.length - 1; i++) {
            if (randomArray[i] > randomArray[i + 1]) {
                arr = true;
                break;
            }
        }
        if (arr) {
            System.out.println("Massiv ne rastet");
        }
    }
}

