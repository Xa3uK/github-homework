package lesson21.ex11_20.ex16;

class A {
    void methodA1(int i) {
        System.out.println(i++ + i);
    }

    void methodA2(int i) {
        System.out.println(--i - i--);
    }
}

class B {
    A a = new A() {
        void methodA1(int i) {
            System.out.println(++i + i++);
        }

        void methodA2(int i) {
            System.out.println(i-- - i);
        }
    };
}

class MainClass {
    public static void main(String[] args) {
        A a = new A();

        a.methodA1(10);

        a.methodA2(10);

        B b = new B();

        b.a.methodA1(10);

        b.a.methodA2(10);
    }
}

//16) What will be the output of the below program?

//21   10 + 11
//0   9-9
//
//22   11 + 11
//1  10 - 9
