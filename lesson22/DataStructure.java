package lesson22;

import java.util.Iterator;

public class DataStructure<T> {
    private T[] array;

    public DataStructure(T[] array) {
        this.array = array;
    }

    public void printEven() {
        EvenIterator evenIterator = this.new EvenIterator();
        while (evenIterator.hasNext()) {
            System.out.print(evenIterator.next() + " ");
        }
    }

    public Iterator<T> evenIterator() {
        return this.new EvenIterator();
    }

    public Iterator<T> evenIterator(int index) {
        return this.new EvenIterator(index);
    }

    private interface ArrayIterator<T> extends Iterator<T> {

    }

    private class EvenIterator implements ArrayIterator {
        int index = 0;

        public EvenIterator() {
        }

        public EvenIterator(int index) {
            this.index = index;
        }

        @Override
        public boolean hasNext() {
            return index < array.length;
        }

        @Override
        public T next() {
            T value;
            value = array[index];
            index += 2;
            return value;
        }
    }
}

