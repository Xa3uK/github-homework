package lesson5;

public class FindSolutionRecursion {
    public static void main(String[] args) {
        int startNumber = 1;
        String startString = "1";
        String result = null;
        try {
            int userNumber = Integer.parseInt(args[0]);
            System.out.println(findSolutionRecursion(userNumber, startNumber, startString, result));
        } catch (NumberFormatException e){
            System.out.println("Argument must be a number");
        }
    }

    public static String findSolutionRecursion(int userNumber, int startNumber, String startStr, String result) {
        if (startNumber * 3 == userNumber) {
            result = "(" + startStr + " * 3)";
        }
        if (startNumber < userNumber) {
            result = findSolutionRecursion(userNumber, startNumber * 3, "(" + startStr + " * 3)", result);
        }
        if (startNumber + 5 == userNumber) {
            result = "(" + startStr + " + 5)";
        }
        if (startNumber < userNumber) {
            result = findSolutionRecursion(userNumber, startNumber + 5, "(" + startStr + " + 5)", result);
        }
        return result;
    }
}

