package lesson1;

public class Summator {
    public static void main(String[] args) {

        if (isNumber(args[0]) && isNumber(args[1])) {

            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);
            int result = a + b;
            System.out.println(" > Result: " + args[0] + " + " + args[1] + " = " + result);
        }
        else throw new IllegalArgumentException("Argument must be a number!!! Try again");
    }

    public static boolean isNumber(String arg) {
        try {
            Integer.parseInt(arg);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
