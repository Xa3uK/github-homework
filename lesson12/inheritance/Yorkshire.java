package lesson12.inheritance;

public class Yorkshire extends Dog {
    private static final int breedWeight = 1;

    public Yorkshire(String name) {
        super(name);
    }

    @Override
    public String speak() {
        return "woof";
    }

    @Override
    public int avgBreedWeight() {
        return breedWeight;
    }
}
