package lesson14.flowers;

public abstract class Flower {
    private final double price;
    private final String name;

    public Flower(double price, String name) {
        this.price = price;
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " (" + getPrice() + ")";
    }
}
