package lesson1;

public class Calculator {
    public static void main(String[] args) {
        if (!isNumber(args[0]) || !isNumber(args[2])) {
            throw new IllegalArgumentException("First and third arguments must be numbers");
        }
        int a = Integer.parseInt(args[0]);
        String operation = args[1];
        int b = Integer.parseInt(args[2]);
        int result;
        String operationChar;
        switch (operation) {
            case "plus":
                result = a + b;
                operationChar = "+";
                break;
            case "minus":
                result = a - b;
                operationChar = "-";
                break;
            case "divide":
                result = a / b;
                operationChar = "/";
                break;
            case "multiply":
                result = a * b;
                operationChar = "*";
                break;
            default:
                throw new IllegalArgumentException("Unknown operation: " + operation + ". \n Please use 'plus/minus/divide/multiply' operations! \n");
        }
        System.out.println(" > " + args[0] + " " + operationChar + " " + args[2] + " = " + result);
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
