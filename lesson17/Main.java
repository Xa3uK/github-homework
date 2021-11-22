package lesson17;

import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Reader reader = new Reader();
        TreeMap<Customer, Product> map = reader.fileToMap();
        
        for (Map.Entry<Customer, Product> customerEntry : map.entrySet()) {
            Product product = customerEntry.getValue();
            System.out.println(customerEntry.getKey() + ":");
            for (Map.Entry<String, Integer> productEntry : product.getProduct().entrySet()) {
                System.out.println(productEntry.getKey() + " " + productEntry.getValue());
            }
            System.out.println();
        }
    }
}
