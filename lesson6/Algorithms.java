package lesson6;

public class Algorithms {
    public static void main(String[] args) {
        timerFindMethods(1000);
        timerFindMethods(100000);
        timerSortMethods(1000);
        timerSortMethods(100000);
    }

    public static int[] quickSort(int[] array, int left, int right) {
        if (array.length < 2) {
            return array;
        }
        if (left >= right) {
            return array;
        }
        int i = left;
        int j = right;
        int oporniy = array[(left + right) / 2];
        while (i < j) {
            while (array[i] < oporniy) {
                i++;
            }
            while (array[j] > oporniy) {
                j--;
            }
            if (i <= j) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                i++;
                j--;
            }
        }
        quickSort(array, left, j);
        quickSort(array, i, right);
        return array;
    }

    public static int[] selectionSort(int[] array) {
        if (array.length < 2) {
            return array;
        } else {
            for (int i = 0; i < array.length; i++) {
                int minValue = array[i];
                int index = i;
                for (int j = i + 1; j < array.length; j++) {
                    if (array[j] < minValue) {
                        index = j;
                        minValue = array[j];
                    }
                }
                array[index] = array[i];
                array[i] = minValue;
            }
        }
        return array;
    }

    public static int simpleFind(int[] array, int findNumber) {
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == findNumber) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static int binaryFind(int[] array, int findNumber) {
        int start = 0;
        int end = array.length - 1;
        int middle = array.length / 2;
        while (array[middle] != findNumber) {
            if (array[middle] == findNumber) {
                return middle;
            }
            if (array[middle] > findNumber) {
                end = middle;
                middle = (start + middle) / 2;
            } else {
                start = middle;
                middle = (middle + end) / 2 + 1;
            }
        }
        return middle;
    }

    public static void timerFindMethods(int arrayLength) {
        int[] arrayOne = createSortedArray(arrayLength);
        long startSimple = System.nanoTime();
        simpleFind(arrayOne, arrayOne.length - 1);
        long resultSimple = System.nanoTime() - startSimple;
        announcer(resultSimple, arrayLength, "SimpleFind");

        int[] arrayTwo = createSortedArray(arrayLength);
        long startBinary = System.nanoTime();
        binaryFind(arrayTwo, arrayTwo.length - 1);
        long resultBinary = System.nanoTime() - startBinary;
        announcer(resultBinary, arrayLength, "BinaryFind");
    }

    public static void timerSortMethods(int arrayLength) {
        int[] arrayOne = createRandomArray(arrayLength);
        long startSelection = System.nanoTime();
        selectionSort(arrayOne);
        long resultSelection = System.nanoTime() - startSelection;
        announcer(resultSelection, arrayLength, "SelectionSort");

        int[] arrayTwo = createRandomArray(arrayLength);
        long startQuick = System.nanoTime();
        quickSort(arrayTwo, 0, arrayTwo.length - 1);
        long resultQuick = System.nanoTime() - startQuick;
        announcer(resultQuick, arrayLength, "QuickSort");
    }

    public static void announcer(long result, int arrayLength, String name) {
        System.out.println("\n" + name + " method speed: " + result + " ns");
        System.out.println("Input array length: " + arrayLength);
    }

    public static int[] createSortedArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        return array;
    }

    public static int[] createRandomArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * size);
        }
        return array;
    }
}

