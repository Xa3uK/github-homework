package lesson14;

public class VipTicket extends Ticket {
    private final Meal meal;
    private final Baggage baggage;

    public VipTicket(int sitNumber, FlightInfo flightinfo, Passenger passenger, Meal meal, Baggage baggage) {
        super(sitNumber, flightinfo, passenger);
        this.meal = meal;
        this.baggage=baggage;
    }

    @Override
    public int getCost() {
        return meal.getPrice() + baggage.getFee() + super.getCost();
    }

    @Override
    public String toString() {
        return "VipTicket{" + "sitNUmber= " + getSitNumber() +
                ", meal=" + meal + "\n" +
                "baggage=" + baggage +
                ", ticket price=" + getCost() + " $ }";
    }
}
