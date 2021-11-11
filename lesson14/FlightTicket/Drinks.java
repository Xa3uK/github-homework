package lesson14.FlightTicket;

public enum Drinks {
    YES(0, "C напитками", 50),
    NO(1, "без", 0);


    private final int var;
    private final String description;
    private final int price;

    Drinks(int var, String description, int price) {
        this.var = var;
        this.description = description;
        this.price = price;
    }

    public int getVar() {
        return var;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Drinks{" +
                "var=" + var +
                ", description='" + description + '\'' +
                ", price=" + price + "$" +
                '}';
    }
}
