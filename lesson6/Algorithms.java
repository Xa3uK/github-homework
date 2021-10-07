package lesson6;

public class Algorithms {
    public static void main(String[] args) {
        int[] arraySortedLittle = createSortedArray(1000);
        int[] arraySortedBig = createSortedArray(100000);
        int[] arrayRandomLittle = createRandomArray(1000);
        int[] arrayRandomBig = createRandomArray(100000);
        timerSimpleFind(arraySortedLittle);
        timerBinaryFind(arraySortedLittle);
        timerSimpleFind(arraySortedBig);
        timerBinaryFind(arraySortedBig);
        timerSelectionSort(arrayRandomLittle);
        timerQuickSort(arrayRandomLittle);
        timerSelectionSort(arrayRandomBig);
        timerQuickSort(arrayRandomBig);
    }

    public static int[] quickSort(int[] array, int left, int right) {
        if (array.length < 2) {
            return array;
        }
        if (left >= right) {
            return array;
        } else {
            int oporniy = array[(left + right) / 2];
            int i = left;
            int j = right;
            while (array[i] < oporniy) {
                i++;
            }
            while (array[j] > oporniy) {
                j--;
            }
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
            if (left < j) {
                quickSort(array, left, j);
            }
            if (right > i) {
                quickSort(array, i, right);
            }
        }
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

    public static void timerSimpleFind(int[] array){
        int findNumber = array.length-1;
        long start = System.nanoTime();
        simpleFind(array, findNumber);
        long result = System.nanoTime() - start;
        announcer(result, array, "SimpleFind");
    }

    public static void timerBinaryFind(int[] array){
        int findNumber = array.length-1;
        long start = System.nanoTime();
        binaryFind(array, findNumber);
        long result = System.nanoTime() - start;
        announcer(result, array, "BinaryFind");
    }
    public static void timerSelectionSort(int[] array){
        long start = System.nanoTime();
        selectionSort(array);
        long result = System.nanoTime() - start;
        announcer(result, array, "SelectionSort");
    }

    public static void timerQuickSort(int[] array){
        int left = 0;
        int right = array.length-1;
        long start = System.nanoTime();
        quickSort(array, left, right);
        long result = System.nanoTime() - start;
        announcer(result, array, "QuickSort");
    }

    public static void announcer(long result, int[] array, String name) {
        System.out.println("\n" + name + " method speed: " + result + " ns");
        System.out.println("Input array length: " + array.length);
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

