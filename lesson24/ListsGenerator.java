package lesson24;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ListsGenerator {




    static List<Product> createProducts(){
        Product prod1 = new Product(1L, "Mathematics", "Book", 112.30);
        Product prod2 = new Product(2L, "Chemistry", "Book", 144.30);
        Product prod3 = new Product(3L, "English words", "Book", 55.30);
        Product prod4 = new Product(4L, "Japan words", "Book", 33.30);
        Product prod5 = new Product(5L, "Hats", "Children", 123.20);
        Product prod6 = new Product(6L, "Boots", "Children", 234.20);
        Product prod7 = new Product(7L, "Huggies", "Children", 44.20);
        Product prod8 = new Product(8L, "Pampers", "Children", 144.35);
        Product prod9 = new Product(9L, "Car", "Toys", 78.30);
        Product prod10 = new Product(10L, "Gun", "Toys", 44.30);
        Product prod11 = new Product(11L, "Barbie", "Toys", 88.30);
        Product prod12 = new Product(12L, "Ken", "Toys", 127.20);

        List<Product>  allProducts = new ArrayList<>();
        allProducts.add(prod1);
        allProducts.add(prod2);
        allProducts.add(prod3);
        allProducts.add(prod4);
        allProducts.add(prod5);
        allProducts.add(prod6);
        allProducts.add(prod7);
        allProducts.add(prod8);
        allProducts.add(prod9);
        allProducts.add(prod10);
        allProducts.add(prod11);
        allProducts.add(prod12);
        return allProducts;
    }

    static List<Order> allOrders(){
        Customer customer1 = new Customer(1L, "Ivan", 1);
        Customer customer2 = new Customer(2L, "Petro", 2);
        Customer customer3 = new Customer(3L, "Mishanya", 3);
        Customer customer4 = new Customer(3L, "Sanya", 3);
        Customer customer5 = new Customer(3L, "Grisha", 2);
        Customer customer6 = new Customer(3L, "Tolya", 1);

        Product prod1 = new Product(1L, "Mathematics", "Book", 112.30);
        Product prod2 = new Product(2L, "Chemistry", "Book", 144.30);
        Product prod3 = new Product(3L, "English words", "Book", 55.30);
        Product prod4 = new Product(4L, "Japan words", "Book", 33.30);
        Product prod5 = new Product(5L, "Hats", "Children", 123.20);
        Product prod6 = new Product(6L, "Boots", "Children", 234.20);
        Product prod7 = new Product(7L, "Huggies", "Children", 44.20);
        Product prod8 = new Product(8L, "Pampers", "Children", 144.35);
        Product prod9 = new Product(9L, "Car", "Toys", 78.30);
        Product prod10 = new Product(10L, "Gun", "Toys", 44.30);
        Product prod11 = new Product(11L, "Barbie", "Toys", 88.30);
        Product prod12 = new Product(12L, "Ken", "Toys", 127.20);

        List<Product> products = new ArrayList<>();
        products.add(prod1);
        products.add(prod3);
        products.add(prod7);
        products.add(prod9);
        products.add(prod10);
        products.add(prod11);

        List<Product> products1 = new ArrayList<>();
        products1.add(prod2);
        products1.add(prod4);
        products1.add(prod7);
        products1.add(prod8);
        products1.add(prod11);

        List<Product> products2 = new ArrayList<>();
        products2.add(prod2);
        products2.add(prod3);
        products2.add(prod1);
        products2.add(prod7);
        products2.add(prod12);

        List<Product> products3 = new ArrayList<>();
        products3.add(prod1);
        products3.add(prod4);

        List<Product> products4 = new ArrayList<>();
        products4.add(prod7);
        products4.add(prod10);

        List<Product> products5 = new ArrayList<>();
        products5.add(prod6);


        Order order1 = new Order(11L, "in shop", LocalDate.of(2021, 10, 15),
                LocalDate.of(2021, 12, 12), products, customer1);

        Order order2 = new Order(21L, "delivering", LocalDate.of(2021, 9, 1),
                LocalDate.of(2021, 12, 2), products1, customer2);

        Order order3 = new Order(31L, "delivered", LocalDate.of(2021, 10, 12),
                LocalDate.of(2021, 12, 10), products2, customer3);

        Order order4 = new Order(41L, "in shop", LocalDate.of(2021, 11, 15),
                LocalDate.of(2021, 12, 15), products3, customer4);

        Order order5 = new Order(51L, "delivering", LocalDate.of(2021, 11, 1),
                LocalDate.of(2021, 12, 6), products4, customer5);

        Order order6 = new Order(61L, "delivered", LocalDate.of(2021, 11, 8),
                LocalDate.of(2021, 12, 21), products5, customer6);

        List<Order> orders = new ArrayList<>();
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);
        orders.add(order4);
        orders.add(order5);
        orders.add(order6);
        return orders;
    }
}
