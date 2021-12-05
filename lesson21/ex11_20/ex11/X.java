package lesson21.ex11_20.ex11;

class X {
    {
        System.out.println(1);
    }

    static {
        System.out.println(2);
    }

    public X() {
        new Y();
    }

    static class Y {
        {
            System.out.println(3);
        }

        static {
            System.out.println(4);
        }
    }
}

class MainClass {
    public static void main(String[] args) {
        X x = new X();

        X.Y y = new X.Y();
    }
}
//11) What will be the output of the following program?

//2 - сначало статика переменные
//1 - потом обычные переменные
//4 - потом конструктор = здесь статик переменная вложенного класа
//3 - обычная переменная вложенного класса
//3 - снова обычная переменная вложенного класса, так как статика прогружалась до этого

//если еще эти классы посоздавать то будет выстреливать только 1 и 3 обычные переменные
