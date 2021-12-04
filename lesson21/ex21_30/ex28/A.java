package lesson21.ex21_30.ex28;

class A {
    int i = 1;

    class B {
        int i = 2;

        class C extends A {
            void methodC() {
                System.out.println(i);
            }
        }
    }
}

class MainClass {
    public static void main(String[] args) {
        new A().new B().new C().methodC();
    }
}
//28) What will be the output of the following program?

//1, от кого наследуется ту переменную и видит