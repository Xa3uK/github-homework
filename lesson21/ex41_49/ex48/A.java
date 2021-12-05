package lesson21.ex41_49.ex48;

class A {
    void methodA() {
        System.out.println("AAAA");
    }

    class B extends C.D {
        @Override
        void methodD() {
            System.out.println("BBBB");
        }
    }
}

class C extends A {
    static class D {
        void methodD() {
            System.out.println("DDDD");
        }
    }

    @Override
    void methodA() {
        System.out.println("CCCC");
    }
}

class MainClass {
    public static void main(String[] args) {
        A a = new C();

        a.methodA();

        C.D d = new A().new B();

        d.methodD();
    }
}

//48) What will be the output of the following program?

//      cccc
//      bbbb