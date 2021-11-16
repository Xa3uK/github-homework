package lesson16;

import java.util.*;

public class ListIteratorExample {
    public static void main(String[] args) {
        System.out.println("Исходные массивы");
        ArrayList<String> listArray = arrayElementsAdd(10);
        LinkedList<String> listLink = linkElementsAdd(10);
        System.out.println(listArray);
        System.out.println(listLink + "\n");

        System.out.println("Перемешка один за одним");
        System.out.println(oneByOne(listArray, listLink));

        listLink = linkElementsAdd(10);
        System.out.println("\nИсходные массивы");
        System.out.println(listArray);
        System.out.println(listLink + "\n");
        System.out.println("Перемешка один через два");
        System.out.println(oneByTwo(listArray, listLink));
    }

    public static LinkedList<String> oneByTwo(ArrayList<String> arr, LinkedList<String> link) {
        ListIterator<String> listArr = arr.listIterator(arr.size());
        ListIterator<String> listLink = link.listIterator();
        while (listArr.hasPrevious()) {
            listLink.add(listArr.previous());
            if (listLink.hasNext())
                listLink.next();
            if (listLink.hasNext())
                listLink.next();
        }
        return link;
    }

    public static LinkedList<String> oneByOne(ArrayList<String> arr, LinkedList<String> link) {
        ListIterator<String> listArr = arr.listIterator(arr.size());
        ListIterator<String> listLink = link.listIterator();
        while (listArr.hasPrevious()) {
            listLink.add(listArr.previous());
            listLink.next();
        }
        return link;
    }

    public static LinkedList<String> linkElementsAdd(int size) {
        LinkedList<String> list = new LinkedList<>();
        list.add("li_0");
        while (size-- > 1) {
            int index = randomIndex(list);
            list.add(index, "li_" + index);
        }
        return list;
    }

    private static int randomIndex(LinkedList<String> list) {
        Random random = new Random();
        return random.nextInt(list.size()) + 1;
    }

    public static ArrayList<String> arrayElementsAdd(int size) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add("ar_" + i);
        }
        return list;
    }
}
