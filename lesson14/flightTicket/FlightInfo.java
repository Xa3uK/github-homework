package lesson14.flightTicket;

public class FlightInfo {
    private final int flightNumber;
    private final String departure;
    private final String destination;
    private final double time;
    private final int cost;

    public FlightInfo(int flightNumber, String departure, String destination, double time, int cost) {
        this.flightNumber = flightNumber;
        this.departure = departure;
        this.destination = destination;
        this.time = time;
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Flightinfo{" +
                "flightNumber=" + flightNumber +
                ", departure='" + departure + '\'' +
                ", \ndestination='" + destination + '\'' +
                ", time=" + time + "}";
    }
}
