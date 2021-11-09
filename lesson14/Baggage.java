package lesson14;

public class Baggage {
    private final int amount;
    private final int customsFee;

    public Baggage(int amount, int customsFee) {
        this.amount = amount;
        this.customsFee = customsFee;
    }

    public int getFee() {
        return customsFee * amount;
    }

    @Override
    public String toString() {
        return "Baggage{" +
                " amount=" + amount +
                ", fee=" + getFee() + " $ " +
                '}';
    }
}
