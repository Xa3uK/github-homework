package lesson5;

public class FindSolutionRecursion {
    public static void main(String[] args) {
        String notFind = null;
        int startNumber = 1;
        String startString = "1";
        try {
            int userNumber = Integer.parseInt(args[0]);
            findSolutionRecursion(userNumber, startNumber, startString);
        } catch (NumberFormatException e){
            System.out.println("Argument must be a number");
            System.exit(0);
        }
        System.out.println(notFind);
    }
    
    public static void findSolutionRecursion(int number, int start, String str) {
        if (start + 5 == number) {
            System.out.println("(" + str + " + 5)");
            System.exit(0);
        }
        if (start < number) {
            findSolutionRecursion(number, start + 5, "(" + str + " + 5)");
        }
        if (start * 3 == number) {
            System.out.println("(" + str + " * 3)");
            System.exit(0);
        }
        if (start < number) {
            findSolutionRecursion(number, start * 3, "(" + str + " * 3)");
        }
    }
}