package lesson12;

public abstract class Dog {
    private final String name;

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String speak() {
        return "Woof";
    }

    public abstract int avgBreedWeight();
}
