package lesson21.ex41_49.ex45;

class A {
    interface I {
        int i = 4444;

        void show(int i);
    }

    class B implements I {
        public void show(int i) {
            System.out.println(this.i);
        }
    }

    void methodA(int i) {
        new B().show(i);
    }
}

class MainClass {
    public static void main(String[] args) {
        new A().methodA(1111);
    }
}
//45) What will be the output of the following program?

//будет 4444, потому что this.i оно тянет с интерфейса.
//        Если поменять на просто i то будет саутить то что передаем в метод в мейне