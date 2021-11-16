package lesson16;

public class Main {
    public static void main(String[] args) {
        NumberGenerator num = new NumberGenerator(10, -5, 7);
        System.out.println(num.generateList());
        System.out.println(num.generateSet());
    }
}
