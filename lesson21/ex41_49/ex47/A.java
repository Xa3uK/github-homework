package lesson21.ex41_49.ex47;

class A {
    static {
        System.out.println(1);

        class B {
            {
                System.out.println(2);
            }
        }
    }

    {
        System.out.println(3);

        class B {
            {
                System.out.println(4);
            }
        }
    }
}

class MainClass {
    public static void main(String[] args) {
        new A();
    }
}

//47) What will be the output of the following program?

//1
//3
//сначало статика потом не статика