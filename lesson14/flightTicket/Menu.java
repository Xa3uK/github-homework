package lesson14.flightTicket;

public enum Menu {
    SOUP(0, "Суп", 300),
    VEGETABLES(1, "Овощи", 30),
    MEAT(2, "Мясо", 200),
    DESSERT(3, "Десерт", 100);

    private final int var;
    private final String description;
    private final int price;

    Menu(int var, String description, int price) {
        this.var = var;
        this.description = description;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public int getVar() {
        return var;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "var=" + var +
                ", description='" + description + '\'' +
                ", price=" + price + '$' +
                "},\n";
    }
}
