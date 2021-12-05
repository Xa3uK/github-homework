package lesson21.ex21_30.ex30;

class X {
    static {
        class Y {
            {
                System.out.println(1);
            }
        }
    }

    {
        class Y {
            {
                System.out.println(2);
            }
        }
    }
}

class MainClass {
    public static void main(String[] args) {
        new X();
    }
}
//30) What will be the output of the following program?

//ничего в консоль не выведет