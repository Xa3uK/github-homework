package lesson21.ex31_40.ex32;

class A {
    abstract class B {
        abstract void method();
    }

    {
        new B() {

            @Override
            void method() {
                System.out.println("BBB");
            }
        }.method();
    }
}

class MainClass {
    public static void main(String[] args) {
        new A();
    }
}
//32) What will be the output of the following program?

//BBB так как прогрузится блок кода абстракного класса где создается экземпляр класса В с его методом