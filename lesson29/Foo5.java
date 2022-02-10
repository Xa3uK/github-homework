package lesson29;

@Start(priority = 77, method = "initialize")
public class Foo5 {
    public void run() {
        throw new IllegalStateException("This method should not be called");
    }

    public void initialize() {
        System.out.println("Class Foo5 initialized! by initialize");
    }
}
