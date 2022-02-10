package lesson29;

@Start(priority = 80)
public class Foo3 {
    public void run() {
        System.out.println("Class Foo3 initialized! by run");;
    }

    public void initialize() {
        System.out.println("errror");
    }
}
