package lesson21.ex1_10.ex2;

class X {
    static int x = 3131;

    static class Y {
        static int y = x++;

        static class Z {
            static int z = y++;
        }
    }
}

class MainClass {
    public static void main(String[] args) {
        System.out.println(X.x);

        System.out.println(X.Y.y);

        System.out.println(X.Y.Z.z);
    }
}
//    What will be the output of the following program?

//три раза по 3131. Переменные инициализируются по очереди, в момент вызова их в println насколько я понял,
// поэтому результат инкремента остается на потом.

