package lesson21.ex21_30.ex23;

public class Question23 {
    static int a = 1;

    class inner {
        void test() {
            System.out.println(Question23.a);
        }
    }
}

//23) Can we access static members of outer class inside a member inner class?

//да
