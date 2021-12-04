package lesson21.ex11_20.ex18;

class One {
    {
        System.out.println("ONE");
    }

    class Two {
        {
            System.out.println("TWO");
        }
    }

    static {
        System.out.println("THREE");
    }

    static class Three {
        {
            System.out.println("FOUR");
        }

        static {
            System.out.println("FIVE");
        }
    }
}

class MainClass {
    public static void main(String[] args) {
        One one = new One();
        One.Two two = one.new Two();
        One.Three three = new One.Three();
    }
}
//18) Is the below program written correctly? If yes, what will be the output?

//            Three - статика класса 1
//            one - нон статика класса 1
//            two - нон статика класса 2
//            five - статика класса 3
//                    four - нон статика класса 3
