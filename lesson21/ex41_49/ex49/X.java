package lesson21.ex41_49.ex49;

interface X {
    void methodOne(String s);

    void methodTwo(String s);
}

abstract class Y implements X {
    String s = "ONE";

    public void methodOne(String s) {
        System.out.println(this.s + s);
    }
}

class MainClass {
    public static void main(String[] args) {
        X x = new Y() {
            {
                s = s + s;
            }

            public void methodTwo(String s) {
                System.out.println(this.s + s);
            }
        };

        x.methodOne("1");

        x.methodTwo("2");
    }
}
//49) What will be the output of the following program?

//oneone1
//oneone2
//        методы по сути одинаково работают