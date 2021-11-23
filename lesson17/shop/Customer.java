package lesson17.shop;

import java.util.Objects;

public class Customer implements Comparable<Customer> {
    private final String name;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return name.equals(customer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Customer o) {
        return this.getName().compareTo(o.getName());
    }

    @Override
    public String toString() {
        return name;
    }
}
