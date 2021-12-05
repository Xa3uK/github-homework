package lesson21.ex21_30.ex29;

class A {
    {
        System.out.println(1);
    }

    void method() {
        class B {
            {
                System.out.println(2);
            }

            class C {
                {
                    System.out.println(3);
                }
            }
        }
    }
}

class MainClass {
    public static void main(String[] args) {
        new A().method();
    }
}
//29) What will be the output of the following program?

//будет просто 1, там дальше идет описание классов, но не их создание, ничего более вызыватся не будет