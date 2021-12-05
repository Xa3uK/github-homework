package lesson21.ex1_10.ex6;

class A {
    String s = "AAA";

    void methodA() {
        System.out.println(s);
    }

    static class B {
        void methodB() {
//            methodA();
        }
    }
}
//6) Is the below code written correctly?

//Нет, из статического вложенного класа нельзя обращаться напрямую
//        к не статическим переменым и методам класса оболчки.
//        Нужно создать их экземпляр и делать это через него