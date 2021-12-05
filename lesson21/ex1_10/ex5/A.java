package lesson21.ex1_10.ex5;

class A {
    {
        new B();
    }

    static class B {
        {
            new A().new C();
        }
    }

    class C {
        {
            System.out.println("SUCCESS");
        }
    }
}

class MainClass {
    public static void main(String[] args) {
        new A();
    }
}
//5) Does below program print “SUCCESS” on the console when you run it?

//Не напечатает, получается замкнутый круг, А вызывает В и наоборот,
//    до создания экземпляра С не доходит, стековерфлоу еррор

