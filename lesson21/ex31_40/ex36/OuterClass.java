package lesson21.ex31_40.ex36;

class OuterClass {
    static class InnerClassOne {
        int i = 1221;

        int getI() {
            return i = i++ - ++i;
        }
    }

    static class InnerClassTwo extends InnerClassOne {
        @Override
        int getI() {
            return i = i-- + --i;
        }
    }
}

class MainClass {
    public static void main(String[] args) {
        OuterClass.InnerClassOne one = new OuterClass.InnerClassOne();

        System.out.println(one.getI());

        one = new OuterClass.InnerClassTwo();

        System.out.println(one.getI());
    }
}
//36) What will be the output of the following program?

//-2
//2240

//методы гет не меняют переменную, поэтому во втором методе заново отталкиваемся от 1221