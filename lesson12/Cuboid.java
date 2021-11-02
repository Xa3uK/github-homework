package lesson12;

public class Cuboid extends Rectangle {
    private double height;

    public Cuboid(double width, double length, double height) {
        super(width, length);
        if (height < 0) {
            height = 0;
        }
        this.height = height;
    }

    protected double getHeight() {
        return height;
    }

    protected double getVolume() {
        return getArea() * getHeight();
    }
}
