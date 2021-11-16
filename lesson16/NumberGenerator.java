package lesson16;

import java.util.*;

public class NumberGenerator {
    private final int numberOfElements;
    private final int minNumber;
    private final int maxNumber;

    public NumberGenerator(int numberOfElements, int minNumber, int maxNumber) {
        this.numberOfElements = numberOfElements;
        this.minNumber = minNumber;
        this.maxNumber = maxNumber;
    }


    public List<Integer> generateList() {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        int counter = numberOfElements;
        while (counter > 0) {
            int number = random.nextInt(maxNumber - minNumber) + minNumber;
            list.add(number);
            counter--;
        }
        return list;
    }

    public Set<Integer> generateSet() {
        Set<Integer> set = new HashSet<>();
        if (maxNumber - minNumber < numberOfElements) {
            throw new UnsupportedOperationException();
        } else {
            List<Integer> temp = new ArrayList<>();
            for (int i = minNumber; i < maxNumber; i++) {
                temp.add(i);
            }
            int counter = numberOfElements;
            Random random = new Random();
            while (counter > 0) {
                int index = random.nextInt(temp.size());
                set.add(temp.get(index));
                temp.remove(index);
                counter--;
            }
        }
        return set;
    }
}
