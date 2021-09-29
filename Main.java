public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        String str = args[0];
        int number;
        boolean countArgs = args.length > 1;
        try {
            if (countArgs) {
                number = Integer.parseInt(args[1]);
                print(str, number);
            } else {
                print(str);
            }
        } catch (NumberFormatException e) {
            System.out.println("Second argument must be a number");
        }
    }

    public static void print(String string) {
        System.out.println(string);
    }

    public static void print(String string, int counter) {
        for (int i = 0; i < counter; i++) {
            System.out.println(string);
        }
    }
}