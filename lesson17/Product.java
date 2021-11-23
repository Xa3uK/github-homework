package lesson17;

import java.util.TreeMap;

public class Product {
    private TreeMap<String, Integer> productDescription;

    public Product() {
        this.productDescription = new TreeMap<>();
    }

    public void addProduct(String name, Integer count) {
        productDescription.put(name, count);
    }

    public TreeMap<String, Integer> getProduct() {
        return productDescription;
    }
}
