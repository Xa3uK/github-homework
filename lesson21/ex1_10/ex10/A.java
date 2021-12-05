package lesson21.ex1_10.ex10;

class A {
    void methodOne() {
        class B {
            void methodTwo() {
                System.out.println("Method Two");
            }
        }
    }

    void methodThree() {
//        new B().methodTwo();
    }
}
//10) Can you find out the error in the following code?

//не компилится потому что класс В локальный (одноразовый), действует только внутри methodOne,
//    в рамках жизненного цикла methodOne, к нему нельзя обратиться или создать из вне