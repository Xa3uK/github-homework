package lesson1;

public class Environment {
    public static void main(String[] args) {
        if (System.getenv(args[0]) != null) {
            System.out.println(System.getenv(args[0]));
        } else
            throw new IllegalArgumentException("Wrong System environment variable. Please enter correct variable");
    }
}
