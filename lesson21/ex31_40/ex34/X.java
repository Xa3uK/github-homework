package lesson21.ex31_40.ex34;

class X {
    {
        class Y {
            {
                System.out.println(1);
            }
        }

        new Y();
    }

    static {
        class Z {
            {
                System.out.println(2);
            }
        }

        new Z();
    }
}

class MainClass {
    public static void main(String[] args) {
        new X();
    }
}

//2
//1
//сначало статика потом обычные блоки