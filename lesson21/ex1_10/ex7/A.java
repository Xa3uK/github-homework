package lesson21.ex1_10.ex7;

abstract class A {
    {
        System.out.println(1);
    }

    static {
        System.out.println(2);
    }
}

class MainClass {
    public static void main(String[] args) {
        A a = new A() {
        };
    }
}
//7) Is the below program written correctly? If yes, what will be the output?
//Написано корректно, сначала отработает статика, потом остальное : 2 1