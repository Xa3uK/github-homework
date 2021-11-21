package lesson17;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

public class Reader {

    public TreeMap<Customer, Product> fileToMap() {
        String path = "lesson17/input";
        String line = null;
        BufferedReader br = bufferedReader(path);
        TreeMap<Customer, Product> map = new TreeMap<>();

        while ((line = reader(br)) != null) {
            String[] temp = line.split(" ");
            String customerName = temp[0];
            String productName = temp[1];
            Integer productCount = Integer.parseInt(temp[2]);

            Customer customer = new Customer(customerName);
            Product product = new Product();
            product.addProduct(productName, productCount);

            if (!map.containsKey(customer)) {
                map.put(customer, product);
            } else {
                if (map.get(customer).getProduct().containsKey(productName)) {
                    int oldCount = map.get(customer).getProduct().get(productName);
                    map.get(customer).addProduct(productName, productCount + oldCount);
                } else {
                    map.get(customer).addProduct(productName, productCount);
                }
            }
        }
        return map;
    }

    public static BufferedReader bufferedReader(String path) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            System.out.println("File by this Path not found");
        }
        return br;
    }

    public static String reader(BufferedReader br) {
        String str = null;
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.exit(1);
        }
        return str;
    }
}
