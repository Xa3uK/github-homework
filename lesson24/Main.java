package lesson24;

import javax.print.attribute.standard.OrientationRequested;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Product> allProducts = ListsGenerator.createProducts();
        List<Order> allOrders = ListsGenerator.allOrders();

//   Упражнение 1. Получите список товаров (Product), относящихся к категории "Книги" с ценой > 100.
        System.out.println("All books with price bigger then 100:");

        allProducts.stream()
                .filter(x -> x.getCategory().equals("Book") && x.getPrice() > 100)
                .forEach(System.out::println);

        System.out.println("--------------------------------\n");

//    Упражнение 2. Получите список заказов с товарами (Order), относящимися к категории "Детские".
        System.out.println("Orders with children products:");

        allOrders.stream()
                .filter(x -> x.getProducts()
                        .stream().anyMatch(p -> p.getCategory().equals("Children")))
                .forEach(System.out::println);

        System.out.println("--------------------------------\n");

//    Упражнение 3. Получите список товаров (Product) с категорией "Игрушки" и скидкой 10% для каждого товара.
        System.out.println("List of toys with 10% discount:");

        allProducts.stream()
                .filter(x -> x.getCategory().equals("Toys"))
                .peek(x -> x.setPrice(x.getPrice() - (x.getPrice()) / 100 * 10))
                .forEach(System.out::println);

        System.out.println("--------------------------------\n");

//    Упражнение 4. Получите список товаров (Product), заказанных клиентом уровня 2 (поле tier класса Customer) в период с 01.10.2021. по 01.11.2021.
        System.out.println("Products of customer with tier '2' and ordered in 2021.10.01 - 2021.11.01:");
        LocalDate startDate = LocalDate.of(2021, 10, 1);
        LocalDate endDate = LocalDate.of(2021, 11, 1);

        allOrders.stream()
                .filter(o -> o.getCustomer().getTier() == 2 && o.getOrderDate().isAfter(startDate)
                        && o.getOrderDate().isBefore(endDate))
                .map(Order::getProducts)
                .flatMap(Collection::stream)
                .distinct()
                .forEach(System.out::println);

        System.out.println("--------------------------------\n");

//        Упражнение 5. Получите самый дешевый товар (Product) категории "Книги".
        System.out.println("Most cheapest book is:");

        Product minPriceBook = allProducts.stream()
                .filter(x -> x.getCategory().equals("Book"))
                .min(Comparator.comparing(Product::getPrice))
                .orElseThrow(NoSuchElementException::new);

        System.out.println(minPriceBook);
        System.out.println("--------------------------------\n");

//        Упражнение 6. Получите 3 последних размещенных заказа (Order).
        System.out.println("Last three orders:");

        allOrders.stream()
                .sorted(Comparator.comparing(Order::getOrderDate).reversed())
                .limit(3)
                .forEach(System.out::println);

        System.out.println("--------------------------------\n");

//        Упражнение 7. Получите список заказов (Order), которые были заказаны 15.11.2021 года, выведите заказы в консоль и затем верните список продуктов, заказанных в этот день.
        System.out.println("All orders in 2021.11.15 and then all products:");

        allOrders.stream()
                .filter(x -> x.getOrderDate().equals(LocalDate.of(2021, 11, 15)))
                .forEach(System.out::println);

        List<Product> products = allOrders.stream()
                .filter(x -> x.getOrderDate().equals(LocalDate.of(2021, 11, 15)))
                .map(Order::getProducts)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        System.out.println(products);
        System.out.println("--------------------------------\n");

//        Упражнение 8. Получите Map<Order, Double> с заказами и общей суммой стоимости продуктов.
        System.out.println("Map of orders and total price sum");
        Map<Order, Double> orderTotalPricesSum =
                allOrders.stream()
                        .collect(Collectors.toMap(Function.identity(), order ->
                                order.getProducts().stream()
                                        .mapToDouble(Product::getPrice)
                                        .sum()));

        orderTotalPricesSum.entrySet().stream()
                .map(x -> x.getKey() + "\ntotal price: " + x.getValue())
                .forEach(System.out::println);
    }
}
