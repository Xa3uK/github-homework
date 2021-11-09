package lesson14;

public class Ticket {
    private final int sitNumber;
    private final FlightInfo flightinfo;
    private final Passenger passenger;

    public Ticket(int sitNumber, FlightInfo flightinfo, Passenger passenger) {
        this.sitNumber = sitNumber;
        this.flightinfo = flightinfo;
        this.passenger = passenger;
    }

    public int getSitNumber() {
        return sitNumber;
    }

    public int getCost() {
        return flightinfo.getCost();
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "sitNumber=" + sitNumber +
                ", flightinfo=" + flightinfo +
                ", passengerInfo=" + passenger +
                ", ticket price=" + getCost() + " $ " +
                '}';
    }
}
