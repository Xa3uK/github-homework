package lesson29;

@Start(priority = 1, method = "initialize")
public class Foo2 {
    public void run() {
        throw new IllegalStateException("This method should not be called");
    }

    public void initialize() {
        System.out.println("Class Foo2 initialized! by initialize");
    }
}
