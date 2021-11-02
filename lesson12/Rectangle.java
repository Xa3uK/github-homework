package lesson12;

public class Rectangle {
    private double width;
    private double length;

    protected Rectangle(double width, double length) {
        if (width < 0) {
            width = 0;
        }
        this.width = width;
        if (length < 0) {
            length = 0;
        }
        this.length = length;
    }

    protected double getWidth() {
        return width;
    }

    protected double getLength() {
        return length;
    }

    protected double getArea() {
        return getLength() * getWidth();
    }
}
