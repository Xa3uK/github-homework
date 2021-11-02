package lesson11.robot;

public class RobotTotal extends Robot{
    private double totalDistance = 0;

    public RobotTotal(double x, double y) {
        super(x, y);
    }

    @Override
    public void forward(int distance) {
        super.forward(distance);
        totalDistance += distance;
        System.out.println("ROBOT TOTAL");
    }

    public double getTotalDistance() {
        return totalDistance;
    }
}
