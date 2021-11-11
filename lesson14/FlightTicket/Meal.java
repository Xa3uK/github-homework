package lesson14.FlightTicket;

public class Meal {
    private final Menu menu;
    private final Drinks drinks;

    public Meal(Menu menu, Drinks drinks) {
        this.menu = menu;
        this.drinks = drinks;
    }

    public Menu getMenu() {
        return menu;
    }

    public Drinks getDrinks() {
        return drinks;
    }

    public int getPrice(){
        return menu.getPrice() + drinks.getPrice();
    }

    @Override
    public String toString() {
        return "Meal{" +
                "menu=" + menu +
                "drinks=" + drinks +
                ", total price=" + getPrice() + "$" + "},";
    }
}
