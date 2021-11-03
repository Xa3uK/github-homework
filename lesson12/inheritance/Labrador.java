package lesson12.inheritance;

public class Labrador extends Dog {
    private final String color;
    private static final int breedWeight = 75;

    public Labrador(String name, String color) {
        super(name);
        this.color = color;
    }

    @Override
    public String speak() {
        return "WOOF";
    }

    @Override
    public int avgBreedWeight() {
        return breedWeight;
    }
}
