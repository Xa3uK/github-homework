package lesson14.FlightTicket;

public class Passenger {
    private final String name;
    private final String lastname;
    private final long passport;

    public Passenger(String name, String lastname, long passport) {
        this.name = name;
        this.lastname = lastname;
        this.passport = passport;
    }

    @Override
    public String toString() {
        return "PassengerInfo{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", passport=" + passport +
                '}';
    }
}
