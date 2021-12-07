package lesson22;

public class Main {
    public static void main(String[] args) {
                Integer[] arr = new Integer[40];
//        String[] arr = new String[40];
        for (int i = 0; i < arr.length; i++) {
//            arr[i] = "V_" + i;
            arr[i] = i;
        }
        DataStructure<Integer> ds = new DataStructure<>(arr);
//        DataStructure<String> ds = new DataStructure<>(arr);
        ds.printEven();
    }
}
