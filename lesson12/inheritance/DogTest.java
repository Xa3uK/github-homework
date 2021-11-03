package lesson12.inheritance;

public class DogTest {
    public static void main(String[] args) {
        Dog labr = new Labrador("Buch", "Brown");
        System.out.println(labr.getName() + " says " + labr.speak());
        Dog york = new Yorkshire("Didi");
        System.out.println(york.getName() + " says " + york.speak());
        System.out.println("Average weight of all dogs: " + (labr.avgBreedWeight() + york.avgBreedWeight()));
    }
}
